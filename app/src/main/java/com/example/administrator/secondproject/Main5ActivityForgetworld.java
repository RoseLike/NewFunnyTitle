package com.example.administrator.secondproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.secondproject.login.MySharePrefarse;

public class Main5ActivityForgetworld extends AppCompatActivity implements View.OnClickListener {
    EditText userInfo, userNewPsw;
    Button button, button2;
    TextView userText;
    MySharePrefarse prefarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_forget_wworld);
        userInfo = (EditText) findViewById(R.id.forget_pswId);
        userNewPsw = (EditText) findViewById(R.id.forget_NewPswId);
        button = (Button) findViewById(R.id.forget_buttonId);
        userText = (TextView) findViewById(R.id.forget_findId);
        button2= (Button) findViewById(R.id.forget_SecondtonId);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        prefarse = new MySharePrefarse(this);
    }




    @Override
    public void onClick(View v) {
        String user = userInfo.getText().toString();
        switch (v.getId()) {
            case R.id.forget_buttonId:

                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(getApplicationContext(), "请输入正确的电话号码", Toast.LENGTH_LONG).show();
                    button.setVisibility(View.VISIBLE);
                } else if (user.length() == 11 && user.startsWith("1")) {
                    userText.setText("请输入新的密码");
                    button.setVisibility(View.GONE);
                }else {

                    Toast.makeText(getApplicationContext(),"请输入正确的电话号码",Toast.LENGTH_LONG).show();


                }

                break;
            case R.id.forget_SecondtonId:
                String psw = userNewPsw.getText().toString();
                if (!TextUtils.isEmpty(psw)) {
                    userText.setText("请牢记您的新密码" + psw);
                    prefarse.dellwith(user);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(getApplicationContext(), "密码设置失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
