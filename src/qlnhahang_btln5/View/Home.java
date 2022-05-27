/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.View;

import javax.swing.JOptionPane;
import qlnhahang_btln5.Controller.EmployeeController;
import qlnhahang_btln5.Models.Employee;

/**
 *
 * @author duong
 */
public class Home extends javax.swing.JFrame {
    static Employee emp = null;
    /**
     * Creates new form Home
     */
    public Home(){
        initComponents();
    }
    public Home(int idEmp){
        initComponents();
        emp = EmployeeController.GetEmployee(idEmp);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        qlNhanVien = new javax.swing.JMenuItem();
        qlThucDon = new javax.swing.JMenuItem();
        qlBan = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("Trang chủ ");
        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setText("Order");
        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setText("Quản lý");

        qlNhanVien.setText("Nhân viên");
        qlNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qlNhanVienMouseClicked(evt);
            }
        });
        qlNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qlNhanVienActionPerformed(evt);
            }
        });
        jMenu3.add(qlNhanVien);

        qlThucDon.setText("Thực đơn");
        jMenu3.add(qlThucDon);

        qlBan.setText("Bàn");
        jMenu3.add(qlBan);

        jMenuBar1.add(jMenu3);

        jMenu4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu4.setText("Thống kê");
        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu5.setText("Trợ giúp");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 997, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qlNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qlNhanVienActionPerformed
        // TODO add your handling code here:
        ManagerEmployee mn = new ManagerEmployee();
        mn.setVisible(true);
    }//GEN-LAST:event_qlNhanVienActionPerformed

    private void qlNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlNhanVienMouseClicked
        
    }//GEN-LAST:event_qlNhanVienMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        if(emp == null){
            new Home().setVisible(false);
            new Login().setVisible(true);
            System.out.println(emp);
        }else{
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Home().setVisible(true);
                }
            });
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem qlBan;
    private javax.swing.JMenuItem qlNhanVien;
    private javax.swing.JMenuItem qlThucDon;
    // End of variables declaration//GEN-END:variables
}
