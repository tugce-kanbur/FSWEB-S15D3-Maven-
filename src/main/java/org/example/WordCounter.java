package org.example;

import java.util.HashMap;
import java.util.Map;

public final class WordCounter {
    public static Map<String, Integer> calculateWord(String text) {
        Map<String, Integer> wordCounter = new HashMap<>();
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = text.split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) continue;
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }

        return wordCounter;
    }
}

