<%--
  Created by IntelliJ IDEA.
  User: zjjt
  Date: 2020/12/31
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head.jsp"%>
</head>
<style>
    .error{
        color: red;
        font-weight: bold;
    }
</style>
<body>
<h1>书本新增</h1>
${book}
<f:form  modelAttribute="book" action="${ctx}/book/addBook" method="post">
    <label>书本编号</label><f:input type="text" path="bookId"/>
    <f:errors path="book*" cssClass="error" /><br/>
    <label>书本名称</label><f:input type="text" path="bookName"/>
    <f:errors path="bookName" cssClass="error" /><br/>
    <label>书本价格</label><f:select path="bookPrice">
        <option value="">--请选择--</option>
<%--        <c:forEach items="${list}" var="bt">--%>
<%--            <option value="${bt}">${bt}</option>--%>
<%--        </c:forEach>--%>
    <f:options items="${list}"/>
</f:select><f:errors path="bookPrice" cssClass="error" /><br/>
    </label><input type="submit" value="提交" ><br/>
</f:form >
</body>
</html>
