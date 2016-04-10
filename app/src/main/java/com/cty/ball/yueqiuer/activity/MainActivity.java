package com.cty.ball.yueqiuer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.cty.ball.yueqiuer.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private GridView gridView=null;
    private List ListBalls=new ArrayList<HashMap<String,Object>>();
    int[] drawbleIds={R.drawable.basketball,R.drawable.soccer,R.drawable.tabletennis,R.drawable.tennis,R.drawable.badminton,R.drawable.billiards,R.drawable.bowling,R.drawable.volleyball,R.drawable.more};
    String [] sBalls=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //用户头像(限制图像大小55*55dp)
        ImageView touxiang = (ImageView) findViewById(R.id.imageView_changeIcon);

        toolbar.setNavigationIcon(R.drawable.touxiang);
        //用户名称

        toolbar.setTitle("用户名称");
        //右侧功能
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MineActivity.class);
                startActivity(intent);
            }
        });
        GridView gridView = (GridView) findViewById(R.id.gridView);

        //生成动态数组，并且传入数据
            sBalls=getResources().getStringArray(R.array.sBalls);
            for(int i=0;i<drawbleIds.length;i++){
                Map map = new HashMap<String,Object>();
                map.put("ItemImage",drawbleIds[i]);
                map.put("ItemText",sBalls[i]);
                ListBalls.add(map);
            }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,ListBalls,R.layout.gridview_item,new String[]{"ItemImage","ItemText"},new int[]{R.id.grid_imageView,R.id.grid_textView});
        //添加并且显示
        gridView.setAdapter(simpleAdapter);
        //添加消息处理
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ActivityListActivity.class);
                switch (sBalls[position]){
                    case "篮球":
                        intent.putExtra("ball","篮球");
                        startActivity(intent);
                        break;
                    case "足球":
                        intent.putExtra("ball", "足球");
                        startActivity(intent);
                        break;
                    case "乒乓球":
                        intent.putExtra("ball","乒乓球");
                        startActivity(intent);
                        break;
                    case "网球":
                        intent.putExtra("ball","网球");
                        startActivity(intent);
                        break;
                    case "羽毛球":
                        intent.putExtra("ball","羽毛球");
                        startActivity(intent);
                        break;
                    case "台球":
                        intent.putExtra("ball","台球");
                        startActivity(intent);
                        break;
                    case "保龄球":
                        intent.putExtra("ball","保龄球");
                        startActivity(intent);
                        break;
                    case "排球":
                        intent.putExtra("ball","排球");
                        startActivity(intent);
                        break;
                    case "更多":
                        Toast.makeText(MainActivity.this,"敬请期待...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //inspection SimplifiableIfStatement
        if (id == R.id.action_release) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MyReleaseActivity.class);
            startActivity(intent);
        }if (id == R.id.action_signup) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MySignUpActivity.class );
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }




}
