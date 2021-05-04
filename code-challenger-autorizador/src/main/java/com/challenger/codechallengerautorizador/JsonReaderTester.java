package com.challenger.codechallengerautorizador;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonReaderTester {

    public static void main(String[] args) throws IOException {

        JsonReaderTester jsonTutorial = new JsonReaderTester();
        IConverter converter = new UserConverter();

        InputStream is = jsonTutorial.fileLocation("C:/Users/olive/Desktop/teste.json");

        List users = converter.jsonToCollection(is);
        users.forEach(System.out::println);


    }

    private InputStream fileLocation(String file) {

        return getClass().getClassLoader().getResourceAsStream(file);
    }
}
