package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExampleInt {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        Optional<Integer> sum = nums.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());
    }

    public static class ReduceExampleString {
        public static void main(String[] args) {
            List<String> nums = List.of("Один", "Два", "Три");
            Optional<String> sum = nums.stream()
                    .reduce((a, b) -> a + ", " + b);
            System.out.println(sum.get());
        }
    }

    public static class ReduceExampleBinaryOperator {
        public static void main(String[] args) {
            List<Integer> nums = Arrays.asList(1, 2, 3, 4);
            int sum = nums.stream()
                    .reduce(2, (a, b) -> a + b);
            System.out.println(sum);
        }
    }

    public static class ReduceExamplePeople {
        public static void main(String[] args) {
            List<MapToIntExampleInt.Person> people = Arrays.asList(
                    new MapToIntExampleInt.Person("Михаил", 35),
                    new MapToIntExampleInt.Person("Ольга", 26),
                    new MapToIntExampleInt.Person("Антон", 20),
                    new MapToIntExampleInt.Person("Виктор", 16),
                    new MapToIntExampleInt.Person("Анна", 29)
            );
            int sum = people.stream()
                    .reduce(
                            0,
                            (a, b) -> {
                                if (b.getAge() > 25) {
                                    return a + b.getAge();
                                } else {
                                    return a;
                                }
                            },
                            (a, b) -> a + b
                    );
            System.out.println(sum);
        }
    }
}
