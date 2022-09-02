package com.math;

/*
 * Actual math for calculating trajectory
 * 
 * Calculates equation as a string and returns it
 * 
 */

 public class TrajectoryMath {

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

        this.coefficientA = height;
        this.coefficientB = Math.tan(degrees);
        this.coefficientC = 9.8 / (2 * Math.pow(velocity, 2) * Math.pow(Math.cos(degrees), 2));

        String precheckedEquation = "y = " + String.valueOf(coefficientA) + " + " + String.valueOf(coefficientB) + "x - " +
        String.valueOf(coefficientC) + "x^2";
        // Fix double negative, but later
        //if (precheckedEquation.contains("- -")) {
        //}

        //Add threshold

        this.equation = precheckedEquation;
    }

    public double getValue(double v) {
        return coefficientA + coefficientB*v - coefficientC*Math.pow(v, 2);
    }

    /*
    Just testing if it works => y = 4.0 + 0.320040389379563x - 0.024008385195945284x^2
     *  public static void main(String[] args) {
        TrajectoryMath example = new TrajectoryMath(15, 60, 4);
        System.out.println(example.getEquation());
     }
     */
   
 }