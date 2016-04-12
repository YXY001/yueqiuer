package com.cty.ball.yueqiuer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.cty.ball.yueqiuer.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

public class UpdatePasswordActivity extends AppCompatActivity {

    private EditText oldPassword,newPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        //初始化
        initView();

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
    private void initView(){
        oldPassword = (EditText) findViewById(R.id.changPassword_before);
        newPassword = (EditText) findViewById(R.id.changPassword_new);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_updatepassword, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //inspection SimplifiableIfStatement
        if (id == R.id.action_sure) {
            String S_oldPassword = oldPassword.getText().toString().trim();
            String S_newPassword = newPassword.getText().toString().trim();
            if(!TextUtils.isEmpty(S_oldPassword)&&!TextUtils.isEmpty(S_newPassword)){
                updatePassword(S_oldPassword, S_newPassword);
            }
        }


        return super.onOptionsItemSelected(item);
    }


    /**
     * 修改密码的Bmob服务器
     * 苑雪元 2016/04/12
     */
    public void updatePassword(String oldPassword,String newPassword){
        BmobUser.updateCurrentUserPassword(this, oldPassword, newPassword, new UpdateListener() {

            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
                toast("smile---密码修改成功，可以用新密码进行登录啦");
                Intent intent = new Intent(UpdatePasswordActivity.this,MineActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(int code, String msg) {
                // TODO Auto-generated method stub
                toast("smile---密码修改失败：" + msg + "(" + code + ")");
            }
        });
    }
}
