package com.example.administrator.secondproject.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/28.
 */
public class MySharePrefarse {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;
    boolean result=false;
    public MySharePrefarse(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        editor = preferences.edit();


    }
     public void dellwith(String user){
         editor.remove(user);
         editor.commit();
     }
    public void getUserInfo(String name, String passworld,View view) {
       if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(passworld)){


           if (name.length() == 11 && passworld != null&&!(name.equals(preferences.getString("name","majunjun")))) {
               editor.putString("name", name);
               editor.putString("pass", passworld);
               editor.commit();
               Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show();
               view.setVisibility(View.GONE);

           }  else  {

               Toast.makeText(context, "请输入正确的注册信息", Toast.LENGTH_SHORT).show();
           }

       }else {

           Toast.makeText(context,"输入注册信息不能为空",Toast.LENGTH_SHORT).show();
       }

    }

    public boolean checkuser(String names, String passworld,View view) {
        if (!TextUtils.isEmpty(names) && !TextUtils.isEmpty(passworld)) {
            if (names.equals(preferences.getString("name","majunjun")) &&
                    passworld.equals(preferences.getString("pass", "123"))) {
             Toast.makeText(context,"欢迎登录",Toast.LENGTH_SHORT).show();
                view.setVisibility(View.GONE);
            } else if (!(names.equals(preferences.getString("name","majunjun")))||!(passworld.equals(preferences.getString("pass","123")))){
                Toast.makeText(context, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
