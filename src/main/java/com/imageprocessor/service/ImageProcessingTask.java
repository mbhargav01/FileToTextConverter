package com.imageprocessor.service;

import java.awt.image.BufferedImage;
import java.util.concurrent.RecursiveTask;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageProcessingTask extends RecursiveTask<String>{

	private final BufferedImage image;
    private final Tesseract tesseract;

    public ImageProcessingTask(BufferedImage image, Tesseract tesseract) {
        this.image = image;
        this.tesseract = tesseract;
    }
    
	@Override
	protected String compute() {
		try {
            return tesseract.doOCR(image);
        } catch (TesseractException e) {
            throw new RuntimeException("Error during OCR processing", e);
        }
	}

}
