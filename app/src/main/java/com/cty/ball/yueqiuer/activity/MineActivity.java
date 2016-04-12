package com.cty.ball.yueqiuer.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cty.ball.yueqiuer.R;
import com.cty.ball.yueqiuer.utils.LoginOrNot;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

public class MineActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_changeInfo,btn_signOut,btn_changePwd,btn_checkUpdate;
    private TextView textView_userName;

    private BmobUser bmobUser;

    private Intent intent;

    private LoginOrNot loginOrNot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //初始化界面
        initView();
        //设置点击事件
        click();

        //判断用户是否登录
        loginOrNot = new LoginOrNot(bmobUser);
    }

    /**
     * Toast的方法
     * @param msg
     */
    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /**
     * 初始化界面
     */
    public void initView(){
        textView_userName = (TextView) findViewById(R.id.textView_uesrname);

        btn_changeInfo= (Button) findViewById(R.id.btn_changeInfo);
        btn_changePwd = (Button) findViewById(R.id.btn_changePwd);
        btn_checkUpdate = (Button) findViewById(R.id.btn_checkUpdate);
        btn_signOut = (Button) findViewById(R.id.btn_signOut);

        bmobUser= BmobUser.getCurrentUser(MineActivity.this);
    }

    //点击事件
    public void click(){
        btn_changeInfo.setOnClickListener(this);
        btn_changePwd.setOnClickListener(this);
        btn_checkUpdate.setOnClickListener(this);
        btn_signOut.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //修改个人信息
            case R.id.btn_changeInfo:
                loginOrNot.loginOrNot(MineActivity.this, EditInfoActivity.class);
                break;

            //修改密码
            case R.id.btn_changePwd:
                loginOrNot.loginOrNot(MineActivity.this,UpdatePasswordActivity.class);
                break;
            //检查更新
            case R.id.btn_checkUpdate:
                break;
            //退出登录
            case R.id.btn_signOut:
                if (bmobUser!=null){
                    signOutDialog();
                }else {
                    intent = new Intent(MineActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

                break;
        }
    }

    /**
     * 退出确认
     * 苑雪元 2016/04/12
     */
    public void signOutDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MineActivity.this);
        builder.setTitle("提示");
        builder.setMessage("退出当前账号？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BmobUser.logOut(MineActivity.this);   //清除缓存用户对象
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }


}
