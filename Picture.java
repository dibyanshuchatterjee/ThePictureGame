/*
 * Picture.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */
/**
 * This class works on storing the .txt type image input.
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

import java.io.*;
import java.util.*;

public class Picture {


    Vector<String> ForStoringTheImage = new Vector<String>();

    public void thisIsThePicture(String pictureFileName) throws FileNotFoundException {
        /*
         * this function works on storing the image
         *
         */
        String currentPath = System.getProperty("user.dir") + "/";
        File fileName = new File(currentPath + pictureFileName); //importing file
        try { //using exception handling
            Scanner sc = new Scanner(fileName);

            while (sc.hasNextLine()) { //looping until whole functionality has been done
                String row = sc.nextLine();
                char[] characterArray = row.toCharArray();
                for (int i = 0; i < characterArray.length; i++) {
                    if (i == characterArray.length - 1) {
                        this.ForStoringTheImage.add("" + characterArray[i] + "\n");
                    } else if (i == 0) {
                        this.ForStoringTheImage.add("\t\t" + characterArray[i]);
                    } else
                        this.ForStoringTheImage.add("" + characterArray[i]);
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {

        }
    }

}