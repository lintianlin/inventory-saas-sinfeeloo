package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/image")
public class FileUploadController extends BaseController {


    public static final String ROOT = "upload-dir";

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/")
//    public String provideUploadInfo(Model model) throws IOException {
//
//        model.addAttribute("files", Files.walk(Paths.get(ROOT))
//                .filter(path -> !path.equals(Paths.get(ROOT)))
//                .map(path -> Paths.get(ROOT).relativize(path))
//                .map(path -> linkTo(methodOn(FileUploadController.class).getFile(path.toString())).withRel(path.toString()))
//                .collect(Collectors.toList()));
//
//        return "uploadForm";
//    }

    //显示图片的方法关键 匹配路径像 localhost:8080/b7c76eb3-5a67-4d41-ae5c-1642af3f8746.png
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 上传的方法
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public ComResp handleFileUpload(@RequestParam("file") MultipartFile file,
                                    HttpServletRequest request) {
        System.out.println(request.getParameter("member"));
        if (!file.isEmpty()) {
            try {
//                Path path = Paths.get(ROOT, file.getOriginalFilename());
                Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
                return ComResp.success("上传成功！", Paths.get(ROOT, file.getOriginalFilename()));
            } catch (IOException | RuntimeException e) {
                return ComResp.error("上传失败！", e);
            }
        } else {
            return ComResp.error("没有上传文件！");
        }

    }

}