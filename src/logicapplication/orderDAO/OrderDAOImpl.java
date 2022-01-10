package logicapplication.orderDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logicapplication.bookDAO.BookDAO;
import logicapplication.bookDAO.BookDAOImpl;

import model.book.Book;
import model.book.BookItem;
import model.order.Order;
import model.order.OrderDTO;
import util.Common;
import util.Constants;
import util.DBConnection;

public class OrderDAOImpl implements OrderDAO {
	
    // Order details
    @Override
    public int addOrder(Order order) {
        String sqlOrder = "INSERT INTO `order`(customerID, created_date, status) VALUES (?, ?, ?)";
        String sqlItem = "INSERT INTO item(orderID, productID, price, quantity) VALUES (?, ?, ?, ?)";
        String sqlPayment = "INSERT into payment(type, orderID) VALUES (?,?)";
        Connection conn = null;
        try {
            conn = DBConnection.getCon();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlOrder, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser().getId());
            ps.setDate(2, new Date(new java.util.Date().getTime()));
            ps.setInt(3, Constants.ORDER_PENDING_PAYMENT);
            ps.executeUpdate();
            int orderId = -1;
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                orderId = rs.getInt(1);

            ps = conn.prepareStatement(sqlItem);

            for(BookItem item : order.getItems()) {
                ps.setInt(1, (int)orderId);
                ps.setInt(2, item.getProduct().getId());
                ps.setDouble(3, item.getPrice());
                ps.setInt(4, item.getQuantity());
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
            conn.close();
            ps.close();
            return orderId;
        } catch (Exception e) {
            try {
                conn.rollback();				
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<BookItem> getOrderByOrderId(int id) {
        String sql = "SELECT * FROM `order` INNER JOIN item ON item.orderID = `order`.id WHERE orderID = " + id;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            List<BookItem> list = new ArrayList<>();
            BookDAO productDao = new BookDAOImpl();
            while(rs.next()) {
                BookItem item = new BookItem();
                item.setId(rs.getInt("id"));
                item.setProduct(productDao.getProductById(rs.getInt("productID")));
                item.setQuantity(rs.getInt("quantity"));
                item.setPrice(rs.getDouble("price"));
                list.add(item);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Order DTO
    @Override
    public List<OrderDTO> getAllOrders() {
        String sql = "SELECT `order`.id, `order`.customerID, `order`.created_date, SUM(item.price * item.quantity) AS price, SUM(item.quantity) as quantity, `order`.status " + 
                    "FROM (`order` INNER JOIN item " + 
                    "ON `order`.id = item.orderID) " + 
                    "GROUP BY `order`.id, `order`.customerID, `order`.created_date, `order`.status";

        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            List<OrderDTO> list = new ArrayList<>();
            while(rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setId(rs.getInt("id"));
                order.setCustomerId(rs.getInt("customerID"));
                order.setQuantity(rs.getInt("quantity"));
                order.setPrice(rs.getDouble("price"));
                order.setCreatedDate(Common.dateToString(rs.getDate("created_date")));
                order.setStatus(rs.getInt("status"));
                list.add(order);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(int id) {
        String sql = "SELECT `order`.id, `order`.customerID, `order`.created_date, SUM(item.price * item.quantity) AS price, SUM(item.quantity) as quantity, `order`.status " + 
                        "FROM (`order` INNER JOIN item " + 
                        "ON `order`.id = item.orderID) " + 
                        "WHERE `order`.customerID = " + id + 
                        " GROUP BY `order`.id, `order`.customerID, `order`.created_date, `order`.status";

        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            List<OrderDTO> list = new ArrayList<>();
            while(rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setId(rs.getInt("id"));
                order.setCustomerId(rs.getInt("customerID"));
                order.setQuantity(rs.getInt("quantity"));
                order.setPrice(rs.getDouble("price"));
                order.setCreatedDate(Common.dateToString(rs.getDate("created_date")));
                order.setStatus(rs.getInt("status"));
                list.add(order);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int countOrders() {
        String sql = "SELECT COUNT(*) AS 'tong' FROM `order`";
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()) 
                    return rs.getInt("tong");
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateOrderStatus(int id, int status) {
        String sql = "UPDATE `order` SET status = " + status + " WHERE id = " + id;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
        ){
            return stmt.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) {
        new OrderDAOImpl().updateOrderStatus(1, 1);
    }
}
