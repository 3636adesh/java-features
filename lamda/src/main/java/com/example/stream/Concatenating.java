package com.example.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Concatenating {
    public static void main(String[] args) {
        List<Integer> list0 = List.of(1, 2, 3);
        List<Integer> list1 = List.of(4, 5, 6);
        List<Integer> list2 = List.of(7, 8, 9);
        List<Integer> concat =
                Stream.concat(list0.stream(), list1.stream())
                        .toList();
        List<Integer> flatMap = Stream.of(list0.stream(), list1.stream(), list2.stream())
                .flatMap(Function.identity())
                .toList();
        System.out.println("concat  = " + concat);
        System.out.println("flatMap = " + flatMap);

    }

    static class Debug{
        public static void main(String[] args) {
            List<String> strings = List.of("one", "two", "three", "four");

            List<String> result =
                    strings.stream()
                            .peek(s -> System.out.println("Starting with = " + s))
                            .filter(s -> s.startsWith("t"))
                            .peek(s -> System.out.println("Filtered = " + s))
                            .map(String::toUpperCase)
                            .peek(s -> System.out.println("Mapped = " + s))
                            .toList();
            System.out.println("result = " + result);
        }
    }
}
