package base;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfigFileReader {


    private static final Properties properties;

    static {
        properties = new Properties();
        String propertyFilePath = "src/test/resources/config.properties";
        try(InputStream input= Files.newInputStream(Path.of(propertyFilePath))){
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar el archivo properties "+propertyFilePath,e);
        }
    }

    public static String getProp(String keyName){
        return properties.getProperty(keyName);
    }
}
