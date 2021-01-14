package com.company;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------Calculator------");
        System.out.println("Enter the Number 1 = ");
        int num1 = sc.nextInt();
        System.out.println("Enter the Number 2 = ");
        int num2 = sc.nextInt();

        int sum = num1 + num2;

        System.out.println("Your Sum is "+sum);
    }
}
