package com.cydeo.numericsMapTask;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapWithNumerics {

    public static void main(String[] args) {

        System.out.println("***Task 1 solution***");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        List<Integer> numbersSquare = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(numbersSquare);

        System.out.println("***Task 2 solution***");

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .forEach(pair -> System.out.println(Arrays.toString(pair)));

        List<int[]> listOfIntArray = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());


    }
}
