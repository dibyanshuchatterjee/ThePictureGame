/*
 * ForPlayingTheGame.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class works on taking command line arguments and creating a word guess game.
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

import java.io.*; //importing io library
import java.util.*; //importing util library

public class ForPlayingTheGame {

    public static int i = 0;

    public static Scanner obj = new Scanner(System.in);

    public static void start(ForThePlayer[] players) throws FileNotFoundException {
        /*
         * this function initiates the game play.
         *
         */
        while (players[0].score != players[0].secretWordLength && players[1].score != players[1].secretWordLength) {
            System.out.print(players[i].turn + players[i].answer);
            String characterGuessed = obj.next().toLowerCase();
            //introducing conditional statements to initiate the main functionality
            if (characterGuessed.length() == 1 && players[i].secretWord.toLowerCase().contains(characterGuessed)) {
                //passing arguments to update the score
                scoreUpdate(++players[i].score, characterGuessed, players);
                System.out.println("\t\t" + players[i].NameOfPlayer +
                        " guess was correct: " + players[i].answer);
                //initiating vector arguments
                Vector<String> vec = generateImage(players[i].secretWordLength, players[i].score, players[i].ForImage);
                for (String a : vec) {
                    System.out.print(a);
                }
                players[i].secretWord = players[i].secretWord.replaceFirst(characterGuessed, "*");
                if (players[i].secretWord.length() == 0) {
                    System.out.println("This word guessed correctly was: " + players[i].secretWord);
                }

            } else { //conditional statements to check for incorrect inputs
                System.out.println("Try Again");
            }
            i = 1 - i;
        }
    }

    public static Vector<String> generateImage(int descLength, int scores, Vector<String> imageVector) {
        /*
         * this function works on generating the image returns a vector type value.
         *
         */
        Vector<String> imageTempVector = new Vector<>(imageVector);
        double percentage = (scores / (double) descLength);
        int n = (int) (imageTempVector.size() - (percentage * imageTempVector.size()));
        for (int i = 0; i < n; i++) {
            int var = randomNum(imageTempVector);
            if (imageTempVector.get(var).contains("\n"))
                imageTempVector.set(var, ".\n");
            else if (imageTempVector.get(var).contains("\t\t"))
                imageTempVector.set(var, "\t\t.");
            else
                imageTempVector.set(var, ".");
        }
        return imageTempVector;
    }

    /**
     * This method generates a random integer
     *
     * @param v Vector of Strings
     */

    public static int randomNum(Vector<String> v) {
        Random ran = new Random();
        int var = 1;
        while (v.get(var).equalsIgnoreCase(".")) {
            var = ran.nextInt(v.size());
        }
        return var;
    }


    public static void scoreUpdate(int updatedScore, String characterGuessed, ForThePlayer[] players) {
        /*
         * this function works on updating the player's score and has no return value.
         *
         */
        int indexOfChar = players[i].secretWord.toLowerCase().indexOf(characterGuessed);
        System.out.print(players[i].secretWord);
        players[i].answer = players[i].answer.substring(0, indexOfChar) + characterGuessed + players[i].answer.substring(indexOfChar + 1);
        players[i].score = updatedScore;

    }


    public static void main(String[] args) throws FileNotFoundException {
        /*
         * Main function to iterate through the .txt file containing set of words.
         *
         */

        if (args.length > 0) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the round number: ");
            int roundNumber = scan.nextInt();
            ForThePlayer[] players = new ForThePlayer[2];
            players[0] = new ForThePlayer(args[1], roundNumber, args[3], args[5]);
            players[1] = new ForThePlayer(args[7], roundNumber, args[9], args[11]);
            System.out.println(players[0].answer);
            start(players);
        } else {
            System.out.println("Incorrect argument");
            System.exit(1);
        }

    }
}