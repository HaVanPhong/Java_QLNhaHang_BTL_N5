
package qlnhahang_btln5.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static qlnhahang_btln5.Controller.SQLProcessing.statement;
import qlnhahang_btln5.Models.Tables;

/**
 *
 * @author HaPhong
 */
public class TableController {
    public static int insertRecord(Tables table) {
        String sqlInsert = "insert into Tables values ("+table.getTbNumber()+", N'"+table.getGhiChu()+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            return -1;
        }
    }
    
    public static List<Tables> readAllTables() {
        List<Tables> tbs = new ArrayList<>();
        String sql = "select * from Tables";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Tables tb = new Tables(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3)
                );

                tbs.add(tb);
            }
        } catch (SQLException e) {
            System.out.println("Error: read all tables fail");
        }
        return tbs;
    }
    
    public static int deleteRecord(int idTable) {
        String sqlDelete = "delete from Tables where tbNumber="+idTable;
        System.out.println("sql: "+ sqlDelete);
        try {
            return statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static int updateRecord(Tables table) {
        String sqlUpdate =
                "update Tables set tbNumber ="+table.getTbNumber()+ ", note=N'"+table.getGhiChu()+"' where idTB ="+table.getIdTB()+"";
        try {
            return statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public static Tables getTable(int idTb){
        Tables table = null;
        String sql = "select * from Tables where idTB='"+idTb+"'";
        try {
            System.out.println("");
           ResultSet resultSet = statement.executeQuery(sql);
           if(resultSet.next()){
               table = new Tables(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)
               );
           }
       } catch (SQLException e) {
           System.out.println(e);
       }
        return table;
    }
}
