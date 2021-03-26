package com.example.exam1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inputMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send=findViewById(R.id.send);
        send.setOnClickListener(this);
        inputMsg=findViewById(R.id.inputMsg);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, inputMsg.getText().toString(), Toast.LENGTH_SHORT)
                .show();
    }
}