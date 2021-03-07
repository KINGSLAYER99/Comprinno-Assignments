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
7
abc
aaabbccddeeffggggg
ppppmmnnoooopp
aabbcc
abbbcccdddd
aaaaaaaaaaaaaaaabbbbbb
aaaabbbb

Sample Output:
Not
Dynamic since f(g) = f(b) + f(a) for C= {c,d,e,f,a,b,g}
Dynamic since f(p) = f(o) + f(n) for C= {m,o,n,p}
Not
Dynamic since f(d) = f(b) + f(a) for C= {c,a,b,d}
Dynamic since unique < 3
Dynamic since unique < 3
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case,
    2.1) input character string from user. Validate its size according to constraints
    2.2) if the size <=2, there will be <3 unique characters, hence it will be dynamic
    2.3)if not,convert string to character array, create Int array of size of lower case alphabets count(26), check the occurence of each alphabet in the input string and update it in that int Array
    2.4)Remove all those values which are 0 in that array, and put the rest of values to Arraylist. if arraylist size <= 2, it means number of unique characters < 3, hence return "Dynamic"
    2.5) If not, check if for every i from 0 to arraylist size -2,
    		for every j from i+1 to arraylist size -1,
    		    for every k from j+1 to arraylist size
			if arraylist[i] + arraylist[j] == arraylist[k]. If yes, its dynamic
    2.6) for entire arraylist if the above condition doesnt satisfy return "Not"

 */

//Code:
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

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
                        if (input.length() <= 2) {//number of characters < 3
                            System.out.println("Dynamic");
                        }
                        else {
                            char[] userString = input.toCharArray();//for faster operations
     // since only lower case letters are gonna be used, hence constructing an int array of that size to store count of each lower case character
                            int[] occurences = new int[26]; 
     // For each character in character array, update the character's occurence count in "occurences" array.
                            for (int i = 0; i < userString.length; i++) {
                                occurences[userString[i] - 97]++;
                            }
     // Sort this finite array, this is better as it avoids sorting the entire string of size 10^5, it will always sort this finite size
                            Arrays.sort(occurences);//so that counting of occurences of all characters becomes easy
                            String result = validateDynamic(occurences);
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
    private static String validateDynamic(int[] occurences) {
        ArrayList<Integer> occurenceCount = new ArrayList<Integer>();
        // Some indexes may have 0 value as those characters may not exist in the input string, hence removing them, and adding rest to ArrayList
        for (int i = 0; i < 26; i++) {
            if (occurences[i] != 0) {
                occurenceCount.add(occurences[i]);
            }
        }
//             System.out.println(occurenceCount); 
//             System.out.println(occurenceCount.size()); 

             if (occurenceCount.size() <= 2) {//number of unique characters < 3
                 return  "Dynamic";
             }

// Extra Optimization
// This arraylist contains only Occurence Counts which are not repeated more than twice, since if those occurences are repeated lets say for 3 times, x != x+x any time, and more than 2 x's aren't needed for comparison with rest of the Occurence Counts             
        ArrayList<Integer> adjustedCount = new ArrayList<Integer>();
        // Traverse through the first list 
        int maximum = 1;
        for (Integer element : occurenceCount) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!adjustedCount.contains(element)) { 
  
                adjustedCount.add(element);
                maximum = 1;
            } 
            // Only add it if only 1 duplicate exists, so if counts are 4,2,2,2,2,3 it will add 4,2,2,3 only
            else if (adjustedCount.contains(element) && maximum == 1) { 
  
                adjustedCount.add(element);
                maximum = 2;
            } 
        }
//        System.out.println(adjustedCount); 

// check every index with every other index of this finite size ArrayList. This covers all permutations
        occurenceCount = adjustedCount;
        for (int i = 0; i < occurenceCount.size() - 2; i++) {
            for (int j = i + 1; j < occurenceCount.size() - 1; j++) {
                for (int k = j + 1; k < occurenceCount.size(); k++) {
//		     System.out.println("i:" + occurenceCount.get(i) + " j:" + occurenceCount.get(j) + " k:" + occurenceCount.get(k)); 
                    if ((occurenceCount.get(i) + occurenceCount.get(j)) == occurenceCount.get(k)) {//fibonacci formula
                        return "Dynamic";
                    }
                }
            }
        }
        return "Not";//formula wasn't applied, thus not dynamic
    }

}

