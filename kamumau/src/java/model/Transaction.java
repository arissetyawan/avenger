/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author x201
 * CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT,
    no varchar(10) NOT NULL,
    user_id int NOT NULL.
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    PRIMARY KEY (id)
);
 */
public class Transaction extends MyConnection{
    private int id_order;
    private int id_product;
    private int qty;
    private int total;
    private String name;
    private static final String TABLE_NAME = "transaction";
    private static final String TABLE_NAME_ORDER = "orders";
    
    public Transaction(int id_order, int id_product, int qty, int total) {
        this.id_order = id_order;
        this.id_product = id_product;
        this.qty = qty;
        this.total = total;
    }

    public int getId_order() {
        return id_order;
    }

    public int getId_product() {
        return id_product;
    }

    public int getQty() {
        return qty;
    }

    public int getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public static String getTABLE_NAME_ORDER() {
        return TABLE_NAME_ORDER;
    }

    public int getId() {
        return id;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    
        
}
