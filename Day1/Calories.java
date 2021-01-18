package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Calories {
    int duration = 0;
    int weight = 0;



    public  static void Running(String name,String excerise,String user,int duration,int weight){
        int cal = 0;
        if(weight > 55){
            cal = 11 * duration;
        }
        if(weight > 81){
            cal = 17 * duration;
        }
        System.out.println("Hii "+name+",");
        System.out.println("Calories you Burned by " + excerise +" on "+ user + "=" +cal);

    }
    public static void Runcycle(String name,String excerise,String user,int duration,int weight){
        int cal = 0;
        if(duration >= 30 && weight >=56){
            cal = 240;
        }
        if(duration >= 30 && weight >=70){
            cal = 298;
        }
        if(duration >= 30 && weight >=84){
            cal = 355;
        }
        System.out.println("Hii "+name+",");
        System.out.println("Calories you Burned by Cycling on "+ user + " = " +cal);

        int cals = 0;
        if(weight > 55){
            cals = 11 * duration;
        }
        if(weight > 81){
            cals = 17 * duration;
        }
        System.out.println("Calories you Burned by Running on "+ user + " = " +cals);

        int total = cal + cals;
        System.out.println("\nTotal Calories burned by both excerise ="+total);

    }

    public static void Walking(String name,String excerise,String user,int duration,int weight){
        int total = 0;
        total = (int) ((0.035 * weight) + (1.225) + ((0.029) * (weight))) ;
        total = total * duration;
        System.out.println("Hii "+name+",");
        System.out.println("Calories you Burned by " + excerise +" on "+ user + "=" +total);

    }

    public static void Cycling(String name,String excerise,String user,int duration,int weight){
        int cal = 0;
        if(duration >= 30 && weight >=56){
            cal = 240;
        }
        if(duration >= 30 && weight >=70){
            cal = 298;
        }
        if(duration >= 30 && weight >=84){
            cal = 355;
        }
        System.out.println("Hii "+name+",");
        System.out.println("Calories you Burned by " + excerise +" on "+ user + "=" +cal);

    }


    public static void Calculate(String name, String exercise,String user,int duration ,int weight){

        if(exercise.equals("cycling")){
            Cycling(name,exercise,user,duration,weight);
        }
        if(exercise.equals("walking")){
            Walking(name,exercise,user,duration,weight);
        }
        if(exercise.equals("running")){
            Running(name,exercise,user,duration,weight);
        }
        if(exercise.equals("running,cycling")){
            Runcycle(name,exercise,user,duration,weight);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Calorie Meter-------------");
        System.out.println("Enter your Name = ");
        String name = sc.nextLine();
        System.out.println("Enter type of Exercise = ");
        String exercise = sc.nextLine();
        System.out.println("Enter Date = ");
        String user = sc.nextLine();
        System.out.println("Enter Duration");
        int duration = sc.nextInt();
        System.out.println("Enter your Weight");
        int weight = sc.nextInt();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        if(user.equals(" ")){
            user = strDate;
        }
        System.out.println("---------------------------------------");

        Calculate(name,exercise,user,duration,weight);

    }
}
