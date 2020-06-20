/*
Sample Question 4: Bear and Milky Cookies
Limak is a little polar bear, who loves eating cookies and drinking milk. For this reason he often visits
Chef's kitchen.
Limak is going to spend N minutes in the kitchen. Each minute he either eats a cookie or drinks milk.
Cookies are very sweet and thus Limak's parents have instructed him, that after eating a cookie, he
has to drink milk in the next minute.
You are given whether he ate a cookie or drank milk in each of the N minutes. Your task is to check
if Limak followed his parents' instructions. That is, you need to verify whether after each eaten
cookie he drinks milk in the next minute. Print "YES" or "NO" for each test case accordingly.
Input
The first line of the input contains an integer T denoting the number of test cases. The description of
T test cases follows.
The first line of each test case contains an integer N denoting the number of minutes.
The second line of a test case contains N space-separated strings S 1 , S 2 , ..., S N . The string S i is
either "cookie" (if Limak eats a cookie in the i-th minute) or "milk" (otherwise).
Output
For each test case, output a single line containing the answer — "YES" if Limak followed his parents'
instructions, and "NO" otherwise, both without the quotes.
Constraints
1 <= T <= 50
1 <= N <= 50
Each S[i] is either "cookie" or "milk" (without the quotes)
Example
Input:
4
7
cookie milk milk cookie milk cookie milk
5
cookie cookie milk milk milk
4
milk milk milk milk
1
cookie
Output:
YES
NO
YES
NO
Explanation
Test case 1. Limak is in the kitchen for 7 minutes. He eats three cookies and after each of them he
indeed drinks milk in the next minute. The answer is "YES".
Test case 2. Limak is in the kitchen for 5 minutes. In the first minute he eats a cookie and in the
second minute he eats a cookie again, instead of drinking milk. The answer is "NO".
Test case 3. Here Limak doesn't eat any cookies. The answer is "YES" because the condition is
satisfied (there is no situation when Limak eats a cookie but doesn't drink milk in the next minute).
Test case 4. Limak eats a cookie and doesn't drink milk in the next minute so the answer is "NO".
Comprinno Technologies
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case, take input array size and check its constraints.
    2.1) for range 0 to n-1, take array values from user
    2.2) for that array, for every occurence of "cookie", check if next index exists and is "milk", if not
            return the loop with answer "no"
    2.3) if loop ends, return "yes"
 */

//Code:
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //number of test cases is within integer range, hence taken integer.
        //System.out.println("Please enter number of Test cases:");
        int T = scanner.nextInt();//user input for test cases
        int n;//variables needed for user input
        if (T >= 1 && T <= 50) {//checking Test case constraints

            while (T-- > 0) {//for each test case
                //System.out.println("Please enter size of array (N):");
                n = scanner.nextInt();
                if (n >= 1 && n <= 50) {

                    scanner.nextLine();//so that all the spaces of integer line gets eliminated
                    //System.out.println("Please enter array values as space separated characters:");
                    String[] input = scanner.nextLine().split(" ");
                    String result = validateCookieInstruction(input);
                    System.out.println(result);

                } else {
                    System.out.println("Violating array size constraints!");
                }
            }
        }else {
            System.out.println("Violating Test case count constraint.");
        }
    }

    //this function checks if limak followed the instruction or not
    private static String validateCookieInstruction(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i].equalsIgnoreCase("cookie")) {//if cookie occurence
                if ((i + 1) >= input.length) {//no next element possible, then instruction not followed
                    return "no";
                }
                else {
                    if (!input[i+1].equalsIgnoreCase("milk")) {//next thing isnt milk, then instruction not followed
                        return "no";
                    }
                }
            }
        }
        return "yes";//no problems in entire loop, hence, instruction was followed
    }
}
