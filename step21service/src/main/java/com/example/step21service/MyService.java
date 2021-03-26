package com.example.step21service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class MyService extends Service {
    //카운트 값을 저장할 필드
    int count;

    //생성자
    public MyService() {
        Log.e("MyService", "생성자 호출됨!");
    }
    //액티비티에서 이 서비스를 연결할때 호출되는 메소드
    @Override
    public IBinder onBind(Intent intent) {
        //IBinder 객체를 리턴해주면 되는데
        //연결하지 않을거면 null 을 리턴해주면 된다.
        return null;
    }
    //서비스가 최초 활성화 될때 호출되는 메소드
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyService","onCreate()");
    }
    //서비스가 시작될때 호출되는 메소드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("MyService", "onStartCommand()");
        //핸들러에 메세지 보내기
        handler.removeMessages(0);
        handler.sendEmptyMessage(0);

        /*
            백그라운드 서비스는 운영체제가 시스템 자원이 부족하면 강제 종료한다.
            강제 종료후 자원의 여력이 생기면 자동으로 다시 서비스가 시작되기를
            원하면 START_STICKY 상수를 리턴하면 된다.
            하지만 언제 다시 시작될지 보장은 안된다.

        */
        return START_STICKY;
    }
    //서비스가 비활성화 될때 호출되는 메소드
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService", "onDestroy()");
        //핸들러 메세지 제거
        handler.removeMessages(0);
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            count++;
            Log.e("MyService.Handler", "count:"+count);
            //핸들러에 1초 이후에 빈 메세지 보내기
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    };
}
