package com.sust.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/17 9:51
 */
public class MultiPartFiles2File {
    public static File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());

        FileOutputStream fos = new FileOutputStream(convFile);

        fos.write(file.getBytes());

        fos.close();

        return convFile;
    }
}
