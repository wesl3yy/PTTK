/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.book;

import model.category.Category;

/**
 *
 * @author NamBui
 */
public class Magazine extends Book {
    private int id;
    private String publicdate;
    private String numberofpage;
    private String language;
    
    public Magazine(){
        super();
    }
    
    public Magazine(int id, String publicdate, String numberofpage, String language){
        this.id = id;
        this.publicdate = publicdate;
        this.numberofpage = numberofpage;
        this.language = language;
    }
    
    public Magazine(int id1, String publicdate, String numberofpage, String language, int id2, String isbn, String name, Category category, double price, String type, String img){
        super(id1, isbn, name, category, price, type, img);
        this.id = id2;
        this.publicdate = publicdate;
        this.numberofpage = numberofpage;
        this.language = language;
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
    
    
}
