package com.example.lamda;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PlayWith_Comparator {

    public record Person(String firstName, String lastName, int age) {
    }
    public static void main(String[] args) {
        Person ravindra = new Person("Ravindra", "baloda", 37);
        Person deepak = new Person("Deepak", "Dev", 27);
        Person aakash = new Person("Aakash", "Sharma", 24);
        Person pooja = new Person("Pooja", "Sharma", 32);
        Person sunil = new Person("Sunil", "Kichar", 36);
        Person ashish = new Person("Ashish", "Chaudhary", 33);

        Function<Person, String> firstName = Person::firstName;
        Function<Person, String> lastName = Person::lastName;
        Function<Person, Integer> age = Person::age;

        Comparator<Person> comparator = Comparator.comparing(firstName)
                .thenComparing(lastName)
                .thenComparing(age);

        comparator = Comparator.nullsLast(comparator);


        List<Person> peoples = Arrays.asList(ravindra, null, aakash, deepak, pooja, sunil, ashish);
        peoples.sort(comparator);


        peoples.forEach(System.out::println);


    }
}
