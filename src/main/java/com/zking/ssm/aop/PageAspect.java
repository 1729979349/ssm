package com.zking.ssm.aop;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.ssm.utlis.PageBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {

    /**
     *
     * 1)* 返回值不限
     * 2)*..包名不限
     * 3)*Service:以Service类或接口结尾
     * 4)*Pager:以Pager结尾方法名
     * 5)(..):参数类型几个数不限
     *
     */
    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        //获得目标方法的执行参数
        Object[] params = joinPoint.getArgs();
        //定义PageBean对象
        PageBean pageBean=null;
        //循环执行参数
        for (Object param : params) {
            //判断参数是否是PageBean类型
            if(param instanceof PageBean){
                pageBean=(PageBean)param;
                break;
            }
        }

        //判断是否分页
        if(pageBean!=null && pageBean.isPagination())
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());


        //执行方法
        Object returnValue = joinPoint.proceed(params);

        if(pageBean!=null && pageBean.isPagination()){
            List list=(List)returnValue;
            PageInfo pageInfo=new PageInfo(list);
            pageBean.setTotal(pageInfo.getTotal()+"");

        }
            return returnValue;
    }
}
