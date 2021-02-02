package com.learning.java.eight.javaeight;

import org.apache.logging.log4j.util.PropertySource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();
        palavras.add("carro");
        palavras.add("onibus");
        palavras.add("aeronave");


        //Collections.sort(palavras, comparador);
        //Mesma coisa:

        /*
        palavras.sort((s1, s2) -> {
                if (s1.length() < s2.length())
                    return -1;
                if (s1.length() > s2.length())
                    return 1;
                return 0;
        });*/

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(palavras);

        /*
        for (String p : palavras) {
            System.out.println(p);
        }*/

        Consumer<String> impressor = s -> System.out.println(s);
        palavras.forEach(impressor);

        //Mesma coisa:
        palavras.forEach(s -> System.out.println(s));
    }
}

class ComparadorPorTamanho implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        return 0;
    }
}

class ImprimeNaLinha implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}