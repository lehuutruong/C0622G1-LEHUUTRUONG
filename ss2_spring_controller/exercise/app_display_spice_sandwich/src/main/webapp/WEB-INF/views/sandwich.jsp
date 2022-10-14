<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h3>Sandwich Condiments</h3>
<form action="/display">
    <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
    <input type="checkbox" name="condiment" value="Tomato"> Tomato
    <input type="checkbox" name="condiment" value="Mustard"> Mustard
    <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
    <p> Result: <c:forEach items="${condiment}" var="condiment">${condiment}</c:forEach></p>
    <button type="submit" value="Save">Save</button>
</form>
</body>
</html>
