<%--
  Created by IntelliJ IDEA.
  User: zjjt
  Date: 2021/1/3
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head.jsp"%>
</head>
<body>
<h1>文件上传</h1>
    <form action="${ctx}/bookFile/upload" method="post" enctype="multipart/form-data">
        书本编号：<input type="text" name="bookId" value="${param.id}" readonly><br>
        书本图片：<input type="file" name="bFile">
        <input type="submit" value="上传">

    </form>

</body>
</html>
