package com.ower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparotorDemo{
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<Car>();

        Car honda = new Car("Honda", 1997);
        Car ford = new Car("Ford", 2000);

        cars.add(honda);
        cars.add(ford);

        Collections.sort(cars, (o1,o2) -> o2.getModel().compareTo(o1.getModel()));
        System.out.println(cars);






    }
}
