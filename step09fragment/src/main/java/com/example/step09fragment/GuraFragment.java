package com.example.step09fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/*
    [Fragment 만드는 방법]
    1. Fragment 클래스를 상속받는다.
    2. 프레그먼트의 layout xml 문서를 만든다.
    3. onCreateView() 메소드를 오버라이딩한다.


 */
public class GuraFragment extends Fragment implements View.OnClickListener {
    TextView textView;
    int count;
    //프레그먼트가 관리할 화면 View를 만들어서 리턴해 줘야 한다.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //인자로 전달되는 레이아웃 전개자 객체를 이용해서 View를 만들어서
        View view=inflater.inflate(R.layout.fragment_gura, container);
        //만든 View에서 TextView의 참조값을 얻어온다.
        textView=view.findViewById(R.id.textView);
        textView.setOnClickListener(this);

        //리턴해준다.
        return view;
    }

    //TextView를 클릭하면 호출되는 메소드
    @Override
    public void onClick(View v) {
        //v 에는 이벤트가 발생한 TextView의 참조값이 전달된다.
        boolean result = textView==v; //true
        //TextView의 참조값을 부모타입(View)로 받았기 때문에
        //캐스팅을 해야 TextView안에 있는 메소드 사용가능하다.

        //TextView t=(TextView)v;
        //t.setText("Click");

        count++;
        textView.setText(Integer.toString(count));
        //textView.setText(R.string.msg);

        //만일 count가 10의 배수라면 현재 나를 관리하는 액티비티에 해당 정보를 알려보자

        //프레그먼트를 관리하는 액티비티의 참조값을 부모 type으로 얻어오기
        FragmentActivity fa=getActivity();
        //액티비티가 GuraFragmentListener type이 맞는지(인터페이스를 구현) 확인
        if(fa instanceof GuraFragmentListener && count%10==0){
            GuraFragmentListener ma2=(GuraFragmentListener)fa;
            ma2.wow(count+"입니다");
        }

    }
    //리셋 하는 메소드
    public void reset(){
        count=0;
        textView.setText("0");
    }


    //이 프레그먼트를 사용하는 액티비티가 구현해야 하는 메소드
    public interface GuraFragmentListener{
        public void wow(String msg);
    }
}
