package com.imageprocessor.dto;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class ImageRequest {
	private MultipartFile file;
}
