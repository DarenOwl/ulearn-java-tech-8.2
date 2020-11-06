package com.example.fileanalyzer.modules;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

@Component
public class TextFileCharacterTypesCountModule extends TextFileModule {
    @Override
    public String getDescription() {
        return "I count types of characters";
    }

    @Override
    public void runFunc(BufferedReader bufferedReader) {
        HashMap<String, Integer> letters = new HashMap<>();

        int totalCount = 0;
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
                totalCount++;
                String type;
                if (Character.isDigit(line.charAt(i)))
                    type = "digits";
                else if (Character.isLetter(line.charAt(i)))
                    type = "letters";
                else if (Character.isISOControl(line.charAt(i)))
                    type = "control characters";
                else if (Character.isWhitespace(line.charAt(i)))
                    type = "white spaces";
                else
                    type = "other";
                
                if (letters.containsKey(type)) {
                    letters.replace(type,letters.get(type) + 1);
                }
                else {
                    letters.put(type, 1);
                }
            }
        }

        letters.forEach(this::PrintEntry);
        System.out.println("--- total: " + totalCount);
    }

    private void PrintEntry(String letterType, Integer count) {
        System.out.println(letterType + " : " + count);
    }
}
