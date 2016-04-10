package com.cty.ball.yueqiuer.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cty.ball.yueqiuer.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySignUpActivity extends AppCompatActivity {
    private ListView mySignUpListview;
    private ArrayList<Map<String,Object>> arrayList=null;
    private String[] names={"石家庄","保定","暗淡","横竖"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mySignUpListview= (ListView) findViewById(R.id.mySignUpListview);
        arrayList=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        int number=names.length;
        for (int i=0;i<number;i++){
            map.put("releaseTime","0222");
            map.put("releasePosition",names[i]);
            arrayList.add(map);
        }
        MyAdapter myAdapter=new MyAdapter(MySignUpActivity.this,arrayList,R.layout.intentionsignup,
                new String[]{"releaseTime","releasePosition"},new int[]{R.id.TView_signupTime1,R.id.TView_signupPosition1});
        mySignUpListview.setAdapter(myAdapter);
        //去除背景
//        mySignUpListview.setCacheColorHint(0);
        mySignUpListview.setFocusableInTouchMode(true);
    }


    /**
     * 自定义适配器
     * @author  谭亚东
     */
    private  class MyAdapter extends SimpleAdapter {

        public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v=super.getView(position,convertView,parent);
            return v;
        }
    }

}
