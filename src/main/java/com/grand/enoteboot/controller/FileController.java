package com.grand.enoteboot.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        try {
            if (file.getBytes().length > 5242880) {
                return "最大支持5M的文件";
            }
            File newFile = new File("D:/upload/" + file.getOriginalFilename());
            FileUtils.writeByteArrayToFile(newFile, file.getBytes());
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败 : " + e.getMessage();
        }
    }
}
