package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {
     private static final String TEST_DATA_PATH = "src/test/resources/TestData/";

    public static String getPropertyValue(String fileName, String key) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(TEST_DATA_PATH + fileName + ".properties"));
        return properties.getProperty(key);
    }

    public static String getJsonValue(String fileName, String key) throws IOException {

        FileReader fileReader = new FileReader(TEST_DATA_PATH + fileName + ".json");
        JsonElement jsonElement = JsonParser.parseReader(fileReader);
        return jsonElement.getAsJsonObject().get(key).getAsString();

    }

}
