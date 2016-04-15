package com.cty.ball.yueqiuer.entity;

import cn.bmob.v3.BmobObject;

/**
 * 球类表
 * Created by TYD on 2016/4/9.
 */
public class BallType extends BmobObject{
    private Integer ballTypeID; //球类ID
    private Integer activityID; //活动ID
    private String ballTypeName;//球类名称

    public BallType(Integer ballTypeID, Integer activityID, String ballTypeNamel) {
        this.ballTypeID = ballTypeID;
        this.activityID = activityID;
        this.ballTypeName = ballTypeName;
    }

    public Integer getBallTypeID() {
        return ballTypeID;
    }

    public void setBallTypeID(Integer ballTypeID) {
        this.ballTypeID = ballTypeID;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public String getBallTypeNamel() {
        return ballTypeName;
    }

    public void setBallTypeNamel(String ballTypeNamel) {
        this.ballTypeName = ballTypeNamel;
    }

    @Override
    public String toString() {
        return "BallType{" +
                "ballTypeID=" + ballTypeID +
                ", activityID=" + activityID +
                ", ballTypeNamel='" + ballTypeName + '\'' +
                '}';
    }
}
