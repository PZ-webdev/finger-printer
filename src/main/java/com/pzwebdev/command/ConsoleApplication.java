package com.pzwebdev.command;

import com.pzwebdev.service.ImageLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class ConsoleApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        BufferedImage images1 = ImageLoader.loadImage("image1.jpg");
        System.out.println("Hello Spring ...");
    }
}
