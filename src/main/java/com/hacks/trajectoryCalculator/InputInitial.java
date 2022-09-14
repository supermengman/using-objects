package com.hacks.trajectoryCalculator;

import javax.swing.JOptionPane; // library to display options
import javax.swing.JTextField; // library to create a text field to render on GUI

public class InputInitial {
    // instance variables to be used
    public static Double initialVelocity;
    public static Double initialDegrees;
    public static Double initialHeight;

    // create the GUI element that users input into
    public void spawnInputs() {
        // while the values have not changed yet, keep going (for error handling)
        while (initialVelocity == null || initialDegrees == null || initialHeight == null) {
            // text field initialization
            JTextField inputVelocity = new JTextField();
            JTextField inputDegrees = new JTextField();
            JTextField inputHeight = new JTextField();

            // organizing the input text to display + the text field in object
            Object[] inputs = {
                "Initial Velocity (m/s):", inputVelocity,
                "Initial Degrees:", inputDegrees,
                "Initial Height (m):", inputHeight
            };

            JOptionPane.showConfirmDialog(null, inputs, "Input the initial values for your object (numbers only):", JOptionPane.OK_CANCEL_OPTION); // creates the option menu with the 3 inputs
            
            // take the input, assign it to the public variables
            initialVelocity = parseInput(inputVelocity);
            initialDegrees = parseInput(inputDegrees);
            initialHeight = parseInput(inputHeight);
        }
        
    }

    // change JTextField into Double, also error handling
    public Double parseInput(JTextField inputValue) {
        String placeholder = inputValue.getText(); // get the string out of the input
        
        // error handling + edge cases
        try {
            double initialValue = Double.parseDouble(placeholder);

            // if negative, cannot be valid so throw error --> reinput values bc still null
            if (initialValue < 0.0) {
                JOptionPane.showMessageDialog(null, "Inputs must be greater than 0", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return null;
            } else { // if everything ok, return the value
                return initialValue;
            }
            
        } catch (Exception e) { // if cannot be cased as a double, throw error --> reinput values
            JOptionPane.showMessageDialog(null, "There was an invalid input for " + placeholder + ", please try again. " + e, "Unwanted Input", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
}