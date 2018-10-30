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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Feedback;
import model.Person;

/**
 *
 * @author x201
 */

public class FeedbacksController extends HttpServlet {
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
        HttpSession session = request.getSession();
        session.setAttribute("current_user", 1);
            try (PrintWriter out = response.getWriter()) {
                String action = request.getParameter("action");
                if(action==null){
                    action= "list";
                }
                try {
                    switch (action) {
                    case "new":
                        //mustLoggedIn(request, response);
                        showNewForm(request, response);
                        break;
                    case "create":
                        createFeedback(request, response);
                        break;
                    case "delete":
                        deleteFeedback(request, response);
                        break;
                    default:
                        listFeedback(request, response);
                        break;
                    }
                } 
            catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }
    
    private void listFeedback(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Feedback p= new Feedback();
        List<Feedback> feedbacks = p.all();
        request.setAttribute("feedbacks", feedbacks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedbacks/list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void createFeedback(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String rating = request.getParameter("rating");
        String content = request.getParameter("content");
        /*This below made for making order_id, seller_id and buyer_id for a while
        because feedback hasn't been connected with order things (to take foreign) */
        String order_id = "2";
        String seller_id = "2";
        String buyer_id = "2";
        /*HttpSession session = request.getSession();
        String buyer_id = (session.getAttribute("current_user").toString());*/
 
        Feedback feedback = new Feedback();
        feedback.setRating(rating);
        feedback.setContent(content);
        feedback.setOrder_Id(order_id);
        feedback.setSeller_Id(seller_id);
        feedback.setBuyer_Id(buyer_id);
        if (feedback.create()){
            message= "new feedback added";                    
            request.setAttribute("message", message);
            response.sendRedirect("feedbacks?action="+list_action);
        }
        else{
            message= "new feedback failed to add";
            request.setAttribute("message", message);
            request.getRequestDispatcher("feedbacks?action="+add_action).include(request, response);
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
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("feedbacks/new.jsp");
            dispatcher.forward(request, response);
        }

 
    private void deleteFeedback(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Feedback feedback = new Feedback();
        feedback.setId(id);
        if(feedback.delete()){
            message= "feedback deleted";                    
        }
        else{
            message= "feedback was not deleted";                
        }    
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedbacks?action="+ list_action);
        dispatcher.forward(request, response);
    }
}
