package com.cty.ball.yueqiuer.entity;

import cn.bmob.v3.BmobObject;

/**
 * 活动列表
 * Created by 苑雪元 on 2016/4/9.
 */
public class ActivityList extends BmobObject {
    //活动ID
    private Integer activityID;
    //活动名称
    private String activityName;
    //球类ID，外键
    private BallType ballTypeID;
    //发起人ID，外键
    private User initiatorID;
    //参与者ID，外键
    private User participantID;
    //时间年月日
    private String date;
    //开始时间点
    private String startHour;
    //结束时间点
    private String endHour;
    //地点
    private String palce;
    //活动介绍
    private String activityIntroduce;
    //人员数
    private Integer personNum;
    //参与人数
    private Integer participantNum;
    //状态
    private Integer state;


    //gettter、setter方法
    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public BallType getBallTypeID() {
        return ballTypeID;
    }

    public void setBallTypeID(BallType ballTypeID) {
        this.ballTypeID = ballTypeID;
    }

    public User getInitiatorID() {
        return initiatorID;
    }

    public void setInitiatorID(User initiatorID) {
        this.initiatorID = initiatorID;
    }

    public User getParticipantID() {
        return participantID;
    }

    public void setParticipantID(User participantID) {
        this.participantID = participantID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getPalce() {
        return palce;
    }

    public void setPalce(String palce) {
        this.palce = palce;
    }

    public String getActivityIntroduce() {
        return activityIntroduce;
    }

    public void setActivityIntroduce(String activityIntroduce) {
        this.activityIntroduce = activityIntroduce;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public Integer getParticipantNum() {
        return participantNum;
    }

    public void setParticipantNum(Integer participantNum) {
        this.participantNum = participantNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 构造方法
     * @param tableName
     * @param activityID
     * @param activityName
     * @param ballTypeID
     * @param initiatorID
     * @param participantID
     * @param date
     * @param startHour
     * @param endHour
     * @param palce
     * @param activityIntroduce
     * @param personNum
     * @param participantNum
     * @param state
     */
    public ActivityList(String tableName, Integer activityID, String activityName, BallType ballTypeID, User initiatorID, User participantID, String date, String startHour, String endHour, String palce, String activityIntroduce, Integer personNum, Integer participantNum, Integer state) {
        super(tableName);
        this.activityID = activityID;
        this.activityName = activityName;
        this.ballTypeID = ballTypeID;
        this.initiatorID = initiatorID;
        this.participantID = participantID;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.palce = palce;
        this.activityIntroduce = activityIntroduce;
        this.personNum = personNum;
        this.participantNum = participantNum;
        this.state = state;
    }

    @Override
    public String toString() {
        return "ActivityList{" +
                "activityID=" + activityID +
                ", activityName='" + activityName + '\'' +
                ", ballTypeID=" + ballTypeID +
                ", initiatorID=" + initiatorID +
                ", participantID=" + participantID +
                ", date='" + date + '\'' +
                ", startHour='" + startHour + '\'' +
                ", endHour='" + endHour + '\'' +
                ", palce='" + palce + '\'' +
                ", activityIntroduce='" + activityIntroduce + '\'' +
                ", personNum=" + personNum +
                ", participantNum=" + participantNum +
                ", state=" + state +
                '}';
    }
}
