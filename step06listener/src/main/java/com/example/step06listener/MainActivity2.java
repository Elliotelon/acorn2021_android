package com.example.step06listener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    //익명의 local inner class를 이용해서 View.OnClickListener type의 참조값 얻어내기
    View.OnClickListener listener = new View.OnClickListener() {
        //이 리스너 객체를 등록한 UI에 클릭 이벤트가 발생하면 호출되는 메소드
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity2.this, "전송합니다.2", Toast.LENGTH_SHORT).show();

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id가 sendBtn인 Button의 참조값 얻어오기
        Button sendBtn = findViewById(R.id.sendBtn);

        //전송 버튼에 필드에 저장된 클릭 리스너 등록하기
        sendBtn.setOnClickListener(listener);
    }
}