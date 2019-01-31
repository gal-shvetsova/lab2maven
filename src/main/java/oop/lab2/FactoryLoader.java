package oop.lab2;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class FactoryLoader {
    private FactoryLoader() {
    }

    public static HashMap makeMap(String filePath) {
        HashMap<String, String> operations = new HashMap();
        if (filePath == null) {
            return operations;
        }
        Properties properties = new Properties();
        InputStream in = FactoryLoader.class.getClassLoader().getResourceAsStream(filePath);
        try {
            properties.load(in);
            in.close();
        } catch (Exception ex) {
            return operations;
        }
        for (
                HashMap.Entry<Object, Object> entry : properties.entrySet()) {
            operations.put((String) entry.getKey(), (String) entry.getValue());
        }
        return operations;
    }
}