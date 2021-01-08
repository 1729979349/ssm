package com.zking.ssm.mapper;

import com.zking.ssm.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "bookMapper")
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> queryBookListPager(Book book);

    //2 使用resultType返回List<T>
    List<Book>  queryBookList();
    //3 使用resultType返回单个对象
    Book  queryBookById(Integer bookId);
    //4 使用resultType返回List<Map>，适用于多表查询返回结果集
    List<Map<String,Object>> queryBookByListMap();
    //5 使用resultType返回Map<String,Object>，适用于多表查询返回单个结果集
    Map<String,Object> queryBookByMap(Integer bookId);
}