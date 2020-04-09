package com.curd.controller;

import com.curd.utils.RenamePhoto;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/9 22:08
 */
@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("/upload_page")
    public String upload_page() {
        return "upload";
    }

    @RequestMapping("/personalPhoto_upload")
    @ResponseBody
    public String personalPhoto_upload(HttpSession session, String photo_name,
                                       @RequestParam("file") MultipartFile mfile) throws IllegalStateException, IOException {
        String realPath = session.getServletContext().getRealPath("/upload");
        // System.out.println(realPath);
        String fileName = mfile.getOriginalFilename();
        String uuid_name = RenamePhoto.rename(fileName);
        String target = realPath + "/" + uuid_name;
        mfile.transferTo(new File(target));
        return uuid_name;
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile mfile, HttpSession session, HttpServletRequest req)
            throws IllegalStateException, IOException {
        // System.out.println("原始文件名为：" + mfile.getOriginalFilename());
        // System.out.println("文件大小为：" + mfile.getSize() + " b");
        // System.out.println("文件类型为：" + mfile.getContentType());
        // System.out.println("文件是否为空：" + mfile.isEmpty());
        String realPath = session.getServletContext().getRealPath("/upload");
        String fileName = mfile.getOriginalFilename();
        mfile.transferTo(new File(realPath + "/" + fileName));
        req.setAttribute("fileName", fileName);
        return "upload";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam String fileName, HttpSession session) throws IOException {
        System.out.println(fileName + "   ......");
        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath + "/" + fileName);
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以attachment（下载的方式）方式打开图片
        headers.setContentDispositionFormData("attachment", fileName);
        // 二进制流的方式下载文件 application/octet-stream
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
