<%-- 
    Document   : edit
    Created on : Oct 15, 2018, 9:02:29 PM
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
         <br>
         <br>
         <br>
            <h4><c:out value='${message}' /></h4>
        <form action="products?action=update&id=<c:out value='${product.getId()}' />" method="post"> 
        <%@include file= "form.html" %>
        </form>
    </body>
</html>
