package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.Customer;
import com.zking.ssm.utlis.PageBean;
import com.zking.ssm.vo.BookFileVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface IBookService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    /**
     * 根据book_id修改书本信息中的book_image字段
     * 注意 ：在这里需要使用事务处理，保持数据一致性
     * @param bookFileVo
     * @return
     */
    int updateByPrimaryKeySelective(BookFileVo bookFileVo);

    int updateByPrimaryKey(Book record);

    List<Book> queryBookListPager(Book book , PageBean pageBean);

    void claer(Integer bookId);

    //2 使用resultType返回List<T>
    List<Book>  queryBookList();
    //3 使用resultType返回单个对象
    Book  queryBookById(Integer bookId);
    //4 使用resultType返回List<Map>，适用于多表查询返回结果集
    List<Map<String,Object>> queryBookByListMap();
    //5 使用resultType返回Map<String,Object>，适用于多表查询返回单个结果集
    Map<String,Object> queryBookByMap(Integer bookId);


}