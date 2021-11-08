package com.qiuqian.domain;

public class News {
    private Integer id;
    private String news_title;
    private String news_content;
    private Season HappenSeason;

    public News() {
    }

    public News(Integer id, String news_title, String news_content) {
        this.id = id;
        this.news_title = news_title;
        this.news_content = news_content;
    }

    public News(Integer id, String news_title, String news_content, Season happenSeason) {
        this.id = id;
        this.news_title = news_title;
        this.news_content = news_content;
        HappenSeason = happenSeason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public Season getHappenSeason() {
        return HappenSeason;
    }

    public void setHappenSeason(Season happenSeason) {
        HappenSeason = happenSeason;
    }
}
