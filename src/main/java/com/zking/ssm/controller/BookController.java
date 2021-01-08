package com.zking.ssm.controller;

import com.zking.ssm.exception.BusinessException;
import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.utlis.PageBean;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private IBookService BookService;

    /**
     * 非请求处理方式，在所有请求处理方法前被调用
     * @param model
     */
    @ModelAttribute
    public void  init(Model model){
        List<Float> list =new ArrayList<>();
        list.add(10.98f);
        list.add(20.98f);
        list.add(30.98f);
        list.add(40.98f);
        list.add(50.99f);
        list.add(60.99f);
        model.addAttribute("book",new Book());
        model.addAttribute("list",list);

    }


    @RequestMapping("/a")
    public String toIndex(){

        System.out.println("book分支");
        return "index";
    }

    @RequestMapping("bookAdd")
    // 传参起别名： @RequestParam("ss")
    public String bookAdd( String sex, Integer bookId,
                           @RequestBody String map,Map<String,Object> maps){
//        System.out.println(request.getRequestURL());
        System.out.println(sex);
        System.out.println(bookId+1);
//        System.out.println(book);
        System.out.println(map);

        return "/book/bookAdd";
    }

    /**
     * 返回值
     * String ：逻辑视图名,讲由springMVC视图解析器进行解析，拼接前缀+逻辑视图名+后缀
     * String+model:String:代表逻辑视图名。model:数据模型
     * ModelAndView：逻辑视图名+数据模型
     * @param book
     * @return
     */
    @RequestMapping("bookAddb")
    public ModelAndView bookAddb(Book book, Model model){
        //使用 model 传递数据
        //model.addAttribute("book",book);

        ModelAndView mv=new ModelAndView();
        //逻辑视图名
        mv.setViewName("/book/bookAdd");
        //别渲染的模型数据
        //mv.addObject("book",book);

        return mv;
    }

    /**
     *
     *页面跳转
     *      转发："forward:path"
     *      重定向："redirect:path"
     *
     *   1)注意：这两种跳转方式将会绕开视图解析器的前缀和后缀
     *   2)path:不是逻辑视图名，而是请求方法名
     *   3)在同一个Controller中跳转，不需要加入/
     *       在不同一个Controller中跳转，必须需要加入/ 注意窄化路径
     */
    @RequestMapping("gotoPage")
    public String gotoPage(){
        System.out.println("进入了go");
        //页面跳转
        return "forward:/books";
    }




    @RequestMapping("add")
    public String addBook(Book book ,Model model){
        System.out.println("进来了addbook");
        //model.addAttribute("book",book);
        return "/book/bookAdd";
    }

    @RequestMapping(value = "addBook",method = RequestMethod.POST)
    @ResponseBody
    public String add(@Validated({Book.ValidateGroups.Add.class}) @ModelAttribute Book book , BindingResult bindingResult){
      if(bindingResult.hasErrors()){
          List<ObjectError> allErrors = bindingResult.getAllErrors();
          List<String> slist=new ArrayList<>();
          for (ObjectError allError : allErrors) {
              slist.add(allError.getDefaultMessage());
          }
          System.out.println("效验有误！");
//          bindingResult.rejectValue("bookName", null, "帐号错误");
          //返回json字符串
          return slist.toString();
      }else{
          ModelAndView mv=new ModelAndView();
          //逻辑视图名
//        mv.setViewName();
          //添加方法
          BookService.insert(book);

          return "redirect:bookList";
      }

    }

    @RequestMapping("bookList")
    public String list(HttpServletRequest request,Book book, Model model){
        System.out.println(222);
        PageBean pageBean=new PageBean();
        //设置pagebean初始参数
        pageBean.setRequest(request);

        List<Book> books = BookService.queryBookListPager(book, pageBean);
        //将数据传递到页面
        model.addAttribute("books",books);

        return "book/bookList";
    }

   /*-----------------json----------------*/
    @RequestMapping("toEditBook")
    @ResponseBody
    public String toEditBook(){
        return "book/bookEdit";
    }
    @RequestMapping("queryBookById")
    @ResponseBody
    public Book queryBookById(Integer bookId){
        Book book= BookService.queryBookById(bookId);
        book.setDate(new Date(System.currentTimeMillis()));
        return book;
    }
    @RequiresRoles(value = {"管理员","高级用户"},logical = Logical.OR)
    @RequestMapping("queryBookList")
    @ResponseBody
    public List<Book> queryBookList(Integer bookId){
        return BookService.queryBookList();
    }

    @RequiresPermissions(value = {"bookmanager:book:edit"})
    @RequestMapping("queryBookByListMap")
    @ResponseBody
    public List<Map<String,Object>> queryBookByListMap(){
        return BookService.queryBookByListMap();
    }

    @RequestMapping("queryBookByMap")
    @ResponseBody
    public Map<String,Object> queryBookByMap(Integer bookId){
        try {
          int a = Integer.parseInt("a");
          return BookService.queryBookByMap(bookId);
        }catch (Exception e){
           e.printStackTrace();
           throw new BusinessException("Map集合异常");
        }
    }



}
