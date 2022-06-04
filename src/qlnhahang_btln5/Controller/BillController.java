/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import qlnhahang_btln5.Models.Bill;


import java.util.List;
import static qlnhahang_btln5.Controller.SQLProcessing.statement;
import qlnhahang_btln5.Models.BillDetail;

/**
 *
 * @author ADMIN
 */
public class BillController {
    public static Bill getBill(int idBill){
        Bill bill = null;
        String sql = "select * from Bill where idBill='"+idBill+"'";
        try {
               ResultSet resultSet = statement.executeQuery(sql);
               if(resultSet.next()){
                    bill = new Bill(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6)
                   );
               }
           } catch (SQLException e) {
               System.out.println(e);
           }
        return bill;
    }
    
    public static ArrayList<Bill> getAllBill() {
        ArrayList<Bill> listBill = new ArrayList<>();
        String sql = "select * from Bill";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bill bill = new Bill(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6)
                );
                listBill.add(bill);
            }
        } catch (SQLException e) {
            System.out.println("Error get all bill: "+ e.getMessage());
        }
        
        return listBill;
    }
    
    public static ArrayList<Bill> getAllBill(Date from, Date to) {
        ArrayList<Bill> listBill = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String whereDate = "";
        if(from == null) {
            whereDate = to == null ? "" : " where createdAt <= '" + formatter.format(to) + "'";
        } else {
            whereDate = to == null ? " where createdAt >= '" + formatter.format(from) + "'" 
                    :" where createdAt >= '" + formatter.format(from) +"' and createdAt <= '"
                    + formatter.format(to) + "'";

        }

        String sql = "select * from Bill" + whereDate;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bill bill = new Bill(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6)
                );
                listBill.add(bill);
            }
        } catch (SQLException e) {
            System.out.println("Error get all bill: "+ e.getMessage());
        }
        
        return listBill;
    }
    
    public static boolean createBill(int idCus, int idEmp, int idTb, double total, List<BillDetail> listDetail){
        String sqlCreateBill = "insert into Bill(idCus, idEmp, idTb, total) values (?, ?, ?, ?)";
        String sqlCreateDetail = "insert into Billdetail(idBill, idDish, quantity) values (?, ?, ?)";
        boolean isSuccess = true;
        try {
            SQLProcessing.conn.setAutoCommit(false);
            PreparedStatement preCreateBill = SQLProcessing.conn.prepareStatement(sqlCreateBill, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement preCreateDetail = SQLProcessing.conn.prepareStatement(sqlCreateDetail);
         
            preCreateBill.setNull(1, java.sql.Types.NULL);           
            preCreateBill.setNull(2, java.sql.Types.NULL);
            preCreateBill.setNull(3, java.sql.Types.NULL);

            if(idCus > 0) {
                preCreateBill.setInt(1, idCus);
            }
            
            if(idEmp > 0) {
                preCreateBill.setInt(2, idEmp);
            }
            
            if(idTb > 0) {
                preCreateBill.setInt(3, idTb);
            }
            preCreateBill.setDouble(4, total);
            int affectedRows = preCreateBill.executeUpdate();
            
            if(affectedRows == 0) {
                throw new Exception("Create bill failed.");
            }
            
            int idBill = -1;
            ResultSet generatedKeys = preCreateBill.getGeneratedKeys();

            if(generatedKeys.next()) {
                idBill = generatedKeys.getInt(1);
            } else {
                throw new Exception("Cannot find bill id");
            }
            
            preCreateDetail.setInt(1, idBill);
            for(BillDetail detail : listDetail) {
                preCreateDetail.setInt(2, detail.getIdDish());
                preCreateDetail.setInt(3, detail.getQuantity());
                preCreateDetail.executeUpdate();
            }

            SQLProcessing.conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                SQLProcessing.conn.rollback();
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
            }
            isSuccess = false;
        }finally {
            try {
                SQLProcessing.conn.setAutoCommit(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return isSuccess;
    }
    
     public static boolean updateBill(int idBill, int idCus, int idEmp, int idTb, double total, List<BillDetail> listDetail){
        String sqlUpdateBill = "update Bill set idCus = ?, idEmp = ?, idTb = ?, total = ? where idBill = ?";
        String sqlCreateDetail = "insert into Billdetail(idBill, idDish, quantity) values (?, ?, ?)";
        String sqlDeleteDetail = "delete from Billdetail where idBill = ?";
        
        boolean isSuccess = true;
        try {
            SQLProcessing.conn.setAutoCommit(false);
            PreparedStatement preUpdateBill = SQLProcessing.conn.prepareStatement(sqlUpdateBill);
            PreparedStatement preCreateDetail = SQLProcessing.conn.prepareStatement(sqlCreateDetail);   
            PreparedStatement preDeleteDetail = SQLProcessing.conn.prepareStatement(sqlDeleteDetail);

            preUpdateBill.setNull(1, java.sql.Types.NULL);           
            preUpdateBill.setNull(2, java.sql.Types.NULL);
            preUpdateBill.setNull(3, java.sql.Types.NULL);

            if(idCus > 0) {
                preUpdateBill.setInt(1, idCus);
            }
            
            if(idEmp > 0) {
                preUpdateBill.setInt(2, idEmp);
            }
            
            if(idTb > 0) {
                preUpdateBill.setInt(3, idTb);
            }
            preUpdateBill.setDouble(4, total);
            preUpdateBill.setInt(5, idBill);
            int affectedRows = preUpdateBill.executeUpdate();
            
            if(affectedRows == 0) {
                throw new Exception("Update bill failed.");
            }
          
            preDeleteDetail.setInt(1, idBill);
            preDeleteDetail.executeUpdate();
            
            preCreateDetail.setInt(1, idBill);
            for(BillDetail detail : listDetail) {
                preCreateDetail.setInt(2, detail.getIdDish());
                preCreateDetail.setInt(3, detail.getQuantity());
                preCreateDetail.executeUpdate();
            }

            SQLProcessing.conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                SQLProcessing.conn.rollback();
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
            }
            isSuccess = false;
        }finally {
            try {
                SQLProcessing.conn.setAutoCommit(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return isSuccess;
    }
    
     public static boolean deleteBill(int idBill) {
        String sqlDeleteBill = "delete from Bill where idBill = ?";
        String sqlDeleteDetail = "delete from Billdetail where idBill = ?";
        
        boolean isSuccess = true;
        try {
            SQLProcessing.conn.setAutoCommit(false);
            PreparedStatement preDeleteBill = SQLProcessing.conn.prepareStatement(sqlDeleteBill);
            PreparedStatement preDeleteDetail = SQLProcessing.conn.prepareStatement(sqlDeleteDetail);

            preDeleteBill.setInt(1, idBill);
            preDeleteDetail.setInt(1, idBill);

            preDeleteDetail.executeUpdate();

            preDeleteBill.executeUpdate();
            
            SQLProcessing.conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                SQLProcessing.conn.rollback();
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
            }
            isSuccess = false;
        }finally {
            try {
                SQLProcessing.conn.setAutoCommit(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return isSuccess;
     }
}
