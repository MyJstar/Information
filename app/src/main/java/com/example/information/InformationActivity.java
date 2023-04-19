package com.example.information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent it = getIntent();
        String str= it.getStringExtra("id");

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextAge = findViewById(R.id.editTextAge);
        RadioButton radioMale = findViewById(R.id.radioMale);
        RadioButton radioFemale = findViewById(R.id.radioFemale);
        CheckBox cBInfo = findViewById(R.id.cBinfo);
        CheckBox cBInfoAi = findViewById(R.id.cBAI);
        CheckBox cBSecurity = findViewById(R.id.cBSecurity);

        Button btnSend = findViewById(R.id.btnSend);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(); //  액티비티를 실행요청을 하지도 않고, 스택에 쌓이지 않으므로 매개변수가 필요없다.
                it.putExtra("name", editTextName.getText().toString());
                it.putExtra("age", editTextAge.getText().toString());
                if( radioMale.isChecked()==true){
                    it.putExtra("sex", "남자");
                }else
                    it.putExtra("sex", "여자");

                String strLicense = "";
                if (cBInfo.isChecked())
                    strLicense += "\n 정보처리기사";
                if (cBInfoAi.isChecked())
                    strLicense += "\n 인공지능 ";
                if (cBSecurity.isChecked())
                    strLicense += "\n 네트워크보안";

                it.putExtra("license", strLicense);
                setResult(RESULT_OK, it);
                finish();

            }
        });
    }
}
