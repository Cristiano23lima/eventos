package com.f5.evento.config;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


@Service
public class CloudinaryConfig {
	private Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "deliveryrevendedor",
			"api_key", "921126976575414",
			"api_secret", "FbwuZxQo0_ryYUm8R1jyMUx1vtc"
	));

    public String uploadFile(MultipartFile file) {
        try {
            File uploadedFile = convertMultiPartToFile(file);
            Map uploadResult = cloudinary.uploader().upload(uploadedFile, ObjectUtils.asMap(
            		"public_id", "images/"+new Date().getTime(),
            		"eager", Arrays.asList(new Transformation().width(400).height(300).crop("pad"))
            ));
            return uploadResult.get("secure_url").toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
