package br.com.alura.java.io.teste;

import java.io.*;

public class IntegrandoLeituraEscrita {

    public static void main(String[] args) throws IOException {

        InputStream fis = System.in; //new FileInputStream("clubhouse.txt");
        Reader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        OutputStream fos = new FileOutputStream("arquivoIntegrado.txt"); //System.out;
        Writer osr = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osr);

        String linha = br.readLine();

        while (linha != null && !linha.isEmpty()) {
            bw.write(linha);
            bw.newLine();
            bw.flush();
            linha = br.readLine();
        }
        br.close();
        bw.close();
    }
}
