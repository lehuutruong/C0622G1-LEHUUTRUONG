<%--
  Created by IntelliJ IDEA.
  User: Vanxuan
  Date: 10/13/2022
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Currency Converter App</title>
</head>
<body>
<form action="/result" method="post">
<pre><input type="number" name="vnd" placeholder="VND" value="${vnd}"></pre>
<pre><input type="number" name="rate" placeholder="RATE" value="${rate}"></pre>
<pre>USD:${usd}</pre>
<input type="submit" value="Converter">
</form>
</body>
</html>
