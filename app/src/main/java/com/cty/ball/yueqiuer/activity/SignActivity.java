package com.cty.ball.yueqiuer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cty.ball.yueqiuer.R;
import com.cty.ball.yueqiuer.utils.CheckPhoneNumber;

public class SignActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText telphone,verificationCode,password,surePassword;
    private Button sign,btnVerificationCode;
    private CheckBox boxUserAgreement;
    private TextView textUserAgreement;
    private String S_telphone,S_verificationCode,S_password,S_surePassword;
    private CheckPhoneNumber checkPhoneNumber;

    private final static String  TAG = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //初始化类
        checkPhoneNumber = new CheckPhoneNumber();

        //初始化View
        inintView();
        //设置点击事件
        setOnClick();
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
        S_telphone =telphone.getText().toString().trim();
        S_verificationCode = verificationCode.getText().toString().trim();
        S_password = password.getText().toString().trim();
        S_surePassword = surePassword.getText().toString().trim();
        return S_telphone.isEmpty()||S_verificationCode.isEmpty()||S_password.isEmpty();
    }

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
     * 获取验证码
     * @return 验证码
     */
    public String analyzeCode(){
        return "123456";
    }

    /**
     * 判断验证码是否正确
     * @return 输入的验证码和发送的验证码是否一致
     */
    public boolean verificationCodeRoW(){
        return S_verificationCode.equals(analyzeCode());
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
                break;
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
                if (!filloutYoN()&& verificationCodeRoW() &&userAgreementYoN() && checkPhoneNumber.checkPhoneNum(S_telphone)){
                    /*Intent intent = new Intent();
                    intent.putExtra("userName", S_telphone);
                    intent.putExtra("password", S_password);
                    intent.setClass(SignActivity.this, LoginActivity.class);
                    startActivity(intent);*/
                }
                break;
        }
    }
}
