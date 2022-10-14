<%--
  Created by IntelliJ IDEA.
  User: Vanxuan
  Date: 10/14/2022
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Check Mail</title>
</head>
<body>
<form method="get" action="/check">
    <pre><input type="text" name="email" value="${email}"></pre>
    <pre>${check}</pre>
    <pre><input type="submit" value="Check Mail" ></pre>
</form>
</body>
</html>
