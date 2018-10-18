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
 *CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT,
    no varchar(10) NOT NULL,
    user_id int NOT NULL.
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    PRIMARY KEY (id)
);
 * @author x201
 */
public class Product extends MyConnection{
    private final String tableName= "product";
    public String name;
    public String price;
    public String stock;
    public String updated;
    public String category;


    public Product() {
        super();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
     public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
     public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public boolean create() {
        if(!validate()){
            return false;
        }
        String query = "INSERT INTO "+ tableName +"(category, name, price, stock) values ('" + this.category + "', '" + this.name + "', '" + this.price + "', '" + this.stock + "')";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validate(){
        boolean status= false;
        if (!"".equals(this.name) &&  !"".equals(this.price)){
            status= true;
        } 
        return status;
    }

    public boolean update() {
        if(!validate()){
            return false;
        }
        String query = "UPDATE "+ tableName + " SET category='"
        + this.category + "', name='" + this.name
        + "', price='" + this.price
        + "', stock='" + this.stock
        + "' WHERE id = " + this.id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
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
    
    public Product find(int id){
        Product product = new Product();
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                product.setCategory(res.getString("category"));
                product.setName(res.getString("name"));
                product.setPrice(res.getString("price"));
                product.setStock(res.getString("stock"));
                product.setUpdated(res.getString("updated_at"));
                product.setId(res.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public ArrayList<Product> all(){
        String query = "SELECT * FROM " + tableName;
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Product product = new Product();
                product.setCategory(res.getString("category"));
                product.setName(res.getString("name"));
                product.setPrice(res.getString("price"));
                product.setStock(res.getString("stock"));
                product.setUpdated(res.getString("updated_at"));
                product.setId(res.getInt("id"));
              
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
    
}
