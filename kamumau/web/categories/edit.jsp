<%-- 
    Document   : new
    Created on : Oct 18, 2018, 5:59:38 PM
    Author     : Nissa
--%>


<%@page import="java.sql.*;" %>
<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">
<%@include file= "/layouts/header.jsp" %>



<main role="main">

    <div class="jumbotron">

        <div class="container">
            <h1>Edit Category</h1>            
            <h4><c:out value='${message}' /></h4>
            <form action="/kamumau/categories?action=update&id=<c:out value='${category.getId()}' />" method="post"> 
                
                <table class="table">  

                    <tr>
                        <td>Parent Category</td>
                        <td>
                            <div class="form-group">
                                <input class="form-control" disabled="true" type="text" id="category_id" name="category_id" value="<c:out value='${category.getCategory_id()}' />"/>
                            </div>
                        </td>
                    </tr>
                    
                    <tr>
                        
                        <td>Name Category</td>
                        <td>
                            <div class="form-group">
                                <input class="form-control"  type="text" id="name" name="name" value="<c:out value='${category.getName()}' />"/>
                            </div>
                        </td>
                    </tr>  
                    
                    
                    <tr>
                        <td>Description</td>
                        <td>
                            <div class="form-group">
                                <textarea class="form-control" rows="5" name="description" id="description"><c:out value='${category.getDescription()}'/></textarea>
                            </div> 
                        </td>
                    </tr>  
                    
                    <tr>
                        <td colspan="2"><input align="center" class="btn btn-primary" type="submit" value="Save"  /></td>
                    </tr>  
                </table>
                
            </form>

        </div>
            
    </div> 

</main>

    <%@include file= "/layouts/footer.html" %>