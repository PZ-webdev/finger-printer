package com.pzwebdev.command;

import com.pzwebdev.comman.algorithms.CrossingNumber;
import com.pzwebdev.comman.algorithms.KMM;
import com.pzwebdev.comman.algorithms.MedianFilter;
import com.pzwebdev.comman.algorithms.OTSU;
import com.pzwebdev.helper.ConsoleInputReader;
import com.pzwebdev.service.ImageLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.Objects;

@Component
public class ConsoleApplication implements CommandLineRunner {

    private final OTSU otsu = new OTSU();
    private final KMM kmm = new KMM();
    private final MedianFilter medianFilter = new MedianFilter();
    private final CrossingNumber crossingNumber = new CrossingNumber();

    @Override
    public void run(String... args) {
        String filename = ConsoleInputReader.readString("Podaj nazwę pliku z katalogu 'images'");
        BufferedImage image = ImageLoader.loadImage(filename);

        if (Objects.isNull(image)) {
            System.err.println("Image not found!");
        } else {
            image = otsu.binarize(image);
            image = medianFilter.filter(image, 3);
            kmm.calculate(image);
            image = crossingNumber.findMinutiae(image);

            ImageLoader.saveImage(image, "finger_output.png");
        }
    }
}
