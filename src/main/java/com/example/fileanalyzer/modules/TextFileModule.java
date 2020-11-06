package com.example.fileanalyzer.modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class TextFileModule extends Module {
    public TextFileModule() {
        supportedFileTypes = new String[] {".txt",".xml",".java",".cs",".iml"};
    }

    @Override
    public void runFunc(String filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            runFunc(reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected abstract void runFunc(BufferedReader bufferedReader);
}
