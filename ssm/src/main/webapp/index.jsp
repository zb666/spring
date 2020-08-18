<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<a href="account/findAll">测试查询</a>

<form action="account/findAccount" method="post">
    姓名：<input type="text" name="username"></br>
    <input type="submit" value="查询"></br>
</form>

<h3>测试包</h3>

<%--这样写 对应AccountController--%>
   <form action="account/save" method="post">
    姓名：<input type="text" name="name"></br>
    金额: <input type="text" name="money"></br>
       <input type="submit" value="保存"></br>
   </form>
</body>

</html>
