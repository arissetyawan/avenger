<%-- 
    Document   : list
    Created on : Oct 11, 2018, 8:27:04 PM
    Author     : x201
--%>
<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>

<main role="main">

    <div class="container">
        <hr>
        <hr>
        <hr>
        <br>
        <h4>Orders Page</h4>
        <p>In This Page You Can View Your Order And Your Cart</p>
        <h4><c:out value='${message}' /></h4>
        <a href="orders?action=mycart">
            <button class="btn btn-md btn-outline-primary">My Cart</button>
        </a>
        <a href="orders?action=ordernew">
            <button class="btn btn-md btn-outline-warning active">Order Incoming</button>
        </a>
        <a href="orders?action=ordercompleted">
            <button class="btn btn-md btn-outline-success">Order Delivered</button>
        </a>
        <br><br>
        <!-- Nav Tabs For Order Incoming And Order Complete -->
        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
            <!-- Order Incoming -->
            <li class="nav-item">
                <a class="nav-link active" id="pills-incom-tab" data-toggle="pill" href="#pills-incom" role="tab" aria-controls="pills-incom" aria-selected="true">Incoming Orders</a>
            </li>
        </ul>
        
        <!-- Detail Order Incoming -->
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
                            <c:forEach var="new" items="${new}">
                                <tr>
                                    <td><%=i %></td>
                                    <td><c:out value="${new.no}" /></td>
                                    <td><c:out value="${new.user_name}" /></td>
                                    <td><c:out value="${new.address}" /></td>
                                    <td>1</td>
                                    <td><c:out value="${new.created_at}" /></td>
                                    <td><c:out value="${new.updated_at}" /></td>
                                    <td><button class="btn btn-sm btn-primary"><c:out value="${new.status}" /></button></td>
                                    <td align="center">
                                        <a href="orders?action=detail" class="btn btn-outline-info btn-sm">Detail</a>
                                        <a href="orders?action=delete&id=<c:out value='${new.getId()}' />&no=<c:out value='${new.getNo()}' />" class="btn btn-outline-danger btn-sm" 
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

      <hr>

    </div> <!-- /container -->

</main>

<%@include file= "/layouts/footer.html" %>