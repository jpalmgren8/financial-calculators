package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {

    // Declaration and initialization of scanner (keyboard)
    // Made static so it could be used globally by all 3 calculators
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        // Prompting the user for input on what calculator to use (1-3)
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
    // Calculator program for calculating mortgage loans
    public static void mortgageCalculator() {

        System.out.println("=====[Mortgage Calculator]=====");

        // Prompts asking the user for loan amount, interest rate, and loan term (years)
        System.out.print("Enter your loan amount: $");
        double loanPrincipal = keyboard.nextDouble();

        System.out.print("Enter your interest rate: ");
        double annualInterestRate = keyboard.nextDouble();

        System.out.print("Enter the loan term in years: ");
        double loanTerm = keyboard.nextDouble();

        //Converting annualInterestRate into decimal form and calculating the monthly interest rate
        double monthlyInterestRate = annualInterestRate / 100.0 / 12;
        double countMonthlyPayments = loanTerm * 12;

        // Monthly payment calculated using formula: M = P (i * (1 + i)^n / ( (1 + i)^n -1)
        double monthlyPayment = loanPrincipal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate,countMonthlyPayments)) / (Math.pow(1 + monthlyInterestRate,countMonthlyPayments) - 1);

        // Total interest calculated using formula (M * n) - P
        double totalInterest = (monthlyPayment * countMonthlyPayments) - loanPrincipal;

        // Final print out of loan details including the monthly payment amount and total interest on the loan
        System.out.printf("============[LOAN DETAILS]============ \n Your monthly loan payment is: $%.2f",monthlyPayment);
        System.out.println();
        System.out.printf("====================================== \n Your total interest is: $%.2f",totalInterest);
        System.out.println();
        System.out.print("======================================");

    }
    public static double futureValueCalculator() {

        // ADD COMMENTS

        System.out.println("=====[Future Value Calculator]=====");

        System.out.print("Enter your deposit amount: $");
        double depositAmount = keyboard.nextDouble();

        System.out.print("Enter your interest rate: ");
        double interestRate = keyboard.nextDouble();

        System.out.print("Enter the amount of years: ");
        double yearsTotal = keyboard.nextDouble();

        interestRate = interestRate / 100.0;
        double futureValue = depositAmount * Math.pow(1 + (interestRate / 365),(365 * yearsTotal));

        double interestEarned = futureValue - depositAmount;

        System.out.printf("============[CD Future Value]============ \n Future value of CD: $%.2f",futureValue);
        System.out.println();
        System.out.printf("========================================= \n Interest earned: $%.2f",interestEarned);
        System.out.println();
        System.out.print("=========================================");

        return futureValue;

    }
    public static void presentValueCalculator() {

        // Work in progress, currently working on making the correct formula for funding an annuity
        // I believe this is the right formula, C * [1 - (1 + r)^-n]/r
        // This calculator calls the future value method get the future value calculation

        System.out.println("=====[Present Value Calculator]=====");

        System.out.print("Enter monthly payout: ");
        double monthlyPayout = keyboard.nextDouble();

        System.out.print("Enter your interest rate: ");
        double expectedRate = keyboard.nextDouble();

        System.out.print("Enters years to pay out: ");
        double yearsPayout = keyboard.nextDouble();

        double futureValueCalc = futureValueCalculator();

        expectedRate = expectedRate / 100.0;

        double monthlyRate = expectedRate / 100.0 / 12;
        double numberOfPeriods = yearsPayout * 12;

        double presentValueCalc = futureValueCalc / Math.pow((1 +(monthlyRate / numberOfPeriods)),(numberOfPeriods));

        System.out.printf("============[Present Value]============ \n Present Value: $%.2f",presentValueCalc);


    }
}
