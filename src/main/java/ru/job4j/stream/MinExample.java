package ru.job4j.stream;

import java.util.*;
import java.util.stream.IntStream;

public class MinExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 1, 3, 2);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get());
    }

    public static class MaxExample {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(4, 5, 1, 3, 2);
            Optional<Integer> minEl = list.stream()
                    .max(Comparator.naturalOrder());
            System.out.println(minEl.get());
        }
    }

    public static class MinExampleNotComparator {
        public static void main(String[] args) {
            OptionalInt min = IntStream
                    .rangeClosed(1, 5)
                    .min();
            System.out.println(min.getAsInt());
        }
    }

    public static class MinExamplePerson {
        public static void main(String[] args) {
            List<MapToIntExampleInt.Person> people = Arrays.asList(
                    new MapToIntExampleInt.Person("Михаил", 35),
                    new MapToIntExampleInt.Person("Ольга", 26),
                    new MapToIntExampleInt.Person("Антон", 20),
                    new MapToIntExampleInt.Person("Виктор", 16),
                    new MapToIntExampleInt.Person("Анна", 29)
            );
            Optional<MapToIntExampleInt.Person> youngestPerson = people.stream()
                    .min(Comparator.comparing(MapToIntExampleInt.Person::getAge));
            int age = youngestPerson.get().getAge();
            System.out.println(age);
        }
    }

    public static class MaxExamplePerson {
        public static void main(String[] args) {
            List<MapToIntExampleInt.Person> people = Arrays.asList(
                    new MapToIntExampleInt.Person("Михаил", 35),
                    new MapToIntExampleInt.Person("Ольга", 26),
                    new MapToIntExampleInt.Person("Антон", 20),
                    new MapToIntExampleInt.Person("Виктор", 16),
                    new MapToIntExampleInt.Person("Анна", 29)
            );
            Optional<MapToIntExampleInt.Person> youngestPerson = people.stream()
                    .max(Comparator.comparing(MapToIntExampleInt.Person::getAge));
            int age = youngestPerson.get().getAge();
            System.out.println(age);
        }
    }

    public static class CountExample {
        public static void main(String[] args) {
            List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
            long sum = nums.stream()
                    .filter(el -> el % 2 == 0)
                    .count();
            System.out.println(sum);
        }
    }

    public static class AverageExample {
        public static void main(String[] args) {
            List<MapToIntExampleInt.Person> people = Arrays.asList(
                    new MapToIntExampleInt.Person("Михаил", 35),
                    new MapToIntExampleInt.Person("Ольга", 26),
                    new MapToIntExampleInt.Person("Антон", 20),
                    new MapToIntExampleInt.Person("Виктор", 16),
                    new MapToIntExampleInt.Person("Анна", 29)
            );
            OptionalDouble average = people.stream()
                    .mapToInt(MapToIntExampleInt.Person::getAge)
                    .average();
            double avg = average.getAsDouble();
            System.out.println(avg);
        }
    }

    public static class SumExample {
        public static void main(String[] args) {
            List<MapToIntExampleInt.Person> people = Arrays.asList(
                    new MapToIntExampleInt.Person("Михаил", 35),
                    new MapToIntExampleInt.Person("Ольга", 26),
                    new MapToIntExampleInt.Person("Антон", 20),
                    new MapToIntExampleInt.Person("Виктор", 16),
                    new MapToIntExampleInt.Person("Анна", 29)
            );
            int sum = people.stream()
                    .mapToInt(MapToIntExampleInt.Person::getAge)
                    .sum();
            System.out.println(sum);
        }
    }
}