package com.tictactoe.gametictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameTictactoeApplication {

	public static void main(String[] args) {
		new TicTacToe();
		SpringApplication.run(GameTictactoeApplication.class, args);
	}

}
