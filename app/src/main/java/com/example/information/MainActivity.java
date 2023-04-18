package com.example.information;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tVResult, tVResultLabel;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tVResult = findViewById(R.id.tVResult);
        tVResultLabel = findViewById(R.id.tVResultLabel);

        Button btnRequest =findViewById(R.id.btnRequest);
        Button btnEnd = findViewById(R.id.btnEnd);

        EditText editTextID = findViewById(R.id.editTextID);




        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str = editTextID.getText().toString(); // 문자열로 형변환 해주는 메소드이다.
                Intent it = new Intent(getApplicationContext(),InformationActivity.class);
                it.putExtra("id", str);
                startActivityForResult(it, 1);
            }
        });





        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}