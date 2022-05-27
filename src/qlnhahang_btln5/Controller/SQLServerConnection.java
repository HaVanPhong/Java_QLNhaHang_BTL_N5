package qlnhahang_btln5.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:sqlserver://DESKTOP-0RUMIDL\\SQLEXPRESS:1433;databaseName=QuanLyNhaHang;user=sa;password=123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: "+ e.getMessage());
        } catch (Exception ee){
            System.out.println("Error: cannot connect-- "+ ee.getMessage());
        }
        return null;
    }
}
