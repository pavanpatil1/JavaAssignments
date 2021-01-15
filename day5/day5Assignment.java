package com.company;

import java.util.*;
import java.util.regex.Pattern;

public class Quiz {

    public static int score;
    public static int correctanswer;
    public static int wronganswer;
    public static int totalquestion;


    public static void Correct(){
        score+=1;
        correctanswer+=1;
        totalquestion+=1;
    }
    public static void Wrong(){
        wronganswer+=1;
        totalquestion+=1;
    }

    public static boolean isWord(String in){
        return Pattern.matches("[a-d]",in);
    }
    public static boolean isNum(String in){
        return Pattern.matches("[1-10]",in);
    }


    public static void main(String[] args) {

        HashMap<String , String> bank = new HashMap<String, String>();
        bank.put("In Java arrays are \n" + "a.Objects \nb.Objects references \nc.Primitive data type \nd.None of above","a");
        bank.put("The class string belong to \n" + "a.java.awt \nb.java.lang \nc.java.applet \nd.java.string","b");
        bank.put("Who is Father of Java \n" + "a.James Gosling \nb.M.P java \nc.Charles babbage \nd.Bilas pascal","a");
        bank.put("Which is not java keyword \n" + "a.double \nb.switch \nc.then \nd.instanceOf","c");
        bank.put("Java language was initially called as \n" + "a.Sumtra \nb.J++ \nc.Oak \nd.Pine","c");
        bank.put("Color of Apple is \n" + "a.red \nb.Yellow \nc.Blue \nd.Orange","a");
        bank.put("Color of Lemon \n" + "a.red \nb.Yellow \nc.Blue \nd.Orange","b");
        bank.put("The maximum length of the char column is \n" + "a.65,535 \nb.256 bytes \nc.255 bytes \nd.None","c");
        bank.put("Father of mysql is \n" + "a.Bill joy \nb.Michael widenius \nc.Bill gates \nd.Stephanie wall","b");
        bank.put("Which of the following directly stop execution of a thread \n" + "a.wait \nb.notify \nc.notifyall \nd.exits synchronizes code","a");
        bank.put("Full form of MVC \n" + "a.Model View Controller \nb.Model Mobile Controller \nc.may be controller \nd. None code","a");
        bank.put("Full form of AWS \n" + "a.Amazon wide services \nb.Amazon web services \nc.Amazon wise services \nd.None ","b");
        bank.put("Film and Tv institue of india located in \n" + "a.Pune \nb.Kolhapur \nc.Nashik \nd.None ","a");
        bank.put("Hockey was introduce in asian games in \n" + "a.1958 Tokyo \nb.1962 in Jakarta \nc.1966 in Mumbai \nd.None ","a");
        bank.put("During World war II, when did Germany attack France \n" + "a.1940 \nb.1941 \nc.1942 \nd.None ","a");
        bank.put("Golden template, Amritsar is india's \n" + "a.largest gurdwara \nb.oldest gurudwara \nc.both a & b \nd. ALl ","a");

        boolean isNumber = false;

        List<String> keylist = new ArrayList<String>(bank.keySet());

        int random = new Random().nextInt(keylist.size());
        String randomkey = keylist.get(random);

        System.out.println("------Quiz Application------");

        for(String name : bank.keySet()){

            System.out.println(name);
            Scanner input = new Scanner(System.in);

            String num = String.valueOf(isNumber);
//            System.out.println(num);

            switch (num){
                case "false":
                    System.out.println("Enter Answer = ");
                    String answer = input.nextLine();
                    String answers = bank.get(name);


                    if(answer.equals(answers)){
                        Correct();
                    }
                    else{
                        Wrong();
                    }


                    if(totalquestion >= 10){
                        System.out.println("your score is "+score + ", Wrong Answer "+wronganswer + ", Correct Answer "+correctanswer);
                        System.exit(0);
                    }
                    if(wronganswer >= 4){
                        System.out.println("Sorry you are Fail..");
                        System.exit(0);
                    }

                    if (answer.length() > 1 || isWord(answer) == false || isNum(answer) == true) {
                        System.out.println("Invalid Input");
                        isNumber = false;
                    }
                    else {
                        isNumber = true;
                    }


                case "true":
                    System.out.println("Enter Answer = ");
                    answer = input.nextLine();
                    answers = bank.get(name);


                    if(answer.equals(answers)){
                        Correct();
                    }
                    else{
                        Wrong();
                    }


                    if(totalquestion >= 10){
                        System.out.println("your score is "+score + ", Wrong Answer "+wronganswer + ", Correct Answer "+correctanswer);
                        System.exit(0);
                    }
                    if(wronganswer >= 4){
                        System.out.println("Sorry you are Fail..");
                        System.exit(0);
                    }

                    if (answer.length() > 1 || isWord(answer) == false || isNum(answer) == true) {
                        System.out.println("Invalid Input");
                        isNumber = false;
                    }
                    else {
                        isNumber = true;
                    }
            }

        }
        System.out.println("your score is "+score + " Wrong Answer "+wronganswer + " Correct Answer "+correctanswer + "total question" + totalquestion);

    }
}
