<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form action="login" method="post" modelAttribute="login">
<table>
    <tr>
       <td><c:input path="account"/>Account</td>
       <td><c:input path="password"/>Password</td>
    </tr>
    <button type="submit" value="login">Login</button>
</table>
</form:form>
</body>
</html>
