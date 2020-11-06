package com.example.fileanalyzer.modules;

import org.springframework.stereotype.Component;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.HashMap;

@Component
public class CatalogCountFileTypesModule extends CatalogModule {
    @Override
    public String getDescription() {
        return "I can count types of files in the catalog";
    }

    @Override
    protected void runFunc(DirectoryStream<Path> directoryStream) {
        HashMap<String, Integer> fileTypes = new HashMap<>();

        for (Path path : directoryStream) {
            String filename = path.getFileName().toString();
            String extention = "directories";
            for (int i = filename.length() - 1; i >= 0; i--) {
                if (filename.charAt(i) == '.') {
                    extention = filename.substring(i);
                    break;
                }
            }
            if (fileTypes.containsKey(extention))
                fileTypes.replace(extention, fileTypes.get(extention) + 1);
            else
                fileTypes.put(extention, 1);
        }
        fileTypes.forEach(this::printEntry);
    }

    private void printEntry(String extension, Integer count) {
        System.out.println(extension + " : " + count);
    }
}
