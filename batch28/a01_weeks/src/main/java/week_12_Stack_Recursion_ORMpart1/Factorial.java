package week_12_Stack_Recursion_ORMpart1;

public class Factorial {

    public static void main(String[] args) {
        // find factorial of given number

        System.out.println("recursion = " + factorial(4));
    }

    static long factorial(int n) {
        long result = -5;
        if (n <= 1)     // base condition
            return 1;

        System.out.println("before; n : " + n + " result : "+ result);
        result = n * factorial(n -1);
        System.out.println("after; n : " + n + " result : "+ result);
        return result;
    }

    static long fact(int n) {
        if (n <= 1)     // base condition
            return 1;

        return n * fact(n -1);
    }



    static long factorialIteration(int n) {
        if (n <= 0) return 1;
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
