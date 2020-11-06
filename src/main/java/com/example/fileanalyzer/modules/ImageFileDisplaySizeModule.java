package com.example.fileanalyzer.modules;

import org.springframework.stereotype.Component;
import java.awt.image.BufferedImage;

@Component
public class ImageFileDisplaySizeModule extends ImageFileModule {

    @Override
    public String getDescription() {
        return "I can display the size of your image file";
    }

    @Override
    public void runFunc(BufferedImage image) {
        System.out.println("image width: " + image.getWidth());
        System.out.println("image height: " + image.getHeight());
    }
}
