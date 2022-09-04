package com.math;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InputInitial {
    public static int initialVelocity;
    public static int initialDegrees;
    public static int initialHeight;

    private void spawnInputs() {
        JTextField inputVelocity = new JTextField();
        JTextField inputDegrees = new JTextField();
        JTextField inputHeight = new JTextField();

        Object[] inputs = {
            "Initial Velocity:", inputVelocity,
            "Initial Degrees:", inputDegrees,
            "Initial Height:", inputHeight
        };

        JOptionPane.showConfirmDialog(null, inputs, "Input the initial values for your object:", JOptionPane.OK_CANCEL_OPTION);

        System.out.println(parseInput(inputVelocity, initialVelocity));
        System.out.println(parseInput(inputDegrees, initialDegrees));
        System.out.println(parseInput(inputHeight, initialHeight));
    }

    public int parseInput(JTextField inputValue, int initialValue) {
        String placeholder = inputValue.getText();
        initialValue = Integer.parseInt(placeholder);
        return initialValue;
    }
}