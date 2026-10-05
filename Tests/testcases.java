package Tests;


import java.util.Arrays;
import java.util.List;

public class testcases {
    public static void main(String[] args) {

        System.out.println("     Problem 1  ");
        PROBLEM1.Exercise p1 = new PROBLEM1.Exercise();

        System.out.println("Question: Count digits of 12345");
        System.out.println("Answer: " + p1.countDigits(12345));

        System.out.println("Question: Count digits of -12345");
        System.out.println("Answer: " + p1.countDigits(-12345));

        System.out.println("Question: Count digits of 0");
        System.out.println("Answer: " + p1.countDigits(0));


        System.out.println("\n       Problem 2 ");
        PROBLEM2.Exercise p2 = new PROBLEM2.Exercise();

        System.out.println("Question: Swap 10 and 20");
        System.out.println("Answer: " + Arrays.toString(p2.swapNumbers(10, 20)));

        System.out.println("Question: Swap -5 and 0");
        System.out.println("Answer: " + Arrays.toString(p2.swapNumbers(-5, 0)));


        System.out.println("\n   Problem 3");
        PROBLEM3.Exercise p3 = new PROBLEM3.Exercise();

        System.out.println("Question: [2, 7, 11, 15], target = 9");
        System.out.println("Answer: " +
                Arrays.toString(p3.twoSum(new int[]{2, 7, 11, 15}, 9)));

        System.out.println("Question: [1, 2, 3], target = 10");
        System.out.println("Answer: " +
                Arrays.toString(p3.twoSum(new int[]{1, 2, 3}, 10)));

        System.out.println("Question: [3, 3], target = 6");
        System.out.println("Answer: " +
                Arrays.toString(p3.twoSum(new int[]{3, 3}, 6)));


        System.out.println("\n  Problem 4 ");
        PROBLEM4.Exercise p4 = new PROBLEM4.Exercise();

        System.out.println("Question: Compress \"aabcc\"");
        System.out.println("Answer: " + p4.compressString("aabcc"));

        System.out.println("Question: Compress \"aabaa\"");
        System.out.println("Answer: " + p4.compressString("aabaa"));

        System.out.println("Question: Compress \"a\"");
        System.out.println("Answer: " + p4.compressString("a"));

        System.out.println("Question: Compress empty string");
        System.out.println("Answer: " + p4.compressString(""));
    }
}