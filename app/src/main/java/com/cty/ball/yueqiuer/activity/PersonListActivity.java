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

/**
 * 人员列表页面
 */
public class PersonListActivity extends AppCompatActivity {
    private ListView personList_listview;
    private ArrayList<Map<String,Object>> arrayList=null;
    private String[] names={"石家庄","保定","暗淡","横竖"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        personList_listview= (ListView) findViewById(R.id.personListlistview);
        arrayList=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        int number=names.length;
        for (int i=0;i<number;i++){
            map.put("releaseTime","0222");
            map.put("releasePosition",names[i]);
            arrayList.add(map);
        }

        MyAdapter myAdapter=new MyAdapter(PersonListActivity.this,arrayList,R.layout.intentionpersonlist,
                new String[]{"releaseTime","releasePosition"},new int[]{R.id.TV_personList_nickname1,R.id.TView_personListName1});
        personList_listview.setAdapter(myAdapter);
        personList_listview.setCacheColorHint(0);
        personList_listview.setFocusableInTouchMode(true);

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
