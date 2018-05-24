package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Image;
import com.sinfeeloo.inventory.service.FileUploadService;
import com.sinfeeloo.inventory.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequestMapping(value = "/image")
public class FileUploadController extends BaseController {

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${remote.image.path}")
    private String remotePath;


    @PostMapping("/upload")
    public ComResp addImage(@RequestParam("file") MultipartFile file) {
        try {
            String id = UUIDUtil.UUIDGenerators();
            int index = file.getOriginalFilename().lastIndexOf(".");
            String suffix = file.getOriginalFilename().substring(index);
            String filename = id + suffix;

            Image image = new Image();
            image.setFileName(filename);
            image.setFilePath(remotePath + filename);
            image.setUpdatetime(new Date());

            //保存到本地
            fileUploadService.store(file, image);
            //保存到数据库
            fileUploadService.addImage(image);
            return ComResp.success("上传成功！", image);
        } catch (Exception e) {
            return ComResp.error("上传失败！", e);
        }
    }


}