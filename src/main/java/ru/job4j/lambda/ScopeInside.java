package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        var ref = new Object() {
            int total = 0;
        };
        for (int num : number) {
            ref.total = add(
                    () -> ref.total + num
            );
        }
        System.out.println(ref.total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}