package com.nighthawk.spring_portfolio;

/*
 * Actual math for calculating trajectory
 * 
 * Calculates equation as a string and returns it
 * 
 */

import java.util.*;

 public class TrajectoryMath {

    // Initialize variables
    private double velocity;
    private double degrees;
    private double height;
    private String equation;
    
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

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    // Math for equation
    private void calculateEquation() {
        String precheckedEquation = "y = " + String.valueOf(height) + " + " + String.valueOf(Math.tan(degrees)) + "x - " +
        String.valueOf(9.8 / (2 * Math.pow(velocity, 2) * Math.pow(Math.cos(degrees), 2))) + "x^2";

        // Fix double negative, but later
        //if (precheckedEquation.contains("- -")) {
        //}

        this.equation = precheckedEquation;
    }

    public static void main(String[] args) {
        TrajectoryMath example = new TrajectoryMath(15, 60, 4);
        System.out.println(example.getEquation());
    }
 }