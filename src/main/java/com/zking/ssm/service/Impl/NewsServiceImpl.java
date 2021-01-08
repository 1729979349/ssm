package com.zking.ssm.service.Impl;

import com.zking.ssm.mapper.NewsMapper;
import com.zking.ssm.model.Category;
import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper NewsMapper;

    @Override
    public List<News> queryNewsList() {
        return NewsMapper.queryNewsList();
    }
}
