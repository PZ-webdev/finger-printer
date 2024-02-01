package com.pzwebdev.comman.algorithms;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Arrays;

public class MedianFilter {

    public BufferedImage filter(BufferedImage actualImage, int windowSize) {
        BufferedImage image = deepCopy(actualImage);

        for (int y = 0; y < actualImage.getHeight(); y++) {
            for (int x = 0; x < actualImage.getWidth(); x++) {
                image.setRGB(x, y, getCalculatedValue(actualImage, x, y, windowSize));
            }
        }

        return image;
    }

    private int getCalculatedValue(BufferedImage image, int x, int y, int windowSize) {
        int[] red = new int[windowSize * windowSize];
        int[] green = new int[windowSize * windowSize];
        int[] blue = new int[windowSize * windowSize];

        int counter = 0;
        for (int i = -windowSize / 2; i <= windowSize / 2; i++) {
            for (int j = -windowSize / 2; j <= windowSize / 2; j++) {
                if (x + i >= 0 && x + i < image.getWidth() && y + j >= 0 && y + j < image.getHeight()) {
                    int ox = i, oy = j;

                    if (x + i < 0 || x + i > image.getWidth() - 1) ox = 0;
                    if (y + j < 0 || y + j > image.getHeight() - 1) oy = 0;

                    Color c = new Color(image.getRGB(x + ox, y + oy));

                    red[counter] = c.getRed();
                    green[counter] = c.getGreen();
                    blue[counter++] = c.getBlue();
                }
            }
        }

        Arrays.sort(red);
        Arrays.sort(green);
        Arrays.sort(blue);

        return new Color(red[(windowSize * windowSize) / 2],
                green[(windowSize * windowSize) / 2],
                blue[(windowSize * windowSize) / 2]).getRGB();
    }

    private BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}

