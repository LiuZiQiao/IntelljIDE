package com.lxk.face.utils;

import com.sun.javafx.iio.common.ImageTools;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

public class ImageTool {

    public  static String getImageBase64Str(String imageName){
        String imageBase64Str =null;
        String imagePath = getImagePath();
        File file = new File(imagePath,imageName);
        try{
            InputStream is =new FileInputStream(file);
            byte[] data = IOUtils.toByteArray(is) ;
            imageBase64Str = Base64.getEncoder().encodeToString(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return imageBase64Str;
    }

    private static String getImagePath() {

        String ImageName = null;
        String temp = getProjectPath()+"image";
        File file = new File(temp);
         if (file.exists()){
            ImageName = temp;
             System.out.println("目录存在");
         }else{
            boolean flag = file.mkdirs();
            if (flag){
                System.out.println("image目录创建成功");
                ImageName = temp;
            }else {
                throw new RuntimeException("创建失败");
            }
         }
        return ImageName;
    }

    private static String getProjectPath() {
        String projectPath = ImageTool.class.getResource("/").toString();
//        System.out.println(projectPath);
        projectPath=projectPath.substring(6,projectPath.indexOf("target"));
//        System.out.println(projectPath+"000");
        return projectPath;
    }
}
