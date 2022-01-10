package logicapplication.categoryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicapplication.categoryDAO.CategoryDAO;
import model.category.Category;
import util.DBConnection;

public class CategoryDAOImpl implements CategoryDAO {

    //Thêm
    @Override
    public Category addCategory(Category category) {
        String sql = "INSERT INTO category(name) VALUES (?)";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, category.getName());
            ps.executeUpdate();
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Sửa
    @Override
    public void updateCategory(Category category) {
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Xóa
    @Override
    public boolean removeCategory(int id) {
        String sql = "DELETE FROM category WHERE id = " + id;
        try(
            Connection conn = DBConnection.getCon();
        ){
            return conn.createStatement().executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Lấy danh mục hàng
    @Override
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()) {
                Category cate = new Category();
                cate.setId(rs.getInt("id"));
                cate.setName(rs.getString("name"));
                list.add(cate);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Lấy danh mục hàng theo id
    @Override
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM category WHERE id = " + id;
        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            Category cate = new Category();
            while(rs.next()) {
                cate.setId(rs.getInt("id"));
                cate.setName(rs.getString("name"));
            }
            return cate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
