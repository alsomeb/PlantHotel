package gui;

public enum FileDirectoryEnum {
    // Används så man egentligen inte kan få "magic strings" och skriver fel URL för att hämta bilderna.
    CATS("img/randomimg/cats/"),
    ERRORS("img/randomimg/errors/"),

    // För testcase demo
    TEST(null);

    public final String url;

    FileDirectoryEnum(String url) {
        this.url = url;
    }
}
