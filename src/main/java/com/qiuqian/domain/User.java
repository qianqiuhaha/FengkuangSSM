package com.qiuqian.domain;

import java.util.Map;

public class User {
    private Integer id;
    private Name title;
    private String content;

    private Map<String,Object> Meta;

    public Map<String,Object> getMeta() {
        return Meta;
    }

    public void setMeta(Map<String,Object> meta) {
        Meta = meta;
    }

    public User(){}
    public User(Integer id,Name title, String content){
        this.id=id;
        this.content=content;
        this.title=title;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", title=" + title +
                ", content='" + content + '\'' +
                '}';
    }
}
