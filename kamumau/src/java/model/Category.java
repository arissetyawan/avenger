<<<<<<< HEAD
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
    public String name;
    public int category_id;

    public void setId(int id) {
        this.id = id;
    }
    public void setParentId(int category_id) {
        this.category_id = category_id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Category find(int id){
        Category category = new Category();
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                category.setName(res.getString("name"));
                category.setParentId(res.getInt("category_id"));
                category.setId(res.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    public boolean create() {
        boolean result;
        String query = "INSERT INTO "+ tableName +"(name, category_id) values ('" + this.name + "', '" + this.category_id + "')";
        try {
            result= this.stateOpen().executeUpdate(query) > 0;
            this.stateClose();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public ArrayList<Category> all(){
        String query = "SELECT * FROM " + tableName;
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Category category = new Category();
                category.setName(res.getString("name"));
                category.setParentId(res.getInt("category_id"));
                category.setId(res.getInt("id"));
                categories.add(category);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
}
=======
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


//CREATE TABLE IF NOT EXISTS `categories` (
//  `id` int(11) NOT NULL AUTO_INCREMENT,
//  `name` varchar(30) NOT NULL,
//  `category_id` int(11) DEFAULT '0',
//  `description` text NOT NULL,
//  PRIMARY KEY (`id`),
//  UNIQUE KEY `id` (`id`)
//) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


public class Category extends MyConnection {
    private String tableName="categories";
    private int category_id;
    public String name, description;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    
    
    

//    public String getParentCategory() {
//        return parentCategory;
//    }
//
//    public void setParentCategory(String parentCategory) {
//        this.parentCategory = parentCategory;
//    }

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
                category.setCategory_id(res.getInt("category_id"));
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
        if(!"".equals(this.name) && !"".equals(this.category_id) && !"".equals(this.description)){
            status = true;
        }
        return status;
    }
    
     
    public boolean insert() {
        boolean result;
        
       String query = "INSERT INTO "+ tableName +"(name, category_id, description) values ('" 
               + this.name + "', '" 
               + this.category_id + "', '" 
               + this.description + "')";
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
        + this.name + "', description='" + this.description
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
                category.setCategory_id(res.getInt("category_id"));
                category.setDescription(res.getString("description"));
                categories.add(category);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
    
    
    public Category Search(String name){
        Category category = new Category();
        String query = "SELECT * FROM " + tableName + " WHERE name = " + name + " ";
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                category.setId(res.getInt("id"));
                category.setName(res.getString("name"));
                category.setCategory_id(res.getInt("category_id"));
                category.setDescription(res.getString("description"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }
    
       public ArrayList<Category> search(String keyword){
        String query = "SELECT * FROM " + tableName + " where name = '"+keyword+"'" ;
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Category category = new Category();
                category.setId(res.getInt("id"));
                category.setName(res.getString("name"));
                category.setCategory_id(res.getInt("category_id"));
                category.setDescription(res.getString("description"));
                
                categories.add(category);
            }
            
        } catch (SQLException e) {
            System.out.println("search() : "+e.getMessage());
        }
        return categories;
    }
}
>>>>>>> 2af7e0e9ff9a30b510bed6c243a915e9262afde3
