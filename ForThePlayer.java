/*
 * ForThePlayer.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */
/**
 * This class works on initializing the players and all the work is done through constructor.
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

import java.io.*;
import java.util.*;

class ForThePlayer {

    String NameOfPlayer; //store's player's name
    String secretWord; //store's the word
    int secretWordLength; //to store word's length
    String answer = ""; //string to store user's answer
    String turn; //to store turn
    int score = 0; //to keep a track of score
    Vector<String> ForImage; //vector to store the image


    ForThePlayer(String NameOfPlayer, int secretWordIndex, String secretWordFileName, String imageWordFileName) throws FileNotFoundException {
        this.NameOfPlayer = NameOfPlayer; //initializing value
        turn = NameOfPlayer;
        ToWorkWithWords word = new ToWorkWithWords(); //creating object to access the function of class
        secretWord = word.getWord(secretWordFileName, secretWordIndex);
        secretWordLength = secretWord.length();
        System.out.println("The Word for " + NameOfPlayer + " is: " + secretWord);
        for (int index = 0; index < secretWordLength; index++) {
            answer += ".";
        }
        Picture picture = new Picture();
        picture.thisIsThePicture(imageWordFileName);
        this.ForImage = picture.ForStoringTheImage;
    }


    public static void main(String[] args) {
    }

}