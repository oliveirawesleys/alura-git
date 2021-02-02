package com.learning.java.eight.javaeight;

public class ExerciceRunnable {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executando Runnable");
            }
        }).start();

        new Thread(() -> System.out.println("Executando Runnable com Lambda")).start();
    }
}
