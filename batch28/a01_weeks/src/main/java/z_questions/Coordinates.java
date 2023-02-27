package z_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Coordinates {

    public static void main(String[] args) {

    }

    static void funcDrop(int[] xCoordinate, int[] yCoordinate){
        Map<Integer, Integer> x = new HashMap<>();
        Map<Integer, Integer> y = new HashMap<>();

        for (int i : xCoordinate) {
            x.put(i, x.getOrDefault(x.get(i), 0)+1);
        }
        for (int i : yCoordinate) {
            y.put(i, y.getOrDefault(y.get(i), 0)+1);
        }
        int xMaxValue = 0;
        for (Map.Entry<Integer, Integer> each : x.entrySet()) {
            if (xMaxValue<each.getValue()){
                xMaxValue = each.getValue();
            }
        }

        int yMaxValue = 0;
        for (Map.Entry<Integer, Integer> each : y.entrySet()) {
            if (yMaxValue<each.getValue()){
                yMaxValue = each.getValue();
            }
        }
        int max = Math.max(xMaxValue, yMaxValue);
        if (max >1) {
            System.out.println(max);
        } else {
            System.out.println(0);
        }
    }


}
