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
        
        <!-- Nav Tabs For Order Incoming And Order Complete -->
        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
            <!-- Order Incoming -->
            <li class="nav-item">
                <a class="nav-link active" id="pills-incom-tab" data-toggle="pill" href="#pills-incom" role="tab" aria-controls="pills-incom" aria-selected="true">Incoming Orders</a>
            </li>
            <!-- Order Complete -->
            <li class="nav-item">
                <a class="nav-link" id="pills-complete-tab" data-toggle="pill" href="#pills-complete" role="tab" aria-controls="pills-complete" aria-selected="false">Complete Orders</a>
            </li>
            <!-- -->
        </ul>
        <!-- Detail Order Incoming -->
        <div class="tab-content" id="pills-tabContent">

            <div class="tab-pane fade show active" id="pills-incom" role="tabpanel" aria-labelledby="pills-incom-tab">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>No</th>
                                <th>Costumer Name</th>
                                <th>Address</th>
                                <th>Total</th>
                                <th>Created At</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <tr>
                                <td>1</td>
                                <td>2</td>
                                <td>Durmad</td>
                                <td>Tegal</td>
                                <td>1000</td>
                                <td>2018-10-12</td>
                                <td>new</td>
                                <td align="center">
                                    <a href="orders?action=orderdetail" class="btn btn-outline-info btn-sm">Detail </a>
                                    <a href="#" class="btn btn-outline-danger btn-sm"> Hapus </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="tab-pane fade" id="pills-complete" role="tabpanel" aria-labelledby="pills-complete-tab">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>No</th>
                                <th>Costumer Name</th>
                                <th>Address</th>
                                <th>Total</th>
                                <th>Created At</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>0001</td>
                                <td>Durmad</td>
                                <td>Tegal</td>
                                <td>1000</td>
                                <td>10-10-2010</td>
                                <td>Delivered</td>
                                <td align="center">
                                    <a href="orders?action=orderdetail" class="btn btn-outline-info btn-sm">Detail</a>
                                    <a href="#" class="btn btn-outline-danger btn-sm">Hapus</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

      <hr>

    </div> <!-- /container -->

</main>

<%@include file= "/layouts/footer.html" %>