package com.nighthawk.spring_portfolio.hacks.trajectoryCalculator;

import org.jfree.data.function.Function2D;

/*
 * Actual math for calculating trajectory
 * 
 * Calculates equation as a string
 *  
 * Returns equation
 * 
 */

 public class TrajectoryMath implements Function2D {

    // Initialize variables
    private double velocity;
    private double degrees;
    private double height;
    private String equation;
    private double coefficientA;
    private double coefficientB;
    private double coefficientC;

    
    // Constructor
    public TrajectoryMath(double velocity, double degrees, double height) {
        this.velocity = velocity;
        this.degrees = degrees;
        this.height = height;

        this.calculateEquation();
    }

    // Getters and setters
    public double getVelocity() {
        return this.velocity;
    }

    public double getDegrees() {
        return this.degrees;
    }

    public double getHeight() {
        return this.height;
    }

    public String getEquation() {
        return this.equation;
    }

    public double getCoefficientA() {
        return this.coefficientA;
    }

    public double getCoefficientB() {
        return this.coefficientB;
    }

    public double getCoefficientC() {
        return this.coefficientC;
    }

    // Gets the root of the equation
    // There should be only one positive root, so the method will return that and discard the other
    // Returns 0.0 if none is found (which shouldn't happen usually)
    public double getRoot() {
        double rootOne = (-this.coefficientB + Math.sqrt(Math.pow(coefficientB, 2) - 4 * (-this.coefficientC) * this.coefficientA)) / (2 * (-this.coefficientC));
        double rootTwo = (-this.coefficientB - Math.sqrt(Math.pow(coefficientB, 2) - 4 * (-this.coefficientC) * this.coefficientA)) / (2 * (-this.coefficientC));

        if (rootOne > 0) {
            return rootOne;
        } else if (rootTwo > 0) {
            return rootTwo;
        } else {
            return 0.0;
        }
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    // Array should be in order of velocity, degrees, and height
    public void setParameters(double[] values) {
        this.velocity = values[0];
        this.degrees = values[1];
        this.height = values[2];
    }

    // Math for equation
    private void calculateEquation() {

        // Calculates coefficients for each part
        this.coefficientA = height;
        this.coefficientB = Math.tan(degrees * Math.PI/180);
        this.coefficientC = 9.8 / (2 * Math.pow(velocity, 2) * Math.pow(Math.cos(degrees * Math.PI/180), 2));

        // Makes string of equation just in case
        String precheckedEquation = "y = " + String.valueOf(coefficientA) + " + " + String.valueOf(coefficientB) + "x - " +
        String.valueOf(coefficientC) + "x^2";
        this.equation = precheckedEquation;
    }

    // Returns equation
    public double getValue(double v) {
        return coefficientA + coefficientB * v - coefficientC * Math.pow(v, 2);
    }

    /*
     * public static void main(String[] args) {
        TrajectoryMath example = new TrajectoryMath(15, 60, 4);
        System.out.println(example.getRoot());
     }
     */
     
   
 }