<%-- 
    Document   : rated
    Created on : Oct 17, 2018, 7:00:55 AM
    Author     : Putrialutfi
--%>
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
            Seller : PT. TokoLaku 
        </div>
        <div class="card-body">
            <p class="card-text">Address : Jalan Belok Kanan No. 212 - Jakarta</p>
            <p class="card-text">Cancelled: 10, Delivered: 120</p>
        </div>
    </div>
        </form>
    
        <div align="center">
            <h4><c:out value='${message}' /></h4>
            <c:forEach var="feedback" items="${feedbacks}">
                <div style="text-align: left">
                    <c:out value="${feedback.rating}"/><span>/5   </span><c:out value="${feedback.content}" />
                </div>
                <br>
            </c:forEach>
        </div>    
</main>  
</body>
    <%@include file= "/layouts/footer.html" %>
</html>
