<%-- 
    Document   : shopping
    Created on : 05 Nov 18, 2:31:20
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
                <h4>Shopping</h4>
                <p>Completed Form To Continue Shopping</p>
                <h4><c:out value='${message}' /></h4>
                <form action="/kamumau/orders?action=confirmPayment&id=<c:out value='${shopping.id}' />" method="POST">
                    <div class="form-group">
                        <label>Product ID</label>
                        <input type="hidden" name="product_id" value="1" />                      
                        <input type="hidden" name="status" value="new" />
                        <input type="number" class="form-control" name="order_id" readonly="true" value="<c:out value="${shopping.id}" />"/>
                    </div>
                    <div class="form-group">
                        <label>Product No</label>
                        <input type="number" class="form-control" name="order_no" readonly="true" value="<c:out value="${shopping.no}" />" />
                    </div>
                    <div class="form-group">
                        <label>Product Name</label>
                        <input type="text" class="form-control" name="order_name" readonly="true" value="<c:out value="${shopping.product_name}" />" />
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" class="form-control" name="price" readonly="true" id="price" value="<c:out value="${shopping.price}" />" />
                    </div>
                    <div class="form-group">
                        <label>QTY</label>
                        <input type="number" class="form-control" name="qty" id="qty" />
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <textarea class="form-control" name="address" rows="5"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Total</label>
                        <input type="number" class="form-control" name="total" id="total" />
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-md btn-outline-warning">Confirm Payment</button>
                        <button onclick="return window.history.go(-1)" type="button" class="btn btn-md btn-outline-danger">Cancel Shopping</button>
                    </div>
                </form>
            </div>
        </div>
                    <script>
                        $(document).ready(function (){
                           $('#qty').change(function(){
                              var price  = $('#price').val();
                              var qty    = $('#qty').val();
                              var total = price * qty;
                              $('#total').val(total);
                           });
                       });
                    </script>
</main>

<%@include file= "/layouts/footer.html" %>
