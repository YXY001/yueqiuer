package com.cty.ball.yueqiuer.entity;

import cn.bmob.v3.BmobUser;

/**
 * 用户实体类
 * Created by 苑雪元 on 2016/4/9.
 */
public class User extends BmobUser {
    //用户性别
    private String userSex;
    //用户的头像
    private String userHeadPortrait;
    //用户的介绍
    private String userInfo;


    //gettter、setter方法
    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(String userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * 无参构造
     */
    public User(){

    }

    /**
     * 构造方法
     * @param userSex
     * @param userHeadPortrait
     * @param userInfo
     */
    public User(String userSex, String userHeadPortrait, String userInfo) {
        this.userSex = userSex;
        this.userHeadPortrait = userHeadPortrait;
        this.userInfo = userInfo;
    }

    /**
     * tostring方法
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "userSex='" + userSex + '\'' +
                ", userHeadPortrait='" + userHeadPortrait + '\'' +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}
