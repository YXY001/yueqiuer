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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityInfoActivity extends AppCompatActivity {

    //模拟数据
    private String [] comments = {"11111111111","11111111111","22222222","3333333","3333333"};
    private int [] images = {R.drawable.qq,R.drawable.qq,R.drawable.qq,R.drawable.qq,R.drawable.qq};
    private ListView listView = null;
    private List list = new ArrayList<HashMap<String,Object>>();
    private Button BtnActivity_iSignUp;
    private View LLayout_ActivityInfo_seeAll;
    private ArrayAdapter<String> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_info);

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        //初始化组件
        inintView();
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



    private void inintView() {
        listView = (ListView) findViewById(R.id.ListActivityInfo);
        BtnActivity_iSignUp= (Button) findViewById(R.id.BtnActivity_iSignUp);
        LLayout_ActivityInfo_seeAll=findViewById(R.id.LLayout_ActivityInfo_seeAll);
        LLayout_ActivityInfo_seeAll.setOnClickListener(LLayout_seeAll);
        BtnActivity_iSignUp.setOnClickListener(btnSignUp);

    }

    View.OnClickListener btnSignUp =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(ActivityInfoActivity.this,UserSignUpActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener LLayout_seeAll =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(ActivityInfoActivity.this,MainActivity.class);
            startActivity(intent);
        }
    };

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


}
