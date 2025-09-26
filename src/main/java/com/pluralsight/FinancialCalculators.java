package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {

    // Declaration and initialization of scanner (keyboard)
    // Made static so it could be used globally by all 3 calculators
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("What calculator would you like to use? (1-3) \n 1. Mortgage \n 2. Future Value \n 3. Present Value \n Enter here: ");
        int calculatorSelect = keyboard.nextInt();

        // While loop to catch if the user enters the incorrect output out of range. Range is 1-3
        while (calculatorSelect < 1 || calculatorSelect > 3) {
            System.out.print("Error, please enter a selection 1-3!");

            System.out.print("What calculator would you like to use? (1-3) \n 1. Mortgage \n 2. Future Value \n 3. Present Value \n Enter here: ");
            calculatorSelect = keyboard.nextInt();
        }
        // If statement to call the user selected calculator method
        if (calculatorSelect == 1) {
            mortgageCalculator();
        } else if (calculatorSelect == 2) {
            futureValueCalculator();
        } else if (calculatorSelect == 3) {
            presentValueCalculator();
        }
    }

    public static void mortgageCalculator() {

        System.out.println("=== Mortgage Calculator ===");
        System.out.println(" ");

        System.out.print("Enter your loan amount: $");
        double loanPrincipal = keyboard.nextDouble();

        System.out.print("Enter your interest rate: ");
        double annualInterestRate = keyboard.nextDouble();

        System.out.print("Enter the loan term in years: ");
        double loanTerm = keyboard.nextDouble();

        double monthlyInterestRate = annualInterestRate / 100.0 / 12;
        double countMonthlyPayments = loanTerm * 12;

        // Monthly payment calculated using formula: M = P (i * (1 + i)^n / ( (1 + i)^n -1)
        double monthlyPayment = loanPrincipal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate,countMonthlyPayments)) / (Math.pow(1 + monthlyInterestRate,countMonthlyPayments) - 1);

        System.out.printf("Your monthly loan payment is: $%.2f",monthlyPayment);

    }
    public static void futureValueCalculator() {

    }
    public static void presentValueCalculator() {

    }
}
