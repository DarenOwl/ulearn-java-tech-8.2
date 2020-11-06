package com.example.fileanalyzer.modules;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class TextFileLinesCountModule extends TextFileModule {

    @Override
    public String getDescription() {
        return "I can count lines";
    }

    @Override
    public void runFunc(BufferedReader bufferedReader){
        System.out.println("lines count: " + bufferedReader.lines().count());
    }
}
