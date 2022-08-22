package com.cydeo.fibonacciTask;

import java.util.stream.Stream;

public class InfiniteStream {

    public static void main(String[] args) {

        Stream.iterate(1, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("*****************");
        System.out.println("How does it work? Iterate needs a lambda to specify the successor element");
        System.out.println("In the case of the tuple (3,5) the successor (5,3+5) = (5,8)");
        System.out.println("The next one (8,5+8)");

        Stream.iterate((new int[]{0, 1}), t -> new int[]{t[1], t[0] + t[1]})
                .limit(8)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
        System.out.println("Regular way for writing fibonacci");
        Stream.iterate((new int[]{0, 1}), t -> new int[]{t[1], t[0] + t[1]})
                .limit(8)
                .map(t-> t[0])
                .forEach(System.out::println);
    }
}
