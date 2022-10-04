package frontend;

import javax.swing.*;
import java.io.File;
import java.util.Random;

public class RandomImageGenerator {
    // Metoder i Klassen
    public ImageIcon generateRandomCatImg() {
        String[] cats = getAllFileNamesAsArrayInFolder(FileDirectoryEnum.CATS);

        // Random nr dynamiskt från listan
        int randomNr = getRandomNumber(cats.length);

        // Returnerar en random index
        return new ImageIcon(FileDirectoryEnum.CATS.url + cats[randomNr]);
    }

    public ImageIcon generateRandomErrorImg() {
        String[] errs = getAllFileNamesAsArrayInFolder(FileDirectoryEnum.ERRORS);
        int randomNr = getRandomNumber(errs.length);
        return new ImageIcon(FileDirectoryEnum.ERRORS.url + errs[randomNr]);
    }

    public String[] getAllFileNamesAsArrayInFolder(FileDirectoryEnum directoryEnum) {
        File randomDirectory = new File(directoryEnum.url);

        // Populates the Array with the url to the images
        return randomDirectory.list();
    }

    private int getRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

}
