package com.example.fileanalyzer.modules;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

@Component
public class ImageFileColorsCountModule extends ImageFileModule {

    @Override
    public String getDescription() {
        return "I can count colors of your image file";
    }

    @Override
    public void runFunc(BufferedImage image) {
        Set<Integer> colors = new HashSet<>();
        int width = image.getWidth();
        int height = image.getHeight();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                int pixel = image.getRGB(x, y);
                colors.add(pixel);
            }
        }
        System.out.println("Colors count: "+colors.size());
    }
}
