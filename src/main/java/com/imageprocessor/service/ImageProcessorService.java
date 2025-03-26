package com.imageprocessor.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ForkJoinPool;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.Tesseract;

@Service
public class ImageProcessorService {

	private final Tesseract tesseract;

    public ImageProcessorService() {
        tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tessdata");
    }
    
    public String processImage(InputStream inputStream) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);
        
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ImageProcessingTask task = new ImageProcessingTask(image, tesseract);
        
        return forkJoinPool.invoke(task);
    }
}
