package gui;

import java.io.File;
import java.util.Random;

public class RandomImage {

    public static String getRandomCatImg() {
        String[] cats = getAllFileNamesAsArrayInFolder(FileDirectoryEnum.CATS);

        // Random nr dynamiskt från listan
        int randomNr = getRandomNumber(cats.length);

        // Returnerar en random index
        return FileDirectoryEnum.CATS.url + cats[randomNr];
    }

    public static String getRandomErrImg() {
        String[] errs = getAllFileNamesAsArrayInFolder(FileDirectoryEnum.ERRORS);
        int randomNr = getRandomNumber(errs.length);
        return FileDirectoryEnum.ERRORS.url + errs[randomNr];
    }

    private static int getRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public static String[] getAllFileNamesAsArrayInFolder(FileDirectoryEnum directoryEnum) {
        String[] pathNames;
        File randomDirectory = new File(directoryEnum.url);

        // Populates the Array with the url to the images
        return pathNames = randomDirectory.list();
    }
}
