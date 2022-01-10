/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicapplication.orderDAO;

import java.util.List;
import model.book.BookItem;

/**
 *
 * @author Cuong
 */
public interface CartDAO {
    public void createCart(int id);
    public void addToCart(BookItem item, int id);
    public void deleteFromCart(int id);
    public void checkOut(int id);
    public List<BookItem> getCart(int id);
}
