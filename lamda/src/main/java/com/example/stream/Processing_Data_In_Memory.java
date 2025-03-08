package com.example.stream;

import java.time.LocalDate;
import java.time.Month;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Processing_Data_In_Memory {


    static class Counting {

        public static void main(String[] args) {
            List<String> strings = List.of("one", "two", "three", "four", "five");
            var map = strings.stream().collect(
                    Collectors.groupingBy(String::length, Collectors.counting())
            );
            map.forEach((k, v) -> System.out.println(k + ":" + v));
        }
    }

    static class Map_Filter_Reduce {
        public static void main(String[] args) {
            record Sale(String product, LocalDate date, int amount) {
            }
            List<Sale> sales = List.of(
                    new Sale("Orange", LocalDate.of(2022, Month.JANUARY, 2), 4),
                    new Sale("Pumpkin", LocalDate.of(2022, Month.OCTOBER, 18), 12),
                    new Sale("Butternut", LocalDate.of(2022, Month.OCTOBER, 03), 6),
                    new Sale("Apple", LocalDate.of(2022, Month.AUGUST, 28), 3)
            );

            var totalAmount=sales.stream()
                    .filter(sale->sale.date().getMonth() == Month.OCTOBER)
                    .mapToInt(Sale::amount)
                    .sum()
            ;
            System.out.println(totalAmount);
        }
    }

    static class Terminal_Operation {
        public static void main(String[] args) {
            // This code throws an exception at runtime
            var stream = Stream.of(1, 2, 3, 4);

                // 1st use of stream
            var stream1 = stream.map(i -> i + 1);

             // 2nd use of stream: this is forbidden!
            var list = stream.toList();
        }
    }

    static class Intermediate_Operations{
        public static void main(String[] args) {
            List<String> strings = List.of("one", "two", "three", "four");
            var statistics = strings.stream().mapToInt(String::length).summaryStatistics();
            System.out.println(statistics);
        }
    }
}
