package com.tictactoe.gametictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    JPanel pScreen = new JPanel(new GridLayout(3, 3, 5, 5));
    JLabel lInformation = new JLabel();

    Field[] fields = new Field[9];

    final int PLAYER_1 = 1;
    final int PLAYER_2 = 2;

    public TicTacToe() {
        configureTicTacToe();
        configureScreen();
    }

    public void configureScreen() {
        add(BorderLayout.CENTER, pScreen);
        add(BorderLayout.NORTH, lInformation);

        for (int i = 0; i < 9; i++) {
            Field field = new Field();

            fields[i] = field;
            pScreen.add(field);
        }
    }


    private void configureTicTacToe() {
        setTitle("Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
