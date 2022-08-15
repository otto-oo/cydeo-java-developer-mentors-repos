package tasks.task3;

public final class Algorithm {
    public static <T> T max(T x, T y) {
        return (Character) x > (Character) y ? x : y;
    }

    public static void main(String[] args) {

        System.out.println(max('A', 'V'));
    }
}
