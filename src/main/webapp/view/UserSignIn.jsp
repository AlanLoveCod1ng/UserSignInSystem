<%--
  Created by IntelliJ IDEA.
  User: bingxuhu
  Date: 1/13/22
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String otherCountry;%>
<html>
<head>
    <title>User Sign In</title>
</head>
<body>
    <form action="<%= request.getContextPath()%>/signin" method = "POST">
        User Name:<input type="text" name = "userName" required><br/>
        Password:<input type="password" name="password" required><br/>
        First Name:<input type="text" name = "first_name" required><br/>
        Second Name:<input type="text" name = "second_name" required><br/>
        Gender: <input type="radio" name="gender" value="M" checked="checked">Male
                <input type="radio" name="gender" value="F">Female<br/>
        Language: <input type="checkbox" name="language" value="English">English
                    <input type="checkbox" name="language" value="Chinese">Chinese
                    <input type="checkbox" name="language" value="French">French
                    <input type="checkbox" name="language" value="Spanish">Spanish<br/>
        Address:<input type="text" name = "address" required><br/>
        Birth Date:<input type="text" name="birth_date" required> Form: XXXX-XX-XX<br/>
        Nation: <Input type="radio" name="nation" value="US">US
                <input type="radio" name="nation" value="China">China
                <input type="radio" name="nation" value="UK">UK
                <input type="radio" name="nation" value="India">India
        Phone Number:<input type="text" name="phone_number" required>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
