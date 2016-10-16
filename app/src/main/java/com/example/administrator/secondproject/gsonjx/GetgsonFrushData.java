package com.example.administrator.secondproject.gsonjx;

import com.example.administrator.secondproject.data.Refreshdata;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public class GetgsonFrushData {
    public static List<Refreshdata> getgson(String jsonstr){
        List<Refreshdata> list=new ArrayList<>();
        JSONObject jsonObject= null;
        try {
            jsonObject = new JSONObject(jsonstr);
            String jsonstring =jsonObject.getJSONObject("data").getJSONArray("data").toString();
            TypeToken<List<Refreshdata>> typeToken=new TypeToken<List<Refreshdata>>(){};
            list=new Gson().fromJson(jsonstring,typeToken.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
