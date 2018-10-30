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
    private final String tableName= "feedback";
    public String rating;
    public String content;
    public String order_id;
    public String seller_id;
    public String buyer_id;

    public Feedback() {
        super();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrder_Id() {
        return order_id;
    }

    public void setOrder_Id(String order_id) {
        this.order_id = order_id;
    }
    
    public String getSeller_Id() {
        return seller_id;
    }

    public void setSeller_Id(String seller_id) {
        this.seller_id = seller_id;
    }
    
    public String getBuyer_Id() {
        return buyer_id;
    }

    public void setBuyer_Id(String buyer_id) {
        this.buyer_id = buyer_id;
    }
    
    public boolean create() {
        boolean result;
        if(!validate()){
            return false;
        }
        
        String query = "INSERT INTO "+ tableName +"(rating, content, order_id, "
                + "seller_id, buyer_id) values ('" + this.rating + "', '" + 
                this.content + "', '" + this.order_id + "', '" + this.seller_id + 
                "', '" + this.buyer_id + "')";
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
    
    public boolean delete() {
        String query = "DELETE FROM " + tableName + " WHERE id = " + this.id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<Feedback> all(){
        String query = "SELECT * FROM " + tableName;
        ArrayList<Feedback> feedbacker = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Feedback feedback = new Feedback();
                feedback.setRating(res.getString("rating"));
                feedback.setContent(res.getString("content"));
                feedback.setOrder_Id(res.getString("order_id"));
                feedback.setSeller_Id(res.getString("seller_id"));
                feedback.setBuyer_Id(res.getString("buyer_id"));
                feedback.setId(res.getInt("id"));
                feedbacker.add(feedback);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return feedbacker;
    }
}
