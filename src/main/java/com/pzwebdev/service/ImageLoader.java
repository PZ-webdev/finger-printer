package com.pzwebdev.service;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class ImageLoader {

    private static final String IMAGES = "images";
    private static final String OUTPUT = "output";

    public static BufferedImage loadImage(String filename) {
        try {
            String currentDirectory = System.getProperty("user.dir");
            String imagePath = currentDirectory + File.separator + IMAGES + File.separator + filename;

            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            return null;
        }
    }

    public static void saveImage(BufferedImage image, String outputPath) {
        try {
            File outputImage = new File(OUTPUT + "/" + outputPath);
            ImageIO.write(image, "png", outputImage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
