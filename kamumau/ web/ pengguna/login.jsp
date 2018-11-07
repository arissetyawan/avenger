<%-- 
    Document   : list
    Created on : Oct 11, 2018, 8:27:04 PM
    Author     : x201
--%>
<link href="/WEB-INF/stylesheets/login.css" rel="stylesheet">
<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>
    <br />      
    <br />      
    <br />      
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <form class="form-signin" action="users?action=do-login" method="POST">
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn-submit">Sign in</button>
    </form>

<%@include file= "/layouts/footer.html" %>
