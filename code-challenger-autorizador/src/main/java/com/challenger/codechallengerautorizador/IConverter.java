package com.challenger.codechallengerautorizador;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface IConverter {

    void collectionToJson(String file, List entity) throws IOException;

    List jsonToCollection(InputStream is) throws IOException;
}
