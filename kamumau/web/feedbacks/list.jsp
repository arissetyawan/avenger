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
            <h4>Here should be displayed value of rating and content from detail order table</h4>
            <h3>I need table order</h3>
            <h1>List of Rating</h1>
            <h4><c:out value='${message}' /></h4>
                <table border="1" cellpadding="5">
                        <tr>
                            <th>ID Feedback</th>
                            <th>Rating</th>
                            <th>Note</th>
                            <th>ID Order</th>
                            <th>ID Seller</th>
                            <th>ID Buyer</th>
                            <th colspan='2'>Actions</th>
                        </tr>
                        <c:forEach var="feedback" items="${feedbacks}">
                        <tr>
                            <td><c:out value="${feedback.id}" /></td>
                            <td><c:out value="${feedback.rating}" /></td>
                            <td><c:out value="${feedback.content}" /></td>
                            <td><c:out value="${feedback.order_Id}" /></td>
                            <td><c:out value="${feedback.seller_Id}" /></td>
                            <td><c:out value="${feedback.buyer_Id}" /></td>
                            <td>
                                <a href="feedbacks?action=delete&id=<c:out value='${feedback.getId()}' />" onclick="return confirm('Are you sure?')" >Delete</a>                                          
                            </td>
                        </tr>
                        </c:forEach>
                </table>
        </div>    
</main>  
</body>
    <%@include file= "/layouts/footer.html" %>
</html>
