package com.qiuqian.dao;

import com.qiuqian.domain.News;

import java.util.List;

public interface NewsMapperOne {
    List<News> selectNews();
    int saveNews(News news);
}
