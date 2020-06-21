/*
Sample Question 1: Fibonacci Series
For a string S let the unique set of characters that occur in it one or more times be C. Consider a
permutation of the elements of C as (c1,c2,c3...) Let f(c) be the number of times c occurs in S.
If any such permutation of the elements of C satisfies f(ci)=f(ci−1)+f(ci−2) for all i≥3, the string is
said to be a dynamic string.
Mr Bancroft is given the task to check if the string is dynamic, but he is busy playing with
sandpaper. Would you help him in such a state?
Note that if the number of distinct characters in the string is less than 3, i.e. if |C|<3, then the
string is always dynamic.
Input:
First line will contain T, number of testcases. Then the testcases follow.
Each testcase contains of a single line of input, a string S.
Output:
For each testcase, output in a single line "Dynamic" if the given string is dynamic, otherwise
print "Not". (Note that the judge is case sensitive)
Constraints
1 <= T <= 10
1 <= |S| <= 10^5
S contains only lower case alphabets: a, b, …, z
Sample Input:
3
aaaabccc
aabbcc
ppppmmnnoooopp
Sample Output:
Dynamic
Not
Dynamic
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case,
    2.1) input character string from user. Validate its size according to constraints
    2.2) if the size <=2, there will be <3 unique characters, hence it will be dynamic
    2.3)if not,convert string to character array, sort the array, check the occurence of each unique character
    and store that occurence count of each character in arraylist. Sort the arraylist
    2.4) if arraylist size <= 2, it means number of unique characters < 3, hence return "Dynamic"
    2.5) else, check if arraylist[i] + arraylist[i+1] == arraylist[i + 2]. If yes, its dynamic
    2.6) for entire arraylist if the above condition doesnt satisfy return "Not"

 */

//Code:
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //number of test cases is within integer range, hence taken integer.
        System.out.println("Please enter number of Test cases:");
        int T = scanner.nextInt();//user input for test cases
        if (T >= 1 && T <= 10) {//checking Test case constraints

            while (T-- > 0) {//for each test case
                System.out.println("Enter the String:");
                    String input = scanner.next();
                    if (input.length() >= 1 && input.length() <= 100000) {//checking String size constraints
                        if (input.length() <= 2) {//number of unique characters < 3
                            System.out.println("Dynamic");
                        }
                        else {
                            char[] userString = input.toCharArray();//for faster operations
                            Arrays.sort(userString);//so that counting of occurences of all characters becomes easy
                            String result = validateDynamic(userString);
                            System.out.println(result);
                        }

                    }
                    else {
                        System.out.println("String length not within constraints");
                    }

            }
        }else {
            System.out.println("Violating Test case count constraint.");
        }
    }

    //function validates if string is dynamic or not
    private static String validateDynamic(char[] userString) {
        ArrayList<Integer> occurenceCount;
             occurenceCount = generateOccurenceCount(userString);
             if (occurenceCount.size() <=2) {//number of unique characters < 3
                 return  "Dynamic";
             }
        for (int i = 0; i < occurenceCount.size() - 2; i++) {
            if ((occurenceCount.get(i) + occurenceCount.get(i + 1)) == occurenceCount.get(i + 2)) {//fibonacci formula
                return "Dynamic";
            }
        }
        return "Not";//formula wasn't applied, thus not dynamic
    }

    private static ArrayList<Integer> generateOccurenceCount(char[] userString) {
        ArrayList<Integer> occurenceCount = new ArrayList<>();
        int count = 0;
        char current = userString[0];
        for (char c : userString) {
            if (c == current) {//it means, I am counting the same character
                count++;
            } else {
                /*this is different character than previous, which means all occurences of previous character are done.
                So, store the occurenceCount of previous character before starting with new character
                */
                occurenceCount.add(count);
                current = c;//store this new character to compare it for further occurences
                count = 1;//this is the first occurence, hence count is 1
            }
        }
        occurenceCount.add(count);//storing the last character occurence count
        Collections.sort(occurenceCount);//sorting to recognise the fibonacci permutation in the arraylist
        return occurenceCount;
    }
}
