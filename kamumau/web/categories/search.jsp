<%-- 
    Document   : list
    Created on : Oct 11, 2018, 8:27:04 PM
    Author     : x201
--%>
<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>

<main role="main">

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="container">
  <div class="jumbotron">
      
      <form method="post" action="categories?action=search" style="margin-top: 50px;">
          <h2>Kata Kunci</h2>
            <input type="text" name="keyword" value=""/>
            <input type="submit" class="btn btn-primary btn-lg" name="submit" value="Search"/>
    </form>
  </div>
</div>

<div class="container">

  <!-- Example row of columns -->
  <a class="btn btn-lg btn-success" href="categories?action=new">Create</a>
  <br>
  <div class="row">
      <c:forEach var="Category" items="${categories}">
        <div class="col-md-3" style="background-color:#e9ecef;margin: 5px;height:200px;padding:25px;">
            <h2><c:out value="${Category.name}" /></h2>
            <p><c:out value="${Category.description}" /></p>
            <p>
                <a class="btn btn-secondary" href="categories?action=edit&id=<c:out value='${Category.getId()}' />" role="button">Edit</a>
                <a class="btn btn-danger" href="categories?action=delete&id=<c:out value='${Category.getId()}' />" onclick="return confirm('Are you sure?')" role="button">Delete</a>
            </p>
            
        </div>
      </c:forEach>
    
  </div>

  <hr>

</div> 

</main>

<%@include file= "/layouts/footer.html" %>