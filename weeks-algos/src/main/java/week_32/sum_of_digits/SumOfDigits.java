package week_32.sum_of_digits;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println("digitalRoot(129) = " + digitalRoot(129));
    }


    public static int digitalRoot(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        if (sum < 10) {
            return sum;
        }
        return digitalRoot(sum);
    }
}
