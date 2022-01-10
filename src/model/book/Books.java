/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.book;
import model.book.Book;
import model.category.Category;
/**
 *
 * @author NamBui
 */
public class Books extends Book {
    private int id;
    private String publicdate;
    private String numberofpage;
    private String language;
    private String author;
    private String publisher;
    
    public Books(){
        super();
    }
    
    public Books(int id, String publicdate, String numberofpage, String language, String author, String publisher){
        this.id = id;
        this.publicdate = publicdate;
        this.numberofpage = numberofpage;
        this.language = language;
        this.author = author;
        this.publisher = publisher;
    }
    
    public Books(int id1, String publicdate, String numberofpage, String language, String author, String publisher ,int id2, String isbn, String name, Category category, double price, String details, String img){
        super(id1, isbn, name, category, price, details, img);
        this.id = id2;
        this.publicdate = publicdate;
        this.numberofpage = numberofpage;
        this.language = language;
        this.author = author;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublicdate() {
        return publicdate;
    }

    public void setPublicdate(String publicdate) {
        this.publicdate = publicdate;
    }

    public String getNumberofpage() {
        return numberofpage;
    }

    public void setNumberofpage(String numberofpage) {
        this.numberofpage = numberofpage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
}
