<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
</head>
<body>
<h3>Welcome ,enter the employee details</h3>
<form:form action="addEmployee" method="post" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Employee ID: </form:label></td>
            <td><form:input path="id"/></td>
            <td><form:label path="name">Employee Name: </form:label></td>
            <td><form:input path="name"/></td>
            <td><form:label path="contactNumber">Employee ContactNumber: </form:label></td>
            <td><form:input path="contactNumber"/></td>
            <td>
                <button type="submit" value="Submit">Submit</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
