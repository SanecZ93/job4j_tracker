package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToIntExampleInt {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        strings.stream()
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }

    public static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person{"
                    + "name='" + name + '\''
                    + ", age=" + age
                    + '}';
        }
    }

    public static class MapToIntExampleObg {
        public static void main(String[] args) {
            List<Person> people = Arrays.asList(
                    new Person("Михаил", 35),
                    new Person("Ольга", 26),
                    new Person("Антон", 20),
                    new Person("Виктор", 16),
                    new Person("Анна", 29)
            );
            int sum = people.stream()
                    .filter(e -> e.getAge() > 25)
                    .mapToInt(Person::getAge)
                    .peek(System.out::println)
                    .sum();
            System.out.println("Сумма: " + sum);
        }
    }

    public static class FlatMapToIntExample {
        public static void main(String[] args) {
            int[] array1 = {1, 2, 3};
            int[] array2 = {4, 5, 6};
            int[] array3 = {7, 8, 9};
            List<Integer> list = Stream.of(array1, array2, array3)
                    .flatMapToInt(Arrays::stream)
                    .boxed()
                    .collect(Collectors.toList());
            System.out.println(list);
        }
    }

    public static class MapToObjExample {
        public static void main(String[] args) {
            List<String> list = IntStream.rangeClosed(1, 5)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.toList());
            System.out.println(list);
        }
    }
}