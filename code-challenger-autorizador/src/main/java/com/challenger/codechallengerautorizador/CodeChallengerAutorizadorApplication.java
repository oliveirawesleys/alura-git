package com.challenger.codechallengerautorizador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.logging.Log;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class CodeChallengerAutorizadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengerAutorizadorApplication.class, args);

		String file = "C:/Users/olive/Desktop/teste.json";
		JSONObject jsonObject;

		JSONParser parser = new JSONParser();
		Boolean valor;
		String sobrenome;
		String estado;
		String pais;

		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(file));

			//Salva nas variaveis os dados retirados do arquivo
/*			nome = (String) jsonObject.get("nome");
			sobrenome = (String) jsonObject.get("sobrenome");
			estado = (String) jsonObject.get("estado");
			pais = (String) jsonObject.get("pais");*/

			valor = (Boolean) jsonObject.get("active-card");
			System.out.println(valor);
			System.out.println(jsonObject);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

/*
		Gson gson = new Gson();
		Transaction transaction = gson.fromJson(file, Transaction.class);
		transaction.toString();

		try {
			System.out.println(readJson(file));
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}

	public static String readJson(String path) throws IOException {
		String json = String.join(" ",
				Files.readAllLines(
						Paths.get(path),
						StandardCharsets.UTF_8)
		);
		return json;
	}

}
