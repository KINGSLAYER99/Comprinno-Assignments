/*
Sample Question 5: Beautiful Array
An array a is called beautiful if for every pair of numbers a i , a j , ( i ≠ j ), there exists an a k such that a k =
a i * a j . Note that k can be equal to i or j too. Find out whether the given array a is beautiful or not!
Input
First line of the input contains an integer T denoting the number of test cases. T test cases follow.
First line of each test case contains an integer n denoting number of elements in a .
Next line contains n space separated integers denoting the array a .
Output
For each test case, output a single line containing "yes" or "no" (without quotes) corresponding to the
answer of the problem.
Constraints
1 <= T <= 10^6
1 <= n <= 10^5
Sum of n over all the test cases <= 10^6
-10^9 <= a[i] <= 10^9
Example
Input
3
2
0 1
2
1 2
2
5 6
Output:
yes
yes
no
Test case 1. If you multiply 0 with 1, you get 0, we see that a 0 = 0 . So, the array is beautiful.
Test case 2. If you multiply 5 with 6, you get 30, there does not exist an k such that a k = 30 . So, the
array is not beautiful .
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case, take input array size and check its constraints.
    2.1) for range 0 to n-1, take array values from user and check for constraints and then add to array as well as hashmap.
    2.2) for that array, check each pair of values to see if their multiplication > 10^9. if it is, then discard that pair
     if not, check to see if the multiplication is present in hashmap
    2.2) if present in hashmap, break the loop and return yes
    2.3) if entire loop is traversed return "no";
 */

//Code:
import java.util.HashSet;
import java.util.Scanner;

class BeautifulArray {
    boolean incorrect;
    int[] arr;
    HashSet<Integer> hash;
    public BeautifulArray(int n) {
        incorrect = false;
        arr = new int[n];
        hash = new HashSet<>();
    }

    public void acceptInputs(int value, int i) {
        
            if (value >= (int)Math.pow(10, -9) && value <= (int)Math.pow(10, 9)) {//if array value is within range
                arr[i] = value;
                hash.add(value);//add all unique array values to hashset
            }
            else {
                System.out.println("Array values not within constraints!");
                incorrect = true;
            }
        }

    public String validateBeautiful() {
        long multiplication;//since multiplication in worst case can be 10^18, but hashset will never have value outside of constraints

        //for each pair, if multiplication is within constraint, check in hashset if value of multiplication exists, if yes-output yes and break
        //if no, keep checking till entire loop
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                multiplication = (arr[i])*(arr[j]);
                if ((multiplication >= (int)Math.pow(10,-9)) && (multiplication <= (int)Math.pow(10,9))) {
                    if (hash.contains((int)multiplication)) {
                        return "yes";
                    }
                }
            }
        }
        return "no";
    }
}

public class Controller {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //number of test cases is within integer range, hence taken integer.
        System.out.println("Please enter number of Test cases:");
        int T = scanner.nextInt();//user input for test cases
        //scanner.nextLine();//so that all the spaces of integer line gets eliminated

        int n;//variables needed for user input
        if (T >= 1 && T <= 100) {//checking Test case constraints

            while (T-- > 0) {//for each test case
                //System.out.println("Please enter size of array (N):");
                n = scanner.nextInt();
                if (n >= 2 && n <= (int)Math.pow(10,5)) {
                    BeautifulArray beautifulArrayobj = new BeautifulArray(n);//initialzing object

                    System.out.println("Please enter array values as space separated characters:");
                    for (int i = 0; i < n; i++) {
                        int value = scanner.nextInt();
                        beautifulArrayobj.acceptInputs(value, i);
                        if (beautifulArrayobj.incorrect) {
                            break;
                        }
                    }
                    if (!beautifulArrayobj.incorrect) {//if all constraints are satisfied
                        String result = beautifulArrayobj.validateBeautiful();
                        System.out.println(result);
                    }
                } else {
                    System.out.println("Violating array size constraints!");
                }


            }
        }else {
            System.out.println("Violating Test case count constraint.");
        }
    }
}
