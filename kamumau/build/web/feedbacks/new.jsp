<%-- 
    Document   : new
    Created on : Oct 17, 2018, 6:34:48 AM
    Author     : Putrialutfi
--%>

<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>

<main role="main">

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <h2>Give Your Feedback</h2>
</div>

<div class="container">            

  <h4><c:out value='${message}' /></h4>

  <form action="/kamumau/feedbacks?action=create" method="post"> 
  <%@include file= "form.html" %>
  
  </form>

  <hr>

</div> <!-- /container -->

</main>

    <%@include file= "/layouts/footer.html" %>