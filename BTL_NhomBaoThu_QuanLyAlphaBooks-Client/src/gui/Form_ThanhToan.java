/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import entities.HoaDon;
import ultilities.ColorProcessing;
import ultilities.ErrorMessage;
import ultilities.ExcelFileExportForHoaDon;
import ultilities.Numberic;

import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.border.Border;

public class Form_ThanhToan extends JFrame {
    private JFrame frameOriginal;
    private TAB_BanHang tabBanHang;
    private HoaDon hoaDon; 
    private HoaDon_BUS hoaDon_BUS;
    private ChiTietHoaDon_BUS chiTietHoaDon_BUS;
    /**
     * Creates new form Form_ThanhToan
     */
    public Form_ThanhToan() {
    }
    
    public Form_ThanhToan(HoaDon x, JFrame y, TAB_BanHang tab) {  
        this.frameOriginal = y;
        this.hoaDon = x;
        this.tabBanHang = tab;
        
        hoaDon_BUS = new HoaDon_BUS();
        chiTietHoaDon_BUS = new ChiTietHoaDon_BUS();
       /* Nghiệp vụ cũ 
        x.setTrangThai("CHO_XU_LY");
        
        if (!tabBanHang.updateHoaDon("CHO_XU_LY")){
            JOptionPane.showMessageDialog(null, "Thông tin: Khởi tạo hoá đơn thất bại.");
        }
        */
        
        y.setEnabled(false);
        //setUndecorated(true); 

       // getRootPane().setWindowDecorationStyle(JRootPane.);
        setResizable(false);
        initComponents();
        setLocationRelativeTo(null); 
        
        lblCanThanhToan.setText(Numberic.formatVND(x.tinhThanhTien()));
        lblChietKhau.setText(Numberic.formatVND(x.getGiaKhuyenMai()));
        lblTongThue.setText(Numberic.formatVND(x.tinhTongThue()));
        lblTongTien.setText(Numberic.formatVND(x.tinhTongTien()));
        lblMaHoaDon.setText(x.getHoaDonID());
        
        lblTraKhach.setText("Còn thiếu " + Numberic.formatVND(x.tinhThanhTien()));

        txtTienKhachDua.setText("");
        txtTienKhachDua.requestFocus();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lblCanThanhToan = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblTraKhach = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        btnClearTienKhachDua = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn1K = new javax.swing.JButton();
        btn2K = new javax.swing.JButton();
        btn5K = new javax.swing.JButton();
        btn10K = new javax.swing.JButton();
        btn20K = new javax.swing.JButton();
        btn50K = new javax.swing.JButton();
        btn100K = new javax.swing.JButton();
        btn200K = new javax.swing.JButton();
        btn500K = new javax.swing.JButton();
        btnVuaDu = new javax.swing.JButton();
        btnBackThanhToan = new javax.swing.JButton();
        btnThanhToanHoanTat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblChietKhau = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTongThue = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Thanh toán");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 102, 165));
        jLabel1.setText("Thông tin thanh toán");

        jPanel5.setBackground(new java.awt.Color(245, 247, 249));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Cần thanh toán");

        lblCanThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCanThanhToan.setForeground(new java.awt.Color(255, 0, 0));
        lblCanThanhToan.setText("100,000 VND");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Trả lại khách");

        lblTraKhach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTraKhach.setForeground(new java.awt.Color(255, 0, 0));
        lblTraKhach.setText("100,000 VND");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Tiền khách đưa:");

        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTienKhachDua.setText("test");
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                updateStateTienKhachDuaKeyPressed(evt);
            }
        });

        btnClearTienKhachDua.setText("X");
        btnClearTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });

        java.awt.GridBagLayout jPanel6Layout = new java.awt.GridBagLayout();
        jPanel6Layout.columnWidths = new int[] {0, 14, 0, 14, 0};
        jPanel6Layout.rowHeights = new int[] {0, 13, 0, 13, 0, 13, 0, 13, 0};
        jPanel6.setLayout(jPanel6Layout);

        btn1K.setBackground(new java.awt.Color(15, 102, 165));
        btn1K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn1K.setForeground(new java.awt.Color(255, 255, 255));
        btn1K.setText("1,000");
        btn1K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn1K, gridBagConstraints);

        btn2K.setBackground(new java.awt.Color(15, 102, 165));
        btn2K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn2K.setForeground(new java.awt.Color(255, 255, 255));
        btn2K.setText("2,000");
        btn2K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn2K, gridBagConstraints);

        btn5K.setBackground(new java.awt.Color(15, 102, 165));
        btn5K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn5K.setForeground(new java.awt.Color(255, 255, 255));
        btn5K.setText("5,000");
        btn5K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn5K, gridBagConstraints);

        btn10K.setBackground(new java.awt.Color(15, 102, 165));
        btn10K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn10K.setForeground(new java.awt.Color(255, 255, 255));
        btn10K.setText("10,000");
        btn10K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn10K, gridBagConstraints);

        btn20K.setBackground(new java.awt.Color(15, 102, 165));
        btn20K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn20K.setForeground(new java.awt.Color(255, 255, 255));
        btn20K.setText("20,000");
        btn20K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn20K, gridBagConstraints);

        btn50K.setBackground(new java.awt.Color(15, 102, 165));
        btn50K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn50K.setForeground(new java.awt.Color(255, 255, 255));
        btn50K.setText("50,000");
        btn50K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn50K, gridBagConstraints);

        btn100K.setBackground(new java.awt.Color(15, 102, 165));
        btn100K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn100K.setForeground(new java.awt.Color(255, 255, 255));
        btn100K.setText("100,000");
        btn100K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn100K, gridBagConstraints);

        btn200K.setBackground(new java.awt.Color(15, 102, 165));
        btn200K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn200K.setForeground(new java.awt.Color(255, 255, 255));
        btn200K.setText("200,000");
        btn200K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn200K, gridBagConstraints);

        btn500K.setBackground(new java.awt.Color(15, 102, 165));
        btn500K.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn500K.setForeground(new java.awt.Color(255, 255, 255));
        btn500K.setText("500,000");
        btn500K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btn500K, gridBagConstraints);

        btnVuaDu.setBackground(new java.awt.Color(15, 102, 165));
        btnVuaDu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVuaDu.setForeground(new java.awt.Color(255, 255, 255));
        btnVuaDu.setText("Vừa đủ");
        btnVuaDu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyPadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btnVuaDu, gridBagConstraints);

        btnBackThanhToan.setBackground(new java.awt.Color(239, 162, 162));
        btnBackThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBackThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnBackThanhToan.setText("Quay lại");
        btnBackThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackThanhToanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btnBackThanhToan, gridBagConstraints);

        btnThanhToanHoanTat.setBackground(new java.awt.Color(83, 182, 118));
        btnThanhToanHoanTat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThanhToanHoanTat.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToanHoanTat.setText("Hoàn tất");
        btnThanhToanHoanTat.setEnabled(false);
        btnThanhToanHoanTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanHoanTatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(btnThanhToanHoanTat, gridBagConstraints);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(btnClearTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCanThanhToan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTraKhach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCanThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanel2.setBackground(new java.awt.Color(245, 247, 249));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã đơn hàng");

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaHoaDon.setForeground(new java.awt.Color(15, 102, 165));
        lblMaHoaDon.setText("HD110923001");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(15, 102, 165));
        lblTongTien.setText("120,000 VND");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiền");

        lblChietKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblChietKhau.setForeground(new java.awt.Color(15, 102, 165));
        lblChietKhau.setText("120,000 VND");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Chiết khấu");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tổng thuế");

        lblTongThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongThue.setForeground(new java.awt.Color(15, 102, 165));
        lblTongThue.setText("20,000 VND");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Phương thức thanh toán (Development)");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Momo" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblChietKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(lblTongThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChietKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongThue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackThanhToanActionPerformed
        // TODO add your handling code here:
        if (ErrorMessage.showConfirmDialogYesNo("Xác nhận thoát", "Hoá đơn này chưa được thanh toán, bạn đã chắc chắn muốn thoát?")){
        	closeFormThanhToan();
        }
    }//GEN-LAST:event_btnBackThanhToanActionPerformed

    private void btnThanhToanHoanTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanHoanTatActionPerformed
        // TODO add your handling code here:
        double tienNhan = 0;
        double tongThanhToan = hoaDon.tinhThanhTien();
        double tienTraLai = 0;
        if (!Numberic.isDouble(txtTienKhachDua.getText())){
            ErrorMessage.showMessageWithFocusTextField("Lỗi", "Tiền khách đưa chỉ có thể là số!", txtTienKhachDua);
            return;
        }
        tienNhan = Numberic.parseDouble(txtTienKhachDua.getText());
        tienTraLai = tienNhan - tongThanhToan;
        if (tienTraLai < 0){
            ErrorMessage.showMessageWithFocusTextField("Lỗi", "Chưa nhận đủ tiền!", txtTienKhachDua);
            return;
        }
        
        hoaDon.setTrangThai("DA_XU_LY");
        boolean result = hoaDon_BUS.createHoaDon(hoaDon);
        
        if (!result){
            JOptionPane.showMessageDialog(null, "Thanh toán thất bại, đã xảy ra lỗi khi khởi tạo hoá đơn.");
            return;
        }
        
        result = chiTietHoaDon_BUS.addNhieuChiTietCuaMotHoaDon(hoaDon.getListChiTietHoaDon());
        if (!result) {
            JOptionPane.showMessageDialog(null, "Thanh toán thất bại, đã xảy ra lỗi khi thêm chi tiết hoá đơn.");
            return;
        }
        
        hoaDon.setNgayLapHoaDon( new Date() );
        if (ErrorMessage.showConfirmDialogYesNo(
                "Thanh toán hoàn tất", 
                (tienTraLai > 0 ? "Đừng quên trả khách " + Numberic.formatVND(tienTraLai) + " nhé!" : "Đã nhận đủ tiền!") + "\nBạn có muốn in hoá đơn?"
        )){
        	new ExcelFileExportForHoaDon(hoaDon, tienNhan, tienTraLai);  
        }

    	tabBanHang.thanhToanHoanTat();
    	closeFormThanhToan();
        
    }//GEN-LAST:event_btnThanhToanHoanTatActionPerformed

    private void btnKeyPadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeyPadActionPerformed
        // TODO add your handling code here:
        Object obj = evt.getSource();
        
        double temp = 0;
        String tempStr = txtTienKhachDua.getText();
        if (tempStr.isBlank() || tempStr.isEmpty())
            tempStr = "0";
        
        /* Vừa đủ */
        if (obj.equals(btnVuaDu)){
            txtTienKhachDua.setText(String.format("%.0f", hoaDon.tinhThanhTien()));
            calcTrangThai(String.format("%.0f", hoaDon.tinhThanhTien()));
            return;
        }
        
        if (obj.equals(btnClearTienKhachDua)){
            txtTienKhachDua.setText("");
            calcTrangThai("0");
            return;
        }
        
        if (obj.equals(btn1K)){
            temp = 1000;
        }else if (obj.equals(btn2K)){
            temp = 2000;
        }else if (obj.equals(btn5K)){
            temp = 5000;
        }else if (obj.equals(btn10K)){
            temp = 10000;
        }else if (obj.equals(btn20K)){
            temp = 20000;
        }else if (obj.equals(btn50K)){
            temp = 50000;
        }else if (obj.equals(btn100K)){
            temp = 100000;
        }else if (obj.equals(btn200K)){
            temp = 200000;
        }else if (obj.equals(btn500K)){
            temp = 500000;
        }
        
        if (!Numberic.isDouble(tempStr))
            tempStr = "0";
        temp += Numberic.parseDouble(tempStr);
        tempStr = String.format("%.0f",temp);
        calcTrangThai(String.format("%.0f",temp));
        txtTienKhachDua.setText(String.format("%.0f",temp));
    }//GEN-LAST:event_btnKeyPadActionPerformed

    private void updateStateTienKhachDuaKeyPressed(KeyEvent evt) {//GEN-FIRST:event_updateStateTienKhachDuaKeyPressed
        // TODO add your handling code here:
        String temp = txtTienKhachDua.getText();
        temp = temp.replaceAll("[\\D]", "");
        
        if (temp.isBlank() || temp.isEmpty())
            temp = "0";
        txtTienKhachDua.setText(temp);
        
        calcTrangThai(temp);
        
    }//GEN-LAST:event_updateStateTienKhachDuaKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (ErrorMessage.showConfirmDialogYesNo("Xác nhận thoát", "Hoá đơn này chưa được thanh toán, bạn đã chắc chắn muốn thoát?")){
        	closeFormThanhToan();
        }
    }//GEN-LAST:event_formWindowClosing

    private void calcTrangThai(String temp){
        double tempDoubleTKD = 0;
        double tempTraLai = 0;
        lblTraKhach.setForeground(ColorProcessing.rgbColor(255, 0, 0));
        btnThanhToanHoanTat.setEnabled(false);
        if (Numberic.isDouble(temp)){
            tempDoubleTKD = Numberic.parseDouble(temp);
            if (tempDoubleTKD == 0)
                txtTienKhachDua.setText("0");
            else
                txtTienKhachDua.setText(String.format("%.0f", tempDoubleTKD));
            tempTraLai = tempDoubleTKD - hoaDon.tinhThanhTien();
            if (tempTraLai < 0){
                lblTraKhach.setText("Còn thiếu " + Numberic.formatVND(tempTraLai * -1));
                return;
            }
            lblTraKhach.setForeground(ColorProcessing.rgbColor(15, 102, 165));
            btnThanhToanHoanTat.setEnabled(true);
            if (tempTraLai == 0){
                lblTraKhach.setText("Nhận vừa đủ");
                return;
            }
            lblTraKhach.setText(Numberic.formatVND(tempTraLai));

        }
    }
    
    private void closeFormThanhToan() {
    	if (frameOriginal != null)
    		frameOriginal.setEnabled(true);
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn100K;
    private javax.swing.JButton btn10K;
    private javax.swing.JButton btn1K;
    private javax.swing.JButton btn200K;
    private javax.swing.JButton btn20K;
    private javax.swing.JButton btn2K;
    private javax.swing.JButton btn500K;
    private javax.swing.JButton btn50K;
    private javax.swing.JButton btn5K;
    private javax.swing.JButton btnBackThanhToan;
    private javax.swing.JButton btnClearTienKhachDua;
    private javax.swing.JButton btnThanhToanHoanTat;
    private javax.swing.JButton btnVuaDu;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCanThanhToan;
    private javax.swing.JLabel lblChietKhau;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblTongThue;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTraKhach;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables

}
