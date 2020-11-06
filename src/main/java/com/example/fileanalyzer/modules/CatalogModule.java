package com.example.fileanalyzer.modules;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class CatalogModule extends Module {
    public CatalogModule() {
        supportedFileTypes = new String[]{""};
    }

    @Override
    public void runFunc(String directoryPath) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            runFunc(directoryStream);
        } catch (IOException ioException) {
            System.out.println("failed to read directory content");
        }
    }

    protected void runFunc(DirectoryStream<Path> directoryStream) {

    }
}
