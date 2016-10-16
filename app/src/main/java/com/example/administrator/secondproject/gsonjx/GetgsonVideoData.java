package com.example.administrator.secondproject.gsonjx;

import com.example.administrator.secondproject.data.Videodata;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class GetgsonVideoData {
   public static List<Videodata> getgson(String jsonstr){
       List<Videodata> list=new ArrayList<>();
       JSONObject jsonObject= null;
       try {
           jsonObject = new JSONObject(jsonstr);
           String jsonstring =jsonObject.getJSONObject("data").getJSONArray("data").toString();
           TypeToken<List<Videodata>> typeToken=new TypeToken<List<Videodata>>(){};
           list=new Gson().fromJson(jsonstring,typeToken.getType());
       } catch (JSONException e) {
           e.printStackTrace();
       }
       return list;
   }
}
