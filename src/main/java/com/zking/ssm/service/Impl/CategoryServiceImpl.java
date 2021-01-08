package com.zking.ssm.service.Impl;

import com.zking.ssm.mapper.CategoryMapper;
import com.zking.ssm.model.Category;
import com.zking.ssm.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper CategoryMapper;

    @Override
    public List<Category> queryCategoryList() {
        return CategoryMapper.queryCategoryList();
    }
}
