/*
Sample Question 8: Two Numbers
Alice and Bob are playing a game. Alice initially has the number A and Bob has the number B .
There are a total of N turns in the game, and Alice and Bob alternatively take turns. In each turn the
player whose turn it is, multiplies his or her number by 2. Alice has the first turn.
Suppose after all the N turns, Alice's number has become C and Bob's number has become D . You
want to calculate the integer division of the maximum number among C and D by the minimum
number among C and D
Input
The first line of the input contains an integer T denoting the number of test cases. The
description of each test case follows.
Each test case contains a single line with 3 integers A , B , and N .
Output
For each test case output a new line with a single integer which should be the answer.
Constraints
1 <= T <= 100
1 <= A <= 1000000000
1 <= B <= 1000000000
1 <= N <= 1000000000
Example
Input:
3
1 2 1
3 2 3
3 7 2
Output:
1
3
2
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case, take input A,B,N and check their constraints.
 (if we go by brute force, we will face overflow for higher values of A,B and N)
    2.1) Since we know that its alternate multiplication, we will check remainder of N with 2. If its odd, multiply 2 to A.
        If its even, do nothing.
    2.2) Now, check greater value among the 2, and lesser value among them, and divide and produce the answer.
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

        int a,b,n;//variables needed for user input
        if (T >= 1 && T <= 100) {//checking Test case constraints
            while (T-- > 0) {//for each test case
                System.out.println("Please enter A,B,N as space separated characters:");
                a = scanner.nextInt();
                b = scanner.nextInt();
                n = scanner.nextInt();

                //checking if a,b,n are within constraints
                if ((1 <= a && a <= 1000000000) && ((1 <= b && b <= 1000000000) && (1 <= n && n <= 1000000000))){
                    if ((n & 1) == 1) {//if n is odd, rest all powers of 2 will get cancelled in final division and only this will remain
                        a = a * 2;
                    }
                    int result = (Math.max(a, b))/(Math.min(a, b));//result based on the logic given in question
                    System.out.println("Answer of Integer Division is:");
                    System.out.println(result);
                } else {
                    System.out.println("A,B,N constraints violated!");
                }
            }
        }else {
            System.out.println("Violating Test case count constraint.");
        }
    }
}
