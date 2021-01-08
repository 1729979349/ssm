package com.zking.ssm.service.Impl;

import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.utlis.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BookServiceImplTest extends baseTest{

    @Autowired
    private IBookService BookService;

    @Test
    public void deleteByPrimaryKey() {
        BookService.deleteByPrimaryKey(3);

    }

    @Test
    public void insert() {
//        for(int i=0;i<20;i++){
          //  BookService.insert(Book.builder().bookName("易经经100").bookPrice(889f).build());
//        }
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        //selectByPrimaryKey-cache-BookServiceImpl.selectByPrimaryKey:3
        Book book = BookService.selectByPrimaryKey(90);
        System.out.println(book);
        System.out.println("--------------0-------------");
//        Book books = BookService.selectByPrimaryKey(10);
//        System.out.println(books);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        //动态修改
      //  BookService.updateByPrimaryKeySelective(Book.builder().bookId(4).bookName("钢铁是怎样炼费的").bookPrice(100f).build());

    }

    @Test
    public void updateByPrimaryKey() {
//        BookService.updateByPrimaryKey(Book.builder().bookId(9).bookName("易经经8").bookPrice(999f).build());

//        BookService.selectByPrimaryKey(9);

        BookService.claer(9);
//        new BookServiceImpl().clear(9);
       // BookService. selectByPrimaryKey(10);
    }

    @Test
    public void queryBookList(){
        PageBean pageBean=new PageBean();
        pageBean.setPagination(false);
//        if(pageBean!=null && pageBean.isPagination())
//            PageHelper.startPage( pageBean.getPage(),pageBean.getRows());

      //  List<Book> books = BookService.queryBookListPager(Book.builder().bookName("1").bookId(1).build(), pageBean);
       // System.out.println(books);
//        if(pageBean!=null && pageBean.isPagination()){
//            PageInfo pageInfo=new PageInfo(books);
//            System.out.println("总记录数"+pageInfo.getTotal());
//            System.out.println("当前页码"+pageInfo.getPageNum());
//            System.out.println("页码行数"+pageInfo.getSize());
//            List list = pageInfo.getList();
//            list.forEach(System.out::println);
//        }

    }
}

