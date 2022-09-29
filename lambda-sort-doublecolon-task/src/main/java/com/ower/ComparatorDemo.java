package com.ower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<Car>();

        Car honda = new Car("Honda", 1997);
        Car ford = new Car("Ford", 2000);
        Car crysler = new Car("Crysler", 2007);

        cars.add(honda);
        cars.add(ford);
        cars.add(crysler);

        Comparator<Car> comparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getYear() < o2.getYear() ? -1 : o1.getYear() == o2.getYear() ? 0 : 1;
            }
        };

        Collections.sort(cars, (o1,o2) -> o2.getModel().compareTo(o1.getModel()));
        System.out.println(cars);

        System.out.println("-------------------------- below compare according to year --------------------");

        Collections.sort(cars, (o1,o2) -> o2.getYear().compareTo(o1.getYear()));
        System.out.println(cars);

        System.out.println("-------------------------- with comparator --------------------");
        Collections.sort(cars, comparator);
        System.out.println(cars);

        System.out.println("-------------------------- with comparator.comparing --------------------");
        Collections.sort(cars, Comparator.comparing(Car::getYear));

        System.out.println("-------------------------- with streams sorted method --------------------");
        cars.stream()
                .sorted(Comparator.comparing(Car::getYear))
                .map(Car::getModel)
                .forEach(System.out::println);


    }
}
