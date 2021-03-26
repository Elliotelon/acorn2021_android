package com.example.step12gameview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //게임시작 버튼을 눌렀을때 GameActivity로 이동하도록 한다.
        Button startBtn=findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
        /*
        //SoundManager 객체 생성하고
        SoundManager manager=new SoundManager(this);
        //효과음 로딩하기
        manager.addSound(1,R.raw.laser1);
        manager.addSound(2,R.raw.shoot1);
        manager.addSound(3,R.raw.birddie);

        Button playBtn=findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.playSound(1);
            }
        });

         */
    }
}