/*
Started October 8, 2018 | Frida Jauregui
Create a program that will play the game Odds and Evens
Each player picks either "odd" or "even" then a number from 0 to 5
The winner will determined by the sum of the numbers
 */
import java.util.Scanner;
import java.util.Random;

public class OddsEvens {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //PART 1
        System.out.println("Let’s play a game called \"Odds and Evens\" ");
        //ask the player1(you) for their name
        System.out.print("What is your name? ");
        String player1 = input.nextLine();
        //pick odds or evens
        System.out.print("Hi, " + player1 + " which do you choose? (O) odds or (E) evens? ");
        //use if/else statements to pick out comp. choice
        String oddsevens = input.next();
        if (oddsevens.equals("O")){
            System.out.println(player1 + " has picked Odds! Computer will be Evens.");
        }else{
            System.out.println(player1 + " has picked Evens! Computer will be Odds.");
        }
        System.out.println("--------------------");

        //PART 2
        System.out.print("How many \"fingers\" do you put out? ");
        int fingers = input.nextInt();
        //letting the computer pick their numbers
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The Computer plays the number " + computer);
        System.out.println("--------------------");
        //add the user’s number and the computer’s numbers together to get the sum
        System.out.println("Player1 + Computer = " + (computer + fingers));
        //check if sum will be odd or even
        int sum = (computer+fingers);
        //true if sum even false if sum is odd
        boolean oddOrEven = sum % 2 == 0;
        //PART 3
        if (oddOrEven){
            System.out.println(sum + "...is even!");
            //place an if inside to determine who wins
            if(oddsevens.equals("E")){
                System.out.println(player1 +" wins! :)");
            }else{
                System.out.println("Computer wins! :(");
            }
        }else{
            System.out.println(sum + "...is odd!");
            //repeat above for an odd win
            if(oddsevens.equals("O")){
                System.out.println(player1 +" wins! :)");
            }else{
                System.out.println("Computer wins! :(");
            }
        }
        System.out.println("--------------------");
    }
}
