package com.tictactoe.gametictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    public TicTacToe() {
        configureTicTacToe();
    }

    private void configureTicTacToe() {
        setTitle("Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
