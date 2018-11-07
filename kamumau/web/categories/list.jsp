<<<<<<< HEAD
<%-- 
    Document   : list
    Created on : Oct 11, 2018, 8:27:04 PM
    Author     : x201
--%>
<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>

<main role="main">

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
  <div class="container">
    <h1 class="display-3">Looking for categories ?</h1>
    <p><form>
        <input type="text" name="keyword" />
        <input type="submit" class="btn btn-primary btn-lg" />
    </form>
  </div>
</div>

<div class="container">

  <!-- Example row of columns -->
  <div class="row">
    <div class="col-md-4">
      <h2>Categories A</h2>
      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
      <p><a class="btn btn-secondary" href="#" role="button">View products &raquo;</a></p>
    </div>
    <div class="col-md-4">
      <h2>Categories B</h2>
      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
      <p><a class="btn btn-secondary" href="#" role="button">View products &raquo;</a></p>
    </div>
    <div class="col-md-4">
      <h2>Categories C</h2>
      <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
      <p><a class="btn btn-secondary" href="#" role="button">View products &raquo;</a></p>
    </div>
  </div>

  <hr>

</div> <!-- /container -->

</main>

=======
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

>>>>>>> 2af7e0e9ff9a30b510bed6c243a915e9262afde3
<%@include file= "/layouts/footer.html" %>