package com.example.fileanalyzer.modules;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class CatalogFilesSizeModule extends CatalogModule {
    @Override
    public String getDescription() {
        return "I can count the size of files in the catalog";
    }

    @Override
    protected void runFunc(DirectoryStream<Path> directoryStream) {
        long totalSize = 0;
        for (Path path : directoryStream) {
            long size;
            if (Files.isDirectory(path))
                size = getDirectorySize(path);
            else
                size = path.toFile().length();
            System.out.println(path.getFileName() + " : " + size + " B");
            totalSize += size;
        }
        System.out.println("--- total: " + totalSize + " B");
    }

    private long getDirectorySize(Path path){
        try {
            return Files.walk(path)
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
        } catch (IOException ioException) {
            System.out.println(path.getFileName() + " : failed to count size ");
            return 0;
        }
    }
}