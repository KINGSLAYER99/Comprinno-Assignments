/*Sample Question 10: Gross Salary
In a company an employee is paid as under: If his basic salary is less than Rs. 1500, then HRA =
10% of base salary and DA = 90% of basic salary.
If his salary is either equal to or above Rs. 1500, then HRA = Rs. 500 and DA = 98% of basic salary.
If the Employee's salary is input, write a program to find his gross salary.
NOTE: Gross Salary = Basic Salary + HRA + DA
Input
The first line contains an integer T , total number of test cases. Then follow T lines, each line contains
an integer salary .
Output
Output the gross salary of the employee. Your answer will be considered correct if the absolute error
is less than 10 -2 .
Constraints
1 <= T <= 1000
1 <= salary <= 100000
Example
Input
3
1203
10042
1312
Output
2406.00
20383.16
2624*/

//Pseudocode:
/*
 1) take input the test cases and check constraint.
 2) for every test case, take input the basic salary and check its constraints.
 3) now, check if the salary is <1500 if yes, apply the salary structure for that condition
 4) if no, apply other salary structure.
 5) now with all data available for calculating grossSalary, calculate with given formula and print the result
  for upto 2 decimal places.
 */

//code:

#include <stdio.h>
float calculateGrossSalary(int salary);//function declaration for C compiler to know that it will encounter this function definition below
int main() {

    int T;//number of test cases is within integer range, hence taken integer.
    //printf("Please enter number of Test cases:\n");
    scanf("%d", &T);
    int salary;
    if (T >= 1 && T <= 1000) {//checking Test case constraints
        while(T--) {//for each test case
            //printf("Please enter base salary:\n");
            scanf("%d", &salary);
            if (salary >= 1 && salary <= 100000) {//checking salary constraints
                printf("Gross Salary is:\n");
                printf("%.2f\n", calculateGrossSalary(salary));
            } else {
                printf("Violating salary constraints!\n");
            }
        }
    } else {
        printf("Violating Test case count constraint.\n");
    }
    return 0;
}

//this function calculates gross salary for given salary for the formula and logic provided.
float calculateGrossSalary(int salary) {
    /*
     * declaring required variables. We can solve directly without variable also,
     * but its better to include variables for better code quality
    */
    float hra, da, grossSalary;
    if (salary < 1500) {//logic constraint 1
       hra = (0.1)*salary;
       da = (0.9)*salary;
    } else {
        hra = 500;
        da = (0.98)*salary;
    }
    grossSalary = salary + hra + da;//formula
    return grossSalary;
}
