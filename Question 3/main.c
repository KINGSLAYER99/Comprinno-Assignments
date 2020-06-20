/*
Sample Question 3: Temple Land
The snakes want to build a temple for Lord Cobra. There are multiple strips of land that they are
looking at, but not all of them are suitable. They need the strip of land to resemble a coiled Cobra.
You need to find out which strips do so.
Formally, every strip of land, has a length. Suppose the length of the i-th strip is is N i , then there will
be N i integers, H i1 , H i2 , .. H iNi , which represent the heights of the ground at various parts of the strip,
in sequential order. That is, the strip has been divided into N i parts and the height of each part is
given. This strip is valid, if and only if all these conditions are satisfied:
There should be an unique 'centre' part. This is where the actual temple will be built. By
centre, we mean that there should be an equal number of parts to the left of this part,
and to the right of this part.
H i1 = 1
The heights keep increasing by exactly 1, as you move from the leftmost part, to the
centre part.
The heights should keep decreasing by exactly 1, as you move from the centre part to
the rightmost part. Note that this means that H iNi should also be 1.
Your job is to look at every strip and find if it's valid or not.
Input
The first line contains a single integer, S , which is the number of strips you need to look
at. The description of each of the S strips follows
The first line of the i-th strip's description will contain a single integer: N i , which is the
length and number of parts into which it has been divided.
The next line contains N i integers: H i1 , H i2 , .., H iNi . These represent the heights of the
various parts in the i-th strip.
Output
For each strip, in a new line, output "yes" if is a valid strip, and "no", if it isn't.
Constraints
1 <= S <= 100
3 <= N i <= 100
1 <= H ij <= 100
Example
 Input:
7
5
1 2 3 2 1
7
2 3 4 5 4 3 2
5
1 2 3 4 3
5
1 3 5 3 1
7
1 2 3 4 3 2 1
4
1 2 3 2
4
1 2 2 1
Output:
yes
no
no
no
yes
no
no
Explanation
In the first strip, all the conditions are satisfied, hence it is valid.
In the second strip, it does not start with a 1, and hence is invalid.
In the third strip, it keeps increasing even past the centre, instead of decreasing. Hence invalid.
The fourth strip does not increase and decrease by exactly 1. Hence invalid.
The fifth satisfies all conditions and hence is valid.
The sixth and seventh strip do not have a 'centre' part. Because for every part, there are either more
parts to its right than its left, or more parts on its left than its right. Hence both the strips are invalid.
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case,
        2.1)take input array size(N) and check its constraints.
        2.2)for 0 to n-1 array size
            2.2.1) check if N is even. if yes return invalid
            2.2.2) check if i and n-i are equal, if they are, proceed to next one, check if they are 1 more than previous
            repeat this till we reach n/2 and then stop. return valid
            if in any iteration, above condition check isnt satisfied, return "invalid"
 */

//Code:

#include <stdio.h>

int validateStrip(int* arr, int n);

int main() {

    int S;//number of strips is within integer range, hence taken integer.

    printf("Please enter number of strips:\n");
    scanf("%d", &S);
    int n;//array size

    if (S >= 1 && S <= 100) {//checking Test case constraints

        while(S--) {//for each test case

            printf("Please enter length (N):\n");
            scanf("%d", &n);

            //checking n constraints
            if ((n >= 3) && (n <= 100))
            {
                int arr[n];//values of Hij
                int temp;
                printf("Enter Space separated integers of Hij values:\n");
                for (int i = 0; i < n; i++) {
                    scanf("%d%*c", &temp);
                    if (temp >= 1 && temp <= 100) {//checking if the value is within the array value constraints
                        arr[i] = temp;//if yes, storing the value to array
                    }
                }

                printf("Validation for test case %d :\n",S);
                int result = validateStrip(arr, n);
                if (result == 0) {
                    printf("no\n");
                }
                else {
                    printf("yes\n");
                }
            } else {
                printf("Violation of length(N) constraint!\n");
            }
        }
    } else {
        printf("Violating Strip count constraint.\n");
    }
    return 0;
}
//function to validate Hij
int validateStrip(int* arr, int n) {
    if (n % 2 == 0) {//for center to be unique, n should be odd
        return 0;// return 0 means invalid(no)
    }
    if (arr[n/2] != (n/2 + 1)) {//since Hij starts from 1, center will always have value n/2 + 1;
        return 0;
    }
    for (int i = 0; i < (n/2); ++i) {//for rest of elements, if arr[i] & arr[n-1-i] are equal and have value i+1, they are correct
        if (arr[i] != arr[n - 1 - i] || arr[i] != i + 1) {//if not, return 0(invalid i.e "no")
            return 0;
        }
    }
    //if no errors till now, return yes.
    return 1;
}
