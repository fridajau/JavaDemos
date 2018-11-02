/*
Started October 3, 2018 | Frida Jauregui
Write a program that asks the user for some information about an international trip they are taking.
 */

import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args){
    //break up the code into different parts for easier self-check
        greetings();
        timeandmoney();
        timediff();
        countryarea();
    }

    //PART1
    public static void greetings() {
        //create Scanner
        Scanner input = new Scanner(System.in);

        //prompts
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        //create a String input
        String name = input.nextLine();
        //print out full name on the same line
        System.out.print("Nice to meet you " + name + ", and where are you planning to travel to? ");
        String place = input.nextLine();
        System.out.println("Great! " + place + " sounds like a great trip!");
        //space out for clearer output
        System.out.println("********************");
        System.out.println();
        System.out.println();
    }

    //PART2
    public static void timeandmoney() {
        Scanner input = new Scanner(System.in);

        //keep track of variable values
        System.out.print("How many days are you going to spend traveling? ");
        int days = input.nextInt();
        System.out.print("What is your total budget for the trip in USD? ");
        int budget = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String curr = input.next();
        System.out.print("How many " + curr + " are there in 1 USD? ");
        double conv = input.nextDouble();
        System.out.println();

        //budget in USD
        int hours = days * 24;
        int min = hours * 60;
        System.out.println("If you are planning to travel for " + days + " days, then that is the same as "
                + hours + " hours or " + min + " minutes.");
        int perdaydol = budget/days;
        System.out.println("If your budget is $" + budget + " USD that means that per day you can spend $"
                + perdaydol + ".");
        //budget converted
        double totbud = conv * budget;
        double totbudperday = totbud/days;

        //PART5
        totbud*= 100;
        totbud = (int) totbud;
        double retotbud = totbud/100.0;

        totbudperday*= 100;
        totbudperday = (int) totbudperday;
        double retotbudperday = totbudperday/100.0;

        System.out.println("Your total budget in " + curr + " is " + retotbud + " " + curr + ", which per day is "
                + retotbudperday + " " + curr + ".");

        //System.out.println("Your total budget in " + curr + " is " + totbud + " " + curr + ", which per day is "
                //+ totbudperday + " " + curr + ".");
        //comment out prev println for part 5
        System.out.println("********************");
        System.out.println();
        System.out.println();
    }

    //PART3
    public static void timediff() {
        Scanner input = new Scanner(System.in);

        //assign noon and midnight values
        System.out.print("What is the time difference, in hours, between your home and the destination? ");
        int diff = input.nextInt();
        //int noon = 12;
        //int mid = 0;
        int cortimenoon = ((12+diff) % 24);
        int cortimemid =  ((24+diff) % 24);
        System.out.println("That means when it's midnight at home it will be " + (cortimemid) + ":00 " +
                "in your travel destination and when it is noon it will be " + (cortimenoon) + ":00.");

        //try if and else statements
        if(diff < 0) {
            System.out.println("trying with if and else statements| midnight: " + (cortimemid) + ":00 " +
                    "noon: " + (cortimenoon) + ":00");
        }else if(diff > 0){
            System.out.println("trying with if and else statements | midnight: " + (cortimemid) + ":00 " +
                    "noon: " + (cortimenoon) + ":00");
        }

        System.out.println("********************");
        System.out.println();
        System.out.println();

    }

    //PART4
    public static void countryarea() {
        Scanner input = new Scanner(System.in);

        //conversion of square area
        System.out.print("What is the square area of your destination country in km2? ");
        int km2 = input.nextInt();
        double mi2 = km2/2.589;
        //System.out.print("In miles2 that is " + mi2 + ".");

        //PART5
        mi2*= 100;
        mi2 = (int) mi2;
        double remi2 = mi2/100.0;

        System.out.print("In miles2 that is " + remi2 + ".");
    }
}
