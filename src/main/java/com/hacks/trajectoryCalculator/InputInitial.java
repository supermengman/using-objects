package com.hacks.trajectoryCalculator;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InputInitial {
    public static Double initialVelocity;
    public static Double initialDegrees;
    public static Double initialHeight;

    public void spawnInputs() {
        while (initialVelocity == null || initialDegrees == null || initialHeight == null) {
            JTextField inputVelocity = new JTextField();
            JTextField inputDegrees = new JTextField();
            JTextField inputHeight = new JTextField();

            Object[] inputs = {
                "Initial Velocity (m/s):", inputVelocity,
                "Initial Degrees:", inputDegrees,
                "Initial Height (m):", inputHeight
            };

            JOptionPane.showConfirmDialog(null, inputs, "Input the initial values for your object (numbers only):", JOptionPane.OK_CANCEL_OPTION);

            initialVelocity = parseInput(inputVelocity);
            initialDegrees = parseInput(inputDegrees);
            initialHeight = parseInput(inputHeight);
        }
        
    }

    public Double parseInput(JTextField inputValue) {
        String placeholder = inputValue.getText();
        try {
            double initialValue = Double.parseDouble(placeholder);
            if (initialValue < 0.0) {
                JOptionPane.showMessageDialog(null, "Inputs must be greater than 0", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return null;
            } else {
                return initialValue;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There was an invalid input for " + placeholder + ", please try again. " + e, "Unwanted Input", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
}