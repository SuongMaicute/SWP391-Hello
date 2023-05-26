<%-- 
    Document   : test
    Created on : May 23, 2023, 9:59:20 PM
    Author     : Minh Quan
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="dataList" value="${requestScope.DATA}"/>
        <c:set var="count" value="${0}"/>
        <c:if test="${not empty dataList}">
            <c:forEach var="data" items="${dataList}">
                <c:if test="${count eq 0}">
                    <h1>${data}</h1>
                    <c:set var="count" value="${1}"/>
                </c:if>
            </c:forEach>
        </c:if>
        <c:if test="${empty dataList}">
            <h1>Empty</h1>
            <c:redirect url="DashboardController"> </c:redirect>
        </c:if>
    </body>
</html>
