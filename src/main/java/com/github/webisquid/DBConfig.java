package com.github.webisquid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {

    Properties properties = new Properties();

    FileInputStream fis;

    {
        try {
            fis = new FileInputStream("src/main/java/resources/application.properties");
            properties.load(fis);
            String uri = properties.getProperty("db.host");
            String login = properties.getProperty("db.user");
            String pssword = properties.getProperty("db.login");
            String port = properties.getProperty("db.port");
            String DBname = properties.getProperty("db.name");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
