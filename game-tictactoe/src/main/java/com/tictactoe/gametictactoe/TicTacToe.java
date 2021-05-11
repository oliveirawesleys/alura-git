package com.tictactoe.gametictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    String p1 = JOptionPane.showInputDialog("Player 1: ");
    String p2 = JOptionPane.showInputDialog("Player 2: ");

    ImageIcon imgX = new ImageIcon ("pizza.png");
    //ImageIcon imgCircleTest = new ImageIcon (getClass().getResource("bolinha.jpg"));
    ImageIcon imgCircle = new ImageIcon ("donuts.png");

    JPanel pScreen = new JPanel(new GridLayout(3, 3, 5, 5));

    Field[] fields = new Field[9];

    final String PLAYER_1 = p1;
    final String PLAYER_2 = p2;
    int turn = 0;
    String playerActual = PLAYER_1;

    JLabel lInformation = new JLabel(PLAYER_1);

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
        if (playerActual == p1) {
            playerActual = p2;
            lInformation.setText(p2);
            lInformation.setForeground(Color.RED);
        } else {
            playerActual = p1;
            lInformation.setText(p1);
            lInformation.setForeground(Color.GREEN);
        }
    }

    public boolean hasVictory(String player) {
        if (fields[0].who == player && fields[1].who == player && fields[2].who == player ) {
            return true;
        }
        if (fields[3].who == player && fields[4].who == player && fields[5].who == player ) {
            return true;
        }
        if (fields[6].who == player && fields[7].who == player && fields[8].who == player ) {
            return true;
        }
        if (fields[0].who == player && fields[3].who == player && fields[6].who == player ) {
            return true;
        }
        if (fields[1].who == player && fields[4].who == player && fields[7].who == player ) {
            return true;
        }
        if (fields[2].who == player && fields[5].who == player && fields[8].who == player ) {
            return true;
        }
        if (fields[0].who == player && fields[4].who == player && fields[8].who == player ) {
            return true;
        }
        if (fields[2].who == player && fields[4].who == player && fields[6].who == player ) {
            return true;
        }
        return false;
    }

    private void configureTicTacToe() {
        setTitle("Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class Field extends JButton {
        String who = "";

        public Field() {
            setBackground(Color.WHITE);
            addActionListener(e -> {
                if (who.equals("")) {
                    if (playerActual == PLAYER_1) {
                        setIcon(imgCircle);
                        who = p1;
                    } else {
                        setIcon(imgX);
                        who = p2;
                    }
                    if (hasVictory(who)) {
                        JOptionPane.showMessageDialog(null, "Player " + who + " win a PlayStation 5!");
                        System.exit(0);
                    }
                    turn++;
                    if (turn == 9) {
                        JOptionPane.showMessageDialog(null, "Play again...");
                        System.exit(0);
                    }
                    changePlayer();
                }
            });
        }
    }

}
