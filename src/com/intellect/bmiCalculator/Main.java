package com.intellect.bmiCalculator;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        BMIUnit unit = _getUnit(scanner);

        if(unit == BMIUnit.None){
            _print("You inputted a wrong input, closing program");
            return;
        }

        double weight = _getWeight(scanner, unit);
        double height = _getHeight(scanner, unit);

        BMICalculator calculator = new BMICalculator(unit, height, weight);

        double bmi = calculator.getBMIValue();
        _print("Your BMI is " + bmi);

    }

    private static double _getHeight(Scanner scanner, BMIUnit unit) {
        String heightUnit = unit == BMIUnit.SI ? "Meters (m)":"Inches (in)";
        _print("Please enter the height in " + heightUnit );
        return scanner.nextDouble();
    }

    private static double _getWeight(Scanner scanner, BMIUnit unit) {
        String weightUNit = unit == BMIUnit.SI ? "Kilogram (kg)":"Pounds (lbs)";
        _print("Please enter the weight in " + weightUNit );
         return scanner.nextDouble();
    }

    private static BMIUnit _getUnit(Scanner scanner) {
        _print("Welcome to the CMD BMI Calculator:\n");
        _print("Which Unit do you want to use?\nEnter \"s\" for SI Unit (Weight in kg and height in meters) \nEnter \"u\" for USC Unit (Weight in lbs and height in inches) ");

        String data = scanner.nextLine();

        if(data.toLowerCase().trim(). equals("s")){
            return BMIUnit.SI;

        }else if(data.toLowerCase().trim(). equals("u")){
            return BMIUnit.Usc;
        }else{
            return BMIUnit.None;
        }

    }

    private static void _print(String s) {
        System.out.println(s);
    }


    static class BMICalculator{
        BMIUnit unit;
        double height;
        double weight;

        BMICalculator(BMIUnit unit, double height, double weight){
            this.unit = unit;
            this.height = height;
            this.weight = weight;
        }

        public double getBMIValue(){
            double bmi =0;
            if(unit == BMIUnit.Usc){
                bmi = 703* (weight/(height * height));
            }else{
                bmi =(weight/(height * height));
            }
            return  bmi;
        }


    }

    static enum BMIUnit{
        Usc,
        SI,
        None,
    }
}
