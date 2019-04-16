package com.jxc.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUtil {

    public static String getFileTail(MultipartFile file){
        String fileName = file.getOriginalFilename();
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }
}
