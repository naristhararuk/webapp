<%-- 
    Document   : ListCustomer
    Created on : Oct 18, 2015, 2:01:35 PM
    Author     : Student Lab
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search Customer!</h1>
        <form action="SearchCustomer" method="post">
            <hr>
            Search Customer by Name:
            <input type="text" name="custName" value="${param.custName}"/>
            <input type="submit" value="Search"/>
             <hr>
        </form>
            <br>
            <table style="border:1px solid gray; width:700px; border-collapse: 1px;">
                <tr style="background-color: #0099ff; color: white;">
                    <td>Customer ID</td>
                    <td>Customer Name</td>
                    <td>Email Address</td>
                    <td>Credit Limit</td>
                </tr>
                <c:forEach items="${customers}" var="c">
                   <tr>
                        <td>${c.customerId}</td>
                        <td>${c.name}</td>
                        <td>${c.email}</td>
                        <td>${c.creditLimit}</td>
                    </tr> 
                </c:forEach>
            </table>
            <p style="color:red;">${message}</p>
    </body>
</html>
