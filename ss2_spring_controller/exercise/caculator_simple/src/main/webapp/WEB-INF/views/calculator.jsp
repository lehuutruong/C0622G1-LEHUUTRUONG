<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>Calculator</h3>
<form method="get" action="/calculator">
    <pre><input type="number" name="parameterOne" value="${parameterOne}"></pre>
    <pre><input type="number" name="parameterTwo" value="${parameterTwo}"></pre>
    <pre> RESULT: ${result}</pre>
    <pre><input type="submit" value="addition" name="calculation" style="width: 100px"></pre>
    <pre><input type="submit" value="subtraction" name="calculation" style="width: 100px"></pre>
    <pre><input type="submit" value="multiplication" name="calculation" style="width: 100px"></pre>
    <pre><input type="submit" value="division" name="calculation" style="width: 100px"></pre>
</form>
</body>
</html>
