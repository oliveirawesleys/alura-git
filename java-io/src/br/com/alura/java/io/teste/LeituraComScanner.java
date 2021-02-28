package br.com.alura.java.io.teste;

import java.io.*;
import java.util.Scanner;

public class LeituraComScanner {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("contas.csv"));
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            System.out.println(linha);

            String[] valores = linha.split(",");
            System.out.println(valores[3]);

        }

        scanner.close();
    }
}
