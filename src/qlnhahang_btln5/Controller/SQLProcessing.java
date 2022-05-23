package qlnhahang_btln5.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;




public class SQLProcessing {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try {
            if (conn!=null){
                statement = conn.createStatement();
            }else{
                System.out.println("Connect db fail");
            }
            System.out.println("Statement: "+ statement);
            
        } catch (NullPointerException e) {
            System.out.println("Error create statment because conn is null");
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex.getMessage());
        } 
    }
    

    //---------------------------- 
    
    
}
