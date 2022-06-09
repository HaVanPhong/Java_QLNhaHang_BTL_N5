/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.View;

import java.awt.HeadlessException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qlnhahang_btln5.Controller.AccountController;
import qlnhahang_btln5.Controller.EmployeeController;
import qlnhahang_btln5.Models.Account;
import qlnhahang_btln5.Models.Employee;

/**
 *
 * @author huong
 */
public class AccountManager extends javax.swing.JFrame {
    DefaultTableModel model = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    String [] TileAcc = {"STT","Mã tài khoản","Mã nhân viên","Họ tên","Chức vụ","Tài khoản","Quyền"};
    String [] Tile = {"STT","Mã nhân viên","Họ tên","Chức vụ"};
    static ArrayList<Employee> listEmp = new ArrayList<>();
    static Account acc = null;
    /**
     * Creates new form ManagerEmployee
     */
    public AccountManager() {
        initComponents();
        this.setLocationRelativeTo(null);
        model =  (DefaultTableModel) tbQlAccount.getModel();
        ShowTableEmpAcc();
    }
    public AccountManager(int idUser) {
        initComponents();
        this.setLocationRelativeTo(null);
        acc = AccountController.getAccountByIdUser(idUser);
        model =  (DefaultTableModel) tbQlAccount.getModel();
        ShowTableEmpAcc();
    }
    public void  ShowTableEmpAcc(){
        model.setColumnIdentifiers(TileAcc);
        listEmp = EmployeeController.GetAllEmployee();
        //System.out.println(listEmp.size());
        model.setRowCount(0);
        int stt =1;
        for (Employee emp : listEmp) {
            Account acc = AccountController.getAccountByIdEmp(emp.getIdEmp());
            if(acc != null){
                model.addRow(new Object[]{
                    stt++,acc.getIdUser(),emp.getIdEmp(),emp.getFullname(),emp.getPosition(),acc.getUsername(),acc.getRole()
                });
            }
        }
    }
    
    public void  ShowTableEmp(){
        model.setColumnIdentifiers(Tile);
        listEmp = EmployeeController.GetAllEmployee();
        System.out.println(listEmp.size());
        
        model.setRowCount(0);
        int stt =1;
        for (Employee emp : listEmp) {
            Account acc = AccountController.getAccountByIdEmp(emp.getIdEmp());
            if(acc == null){
                model.addRow(new Object[]{
                    stt++,emp.getIdEmp(),emp.getFullname(),emp.getPosition()
                });
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfullname = new javax.swing.JTextField();
        cbbRole = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIdEmp = new javax.swing.JTextField();
        panelResetPW = new javax.swing.JPanel();
        cbResetPass = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbQlAccount = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        cbTbaleEmp = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý Tài Khoản");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Create.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Edit.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Refresh.png"))); // NOI18N
        btnRefesh.setText("Làm mới");
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Họ tên : ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Quyền");

        txtfullname.setEnabled(false);

        cbbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        cbbRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbRoleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tài Khoản : ");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Mã nhân viên:");

        txtIdEmp.setEnabled(false);

        panelResetPW.setBackground(new java.awt.Color(204, 255, 204));

        cbResetPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbResetPass.setText("Đặt lại mật khẩu");
        cbResetPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelResetPWLayout = new javax.swing.GroupLayout(panelResetPW);
        panelResetPW.setLayout(panelResetPWLayout);
        panelResetPWLayout.setHorizontalGroup(
            panelResetPWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResetPWLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbResetPass)
                .addGap(82, 82, 82))
        );
        panelResetPWLayout.setVerticalGroup(
            panelResetPWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResetPWLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbResetPass)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(txtIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfullname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(panelResetPW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(40, 40, 40)
                .addComponent(panelResetPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145))
        );

        tbQlAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbQlAccount.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbQlAccountAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbQlAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbQlAccountMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbQlAccount);

        txtSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Home.png"))); // NOI18N
        btnHome.setText("Trang chủ");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        cbTbaleEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbTbaleEmp.setText("Nhân viên chưa có tài khoản");
        cbTbaleEmp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbTbaleEmpStateChanged(evt);
            }
        });
        cbTbaleEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTbaleEmpMouseClicked(evt);
            }
        });
        cbTbaleEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTbaleEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTbaleEmp)
                        .addGap(51, 51, 51)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(57, 57, 57))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch)
                        .addComponent(txtSearch)
                        .addComponent(cbTbaleEmp))
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Home home = new Home(acc.getIdUser());
        this.dispose();
        home.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void tbQlAccountAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbQlAccountAncestorAdded

    }//GEN-LAST:event_tbQlAccountAncestorAdded
    void resetForm(){
        txtIdEmp.setText("");
        txtfullname.setText("");
        txtUsername.setText("");
        cbbRole.setSelectedItem("User");
        cbResetPass.setSelected(false);
    }
    private void tbQlAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQlAccountMouseClicked
        int row = tbQlAccount.getSelectedRow();
        resetForm();
        if(cbTbaleEmp.isSelected() == true){
            txtIdEmp.setText(model.getValueAt(row,1).toString());
            txtfullname.setText(model.getValueAt(row,2).toString());
        }else{
            txtIdEmp.setText(model.getValueAt(row,2).toString());
            txtfullname.setText(model.getValueAt(row,3).toString());
            txtUsername.setText(model.getValueAt(row,5).toString());
            cbbRole.setSelectedItem(model.getValueAt(row,6).toString());
        }
    }//GEN-LAST:event_tbQlAccountMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        listEmp = EmployeeController.SearchEmployee(txtSearch.getText());
        if(cbTbaleEmp.isSelected() == true){
            ShowTableEmp();
        }else{
            ShowTableEmpAcc();
        }   
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        if(cbTbaleEmp.isSelected() == true){
            ShowTableEmp();
        }else{
            ShowTableEmpAcc();
        }
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tbQlAccount.getSelectedRow();
        if(row >= 0){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa bản ghi này?","Admin",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                int idUser = Integer.parseInt(model.getValueAt(row,1).toString());
                if(AccountController.DeleteAccountById(idUser)){
                    JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
                    resetForm();
                    ShowTableEmpAcc();
                }
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn bản ghi nào", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int row = tbQlAccount.getSelectedRow();
            if(row>=0){
                int idUser = Integer.parseInt(model.getValueAt(row, 1).toString());
                String regUserName = "^[_a-z0-9]{6,}$";
                String username = txtUsername.getText();
                if(!username.matches(regUserName)){
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng đặt tên tài khoản không có ký tự đặc biệt và có ít nhất 6 chữ số!");
                }else if(AccountController.CheckDuplicateUsername(username)){
                    JOptionPane.showMessageDialog(rootPane, "Tên tài khoản đã tồn tại!");
                }else{
                    String role = cbbRole.getSelectedItem().toString();
                    String pass = "";
                    if(cbResetPass.isSelected()){
                        if(AccountController.UpdateAccountById(idUser, username, HashPasswordDefault(username), role)){
                            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
                        }
                    }else{
                        pass = AccountController.getAccountByIdEmp(Integer.parseInt(txtIdEmp.getText())).getPassword();
                        if(AccountController.UpdateAccountById(idUser, username, pass, role)){
                            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                            ShowTableEmpAcc();
                            resetForm();
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn bản ghi nào", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Có lỗi trong quá trình sửa!");
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            int idEmp = Integer.parseInt(txtIdEmp.getText());
            String regUserName = "^[_a-z0-9]{6,}$";
            
            String username = txtUsername.getText();
            if(!username.matches(regUserName)){
                JOptionPane.showMessageDialog(rootPane, "Vui lòng đặt tên tài khoản không có ký tự đặc biệt và có ít nhất 6 chữ số!");
            }else if(AccountController.CheckDuplicateUsername(username)){
                    JOptionPane.showMessageDialog(rootPane, "Tên tài khoản đã tồn tại!");
            }else{
                String role = cbbRole.getSelectedItem().toString();
                if(AccountController.CreateAccount(username,HashPasswordDefault(username), role, idEmp)){
                    JOptionPane.showMessageDialog(rootPane, "Tạo tài khoản thành công!");
                    ShowTableEmp();
                    resetForm();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Tạo tài khoản thất bại!");
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ hoặc chính xác");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void cbTbaleEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTbaleEmpMouseClicked
        resetForm();
        if(cbTbaleEmp.isSelected() == true){
            ShowTableEmp();
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
            btnAdd.setEnabled(true);
            panelResetPW.setVisible(false);
        }else{
            ShowTableEmpAcc();
            btnAdd.setEnabled(false);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            panelResetPW.setVisible(true);
        }
    }//GEN-LAST:event_cbTbaleEmpMouseClicked
    
    private void cbTbaleEmpStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbTbaleEmpStateChanged
      // TODO add your handling code here:
    }//GEN-LAST:event_cbTbaleEmpStateChanged

    private void cbbRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbRoleActionPerformed

    private void cbTbaleEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTbaleEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTbaleEmpActionPerformed
    public static String getMd5(String input) 
    { 
        try { 
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
    public static String HashPasswordDefault(String username){
        return getMd5(username+"123");
    }
    void ClearForm(){
        
//        txtfullname.requestFocus();
//        txtAddress.setText("");
//        dateBirthDay.setDate(date);
//        txtPhone.setText("");
//        txtSalary.setText("");
//        txtfullname.setText("");
//        rdoMale.setSelected(true);
//        cbbPositon.setSelectedIndex(0);
    }
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
            java.util.logging.Logger.getLogger(AccountManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AccountManager screen = new AccountManager();
                screen.setLocationRelativeTo(null);
                
                screen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbResetPass;
    private javax.swing.JCheckBox cbTbaleEmp;
    private javax.swing.JComboBox<String> cbbRole;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelResetPW;
    private javax.swing.JTable tbQlAccount;
    private javax.swing.JTextField txtIdEmp;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtfullname;
    // End of variables declaration//GEN-END:variables
}
