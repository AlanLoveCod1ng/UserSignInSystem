<%--
  Created by IntelliJ IDEA.
  User: bingxuhu
  Date: 1/14/22
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    User Name<input type="text" name="userName"><br/>
    Password<input type="password" name="password"><br/>
    <input type="submit" value="submit">
</form>
</body>
</html>
