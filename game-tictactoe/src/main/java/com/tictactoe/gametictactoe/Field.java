package com.tictactoe.gametictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JButton {
    final int PLAYER_1 = 1;
    final int PLAYER_2 = 2;

    int playerActual = PLAYER_1;

    public Field() {
        int who = 0;
        setBackground(Color.WHITE);
        addActionListener(e -> {
            if (who == 0) {
                if (playerActual == PLAYER_1) {
                } else {
                }
            }
        });
    }
}
