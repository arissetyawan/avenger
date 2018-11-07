<<<<<<< HEAD
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
import javax.xml.soap.Detail;
import model.Order;

/**
 *
 * @author x201
 */
public class OrdersController extends ApplicationController {
    private final static String ADD_ACTION = "new";
    private final static String DELETE_ACTION = "delete";
    private final static String EDIT_ACTION = "edit";
    private final static String LIST_ACTION = "list";
    private String message= "";
    private static final int ID_USER = 1; // Id User Sementara     
    private static final int ID_SELLER = 2; // Id Seller Sementara 


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                String action = request.getParameter("action");
                if(action == null) {
                    action = LIST_ACTION;
                }
                try {
                    switch (action) {
                        case "confirmPayment":
                            confirmPayment(request, response);
                            break;
                        case "shopping":
//                            mustLoggedIn(request, response);
                            shopping(request, response);
                            break;
                        case "mycart":
//                            mustLoggedIn(request, response);
                            mycart(request, response);
                            break;
                        case "ordercompleted":
//                            mustLoggedIn(request, response);
                            orderCompleted(request, response);
                            break;
                        case "ordernew":
//                            mustLoggedIn(request, response);
                            orderNew(request, response);
                            break;
                        case "delete":
    //                        mustLoggedIn(request, response);
                            deleteOrder(request, response);
                            break;
                        case "update":
    //                        mustLoggedIn(request, response);
                            updateOrder(request, response);
                            break;
                        default:
    //                        mustLoggedIn(request, response);
                            orderNew(request, response);
                            break;
                }
                }catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_order = Integer.parseInt(request.getParameter("no"));
        Order order = new Order();
        order.setId(id);
        order.setNo(id_order);
        message = order.delete()? "order succesffully deleted":"order was not deleted";
        request.setAttribute("message", message);
        response.sendRedirect("orders?action="+LIST_ACTION); 
    }
    
    private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        Order o = new Order();
        o.setStatus(status);
        if (o.updateStatus()){
            message= "Status Update To Delivered Thank You :)";     
            request.setAttribute("message", message);
            List<Order> order = o.all(ID_USER);
            request.setAttribute("order", order);
            request.getRequestDispatcher("orders/list.jsp").include(request, response);
        }else{
            message= "order failed to updated";     
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("orders?action="+ EDIT_ACTION);
            dispatcher.forward(request, response);
        }
    }
    
    private void confirmPayment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");        
        String address = request.getParameter("address");
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        int price = Integer.parseInt(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("qty"));        
        int total = Integer.parseInt(request.getParameter("total"));

        
        Order o = new Order();
        o.setStatus(status);        
        o.setOrder_id(order_id);
        o.setProduct_id(product_id);
        o.setPrice(price);
        o.setQty(qty);
        o.setAddress(address);
        o.setTotal(total);

        if (o.updateOrderPayment()){
            message= "Thank You For Your Purchase, Now Order Has New Status to NEW now Wait Status to Delivered :)";     
            request.setAttribute("message", message);
            List<Order> orders = o.getOrderIncom(ID_USER, ID_SELLER);
            request.setAttribute("new", orders);
            request.getRequestDispatcher("orders/orderIncoming.jsp");
        }else{
            message= "order failed to updated";     
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("orders?action="+ EDIT_ACTION);
            dispatcher.forward(request, response);
        }
    }

    private void orderNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        List<Order> orders = order.getOrderIncom(ID_USER, ID_SELLER);
        request.setAttribute("new", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/orderIncoming.jsp");        
        dispatcher.forward(request, response);
    }

    private void orderCompleted(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        List<Order> orders = order.getOrderCompleted(ID_USER, ID_SELLER);
        request.setAttribute("completed", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/orderCompleted.jsp");        
        dispatcher.forward(request, response);
    }

    private void mycart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        List<Order> orders = order.myCart(ID_USER, ID_SELLER);
        request.setAttribute("cart", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/myCart.jsp");        
        dispatcher.forward(request, response);
    }

    private void shopping(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("shopping", order.find(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/shopping.jsp");        
        dispatcher.forward(request, response);
    }

}
=======
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
>>>>>>> 2af7e0e9ff9a30b510bed6c243a915e9262afde3
