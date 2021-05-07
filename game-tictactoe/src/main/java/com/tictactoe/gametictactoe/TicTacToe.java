package com.tictactoe.gametictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    ImageIcon circle = new ImageIcon("circle.png");
    ImageIcon x = new ImageIcon("x.png");

    JPanel pScreen = new JPanel(new GridLayout(3, 3, 5, 5));

    Field[] fields = new Field[9];

    final int PLAYER_1 = 1;
    final int PLAYER_2 = 2;

    int playerActual = PLAYER_1;

    JLabel lInformation = new JLabel("Player " + PLAYER_1);

    public TicTacToe() {
        configureTicTacToe();
        configureScreen();
    }

    public void configureScreen() {
        add(BorderLayout.CENTER, pScreen);
        add(BorderLayout.NORTH, lInformation);
        pScreen.setBackground(Color.BLACK);
        lInformation.setFont(new Font("Arial", Font.BOLD, 35));
        lInformation.setForeground(new Color(50, 200, 50));
        lInformation.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 9; i++) {
            Field field = new Field();

            fields[i] = field;
            pScreen.add(field);
        }
    }

    public void changePlayer() {
        if (playerActual == 1) {
            playerActual = 2;
            lInformation.setText("Player 2");
            lInformation.setForeground(Color.RED);
        } else {
            playerActual = 1;
            lInformation.setText("Player 2");
            lInformation.setForeground(Color.GREEN);
        }
    }

    public boolean hasVictory(int player) {
        if (fields[0].who == player && fields[1].who == player && fields[2].who == player ) {
            return true;
        }
        return false;
    }

    private void configureTicTacToe() {
        setTitle("Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class Field extends JButton {
        int who = 0;

        public Field() {
            setBackground(Color.WHITE);
            addActionListener(e -> {
                if (who == 0) {
                    if (playerActual == PLAYER_1) {
                        setIcon(circle);
                        who = PLAYER_1;
                    } else {
                        setIcon(x);
                        who = PLAYER_2;
                    }
                    changePlayer();
                }
            });
        }
    }

}
