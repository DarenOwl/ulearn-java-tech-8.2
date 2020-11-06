package com.example.fileanalyzer.modules;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

@Component
public class TextFileCharacterFrequencyModule extends TextFileModule {

    @Override
    public String getDescription() {
        return "I count every character frequency";
    }

    @Override
    public void runFunc(BufferedReader bufferedReader) {
        HashMap<Character, Integer> letters = new HashMap<>();
        while (true) {
            String line;
            try {
                line = bufferedReader.readLine();
            } catch (IOException ioException) {
                break;
            }
            if (line == null) {
                break;
            }
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (letters.containsKey(c)) {
                    letters.replace(c,letters.get(c) + 1);
                }
                else {
                    letters.put(c, 1);
                }
            }
        }

        letters.forEach(this::PrintEntry);
    }

    private void PrintEntry(Character letter, Integer count) {
        System.out.println(letter + " : " + count);
    }
}