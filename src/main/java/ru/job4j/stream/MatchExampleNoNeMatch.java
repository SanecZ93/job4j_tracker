package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExampleNoNeMatch {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean rsl = strings
                .stream()
                //.noneMatch(s -> s.contains("Шесть"));
                .noneMatch("Шесть"::contains);
        System.out.println(rsl);
    }

    public static class MatchExampleAnyMatch {
        public static void main(String[] args) {
            List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
            boolean rsl = strings
                    .stream()
                    .anyMatch(e -> e.endsWith("н"));
            System.out.println(rsl);
        }
    }

    public static class MatchExampleAllMatch {
        public static void main(String[] args) {
            List<String> strings = Arrays.asList("Трижды", "Три", "Триста", "Три тысячи");
            boolean rsl = strings
                    .stream()
                    .allMatch(e -> e.startsWith("Три"));
            System.out.println(rsl);
        }
    }
}
