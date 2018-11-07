<%-- 
    Document   : myCart
    Created on : 05 Nov 18, 1:32:00
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
                    <button class="btn btn-md btn-outline-primary active">My Cart</button>
                </a>
                <a href="orders?action=ordernew">
                    <button class="btn btn-md btn-outline-warning">Order Incoming</button>
                </a>
                <a href="orders?action=ordercompleted">
                    <button class="btn btn-md btn-outline-success">Order Delivered</button>
                </a>
                <br><br>
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active" id="pills-incom-tab" data-toggle="pill" href="#pills-incom" role="tab" aria-controls="pills-incom" aria-selected="true">My Cart</a>
                    </li>
                </ul>
                <div class="tab-content" id="pills-tabContent">
                    
                    <div class="tab-pane fade show active" id="pills-incom" role="tabpanel" aria-labelledby="pills-incom-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>QTY</th>
                                        <th>Total</th>
                                        <th>Update At</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="cart" items="${cart}">
                                    <tr>
                                        <td><c:out value="${cart.id}" /></td>
                                        <td><c:out value="${cart.product_name}" /></td>
                                        <td><c:out value="${cart.price}" /></td>
                                        <td>1</td>
                                        <td>-</td>
                                        <td><c:out value="${cart.updated_at}" /></td>
                                        <td align="center">
                                            <a href="orders?action=shopping&id=<c:out value="${cart.getId()}" />"><button class="btn btn-outline-primary btn-sm">Continue Shopping</button></a>
                                            <a href="orders?action=delete&id=<c:out value='${cart.getId()}' />&no=<c:out value='${cart.getNo()}' />" class="btn btn-outline-danger btn-sm" 
                                           onclick="return confirm('Are you sure Want To Deleted Cart...?')">Delete</a>
                                        </td>
                                    </tr>
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