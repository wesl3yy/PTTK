package logicapplication.managerDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicapplication.customerDAO.CustomerDAO;
import model.customer.Customer;
import util.Common;
import util.DBConnection;

public class ManagerDAOImpl implements ManagerDAO {

    @Override
    public boolean checkLoginInfo(String username, String password) {
        String sql = "SELECT * FROM manager WHERE username = ? AND password = ?";
        try(
            Connection conn = DBConnection.getCon();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, username);
            ps.setString(2, password);
            if(ps.executeQuery().next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
