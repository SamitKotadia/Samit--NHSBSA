package uk.nhs.nhsbsa.services.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadCongiFile {

    private Properties properties;


    public ReadCongiFile(String propertyFilePath) {
        propertyFilePath = "src/test/resources/" + propertyFilePath;
        BufferedReader reader;     // This is predifined class used to read the file
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(".properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationURL() {
        String url = properties.getProperty("baseURL");
        return url;
    }

    public String getApplicationBrowser() {
        String myBrowser = properties.getProperty("browser");
        return myBrowser;
    }
}
