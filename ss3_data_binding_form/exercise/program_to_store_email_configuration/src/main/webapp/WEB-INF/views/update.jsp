<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<table class="table">
    <tbody>
    <tr>
        <td><b>Language:</b>${mail.language}</td>
    </tr>
    <tr>
        <td><b>Size:</b>${mail.size}</td>
    </tr>
    <tr>
        <td><b>Spam Filter:</b>${mail.spamFilter}</td>
    </tr>
    <tr>
        <td><b>Signature:</b>${mail.signature}</td>
    </tr>
    </tbody>
</table>
</body>
</html>