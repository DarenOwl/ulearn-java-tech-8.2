package com.example.fileanalyzer.modules;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class ImageFileModule extends Module {
    public ImageFileModule() {
        supportedFileTypes = new String[]{".png",".jpg",".jpeg"};
    }

    @Override
    public void runFunc(String filepath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filepath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (image != null)
            runFunc(image);
    }

    protected void runFunc(BufferedImage image){
    }
}
