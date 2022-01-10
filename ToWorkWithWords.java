/*
 * ToWorkWithWords.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */
/**
 * This class works on getting the word using the function getWord.
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

import java.io.*; //importing io
import java.util.*; //importing util


class ToWorkWithWords {
    public String getWord(String FromPictureTXT, int FromWordFile) throws FileNotFoundException {
        /*
         * this function works on getting the word and returns a the same
         *
         */

        String currentPath = System.getProperty("user.dir") + "/"; //to store the path of the file
        File fileName = new File(currentPath + FromPictureTXT); //importing file trough path
        Scanner fetch = new Scanner(fileName); //scanner object
        List<String> words = new ArrayList<>(); //arraylist to store words
        while (fetch.hasNextLine()) {
            words.add(fetch.nextLine());
        }
        return words.get(FromWordFile - 1); //returning from the file

    }
}