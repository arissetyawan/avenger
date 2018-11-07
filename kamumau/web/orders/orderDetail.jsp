<%-- 
    Document   : orderDetail
    Created on : 15 Okt 18, 11:19:47
    Author     : atfal
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
                <div style="float: right;">
                    <button class="btn btn-outline-primary btn-sm">Deliver</button>
                    <button class="btn btn-outline-danger btn-sm">Cancel</button>
                </div>
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active" id="pills-incom-tab" data-toggle="pill" href="#pills-incom" role="tab" aria-controls="pills-incom" aria-selected="true">Detail Order No 3000012321 ( Status : Pois )</a>
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
                                    <tr>
                                        <td>1</td>
                                        <td>Durmad</td>
                                        <td>1200000</td>
                                        <td>100</td>
                                        <td>1000000</td>
                                        <td>10-10-2010</td>
                                        <td align="center">
                                            <button class="btn btn-outline-danger btn-sm">Hapus</button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        
                        <p><b>Address</b> : JL. Tugel Tugel</p>
                    </div>
                    
                </div>
            </div>
        </div>

</main>

<%@include file= "/layouts/footer.html" %>