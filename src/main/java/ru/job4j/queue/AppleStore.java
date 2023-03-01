package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer rsl = null;
        for (int i = 1; i < count; i++) {
            queue.poll();
            rsl = queue.peek();
        }
        return rsl != null ? rsl.name() : null;
    }

    public String getFirstUpsetCustomer() {
        Customer rsl = null;
        for (int i = 1; i <= count; i++) {
            queue.poll();
            rsl = queue.peek();
        }
        return rsl != null ? rsl.name() : null;
    }
}