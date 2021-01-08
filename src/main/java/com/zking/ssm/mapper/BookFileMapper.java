package com.zking.ssm.mapper;

import javax.annotation.Resource;


import com.zking.ssm.model.BookFile;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFileMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(BookFile record);

    int insertSelective(BookFile record);

    BookFile selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(BookFile record);

    int updateByPrimaryKey(BookFile record);
}