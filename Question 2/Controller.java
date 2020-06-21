/*
Sample Question 2: Ordering teams
In ACM-ICPC contests, there are usually three people in a team. For each person in the team,
you know their scores in three skills - hard work, intelligence and persistence.
You want to check whether it is possible to order these people (assign them numbers from 1 to
3) in such a way that for each 1 ≤ i ≤ 2, i+1-th person is strictly better than the i-th person.
A person x is said to be better than another person y if x doesn't score less than y in any of the
skills and scores more than y in at least one skill.
Determine whether such an ordering exists.
Input
The first line to the input contains an integer T denoting the number of test cases.
Each test consists of three lines. Each of these lines contains three space separated integers s 1 , s 2
and s 3 denoting the scores of one member of the team in each of the three skills, in the given order.
Output
For each test case, output a single line containing "yes" if such an ordering exists or "no" if doesn't
exist (without quotes).
Constraints
● 1 ≤ T ≤ 1000
● 1 ≤ s 1 , s 2 , s 3 ≤ 100
Example
Input
3
1 2 3
2 3 4
2 3 5
1 2 3
2 3 4
2 3 4
5 6 5
1 2 3
2 3 4
Output
yes
no
yes
Explanation
Test Case 1 : We can order them as (3, 2, 1). Person 3 is better than Person 2 because his scores in
the first two skills are not lesser than Person 2's. And in skill 3, Person 3 scores higher. Similarly,
Person 2 is better than Person 1. He scores more than Person 1 in every skill, in fact.
*/

//Pseudocode:
/*
0) Create class Student with the 3 characteristics of students as integers.
    create getters, and constructor to initialize them.
   Create 3 sorting classes which implement concerned characteristic comparator
 1) take input the test cases and check constraint.
 2) for every test case,
    2.1) take 3*3 matrix input from user. Check for constraints of the values of matrix.
    2.2) if constraints are valid, create a list of 3 students based on value of each row of matrix
    2.3) create comparators for each of the characteristics
    2.4)Sort the list based on any order of usage of 3 comparators
    2.5) now, between every pair of Student objects from the list, check
        the sum of difference of characteristics of i+1th and ith student.
        If the sum isn't positive, then the ordering we need isn't possible. Return "no".
    2.6) if pair comparison loop ends that means order is satisfied, hence return "yes"

 */

//Code:
import java.util.*;
//since all test cases have students with 3 characteristics, This class represents each student
class Student implements Comparable<Student> {

    //3 necessary user input variables
    private final int hardwork;
    private final int intelligence;
    private final int persistence;

    //getters
    public int getHardwork() {
        return hardwork;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getPersistence() {
        return persistence;
    }

    //constructor which sets value of characteristics of students
    public Student(int[] arr) {
        this.hardwork = arr[0];
        this.intelligence = arr[1];
        this.persistence = arr[2];
    }
    //no need to use this method
    @Override
    public int compareTo(Student o) {
        return 0;
    }
    //since this is Student obj(user Defined), if we wish to print the object, we need to override default toString method
    @Override
    public String toString() {
        return "\nEmployee [hardwork=" + hardwork + ", intelligence=" + intelligence + ", persistence=" + persistence + "]";
    }
}

//class that compares 2 student object based on their hardwork characteristic
class HardworkSorter implements Comparator<Student>
{
    public int compare(Student o1, Student o2)
    {
        return o1.getHardwork()- o2.getHardwork();
    }
}

//class that compares 2 student object based on their intelligence characteristic
class IntelligenceSorter implements Comparator<Student>
{
    public int compare(Student o1, Student o2)
    {
        return o1.getIntelligence() - o2.getIntelligence();
    }
}

//class that compares 2 student object based on their persistence characteristic
class PersistenceSorter implements Comparator<Student>
{
    public int compare(Student o1, Student o2)
    {
        return o1.getPersistence() - o2.getPersistence();
    }
}

public class Controller {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //number of test cases is within integer range, hence taken integer.
        System.out.println("Please enter number of Test cases:");
        int T = scanner.nextInt();//user input for test cases
        if (T >= 1 && T <= 1000) {//checking Test case constraints
            int[][] arr = new int[3][3];//3 students with 3 characteristics
            int temp;
            boolean incorrect = false;
            while (T-- > 0) {//for each test case
                System.out.println("Enter student scores in 3 domains:");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        temp = scanner.nextInt();
                        if (temp >= 1 && temp <= 100) {
                            arr[i][j] = temp;
                        } else {
                            incorrect = true;
                            break;
                        }
                    }
                }
                if (!incorrect) {//if constraints are satisfied
                    String result = validateOrdering(arr);
                    System.out.println(result);
                } else {
                        System.out.println("Student Characteristics values not within constraints");
                    }
            }
        }else {
            System.out.println("Violating Test case count constraint.");
        }
    }

    private static String validateOrdering(int[][] arr) {
        int sum;//calculates the total differnce of points across all 3 characteristics of student
        List<Student> list = sortForOrdering(arr);
        for (int i = 1; i < 3; i++) {
            sum = 0;
            sum = sum + (list.get(i).getHardwork() - list.get(i - 1).getHardwork()) +
                        (list.get(i).getPersistence() - list.get(i - 1).getPersistence()) +
                        (list.get(i).getIntelligence() - list.get(i - 1).getIntelligence());
            /*if sum <=0,
            it means that next student isnt in the order we need,
            since, he doesn't have atleast 1 characteristic more than prev student*/
            if (sum <= 0) {
                return "no";
            }
        }
        //logic is satisfied, hence, return yes
        return "yes";
    }

    private static List<Student> sortForOrdering(int[][] arr) {
        //make list of the 3 students
        List<Student> list = Arrays.asList(new Student(arr[0]),
                new Student(arr[1]),
                new Student(arr[2]));
        //sort them first by hardwork, then by Intelligence and then by Persistence in ascending order
        //with this sorting, we would get the order we need, but we need to check if any characterstic is > for i+1th student or not
        list.sort(new HardworkSorter()
                .thenComparing(new IntelligenceSorter())
                .thenComparing(new PersistenceSorter()));
        //System.out.println(list);
        return list;
    }
}
