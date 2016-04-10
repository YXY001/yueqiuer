package com.cty.ball.yueqiuer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.cty.ball.yueqiuer.R;

public class MineActivity extends AppCompatActivity {
    private Button btn_changeInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_changeInfo= (Button) findViewById(R.id.btn_changeInfo);
        btn_changeInfo.setOnClickListener(changeInfo);
    }
    View.OnClickListener changeInfo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MineActivity.this,EditInfoActivity.class);
            startActivity(intent);
        }
    };


}
