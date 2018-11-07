<%-- 
    Document   : orderCompleted
    Created on : 05 Nov 18, 1:31:43
    Author     : muh_athfal
--%>
<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>
<main role="main">
    <hr>
    <hr>
    <hr>
    <br>
    <div class="row">
            <div class="container">
                <h4>Orders Page</h4>
                <p>In This Page You Can View Your Order And Your Cart</p>
                <a href="orders?action=mycart">
                    <button class="btn btn-md btn-outline-primary">My Cart</button>
                </a>
                <a href="orders?action=ordernew">
                    <button class="btn btn-md btn-outline-warning">Order Incoming</button>
                </a>
                <a href="orders?action=ordercompleted">
                    <button class="btn btn-md btn-outline-success active">Order Delivered</button>
                </a>
                <br><br>
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active" id="pills-incom-tab" data-toggle="pill" href="#pills-incom" role="tab" aria-controls="pills-incom" aria-selected="true">Order Delivered</a>
                    </li>
                </ul>
                <div class="tab-content" id="pills-tabContent">
                    
                    <div class="tab-pane fade show active" id="pills-incom" role="tabpanel" aria-labelledby="pills-incom-tab">
                       <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>No.</th>
                                        <th>Costumer Name</th>
                                        <th>Address</th>
                                        <th>Total</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% int i = 1; %>
                                    <c:forEach var="completed" items="${completed}">
                                        <tr>
                                            <td><%=i %></td>
                                            <td><c:out value="${completed.no}" /></td>
                                            <td><c:out value="${completed.user_name}" /></td>
                                            <td><c:out value="${completed.address}" /></td>
                                            <td>1</td>
                                            <td><c:out value="${completed.created_at}" /></td>
                                            <td><c:out value="${completed.updated_at}" /></td>
                                            <td><button type="button" class="btn btn-sm btn-success"><c:out value="${completed.status}" /></button></td>
                                            <td align="center">
                                                <a href="orders?action=detail" class="btn btn-outline-info btn-sm">Detail</a>
                                                <a href="orders?action=delete&id=<c:out value='${completed.getId()}' />&no=<c:out value='${completed.getNo()}' />" class="btn btn-outline-danger btn-sm" 
                                                   onclick="return confirm('Are you sure Want To Deleted Order...?')">Delete</a>
                                            </td>
                                        
                                    </tr>
                                    <% i++; %>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>

</main>

<%@include file= "/layouts/footer.html" %>