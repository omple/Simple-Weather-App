package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame jFrame;
    private static int HEIGHT = 1000;
    private static int WIDTH = 1000;
    private static JTextField jTextField;
    private static JButton continueButton;
    private static String zipCode;
    private static JLabel weather;

    private final String stringDigit = "0123456789";

    public GUI(){
        jFrame = new JFrame();
        jFrame.setTitle("Simple Weather App");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setSize(WIDTH,HEIGHT);
        jFrame.setResizable(true);
        jFrame.setLocation(400,400);

        jFrame.setLayout(new FlowLayout());
        jTextField = new JTextField("",10);
        continueButton = new JButton("Find Weather");
        weather = new JLabel("Temp");

        jFrame.add(jTextField);
        jFrame.add(continueButton);
        jFrame.add(weather);

        jFrame.pack();

        continueButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Boolean isFormated = true;
        zipCode = jTextField.getText();

        if (zipCode.length() == 5){
            for(char i: zipCode.toCharArray()){
                // Character.toString from https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#toString-char-
                if (!stringDigit.contains(Character.toString(i))){
                    isFormated = false;
                }
            } // got char array from https://stackoverflow.com/a/2451660
        }

        if(isFormated){
            DataAPI data = new DataAPI(zipCode);
            System.out.println(data.getTemp());
            weather.setText(data.getTemp());
        }

    }
}
