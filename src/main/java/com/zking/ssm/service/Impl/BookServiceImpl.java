package com.zking.ssm.service.Impl;

import com.zking.ssm.mapper.BookFileMapper;
import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.utlis.PageBean;
import com.zking.ssm.vo.BookFileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BookServiceImpl implements IBookService {

//    @Autowired
    @Resource(name = "bookMapper")
    private BookMapper BookMapper;
    @Autowired
    private BookFileMapper bookFileMapper;

    @CacheEvict(value = "selectByPrimaryKey",key="T(String).valueOf(#bookId).concat('-')")
    @Override
    public int deleteByPrimaryKey(Integer bookId) {
        return BookMapper.deleteByPrimaryKey(bookId);
    }
    @Override
    public int insert(Book record) {
        return BookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return BookMapper.insertSelective(record);
    }

   // @Cacheable(value = "selectByPrimaryKey",key = "'-key'+#bookId",condition ="#bookId>5" )
//    @CachePut(value = "selectByPrimaryKey",key = "'-key'+#bookId")
//    @CacheEvict(value = "selectByPrimaryKey",key = "'-key'+#bookId")
  //  @Cacheable(value = "selectByPrimaryKey",unless = "#result==null")
  @CachePut(value = "selectByPrimaryKey",key = "'-key'+#bookId")
    @Override
    public Book selectByPrimaryKey(Integer bookId) {

        return BookMapper.selectByPrimaryKey(bookId);
    }
//    @Cacheable("databaseCache")
    @Transactional
    @Override
    public int updateByPrimaryKeySelective(BookFileVo bookFileVo) {
        //获取uuid 32位
        String fileId= UUID.randomUUID().toString().replace("-","");
        //给BookFile中的fileId赋值
        bookFileVo.setFileId(fileId);
        //调用bookFileMapper中的添加方法，添加图片
        bookFileMapper.insert(bookFileVo);

        //根据book_id修改书本信息中的book_image字段
        Book book=new Book();
        book.setBookId(bookFileVo.getBookId());
        book.setBookImage(fileId);
        BookMapper.updateByPrimaryKeySelective(book);

        return 1;
    }
//    @CachePut(value ="updateByPrimaryKey",condition = "#record.bookId>10")
//    @CacheEvict(value = "updateByPrimaryKey")
    @Override
    public int updateByPrimaryKey(Book record) {

        return BookMapper.updateByPrimaryKey(record);
    }

    @CacheEvict(value = "selectByPrimaryKey",key = "'-key'+#bookId")
    public void clear(Integer bookId){

    }


   // @Cacheable(value ="selectByPrimaryKey",key ="'-key'+#book.bookId")
    @Override
    public List<Book> queryBookListPager(Book book, PageBean pageBean) {

        return BookMapper.queryBookListPager(book);
    }

    @CacheEvict(value = "selectByPrimaryKey",key = "'-key'+#bookId" )
    @Override
    public void claer(Integer bookId) {
        System.out.println("清空了");
    }

    @Override
    public List<Book> queryBookList() {
        return BookMapper.queryBookList();
    }

    @Override
    public Book queryBookById(Integer bookId) {
        return BookMapper.queryBookById(bookId);
    }

    @Override
    public List<Map<String, Object>> queryBookByListMap() {
        return BookMapper.queryBookByListMap();
    }

    @Override
    public Map<String, Object> queryBookByMap(Integer bookId) {
        return BookMapper.queryBookByMap(bookId);
    }
}
