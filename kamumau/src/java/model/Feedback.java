/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `content` varchar(100) NOT NULL,
  `order_id` int(11) NOT NULL,
  `seller_id` int(11) NOT NULL,
  `buyer_id` int(11) NOT NULL
) 
* url to create http://localhost:53062/kamumau/feedbacks?action=new
 */
public class Feedback extends MyConnection{
    private final String tableName= "feedbacks";
    public int rating;
    public String content;
    public int order_id;
    public int seller_id;
    public int buyer_id;
    public int order_no;
    public String full_name;
    public String address;
    public String status;
    public String date;

    public Feedback() {
        super();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrder_Id() {
        return order_id;
    }

    public void setOrder_Id(int order_id) {
        this.order_id = order_id;
    }
    
    public int getSeller_Id() {
        return seller_id;
    }

    public void setSeller_Id(int seller_id) {
        this.seller_id = seller_id;
    }
    
    public int getBuyer_Id() {
        return buyer_id;
    }

    public void setBuyer_Id(int buyer_id) {
        this.buyer_id = buyer_id;
    }
    
    public int getOrder_No() {
        return order_no;
    }

    public void setOrder_No(int order_no) {
        this.order_no = order_no;
    }
    
    public String getFull_Name() {
        return full_name;
    }

    public void setFull_Name(String full_name) {
        this.full_name = full_name;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public boolean create() {
        boolean result;
        if(!validate()){
            return false;
        }
        
        String query = "INSERT INTO "+ tableName +"(rating, content, order_id, "
                + "seller_id, buyer_id, created_at) values ('" + this.rating + "', '" + 
                this.content + "', '" + this.order_id + "', '" + this.seller_id + 
                "', '" + this.buyer_id + "', '" + this.date + "')";
        try {
            result= this.stateOpen().executeUpdate(query) > 0;
            this.stateClose();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validate(){
        boolean status= false;
        if (!"".equals(this.rating) &&  !"".equals(this.content)){
            status= true;
        } 
        return status;
    }
    
    public ArrayList<Feedback> getData(int order_id){
        String queryGetSeller = "SELECT orders.order_no, orders.seller_id, orders.buyer_id "
                + "FROM "+ tableName +" INNER JOIN orders ON "+ tableName +".order_id = "
                + "orders.id WHERE order_id = " + order_id;
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(queryGetSeller);
            while (res.next()) {
                Feedback feedback = new Feedback();
                feedback.setOrder_No(res.getInt("order_no"));
                feedback.setSeller_Id(res.getInt("seller_id"));
                feedback.setBuyer_Id(res.getInt("buyer_id"));
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return feedbacks;
    }
    
    public ArrayList<Feedback> all(int seller_id){
        String query = "SELECT user.full_name, user.address, orders.order_no, "
                + "orders.status, feedbacks.* from feedbacks INNER JOIN orders ON "
                + "feedbacks.order_id = orders.id INNER JOIN user ON orders.seller_id "
                + "= user.id WHERE orders.seller_id & user.id & feedbacks.seller_id = " + seller_id;
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Feedback feedback = new Feedback();
                feedback.setFull_Name(res.getString("full_name"));
                feedback.setAddress(res.getString("address"));
                feedback.setOrder_No(res.getInt("order_no"));
                feedback.setStatus(res.getString("status"));
                feedback.setRating(res.getInt("rating"));
                feedback.setContent(res.getString("content"));
                feedback.setOrder_Id(res.getInt("order_id"));
                feedback.setSeller_Id(res.getInt("seller_id"));
                feedback.setBuyer_Id(res.getInt("buyer_id"));
                feedback.setDate(res.getString("created_at"));
                feedback.setId(res.getInt("id"));
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return feedbacks;
    }

}
