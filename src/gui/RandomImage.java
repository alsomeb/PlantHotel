package gui;

import java.io.File;
import java.util.Random;

public class RandomImage {

    public static String getRandomCatImg() {
        String[] cats = getAllFileNamesAsArrayInFolder("cats");

        // Random nr dynamiskt från listan
        int randomNr = getRandomNumber(cats.length);

        // Returnerar en random index
        return "img/randomimg/cats/" + cats[randomNr];
    }

    public static String getRandomErrImg() {
        String[] errs = getAllFileNamesAsArrayInFolder("errors");
        int randomNr = getRandomNumber(errs.length);
        return "img/randomimg/errors/" + errs[randomNr];
    }

    private static int getRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private static String[] getAllFileNamesAsArrayInFolder(String folder) {
        String[] pathNames;
        File randomDirectory = new File("img/randomimg/" + folder + "/");

        // Populates the Array with the url to the images
        return pathNames = randomDirectory.list();
    }
}
