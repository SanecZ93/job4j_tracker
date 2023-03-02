package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
       StringBuilder strChar = new StringBuilder(evenElements.toString());
       for (int i = 0; i < evenElements.size(); i++) {
           if (i % 2 != 0) {
              strChar.deleteCharAt(i);
           }
       }
        return strChar.toString();
    }

    private String getDescendingElements() {
        StringBuilder strChar = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            strChar.append(iterator.next());
        }
        return strChar.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}