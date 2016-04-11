package com.cty.ball.yueqiuer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cty.ball.yueqiuer.R;
import com.cty.ball.yueqiuer.entity.User;
import com.cty.ball.yueqiuer.utils.CheckPhoneNumber;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QuerySMSStateListener;
import cn.bmob.v3.listener.RequestSMSCodeListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.VerifySMSCodeListener;

public class SignActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText telphone,verificationCode,password,surePassword;
    private Button sign,btnVerificationCode;
    private CheckBox boxUserAgreement;
    private TextView textUserAgreement;
    private String S_telphone,S_verificationCode,S_password,S_surePassword;
    private CheckPhoneNumber checkPhoneNumber;

    private final static String  TAG = "1";
    private static boolean smsTag = false;
    private final String APPKEYID = "73ecc55290215bf4be474a812a4c4692";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //初始化bmob插件
        Bmob.initialize(this, APPKEYID);
        //初始化类
        checkPhoneNumber = new CheckPhoneNumber();

        //初始化View
        inintView();
        //设置点击事件
        setOnClick();
    }

    /**
     * Toast的方法
     * @param msg
     */
    public void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        //获取上个传递的数据，动态改变按钮的文字
        Intent intent = this.getIntent();
        String tag = intent.getStringExtra("sign");
        if (tag.equals(TAG)){
            sign.setText("找回密码");
        }else{
            sign.setText("注册");
        }
    }

    /**
     * 初始化View
     */
    private void inintView() {
        telphone = (EditText) findViewById(R.id.ETextSign_Telphone);
        verificationCode = (EditText) findViewById(R.id.ETextSign_VerificationCode);
        btnVerificationCode = (Button) findViewById(R.id.BtnSign_VerificationCode);
        password = (EditText) findViewById(R.id.ETextSign_Password);
        surePassword = (EditText) findViewById(R.id.ETextSign_SurePassword);
        sign = (Button) findViewById(R.id.BtnSign_sign);
        boxUserAgreement = (CheckBox) findViewById(R.id.CBoxSign_userAgreement);
        textUserAgreement = (TextView) findViewById(R.id.TViewSign_userAgreement);


    }

    /**
     * 对每个组件进行设置点击事件
     */
    public void setOnClick(){
        btnVerificationCode.setOnClickListener(this);
        sign.setOnClickListener(this);
        textUserAgreement.setOnClickListener(this);
    }

    /**
     *判断输入的所有数据是否为空
     */
    public boolean filloutYoN(){
        //获取数据
        S_telphone =telphone.getText().toString().trim();
        S_verificationCode = verificationCode.getText().toString().trim();
        S_password = password.getText().toString().trim();
        S_surePassword = surePassword.getText().toString().trim();
        return S_telphone.isEmpty()||S_verificationCode.isEmpty()||S_password.isEmpty();
    }

    /**
     * 两次的密码是否一致
     * @return
     */
    public boolean surePassword(){
        return S_password.equals(S_surePassword);
    }

    /**
     * 判断是否同意用户协议
     * @return 用户是否点击对勾
     */
    public boolean userAgreementYoN(){
        return boxUserAgreement.isChecked();
    }


    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //获取验证码
            case R.id.BtnSign_VerificationCode:
                requestSmsCode();
                break;
            //用户协议
            case R.id.TViewSign_userAgreement:
                Intent intent = new Intent();
                intent.setClass(SignActivity.this,UserAgreementActivity.class);
                startActivity(intent);
                break;
            //注册按钮
            case R.id.BtnSign_sign:
                if (filloutYoN()){
                    Toast.makeText(SignActivity.this, "请完善全部信息", Toast.LENGTH_SHORT).show();
                }else if (!checkPhoneNumber.checkPhoneNum(S_telphone)){
                    Toast.makeText(SignActivity.this,"请正确输入手机号",Toast.LENGTH_SHORT).show();
                }else if (!verificationCodeRoW()){
                    Toast.makeText(SignActivity.this,"请正确填写验证码",Toast.LENGTH_SHORT).show();
                }else if (!userAgreementYoN()){
                    Toast.makeText(SignActivity.this,"请阅读用户协议",Toast.LENGTH_SHORT).show();
                }else if (!surePassword()){
                    Toast.makeText(SignActivity.this,"两次输入的密码不相同",Toast.LENGTH_SHORT).show();
                }
                //验证信息全部正确
                if (!filloutYoN()&& verificationCodeRoW() &&userAgreementYoN() && checkPhoneNumber.checkPhoneNum(S_telphone)&&surePassword()){
                    //数据赋值
                    //数据储存及后期逻辑
                    User user = new User();
                    user.setUsername("diyiwei");
                    user.setPassword(S_password);
                    user.setMobilePhoneNumber(S_telphone);
//                    user.setMobilePhoneNumberVerified(verificationCodeRoW());
                    user.signUp(this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            toast("存入云服务成功");
                            Intent intent = new Intent(SignActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        @Override
                        public void onFailure(int i, String s) {
                            toast("存入云服务失败");
                        }
                    });
                }
                break;
        }
    }

    /**
     * 请求验证码
     * 苑雪元 2016/04/11
     */
    private void requestSmsCode(){
        S_telphone =telphone.getText().toString().trim();
        if(!TextUtils.isEmpty(S_telphone)){
            BmobSMS.requestSMSCode(this, S_telphone, "注册模板", new RequestSMSCodeListener() {

                @Override
                public void done(Integer smsId,BmobException ex) {
                    // TODO Auto-generated method stub
                    if (ex == null) {//请求成功
                        toast("短信已发送，请注意查收");//短信编号
                    } else {
                        if(ex.getErrorCode()==10010){
                            toast("您的手机号发送短信达到限制，请稍后在发送");
                        }
                    }
                }
            });
        }else{
            toast("请输入手机号");
        }

    }
    /**
     * 短信验证码
     * 苑雪元 2016/04/11
     */
    private boolean verificationCodeRoW(){
        S_telphone =telphone.getText().toString().trim();
        S_verificationCode = verificationCode.getText().toString().trim();
        toast(S_telphone+S_verificationCode);
            BmobSMS.verifySmsCode(SignActivity.this,S_telphone,S_verificationCode, new VerifySMSCodeListener() {
                @Override
                public void done(BmobException ex) {
                    // TODO Auto-generated method stub
                    if(ex==null){//验证码验证通过
                        toast("验证码验证通过");
//                        smsTag = true;
                    }else{
                        toast("验证码不正确");
//                        smsTag = false;
                    }
                }
            });
        toast("ss"+smsTag);
        return smsTag;
    }



}
