package com.example.exam2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //필요한 필드 정의하기
    List<String> names;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ListView의 참조값 얻어오기
        ListView listView=findViewById(R.id.listView);
        //ListView에 출력할 모델
        names=new ArrayList<>();
        names.add("한국");
        names.add("미국");
        names.add("캐나다");
        names.add("중국");
        names.add("호주");
        names.add("독일");
        names.add("프랑스");
        names.add("이탈리아");
        names.add("브라질");
        names.add("남아공");

        //new ArrayAdapter<>(Context , layout resource, 모델)
        adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                names);
        //ListView에 아답타 연결하기
        listView.setAdapter(adapter);
    }
}