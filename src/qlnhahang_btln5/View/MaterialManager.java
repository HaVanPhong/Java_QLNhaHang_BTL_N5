/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.View;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qlnhahang_btln5.Controller.AccountController;
import qlnhahang_btln5.Controller.MaterialController;
import qlnhahang_btln5.Models.Account;
import qlnhahang_btln5.Models.Material;

/**
 *
 * @author HaPhong
 */
public class MaterialManager extends javax.swing.JFrame {

    DefaultTableModel model=null;
    static Account acc = null;
    List<Material> materials;
    public MaterialManager() {
        initComponents();
        model= (DefaultTableModel) tbMaterial.getModel();
        materials= MaterialController.readAllRecord();
        for (Material mat: materials){
            model.addRow(new Object[]{
                mat.getIdMat(), mat.getName(), mat.getQuantity(), mat.getNote()
            });
        }
        setDateDefault();
   }
    public MaterialManager(int idUser) {
        initComponents();
        this.setLocationRelativeTo(null);
        acc = AccountController.getAccountByIdUser(idUser);
        model= (DefaultTableModel) tbMaterial.getModel();
        materials= MaterialController.readAllRecord();
        for (Material mat: materials){
            model.addRow(new Object[]{
                mat.getIdMat(), mat.getName(), mat.getQuantity(),mat.getNote()
            });
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        txtNgayNhap.setText(dtf.format(localDate)); 
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMaterial = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenNguyenLieu = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nguyên liệu trong kho");

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Home.png"))); // NOI18N
        btnHome.setText("Trang chủ");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Search.png"))); // NOI18N
        jButton1.setText("Tìm kiếm");

        txtSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbMaterial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nguyên Liệu", "Tên", "Số lượng", "Ghi chú"
            }
        ));
        tbMaterial.setRowHeight(24);
        tbMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMaterialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbMaterial);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tên nguyên liệu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 76, -1, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Số lượng");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 150, -1, 27));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ghi chú");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 27));

        txtTenNguyenLieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTenNguyenLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNguyenLieuActionPerformed(evt);
            }
        });
        jPanel1.add(txtTenNguyenLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 71, 214, 40));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Create.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 143, 42));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Edit.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 148, 42));

        btnXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Delete.png"))); // NOI18N
        btnXuat.setText("Xuất");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });
        jPanel1.add(btnXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 143, 45));

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Refresh.png"))); // NOI18N
        btnRefesh.setText("Làm mới");
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefesh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 148, 45));

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        jPanel1.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 145, 214, 40));

        txtGhiChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });
        jPanel1.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 214, 41));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Quản lý nguyên liệu trong kho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(txtSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Home home = new Home(acc.getIdUser());
        this.dispose();
        home.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtTenNguyenLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNguyenLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNguyenLieuActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int row = tbMaterial.getSelectedRow();
            int id= (int) model.getValueAt(row, 0);
            String tenNL= txtTenNguyenLieu.getText().trim();
            int soLuong= Integer.parseInt(txtSoLuong.getText().trim());
            String ghiChu= txtGhiChu.getText().trim();
            
            Material mat= new Material(id, tenNL, soLuong, ghiChu);
            
            try {
                MaterialController.updateRecord(mat);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Lỗi truy vấn", JOptionPane.ERROR_MESSAGE);
            }
            
            materials.remove(row);
            materials.add(row, mat);
            
            model.setValueAt(tenNL, row, 1);
            model.setValueAt(soLuong, row, 2);
            model.setValueAt(ghiChu, row, 3);
            
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String tenNL= txtTenNguyenLieu.getText().trim();
            int soLuong= Integer.parseInt(txtSoLuong.getText().trim());
            String ghiChu= txtGhiChu.getText().trim();
            int id= materials.size()==0? 1: materials.get(materials.size()-1).getIdMat()+1;
            Material mat= new Material(id, tenNL, soLuong, ghiChu);
            
            for (int i=0; i<materials.size(); i++){
                
            }
            
            MaterialController.insertRecord(mat);
            materials.add(mat);
            model.addRow(new Object[]{
            mat.getIdMat(), mat.getName(), mat.getQuantity(), mat.getNote()
            });
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        reset();
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void tbMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMaterialMouseClicked
        int row = tbMaterial.getSelectedRow();
        String tenNL=(String) model.getValueAt(row, 1);
        int soLuong=(int) model.getValueAt(row, 2);
        String ghiChu=(String) model.getValueAt(row, 3);
        
        txtTenNguyenLieu.setText(tenNL);
        txtSoLuong.setText(soLuong+"");
        txtGhiChu.setText(ghiChu);
        
    }//GEN-LAST:event_tbMaterialMouseClicked

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        try {            
            int row = tbMaterial.getSelectedRow();
            int id= (int) model.getValueAt(row, 0);
            String tenNL= txtTenNguyenLieu.getText().trim();
            int soLuongConLai= Integer.parseInt(txtSoLuong.getText().trim());
            String ghiChu= txtGhiChu.getText().trim();
                        
            soLuongConLai= materials.get(row).getQuantity()- soLuongConLai;
            
            if (soLuongConLai<0){
                throw new Exception("Không đủ số lượng xuất");
            }
            
            if (soLuongConLai==0){
                model.removeRow(row);
                try {
                    MaterialController.deleteRecord(id);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Lỗi truy vấn", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            Material mat= new Material(id, tenNL, soLuongConLai, ghiChu);
            
            try {
                MaterialController.updateRecord(mat);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Lỗi truy vấn", JOptionPane.ERROR_MESSAGE);
            }
            
            
            
            model.setValueAt(soLuongConLai, row, 2);
            
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXuatActionPerformed

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
            java.util.logging.Logger.getLogger(MaterialManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaterialManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaterialManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaterialManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaterialManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnXuat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbMaterial;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenNguyenLieu;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        txtTenNguyenLieu.setText("");
        txtGhiChu.setText("");
        txtSoLuong.setText("");
//        setDateDefault();
    }

    private void setDateDefault() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
//        txtNgayNhap.setText(dtf.format(localDate)); 
    }
}
