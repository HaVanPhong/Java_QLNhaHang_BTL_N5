/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.View;

import java.util.ArrayList;
import java.util.Observer;
import java.util.regex.Pattern;
import java.util.List;
import javafx.collections.ObservableList;
import javax.swing.table.DefaultTableModel;
import qlnhahang_btln5.Controller.AccountController;
import qlnhahang_btln5.Controller.BillController;
import qlnhahang_btln5.Controller.CustomerController;
import qlnhahang_btln5.Controller.MaterialController;
import qlnhahang_btln5.Controller.EmployeeController;
import qlnhahang_btln5.Controller.EquipmentController;
import qlnhahang_btln5.Controller.ExpenseController;
import qlnhahang_btln5.Controller.MaterialController;
import qlnhahang_btln5.Controller.TableController;
import qlnhahang_btln5.Models.Account;
import qlnhahang_btln5.Models.Bill;
import qlnhahang_btln5.Models.Material;
import qlnhahang_btln5.Models.Equipment;
import qlnhahang_btln5.Models.ExpenseDetail;
import qlnhahang_btln5.Models.Customer;
import qlnhahang_btln5.Models.Employee;
import qlnhahang_btln5.Models.Tables;

/**
 *
 * @author duong
 */
public class CreateExpense extends javax.swing.JFrame {
    DefaultTableModel modelMaterial = null;   
    DefaultTableModel modelEquipment = null;
    DefaultTableModel modelDetail = null;

    String [] titleMaterial = { "STT","Mã NL","Tên NL", "Số lượng" };
    String [] titleEquipment = { "STT","Mã TTB","Tên TTB","Số lượng" };

    String [] titleDetail = {"STT","Mã hàng", "Loại hàng","Tên hàng", "Số lượng", "Đơn giá", "Thành tiền" };
    double total = 0;

    static List<Material> listMaterial = new ArrayList<>();
    static List<Equipment> listEquipment = new ArrayList<>();
    static List<ExpenseDetail> listDetail = new ArrayList<>();
    static List<Employee> listEmployee = new ArrayList<>();
    static Account acc = null;

    class ComboItem
    {
        private String key;
        private int value;

        public ComboItem(String key, int value)
        {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString()
        {
            return key;
        }

        public String getKey()
        {
            return key;
        }

        public int getValue()
        {
            return value;
        }
    }

    /**
     * Creates new form ManagerBill
     */
    public CreateExpense() {
        initComponents();
        modelMaterial =  (DefaultTableModel) tbMaterial.getModel();
        modelEquipment = (DefaultTableModel) tbEquipment.getModel();        
        modelDetail =  (DefaultTableModel) tbDetail.getModel();

        modelMaterial.setColumnIdentifiers(titleMaterial);
        modelEquipment.setColumnIdentifiers(titleEquipment);
        modelDetail.setColumnIdentifiers(titleDetail);

        listEmployee = EmployeeController.GetAllEmployee();

        cbbEmployee.removeAllItems();
        cbbEmployee.addItem(new ComboItem("Không xác định", -1));
        for(Employee employee : listEmployee) {
            cbbEmployee.addItem(new ComboItem(employee.getFullname(), employee.getIdEmp()));
        }
        
        showTableMaterial();
        showTableEquipment();
    }
    public CreateExpense(int idUser) {
        initComponents();
        this.setLocationRelativeTo(null);
        acc = AccountController.getAccountByIdUser(idUser);
        modelMaterial =  (DefaultTableModel) tbMaterial.getModel();
        modelEquipment = (DefaultTableModel) tbEquipment.getModel();        
        modelDetail =  (DefaultTableModel) tbDetail.getModel();

        modelMaterial.setColumnIdentifiers(titleMaterial);
        modelEquipment.setColumnIdentifiers(titleEquipment);
        modelDetail.setColumnIdentifiers(titleDetail);

        listEmployee = EmployeeController.GetAllEmployee();

        cbbEmployee.removeAllItems();
        cbbEmployee.addItem(new ComboItem("Không xác định", -1));
        for(Employee employee : listEmployee) {
            cbbEmployee.addItem(new ComboItem(employee.getFullname(), employee.getIdEmp()));
        }
        
        showTableMaterial();
        showTableEquipment();
    }
    public void  showTableMaterial(){
        modelMaterial.setRowCount(0);
        listMaterial = MaterialController.readAllRecord();

        int stt =1;
        for (Material material : listMaterial) {
            modelMaterial.addRow(new Object[]{
                stt++,material.getIdMat(), material.getName(), material.getQuantity()
            });
        }
    }
    
     public void  showTableEquipment(){
        listEquipment = EquipmentController.readAllRecord();

        modelEquipment.setRowCount(0);
        int stt =1;
        for (Equipment equipment : listEquipment) {
            modelEquipment.addRow(new Object[]{
                stt++,equipment.getIdEquip(), equipment.getName(), equipment.getQuantity()
            });
        }
    }
    
    public void  showTableDetail(){
        modelDetail.setRowCount(0);
        int stt =1;
        double total = 0;
        for (ExpenseDetail detail : listDetail) {
            
            double money = detail.getPrice()* detail.getQuantity();
            String category = detail.getType().equalsIgnoreCase("Material") ? "Nguyên vật liệu" : "Trang thiết bị";
            total += money;
            modelDetail.addRow(new Object[]{
                stt++,detail.getIdType(), category, detail.getGoodsName(), detail.getQuantity(), detail.getPrice(), money
            });
        }
        
        txtTotal.setText(total + "");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnComeback = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMaterial = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaterialName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaterialPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAddMaterial = new javax.swing.JButton();
        btnMaterialUpdate = new javax.swing.JButton();
        errMaterial = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMaterialQty = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        cbbEmployee = new javax.swing.JComboBox();
        btnExpenseAdd = new javax.swing.JButton();
        btnExpenseRefresh = new javax.swing.JButton();
        txtEquipmentPrice = new javax.swing.JTextField();
        btnEquipmentAdd = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnEquipmentUpdate = new javax.swing.JButton();
        txtEquipmentQty = new javax.swing.JSpinner();
        txtEquipmentName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbEquipment = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        errEquipment = new javax.swing.JLabel();
        errExpense = new javax.swing.JLabel();
        msgExpense = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tạo biên lai");

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnComeback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Exit.png"))); // NOI18N
        btnComeback.setText("Quay lại");
        btnComeback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComebackActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(46, 204, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TẠO BIÊN LAI");

        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 350));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 350));

        tbMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMaterial);

        tbDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbDetail);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nguyên vật liệu");

        jLabel3.setText("Tên hàng");

        txtMaterialName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaterialName.setEnabled(false);

        jLabel5.setText("Đơn giá");

        txtMaterialPrice.setDisabledTextColor(new java.awt.Color(20, 20, 20));
        txtMaterialPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaterialPriceActionPerformed(evt);
            }
        });

        jLabel6.setText("Số lượng");

        btnAddMaterial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Create.png"))); // NOI18N
        btnAddMaterial.setText("Thêm");
        btnAddMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMaterialMouseClicked(evt);
            }
        });
        btnAddMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMaterialActionPerformed(evt);
            }
        });

        btnMaterialUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMaterialUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Edit.png"))); // NOI18N
        btnMaterialUpdate.setText("Sửa");
        btnMaterialUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaterialUpdateMouseClicked(evt);
            }
        });
        btnMaterialUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialUpdateActionPerformed(evt);
            }
        });

        errMaterial.setForeground(new java.awt.Color(255, 0, 0));
        errMaterial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setText("Tổng tiền");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("VND");

        txtTotal.setDisabledTextColor(new java.awt.Color(20, 20, 20));
        txtTotal.setEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${total}"), txtTotal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("VND");

        txtMaterialQty.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtMaterialQty.setPreferredSize(new java.awt.Dimension(0, 200));
        txtMaterialQty.setValue(1);
        txtMaterialQty.setVerifyInputWhenFocusTarget(false);
        txtMaterialQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtMaterialQtyStateChanged(evt);
            }
        });

        jLabel15.setText("Nhân viên");

        cbbEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnExpenseAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExpenseAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Create.png"))); // NOI18N
        btnExpenseAdd.setText("Tạo biên lai");
        btnExpenseAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExpenseAddMouseClicked(evt);
            }
        });
        btnExpenseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpenseAddActionPerformed(evt);
            }
        });

        btnExpenseRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExpenseRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Refresh.png"))); // NOI18N
        btnExpenseRefresh.setText("Làm mới");
        btnExpenseRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExpenseRefreshMouseClicked(evt);
            }
        });
        btnExpenseRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpenseRefreshActionPerformed(evt);
            }
        });

        txtEquipmentPrice.setDisabledTextColor(new java.awt.Color(20, 20, 20));
        txtEquipmentPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentPriceActionPerformed(evt);
            }
        });

        btnEquipmentAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEquipmentAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Create.png"))); // NOI18N
        btnEquipmentAdd.setText("Thêm");
        btnEquipmentAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEquipmentAddMouseClicked(evt);
            }
        });
        btnEquipmentAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipmentAddActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("VND");

        jLabel18.setText("Tên hàng");

        jLabel19.setText("Đơn giá");

        btnEquipmentUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEquipmentUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Edit.png"))); // NOI18N
        btnEquipmentUpdate.setText("Sửa");
        btnEquipmentUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEquipmentUpdateMouseClicked(evt);
            }
        });
        btnEquipmentUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipmentUpdateActionPerformed(evt);
            }
        });

        txtEquipmentQty.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtEquipmentQty.setPreferredSize(new java.awt.Dimension(0, 200));
        txtEquipmentQty.setValue(1);
        txtEquipmentQty.setVerifyInputWhenFocusTarget(false);
        txtEquipmentQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtEquipmentQtyStateChanged(evt);
            }
        });

        txtEquipmentName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEquipmentName.setEnabled(false);

        jLabel20.setText("Số lượng");

        jScrollPane3.setMaximumSize(new java.awt.Dimension(500, 350));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(500, 350));

        tbEquipment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEquipmentMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbEquipment);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Trang thiết bị");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Danh sách nhập hàng");

        errEquipment.setForeground(new java.awt.Color(255, 0, 0));
        errEquipment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errExpense.setForeground(new java.awt.Color(204, 0, 0));
        errExpense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        msgExpense.setForeground(new java.awt.Color(0, 204, 51));
        msgExpense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(19, 19, 19)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMaterialQty, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtMaterialPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel9))
                                .addComponent(txtMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMaterialUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(errMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnAddMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEquipmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(txtEquipmentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEquipmentQty, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnEquipmentAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEquipmentUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnExpenseAdd)
                        .addGap(77, 77, 77)
                        .addComponent(btnExpenseRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errExpense, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(msgExpense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnComeback, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1)
                        .addGap(228, 228, 228)
                        .addComponent(jLabel21)
                        .addGap(362, 362, 362)
                        .addComponent(jLabel22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(527, 527, 527)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnComeback, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMaterialPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtMaterialQty, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAddMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMaterialUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtEquipmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(jLabel19)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel20)
                                .addGap(15, 15, 15)
                                .addComponent(errEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEquipmentAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEquipmentUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEquipmentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(txtEquipmentQty, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(cbbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(errExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(msgExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnExpenseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExpenseRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(577, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(867, 867, 867))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEquipmentMouseClicked
        // TODO add your handling code here:
        int row = tbEquipment.getSelectedRow();

        txtEquipmentName.setText(tbEquipment.getValueAt(row, 2).toString());
        txtEquipmentPrice.setText("0");
        txtEquipmentQty.setValue(1);
    }//GEN-LAST:event_tbEquipmentMouseClicked

    private void txtEquipmentQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtEquipmentQtyStateChanged
        // TODO add your handling code here:
        int quantity = (int) txtEquipmentQty.getValue();

        if(quantity < 0) {
            quantity = 0;
            txtMaterialQty.setValue(quantity);
        }
    }//GEN-LAST:event_txtEquipmentQtyStateChanged

    private void btnEquipmentUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipmentUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEquipmentUpdateActionPerformed

    private void btnEquipmentUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEquipmentUpdateMouseClicked
        // TODO add your handling code here:
         int rowEquipment = tbEquipment.getSelectedRow();
        errEquipment.setText("");

        if(rowEquipment < 0) {
            errEquipment.setText("Bạn chưa chọn món ăn");
            return;
        }
        
        int quantity = (int) txtEquipmentQty.getValue();
        
        Pattern patternPrice = Pattern.compile("^[0-9]+$");
        
        if(!patternPrice.matcher(txtEquipmentPrice.getText()).find()) {
            errEquipment.setText("Giá phải là số nguyên dương.");
            return;
        }
        
        int price = Integer.parseInt(txtEquipmentPrice.getText());

        if(quantity < 0) {
            errEquipment.setText("Số lượng phải lớn hơn hoặc bằng 0");
            return;
        }

        Equipment equipment = EquipmentController.getEquipment((int) tbEquipment.getValueAt(rowEquipment, 1));
        if(equipment == null) {
            errEquipment.setText("Trang thiết bị này không tồn tại");
            showTableEquipment();
            return;
        }
        
        ExpenseDetail oldDetail = null;
        int index = -1;
        for(int i = 0; i < listDetail.size(); i++) {
            if(listDetail.get(i).getIdType() == equipment.getIdEquip() && listDetail.get(i).getType().equalsIgnoreCase("Equipment")) {
                index = i;
                oldDetail = listDetail.get(i);
                break;
            }
        }

        if(oldDetail  != null) {
            if(quantity == 0) {
                listDetail.remove(index);
                showTableDetail();

            } else {
                oldDetail.setQuantity(quantity);
                oldDetail.setPrice(price);
                listDetail.set(index, oldDetail);
                showTableDetail();
                return;
            }

        } else {
            errEquipment.setText("Trang thiết bị này chưa có trong biên lai.");
        }
    }//GEN-LAST:event_btnEquipmentUpdateMouseClicked

    private void btnEquipmentAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipmentAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEquipmentAddActionPerformed

    private void btnEquipmentAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEquipmentAddMouseClicked
        // TODO add your handling code here:
         int rowEquipment = tbEquipment.getSelectedRow();
        errEquipment.setText("");

        if(rowEquipment < 0) {
            errEquipment.setText("Bạn chưa chọn món ăn");
            return;
        }
        
        int quantity = (int) txtEquipmentQty.getValue();
        
        Pattern patternPrice = Pattern.compile("^[0-9]+$");
        
        if(!patternPrice.matcher(txtEquipmentPrice.getText()).find()) {
            errEquipment.setText("Giá phải là số nguyên dương.");
            return;
        }
        
        int price = Integer.parseInt(txtEquipmentPrice.getText());

        if(quantity <= 0) {
            errEquipment.setText("Số lượng phải lớn hơn hoặc bằng 0");
            return;
        }

        Equipment equipment = EquipmentController.getEquipment((int) tbEquipment.getValueAt(rowEquipment, 1));
        if(equipment == null) {
            errEquipment.setText("Trang thiết bị này không tồn tại");
            showTableEquipment();
            return;
        }
        
        ExpenseDetail oldDetail = null;
        int index = -1;
        for(int i = 0; i < listDetail.size(); i++) {
            if(listDetail.get(i).getIdType() == equipment.getIdEquip() && listDetail.get(i).getType().equalsIgnoreCase("Equipment")) {
                index = i;
                oldDetail = listDetail.get(i);
                break;
            }
        }

        if(oldDetail  != null) {
            oldDetail.setQuantity(quantity + oldDetail.getQuantity());
            oldDetail.setPrice(price);
            listDetail.set(index, oldDetail);
            showTableDetail();
            return;
        }

        ExpenseDetail detail = new ExpenseDetail();
        detail.setIdType(equipment.getIdEquip());
        detail.setQuantity(quantity);
        detail.setType("Equipment");
        detail.setPrice(price);
        detail.setGoodsName(equipment.getName());
        listDetail.add(detail);
        showTableDetail();
    }//GEN-LAST:event_btnEquipmentAddMouseClicked

    private void txtEquipmentPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentPriceActionPerformed

    private void btnExpenseRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpenseRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExpenseRefreshActionPerformed

    private void btnExpenseRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpenseRefreshMouseClicked
        // TODO add your handling code here:
        txtMaterialName.setText(null);
        txtMaterialPrice.setText(null);
        txtMaterialQty.setValue(1);
        txtEquipmentName.setText(null);
        txtEquipmentPrice.setText(null);
        txtEquipmentQty.setValue(1);
        errMaterial.setText(null);        
        errEquipment.setText(null);
        listDetail.clear();
        showTableDetail();
        cbbEmployee.setSelectedIndex(0);
        errExpense.setText(null);
        msgExpense.setText(null);
    }//GEN-LAST:event_btnExpenseRefreshMouseClicked

    private void btnExpenseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpenseAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExpenseAddActionPerformed

    private void btnExpenseAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpenseAddMouseClicked
        // TODO add your handling code here:
        errExpense.setText(null);
        msgExpense.setText(null);

        if(listDetail.size() < 1) {
            errExpense.setText("Chưa có món hàng nào trong biên lai.");
            return;
        }
        
        ComboItem itemEmployee = (ComboItem)cbbEmployee.getSelectedItem();

        double total = 0;
        for(ExpenseDetail detail : listDetail) {
            total += detail.getPrice() * detail.getQuantity();
        }
        if(ExpenseController.createExpense(itemEmployee.getValue(),listDetail)) {
            btnExpenseRefreshMouseClicked(evt);
            msgExpense.setText("Tạo biên lai thành công.");
            showTableEquipment();
            showTableMaterial();
        } else {
            errExpense.setText("Tạo biên lai thất bại.");
        }
    }//GEN-LAST:event_btnExpenseAddMouseClicked

    private void txtMaterialQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtMaterialQtyStateChanged
        // TODO add your handling code here:
        int quantity = (int) txtMaterialQty.getValue();

        if(quantity < 0) {
            quantity = 0;
            txtMaterialQty.setValue(quantity);
        }
    }//GEN-LAST:event_txtMaterialQtyStateChanged

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnMaterialUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialUpdateActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnMaterialUpdateActionPerformed

    private void btnMaterialUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaterialUpdateMouseClicked
        // TODO add your handling code here:
        int rowMaterial = tbMaterial.getSelectedRow();
        errMaterial.setText("");

        if(rowMaterial < 0) {
            errMaterial.setText("Bạn chưa chọn món ăn");
            return;
        }
        int quantity = (int) txtMaterialQty.getValue();
        Pattern patternPrice = Pattern.compile("^[0-9]+$");
        
        if(!patternPrice.matcher(txtMaterialPrice.getText()).find()) {
            errMaterial.setText("Giá phải là số nguyên dương.");
            return;
        }
        
        int price = Integer.parseInt(txtMaterialPrice.getText());

        if(quantity < 0) {
            errMaterial.setText("Số lượng phải lớn hơn hoặc bằng 0");
            return;
        }

        Material material = MaterialController.getMaterial((int) tbMaterial.getValueAt(rowMaterial, 1));
        if(material == null) {
            errMaterial.setText("Nguyên liệu này không tồn tại.");
            showTableMaterial();
            return;
        }

        ExpenseDetail oldDetail = null;
        int index = -1;
        for(int i = 0; i < listDetail.size(); i++) {
            if(listDetail.get(i).getIdType() == material.getIdMat() && listDetail.get(i).getType().equalsIgnoreCase("Material")) {
                index = i;
                oldDetail = listDetail.get(i);
                break;
            }
        }

        if(oldDetail  != null) {
            if(quantity == 0) {
                listDetail.remove(index);
                showTableDetail();

            } else {
                oldDetail.setQuantity(quantity);
                oldDetail.setPrice(price);
                listDetail.set(index, oldDetail);
                showTableDetail();
                return;
            }

        } else {
            errMaterial.setText("Nguyên liệu này chưa có trong biên lai.");
        }
    }//GEN-LAST:event_btnMaterialUpdateMouseClicked

    private void btnAddMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMaterialActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAddMaterialActionPerformed

    private void btnAddMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMaterialMouseClicked
        // TODO add your handling code here:
       int rowMaterial = tbMaterial.getSelectedRow();
        errMaterial.setText("");

        if(rowMaterial < 0) {
            errMaterial.setText("Bạn chưa chọn nguyên liệu nào.");
            return;
        }
        
        int quantity = (int) txtMaterialQty.getValue();
        
        Pattern patternPrice = Pattern.compile("^[0-9]+$");
        
        if(!patternPrice.matcher(txtMaterialPrice.getText()).find()) {
            errMaterial.setText("Giá phải là số nguyên dương.");
            return;
        }
        
        int price = Integer.parseInt(txtMaterialPrice.getText());

        if(quantity <= 0) {
            errMaterial.setText("Số lượng phải lớn hơn hoặc bằng 0");
            return;
        }

        Material material = MaterialController.getMaterial((int) tbMaterial.getValueAt(rowMaterial, 1));
        if(material == null) {
            errMaterial.setText("Nguyên liệu này không tồn tại");
            showTableMaterial();
            return;
        }
        
        ExpenseDetail oldDetail = null;
        int index = -1;
        for(int i = 0; i < listDetail.size(); i++) {
            if(listDetail.get(i).getIdType() == material.getIdMat() && listDetail.get(i).getType().equalsIgnoreCase("Material")) {
                index = i;
                oldDetail = listDetail.get(i);
                break;
            }
        }

        if(oldDetail  != null) {
            oldDetail.setQuantity(quantity + oldDetail.getQuantity());
            oldDetail.setPrice(price);
            listDetail.set(index, oldDetail);
            showTableDetail();
            return;
        }

        ExpenseDetail detail = new ExpenseDetail();
        detail.setIdType(material.getIdMat());
        detail.setQuantity(quantity);
        detail.setType("Material");
        detail.setPrice(price);
        detail.setGoodsName(material.getName());
        listDetail.add(detail);
        showTableDetail();
    }//GEN-LAST:event_btnAddMaterialMouseClicked

    private void txtMaterialPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaterialPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaterialPriceActionPerformed

    private void tbMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMaterialMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int row = tbMaterial.getSelectedRow();

        txtMaterialName.setText(tbMaterial.getValueAt(row, 2).toString());
        txtMaterialPrice.setText("0");
        txtMaterialQty.setValue(1);
    }//GEN-LAST:event_tbMaterialMouseClicked

    private void btnComebackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComebackActionPerformed
        ManagerExpense managerExpense = new ManagerExpense(acc.getIdUser());
        this.dispose();
        managerExpense.setVisible(true);
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
            java.util.logging.Logger.getLogger(CreateExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateExpense().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMaterial;
    private javax.swing.JButton btnComeback;
    private javax.swing.JButton btnEquipmentAdd;
    private javax.swing.JButton btnEquipmentUpdate;
    private javax.swing.JButton btnExpenseAdd;
    private javax.swing.JButton btnExpenseRefresh;
    private javax.swing.JButton btnMaterialUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbbEmployee;
    private javax.swing.JLabel errEquipment;
    private javax.swing.JLabel errExpense;
    private javax.swing.JLabel errMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel msgExpense;
    private javax.swing.JTable tbDetail;
    private javax.swing.JTable tbEquipment;
    private javax.swing.JTable tbMaterial;
    private javax.swing.JTextField txtEquipmentName;
    private javax.swing.JTextField txtEquipmentPrice;
    private javax.swing.JSpinner txtEquipmentQty;
    private javax.swing.JTextField txtMaterialName;
    private javax.swing.JTextField txtMaterialPrice;
    private javax.swing.JSpinner txtMaterialQty;
    private javax.swing.JTextField txtTotal;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
