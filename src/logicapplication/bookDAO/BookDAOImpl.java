/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicapplication.bookDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logicapplication.categoryDAO.CategoryDAOImpl;
import model.book.Book;
import model.book.Books;
import model.book.Magazine;
import util.Constants;
import util.DBConnection;
import util.OrderBy;

/**
 *
 * @author NamBui
 */
public class BookDAOImpl implements BookDAO{

    @Override
    public Book addProduct(Book product) {
        String sql = "INSERT INTO book(isbn, name, categoryID, price, type, img) VALUES (?,?,?,?,?,?)";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, product.getIsbn());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getCategory().getId());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getType());
            ps.setString(6, product.getImg());
            ps.executeUpdate();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProduct(Book product) {
        String sql = "UPDATE book SET isbn = ?, name = ?, categoryID = ?,"
                    + "price = ?, type = ?, img = ? WHERE id = ?";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, product.getIsbn());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getCategory().getId());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getType());
            ps.setString(6, product.getImg());
            ps.setInt(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeProduct(int id) {
        String sql = "DELETE FROM book WHERE id = " + id;
        try(
            Connection conn = DBConnection.getCon();
        ){
            return conn.createStatement().executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> getProductsByName(String name, OrderBy orderBy) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE name LIKE ? ORDER BY " + orderBy.getSomething();
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book product = new Book();
                product.setId(rs.getInt("id"));
                product.setIsbn("isbn");
                product.setName(rs.getString("name"));
                product.setCategory(new CategoryDAOImpl().getCategoryById(rs.getInt("categoryID")));
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImg(rs.getString("img"));
                list.add(product);
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAllProducts(OrderBy orderBy) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book ORDER BY " + orderBy.getSomething();
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()) {
                Book product = new Book();
                product.setId(rs.getInt("id"));
                product.setIsbn(rs.getString("isbn"));
                product.setName(rs.getString("name"));
                product.setCategory(new CategoryDAOImpl().getCategoryById(rs.getInt("categoryID")));
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImg(rs.getString("img"));
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getLimitProductsByCategory(int categoryId, OrderBy orderBy, int pageId) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE categoryID = " + categoryId + " ORDER BY " + orderBy.getSomething()
                    + " LIMIT " + ((pageId - 1) * Constants.NUMBER_PER_PAGES) + "," + Constants.NUMBER_PER_PAGES ;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()) {
                Book product = new Book();
                product.setId(rs.getInt("id"));
                product.setIsbn(rs.getString("isbn"));
                product.setName(rs.getString("name"));
                product.setCategory(new CategoryDAOImpl().getCategoryById(rs.getInt("categoryID")));
                
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImg(rs.getString("img"));
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getLimitProductsByKeyWord(String keyword, OrderBy orderBy, int pageId) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE name LIKE N'%" + keyword + "%' ORDER BY " + orderBy.getSomething()
                        + " LIMIT " + ((pageId - 1) * Constants.NUMBER_PER_PAGES) + "," + Constants.NUMBER_PER_PAGES ;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()) {
                Book product = new Book();
                product.setId(rs.getInt("id"));
                product.setIsbn(rs.getString("isbn"));
                product.setName(rs.getString("name"));
                product.setCategory(new CategoryDAOImpl().getCategoryById(rs.getInt("categoryID")));
              
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImg(rs.getString("img"));
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAllProductsLimit(OrderBy orderBy, int pageId) {
         List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book ORDER BY " + orderBy.getSomething()
            + " LIMIT " + ((pageId - 1) * Constants.NUMBER_PER_PAGES) + "," + Constants.NUMBER_PER_PAGES ;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()) {
                Book product = new Book();
                product.setId(rs.getInt("id"));
                product.setIsbn(rs.getString("isbn"));
                product.setName(rs.getString("name"));
                product.setCategory(new CategoryDAOImpl().getCategoryById(rs.getInt("categoryID")));
                
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImg(rs.getString("img"));
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countProducts() {
        String sql = "SELECT COUNT(*) AS products FROM book";
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next())
                return rs.getInt("products");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Book getProductById(int id) {
        String sql = "SELECT * FROM book WHERE id = " + id;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()) {
                Book product = new Book();
                product.setId(rs.getInt("id"));
                product.setIsbn(rs.getString("isbn"));
                product.setName(rs.getString("name"));
                product.setCategory(new CategoryDAOImpl().getCategoryById(rs.getInt("categoryID")));
               
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImg(rs.getString("img"));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Books addBooks(Books product) {
        String sql = "INSERT INTO book(isbn ,name, categoryID, price, type, img, publicationdate, numberofpage, language, author, publisher) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, product.getIsbn());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getCategory().getId());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getType());
            ps.setString(6, product.getImg());
            ps.setString(7, product.getPublicdate());
            ps.setString(8, product.getNumberofpage());
            ps.setString(9, product.getLanguage());
            ps.setString(10, product.getAuthor());
            ps.setString(11, product.getPublisher());
            ps.executeUpdate();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Magazine addMagazine(Magazine product) {
        String sql = "INSERT INTO book(isbn,name, categoryID, price, type, img, publicationdate, numberofpage, language) VALUES (?,?,?,?,?,?,?,?,?)";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, product.getIsbn());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getCategory().getId());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getType());
            ps.setString(6, product.getImg());
            ps.setString(7, product.getPublicdate());
            ps.setString(8, product.getNumberofpage());
            ps.setString(9, product.getLanguage());
            ps.executeUpdate();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateMagazine(Magazine product) {
        String sql = "UPDATE book SET isbn = ?, name = ?, categoryID = ?, price = ?, type = ?, img = ?, publicationdate = ?, numberofpage = ?, language = ? WHERE id = ? ";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, product.getIsbn());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getCategory().getId());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getType());
            ps.setString(6, product.getImg());
            ps.setString(7, product.getPublicdate());
            ps.setString(8, product.getNumberofpage());
            ps.setString(9, product.getLanguage());
            ps.setInt(10, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Magazine getMagazine(int id) {
        String sql = "SELECT * FROM book WHERE id = " + id;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()) {
                Magazine product = new Magazine();
                product.setId(rs.getInt("id"));
                product.setIsbn(rs.getString("isbn"));
                product.setName(rs.getString("name"));
                product.setCategory(new CategoryDAOImpl().getCategoryById(rs.getInt("categoryID")));
               
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImg(rs.getString("img"));
                
                product.setPublicdate(rs.getString("publicationdate"));
                product.setNumberofpage(rs.getString("numberofpage"));
                product.setLanguage(rs.getString("language"));
                
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateBooks(Books product) {
        String sql = "UPDATE book SET isbn = ?, name = ?, categoryID = ?, price = ?, type = ?, img = ?, publicationdate = ?, numberofpage = ?, language = ?, author = ?, publisher = ? WHERE id = ?";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, product.getIsbn());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getCategory().getId());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getType());
            ps.setString(6, product.getImg());
            ps.setString(7, product.getPublicdate());
            ps.setString(8, product.getNumberofpage());
            ps.setString(9, product.getLanguage());
            ps.setString(10, product.getAuthor());
            ps.setString(11, product.getPublisher());
            ps.setInt(12, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Books getBooks(int id) {
        String sql = "SELECT * FROM book WHERE id = " + id;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()) {
                Books product = new Books();
                product.setId(rs.getInt("id"));
                product.setIsbn(rs.getString("isbn"));
                product.setName(rs.getString("name"));
                product.setCategory(new CategoryDAOImpl().getCategoryById(rs.getInt("categoryID")));
               
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                product.setImg(rs.getString("img"));
                product.setPublicdate(rs.getString("publicationdate"));
                product.setNumberofpage(rs.getString("numberofpage"));
                product.setLanguage(rs.getString("language"));
                product.setAuthor(rs.getString("author"));
                product.setPublisher(rs.getString("publisher"));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
