/*
Sample Question 6: Cats and Dogs
Chef is a farmer and a pet lover. He has a lot of his favorite pets cats and dogs in the barn. He does
not know their exact count. But he knows that there are C cats and D dogs in the barn. Also, one day
went to field and found that there were L legs of the animals touching the ground. Chef knows that
cats love to ride on the dogs. So, they might ride on the dogs, and their legs won't touch the ground
and Chef would miss counting their legs. Chef's dogs are strong enough to ride at max two cats on
their back.
It was a cold foggy morning, when Chef did this counting. So he is now wondering whether he
counted the legs properly or not. Specifically, he is wondering is there a some possibility of his
counting being correct. Please help Chef in finding it.
Input
First line of the input contains an integer T denoting number of test cases. T test cases follow.
The only line of each test case contains three space separated integers C, D, L denoting number of
the cats, number of the dogs and number of legs of animals counted by Chef, respectively.
Output
For each test case, output a single line containing a string "yes" or "no" (both without quotes)
according to the situation.
Constraints
1 <= T <= 10^5
0 <= C, D, L <= 10^9
Example
Input:
3
1 1 8
1 1 4
1 1 2
Output:
yes
yes
no

 Explanation
Example 1. There is one cat and one dog. The number of legs of these animals on the ground are 8,
it can be possible when both cat and dog are standing on the ground.
Example 2. There is one cat and one dog. The number of legs of these animals on the ground are 4,
it can be possible if the cat will ride on the dog, so its legs won't be counted by Chef, only the dog's
legs will be counted.
Example 3. There is one cat and one dog. The number of legs of these animals are 2, it can not be
true at all, Chef might have made some mistake. Hence answer is "no".
*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case,
        2.1)take input C,D,L and check its constraints.
        2.2)find max value of legs = (C+D)*4
        2.3)find min value of legs:
            2.3.1) if C <= 2D(since 2 cats can at max be on 1 dog
                min = D*4
            2.3.2)else
                min = (C-D)*4 + D*4;

        2.4) if L is divisible by 4 and min <= L <= max
                output:yes
        2.5) output:no

 */

//Code:

#include <stdio.h>
#include<math.h>

void validateCount(int c, int d, int l);

int main() {

    int T;//number of test cases is within integer range, hence taken integer.
    printf("Please enter number of Test cases:\n");
    scanf("%d", &T);
    int c,d,l;//3 necessary user input variables

    if (T >= 1 && T <= 100000) {//checking Test case constraints

        while(T--) {//for each test case

            printf("Please enter space separated values c,d,l:\n");
            scanf("%d %d %d", &c, &d, &l);

            //checking c,d,l constraints
            if (((c >= 0 && c <= (int)pow(10, 9)) && (d >= 0 && d <= (int)pow(10, 9))) && (l >= 0 && l <= (int)pow(10, 9)))
            {
                printf("Validation for test case %d :\n",T);
                validateCount(c,d,l);
            } else {
                printf("Violation c,d,l constraints!\n");
            }
        }
    } else {
        printf("Violating Test case count constraint.\n");
    }
    return 0;
}
//function to validate the count of legs:
void validateCount(int c, int d, int l) {
    int max = (c + d)*4;//max number of legs will be total number of legs of cats and dogs
    int min = d*4;//minimum possible is when 2*number of dogs >= cats, min cannot go below this
    if (c > (d*2)) {//if cats are more than 2*d, those excess cats cannot be on top of dogs
        min = min + ((c - d)*4);
    }
    if(l % 4 == 0 && (l >= min && l<= max)) {//number of legs should be divisible by 4 be it any case
        printf("yes\n");
    } else {
        printf("no\n");
    }
}
