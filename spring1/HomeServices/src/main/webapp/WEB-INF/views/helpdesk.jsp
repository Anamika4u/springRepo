<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body bgcolor="lavender">
<h2>Thank you for choosing our Service.You need to pay Rs.${cost}/-</h2>
</body>
</html>
 
showpage.jsp
 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
 
<body style="background-color: lavender">
 
    <h1>
 
        <center>Welcome to Online Help Services</center>
 
    </h1>
 
    <form:form method="post" action="helpdesk" modelAttribute="helper">
 
        <table style="margin: 0px auto; margin-left: auto; margin-right: auto">
 
            <tr>
 
                <td>Choose Service:</td>
 
                <td><select name="serviceType" id="serviceType">
 
                    <c:forEach items="${serviceList}" var="service">
 
                        <option value="${service.key}">${service.value}</option>
 
                    </c:forEach>
 
                </select></td>
 
            </tr>
 
            <tr>
 
                <td>Total Hours Service Required</td>
 
                <td><input type="text" name="noOfHours" id="noOfHours"></td>
 
            </tr>
 
            <tr>
 
                <td><input type="submit" name="submit" id="submit"value="TotalCost"></td>
 
                <td><input type="reset" name="cancel" id="cancel"value="Cancel"></td>
 
            </tr>
 
        </table>
 
    </form:form>
 
</body>
 
</html>