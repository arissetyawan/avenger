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
import model.Order;

/**
 *
 * @author x201
 */

public class OrdersController extends HttpServlet {
    private final static String aksi_tambah     = "newOrder";
    private final static String aksi_hapus      = "deleteOrder";
    private final static String aksi_update     = "updateOrder";
    private final static String aksi_view       = "order";
    private String pesan = "";

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
        try(PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            System.out.println(action);
            try {
                if(action == null)
                {
                    action = "lihat";
                }
                switch(action) {
                    case "neworder":
                        showNewOrder(request, response);
                        break;
                    case "createorder":
                        createOrder(request, response);
                        break;
                    case "deleteorder":
                        deleteOrder(response, request);
                        break;
                    case "editorder":
                        showEditOrder(response, request);
                        break;
                    case "updateorder":
                        updateOrder(request, response);
                        break;
                    case "orderdetail":
                        orderDetail(request, response);
                        break;
                    case "ordermycart":
                        orderMyCart(request, response);
                        break;
                    case "orderconfirm":
                        orderConfirm(request, response);
                        break;
                    default:
                        order(request, response);
                        break;
                }
            }  catch(Exception e){
                
            }
        }    
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

    private void showNewOrder(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void deleteOrder(HttpServletResponse response, HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showEditOrder(HttpServletResponse response, HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // For Redirect Order
    
    private void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order o = new Order();
        List<Order> or = o.all(1);
        request.setAttribute("orders", or);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/list.jsp");
        dispatcher.forward(request, response);
    }
    
    // For Redirect Order Detail
    
    private void orderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/orderDetail.jsp");
        dispatcher.forward(request, response);
    }
    
    // For Redirect Order Confirm
    
    private void orderConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/orderConfirm.jsp");
        dispatcher.forward(request, response);
    }
    
    // For Redirect Order My Cart

    private void orderMyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/orderMyCart.jsp");
        dispatcher.forward(request, response);
    }
}
