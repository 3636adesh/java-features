package com.example.stream;

import java.util.Comparator;
import java.util.List;

public class Sorting {

    static class NaturalSort {
        public static void main1(String[] args) {
            List<Integer> ints = List.of(1, 4, 2, 1, 3, 3);
            var distincts = ints.stream()
                    .distinct()
                    .sorted().toList();
            System.out.println("distinct ints: " + distincts);
        }

        public static void main(String[] args) {
            List<String> strings = List.of("one", "two", "three", "four");
            List<String> naturalSort =
                    strings.stream()
                            .sorted()
                            .toList();
            System.out.println("natural sort: " + naturalSort);

            List<String> shortestFirst =
                    strings.stream()
                            .sorted(Comparator.comparingInt(String::length))
                            .toList();
            System.out.println("shortest first: " + shortestFirst);
        }
    }
}
