/*
Sample Question 11: Id and Ship
Write a program that takes in a letter class ID of a ship and display the equivalent string class
description of the given ID. Use the table below.
Class ID Ship Class
B or b BattleShip
C or c Cruiser
D or d Destroyer
F or f Frigate
Input
The first line contains an integer T , total number of test cases. Then follow T lines, each line contains
a character.
Output
Display the Ship Class depending on ID.
Constraints
1 <= T <= 1000
Example
Input
3
B
c
D
Output
BattleShip
Cruiser
Destroyer
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case, take input the character(the ship ID) and check its constraints.
 3) now, check if user has entered character only.
    3.1)If yes, check if it belongs to the set defined in question.
           3.1.1)if it belongs, output the answer. If not, ship ID doesnt exist.
    3.2) if no, its not a character so ID doesnt exist
 */

//Code:
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //number of test cases is within integer range, hence taken integer.
        System.out.println("Please enter number of Test cases:");
        int T = scanner.nextInt();//user input for test cases
        scanner.nextLine();//so that all the spaces of integer line gets eliminated
        if (T >= 1 && T <= 1000) {//checking Test case constraints
            while (T-- > 0) {//for each test case
                System.out.println("Please enter character:");
                String input = scanner.nextLine();
                input = input.toLowerCase();//converting to lowerCase to make comparison easy
                if (input.length() == 1) {//checking if the input is character
                
                System.out.println("Ship class for "+ input.charAt(0) + " is:");
                
                    if (input.charAt(0) == 'b') {
                        System.out.println("BattleShip");
                    }
                    else if (input.charAt(0) == 'c') {
                        System.out.println("Cruiser");
                    }
                    else if (input.charAt(0) == 'd') {
                        System.out.println("Destroyer");
                    }
                    else if (input.charAt(0) == 'f') {
                        System.out.println("Frigate");
                    }
                    else {
                        System.out.println("character(ID) given doesn't belong to any ship class!");
                    }

                } else {
                    System.out.println("Please input a character only!");
                }
            }
        }else {
            System.out.println("Violating Test case count constraint.");
        }
    }
}
