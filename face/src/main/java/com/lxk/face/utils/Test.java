package com.lxk.face.utils;

import com.lxk.face.model.FaceModel;
import org.json.JSONObject;

public class Test {
    public static void main(String[] args) {
        FaceAi faceAi = new FaceAi();
        try{
            String image = ImageTool.getImageBase64Str("timg.jpg");
            FaceModel detect = faceAi.detect(image);
            System.out.println(detect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
