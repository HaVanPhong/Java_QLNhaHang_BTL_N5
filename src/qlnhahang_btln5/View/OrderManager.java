/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.View;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlnhahang_btln5.Controller.AccountController;
import qlnhahang_btln5.Controller.BillController;
import qlnhahang_btln5.Controller.CustomerController;
import qlnhahang_btln5.Controller.DishController;
import qlnhahang_btln5.Controller.TableController;
import qlnhahang_btln5.Models.Account;
import qlnhahang_btln5.Models.BillDetail;
import qlnhahang_btln5.Models.Customer;
import qlnhahang_btln5.Models.DTO.DishOrder;
import qlnhahang_btln5.Models.DTO.Ordering;
import qlnhahang_btln5.Models.Dish;
import qlnhahang_btln5.Models.Tables;

/**
 *
 * @author HaPhong
 */
public class OrderManager extends javax.swing.JFrame {

    /**
     * Creates new form OrderManager
     */
    List<Dish> dishs;
    List<Tables> tables;
    DefaultTableModel modelThucDon=null;
    DefaultTableModel modelMonDaGoi= null;
    public static List<Ordering> listOrderingOfTable= new ArrayList<>();
    static Account acc = null;

    public static List<Ordering> getListOrderingOfTable() {
        return listOrderingOfTable;
    }

    public static void setListOrderingOfTable(List<Ordering> listOrderingOfTable) {
        OrderManager.listOrderingOfTable = listOrderingOfTable;
    }
    
    
    
    public static int currentTableNumber=1;
    public OrderManager(int idUser) {
        initComponents();
        this.setLocationRelativeTo(null);
        acc = AccountController.getAccountByIdUser(idUser);
        edtIdDish.setVisible(false);
        listTable.setLayoutOrientation(JList.VERTICAL_WRAP);
        listTable.setVisibleRowCount(3);
        
        modelThucDon= (DefaultTableModel) tbThucDon.getModel();
        modelMonDaGoi= (DefaultTableModel) tbMonDaGoi.getModel();
        
        try {
            tables= TableController.readAllTables();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Kh??ng l???y ???????c d??? li???u b??n ??n", "L???i truy v???n d??? li???u", JOptionPane.ERROR_MESSAGE);
        }
        dishs= DishController.index();
        
        for (Dish dish: dishs){
            modelThucDon.addRow(new Object[]{
                dish.getIdDish(), dish.getName(), dish.getPrice()
            });
        }
        for (Tables tb: tables){
            listTable.addTable(tb);
            listOrderingOfTable.add(new Ordering(tb.getTbNumber()));
        }       
        
        listTable.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    JList source= (JList) e.getSource();
                    lbCurrentTable.setText("B??n s???: "+ source.getSelectedValue().toString());
                    lbDaGoi.setText(""+ source.getSelectedValue().toString());
                    currentTableNumber= Integer.parseInt(source.getSelectedValue().toString());
                    
                    //render c??c m??n ??ang g???i
                    renderAllDishHadOrderOfTable();
                }
            }

            private void renderAllDishHadOrderOfTable() {
                modelMonDaGoi.setRowCount(0);
                double tongTien=0;
                for (int index=0; index<listOrderingOfTable.size(); index++){
                    if(listOrderingOfTable.get(index).getTbNumber()==currentTableNumber){
                        Ordering ordering= listOrderingOfTable.get(index);
                        for (int i=0; i<ordering.getDishOrders().size(); i++){
                            modelMonDaGoi.addRow(new Object[]{
                                ordering.getDishOrders().get(i).getName(),
                                ordering.getDishOrders().get(i).getPrice(),
                                ordering.getDishOrders().get(i).getQuantity(),
                                ordering.getDishOrders().get(i).getMoney()
                            });
                            tongTien+= ordering.getDishOrders().get(i).getMoney();
                        }
                    }
                }
                edtTongTien.setText(tongTien+"");
                if (tongTien==0){
                    lbCurrentStt.setText("Ch??a c?? kh??ch");
                }else {
                    lbCurrentStt.setText("??ang ph???c v???");
                }
            }
        });
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbCurrentTable = new javax.swing.JLabel();
        lbCurrentStt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTable = new qlnhahang_btln5.View.ListTable<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbThucDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edtTenMon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edtGiaBan = new javax.swing.JTextField();
        btnGoiMon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMonDaGoi = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        edtTongTien = new javax.swing.JTextField();
        edtSDTKhach = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lbDaGoi = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        jLab = new javax.swing.JLabel();
        edtIdDish = new javax.swing.JTextField();
        btnComeback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("G???i m??n");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Danh s??ch b??n");

        lbCurrentTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCurrentTable.setForeground(new java.awt.Color(0, 153, 255));
        lbCurrentTable.setText("B??n s??? 1");

        lbCurrentStt.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbCurrentStt.setForeground(new java.awt.Color(0, 153, 51));
        lbCurrentStt.setText("Ch??a c?? kh??ch");

        listTable.setForeground(new java.awt.Color(255, 255, 255));
        listTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listTable);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Ch??a c?? kh??ch");

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("??ang ph???c v???");

        tbThucDon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbThucDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "T??n m??n ??n", "Gi?? b??n"
            }
        ));
        tbThucDon.setRowHeight(24);
        tbThucDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThucDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbThucDon);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Th???c ????n");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("T??n m??n");

        edtTenMon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Gi?? b??n");

        edtGiaBan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnGoiMon.setBackground(new java.awt.Color(204, 255, 102));
        btnGoiMon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGoiMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Add.png"))); // NOI18N
        btnGoiMon.setText("G???i m??n");
        btnGoiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoiMonActionPerformed(evt);
            }
        });

        tbMonDaGoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbMonDaGoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "T??n m??n", "Gi??", "S??? l?????ng", "Th??nh ti???n"
            }
        ));
        tbMonDaGoi.setRowHeight(24);
        jScrollPane3.setViewportView(tbMonDaGoi);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("T???ng ti???n (VN??)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setText("M?? gi???m gi?? (S??T TV)");

        edtTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edtTongTien.setText("0.0");

        edtSDTKhach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnThanhToan.setBackground(new java.awt.Color(204, 255, 102));
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThanhToan.setText("Thanh To??n");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("S??? l?????ng");

        lbDaGoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDaGoi.setText("1");

        spnSoLuong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLab.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLab.setText("C??c m??n ???? g???i b??n: ");

        edtIdDish.setEditable(false);
        edtIdDish.setForeground(new java.awt.Color(255, 255, 255));

        btnComeback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Exit.png"))); // NOI18N
        btnComeback.setText("Quay l???i");
        btnComeback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComebackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(edtTenMon))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(edtGiaBan)
                                            .addComponent(spnSoLuong)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(137, 137, 137)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(380, 380, 380)
                                .addComponent(btnGoiMon))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbCurrentTable)
                                .addGap(60, 60, 60)
                                .addComponent(lbCurrentStt))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(249, 249, 249)
                                        .addComponent(edtIdDish, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(292, 292, 292)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtSDTKhach)
                                    .addComponent(edtTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnThanhToan)
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbDaGoi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(280, 280, 280))))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnComeback, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnComeback, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCurrentTable)
                    .addComponent(lbCurrentStt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lbDaGoi)
                    .addComponent(jLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(edtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(edtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(edtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(edtSDTKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGoiMon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(edtIdDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableMouseClicked

    }//GEN-LAST:event_listTableMouseClicked

    private void btnGoiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoiMonActionPerformed
        try {
            int row = tbThucDon.getSelectedRow();
            if (row<0){
                throw new Exception("B???n ch??a ch???n m??n n??o");
            }
            String tenMon= edtTenMon.getText().trim();
            double gia= Double.parseDouble(edtGiaBan.getText().trim());
            int soLuong= Integer.parseInt(spnSoLuong.getValue().toString());
            int idDish= Integer.parseInt(edtIdDish.getText().trim());
            DishOrder dishOrder= new DishOrder(soLuong, idDish, tenMon, gia);
            
            for (int index=0; index<listOrderingOfTable.size(); index++){
                if(listOrderingOfTable.get(index).getTbNumber()==currentTableNumber){
                    int vt= listOrderingOfTable.get(index).getDishOrders().indexOf(dishOrder);
                    if (vt!=-1){
                        int slBanDau= listOrderingOfTable.get(index).getDishOrders().get(vt).getQuantity();
                        listOrderingOfTable.get(index).getDishOrders().get(vt).setQuantity(soLuong+ slBanDau);
                        modelMonDaGoi.setValueAt(slBanDau+ soLuong, vt, 2);
                    }else {
                        listOrderingOfTable.get(index).getDishOrders().add(dishOrder);
                        modelMonDaGoi.addRow(new Object[]{
                            dishOrder.getName(), dishOrder.getPrice(), dishOrder.getQuantity(), dishOrder.getMoney()
                        });
                    }
                }
            }


            
            edtTongTien.setText(Double.parseDouble(edtTongTien.getText().trim())+ dishOrder.getMoney()+"");
            lbCurrentStt.setText("??ang ph???c v???");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "L???i thao t??c", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGoiMonActionPerformed

    private void tbThucDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThucDonMouseClicked
        int row = tbThucDon.getSelectedRow();
        edtIdDish.setText(modelThucDon.getValueAt(row, 0).toString());
        edtTenMon.setText(modelThucDon.getValueAt(row, 1).toString());
        edtGiaBan.setText(modelThucDon.getValueAt(row, 2).toString());
        spnSoLuong.setValue(1);
    }//GEN-LAST:event_tbThucDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try {
            double tongTien= Double.parseDouble(edtTongTien.getText().trim());
            if (tongTien==0){
                throw new Exception("Ch??a g???i m??n");
            }
            String sdt= edtSDTKhach.getText().trim();
            
            Customer customer= new Customer(1); //customer 1 id anonymous
            if (!sdt.equals("")){
                Customer customer1= CustomerController.getCustomerByPhone(sdt);
                if (customer1!=null){
                    customer= customer1;
                    tongTien= tongTien - tongTien*20/100;
                }else {
                    throw new Exception("M?? gi???m gi?? kh??ng t???n t???i");
                }
            }
            Tables table= new Tables();
            for (Tables tb: tables){
                if (tb.getTbNumber()== currentTableNumber){
                    table= tb;
                }
            }
            int index=0;
            List<BillDetail> listBillDetail= new ArrayList<>();
            for (int i=0; i<listOrderingOfTable.size() ; i++){
                if (listOrderingOfTable.get(i).getTbNumber()== currentTableNumber){
                   index= i;
                   for (DishOrder or: listOrderingOfTable.get(i).getDishOrders()){
                       System.out.println("idDish: "+ or.getIdDish());
                       listBillDetail.add(new BillDetail(0, or.getIdDish(), or.getQuantity()));
                   }
                   break;
                }
            }
            
            int confirm = JOptionPane.showConfirmDialog(null, "X??c nh???n thanh to??n "+ tongTien +"VN??", "X??c nh???n thanh to??n", JOptionPane.YES_NO_OPTION);
            if (confirm==0){//yes
                BillController.createBill(customer.getIdCus(), Login.idCurrentEmployee, table.getIdTB(), tongTien, listBillDetail);
                listOrderingOfTable.get(index).setDishOrders(new ArrayList<>());
                modelMonDaGoi.setNumRows(0);
                edtTongTien.setText("0.0");
                edtSDTKhach.setText("");
            }           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "L???i thao t??c", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnComebackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComebackActionPerformed
        Home h = new Home(acc.getIdUser());
        this.dispose();
        h.setVisible(true);
    }//GEN-LAST:event_btnComebackActionPerformed

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
            java.util.logging.Logger.getLogger(OrderManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new OrderManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComeback;
    private javax.swing.JButton btnGoiMon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JTextField edtGiaBan;
    private javax.swing.JTextField edtIdDish;
    private javax.swing.JTextField edtSDTKhach;
    private javax.swing.JTextField edtTenMon;
    private javax.swing.JTextField edtTongTien;
    private javax.swing.JLabel jLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCurrentStt;
    private javax.swing.JLabel lbCurrentTable;
    private javax.swing.JLabel lbDaGoi;
    private qlnhahang_btln5.View.ListTable<String> listTable;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTable tbMonDaGoi;
    private javax.swing.JTable tbThucDon;
    // End of variables declaration//GEN-END:variables
}
