<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author arissetyawan.email@gmail.com
 */
public class TestModel{
   
    public static void main(String args[]){
        /*
        Person p= new Person();
        p.find(1);
        p.setName("Jonox");
        p.create();
        System.out.println(System.currentTimeMillis());
        System.out.println(p.all());
        Order o = new Order();
        o.setUser(1);
        o.initOrCeate(2);
        o.find(1);
        o.setUser(1);
        o.initOrCeate(21);
        o.find(5);
        */
        Category cat = new Category();
        cat.setName("Category B");
        cat.create();
        System.out.println(cat.all());

    }
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author arissetyawan.email@gmail.com
 */
public class TestModel{
   
    public static void main(String args[]){
        /*
        Person p= new Person();
        p.find(1);
        p.setName("Jonox");
        p.create();
        System.out.println(System.currentTimeMillis());
        System.out.println(p.all());
        Order o = new Order();
        o.setUser(1);
        o.initOrCeate(2);
        o.find(1);
        o.setUser(1);
        o.initOrCeate(21);
        o.find(5);
        */
       Product p= new Product();
        p.find(1);
        p.setName("Micin");
        p.create();
        System.out.println(p);
        System.out.println(p.all());
    }
>>>>>>> 2af7e0e9ff9a30b510bed6c243a915e9262afde3
}