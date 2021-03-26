package com.example.step06listener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //id가 sendBtn인 Button의 참조값 얻어오기
        Button sendBtn = findViewById(R.id.sendBtn);
        //수정, 삭제 버튼의 참조값도 얻어오기
        Button updateBtn = findViewById(R.id.updateBtn);
        Button deleteBtn = findViewById(R.id.deleteBtn);
        //전송 버튼에 필드에 저장된 클릭 리스너 등록하기
        sendBtn.setOnClickListener(this);
        //수정, 삭제 버튼에도 동일한 리스너 등록하기
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        deleteBtn.setOnLongClickListener(this);
    }
    /*
        리스너로 등록한 UI에 클릭 이벤트가 발생하면 호출되는 메소드

        인자로 전달된 View v 에는 클릭 이벤트가 일어난 UI(버튼)의 참조값이 들어 있다.

     */
    @Override
    public void onClick(View v) {
       //이벤트가 일어난 UI에 부여된 아이디값을 읽어와서 분기한다.
        /*
       if(R.id.sendBtn==v.getId()){
           Toast.makeText(this, "전송합니다.",Toast.LENGTH_SHORT).show();
       }else if(R.id.updateBtn==v.getId()){
           Toast.makeText(this, "수정합니다.",Toast.LENGTH_SHORT).show();
       }else if(R.id.deleteBtn==v.getId()){
           Toast.makeText(this, "삭제합니다.",Toast.LENGTH_SHORT).show();
        }

         */
        //if~else if 문 대신에 switch문도 가능하다.
        switch (v.getId()){
            case R.id.sendBtn:
                Toast.makeText(this, "전송합니다.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.updateBtn:
                Toast.makeText(this, "수정합니다.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.deleteBtn:
                Toast.makeText(this, "삭제합니다.",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "그만좀 눌러", Toast.LENGTH_SHORT).show();
        return false;
    }
}