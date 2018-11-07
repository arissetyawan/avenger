<%-- 
    Document   : new
    Created on : Oct 15, 2018, 8:21:06 PM
    Author     : Gunawan
--%>

<%@page language= "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file= "/layouts/header.jsp" %>
<!DOCTYPE html>
<html>
  <head><title>Product</title></head>

    <body>
          <%@include file= "/layouts/navbar_not_logged_in.jsp" %>
    <center>  <h1>Add Product</h1> </center>           
        
        <h4><c:out value='${message}' /></h4>

        <form action="/kamumau/products?action=create" method="post"> 
        <%@include file= "form.html" %>
        </form>
    </body>
</html>