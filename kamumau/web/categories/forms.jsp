<%-- 
    Document   : forms
    Created on : Oct 31, 2018, 6:05:59 AM
    Author     : Elfan N
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;" %>
<!DOCTYPE html>
<table class="table">  
                    <tr>
                        <td>Name Category</td>
                        <td>
                            <div class="form-group">
                                <input class="form-control"  type="text" id="name" name="name" value="<c:out value='${categories.getName()}' />"/>
                            </div>
                        </td>
                    </tr>  
                    
                    <tr>
                        <td>Parent Category</td>
                        <td>
                            <div class="form-group">
                                <select class="form-control" id="parent_category" name="parent_category" >
                                    <option value="-1">Select Parent Category</option>

                                    <%
                                        try {
                                                
                                                String query = "SELECT * FROM categories";
                                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                Connection conn = DriverManager.getConnection(
                                                "jdbc:mysql://localhost:3307/jspmvcjdbc", "root", "");

                                                Statement stmt  = conn.createStatement();
                                                ResultSet rs = stmt.executeQuery(query);

                                                while (rs.next()) {                                
                                                    %>
                                                        <option value="<%=rs.getInt("id")%>"><%=rs.getString("parent_category")%></option>
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
