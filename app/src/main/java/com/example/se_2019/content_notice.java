package com.example.se_2019;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.se_2019.Activity.MainActivity;
import com.example.se_2019.Activity.Preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class content_notice extends AppCompatActivity {
String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_notice);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.toolbar_home);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //상단바
        final Intent intent = getIntent();
        userID = intent.getExtras().getString("userID");



        ListView listView = (ListView)findViewById(R.id.listview_notice);
        List<String>list = new ArrayList<>();
        list.add("사과");
        list.add("배");
        list.add("귤");
        list.add("바나나");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);


        //리스트뷰에 보여질 아이템을 추가


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//여기서 e/menu_main UI를 가져옴
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        int id = item.getItemId();
        if (id == android.R.id.home) {
            Toast.makeText(this, "홈버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userID", userID);
            startActivity(intent);
        }
        if (id == R.id.toolbar_alarm) {
            Toast.makeText(this, "알람버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.toolbar_profile) {
            Toast.makeText(this, "프로필버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
            // SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(this);
            Intent intent = new Intent(this, Preferences.class);
            intent.putExtra("userID",userID);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
