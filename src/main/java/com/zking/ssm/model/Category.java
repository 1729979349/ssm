package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@ToString
public class Category implements Serializable {

    private Integer categoryId;

    private String categoryName;

    private List<News> newss=new ArrayList<>();

    public List<News> getNewss() {
        return newss;
    }

    public void setNewss(List<News> newss) {
        this.newss = newss;
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category() {
        super();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}