package gui;

import java.io.File;
import java.util.Random;

public class RandomImage {

    public static String getRandomImg() {
        String[] pathNames;
        File randomDirectory = new File("img/randomimg");

        // Populates the Array with the url to the images
        pathNames = randomDirectory.list();

        // Random nr dynamiskt från listan
        int randomNr = getRandomNumber(pathNames.length);

        // Returnerar en random index
        return "img/randomimg/" + pathNames[randomNr];
    }

    private static int getRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }
}
