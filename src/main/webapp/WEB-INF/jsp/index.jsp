<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zjjt
  Date: 2020/12/31
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <%@ include file="/common/head.jsp"%>
</head>
<body>
    <h1><frm:message key="title"/></h1>
    <img src="${ctx}/images/1.jpg">
    <img src="${pageContext.request.contextPath}/img/2.jpg">
    <img src="${pageContext.request.contextPath}/3.jpg">
    <br/>

    <div style="position:absolute;top: 10px;right: 20px" >
        <a href="${ctx}/ChengLocale?type=zh">简体中文</a>
        <a href="${ctx}/ChengLocale?type=us">English</a>
        <a href="${ctx}/ChengLocale?type=jp">日本語</a>
        <a href="${ctx}/user/userLogout">安全退出</a>
    </div>
    <shiro:hasPermission name="bookmanager:book:edit">
        <a href="${pageContext.request.contextPath}/book/bookAddb"><frm:message key="toAddBook"/></a><br/>
    </shiro:hasPermission>
    <a href="${ctx}/input/home"><frm:message key="toHome"/></a><br/>
    <a href="${ctx}/input/book/bookList"><frm:message key="toBookList"/></a>

    <p>
        <shiro:hasRole name="管理员">
            <a href="${ctx}/book/toEditBook">使用@ResponseBody返回JSON数据</a><br/>
        </shiro:hasRole>
        <a href="${ctx}/book/queryBookById?bookId=1">查询返回单个实体返回JSON数据</a><br/>
        <a href="${ctx}/book/queryBookList">查询返回List&lt;T&gt;JSON数据</a><br/>
        <a href="${ctx}/book/queryBookByListMap">查询返回List&lt;map&gt;JSON数据</a><br/>
        <a href="${ctx}/book/queryBookByMap?bookId=4">查询返回&lt;map&gt;JSON数据</a><br/>
    </p>


</body>
</html>
