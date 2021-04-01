package org.fundacionjala.JalaConverter.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {
    public void uploadFile(MultipartFile file) throws IllegalStateException, IOException {
        file.transferTo(new File("G:\\Files\\VideoUploads\\" + file.getOriginalFilename()));
    }
}