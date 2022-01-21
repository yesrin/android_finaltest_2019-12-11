package com.example.finaltest_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Input extends AppCompatActivity {

    Button btnok,btncancel;
    EditText etName=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input); //실제실행은여기서 Main에서 넘겨준거

        btnok=(Button)findViewById(R.id.okbtn);
        btncancel=(Button) findViewById(R.id.cancelbtn);
        etName=(EditText)findViewById(R.id.EditText01);


        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED); //결과받아오는거 취소한다
                finish();
            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recin = getIntent();//받아오는함수
                String myname = etName.getText().toString();//toString 은 문자열로 받아오기위해서씀
                recin.putExtra("fname",myname);
                setResult(RESULT_OK,recin);
                finish();
            }
        });
    }
}
