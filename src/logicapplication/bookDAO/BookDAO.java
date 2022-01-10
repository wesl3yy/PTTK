/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logicapplication.bookDAO;

import java.util.List;
import model.book.Book;
import model.book.Books;
import model.book.Magazine;
import util.OrderBy;

/**
 *
 * @author NamBui
 */
public interface BookDAO {
        // them
    Book addProduct(Book product);
    // sua
    void updateProduct(Book product);
    // xoa
    boolean removeProduct(int id);
    // tim kiem theo ten (va sap xep theo tieu chi nao do)
    List<Book> getProductsByName(String name, OrderBy orderBy);
    // lay tat ca san pham (va sap xep theo tieu chi nao do)
    List<Book> getAllProducts(OrderBy orderBy);
    // lay tat ca san pham theo category (va sap xep theo tieu chi nao do)
    List<Book> getLimitProductsByCategory(int categoryId, OrderBy orderBy, int pageId);
    // lay tat ca san pham theo keyword (va sap xep theo tieu chi nao do)
    List<Book> getLimitProductsByKeyWord(String keyword, OrderBy orderBy, int pageId);
    // tim kiem san pham voi so luong gioi han
    List<Book> getAllProductsLimit(OrderBy orderBy, int pageId);
    // dem so luong san pham
    int countProducts();
    // tim san pham theo id
    Book getProductById(int id);

    Books addBooks(Books books);
    void updateBooks(Books books);
    Magazine addMagazine(Magazine magazine);
    void updateMagazine(Magazine magazine);
    Magazine getMagazine(int id);
    Books getBooks(int id);
}
