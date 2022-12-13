package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExampleSkip {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rsl = strings
                .stream()
                .skip(2)
                .toList();
        System.out.println(rsl);
    }

    public static class SelectionExampleLimit {
        public static void main(String[] args) {
            List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
            List<String> rsl = strings
                    .stream()
                    .limit(3)
                    .toList();
            System.out.println(rsl);
        }
    }

    public static class SelectionExampleSkipLimit {
        public static void main(String[] args) {
            List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
            List<String> rsl = strings
                    .stream()
                    .skip(2)
                    .limit(2)
                    .toList();
            System.out.println(rsl);
        }
    }

    public static class SelectionExampleFindFirst {
        public static void main(String[] args) {
            List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
            String rsl = strings
                    .stream()
                    .skip(2)
                    .limit(2)
                    .findFirst()
                    .orElse("По умолчанию");
            System.out.println(rsl);
        }
    }

    public static class SelectionExampleFindFirstNull {
        public static void main(String[] args) {
            List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
            String rsl = strings
                    .stream()
                    .skip(5)
                    .findFirst()
                    .orElse("По умолчанию");
            System.out.println(rsl);
        }
    }

    public static class SelectionExampleFindFirstEnd {
        public static void main(String[] args) {
            List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
            String rsl = strings
                    .stream()
                    .skip(strings.size() - 1)
                    .findFirst()
                    .orElse("По умолчанию");
            System.out.println(rsl);
        }
    }
}