package com.zking.ssm.service;


import com.zking.ssm.mapper.BookFileMapper;
import com.zking.ssm.model.BookFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public interface IBookFileService {

    BookFile selectByPrimaryKey(String fileId);


}