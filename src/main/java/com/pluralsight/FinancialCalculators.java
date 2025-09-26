package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {

    // Declaration and initialization of scanner (keyboard)
    // Made static so it could be used globally by all 3 calculators
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("What calculator would you like to use? (1-3) \n 1. Mortgage \n 2. Future Value \n 3. Present Value \n Enter here: ");
        int calculatorSelect = keyboard.nextInt();

        if (calculatorSelect < 1 || calculatorSelect > 3) {
            System.out.print("Error, please enter a selection 1-3!");

            System.out.print("What calculator would you like to use? (1-3) \n 1. Mortgage \n 2. Future Value \n 3. Present Value \n Enter here: ");
            calculatorSelect = keyboard.nextInt();
            return;
        }
    }

    public static void mortgageCalculator() {

        System.out.println("=== Mortgage Calculator ===");
        System.out.println(" ");

        System.out.print("Please enter your loan amount: $");
        double loanPrincipal = keyboard.nextDouble();

    }
    public static void futureValueCalculator() {

    }
    public static void presentValueCalculator() {

    }
}
