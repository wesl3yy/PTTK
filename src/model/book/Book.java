/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.book;

import java.io.Serializable;
import model.category.Category;

/**
 *
 * @author NamBui
 */
public class Book implements Serializable{
    private static final long serialVersionUID = 8L;
    private int id;
    private String isbn;
    private String name;
    private Category category;
    private double price;
    private String type;
    private String img;
    public Book() {
        super();
    }
    public Book(int id, String isbn, String name, Category category, double price, String type, String img) {
        super();
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.category = category;
        this.price = price;
        this.type = type;
        this.img = img;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    @Override
    public String toString() {
        return "Product [id=" + id + ", isbn=" + isbn +  ", name=" + name + ", category=" + category + ", price="
                        + price + ", type=" + type + ", img=" + img + "]";
    }
}
