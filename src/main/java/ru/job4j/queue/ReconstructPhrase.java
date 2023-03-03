package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
       StringBuilder strChar = new StringBuilder();
       int length = evenElements.size();
        for (int i = 0; i < length; i++) {
            if (i % 2 != 0) {
                evenElements.poll();
            } else {
                strChar.append(evenElements.poll());
            }
        }
        return strChar.toString();
    }

    private String getDescendingElements() {
        StringBuilder strChar = new StringBuilder();
        int length = descendingElements.size();
        for (int i = 0; i < length; i++) {
            strChar.append(descendingElements.pollLast());
        }
        return strChar.toString();
    }

    public String getReconstructPhrase() {

        return getEvenElements() + getDescendingElements();
    }
}