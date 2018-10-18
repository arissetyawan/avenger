/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;
import model.Product;

/**
 *
 * @author arissetyawan.email@gmail.com
 */
public class ProductsController extends HttpServlet {
    private final static String add_action = "new";
    private final static String delete_action = "delete";
    private final static String edit_action = "edit";
    private final static String list_action = "list";
    private String message= "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                String action = request.getParameter("action");
                if(action==null){
                    action= "list";
                }
                try {
                    switch (action) {
                    case "new":
                        showNewForm(request, response);
                        break;
                    case "create":
                        createProducts(request, response);
                        break;
                    case "delete":
                        deleteProducts(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "update":
                        updateProducts(request, response);
                        break;
                    default:
                        listProducts(request, response);
                        break;
                    }
                } 
            catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }
  
    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Product p= new Product();
        List<Product> products = p.all();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void createProducts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String category = request.getParameter("category");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
       
 
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        
        if (product.create()){
            message= "new product added";                    
            request.setAttribute("message", message);
            response.sendRedirect("products?action="+list_action);
        }
        else{
            message= "new person failed to add";
            request.setAttribute("message", message);
            request.getRequestDispatcher("products?action="+add_action).include(request, response);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("products/new.jsp");
            dispatcher.forward(request, response);
        }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                Product product= new Product();
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("product", product.find(id));
            RequestDispatcher dispatcher = request.getRequestDispatcher("products/edit.jsp");
            dispatcher.forward(request, response);
        }
    
   private void updateProducts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
         int id = Integer.parseInt(request.getParameter("id"));
        String category = request.getParameter("category");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
    
 
        Product product = new Product();
        product.setId(id);
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        
        if (product.update()){
            message= "product updated";     
            request.setAttribute("message", message);
            List<Product> products = product.all();
            request.setAttribute("products", products);
            request.getRequestDispatcher("/products/list.jsp").include(request, response);
        }
        else{
            message= "gagal";     
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("products?action="+ edit_action);
            dispatcher.forward(request, response);
        }
  
    }
 
    private void deleteProducts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
         Product product = new Product();
        product.setId(id);
        if(product.delete()){
            message= "product deleted";                    
        }
        else{
            message= "product was not deleted";                
        }    
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products?action="+ list_action);
        dispatcher.forward(request, response);

        response.sendRedirect("products?action="+list_action); 
        

//        response.sendRedirect("people?action="+list_action); 
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
