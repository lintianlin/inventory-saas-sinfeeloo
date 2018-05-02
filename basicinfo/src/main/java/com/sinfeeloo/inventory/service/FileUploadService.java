package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Image;
import com.sinfeeloo.inventory.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/2 11:18
 */
@Service
public class FileUploadService {

    @Value("${win.image.dir}")
    private String winGallery;

    @Value("${linux.image.dir}")
    private String linuxGallery;

    @Autowired
    private ImageMapper imageMapper;

    private Path path = null;

    public void store(MultipartFile file, Image image) {

        if (file.isEmpty()) {
            throw new RuntimeException("Fail to store empty file");
        }

        try {
            path = Paths.get(getGalleryPath(), image.getFileName());
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getGalleryPath() {
        String osname = System.getProperty("os.name");
        String galleryPath = null;
        if (osname.startsWith("Windows")) {
            // 在 Windows 操作系统上
            galleryPath = winGallery;
        } else if (osname.startsWith("Linux")) {
            // 在 Linux 操作系统上
            galleryPath = linuxGallery;
        }
        return galleryPath;
    }


    /**
     * 添加照片
     *
     * @param image
     */
    public void addImage(Image image) {
        imageMapper.insert(image);
    }
}
