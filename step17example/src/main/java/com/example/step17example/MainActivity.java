package com.example.step17example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
                            implements Util.RequestListener, AdapterView.OnItemClickListener {
    List<String> list;
    ArrayAdapter<String> adapter;
    JSONArray arr;
    //정수 상수 정의하기
    public static final int REQUEST_LIST=1;
    public static final int REQUEST_DETAIL=2;
    public static final int REQUEST_INSERT=3;
    //EditText의 참조값을 필드에 저장하기 위해
    EditText input_name, input_addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //아답타에 연결할 모델
        list=new ArrayList<>();

        //ListView에 연결할 아답타
        adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,list);
        //ListView의 참조값 얻어와서 아답타 연결하기
        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //ListView에 아이템 클릭 리스너 등록
        listView.setOnItemClickListener(this);
        //EditText의 참조값
        input_name=findViewById(R.id.input_name);
        input_addr=findViewById(R.id.input_addr);
        //Button의 참조값
        Button addBtn=findViewById(R.id.addBtn);
        //Button에 리스너 등록하기
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력한 이름과 주소 읽어오기
                String name=input_name.getText().toString();
                String addr=input_addr.getText().toString();
                //서버에 전송하기 위해 Map에 담기
                Map<String, String> map=new HashMap<>();
                map.put("name", name);
                map.put("addr", addr);
                //요청 url
                String url="http://192.168.219.108:8888/spring04/api/member/insert.do";
                //Util을 이용해서 post 방식으로 전송
                Util.sendPostRequest(REQUEST_INSERT, url, map, MainActivity.this);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //ListView에 출력할 데이터를 서버로부터 요청을 한다.
        String url="http://192.168.219.108:8888/spring04/api/member/list.do";
        Util.sendGetRequest(REQUEST_LIST, url, null, this);
    }

    @Override
    public void onSuccess(int requestId, Map<String, Object> result) {
        //서버가 응답한 JSON 문자열
        String data=(String)result.get("data");

        switch (requestId){
            case REQUEST_INSERT:
                //추가하고 난후에 어떤 작업을 해야할까?
                String url="http://192.168.219.108:8888/spring04/api/member/list.do";
                Util.sendGetRequest(REQUEST_LIST, url, null, this);
                //입력창 초기화
                input_name.setText("");
                input_addr.setText("");
                //키보드 숨기기
                Util.hideKeyboard(this);
                //포커스 뺏기
                Util.releaseFocus(input_name);
                Util.releaseFocus(input_addr);
                break;

            case REQUEST_LIST:
                //data는 [{},{},{}, ...] 형식의 JSON 문자열이다.
                try {
                    //List에 있는 내용을 일단 모두 삭제하고
                    list.clear();
                    //새로 넣어 준다.
                    arr=new JSONArray(data);
                    for(int i=0; i<arr.length(); i++){
                        JSONObject obj=arr.getJSONObject(i);
                        int num=obj.getInt("num");
                        String name=obj.getString("name");
                        String addr=obj.getString("addr");
                        list.add(num+" | "+name+" | "+addr);

                    }
                    //모델이 업데이트 되었다고 아답타에 알린다.
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;
            case REQUEST_DETAIL:
                //data는 {} 형식의 문자열이다.
                try {
                    JSONObject obj=new JSONObject(data);
                    int num=obj.getInt("num");
                    String name=obj.getString("name");
                    String addr=obj.getString("addr");
                    //응답된 회원의 번호, 이름, 주소를 MemberDto 객체에 담고
                    MemberDto dto=new MemberDto(num,name,addr);

                    //MemberDto 객체를 자세히 보기 Activity로 이동할 Intent 객체에 담고
                    Intent intent=new Intent(this, DetailActivity.class);
                    intent.putExtra("dto", dto);
                    //자세히 보기 Activity로 이동한다.
                    startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    @Override
    public void onFail(int requestId, Map<String, Object> result) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //클릭한 셀의 인덱스 값을 이용해서 JSONObject 객체의 참조값 얻어오기
        try {
            JSONObject obj=arr.getJSONObject(position);
            //클릭한 셀의 회원 번호
            int num=obj.getInt("num");
            //번호를 이용해서 회원 한명의 정보를 다시 요청한다.
            String url="http://192.168.219.108:8888/spring04/api/member/detail.do";
            //요청 파라미터를 Map에 담는다.
            Map<String,String> params=new HashMap<>();
            params.put("num", Integer.toString(num));
            //Util을 이용해서 요청 하기
            Util.sendGetRequest(2, url, params, this);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}