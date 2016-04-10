package com.cty.ball.yueqiuer.entity;

import cn.bmob.v3.BmobObject;

/**
 * 报名实体
 * Created by TYD on 2016/4/9.
 */
public class Apply  extends BmobObject{
    private int applyID;         //报名ID
    private int activityID;      //活动ID
    private String participantName;  //用户姓名
    private String participantSex;  //用户性别
    private int participantTel;     //用户电话
    private String participantIntroduce;//用户介绍

    //getter和setter方法
    public int getApplyID() {
        return applyID;
    }

    public void setApplyID(int applyID) {
        this.applyID = applyID;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantSex() {
        return participantSex;
    }

    public void setParticipantSex(String participantSex) {
        this.participantSex = participantSex;
    }

    public int getParticipantTel() {
        return participantTel;
    }

    public void setParticipantTel(int participantTel) {
        this.participantTel = participantTel;
    }

    public String getParticipantIntroduce() {
        return participantIntroduce;
    }

    public void setParticipantIntroduce(String participantIntroduce) {
        this.participantIntroduce = participantIntroduce;
    }
    //带参构造方法
    public Apply(int applyID, int activityID, String participantName, String participantSex, int participantTel, String participantIntroduce) {
        this.applyID = applyID;
        this.activityID = activityID;
        this.participantName = participantName;
        this.participantSex = participantSex;
        this.participantTel = participantTel;
        this.participantIntroduce = participantIntroduce;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyID=" + applyID +
                ", activityID=" + activityID +
                ", participantName='" + participantName + '\'' +
                ", participantSex='" + participantSex + '\'' +
                ", participantTel=" + participantTel +
                ", participantIntroduce='" + participantIntroduce + '\'' +
                '}';
    }
}
