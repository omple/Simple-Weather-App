package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class GUI {
    private JFrame jFrame;
    private static int HEIGHT = 300;
    private static int WIDTH = 400;
    private static JButton continueButton;

    public GUI(){
        jFrame = new JFrame();
        jFrame.setTitle("Simple Weather App");
        jFrame.setVisible(true);

        jFrame.setSize(WIDTH,HEIGHT);
        jFrame.setResizable(true);
        jFrame.setLocation(400,400);

        jFrame.setLayout(new FlowLayout());
        continueButton = new JButton("Find Weather");

        jFrame.add(continueButton);


        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }
}
