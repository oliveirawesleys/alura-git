package com.challenger.codechallengerautorizador;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserConverter implements IConverter {

    public void collectionToJson(String file, List users) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new FileOutputStream(file), users);
    }

    public List jsonToCollection(InputStream file) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(file, new TypeReference<List>() {});
    }
}