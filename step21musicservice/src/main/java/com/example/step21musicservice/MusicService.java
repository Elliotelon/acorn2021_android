package com.example.step21musicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

public class MusicService extends Service {
    //필드
    MediaPlayer player;
    //필드로 바인더 객체를 가지고 있게 한다.
    final IBinder binder=new LocalBinder();
    //필드로 MainActivity의 참조값을 저장하기 위해
    MainActivity activity;

    public MusicService() {
        Log.e("MusicService", "MusicService()");
    }
    //액티비티가 서비스에 연결하면 호출되는 메소드
    @Override
    public IBinder onBind(Intent intent) {
        //바인터 객체를 리턴해준다.
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MusicService", "onCreate()");
        // res/raw/mp3piano  음악을 로딩해서 준비하기
        player=MediaPlayer.create(this, R.raw.mp3piano);
        //음악이 재생되는 동안 기기를 깨워 두기
        player.setWakeMode(this, PowerManager.PARTIAL_WAKE_LOCK);
        //재생할 준비가 완료 되었을때 호출되는 리스너 등록
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

            }
        });
        //재생이 완료 되었을때 호출되는 리스너 등록
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(activity != null){
                    activity.showInfo("재생이 완료 되었습니다.");
                }
            }
        });
    }

    //서비스가 시작될때 호출되는 메소드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("MusicService", "onStartCommand()");
        //재생
        player.start();
        //운영체제가 강제로 종료시켜도 다시 시작 되지 않도록
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.e("MusicService", "onDestroy()");
        //중지 및 자원 해제
        player.stop();
        player.release();
        //종료 되기 전에 작업은 super.onDestroy() 호출하기 전에 한다.
        super.onDestroy();
    }

    //만일 특정 액티비티에서 아래의 메소드를 호출하고 싶다면?
    public void pauseMusic(){
        player.pause();
    }
    public void playMusic(){
        player.start();
    }

    //Binder 클래스를 상속 받아서 LocalBinder 클래스를 정의한다.
    public class LocalBinder extends Binder{
        //서비스 객체의 참조값을 리턴해주는 메소드
        public MusicService getService(){
            return MusicService.this;
        }
        //MainActivity의 참조값을 전달 받는 메소드
        public void setActivity(MainActivity activity){
            //인자로 전달받은 액티비티의 참조값을
            //MusicService의 필드에 저장하기
            MusicService.this.activity=activity;
        }
    }

    //액티비티와 바인딩이 해제 되었을때 호출되는 메소드
    @Override
    public boolean onUnbind(Intent intent) {
        //필드를 비워 둔다.
        activity=null;
        return super.onUnbind(intent);
    }
}