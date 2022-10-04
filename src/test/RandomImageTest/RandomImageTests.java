package test.RandomImageTest;
import frontend.FileDirectoryEnum;
import frontend.RandomImageGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class RandomImageTests {
    // Objekt som testas flera gånger så instansierar här
    RandomImageGenerator testRandomGenerator = new RandomImageGenerator();

    // Mapparna som är relevanta i dessa tester
    final String catsDirectoryURL = "img/randomimg/cats/";
    final String errorsDirectoryURL = "img/randomimg/errors/";


    @Test
    void testFileDirEnumCATSReturnCorrectURL() {
        String expected = catsDirectoryURL;
        assert(expected.equals(FileDirectoryEnum.CATS.url));
        assert(!expected.equals(FileDirectoryEnum.ERRORS.url));
    }

    @Test
    void testFileDirEnumERRORSReturnCorrectURL() {
        String expected = errorsDirectoryURL;
        assertEquals(expected, FileDirectoryEnum.ERRORS.url);
        assertNotEquals(expected, FileDirectoryEnum.CATS.url);
    }

    // Just nu finns de 6 jpg filer i mappen "cats", jag vill testa så att alla bilder blir inkluderade i generatorn samt att den inte kastar fel osv
    @Test
    void testThatAllFilesInCatsFolderAreIncludedInArray() {
        File testFile = new File(catsDirectoryURL);
        int expectedCount = Objects.requireNonNull(testFile.list(), "Wrong URL").length; // Om man skriver fel URL så får man ett NullPointerException med lite mer INFO vad man gjort fel
        int expectedCount2 = 6; // HårdKodad faktiskt värde just nu

        int actual = testRandomGenerator.getAllFileNamesAsArrayInFolder(FileDirectoryEnum.CATS).length;
        assertEquals(expectedCount, actual);
        assertEquals(expectedCount2, actual);

        // Provar lite andra metoder för skojs skull
        // Att den inte kastar ett FEL el spec FEL
        assertDoesNotThrow(() -> {
                    testRandomGenerator.getAllFileNamesAsArrayInFolder(FileDirectoryEnum.CATS);
        });

        assertThrows(NullPointerException.class, () -> {
            testRandomGenerator.getAllFileNamesAsArrayInFolder(FileDirectoryEnum.TEST);
        });
    }

    @Test
    void testThatAllFilesInErrorsFolderAreIncludedInArray() {
        File testFile = new File(errorsDirectoryURL);
        int expectedCount = Objects.requireNonNull(testFile.list(), "Wrong URL").length;
        int expectedCount2 = 4;

        int actual = testRandomGenerator.getAllFileNamesAsArrayInFolder(FileDirectoryEnum.ERRORS).length;
        assertEquals(expectedCount, actual);
        assertEquals(expectedCount2, actual);
    }
}
