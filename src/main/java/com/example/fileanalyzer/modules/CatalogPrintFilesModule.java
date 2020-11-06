package com.example.fileanalyzer.modules;

import org.springframework.stereotype.Component;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

@Component
public class CatalogPrintFilesModule extends CatalogModule {
    @Override
    public String getDescription() {
        return "I can list files from the catalog";
    }

    @Override
    protected void runFunc(DirectoryStream<Path> directoryStream) {
        for (Path path : directoryStream) {
            System.out.println(path.toFile().getName());
        }
    }
}
