<%-- 
    Document   : rated
    Created on : Oct 17, 2018, 7:00:55 AM
    Author     : Putrialutfi
--%>
<%@page import="java.util.List"%>
<%@page import="model.Feedback"%>
<%@page language= "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

    <%@include file= "/layouts/header.jsp" %>
<head><title>List of Seller's Feedback</title></head>
<body>
<main role="main">
    <div class="jumbotron">
        <h2>Give Your Feedback</h2>
    </div>
    
    <div class="container"> 
        <form>
    <div class="card text-white bg-primary mb-3">
        <div class="card-header" style="font-weight:bold;">
            <c:forEach begin="0" end="0" var="fb" items="${feedbacks}">
            <h3><c:out value="${fb.full_Name}" /></h3>
        </div>
        <div class="card-body">
            <p class="card-text"><c:out value="${fb.address}" /></p>
            <p class="card-text">Cancelled: 10, Delivered: 120</p>
        </div>
            </c:forEach>
    </div>
        </form>
            <c:forEach var="feedback" items="${feedbacks}">
        <div align="center">
            <h4><c:out value='${message}' /></h4>
                <div style="text-align: left">
                    <c:out value="${feedback.rating}"/><span>/5   ( <c:out value="${feedback.date}" />  )<br></span><c:out value="${feedback.content}" />
                </div>
            </c:forEach>
        </div>    
</main>  
</body>
    <%@include file= "/layouts/footer.html" %>
</html>
