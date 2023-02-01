package tasks.task3;


/**
 * Will the following class compile? If not, why?
 * public final class Algorithm {
 * public static <T> T max(T x, T y) {
 * return x > y ? x : y;
 * }
 * }
 */
public final class Algorithm {

    //bigger or smaller operator is not applicable for objects that's why getting compilation error
    public static <T> T max(T x, T y) {
        return (Character) x > (Character) y ? x : y;
    }

    public static void main(String[] args) {

        System.out.println(max('A', 'V'));
    }
}
