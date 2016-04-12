package com.cty.ball.yueqiuer.utils;

import android.content.Context;
import android.content.Intent;

import com.cty.ball.yueqiuer.activity.LoginActivity;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;

/**
 * 判断用户是否登录了
 * Created by 苑雪元 on 2016/4/12.
 */
public class LoginOrNot {
    public BmobUser bmobUser;
    private Intent intent;
    public LoginOrNot(BmobUser bmobUser){
        this.bmobUser = bmobUser;
    }

    public void loginOrNot(Context context,Class classes){
        if (bmobUser!=null){
            //已经登录，直接修改
            intent = new Intent(context,classes);
            context.startActivity(intent);
        }else {
            //没有登录，进入到登录界面
            intent = new Intent(context,LoginActivity.class);
            context.startActivity(intent);
        }
    }
}
