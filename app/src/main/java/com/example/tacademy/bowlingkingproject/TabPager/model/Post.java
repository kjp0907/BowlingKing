package com.example.tacademy.bowlingkingproject.TabPager.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tacademy on 2017-02-06.
 */

public class Post {

    //내용
    String content;

    Map<String,Boolean> stars = new HashMap<>();


    public Post() {

    }


    public Post(String content) {
        this.content = content;

    }

    public Map<String, Object> toPostMap(){
        Map<String,Object> map = new HashMap<>();

        map.put("content",content);
        map.put("stars",stars);

        return map;

    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Boolean> getStars() {
        return stars;
    }

    public void setStars(Map<String, Boolean> stars) {
        this.stars = stars;
    }


}
