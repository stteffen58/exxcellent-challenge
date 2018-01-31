package de.exxcellent.challenge.fileloader;

/**
 * Factory to hide logic of loading resources.
 */
public class FileLoaderFactory {

    public static final String RESOURCE_PATH = "de/exxcellent/challenge/";

    /**
     * Creates a FileLoader to load a csv file from resource folder.
     * @param fileName
     * @return
     */
    public static FileLoader getCsvFileLoader(String fileName) {
        ClassLoader classloader = FileLoaderFactory.class.getClassLoader();
        String resourcePath = RESOURCE_PATH + fileName;
        return new FileLoaderCsv(
                classloader.getResource(resourcePath).getPath());
    }
}
