package com.cty.ball.yueqiuer.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 苑雪元 on 2016/4/6.
 * 1.增加183手机号
 */
public class CheckPhoneNumber {
    public boolean checkPhoneNum(String phoneNum){
        //建立审核规范
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,3,5-9]))\\d{8}$");
        Matcher m = p.matcher(phoneNum);
        String a = ""+m.matches();
        return m.matches();
    }
}
