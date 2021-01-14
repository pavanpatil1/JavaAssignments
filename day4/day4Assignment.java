package com.company;

import java.util.Scanner;

public class ReverseFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "I am learning Java";
        String reverse = "";
        char[] string = s.toCharArray();
        for(int i=string.length-1;i>=0;i-- ){
            reverse += string[i];
        }
        System.out.println("------Reverse Function------\n");
        System.out.println(reverse);
    }
}
