package com.cty.ball.yueqiuer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import com.cty.ball.yueqiuer.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动列表界面，显示发布的特定种类的活动
 *
 * @author TYD
 */
public class ActivityListActivity extends AppCompatActivity {
    private ListView activityList_listview;
    private TextView TView_ActivityList_ball;
    private ArrayList<Map<String, Object>> arrayList = null;
    private String ball;
    private String[] names = {"石家庄", "保定", "暗淡", "横竖"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //点击加号跳转到发布活动界面
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityListActivity.this,ReleaseActivity.class);
                startActivity(intent);
            }
        });

        activityList_listview = (ListView) findViewById(R.id.activityList_listview);
        TView_ActivityList_ball= (TextView) findViewById(R.id.TView_ActivityList_ball);
        Intent intent=getIntent();
        ball=intent.getStringExtra("ball");
        TView_ActivityList_ball.setText(ball);
        arrayList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        int number = names.length;
        for (int i = 0; i < number; i++) {
            map.put("releaseTime", "0222");
            map.put("releasePosition", names[i]);
            arrayList.add(map);
        }

        MyAdapter myAdapter = new MyAdapter(ActivityListActivity.this, arrayList, R.layout.intentionactivitylist,
                new String[]{"releaseTime", "releasePosition"}, new int[]{R.id.TV_personList_nickname1, R.id.TView_personListName1});
        activityList_listview.setAdapter(myAdapter);
    }




    /**
     * 自定义适配器
     *
     * @author 谭亚东
     */
    private class MyAdapter extends SimpleAdapter {

        public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);
            //获取textview
            Button BtnActivity_iSignUp = (Button) v.findViewById(R.id.BtnActivityList_iSignUp);
            View activityListLayout = v.findViewById(R.id.LLayout_activityList_show);
            //通过设置tag来确定是哪个listview进行操作
            BtnActivity_iSignUp.setTag(position);
            activityListLayout.setTag(position);
            //获取当前简历的id
            //报名按钮的点击事件
            BtnActivity_iSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //通过当前listview的位置来获取id
                    Intent intent = new Intent(ActivityListActivity.this, UserSignUpActivity.class);
                    startActivity(intent);
                }
            });
            //查看全部报名人的点击事件
            activityListLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //通过当前listview的位置来获取id
                    //把id当成参数传过去
                    Intent intent = new Intent(ActivityListActivity.this, MySignUpActivity.class);
                    startActivity(intent);
                }
            });
            //整体的item的点击事件
            activityList_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ActivityListActivity.this, ActivityInfoActivity.class);
                    startActivity(intent);
                }
            });
            return v;
        }
    }

}
