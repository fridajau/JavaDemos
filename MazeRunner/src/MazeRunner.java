/*
Started on October 23, 2018 || Frida Jauregui
Final Project
write the code that uses Maze and decides how to move through it.
 */

import java.util.*;
//PART1
//let the user solve the maze
public class MazeRunner {
    //crete a new maze
    static Maze myMap = new Maze();
    static Scanner input = new Scanner(System.in);
    static int moves = 0;


    public static void main(String[] args) {
        intro();
        while (!myMap.didIWin()) {
            userMove();
            if (moves == 100)
                return;
        }
        System.out.println("Congratulations, you made it out alive! And you did it in " + moves +" moves");

    }

    //PART1
    public static void intro() {
        //welcome the user to the map
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static String userMove() {
        System.out.print("Where would you like to move? (R, L, U, D): ");
        String direction = input.next();
        //if statements
        if (direction.equals("R") || direction.equals("L") || direction.equals("U") || direction.equals("D")) {
            // Returns true if the space to the right is free, false if there is a wall
            if (myMap.canIMoveRight() == true && direction.equals("R")) {
                myMap.moveRight();
                myMap.printMap();
            }
            // Returns true if the space to the left is free, false if there is a wall
            else if (myMap.canIMoveLeft() == true && direction.equals("L")) {
                myMap.moveLeft();
                myMap.printMap();
            }
            // Returns true if the space above is free, false if there is a wall
            else if (myMap.canIMoveUp() == true && direction.equals("U")) {
                myMap.moveUp();
                myMap.printMap();
            }
            // Returns true if the space below is free, false if there is a wall
            else if (myMap.canIMoveDown() == true && direction.equals("D")) {
                myMap.moveDown();
                myMap.printMap();
            }
            //hitting a wall
            else {
                if ((myMap.canIMoveDown() == false && myMap.canIMoveUp() == false &&
                        myMap.canIMoveLeft() == false && myMap.canIMoveRight() == false)) {
                    myMap.printMap();
                    System.out.println("Sorry, you've hit a wall.");
                    System.out.print("Where would you like to move? (R, L, U, D): ");
                    direction = input.next();
                    myMap.printMap();
                }
            }

        }
        return direction;
    }

    //PART2
    public static void movesMessage(int moves){
       //add limitation with limited steps
        if (moves == 50)
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
        else if (moves == 75)
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        else if (moves == 90)
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        else if (moves == 100)
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
    }

    //PART3
    public static void navigatePit(String direction){
        //let user know of pits
        if (myMap.isThereAPit(direction)){
            System.out.print("Watch out! There's a pit ahead, jump it? (Y/N): ");
            String choice = input.next();
            if (choice.equals("y") || choice.equals("Y"))
                myMap.jumpOverPit(direction);
                myMap.printMap();
            //myMap.isThereAPit("R") // Takes in the direction String the user entered in and returns if there is a pit ahead
            //myMap.jumpOverPit("L") // Will jump over a pit in the direction given, skipping that space and landing 2 spaces over in the direction specified.
        }
    }
}
