<%--
  Created by IntelliJ IDEA.
  User: zjjt
  Date: 2021/1/2
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head.jsp"%>
</head>
<body>
<h1>书本列表</h1>
${books}
    <form action="${ctx}/book/bookList" method="post">
      书本名称： <input type="text" name="bookName">
        <input type="submit" value="查询">
    </form>
    <table border="1" style="width: 100%">
        <tr>
            <th>书本编号</th>
            <th>书本名称</th>
            <th>书本图片</th>
            <th>书本价格</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${books}" var="bs">
            <tr>
                <th>${bs.bookId}</th>
                <th>${bs.bookName}</th>
                <th>
                    <c:if test="${empty bs.bookImage}">
                        图片未上传
                    </c:if>
                    <c:if test="${not empty bs.bookImage}">
                        <img width="120px" src="${ctx}/bookFile/download?fileId=${bs.bookImage}" />
                    </c:if>
                </th>
                <th>${bs.bookPrice}</th>
                <th>
                    <a href="${ctx}/input/book/bookUpload?id=${bs.bookId}">文件上传</a>
                    <c:if test="${not empty bs.bookImage}">
                        <a href="${ctx}/bookFile/download?fileId=${bs.bookImage}">文件下载</a>

                    </c:if>
                </th>
            </tr>
        </c:forEach>


    </table>



</body>
</html>
