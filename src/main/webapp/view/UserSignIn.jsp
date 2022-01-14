<%--
  Created by IntelliJ IDEA.
  User: bingxuhu
  Date: 1/13/22
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Sign In</title>
</head>
<body>
    <form action="<%= request.getContextPath()%>/SignIn" method = "POST">
        First Name<input type="text" name = "first_name"><br/>
        Second Name<input type="text" name = "second_name"><br/>
        Address<input type="text" name = "address"><br/>
        Birth Date<input type="text" name="birth_date"> Form: XXXX-XX-XX<br/>
        Nation<Input type="text" name="nation"><br/>
        Phone Number<input type="text" name="phone_number">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
