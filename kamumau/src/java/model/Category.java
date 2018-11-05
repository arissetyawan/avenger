/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    
 * CREATE TABLE categories (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    category_id int(30),
    PRIMARY KEY (id)
); 
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author x201
 */
public class Category extends MyConnection {
    private String tableName="categories";
    public String name, description, parentCategory;
    private String query;
  
    

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    

    public Category find(int id){
        Category category = new Category();
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                category.setName(res.getString("name"));
                category.setParentCategory(res.getString("parent_category"));
                category.setId(res.getInt("id"));
                category.setDescription(res.getString("description"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    private boolean validate(){
        boolean status = false;
        if(!"".equals(this.name) && !"".equals(this.parentCategory) && !"".equals(this.description)){
            status = true;
        }
        return status;
    }
    
    private boolean validateName(){
        boolean status = false;
        if(!"".equals(this.parentCategory)){
           status = true;
        }
        return status;
    }
    
    
   public boolean create2() {
        boolean result;
        if(!validate()){
            String query = "INSERT INTO "+ tableName +"(name, description) values ('" + this.parentCategory + "', '" + this.description + "')";
            //return false;
            
        }
        String query = "INSERT INTO "+ tableName +"(name, parent_category, description) values ('" + this.name + "', '" + this.parentCategory + "', '" + this.description + "')";
        try {
            result= this.stateOpen().executeUpdate(query) > 0;
            this.stateClose();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean insert2(){
        boolean result;
        if(this.parentCategory.isEmpty()){
            
            String query = "INSERT INTO "+ tableName +"(name, parent_category, description) values ('" + this.name + "', null ,'" + this.description + "')";
            
        
        }
            String query = "INSERT INTO "+ tableName +"(name, parent_category, description) values ('" + this.name + "', '" + this.parentCategory + "', '" + this.description + "')";
            
        
        try {
            result= this.stateOpen().executeUpdate(query) > 0;
            this.stateClose();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    
    
    public boolean insert() {
        boolean result;
        
          //String query = "INSERT INTO "+ tableName +"(name, description) values ('" + this.parentCategory + "', '" + this.description + "')";
        
       String query = "INSERT INTO "+ tableName +"(name, parent_category, description) values ('" + this.name + "', '" + this.parentCategory + "', '" + this.description + "')";
        try {
            result= this.stateOpen().executeUpdate(query) > 0;
            this.stateClose();
            return result;
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
    public boolean update() {
        if(!validate()){
            return false;
        }
        String query = "UPDATE "+ tableName + " SET name='"
        + this.name + "', parent_category='" + this.parentCategory
        + "', description='" + this.description
        + "' WHERE id = " + this.id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    

    public ArrayList<Category> all(){
        String query = "SELECT * FROM " + tableName+" ";
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Category category = new Category();
                category.setId(res.getInt("id"));
                category.setName(res.getString("name"));
                category.setParentCategory(res.getString("parent_category"));
                category.setDescription(res.getString("description"));
                categories.add(category);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
    public ArrayList<Category> search(String name){
        String query = "SELECT name FROM " + tableName+"WHERE id like '% "+id+"%' OR name like '%"+name+"%'";
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Category category = new Category();
                category.setId(res.getInt("id"));
                category.setName(res.getString("name"));
                category.setParentCategory(res.getString("parent_category"));
                category.setDescription(res.getString("description"));
                categories.add(category);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
}
