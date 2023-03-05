package CGI_yasin;

import java.util.ArrayList;

public class Q1_BoxAverage {


    public static int boxAverage(ArrayList<Integer> ans) {
        int min = ans.get(0);
        int max = ans.get(0);

        for (Integer a : ans) {
            if (a > max) max = a;
            else if (a < min) min = a;
        }
        return (min + max) / 2;
    }

}
