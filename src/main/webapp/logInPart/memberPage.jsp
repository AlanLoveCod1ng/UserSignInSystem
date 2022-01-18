<%@ page import="com.signin.models.User" %><%--
  Created by IntelliJ IDEA.
  User: bingxuhu
  Date: 1/14/22
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member Page</title>
</head>
<body>
<%
    String userName=null;
    if(session.getAttribute("userName")==null){
        response.sendRedirect(request.getContextPath()+"/login?action=login");
    }
    else{
        userName = session.getAttribute("userName").toString();
    }
    User user = (User) session.getAttribute("user");
%>
userName: <%= userName%><br/>
Name: <%=user.getFirst_name()+" "+user.getSecond_name()%><br/>
Birth Date: <%=user.getBirth_date()%>
Gender: <%=user.getGender()%>
<form action="<%=request.getContextPath()%>/memberPage" method="get">
    <input type="hidden" name="action" value="destroy">
    <input type="submit" value="logout">
</form>
</body>
</html>
