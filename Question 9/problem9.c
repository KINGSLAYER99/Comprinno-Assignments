/*
Sample Question 9: Minimum Maximum
Chef loves to play with arrays by himself. Today, he has an array A consisting of N distinct integers.
He wants to perform the following operation on his array A .
Select a pair of adjacent integers and remove the larger one of these two. This
decreases the array size by 1. Cost of this operation will be equal to the smaller of them.
Find out minimum sum of costs of operations needed to convert the array into a single element.
Input
First line of input contains a single integer T denoting the number of test cases. First line of each test
case starts with an integer N denoting the size of the array A . Next line of input contains N space
separated integers, where the i th integer denotes the value A i .
Output
For each test case, print the minimum cost required for the transformation.
Constraints
1 <= T <= 10
2 <= N <= 50000
1 <= A[i] <= 10^5
Example
Input
2
2
3 4
3
4 2 5
Output
3
4
Explanation
Test 1 : Chef will make only 1 move: pick up both the elements (that is, 3 and 4), remove the larger
one (4), incurring a cost equal to the smaller one (3).
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case,
        2.1)take array size as input and check its constraints.
        2.2) for range 0 to N-1,
            2.2.1)take space separated input of integers.
            check for its constraints. If satisfies, copy it to array, if not, exit the code and print error.
        2.3) go through entire array to find minimum element.
(we will consider the logic where every pair we select will have this minimum element present,
 and the larger gets eliminated everytime, hence, at the end only this min element remains.
 If the array has 3(n) elements, total pairs with this min element will be 2(n-1).
 So the answer will be minElement*(n-1).
        2.4) output the answer as minElement*(n-1)
        (in the worst case, all values of A[i] can be 10^5 and (N-1) = 5*10^4,
        so the multiplication still results in integer value if integer size is 4Bytes)


 */

//Code:

#include <stdio.h>
int main() {

    int T;//number of test cases is within integer range, hence taken integer.

    printf("Please enter number of Test cases:\n");
    scanf("%d", &T);
    int n;//array size
    int minElement = 1000000; //variable which will store the minimum element of the array.
    int temp;//temporary variable to store user array value input for constraint checking
    int result;//variable to store the minimum cost

    if (T >= 1 && T <= 10) {//checking Test case constraints

        while(T--) {//for each test case

            printf("Please enter array size:\n");
            scanf("%d", &n);

            if (n >= 2 && n <= 50000) {//checking array size constraints
                int arr[n];//array of size n

                printf("Enter Space separated integers of array values:\n");
                for (int i = 0; i < n; i++) {
                    scanf("%d%*c", &temp);
                    if (temp >= 1 &&  temp <= 10^5) {//checking if the value is within the array value constraints
                        arr[i] = temp;//if yes, storing the value to array
                        if (temp < minElement) {//calculating the minElement in the same loop
                            minElement = temp;
                        }
                    } else {
                        printf("array value violating constraints");
                        break;
                    }
                }
                result = minElement*(n - 1);//formula stated in pseudocode

                printf("Minimum cost is:\n");
                printf("%d\n", result);
            } else {
                printf("Violating array size constraints!\n");
            }
        }
    } else {
        printf("Violating Test case count constraint.\n");
    }
    return 0;
}