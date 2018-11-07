<<<<<<< HEAD
/*
 * @author x201
 *  CREATE TABLE orders (
    id int(11) NOT NULL AUTO_INCREMENT,
    no int(11) NOT NULL,
    user_id int(11) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    status VARCHAR(5) NOT NULL,
    PRIMARY KEY (id)
);
);
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Order extends MyConnection{
    private final String tableName= "orders";
    private final String tableTransaction= "transaction";
    public int no;
    public int seller_id;
    public Date created_at;
    public Date updated_at;
    private String status;
    public int buyer_id;
    public int user_id;
    public String user_name;    
    public String product_name;
    public int price;
    public int order_id;
    public int product_id;
    public int qty;
    public int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String address;
    
    public Order() {
        super();
    }
    
    /*
    this method returns property id set by setId
    */

    public String getTableName() {
        return tableName;
    }

    public String getTableTransaction() {
        return tableTransaction;
    }

    public int getNo() {
        return no;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getStatus() {
        return status;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getId() {
        return id;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setNo(int no) {
        this.no = no;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }
    
    private String generateDate(){
        Date date= new Date();
        return String.format("%1$tY-%1$tm-%1$td", date);
    }

    private int generateNo(){
        return (int) System.currentTimeMillis();
    }
    
    public ArrayList<Order> all(int user_id){
        String query = "SELECT * FROM " + tableName  + "WHERE user_id = " + user_id;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setNo(res.getInt("no"));
                order.setCreated_at(res.getDate("created_at"));
                order.setUpdated_at(res.getDate("updated_at"));
                order.setId(res.getInt("id"));
                order.setSeller_id(res.getInt("seller_id"));
                order.setStatus(res.getString("status"));                
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
        }
        return orders;
    }
    
    public ArrayList<Order> getOrderIncom(int user_id, int seller_id) {
        String query = "SELECT o.id AS order_id, o.seller_id, o.no, o.buyer_id, u.full_name, o.address, "
                + "o.created_at, o.updated_at, o.status FROM orders o INNER JOIN user u ON "
                + "o.seller_id = u.id WHERE o.buyer_id = "+user_id+" AND o.status = 'new' AND seller_id = "+seller_id+";";
//        String query = "SELECT * FROM orders WHERE buyer_id = "+user_id+" AND status = 'new'";
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setId(res.getInt("order_id"));                
                order.setNo(res.getInt("no"));
                order.setCreated_at(res.getDate("created_at"));
                order.setUpdated_at(res.getDate("updated_at"));
                order.setUser_name(res.getString("full_name"));
                order.setAddress(res.getString("address"));
                order.setSeller_id(res.getInt("seller_id"));
                order.setBuyer_id(res.getInt("buyer_id"));
                order.setStatus(res.getString("status"));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
        }
        return orders;
    }
    
    public ArrayList<Order> getOrderCompleted(int user_id, int seller_id) {
        String query = "SELECT o.id AS order_id, o.seller_id, o.no, o.buyer_id, u.full_name, o.address, "
                + "o.created_at, o.updated_at, o.status FROM orders o INNER JOIN user u ON "
                + "o.seller_id = u.id WHERE o.buyer_id = "+user_id+" AND o.status = 'delivered' AND seller_id = "+seller_id+";";
//        String query = "SELECT * FROM orders WHERE buyer_id = "+user_id+" AND status = 'new'";
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setId(res.getInt("order_id"));                
                order.setNo(res.getInt("no"));
                order.setCreated_at(res.getDate("created_at"));
                order.setUpdated_at(res.getDate("updated_at"));
                order.setUser_name(res.getString("full_name"));
                order.setAddress(res.getString("address"));
                order.setSeller_id(res.getInt("seller_id"));
                order.setBuyer_id(res.getInt("buyer_id"));
                order.setStatus(res.getString("status"));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
        }
        return orders;
    }
    
    public ArrayList<Order> myCart(int user_id, int seller_id) {
//        String query = "SELECT o.id AS order_id, o.seller_id, o.no, o.buyer_id, u.full_name, o.address, "
//                + "o.created_at, o.updated_at, o.status FROM orders o INNER JOIN user u ON "
//                + "o.seller_id = u.id WHERE o.buyer_id = "+user_id+" AND o.status = 'cart' AND seller_id = "+seller_id+";";
        String query = "SELECT * FROM orders WHERE buyer_id = "+user_id+" AND status = 'cart' AND seller_id = "+seller_id+"; ";
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setId(res.getInt("id"));    
                order.setNo(res.getInt("no"));
                order.setUpdated_at(res.getDate("updated_at"));
                order.setProduct_name(res.getString("name"));
                order.setPrice(res.getInt("price"));
                order.setSeller_id(res.getInt("seller_id"));
                order.setBuyer_id(res.getInt("buyer_id"));
                order.setStatus(res.getString("status"));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
        }
        return orders;
    }
    
    private boolean validate(){
        return true;
    }

    public boolean updateStatus() {
        String now_date = generateDate();
        String query = "UPDATE "+ tableName + " SET status='"+ this.status + "', "
                + "updated_at = '"+ now_date +"' WHERE id = " + this.id;
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
            return false;
        }
    }
    
    public boolean updateOrderPayment() {
        String now_date = generateDate();
        String query = "UPDATE "+ tableName + " SET status='"+ this.status + "', "
                + "updated_at = '"+ now_date +"' address = '"+this.address+"' WHERE id = " + this.id;
        try {
            Statement stmt = this.conn().createStatement();
            stmt.executeUpdate(query);
            Statement st = this.conn().createStatement();
            query = "INSERT INTO transaction(order_id, product_id, price, qty, "
                    + "total) VALUES('"+this.order_id +"', '"+this.product_id+"', "
                    + "'"+this.price+"', '"+this.qty+"', '"+this.total+"')" ;
            return st.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
            return false;
        }
    }
    
    public boolean delete() {
        String query = "DELETE FROM " + tableName + " WHERE id = " + this.id;
        try {
            Statement stmt = this.conn().createStatement();
            stmt.executeUpdate(query);
            query = "DELETE FROM "+ tableTransaction+ " WHERE id_order = " + this.no;
            Statement st = this.conn().createStatement();
            return st.executeUpdate(query) > 1;
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
            return false;
        }
    }
    
    public Order findByOrderNo(int no){
        String query = "SELECT * FROM " + tableName + " WHERE id = " + no + " ";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));
                order.setUser_id(res.getInt("user_id"));
                order.setStatus(res.getString("status"));
                order.setCreated_at(res.getDate("created_at"));
                order.setUpdated_at(res.getDate("updated_at"));
            }
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
        }
        return order;
    }
    
    public Order find(int id){
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id + " ";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));                
                order.setProduct_name(res.getString("name"));
                order.setPrice(res.getInt("price"));
                order.setCreated_at(res.getDate("created_at"));
                order.setUpdated_at(res.getDate("updated_at"));
            }
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
        }
        return order;
    }

    public Order initOrCeate(int user_id){
        String query = "SELECT * FROM " + tableName + " WHERE user_id = " + user_id + " AND status='new'";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));
                order.setUser_id(res.getInt("user_id"));
                order.setStatus(res.getString("status"));
                order.setCreated_at(res.getDate("created_at"));
                order.setUpdated_at(res.getDate("updated_at"));
            }
            else{
                order.setId(id);
                if(order.create()){
                   order= order.findByOrderNo(order.getId());
                }
            }
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
        }
        return order;
    }
   
    public boolean create() {
        String now_date= generateDate();
        String query = "INSERT INTO "+ tableName +"(id, name, price, seller_id,"
                + "buyer_id, address, status, created_at, updated_at,status) "
                + "values ('" + this.generateNo() + "', '" + this.id  + "', '" +  now_date + "', "
                + "'" + now_date + "','incoming')";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.err.println("Error : "+e.getMessage());
        }
        return false;
    }
}
=======
/*
 * @author x201
 *  CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT,
    no int NOT NULL,
    user_id int NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    status VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);
);
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends MyConnection{
    private final String tableName= "orders";
    private final String tableTransaction= "transactions";
    public int no;
    public String name;
    public int user_id;
    public Date created_at;
    public Date updated_at;
    private String status="new";

    /* this constructor defined 
       this class to have same behaviour with it parents
    etc
    */
    public Order() {
        super();
    }
    
    /*
    this method returns property id set by setId
    */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setUser(int user_id) {
        this.user_id= user_id;
    }

    public void setStatus(String status) {
        this.status= status;
    }

    private String generateDate(){
        Date date= new Date();
        return String.format("%1$tY-%1$tm-%1$td", date);
    }

    private int generateNo(){
        return (int) System.currentTimeMillis();
    }
    public void setNo(int no) {
        this.no = no;
    }
    public void setCreatedAt(Date date){
        this.created_at= date;
    }
    public void setUpdatedAT(Date date){
        this.updated_at= date;
    }

    public ArrayList<Order> all(int user_id){
        String query = "SELECT * FROM " + tableName  + "WHERE user_id = " + user_id;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setNo(res.getInt("no"));
                order.setName(res.getString("name"));
                order.setCreatedAt(res.getDate("created_at"));
                order.setUpdatedAT(res.getDate("updated_at"));
                order.setId(res.getInt("id"));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    public ArrayList<Transaction> getTransactions(int order_id) {
        String query = "SELECT * FROM " + tableTransaction + " WHERE order_id= " + order_id;
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Transaction t = new Transaction();
                transactions.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transactions;
    }



    private boolean validate(){
        return true;
    }

    public boolean update() {
        return false;
    }
    
    public boolean delete() {
        return false;
    }
    
    public Order findByOrderNo(int no){
        String query = "SELECT * FROM " + tableName + " WHERE no = " + no + " ";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));
                order.setUser(res.getInt("user_id"));
                order.setStatus(res.getString("status"));
                order.setCreatedAt(res.getDate("created_at"));
                order.setUpdatedAT(res.getDate("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }
    public Order find(int id){
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id + " ";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));
                order.setName(res.getString(status));
                order.setCreatedAt(res.getDate("created_at"));
                order.setUpdatedAT(res.getDate("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    public Order initOrCeate(int user_id){
        String query = "SELECT * FROM " + tableName + " WHERE user_id = " + user_id + " AND status='new'";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));
                order.setUser(res.getInt("user_id"));
                order.setStatus(res.getString("status"));
                order.setCreatedAt(res.getDate("created_at"));
                order.setUpdatedAT(res.getDate("updated_at"));
            }
            else{
                order.setUser(user_id);
                if(order.create()){
                   order= order.findByOrderNo(order.getNo());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }
   
    private boolean create() {
        String now_date= generateDate();
        String status= "new";
        String query = "INSERT INTO "+ tableName +"(no, user_id, created_at, updated_at,status) values ('" + this.generateNo() + "', '" + this.user_id  + "', '" +  now_date + "', '" + now_date + "','" + status + "')";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
>>>>>>> 2af7e0e9ff9a30b510bed6c243a915e9262afde3
