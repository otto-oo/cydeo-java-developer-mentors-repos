package week_13_Stack_Recursion_ORMpart1.recursionPractice;

public class a2_PowerLinear {


    public static void main(String[] args) {
        System.out.println("power(2, 3) = " + power(2, 3)); // 8
    }

    /*
1. You are given a number x.
2. You are given another number n.
3. You are required to calculate x raised to the power n. Don't change the signature of power function .
     */

    public static int power(int x, int n){
        if (n < 1) return 1;
        return x * power(x, n-1);
    }
}
