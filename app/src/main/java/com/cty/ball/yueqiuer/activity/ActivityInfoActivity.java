package com.cty.ball.yueqiuer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cty.ball.yueqiuer.R;
import com.cty.ball.yueqiuer.utils.LoginOrNot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.BmobUser;

public class ActivityInfoActivity extends AppCompatActivity implements View.OnClickListener {

    //模拟数据
    private String [] comments = {"11111111111","11111111111","22222222","3333333","3333333"};
    private int [] images = {R.drawable.qq,R.drawable.qq,R.drawable.qq,R.drawable.qq,R.drawable.qq};
    private ListView listView = null;
    private List list = new ArrayList<HashMap<String,Object>>();
    private Button BtnActivity_iSignUp,BtnActivity_commitMyComment;
    private View LLayout_ActivityInfo_seeAll;
    private ArrayAdapter<String> adapter = null;

    private BmobUser bmobUser;
    private LoginOrNot loginOrNot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_info);

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        //初始化组件
        inintView();

        //点击事件
        click();
        final int length = comments.length;
        for(int i = 0;i<length;i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("image",images[i]);
            map.put("comment",comments[i]);
            list.add(map);
        }

        SimpleAdapter arrayAdapter = new SimpleAdapter(getBaseContext(),list,R.layout.all_comments,new String[]{"image","comment"},new int[]{R.id.IViewActivity_commentImage,R.id.TViewActivity_commentInfo});

        listView.setAdapter(arrayAdapter);
    }


    /**
     * 初始化界面
     */
    private void inintView() {
        listView = (ListView) findViewById(R.id.ListActivityInfo);
        BtnActivity_iSignUp= (Button) findViewById(R.id.BtnActivity_iSignUp);
        BtnActivity_commitMyComment = (Button) findViewById(R.id.BtnActivity_commitMyComment);
        LLayout_ActivityInfo_seeAll=findViewById(R.id.LLayout_ActivityInfo_seeAll);
        //获取当前用户
        bmobUser = BmobUser.getCurrentUser(this);
        //声明判断是否登录类
        loginOrNot = new LoginOrNot(bmobUser);

    }

    /**
     * 点击事件
     */
    private void click(){
        LLayout_ActivityInfo_seeAll.setOnClickListener(this);
        BtnActivity_iSignUp.setOnClickListener(this);
        BtnActivity_commitMyComment.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //查看全部报名人数
            case R.id.LLayout_ActivityInfo_seeAll:
                Intent intent = new Intent(ActivityInfoActivity.this,MySignUpActivity.class);
                startActivity(intent);
                break;
            //我要参加按钮
            case R.id.BtnActivity_iSignUp:
                loginOrNot.loginOrNot(ActivityInfoActivity.this,UserSignUpActivity.class);
                break;
            //提交评论,磁珠也要设置权限
            case R.id.BtnActivity_commitMyComment:
                break;
        }

    }
}
