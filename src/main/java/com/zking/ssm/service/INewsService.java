package com.zking.ssm.service;

import com.zking.ssm.model.Category;
import com.zking.ssm.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface INewsService {

    List<News> queryNewsList();


}