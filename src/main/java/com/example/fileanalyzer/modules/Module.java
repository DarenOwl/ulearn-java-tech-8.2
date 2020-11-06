package com.example.fileanalyzer.modules;

import java.util.Arrays;

public abstract class Module {
    String[] supportedFileTypes;

    public boolean supportsFileType(String fileType) {
        for (String supportedType : supportedFileTypes) {
            if (fileType.equals(supportedType))
                return true;
        }
        return false;
    }

    public String getDescription() {
        return "nope";
    }

    public void runFunc(String filepath){
        System.out.println("nothing happened");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
