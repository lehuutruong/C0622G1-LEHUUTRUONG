<%--
  Created by IntelliJ IDEA.
  User: Vanxuan
  Date: 10/13/2022
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionary App Simple</title>
</head>
<body>
<form method="post" action="/result">
<pre><input type="text" name="english" placeholder="english"></pre>
<input type="submit" value="Dictionary">
</form>
<pre>Result: ${result}</pre>
</body>
</html>
