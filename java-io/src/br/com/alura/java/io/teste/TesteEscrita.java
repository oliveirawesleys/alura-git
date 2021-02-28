package br.com.alura.java.io.teste;

import java.io.*;

public class TesteEscrita {

    public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo

        OutputStream fos = new FileOutputStream("clubhouse2.txt");
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Arquivo novo para escrita");
        bw.newLine();
        bw.write("Escrevendo a segunda linha");

        bw.close();
    }
}
