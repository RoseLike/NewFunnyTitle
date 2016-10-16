package com.example.administrator.secondproject.sql_manager;

/**
 * Created by Administrator on 2016/9/28.
 */
public class Mydata {
    String tittle;
    String httpUrl;
    String imageUrl;

    public Mydata(String tittle, String httpUrl, String imageUrl) {
        this.tittle = tittle;
        this.httpUrl = httpUrl;
        this.imageUrl = imageUrl;
    }
    public Mydata(){
        super();
    }
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
