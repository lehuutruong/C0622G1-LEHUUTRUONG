<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Configuration Email</title>
</head>
<body>
<form:form action="/home" method="post" modelAttribute="mail">
    <form:label path="language"><b>Languages: </b></form:label>
    <form:select path="language" items="${languageList}"></form:select>
    <br> <br>
    <form:label path="size"><b>Page Size: </b> Show </form:label>
    <form:select path="size"><form:options items="${sizeList}"/></form:select> emails per page
    <br> <br>
    <form:label path="spamFilter"><b>Spam Filter: </b> </form:label>
    <form:checkbox value="Enable spams filter" path="spamFilter"/> Enable spams filter
    <br> <br>
    <form:label path="signature"><b>Signature: </b> </form:label>
    <form:textarea path="signature"/>
    <br> <br>
    <button type="submit">Update</button>
    <button type="reset">Cancel</button>
</form:form>
</body>
</html>