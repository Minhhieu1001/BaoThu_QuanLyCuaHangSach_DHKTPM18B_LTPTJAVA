/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.values.JavaBase64Holder;

import com.formdev.flatlaf.json.ParseException;
import com.formdev.flatlaf.ui.FlatListCellBorder.Default;

import bus.KhachHang_BUS;
import bus.NhanVien_BUS;
import entities.KhachHang;
import entities.NhanVien;
import ultilities.ErrorMessage;
import ultilities.ProcessingEnumDBForQuy;
import ultilities.RegexPattern;

/**
 *
 * @author s2quy
 */
public class TAB_KhachHang extends javax.swing.JPanel {
	KhachHang_BUS khachHangBus = new KhachHang_BUS();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public TAB_KhachHang() {
		initComponents();
		phimTatTimKien();
		customizeTable();
		loadKhachHangTable();
		showTuBangLenFormKhachHang();
		txtMa.setEditable(false);
		txtMa.setText(phatSinhMaKhachHang1());
               // btnDangXuatKH.setVisible(false);
//		txtMaSoThue.setEditable(false);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        jLabel3 = new JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel9 = new JLabel();
        txtMaSoThue = new javax.swing.JTextField();
        jLabel10 = new JLabel();
        cboLoaiKH = new javax.swing.JComboBox<>();
        dtmNgaySinh = new com.toedter.calendar.JDateChooser();
        cboGioiTinh = new javax.swing.JComboBox<>();
        btnXoaRong = new javax.swing.JButton();
        btnHienThiBang = new javax.swing.JButton();
        right = new javax.swing.JPanel();
        jLabel12 = new JLabel();
        txtMa1 = new javax.swing.JTextField();
        jLabel13 = new JLabel();
        txtTen1 = new javax.swing.JTextField();
        jLabel14 = new JLabel();
        txtSDT1 = new javax.swing.JTextField();
        jLabel15 = new JLabel();
        cboGioiTinh1 = new javax.swing.JComboBox<>();
        jLabel16 = new JLabel();
        cboLoaiKH1 = new javax.swing.JComboBox<>();
        btnTimKiemKH = new javax.swing.JButton();
        jLabel1 = new JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnThemKH = new javax.swing.JButton();
        btnSuaKH = new javax.swing.JButton();
        btnImportKH = new javax.swing.JButton();
        btnExportKH = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        Left.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));
        Left.setToolTipText("");

        jLabel3.setText("Mã Khách Hàng :");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel2.setText("Số Điện Thoại:");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel4.setText("Họ và tên : ");

        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày sinh :");

        jLabel6.setText("Email :");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel7.setText("Giới Tính :");

        jLabel8.setText("Địa chỉ :");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã số thuế :");

        txtMaSoThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtMaSoThueActionPerformed(evt);
            }
        });

        jLabel10.setText("Loại Khách Hàng :");

        cboLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cá nhân", "Doanh nghiệp" }));
        cboLoaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cboLoaiKHActionPerformed(evt);
            }
        });

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        btnXoaRong.setBackground(new Color(255, 51, 51));
        btnXoaRong.setForeground(new Color(255, 255, 255));
        btnXoaRong.setText("Xoá rỗng");
        btnXoaRong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnXoaRongActionPerformed(evt);
            }
        });

        btnHienThiBang.setBackground(new Color(15, 145, 239));
        btnHienThiBang.setForeground(new Color(255, 255, 255));
        btnHienThiBang.setText("Hiển thị bảng");
        btnHienThiBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnHienThiBangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSDT)
                    .addComponent(txtMa)
                    .addComponent(txtEmail)
                    .addComponent(txtDiaChi)
                    .addComponent(cboLoaiKH, 0, 214, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtmNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(LeftLayout.createSequentialGroup()
                            .addComponent(btnHienThiBang)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                            .addComponent(btnXoaRong))
                        .addComponent(txtMaSoThue, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5))
                    .addComponent(dtmNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHienThiBang)
                            .addComponent(btnXoaRong))
                        .addGap(19, 19, 19))))
        );

        right.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm nhân viên"));

        jLabel12.setText("Mã khách hàng:");

        txtMa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtMa1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Họ và tên: ");

        txtTen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtTen1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Số điện thoại");

        txtSDT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtSDT1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Giới tính");

        cboGioiTinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Nam", "Nữ" }));
        cboGioiTinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cboGioiTinh1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Loại khách hàng");

        cboLoaiKH1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Cá nhân", "Doanh nghiệp" }));
        cboLoaiKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cboLoaiKH1ActionPerformed(evt);
            }
        });

        btnTimKiemKH.setBackground(new Color(15, 145, 239));
        btnTimKiemKH.setForeground(new Color(255, 255, 255));
        btnTimKiemKH.setText("Tìm Kiếm");
        btnTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTimKiemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rightLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightLayout.createSequentialGroup()
                                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(rightLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(22, 22, 22)))
                        .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(rightLayout.createSequentialGroup()
                                .addComponent(cboGioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLoaiKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSDT1)
                            .addComponent(txtTen1)
                            .addComponent(txtMa1))))
                .addGap(22, 22, 22))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cboGioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cboLoaiKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new Color(15, 145, 239));
        jLabel1.setText("Quản Lý Khách Hàng");

        tblKhachHang.setAutoCreateRowSorter(true);
        tblKhachHang.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Khách Hàng", "Họ Tên", "Số Điện Thoại", "Ngày sinh", "Email", "Giới Tính", "Địa Chỉ", "Mã số thuế", "Loại Khách Hàng"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKhachHang.setSelectionBackground(new Color(51, 153, 255));
        jScrollPane1.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        btnThemKH.setBackground(new Color(85, 182, 83));
        btnThemKH.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKH.setForeground(new Color(255, 255, 255));
        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/them.png"))); // NOI18N
        btnThemKH.setText("Thêm");
        btnThemKH.setVerifyInputWhenFocusTarget(false);
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnSuaKH.setBackground(new Color(85, 182, 83));
        btnSuaKH.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaKH.setForeground(new Color(255, 255, 255));
        btnSuaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/sua.png"))); // NOI18N
        btnSuaKH.setText("Sửa");
        btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSuaKHActionPerformed(evt);
            }
        });

        btnImportKH.setBackground(new Color(85, 182, 83));
        btnImportKH.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        btnImportKH.setForeground(new Color(255, 255, 255));
        btnImportKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/import.png"))); // NOI18N
        btnImportKH.setText("Import");
        btnImportKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnImportKHActionPerformed(evt);
            }
        });

        btnExportKH.setBackground(new Color(85, 182, 83));
        btnExportKH.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        btnExportKH.setForeground(new Color(255, 255, 255));
        btnExportKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/export.png"))); // NOI18N
        btnExportKH.setText("Export");
        btnExportKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExportKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnThemLayout = new javax.swing.GroupLayout(btnThem);
        btnThem.setLayout(btnThemLayout);
        btnThemLayout.setHorizontalGroup(
            btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemLayout.createSequentialGroup()
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(btnThemLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, btnThemLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnThemKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSuaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnImportKH, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(btnExportKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemLayout.createSequentialGroup()
                                .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48))
        );
        btnThemLayout.setVerticalGroup(
            btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThemLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btnThemLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnImportKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnExportKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(btnThem, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed


	private void customizeTable() {
		// Lấy đối tượng JTableHeader của bảng tblNhanVien
		JTableHeader header = tblKhachHang.getTableHeader();
		DefaultTableCellRenderer headerTitle = new DefaultTableCellRenderer();
		// Tạo một đối tượng Color để đại diện cho màu nền
		Color headerBackgroundColor = Color.decode("#2FA1D2"); // Màu nền là màu mã hex #42d212

		// Tạo một đối tượng Color để đại diện cho màu chữ
		Color headerForegroundColor = Color.WHITE; // Màu chữ là màu trắng

		header.setBackground(headerBackgroundColor);
		header.setForeground(headerForegroundColor);
		header.setFont(new Font("arial", Font.BOLD, 12));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Đặt kiểu căn giữa
		tblKhachHang.setCellSelectionEnabled(false);
		tblKhachHang.setRowSelectionAllowed(true);
		tblKhachHang.setColumnSelectionAllowed(false);
	
	}

	private void btnXoaRongActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnXoaRongActionPerformed
		// TODO add your handling code here:
		xoaRong();
	}// GEN-LAST:event_btnXoaRongActionPerformed

	private void btnHienThiBangActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnHienThiBangActionPerformed
		loadKhachHangTable();
	}// GEN-LAST:event_btnHienThiBangActionPerformed

	private void btnTimKiemKHActionPerformed(ActionEvent evt) {
		// Lấy thông tin từ các trường nhập liệu
		String maKhachHang = txtMa1.getText();
		String tenKhachHang = txtTen1.getText();
		String soDienThoai = txtSDT1.getText();
		String gioiTinh = (String) cboGioiTinh1.getSelectedItem();
		String loaiKhachHang = (String) cboLoaiKH1.getSelectedItem();

		// Gọi hàm tìm kiếm nâng cao từ lớp BUS
		List<KhachHang> resultList = khachHangBus.findKhachHangAdvanced(maKhachHang, tenKhachHang, soDienThoai,
				gioiTinh, loaiKhachHang);

		// Ví dụ hiển thị trên bảng (sử dụng một DefaultTableModel cho bảng jTable1)
		DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
		if (!resultList.isEmpty()) {
			model.setRowCount(0);
			for (int i = 0; i < resultList.size(); i++) {
				KhachHang kh = resultList.get(i);
				model.addRow(new Object[] { i + 1, kh.getKhachHangID(), kh.getHoTen(), kh.getSoDienThoai(),
						kh.getNgaySinh(), kh.getEmail(), ProcessingEnumDBForQuy.enumToGioiTinh(kh.getGioiTinh()), kh.getDiaChi(), kh.getMaSoThue(),
						ProcessingEnumDBForQuy.convertEnumToKhachHang(kh.getLoaiKhachHang()) });
			}
		} else {
			JOptionPane.showMessageDialog(this, "Không tìm thấy");
		}
	}

	private void xoaRong() {
		txtMa.setText(phatSinhMaKhachHang1());
		txtTen.setText("");
		txtSDT.setText("");
		dtmNgaySinh.setDate(null);
		txtEmail.setText("");
		txtMaSoThue.setText("");
		txtDiaChi.setText("");

		cboGioiTinh.setSelectedIndex(0);
		cboLoaiKH.setSelectedIndex(0);
	}

	private void loadKhachHangTable() {
		DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
		model.setRowCount(0);
		KhachHang_BUS khachHangBus = new KhachHang_BUS();
		List<KhachHang> listKH = khachHangBus.getAllKhachHang();
		for (int i = 0; i < listKH.size(); i++) {
			KhachHang kh = listKH.get(i);
			model.addRow(
					new Object[] { i + 1, kh.getKhachHangID(), kh.getHoTen(), kh.getSoDienThoai(), kh.getNgaySinh(),
							kh.getEmail(), ProcessingEnumDBForQuy.enumToGioiTinh(kh.getGioiTinh()), kh.getDiaChi(), kh.getMaSoThue(), ProcessingEnumDBForQuy.convertEnumToKhachHang(kh.getLoaiKhachHang()) });
		}
	}

	public String phatSinhMaKhachHang1() {
		try {
			long maxId = khachHangBus.phatSinhMaKhachHang();
            String maKH = String.format("KH%04d", maxId);
            return maKH;
		} catch (Exception e) {

			return "KH0001";
		}
	}



	private void showTuBangLenFormKhachHang() {
		tblKhachHang.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblKhachHang.rowAtPoint(e.getPoint());
				if (row >= 0) {
					// Lấy giá trị từ bảng và hiển thị lên các JTextField và JComboBox
					txtMa.setText(tblKhachHang.getValueAt(row, 1).toString());
					txtTen.setText(tblKhachHang.getValueAt(row, 2).toString());
					txtSDT.setText(tblKhachHang.getValueAt(row, 3).toString());

					// Hiển thị ngày sinh
					String ngaySinh = tblKhachHang.getValueAt(row, 4).toString();
					try {
						Date ngaySinhDate = dateFormat.parse(ngaySinh);
						dtmNgaySinh.setDate(ngaySinhDate);
					} catch (java.text.ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					txtEmail.setText(tblKhachHang.getValueAt(row, 5).toString());
					cboGioiTinh.setSelectedIndex(ProcessingEnumDBForQuy.gioiTinhToEnum(tblKhachHang.getValueAt(row, 6).toString()).equalsIgnoreCase("NAM") ? 0 : 1);
					txtDiaChi.setText(tblKhachHang.getValueAt(row, 7).toString());
					txtMaSoThue.setText(tblKhachHang.getValueAt(row, 8).toString());
					cboLoaiKH.setSelectedItem(tblKhachHang.getValueAt(row, 9).toString());
				}
			}
		});
	}

	private boolean valid() {
		String errorMessage = "";
		String maKH = phatSinhMaKhachHang1();
		String errorMessage1 = "";
		// Kiểm tra mã khách hàng
		if (maKH.isBlank()) {
			errorMessage += "Mã khách hàng không được trống.\n";
			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}

		if (txtTen.getText().isEmpty()) {
			errorMessage += "Họ tên không được trống.\n";
			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}
		if (!txtTen.getText().matches(RegexPattern.HOTEN)) {
			errorMessage1 += "Họ tên không hợp lệ phải viết hoa các chữ cái đầu.\n";
			JOptionPane.showMessageDialog(this, errorMessage1);
			return false;

		}
		// Kiểm tra số điện thoại
		if (txtSDT.getText().isBlank()) {
			errorMessage += "Số điện thoại không được trống.\n";
			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}
		if (!txtSDT.getText().matches(RegexPattern.SDTVN)) {
			errorMessage1 += "Số điện thoại: phải Có định dạng là 0XXXXXXXXX . \n";
			JOptionPane.showMessageDialog(this, errorMessage1);
			return false;
		}
		// Kiểm tra ngày sinh
		if (dtmNgaySinh.getDate() == null) {
//			errorMessage += "Ngày sinh không được trống.\n";
//			JOptionPane.showMessageDialog(this, errorMessage);
			dtmNgaySinh.setDate(new Date());
		}

		// Kiểm tra địa chỉ
		if (txtDiaChi.getText().isBlank()) {
//			errorMessage += "Địa chỉ không được trống.\n";
//			JOptionPane.showMessageDialog(this, errorMessage);
			//txtDiaChi.setText("");
		}

		// Kiểm tra loại khách hàng
		if (cboLoaiKH.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, errorMessage);
			errorMessage += "Vui lòng chọn loại khách hàng.\n";
			return false;
		}

		// Nếu errorMessage không trống, hiển thị thông báo lỗi
		if (!errorMessage.isEmpty()) {

			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}

		return true;
	}

	private void btnThemKHActionPerformed(ActionEvent evt) {
		if (valid()) {
			try {
				String maKH = phatSinhMaKhachHang1();
				String tenKH = txtTen.getText();
				String sdtKH = txtSDT.getText();                              
                                KhachHang tempKH = khachHangBus.getKhachHangTuMaVaSDT(sdtKH);
                                if (tempKH != null){
                                    ErrorMessage.showMessageWithFocusTextField("Lỗi", "Số điện thoại khách hàng bị trùng với " + tempKH.getKhachHangID() + " thêm thất bại!", txtSDT);
                                    return;
                                }
				Date chonNgaySinh = dtmNgaySinh.getDate();
				String ngaySinh = dateFormat.format(chonNgaySinh);
				String gioiTinh = (String) cboGioiTinh.getSelectedItem();
				String email = txtEmail.getText();

				String diaChi = txtDiaChi.getText();
				String loaiKH = (String) cboLoaiKH.getSelectedItem();
				String maSoThue = txtMaSoThue.getText();

				KhachHang newKhachHang = new KhachHang(maKH, tenKH, sdtKH, LocalDate.parse(ngaySinh), gioiTinh, email,
						maSoThue, diaChi, ProcessingEnumDBForQuy.convertKhachHangToEnum(loaiKH));
				KhachHang_BUS khachHangBus = new KhachHang_BUS();
				if (khachHangBus.addKhachHang(newKhachHang)) {
					JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
					loadKhachHangTable();
					xoaRong();
					txtMa.setText(phatSinhMaKhachHang1());
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi các trường nhập vào...");
			}
		}
	}

	private void btnSuaKHActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnSuaKHActionPerformed
		int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không", "Xác nhận",
				JOptionPane.YES_NO_OPTION);
		if (valid()) {
//			KhachHang kh = new 
			String maKH = txtMa.getText();
			String tenKH = txtTen.getText();
			String sdtKH = txtSDT.getText();
			Date ngaySinh = dtmNgaySinh.getDate();
			LocalDate ngaySinh1 = ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			String email = txtEmail.getText();
			String gioiTinh = cboGioiTinh.getSelectedItem().toString();
			String diaChi = txtDiaChi.getText();
			String maSoThue = txtMaSoThue.getText();
			String loaiKH = cboLoaiKH.getSelectedItem().toString();
//			KhachHang exitingKhachHang = khachHangBus.getKhachHangByKhachHangID(maKH);
			KhachHang khachHang = new KhachHang(maKH, tenKH, sdtKH, ngaySinh1, gioiTinh, email, maSoThue, diaChi,
					ProcessingEnumDBForQuy.convertKhachHangToEnum(loaiKH));
			boolean result = khachHangBus.editKhachHang(khachHang);
			if (result) {
				JOptionPane.showMessageDialog(this, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				loadKhachHangTable();
			} else {
				JOptionPane.showMessageDialog(this, "Sửa không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);

			}

		}
	}

	private void btnXoaKHActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnXoaKHActionPerformed
		try {
			// Lấy thông tin từ các trường nhập liệu trong giao diện
			String maKhachHang = txtMa.getText();

			// Kiểm tra xem người dùng đã chọn một khách hàng để xóa chưa
			if (maKhachHang.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để xóa.", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này?",
					"Xác nhận xóa", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				// Tạo một đối tượng KhachHang với mã khách hàng để truyền vào hàm xóa
				KhachHang khachHangXoa = new KhachHang();
				khachHangXoa.setKhachHangID(maKhachHang);

				boolean result = khachHangBus.deleteKhachHang(khachHangXoa);

				// Hiển thị thông báo kết quả
				if (result) {
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					// Cập nhật lại bảng hoặc làm những gì đó cần thiết
					loadKhachHangTable();
				} else {
					JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi khi xóa khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_btnXoaKHActionPerformed

	private void btnImportKHActionPerformed(ActionEvent evt) {

		try {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
			fileChooser.setFileFilter(filter);

			int returnVal = fileChooser.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();

				List<KhachHang> importedList = readCustomerDataFromExcel(file);

				if (importedList.isEmpty()) {
					JOptionPane.showMessageDialog(this, "File Excel không có dữ liệu hoặc định dạng không đúng.");
					return;
				}

				KhachHang_BUS khachHangBus = new KhachHang_BUS();
                int successCount = 0;

				// Thêm dữ liệu vào cơ sở dữ liệu
				for (KhachHang khachHang : importedList) {
                    if (khachHangBus.checkIfKhachHangExists(khachHang.getKhachHangID())) {
                        JOptionPane.showMessageDialog(this, "Mã khách hàng " + khachHang.getKhachHangID() + " đã tồn tại, bỏ qua.");
                        continue;
                    }
					if (khachHangBus.addKhachHang(khachHang)) {
						successCount++;
					} else {
						// Nếu thêm không thành công, hiển thị thông báo lỗi
						JOptionPane.showMessageDialog(this, "Lỗi khi thêm khách hàng");
						return ;
					}
				}
                loadKhachHangTable();
				JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi khi đọc dữ liệu từ file Excel.");

		}
	}

    public List<KhachHang> readCustomerDataFromExcel(File file) {
        List<KhachHang> customerList = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        int sttColumnIndex = 0;
        int maKhachHangColumnIndex = -1; // Chỉ số của cột Mã khách hàng
        KhachHang_BUS khachHangBus = new KhachHang_BUS();

        try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            // Bỏ qua dòng tiêu đề và xác định vị trí cột
            if (iterator.hasNext()) {
                Row headerRow = iterator.next();
                for (Cell cell : headerRow) {
                    String cellValue = getStringValue(cell);
                    if (cellValue != null && cellValue.equalsIgnoreCase("STT")) {
                        sttColumnIndex = cell.getColumnIndex();
                    } else if (cellValue.equalsIgnoreCase("MÃ KHÁCH HÀNG")) {
                        maKhachHangColumnIndex = cell.getColumnIndex();
                    }
                }
            }

            // Đếm số hàng hợp lệ để sinh mã trước
            int validRows = 0;
            Iterator<Row> tempIterator = sheet.iterator();
            if (tempIterator.hasNext()) tempIterator.next(); // Bỏ qua tiêu đề
            while (tempIterator.hasNext()) {
                Row row = tempIterator.next();
                if (row.getLastCellNum() >= 9) validRows++; // Yêu cầu ít nhất 9 cột (STT, Mã KH, Tên KH, Giới tính, SĐT, Ngày sinh, Email, Mã số thuế, Địa chỉ, Loại KH)
            }

            // Sinh danh sách mã duy nhất
            List<String> maKHList = new ArrayList<>();
            long startNum = khachHangBus.phatSinhMaKhachHang();
            for (int i = 0; i < validRows; i++) {
                String maKH = String.format("KH%04d", startNum + i);
                maKHList.add(maKH);
            }

            // Đọc dữ liệu và tạo đối tượng KhachHang
            int maIndex = 0;
            iterator = sheet.iterator();
            if (iterator.hasNext()) iterator.next(); // Bỏ qua tiêu đề
            while (iterator.hasNext() && maIndex < maKHList.size()) {
                Row currentRow = iterator.next();
                int cellCount = currentRow.getLastCellNum();
                if (cellCount < 9) {
                    errors.add("Hàng " + (currentRow.getRowNum() + 1) + ": Không đủ cột dữ liệu (yêu cầu ít nhất 9 cột).");
                    continue;
                }

                // Đọc dữ liệu từ các cột bằng cách truy cập trực tiếp theo chỉ số
                int currentIndex = sttColumnIndex + 1; // Bỏ qua cột STT
                Cell cellMaKH = currentRow.getCell(currentIndex++); // Cột 2: Mã khách hàng (không dùng)
                Cell cellTenKH = currentRow.getCell(currentIndex++); // Cột 3: Tên khách hàng
                Cell cellGioiTinh = currentRow.getCell(currentIndex++); // Cột 4: Giới tính
                Cell cellSdtKH = currentRow.getCell(currentIndex++); // Cột 5: Số điện thoại
                Cell cellNgaySinh = currentRow.getCell(currentIndex++); // Cột 6: Ngày sinh
                Cell cellEmail = currentRow.getCell(currentIndex++); // Cột 7: Email
                Cell cellMaSoThue = currentRow.getCell(currentIndex++); // Cột 8: Mã số thuế
                Cell cellDiaChi = currentRow.getCell(currentIndex++); // Cột 9: Địa chỉ
                Cell cellLoaiKH = currentRow.getCell(currentIndex++); // Cột 10: Loại khách hàng

                // Kiểm tra và lấy giá trị từ các ô
                String maKH = cellMaKH != null ? getStringValue(cellMaKH) : "";
                String tenKH = cellTenKH != null ? getStringValue(cellTenKH) : "";
                String gioiTinh = cellGioiTinh != null ? getStringValue(cellGioiTinh) : "";
                String sdtKH = cellSdtKH != null ? getStringValue(cellSdtKH) : "";
                String ngaySinh = cellNgaySinh != null ? getStringValue(cellNgaySinh) : "";
                String email = cellEmail != null ? getStringValue(cellEmail) : "";
                String maSoThue = cellMaSoThue != null ? getStringValue(cellMaSoThue) : "";
                String diaChi = cellDiaChi != null ? getStringValue(cellDiaChi) : "";
                String loaiKH = cellLoaiKH != null ? getStringValue(cellLoaiKH) : "";

                // Kiểm tra dữ liệu trống
                if (tenKH.isEmpty() || gioiTinh.isEmpty() || sdtKH.isEmpty() || ngaySinh.isEmpty() || email.isEmpty() || diaChi.isEmpty() || loaiKH.isEmpty()) {
                    errors.add("Hàng " + (currentRow.getRowNum() + 1) + ": Có dữ liệu trống.");
                    continue;
                }

                LocalDate ngayht = LocalDate.now();
                try {
                    // Kiểm tra định dạng ngày trước khi parse
                    if (!ngaySinh.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        errors.add("Hàng " + (currentRow.getRowNum() + 1) + ": Ngày sinh '" + ngaySinh + "' không đúng định dạng yyyy-MM-dd.");
                        continue;
                    }
                    LocalDate ngaySinhDate = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    KhachHang khachHang = new KhachHang(maKHList.get(maIndex), tenKH, sdtKH, ngaySinhDate, gioiTinh, email, maSoThue, diaChi, loaiKH);
                    customerList.add(khachHang);
                    maIndex++;
                } catch (Exception e) {
                    errors.add("Hàng " + (currentRow.getRowNum() + 1) + ": Lỗi dữ liệu - " + e.getMessage());
                    continue;
                }
            }
        } catch (Exception e) {
            errors.add("Lỗi khi đọc dữ liệu từ file Excel: " + e.getMessage());
            e.printStackTrace();
        }

        // Hiển thị tất cả lỗi (nếu có)
        if (!errors.isEmpty()) {
            JOptionPane.showMessageDialog(null, String.join("\n", errors), "Lỗi dữ liệu", JOptionPane.ERROR_MESSAGE);
        }

        // Thông báo kết quả
        if (customerList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu hợp lệ nào được đọc từ file Excel.");
        } else {
            JOptionPane.showMessageDialog(null, "Đã đọc được " + customerList.size() + " khách hàng từ file Excel.");
        }

        return customerList;
    }

    private String getStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        // Sử dụng DataFormatter để lấy giá trị dưới dạng chuỗi giống như hiển thị trong Excel
        org.apache.poi.ss.usermodel.DataFormatter formatter = new org.apache.poi.ss.usermodel.DataFormatter();
        return formatter.formatCellValue(cell);
    }

    private void btnExportKHActionPerformed(ActionEvent evt) {
        List<KhachHang> list = khachHangBus.getAllKhachHang();
        try {
            // Kiểm tra danh sách rỗng
            if (list == null || list.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Danh sách khách hàng rỗng!");
                return;
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu trữ file Excel");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();

                // Kiểm tra và thêm đuôi .xlsx nếu chưa có
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath = filePath + ".xlsx";
                    fileToSave = new File(filePath);
                }

                XSSFWorkbook workBook = new XSSFWorkbook();
                XSSFSheet sheet = workBook.createSheet("Danh sách khách hàng");
                XSSFRow row = null;
                Cell cell = null;

                // Tạo dòng tiêu đề và áp dụng CellStyle
                XSSFCellStyle headerStyle = workBook.createCellStyle();
                headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                row = sheet.createRow(0);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Mã khách hàng");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Tên khách hàng");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Giới tính");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Số điện thoại");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Ngày sinh");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("Email");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue("Mã số thuế");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue("Địa chỉ");
                cell.setCellStyle(headerStyle);

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue("Loại khách hàng");
                cell.setCellStyle(headerStyle);

                // Định dạng ngày sinh
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                // Tạo dòng dữ liệu từ dòng 1
                for (int i = 0; i < list.size(); i++) {
                    row = sheet.createRow(1 + i);
                    cell = row.createCell(0, CellType.NUMERIC);
                    cell.setCellValue(i + 1);

                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(list.get(i).getKhachHangID());

                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(list.get(i).getHoTen());

                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(list.get(i).getGioiTinh());

                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue(list.get(i).getSoDienThoai());

                    // Xử lý ngày sinh
                    cell = row.createCell(5, CellType.STRING);
                    LocalDate ngaySinh = list.get(i).getNgaySinh();
                    if (ngaySinh != null) {
                        Date date = Date.from(ngaySinh.atStartOfDay(ZoneId.systemDefault()).toInstant());
                        cell.setCellValue(dateFormat.format(date));
                    } else {
                        cell.setCellValue("");
                    }

                    cell = row.createCell(6, CellType.STRING);
                    cell.setCellValue(list.get(i).getEmail());

                    cell = row.createCell(7, CellType.STRING);
                    cell.setCellValue(list.get(i).getMaSoThue());

                    cell = row.createCell(8, CellType.STRING);
                    cell.setCellValue(list.get(i).getDiaChi());

                    cell = row.createCell(9, CellType.STRING);
                    cell.setCellValue(list.get(i).getLoaiKhachHang());
                }

                // Lưu file
                FileOutputStream fis = new FileOutputStream(fileToSave);
                workBook.write(fis);
                fis.close();
                workBook.close();

                JOptionPane.showMessageDialog(this, "Xuất file thành công: " + filePath);
            } else {
                JOptionPane.showMessageDialog(this, "Xuất file thất bại: Không chọn nơi lưu trữ.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi xuất file: " + e.getMessage());
        }
    }

	private void btnDangXuatKHActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnDangXuatKHActionPerformed
		KhachHang_BUS khachHangBus = new KhachHang_BUS();
	    int selectedRow = tblKhachHang.getSelectedRow();

	    try {
	        String maKhachHang = tblKhachHang.getValueAt(selectedRow, 1).toString();
	        String hoTenKhachHang = tblKhachHang.getValueAt(selectedRow, 2).toString();
	        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn khách hàng này là Đặc Biệt?", "Xác nhận",
	                JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	        	
	          if(khachHangBus.chuyenLoaiKhachHang(maKhachHang, "DAC BIET")) {
	        	  loadKhachHangTable();
	        	  JOptionPane.showMessageDialog(this, "Đã chuyển thành khách hàng đặc biệt thành công " );
	          }
	           
	           ; 
	        }
	    } catch (Exception e) {
	     
	        JOptionPane.showMessageDialog(this, "Vui Long chon lai: ");
	    }
	}// GEN-LAST:event_btnDangXuatKHActionPerformed
	public void phimTatTimKien() {
		javax.swing.InputMap inputMap =btnTimKiemKH.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
		javax.swing.ActionMap actionMap = btnTimKiemKH.getActionMap();
		javax.swing.KeyStroke enterKey = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,0);
		inputMap.put(enterKey, "thuchienclick");
		actionMap.put("performClick",new javax.swing.AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnTimKiemKH.doClick();
			}
			
		});
	}
	private void txtMa1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_txtMa1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtMa1ActionPerformed

	private void txtTen1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_txtTen1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTen1ActionPerformed

	private void txtSDT1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_txtSDT1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSDT1ActionPerformed

	private void cboLoaiKHActionPerformed(ActionEvent evt) {// GEN-FIRST:event_cboLoaiKHActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cboLoaiKHActionPerformed

	private void txtMaSoThueActionPerformed(ActionEvent evt) {// GEN-FIRST:event_txtMaSoThueActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtMaSoThueActionPerformed

	private void txtDiaChiActionPerformed(ActionEvent evt) {// GEN-FIRST:event_txtDiaChiActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtDiaChiActionPerformed

	private void txtEmailActionPerformed(ActionEvent evt) {// GEN-FIRST:event_txtEmailActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtEmailActionPerformed

	private void txtTenActionPerformed(ActionEvent evt) {// GEN-FIRST:event_txtTenActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTenActionPerformed

	private void txtSDTActionPerformed(ActionEvent evt) {// GEN-FIRST:event_txtSDTActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSDTActionPerformed

	private void cboGioiTinh1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_cboGioiTinh1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cboGioiTinh1ActionPerformed

	private void cboLoaiKH1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_cboLoaiKH1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cboLoaiKH1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton btnExportKH;
    private javax.swing.JButton btnHienThiBang;
    private javax.swing.JButton btnImportKH;
    private javax.swing.JButton btnSuaKH;
    private javax.swing.JPanel btnThem;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnTimKiemKH;
    private javax.swing.JButton btnXoaRong;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboGioiTinh1;
    private javax.swing.JComboBox<String> cboLoaiKH;
    private javax.swing.JComboBox<String> cboLoaiKH1;
    private com.toedter.calendar.JDateChooser dtmNgaySinh;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel right;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMa1;
    private javax.swing.JTextField txtMaSoThue;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDT1;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTen1;
    // End of variables declaration//GEN-END:variables
}
