package gui;

public enum FileDirectoryEnum {
    CATS("img/randomimg/cats/"),
    ERRORS("img/randomimg/errors/");

    public final String url;

    FileDirectoryEnum(String url) {
        this.url = url;
    }
}
