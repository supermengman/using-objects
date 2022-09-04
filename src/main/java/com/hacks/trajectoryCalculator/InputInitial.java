package com.hacks.trajectoryCalculator;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InputInitial {
    public static double initialVelocity;
    public static double initialDegrees;
    public static double initialHeight;

    public void spawnInputs() {
        JTextField inputVelocity = new JTextField();
        JTextField inputDegrees = new JTextField();
        JTextField inputHeight = new JTextField();

        Object[] inputs = {
            "Initial Velocity:", inputVelocity,
            "Initial Degrees:", inputDegrees,
            "Initial Height:", inputHeight
        };

        JOptionPane.showConfirmDialog(null, inputs, "Input the initial values for your object:", JOptionPane.OK_CANCEL_OPTION);

        initialVelocity = parseInput(inputVelocity);
        initialDegrees = parseInput(inputDegrees);
        initialHeight = parseInput(inputHeight);
    }

    public double parseInput(JTextField inputValue) {
        String placeholder = inputValue.getText();
        double initialValue = Double.parseDouble(placeholder);
        return initialValue;
    }
}