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
            <h1>Adding Category</h1>            

            <form action="/kamumau/categories?action=create" method="post"> 
                
                <table class="table">  
                    
                    <tr>
                        <td>Parent Category</td>
                        <td>
                            <div class="form-group">
                                <select class="form-control" id="category_id" name="category_id" >
                                    <option value="0">Select Parent Category</option>

                                    <%
                                        try {
                                                
                                                String query = "SELECT * FROM categories WHERE category_id=0";
                                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                Connection conn = DriverManager.getConnection(
                                                "jdbc:mysql://localhost:3306/jspmvcjdbc", "root", "");

                                                Statement stmt  = conn.createStatement();
                                                ResultSet rs = stmt.executeQuery(query);

                                                while (rs.next()) {                                
                                                    %>
                                                        <option value="<%=rs.getInt("id")%>"><%=rs.getString("name")%></option>
                                                    <%
                                                }

                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                                System.out.println("error"+ex.getMessage());
                                            }
                                    %>
                                </select>
                            </div>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Name Category</td>
                        <td>
                            <div class="form-group">
                                <input class="form-control"  type="text" id="name" name="name" value="<c:out value='${categories.getName()}' />"/>
                            </div>
                        </td>
                    </tr>  

                    
                    <tr>
                        <td>Description</td>
                        <td>
                            <div class="form-group">
                                <textarea class="form-control" rows="5" name="description" id="description"><c:out value='${categories.getDescription()}'/></textarea>
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