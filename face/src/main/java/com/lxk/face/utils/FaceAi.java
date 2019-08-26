package com.lxk.face.utils;
import com.baidu.aip.face.AipFace;
import com.lxk.face.model.FaceModel;
import org.json.JSONObject;

import java.util.HashMap;

public class FaceAi {
    private static final String app_id = "17079798";
    private static final String app_key = "2X1OGuLVqpulM084WjtztXgn";
    private static final String Secret_Key ="htK0HrGVdtBGMmmieZfUYzUwnruiSArQ";

    private static final String IMAGE_TYPE = "BASE64";
    private AipFace apiFace;
    public FaceAi(){
        apiFace = new AipFace(app_id,app_key,Secret_Key);
        apiFace.setConnectionTimeoutInMillis(2000);
        apiFace.setSocketTimeoutInMillis(5000);
    }

    public FaceModel detect(String imgBase64){
        FaceModel faceModel = new FaceModel();
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("face_field", "age,beauty,expression,face_shape,gender,glasses,race,face_type");
        JSONObject jsonObject =apiFace.detect(imgBase64,IMAGE_TYPE,hashMap);

        String error_msg =jsonObject.optString("error_msg");

        JSONObject faceObject =null;
        if (error_msg.equals("SUCCESS")){
            JSONObject result = jsonObject.optJSONObject("result");
            if (result.optInt("face_num")==1){
                faceObject = (JSONObject)result.optJSONArray("face_list").get(0);
            }
        }
        if (faceObject != null){
            faceModel = parseAttribute(faceObject);
        }
        return faceModel;
    }

    private FaceModel parseAttribute(JSONObject faceObject) {
        FaceModel faceModel = new FaceModel();

        String expression = faceObject.getJSONObject("expression").getString("type");
        switch (expression){
            case "simle":
                faceModel.setExpression("微笑");
                break;
            case "laugh":
                faceModel.setExpression("大笑");
                break;
            case "none":
                faceModel.setExpression("无");
                break;
        }

        //脸型
        String faceShape = faceObject.getJSONObject("face_shape").getString("type");
        switch (faceShape) {
            case "square":
                faceModel.setFaceShape("正方形");
                break;
            case "triangle":
                faceModel.setFaceShape("三角形");
                break;
            case "oval":
                faceModel.setFaceShape("椭圆");
                break;
            case "heart":
                faceModel.setFaceShape("心形");
                break;
            case "round":
                faceModel.setFaceShape("圆形");
                break;
            default:
                faceModel.setFaceShape("未知");
        }

//性别
        String gender = faceObject.getJSONObject("gender").getString("type");
        switch (gender) {
            case "male":
                faceModel.setGender("帅哥");
                break;
            case "female":
                faceModel.setGender("美女");
                break;
            default:
                faceModel.setGender("未知");
        }

        //人种
        String race = faceObject.getJSONObject("race").getString("type");
        switch (race) {
            case "yellow":
                faceModel.setRace("黄种人");
                break;
            case "white":
                faceModel.setRace("白种人");
                break;
            case "black":
                faceModel.setRace("黑种人");
                break;
            case "arabs":
                faceModel.setRace("阿拉伯人");
                break;
            default:
                faceModel.setRace("未知");
        }

        //眼镜
        String glasses = faceObject.getJSONObject("glasses").getString("type");
        switch (glasses) {
            case "common":
                faceModel.setGlasses("普通眼镜");
                break;
            case "sun":
                faceModel.setGlasses("墨镜");
                break;
            case "none":
                faceModel.setGlasses("无眼镜");
                break;
            default:
                faceModel.setGlasses("未知");
        }

        //年龄
        int age = faceObject.optInt("age");
        faceModel.setAge(age);

        //颜值
        Integer beauty = faceObject.getInt("beauty");
        faceModel.setBeauty(beauty);
        return faceModel;
    }

}
