/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javax.swing.table.DefaultTableModel;
import qlnhahang_btln5.Controller.BillController;
import qlnhahang_btln5.Controller.CustomerController;
import qlnhahang_btln5.Controller.DetailController;
import qlnhahang_btln5.Controller.DishController;
import qlnhahang_btln5.Controller.EmployeeController;
import qlnhahang_btln5.Controller.TableController;
import qlnhahang_btln5.Models.Bill;
import qlnhahang_btln5.Models.Dish;
import qlnhahang_btln5.Models.BillDetail;
import qlnhahang_btln5.Models.Customer;
import qlnhahang_btln5.Models.Employee;
import qlnhahang_btln5.Models.Tables;

/**
 *
 * @author duong
 */
public class UpdateBill extends javax.swing.JFrame {
    DefaultTableModel modelDish = null;   
    DefaultTableModel modelDetail = null;
    String [] titleDish = { "STT","Mã món","Tên món","Đơn giá" };
    String [] titleDetail = {"STT","Mã món", "Tên món","Đơn giá", "Số lượng", "Thành tiền" };
    double total = 0;

    static List<Dish> listDish = new ArrayList<>();
    static List<BillDetail> listDetail = new ArrayList<>();
    static List<Customer> listCustomer = new ArrayList<>();
    static List<Employee> listEmployee = new ArrayList<>();
    static List<Tables> listTable = new ArrayList<>();
    static Bill bill = null;

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

        @Override
        public boolean equals(Object obj) {
            ComboItem cb = (ComboItem) obj;
            return this.value == cb.getValue();
        }
    }

    /**
     * Creates new form ManagerBill
     */
    public UpdateBill() {
        initComponents();
        
        modelDish =  (DefaultTableModel) tbDish.getModel();        
        modelDetail =  (DefaultTableModel) tbDetail.getModel();

        modelDish.setColumnIdentifiers(titleDish);        
        modelDetail.setColumnIdentifiers(titleDetail);

        listDish = DishController.index();
        listDetail = bill.getBillDetails();
        
        Customer customer = bill.getCustomer();
        Employee employee = bill.getEmployee();
        Tables table = bill.getTable();
        
        ComboItem itemCus = customer == null ? new ComboItem(null, -1) : new ComboItem(customer.getFullname(), customer.getIdCus());
        ComboItem itemEmp = employee == null ? new ComboItem(null, -1) : new ComboItem(employee.getFullname(), employee.getIdEmp());
        ComboItem itemTb = table == null ? new ComboItem(null, -1) : new ComboItem(table.getTbName(), table.getIdTB());

        listCustomer = CustomerController.getAllCustomer();
        listEmployee = EmployeeController.GetAllEmployee();
        listTable = TableController.readAllTables();

        cbbCustomer.removeAllItems();
        cbbCustomer.addItem(new ComboItem("Không xác định", -1));
        for(Customer cus : listCustomer) {
            cbbCustomer.addItem(new ComboItem(cus.getFullname(), cus.getIdCus()));
        }
        cbbCustomer.setSelectedItem(itemCus);
        
        cbbEmployee.removeAllItems();
        cbbEmployee.addItem(new ComboItem("Không xác định", -1));
        for(Employee emp : listEmployee) {
            cbbEmployee.addItem(new ComboItem(emp.getFullname(), emp.getIdEmp()));
        }
        cbbEmployee.setSelectedItem(itemEmp);

        
        cbbTable.removeAllItems();
        cbbTable.addItem(new ComboItem("Không xác định", -1));
        for(Tables tb : listTable) {
            cbbTable.addItem(new ComboItem(tb.getTbName(), tb.getIdTB()));
        }
        cbbTable.setSelectedItem(itemTb);
        double total = 0;
        for(BillDetail detail : listDetail) {
            total += detail.getDish().getPrice() * detail.getQuantity();
        }
        
        int discount = 100 - (int) (bill.getTotal() *100/total);
        txtDiscount.setValue(discount);
        
        showTableDish();
        showTableDetail();
    }
    public void  showTableDish(){
        modelDish.setRowCount(0);
        int stt =1;
        for (Dish dish : listDish) {
            modelDish.addRow(new Object[]{
                stt++,dish.getIdDish(), dish.getName(), dish.getPrice()
            });
        }
    }
    
    public void  showTableDetail(){
        modelDetail.setRowCount(0);
        int stt =1;
        double total = 0;
        for (BillDetail detail : listDetail) {
            Dish dish = detail.getDish();
            String dishName = dish == null ? "" : dish.getName() ;
            double dishPrice = dish == null ? 0 : dish.getPrice();
            double money = dishPrice * detail.getQuantity();
            total += money;
            modelDetail.addRow(new Object[]{
                stt++,dish.getIdDish(), dishName, dishPrice, detail.getQuantity(), money
            });
        }
        
        txtTotal.setText(total + "");
        int discount = (int) txtDiscount.getValue();
        double money = Math.ceil(total * (1 - (double)discount/100));

        txtMoney.setText(String.format("%.0f", money));

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
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDish = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDishName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDishPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JSpinner();
        btnDishAdd = new javax.swing.JButton();
        btnDishUpdate = new javax.swing.JButton();
        errDishQty = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDishQty = new javax.swing.JSpinner();
        txtMoney = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbbCustomer = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        cbbEmployee = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        cbbTable = new javax.swing.JComboBox();
        btnUpdateBill = new javax.swing.JButton();
        btnBillRefresh = new javax.swing.JButton();
        errBill = new javax.swing.JLabel();
        msgBill = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Exit.png"))); // NOI18N
        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(46, 204, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CẬP NHẬT HÓA ĐƠN");

        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 350));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 350));

        tbDish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbDish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDishMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDish);

        tbDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbDetail);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Thực đơn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Món đã gọi");

        jLabel3.setText("Tên món");

        txtDishName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDishName.setEnabled(false);

        jLabel5.setText("Đơn giá");

        txtDishPrice.setDisabledTextColor(new java.awt.Color(20, 20, 20));
        txtDishPrice.setEnabled(false);
        txtDishPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDishPriceActionPerformed(evt);
            }
        });

        jLabel6.setText("Số lượng");

        txtDiscount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtDiscount.setPreferredSize(new java.awt.Dimension(0, 200));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, txtDiscount, org.jdesktop.beansbinding.ELProperty.create("^[0-9]+$"), txtDiscount, org.jdesktop.beansbinding.BeanProperty.create("verifyInputWhenFocusTarget"));
        bindingGroup.addBinding(binding);

        txtDiscount.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtDiscountStateChanged(evt);
            }
        });

        btnDishAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDishAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Create.png"))); // NOI18N
        btnDishAdd.setText("Thêm");
        btnDishAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDishAddMouseClicked(evt);
            }
        });
        btnDishAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDishAddActionPerformed(evt);
            }
        });

        btnDishUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDishUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Edit.png"))); // NOI18N
        btnDishUpdate.setText("Sửa");
        btnDishUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDishUpdateMouseClicked(evt);
            }
        });
        btnDishUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDishUpdateActionPerformed(evt);
            }
        });

        errDishQty.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setText("Tổng tiền");

        jLabel8.setText("Giảm giá");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("VND");

        jLabel10.setText("Tiền phải trả");

        txtTotal.setDisabledTextColor(new java.awt.Color(20, 20, 20));
        txtTotal.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${total}"), txtTotal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("VND");

        txtDishQty.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtDishQty.setPreferredSize(new java.awt.Dimension(0, 200));
        txtDishQty.setValue(1);
        txtDishQty.setVerifyInputWhenFocusTarget(false);
        txtDishQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtDishQtyStateChanged(evt);
            }
        });

        txtMoney.setDisabledTextColor(new java.awt.Color(20, 20, 20));
        txtMoney.setEnabled(false);
        txtMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoneyActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("VND");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("%");

        jLabel14.setText("Khách hàng");

        cbbCustomer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCustomerActionPerformed(evt);
            }
        });

        jLabel15.setText("Nhân viên");

        cbbEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("Bàn");

        cbbTable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnUpdateBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Tick.png"))); // NOI18N
        btnUpdateBill.setText("Cập nhật");
        btnUpdateBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateBillMouseClicked(evt);
            }
        });
        btnUpdateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBillActionPerformed(evt);
            }
        });

        btnBillRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBillRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnhahang_btln5/images/Refresh.png"))); // NOI18N
        btnBillRefresh.setText("Làm mới");
        btnBillRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBillRefreshMouseClicked(evt);
            }
        });
        btnBillRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillRefreshActionPerformed(evt);
            }
        });

        errBill.setForeground(new java.awt.Color(255, 0, 0));
        errBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        msgBill.setForeground(new java.awt.Color(0, 153, 51));
        msgBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(321, 321, 321))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(487, 487, 487)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(47, 47, 47)
                                                .addComponent(txtDishName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(errDishQty, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(txtDishPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel9))
                                                    .addComponent(txtDishQty, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(140, 140, 140)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addGap(31, 31, 31))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(btnDishAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(btnDishUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(199, 199, 199)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel12))
                                            .addComponent(btnUpdateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel14))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cbbTable, 0, 205, Short.MAX_VALUE)
                                                    .addComponent(cbbEmployee, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbbCustomer, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(btnBillRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(errBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(msgBill, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDishName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(cbbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDishPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(cbbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtDishQty, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(cbbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errDishQty, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errBill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msgBill)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDishUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBillRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDishAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void txtDishPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDishPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDishPriceActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ManagerBill managerBill = new ManagerBill();
        this.dispose();
        managerBill.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDishAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDishAddActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDishAddActionPerformed

    private void tbDishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDishMouseClicked
        // TODO add your handling code here:
          // TODO add your handling code here:
        int row = tbDish.getSelectedRow();
        
        txtDishName.setText(tbDish.getValueAt(row, 2).toString());
        txtDishPrice.setText(tbDish.getValueAt(row, 3).toString());
        txtDishQty.setValue(1);
    }//GEN-LAST:event_tbDishMouseClicked

    private void btnDishUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDishUpdateActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_btnDishUpdateActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoneyActionPerformed

    private void btnUpdateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateBillActionPerformed

    private void btnBillRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBillRefreshActionPerformed

    private void cbbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbCustomerActionPerformed

    private void txtDiscountStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtDiscountStateChanged
        // TODO add your handling code here:
        int discount = (int) txtDiscount.getValue();
        
        if(discount < 0) {
            discount = 0;
            txtDiscount.setValue(discount);
        }
        
         if(discount > 100) {
            discount = 100;
            txtDiscount.setValue(discount);
        }
        double total = 0;
        for(BillDetail detail : listDetail) {
            total += detail.getDish().getPrice() * detail.getQuantity();
        }
        
        double money = total * (1 - ((float)discount/100));
        txtMoney.setText(String.format("%.0f", money));
    }//GEN-LAST:event_txtDiscountStateChanged

    private void txtDishQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtDishQtyStateChanged
        // TODO add your handling code here:
        int quantity = (int) txtDishQty.getValue();
        
        if(quantity < 0) {
            quantity = 0;
            txtDishQty.setValue(quantity);
        }
    }//GEN-LAST:event_txtDishQtyStateChanged

    private void btnUpdateBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateBillMouseClicked
        // TODO add your handling code here:
        errBill.setText(null);
        msgBill.setText(null);
        
        if(listDetail.size() < 1) {
            errBill.setText("Chưa có món nào trong hóa đơn.");
            return;
        }
        ComboItem itemCustomer = (ComboItem)cbbCustomer.getSelectedItem();
        ComboItem itemEmployee = (ComboItem)cbbEmployee.getSelectedItem();
        ComboItem itemTable = (ComboItem)cbbTable.getSelectedItem();
        int discount = (int)txtDiscount.getValue();
        
        double total = 0;
        for(BillDetail detail : listDetail) {
            total += detail.getDish().getPrice() * detail.getQuantity();
        }
        total = Math.ceil(total * (1 - (double)discount/100));
        if(BillController.updateBill(bill.getIdBill(), itemCustomer.getValue(), 
                itemEmployee.getValue(), itemTable.getValue(), total, listDetail)) {
            msgBill.setText("Cập nhật hóa đơn thành công.");
            
        } else {
            errBill.setText("Cập nhật hóa đơn thất bại.");
        }
        
    }//GEN-LAST:event_btnUpdateBillMouseClicked

    private void btnBillRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillRefreshMouseClicked
        // TODO add your handling code here:
        txtDishName.setText(null);
        txtDishPrice.setText(null);
        txtDishQty.setValue(1);
        errDishQty.setText(null);
        listDetail.clear();
        txtDiscount.setValue(0);
        showTableDetail();
        cbbCustomer.setSelectedIndex(0);
        cbbEmployee.setSelectedIndex(0);
        cbbTable.setSelectedIndex(0);
        errBill.setText(null);
        msgBill.setText(null);
    }//GEN-LAST:event_btnBillRefreshMouseClicked

    private void btnDishUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDishUpdateMouseClicked
        // TODO add your handling code here:
        int rowDish = tbDish.getSelectedRow();
        errDishQty.setText("");
        
        if(rowDish < 0) {
            errDishQty.setText("Bạn chưa chọn món ăn");
            return;
        }
        int quantity = (int) txtDishQty.getValue();

        if(quantity < 0) {
            errDishQty.setText("Số lượng phải lớn hơn hoặc bằng 0");
            return;
        } 
        
        Dish dish = new Dish((int) tbDish.getValueAt(rowDish, 1),(String) tbDish.getValueAt(rowDish, 2), (double) tbDish.getValueAt(rowDish, 3) );
        
        BillDetail oldDetail = null;
        int index = -1;
        for(int i = 0; i < listDetail.size(); i++) {
            if(listDetail.get(i).getIdDish() == dish.getIdDish()) {
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
                listDetail.set(index, oldDetail);
                showTableDetail();
                return;
            }
          
        } else {
            errDishQty.setText("Món này chưa có trong hóa đơn.");
        }
    }//GEN-LAST:event_btnDishUpdateMouseClicked

    private void btnDishAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDishAddMouseClicked
        // TODO add your handling code here:
        int rowDish = tbDish.getSelectedRow();
        errDishQty.setText("");
        
        if(rowDish < 0) {
            errDishQty.setText("Bạn chưa chọn món ăn");
            return;
        }
        int quantity = (int) txtDishQty.getValue();

        if(quantity < 1) {
            errDishQty.setText("Số lượng phải lớn hơn 0");
            return;
        }
        
        Dish dish = new Dish((int) tbDish.getValueAt(rowDish, 1),(String) tbDish.getValueAt(rowDish, 2), (double) tbDish.getValueAt(rowDish, 3) );
        
        BillDetail oldDetail = null;
        int index = -1;
        for(int i = 0; i < listDetail.size(); i++) {
            if(listDetail.get(i).getIdDish() == dish.getIdDish()) {
                index = i;
                oldDetail = listDetail.get(i);
                break;
            }
        }
        
        if(oldDetail  != null) {
            oldDetail.setQuantity(quantity + oldDetail.getQuantity());
            listDetail.set(index, oldDetail);
            showTableDetail();
            return;
        }
        
        BillDetail detail = new BillDetail();
        detail.setIdDish(dish.getIdDish());
        detail.setQuantity(quantity);
        listDetail.add(detail);
        showTableDetail();
    }//GEN-LAST:event_btnDishAddMouseClicked

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
            java.util.logging.Logger.getLogger(UpdateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                if(bill == null) {
                    ManagerBill managerBill = new ManagerBill();
                    managerBill.setVisible(true);

                    return;
                }
                new UpdateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBillRefresh;
    private javax.swing.JButton btnDishAdd;
    private javax.swing.JButton btnDishUpdate;
    private javax.swing.JButton btnUpdateBill;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbbCustomer;
    private javax.swing.JComboBox cbbEmployee;
    private javax.swing.JComboBox cbbTable;
    private javax.swing.JLabel errBill;
    private javax.swing.JLabel errDishQty;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel msgBill;
    private javax.swing.JTable tbDetail;
    private javax.swing.JTable tbDish;
    private javax.swing.JSpinner txtDiscount;
    private javax.swing.JTextField txtDishName;
    private javax.swing.JTextField txtDishPrice;
    private javax.swing.JSpinner txtDishQty;
    private javax.swing.JTextField txtMoney;
    private javax.swing.JTextField txtTotal;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
