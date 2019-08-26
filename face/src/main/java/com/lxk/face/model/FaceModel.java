package com.lxk.face.model;

public class FaceModel {
    private Integer age; // 年龄
    private Integer beauty; // 颜值
    private String expression; // 表情
    private String faceShape; // 脸型
    private String gender; // 性别
    private String glasses; // 是否带有眼镜
    private String race; // 人种

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBeauty() {
        return beauty;
    }

    public void setBeauty(Integer beauty) {
        this.beauty = beauty;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getFaceShape() {
        return faceShape;
    }

    public void setFaceShape(String faceShape) {
        this.faceShape = faceShape;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "FaceModel{" +
                "age=" + age +
                ", beauty=" + beauty +
                ", expression='" + expression + '\'' +
                ", faceShape='" + faceShape + '\'' +
                ", gender='" + gender + '\'' +
                ", glasses='" + glasses + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
