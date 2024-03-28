<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
</head>
<body>
    <h2>Registration Page</h2>
    <form:form method="post" action="performRegistration" modelAttribute="register">
        <table>
            <tr>
                <td>User Name:</td>
                <td><form:input path="userName" /></td>
            </tr>
            <tr>
                <td>Contact Number:</td>
                <td><form:input path="contactNumber" /></td>
            </tr>
            <tr>
                <td>Email ID:</td>
                <td><form:input path="emailId" /></td>
            </tr>
            <tr>
                <td>Confirm Email ID:</td>
                <td><form:input path="confirmEmailId" /></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><form:checkbox path="status" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Register" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
