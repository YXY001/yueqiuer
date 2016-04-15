package com.cty.ball.yueqiuer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.cty.ball.yueqiuer.R;
import com.cty.ball.yueqiuer.entity.ActivityList;
import com.cty.ball.yueqiuer.entity.BallType;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class ReleaseActivity extends AppCompatActivity {

    private EditText ETextReleaseActivity_Name;
    private EditText ETextReleaseActivity_Data;
    private EditText ETextReleaseActivity_location;
    private EditText ETextReleaseActivity_personNumber;
    private EditText ETextReleaseActivity_introduce;
    private int ballTypeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        String strActivityName="";
        ETextReleaseActivity_Name = (EditText) findViewById(R.id.ETextReleaseActivity_Name);
        strActivityName=ETextReleaseActivity_Name.getText().toString().trim();

        String strActivityLocation="";
        ETextReleaseActivity_location = (EditText) findViewById(R.id.ETextReleaseActivity_location);
        strActivityLocation=ETextReleaseActivity_location.getText().toString().trim();

        String strActivityPersonNumber="";
        ETextReleaseActivity_personNumber = (EditText) findViewById(R.id.ETextReleaseActivity_personNumber);
        strActivityPersonNumber=ETextReleaseActivity_personNumber.getText().toString().trim();

        String strActivityIntroduce="";
        ETextReleaseActivity_introduce = (EditText) findViewById(R.id.ETextReleaseActivity_introduce);
        strActivityIntroduce=ETextReleaseActivity_introduce.getText().toString().trim();

        Intent intent = getIntent();
        String balltype=intent.getStringExtra("ballType");
        BmobQuery<BallType> query = new BmobQuery<BallType>();
        query.addWhereEqualTo("ballTypeName",balltype);
        query.findObjects(ReleaseActivity.this, new FindListener<BallType>() {
            @Override
            public void onSuccess(List<BallType> list) {
                BallType ballType=list.get(0);
                ballTypeId=ballType.getBallTypeID();
            }

            @Override
            public void onError(int i, String s) {

            }
        });

        ActivityList activityList = new ActivityList();
        activityList.setActivityName(strActivityName);
        activityList.setBallTypeID(ballTypeId);
        activityList.setInitiatorID();
        activityList.setParticipantID();
        activityList.setDate();
        activityList.setStartHour();
        activityList.setEndHour();
        activityList.setPalce(strActivityLocation);
        activityList.setActivityIntroduce(strActivityIntroduce);
        activityList.setPersonNum(Integer.valueOf(strActivityPersonNumber));
        activityList.setParticipantNum(null);
        //默认状态为未开始
        activityList.setState(0);



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
}
