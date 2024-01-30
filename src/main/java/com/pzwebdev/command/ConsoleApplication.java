package com.pzwebdev.command;

import com.pzwebdev.comman.algorithms.CrossingNumber;
import com.pzwebdev.comman.algorithms.KMM;
import com.pzwebdev.comman.algorithms.MedianFilter;
import com.pzwebdev.comman.algorithms.OTSU;
import com.pzwebdev.service.ImageLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ConsoleApplication implements CommandLineRunner {

    private final OTSU otsu = new OTSU();
    private final KMM kmm = new KMM();
    private final MedianFilter medianFilter = new MedianFilter();
    private final CrossingNumber crossingNumber = new CrossingNumber();


    @Override
    public void run(String... args) throws IOException {
        BufferedImage image = ImageLoader.loadImage("wskazujacy lewy KJ.jpg");

        image = otsu.binarize(image);
        image = medianFilter.filter(image, 3);
        kmm.calculate(image);
        image = crossingNumber.findMinutiae(image);

        ImageLoader.saveImage(image, "test.png");
    }

}
