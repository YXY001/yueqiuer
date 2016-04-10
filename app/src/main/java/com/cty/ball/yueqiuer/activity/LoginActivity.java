package com.cty.ball.yueqiuer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cty.ball.yueqiuer.R;
import com.cty.ball.yueqiuer.utils.CheckPhoneNumber;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText telphone,password;
    private Button login,sign;
    private TextView forgetPassword,userSign;
    private String S_telphone,S_password;
    private CheckPhoneNumber checkPhoneNumber;
    private LinearLayout QQ,WeiBo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化View
        inintView();
        //设置点击事件
        setOnClick();
    }

    /**
     * 初始化View
     */
    private void inintView() {
        telphone = (EditText) findViewById(R.id.ETextLogin_Telphone);
        password = (EditText) findViewById(R.id.ETextLogin_Password);
        login = (Button) findViewById(R.id.BtnLogin_login);
        sign = (Button) findViewById(R.id.BtnSign_sign);
        forgetPassword = (TextView) findViewById(R.id.TViewLogin_ForgetPassword);
        userSign = (TextView) findViewById(R.id.TViewLogin_Sign);
        QQ = (LinearLayout) findViewById(R.id.LayoutLogin_QQ);
        WeiBo = (LinearLayout) findViewById(R.id.LayoutLogin_WeiBo);
    }

    /**
     * 对每个组件进行设置点击事件
     */
    public void setOnClick(){
        login.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
        userSign.setOnClickListener(this);
        QQ.setOnClickListener(this);
        WeiBo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnLogin_login:
                break;
            case R.id.TViewLogin_ForgetPassword:
                Intent intent = new Intent();
                intent.putExtra("sign","1");
                intent.setClass(LoginActivity.this,SignActivity.class);

                startActivity(intent);

                break;
            case R.id.TViewLogin_Sign:
                Intent intent1 = new Intent();
                intent1.putExtra("sign", "2");
                intent1.setClass(LoginActivity.this,SignActivity.class);

                startActivity(intent1);
                break;
            case R.id.LayoutLogin_QQ:
                break;
            case R.id.LayoutLogin_WeiBo:
                break;
        }
    }
}
