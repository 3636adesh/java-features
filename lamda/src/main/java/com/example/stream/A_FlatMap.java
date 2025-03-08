package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class A_FlatMap {



    class A{
        public static void main(String[] args) {

            record City(String name, int population) {}
            record Country(String name, List<City> cities) {}

            City newYork= new City("New York", 8_258);
            City losAngeles = new City("Los Angeles", 3_821);
            Country usa = new Country("USA", List.of(newYork, losAngeles));

            City london = new City("London", 8_866);
            City manchester = new City("Manchester", 568);
            Country uk = new Country("United Kindgom", List.of(london, manchester));

            City paris = new City("Paris", 2_103);
            City marseille = new City("Marseille", 877);
            Country france = new Country("France", List.of(paris, marseille));
            List<Country> countries = List.of(usa, uk, france);
            int sum = countries.stream()
                    .flatMap(country -> country.cities.stream())
                    .mapToInt(City::population)
                    .sum();
            System.out.println("total population: " + sum);
        }
    }

    static class Flatmap_And_MapMulti{
        public static void main(String[] args) {

            Function<String, Stream<Integer>> flatParser = s ->{

                try {
                    return Stream.of(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                }

                return Stream.empty();
            };

            List<String> strings = List.of("1", " ", "2", "3 ", "", "3");
            var integers = strings.stream().flatMap(flatParser).toList();
            System.out.println("integers "+ integers);


            List<Integer> ints = strings.stream()
                    .<Integer>mapMulti(
                            (string, consumer) -> {
                                try {
                                    consumer.accept(Integer.parseInt(string));
                                } catch (NumberFormatException ignored) {
                                }
                            }
                    ).toList();

            System.out.println("ints "+ ints);
        }
    }
}
