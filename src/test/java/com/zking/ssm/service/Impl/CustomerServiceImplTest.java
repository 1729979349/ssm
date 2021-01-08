package com.zking.ssm.service.Impl;

import com.zking.ssm.model.News;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.ICategoryService;
import com.zking.ssm.service.ICustomerService;
import com.zking.ssm.service.INewsService;
import com.zking.ssm.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceImplTest extends  baseTest{

    @Autowired
    ICustomerService CustomerService;

    @Resource
    IOrderService OrderService;

    @Autowired
    ICategoryService CategoryService;

    @Resource
    INewsService NewsService;

    @Test
    public void queryCustomerBycustomerId() {
        //一对多
//        List<Customer> customers = CustomerService.queryCustomerBycustomerId(0);
//        customers.forEach(System.out::println);
            //多对一
//        List<Order> orders = OrderService.queryOrderList();
//        orders.forEach(System.out::println);

        //多对多
//        List<Category> categories = CategoryService.queryCategoryList();
//        categories.forEach(System.out::println);

        List<News> categories = NewsService.queryNewsList();
        categories.forEach(System.out::println);

    }


}
