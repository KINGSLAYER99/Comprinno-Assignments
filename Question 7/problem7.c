/*
Sample Question 7: Sticks
Chef and his little brother are playing with sticks. They have total N sticks. Length of i-th stick is
Ai. Chef asks his brother to choose any four sticks and to make a rectangle with those sticks its
sides. Chef warns his brother to not to break any of the sticks, he has to use sticks as a whole.
Also, he wants that the rectangle formed should have the maximum possible area among all the
rectangles that Chef's brother can make.
Chef's little brother takes this challenge up and overcomes it. Can you also do so? That is, you
have to tell whether it is even possible to create a rectangle? If yes, then you have to tell the
maximum possible area of rectangle.
Input
The first line contains a single integer T denoting the number of test-cases. T test cases follow.
The first line of each test case contains a single integer N denoting the number of sticks.
The second line of each test case contains N space-separated integers A 1 , A 2 , ..., A N denoting the
lengths of sticks.
Output
For each test case, output a single line containing an integer representing the maximum possible
area for rectangle or -1 if it's impossible to form any rectangle using the available sticks.
Constraints
1 <= T <= 100
1 <= N <= 10^3
1 <= sum of N 's over all test-cases in a single test file <= 10^3
1 <= A[i] <= 10^3
Example
Input:
2
5
1 2 3 1 2
4
1 2 2 3
Output:
 2
-1
Explanation
Example case 1. Chef's brother can choose sticks of lengths 1, 2, 1, 2. He can create a rectangle
with area 1 * 2 = 2.
Example case 2. It's impossible to choose 4 sticks so that they form a rectangle.
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case,
        2.1)take array size as input and check its constraints.
        2.2) accept values of array and check for constraints
        (Since constraints are low, I am using bubble sort to sort the array)
        2.3) Sort the array in decending order

        2.4) go through entire array to find 2 pairs of elements starting from 0th index. If 2 pairs exist:
            2.4.1)Take 1st pair's value of a element as A, 2nd pair's B and multiply them to find the resultant maximum area.
        2.5)else return -1 as rectangle cant be formed

 */

//Code:

#include <stdio.h>
#include<math.h>
void bubbleSort(int* arr, int n) {//function that sorts array in decending order
    int swap;
    for (int i = 0; i < n - 1; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if (arr[i] < arr[j]) {
                swap = arr[j];
                arr[j] = arr[i];
                arr[i] = swap;
            }
        }
    }
}
/*
 * function that calculates max area by finding 2 pairs which will be length and breath pairs of rectangle respectively
 */
int calculateMaxArea(int* arr, int n) {
    int i;
    int a = 0, b = 0;//length of sides of rectangle if they exist
    for (i = 0; i < n - 1; ++i) {
        if (arr[i] == arr[i + 1]) {
            if (a == 0) {// this means even first pair isn't filled
                a = arr[i];
                i = i + 1;
            } else if (b == 0) {// first pair done, second to be done now
                b = arr[i];
                i = i + 1;
                break;
            }
        }
    }
    if ((i == n - 1) && ( a == 0 || b == 0)) {//entire array traversed but 2 pairs not formed, so rectangle not possible
        return -1;
    }
    return a*b;
}
int main() {

    int T;//number of test cases is within integer range, hence taken integer.

    printf("Please enter number of Test cases:\n");
    scanf("%d", &T);
    int n;//array size
    int temp;//variable to check array value constraints before adding values to array
    int area;//variable to store the minimum cost

    if (T >= 1 && T <= 100) {//checking Test case constraints

        while(T--) {//for each test case

            printf("Please enter array size:\n");
            scanf("%d", &n);

            if (n >= 1 && n <= 1000) {//checking array size constraints
                int arr[n];//array of size n

                printf("Enter Space separated integers of array values:\n");
                int flag = 0;
                for (int i = 0; i < n; i++) {
                    scanf("%d%*c", &temp);
                    if (temp >= 1 &&
                        temp <= (int) pow(10, 3)) {//checking if the value is within the array value constraints
                        arr[i] = temp;//if yes, storing the value to array

                    } else {
                        printf("array value violating constraints");
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    bubbleSort(arr, n);
                    area = calculateMaxArea(arr, n);
                    printf("Maximum area is:\n");
                    printf("%d\n", area);
                }
            } else {
                printf("Violating array size constraints!\n");
            }
        }
    } else {
        printf("Violating Test case count constraint.\n");
    }
    return 0;
}
