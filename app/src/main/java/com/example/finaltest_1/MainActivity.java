package com.example.finaltest_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvName;
   // Boolean bLog=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName=(TextView)findViewById(R.id.text01);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==1 && resultCode==RESULT_OK) {
            String resName = data.getStringExtra("fname"); //길동이랑 fname이 문자열이기 때문에 넣음 resName에 길동 들어갈거임
            tvName.append(""+resName+"\n"); //이름그대로 두고(append:현제있던거 그대로두고 끝에붙인다) 그 아래에 출력시킬거
        }
    }//결과받아오는 함수(1,,300번지) cancle은 텅빈거 보냄.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        menu.findItem(R.id.stylec).setEnabled(tvName.isTextSelectable());
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        String str =tvName.getText().toString();

        if(str.getBytes().length<=0){
            menu.findItem(R.id.stylec).setEnabled(false);
        }
        else{
            menu.findItem(R.id.stylec).setEnabled(true);
        }

//        if(bLog==true){
//            menu.findItem(R.id.stylec).setEnabled(false);
//            bLog=false;
//        }else{
//            menu.findItem(R.id.stylec).setEnabled(true);
//        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.inputc:
                Intent i =new Intent(MainActivity.this,Input.class);
                startActivityForResult(i,1);
                return true;
            case R.id.menubold:
                tvName.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                return true;
            case R.id.menultalic:
                tvName.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
                return true;
            case R.id.menunomal:
                tvName.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}

