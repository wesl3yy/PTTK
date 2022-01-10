/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.book;

import java.io.Serializable;

/**
 *
 * @author NamBui
 */
public class BookItem implements Serializable{
       private static final long serialVersionUID = 4L;
       private int id;
       private Book product;
       private int quantity;
       private double price;
       
       public BookItem(){
           super();
       }
       
       public BookItem(int id, Book product, int quantity, double price){
           this.id = id;
           this.product = product;
           this.quantity = quantity;
           this.price = price;
       }
       
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getProduct() {
        return product;
    }

    public void setProduct(Book product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
