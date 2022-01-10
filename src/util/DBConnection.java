package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


	public static String URL = "jdbc:mysql://localhost:3306/shop1";
	public static String USER = "root";
	public static String PASSWORD = "root";
	public static String DRIVER = "com.mysql.cj.jdbc.Driver";

	
    public static Connection getCon() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
