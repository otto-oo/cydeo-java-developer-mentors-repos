package week_23;


import java.util.HashMap;
import java.util.Map;

public class Staircase {

    public static void main(String[] args) {
        System.out.println(getNumberOfStepsWithMap(20));
        System.out.println(getNumberOfSteps(5));
    }

    /**
     * Complete the 'stepPerms' function below.
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    //When we set the new base cases those are enhancing the performance of the methods. Otherwise, it takes much more time.
    public static int getNumberOfSteps(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if (n == 4) {
            return 7;
        }
        if (n == 5) {
            return 13;
        }
        return getNumberOfSteps(n - 1) + getNumberOfSteps(n - 2) + getNumberOfSteps(n - 3);

    }

    public static int getNumberOfStepsWithMap(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 4);
        map.put(4, 7);

        if (n == 0) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            map.put(n, getNumberOfStepsWithMap(n - 1) + getNumberOfStepsWithMap(n - 2) + getNumberOfStepsWithMap(n - 3));
        }
        return map.get(n);
    }
}
