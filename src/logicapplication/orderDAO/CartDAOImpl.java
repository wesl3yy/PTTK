/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicapplication.orderDAO;

import logicapplication.orderDAO.CartDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.book.BookItem;
import util.DBConnection;

/**
 *
 * @author Cuong
 */
public class CartDAOImpl implements CartDAO{

    @Override
    public void addToCart(BookItem item, int id) {
        String sqlCart = "INSERT INTO cart(customerID, itemID, status) VALUES (?,?, 0)";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sqlCart);
        ){            
            ps.setInt(1, id);
            ps.setInt(2, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFromCart(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkOut(int id) {
        //String sqlOrder = "insert into order"
        String sql = "UPDATE cart SET orderID = ? "
                + "WHERE id = ?";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void createCart(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BookItem> getCart(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
