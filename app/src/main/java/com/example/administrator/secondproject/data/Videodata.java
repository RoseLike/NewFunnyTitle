package com.example.administrator.secondproject.data;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public class Videodata {

    /**
     * id : 141651
     * source : 腾讯视频
     * source_name :
     * source_id : 腾讯视频
     * title : 深圳6岁女童被拐 两天后在东莞找到
     * type : 1
     * read_count : 9192
     * share_count : 50
     * comment_count : 79
     * url : http://html.1sapp.com/detail/2016/09/22/141651.html?content_id=141651&key=90752Dx_BGmU6kLp5WHoHMBs_GyzKkSu2c_ByRVklUpfjMvcDy29jQk5rd-soMkbk0s7MEcXrsimIhYcEsmTSMJf8aneeYCaVX03wPFz6wxYfICbvW3C6FhAljZsmmUnXA&pv_id=%7BE7E471FC-FFA6-B6EE-C21A-DCE1D2BE3F8F%7D&cid=255&cat=1&rss_source=%E8%85%BE%E8%AE%AF%E8%A7%86%E9%A2%91&fr=11&o=2&p=1
     * is_hot : 0
     * is_top : 0
     * introduction :
     * tag : ["女童","东莞","深圳"]
     * cover : ["http://static.1sapp.com/image/sp/2016/09/22/57e3ccf9e13de.png?imageView2/2/w/1000/h/600/q/90/format/jpeg"]
     * cover_show_type : 4
     * share_type : 0
     * can_comment : 1
     * publish_time : 1474546938797
     * content_type : 3
     * unlike_enable : 0
     * show_comment : 0
     * show_time : 1474910792
     * is_favorite : false
     */

    private String id;
    private String source;
    private String source_name;
    private String source_id;
    private String title;
    private String type;
    private String read_count;
    private String share_count;
    private String comment_count;
    private String url;
    private String is_hot;
    private String is_top;
    private String introduction;
    private String cover_show_type;
    private String share_type;
    private String can_comment;
    private String publish_time;
    private String content_type;
    private int unlike_enable;
    private int show_comment;
    private int show_time;
    private boolean is_favorite;
    private List<String> tag;
    private List<String> cover;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRead_count() {
        return read_count;
    }

    public void setRead_count(String read_count) {
        this.read_count = read_count;
    }

    public String getShare_count() {
        return share_count;
    }

    public void setShare_count(String share_count) {
        this.share_count = share_count;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(String is_hot) {
        this.is_hot = is_hot;
    }

    public String getIs_top() {
        return is_top;
    }

    public void setIs_top(String is_top) {
        this.is_top = is_top;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCover_show_type() {
        return cover_show_type;
    }

    public void setCover_show_type(String cover_show_type) {
        this.cover_show_type = cover_show_type;
    }

    public String getShare_type() {
        return share_type;
    }

    public void setShare_type(String share_type) {
        this.share_type = share_type;
    }

    public String getCan_comment() {
        return can_comment;
    }

    public void setCan_comment(String can_comment) {
        this.can_comment = can_comment;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public int getUnlike_enable() {
        return unlike_enable;
    }

    public void setUnlike_enable(int unlike_enable) {
        this.unlike_enable = unlike_enable;
    }

    public int getShow_comment() {
        return show_comment;
    }

    public void setShow_comment(int show_comment) {
        this.show_comment = show_comment;
    }

    public int getShow_time() {
        return show_time;
    }

    public void setShow_time(int show_time) {
        this.show_time = show_time;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public List<String> getCover() {
        return cover;
    }

    public void setCover(List<String> cover) {
        this.cover = cover;
    }
}
