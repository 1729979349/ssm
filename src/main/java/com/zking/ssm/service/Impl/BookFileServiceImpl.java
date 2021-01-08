package com.zking.ssm.service.Impl;

import com.zking.ssm.mapper.BookFileMapper;
import com.zking.ssm.model.BookFile;
import com.zking.ssm.service.IBookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookFileServiceImpl implements IBookFileService {

    @Autowired
    private BookFileMapper bookFileMapper;

    @Override
    public BookFile selectByPrimaryKey(String fileId) {
        return bookFileMapper.selectByPrimaryKey(fileId);
    }
}
