
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
    public static int insertRecord(Tables table) throws SQLException {
        String sqlInsert = "insert into Tables values ("+table.getTbNumber()+", N'"+table.getGhiChu()+"')";
        return statement.executeUpdate(sqlInsert);
    }
    
    public static List<Tables> readAllTables() throws SQLException {
        List<Tables> tbs = new ArrayList<>();
        String sql = "select * from Tables";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Tables tb = new Tables(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)
            );
            tbs.add(tb);
        }
        return tbs;
    }
    
    public static int deleteRecord(int idTable) throws SQLException {
        String sqlDelete = "delete from Tables where tbNumber="+idTable;
        return statement.executeUpdate(sqlDelete);
    }
    public static int updateRecord(Tables table) throws SQLException {
        String sqlUpdate =
                "update Tables set tbNumber ="+table.getTbNumber()+ ", note=N'"+table.getGhiChu()+"' where idTB ="+table.getIdTB()+"";
        return statement.executeUpdate(sqlUpdate);
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
