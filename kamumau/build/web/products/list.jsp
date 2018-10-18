<%-- 
    Document   : list
    Created on : Oct 15, 2018, 12:32:09 PM
    Author     : Gunawan
--%>

<%@page language= "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>

<main role="main"></main>
 
 
<html>
<head><title>People MVC JSP Bean Application</title></head>
<body>
    <%@include file= "/layouts/navbar_not_logged_in.jsp" %>
        <div align="center">
        <div class="container">
           
            <h4><c:out value='${message}' /></h4>
           
                <table class="table table-bordered table-hover table-striped">
     <h3>List Product</h3>
     
                        <tr>
     
                                <th><center>ID</th></center>
                                <th><center>Name</th></center>
                                <th><center>PRICE</th></center>
                                <th><center>STOCK</th></center>
                                <th><center>UPDATED AT</th>
                                <th><center>Actions</th>
                        </tr>
                        <c:forEach var="products" items="${products}">
                                <tr>
                                           <td><center><c:out value="${products.id}" /></center></td>
                                           <td><center><c:out value="${products.name}" /></center></td>
                                           <td><center><c:out value="${products.price}" /></center></td>
                                           <td><center><c:out value="${products.stock}" /></center></td>
                                           <td><center><c:out value="${products.updated}" /></center></td>
                                        <td>
      <center> <a href="products?action=edit&id=<c:out value='${products.getId()}' />"><button class="btn btn-outline-info btn-sm">Edit</button></a>
     <a href="products?action=delete&id=<c:out value='${products.getId()}' />" onclick="return confirm('Are you sure delete='+'${products.getName()}?')" ><button class="btn btn-outline-danger btn-sm">Delete</button></a></center>                                          
                                        </td>
                                </tr>
                        </c:forEach>
                </table>
            </div>
            <h4><a href="products?action=new"><button class="btn btn-sm btn-primary">Add Product</button></a></h4>
        </div>      
</body>
</html>