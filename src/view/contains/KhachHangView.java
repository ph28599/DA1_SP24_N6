/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
<<<<<<< HEAD
import javax.swing.table.DefaultTableModel;
import repository.KhachHang_Repository;
import service.KhachHang_Service;
import service.impl.KhachHang_Impl;
=======
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangTichDiem;
import model.KhachHang;
import repository.KhachHangRepository;
import service.BangTichDiemService;
import service.KhachHangService;
import service.impl.BangTichDiemImpl;
import service.impl.KhachHangServiceImpl;
import viewmodel.QLBangTichDiem;
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
import viewmodel.QLKhachHang;

/**
 *
 * @author hieu
 */
public class KhachHangView extends javax.swing.JPanel {
<<<<<<< HEAD

    DefaultTableModel defaultTableModel;
    KhachHang_Repository repository = new KhachHang_Repository();
    KhachHang_Service service = new KhachHang_Impl();
=======
DefaultTableModel defaultTableModel;
    KhachHangRepository repository = new KhachHangRepository();
    KhachHangService service = new KhachHangServiceImpl();
    BangTichDiemService bangTichDiemService = new BangTichDiemImpl();
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
    QLKhachHang kh = new QLKhachHang();
    String ma = "";
    String ten = "";
    String email = "";
    String sdt = "";
<<<<<<< HEAD

=======
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
    /**
     * Creates new form KhachHangView
     */
    
    public KhachHangView() {
        initComponents();
        loadDataTable(service.getList());
    }
<<<<<<< HEAD

    public void loadDataTable(ArrayList<QLKhachHang> listKH) {
=======
    
        public void loadDataTable(ArrayList<QLKhachHang> listKH) {
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : listKH) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
<<<<<<< HEAD
=======

    }
        
        private boolean validateThem() {
//        if (txtMa.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
//                || txtSDT.getText().trim().isEmpty() || dateNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Thông tin không để trống");
//            return false;
//        }
//        for (QLKhachHang kh : service.getList()) {
//            if (txtMa.getText().trim().equals(kh.getMa())) {
//                JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
//                return false;
//            }
//        }
//        return true;


 // Kiểm tra trường thông tin có trống không
    if (txtMaKH.getText().trim().isEmpty() || txtHoTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
            || txtSDT.getText().trim().isEmpty() || jdcNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Thông tin không để trống");
        return false;
    }

    // Kiểm tra định dạng email
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    if (!txtEmail.getText().trim().matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Email không hợp lệ");
        return false;
    }

    // Kiểm tra định dạng số điện thoại
    String sdtRegex = "^[0][0-9]{9}$";
    if (!txtSDT.getText().trim().matches(sdtRegex)) {
        JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
        return false;
    }

    // Kiểm tra mã khách hàng đã tồn tại
    for (QLKhachHang kh : service.getList()) {
        if (txtMaKH.getText().trim().equals(kh.getMa())) {
            JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
            return false;
        }
    }

    // Nếu tất cả đều hợp lệ
    return true;
    }

    private boolean validateSua() {
//        if (txtMa.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
//                || txtSDT.getText().trim().isEmpty() || dateNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Thông tin không để trống");
//            return false;
//        }
//
//        return true;


          // Kiểm tra trường thông tin có trống không
    if (txtMaKH.getText().trim().isEmpty() || txtHoTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
            || txtSDT.getText().trim().isEmpty() || jdcNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Thông tin không để trống");
        return false;
    }

    // Kiểm tra định dạng email
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    if (!txtEmail.getText().trim().matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Email không hợp lệ");
        return false;
    }

    // Kiểm tra định dạng số điện thoại
    String sdtRegex = "^[0][0-9]{9}$";
    if (!txtSDT.getText().trim().matches(sdtRegex)) {
        JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
        return false;
    }
        return true;
    }
    
    public void TimTheoMa() {
        String ma = txtTimKhachHang.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoMa(ma)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoTen() {
        String ten = txtTimKhachHang.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoTen(ten)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoEmail() {
        String email = txtTimKhachHang.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoEmail(email)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoSDT() {
        String sdt = txtTimKhachHang.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoSDT(sdt)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }
    
    public void Clear() {
        txtMaKH.setText("");
        txtHoTen.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        buttonGroup1.clearSelection();
        jdcNgaySinh.setDate(null);
        chkTrangThai.setSelected(false);
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel26 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
<<<<<<< HEAD
        txtTen = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
=======
        txtHoTen = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        chkTrangThai = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
<<<<<<< HEAD
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnMoi1 = new javax.swing.JButton();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();
=======
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
<<<<<<< HEAD
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
=======
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTimKhachHang = new javax.swing.JTextField();
        cbbTimKhachHang = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        rdoNam2 = new javax.swing.JRadioButton();
        rdoNu2 = new javax.swing.JRadioButton();
        txtNgaySinh2 = new javax.swing.JTextField();
        txtDiaChi2 = new javax.swing.JTextField();
        cbTrangThai1 = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        btnThem2 = new javax.swing.JButton();
        btnSua2 = new javax.swing.JButton();
        btnMoi2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        lbMaTichDiem = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbDiemTich = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbTiemDuocGiam = new javax.swing.JLabel();

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("Thông tin khách hàng:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setText("Danh sách khách hàng:");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Họ & tên:");

<<<<<<< HEAD
        txtTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
=======
        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Mã khách hàng:");

<<<<<<< HEAD
        txtMa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
=======
        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Giới tính:");

        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Ngày sinh:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Địa chỉ:");

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Trạng thái:");

        chkTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Đã Thanh Toán");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Text.png"))); // NOI18N
        btnClear.setText("Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        jdcNgaySinh.setDateFormatString("dd-MM-yyyy");
=======
        dateNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        dateNgaySinh.setDateFormatString("yyyy-MM-dd");
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
<<<<<<< HEAD
                    .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING)
=======
                    .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(txtEmail))
                .addGap(53, 53, 53)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel17)
                    .addComponent(jLabel9))
                .addGap(56, 56, 56)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
<<<<<<< HEAD
                        .addComponent(rdoNam)
                        .addGap(32, 32, 32)
                        .addComponent(rdoNu))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(chkTrangThai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jdcNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(79, 79, 79)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
=======
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
<<<<<<< HEAD
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(rdoNam)
                                        .addGap(32, 32, 32)
                                        .addComponent(rdoNu))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(cbTrangThai)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(79, 79, 79))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(dateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem1)))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
=======
                                .addComponent(rdoNam)
                                .addGap(32, 32, 32)
                                .addComponent(rdoNu))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(chkTrangThai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem)))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
<<<<<<< HEAD
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
=======
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu)
<<<<<<< HEAD
                        .addComponent(btnThem1)))
=======
                        .addComponent(btnThem)))
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
<<<<<<< HEAD
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21)))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
=======
                                .addGap(23, 23, 23)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
<<<<<<< HEAD
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
=======
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)))
                        .addGap(26, 26, 26)
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addComponent(chkTrangThai))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(55, 55, 55))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Tìm khách hàng:");

        txtTimKhachHang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKhachHangActionPerformed(evt);
            }
        });

        cbbTimKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Họ Tên", "Email", "SDT" }));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Họ tên", "Email", "SDT", "Giới tính", "Ngày sinh", "Địa chỉ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbTimKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addContainerGap(375, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
<<<<<<< HEAD
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
=======
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTimKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTimKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addContainerGap(421, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("Bảng tích điểm:");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rdoNam2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNam2.setSelected(true);
        rdoNam2.setText("Nam");

        rdoNu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNu2.setText("Nữ");

        txtNgaySinh2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDiaChi2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cbTrangThai1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Đã Thanh Toán");

        btnThem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem2.setText("Thêm");
        btnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem2ActionPerformed(evt);
            }
        });

        btnSua2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua2.setText("Sửa");
        btnSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua2ActionPerformed(evt);
            }
        });

        btnMoi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Text.png"))); // NOI18N
        btnMoi2.setText("Mới");
        btnMoi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi2ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Mã :");

        lbMaTichDiem.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbMaTichDiem.setForeground(new java.awt.Color(51, 0, 255));
        lbMaTichDiem.setText("Mã");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Điểm tích được : ");

        lbDiemTich.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbDiemTich.setForeground(new java.awt.Color(51, 0, 255));
        lbDiemTich.setText("Điểm tích");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Tiền được giảm :");

        lbTiemDuocGiam.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbTiemDuocGiam.setForeground(new java.awt.Color(51, 0, 255));
        lbTiemDuocGiam.setText("Tiền giảm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel29))
                    .addComponent(jLabel18))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaTichDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTiemDuocGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiemTich, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(247, 247, 247)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNgaySinh2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(txtDiaChi2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cbTrangThai1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rdoNam2)
                        .addGap(31, 31, 31)
                        .addComponent(rdoNu2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMoi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam2)
                            .addComponent(rdoNu2)
                            .addComponent(btnThem2))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnSua2))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(lbMaTichDiem))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(lbDiemTich))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(lbTiemDuocGiam))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txtDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTrangThai1)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnMoi2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
<<<<<<< HEAD
                .addContainerGap(903, Short.MAX_VALUE)
=======
<<<<<<< HEAD
                .addContainerGap(521, Short.MAX_VALUE)
                .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                .addContainerGap(527, Short.MAX_VALUE)
                .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
                .addGap(196, 196, 196)
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
<<<<<<< HEAD
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(393, Short.MAX_VALUE)))
=======
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(383, Short.MAX_VALUE)))
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
<<<<<<< HEAD
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(541, Short.MAX_VALUE))
=======
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(540, Short.MAX_VALUE))
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel26)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel23)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
KhachHang kh = new KhachHang();
        if (validateThem()) {
            kh.setMa(txtMaKH.getText().trim());
            kh.setTen(txtHoTen.getText().trim());
            kh.setEmail(txtEmail.getText().trim());
            kh.setSdt(txtSDT.getText().trim());
            int gioiTinh = 0;
            if (rdoNam.isSelected() == true) {
                gioiTinh = 1;
            }
            kh.setGioiTinh(gioiTinh);
            kh.setNgaySinh(jdcNgaySinh.getDate());
            kh.setDiaChi(txtDiaChi.getText().trim());
            int trangThai = 0;
            if (chkTrangThai.isSelected() == true) {
                trangThai = 1;
            }
            kh.setTrangThai(trangThai);
            service.Them(kh);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataTable(service.getList());
            int id = 0;
            for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
                if (txtMaKH.getText().equalsIgnoreCase(tblKhachHang.getValueAt(i, 1).toString())) {
                    id = (int) tblKhachHang.getValueAt(i, 0);
                }
            }

            BangTichDiem bd = new BangTichDiem();
            bd.setIdKH(id);
            bd.setMa("BTD" + id);
            bd.setDiemTich(0);
            bd.setTienDuocGiam(0);
            bangTichDiemService.Them(bd);
            lbMaTichDiem.setText(bd.getMa());
            lbDiemTich.setText(String.valueOf(bd.getDiemTich()));
            lbTiemDuocGiam.setText(String.valueOf(bd.getTienDuocGiam()));
            Clear();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
int selectedRow = tblKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chọn khách hàng cần sửa thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int id = (int) tblKhachHang.getValueAt(selectedRow, 0);
            if (validateSua()) {
                KhachHang kh = new KhachHang();
                kh.setMa(txtMaKH.getText().trim());
                kh.setTen(txtHoTen.getText().trim());
                kh.setEmail(txtEmail.getText().trim());
                kh.setSdt(txtSDT.getText().trim());
                int gioiTinh = 0;
                if (rdoNam.isSelected()) {
                    gioiTinh = 1;
                }
                kh.setGioiTinh(gioiTinh);
                kh.setNgaySinh(jdcNgaySinh.getDate());
                kh.setDiaChi(txtDiaChi.getText().trim());
                int trangThai = 0;
                if (chkTrangThai.isSelected()) {
                    trangThai = 1;
                }
                kh.setTrangThai(trangThai);
                service.Sua(id, kh);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loadDataTable(service.getList());
                Clear();
            }
          
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
           Clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtTimKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKhachHangActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
   if (cbbTimKhachHang.getSelectedItem().equals("Mã")) {
            TimTheoMa();
        } else if (cbbTimKhachHang.getSelectedItem().equals("Họ Tên")) {
            TimTheoTen();
        } else if (cbbTimKhachHang.getSelectedItem().equals("Email")) {
            TimTheoEmail();
        } else if (cbbTimKhachHang.getSelectedItem().equals("SDT")) {
            TimTheoSDT();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
//        int index = tblKhachHang.getSelectedRow();
//        txtMa.setText(tblKhachHang.getValueAt(index, 1).toString());
//        txtTen.setText(tblKhachHang.getValueAt(index, 2).toString());
//        txtEmail.setText(tblKhachHang.getValueAt(index, 3).toString());
//        txtSDT.setText(tblKhachHang.getValueAt(index, 4).toString());
//        if (tblKhachHang.getValueAt(index, 5).toString().equalsIgnoreCase("Nam")) {
//            rdNam.setSelected(true);
//        }
//        if (tblKhachHang.getValueAt(index, 5).toString().equalsIgnoreCase("Nữ")) {
//            rdNu.setSelected(true);
//        }
//        String NgaySinh = tblKhachHang.getValueAt(index, 6).toString();
//        DateFormat dateFomat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date ngSinh = dateFomat.parse(NgaySinh);
//            dateNgaySinh.setDate(ngSinh);
//        } catch (Exception e) {
//        }
//        txtDiaChi.setText(tblKhachHang.getValueAt(index, 7).toString());
//        if (tblKhachHang.getValueAt(index, 8).toString().equalsIgnoreCase("Đã thanh toán")) {
//            cbTrangThai.setSelected(true);
//        }
//        if (tblKhachHang.getValueAt(index, 8).toString().equalsIgnoreCase("Chưa thanh toán")) {
//            cbTrangThai.setSelected(false);
//        }
//
//        int id = (int) tblKhachHang.getValueAt(index, 0);
//        for (QLBangTichDiem btd : bangTichDiemService.getList()) {
//            if (btd.getIdKH() == id) {
//                lbMaTichDiem.setText(btd.getMa());
//                lbDiemTich.setText(String.valueOf(btd.getDiemTich()));
//                lbTiemDuocGiam.setText(String.valueOf(btd.getTienDuocGiam()));
//            }
//        }
//         int index = tblKhachHang.getSelectedRow();
//
//        if (index != -1) { // Kiểm tra xem đã chọn hàng nào chưa
//        txtMa.setText(getCellValue(index, 1));
//        txtTen.setText(getCellValue(index, 2));
//        txtEmail.setText(getCellValue(index, 3));
//        txtSDT.setText(getCellValue(index, 4));
//
//        String gioiTinhValue = getCellValue(index, 5);
//        if (gioiTinhValue != null) {
//            if (gioiTinhValue.equalsIgnoreCase("Nam")) {
//                rdNam.setSelected(true);
//            } else if (gioiTinhValue.equalsIgnoreCase("Nữ")) {
//                rdNu.setSelected(true);
//            }
//        }
//
//        String ngaySinhValue = getCellValue(index, 6);
//        if (ngaySinhValue != null) {
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                Date ngSinh = dateFormat.parse(ngaySinhValue);
//                dateNgaySinh.setDate(ngSinh);
//            } catch (Exception e) {
//                e.printStackTrace(); // Xử lý nếu có lỗi parse ngày
//            }
//        }
//
//        txtDiaChi.setText(getCellValue(index, 7));
//
//        String trangThaiValue = getCellValue(index, 8);
//        if (trangThaiValue != null) {
//            cbTrangThai.setSelected(trangThaiValue.equalsIgnoreCase("Đã thanh toán"));
//        }
//
//        int id = (int) tblKhachHang.getValueAt(index, 0);
//        for (QLBangTichDiem btd : bangTichDiemService.getList()) {
//            if (btd.getIdKH() == id) {
//                lbMaTichDiem.setText(btd.getMa());
//                lbDiemTich.setText(String.valueOf(btd.getDiemTich()));
//                lbTiemDuocGiam.setText(String.valueOf(btd.getTienDuocGiam()));
//            }
//        }
//    }

<<<<<<< HEAD
        int index = tblKhachHang.getSelectedRow();
=======
       int index = tblKhachHang.getSelectedRow();
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
        if (index != -1) {  // Kiểm tra xem một dòng có được chọn không
            Object maValue = tblKhachHang.getValueAt(index, 1);
            Object tenValue = tblKhachHang.getValueAt(index, 2);
            Object emailValue = tblKhachHang.getValueAt(index, 3);
            Object sdtValue = tblKhachHang.getValueAt(index, 4);
            Object gioiTinhValue = tblKhachHang.getValueAt(index, 5);
            Object ngaySinhValue = tblKhachHang.getValueAt(index, 6);
            Object diaChiValue = tblKhachHang.getValueAt(index, 7);
            Object trangThaiValue = tblKhachHang.getValueAt(index, 8);

            // Kiểm tra và đặt giá trị cho ô text
<<<<<<< HEAD
            txtMa.setText((maValue != null) ? maValue.toString() : "");
            txtTen.setText((tenValue != null) ? tenValue.toString() : "");
=======
            txtMaKH.setText((maValue != null) ? maValue.toString() : "");
            txtHoTen.setText((tenValue != null) ? tenValue.toString() : "");
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
            txtEmail.setText((emailValue != null) ? emailValue.toString() : "");
            txtSDT.setText((sdtValue != null) ? sdtValue.toString() : "");

            if (gioiTinhValue != null) {
                String gioiTinh = gioiTinhValue.toString();
                if (gioiTinh.equalsIgnoreCase("Nam")) {
                    rdoNam.setSelected(true);
                } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
                    rdoNu.setSelected(true);
                }
            }
<<<<<<< HEAD
            if (ngaySinhValue != null) {
=======
        if (ngaySinhValue != null) {
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
                String NgaySinh = ngaySinhValue.toString();
                if (!NgaySinh.isEmpty()) {
                    // Kiểm tra xem ngày sinh có giá trị không trống
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date ngSinh = dateFormat.parse(NgaySinh);
<<<<<<< HEAD
                        dateNgaySinh.setDate(ngSinh);
=======
                        jdcNgaySinh.setDate(ngSinh);
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
                    } catch (Exception e) {
                        e.printStackTrace();  // Thực hiện xử lý nếu có lỗi parse ngày sinh
                    }
                } else {
                    // Nếu giá trị là rỗng, đặt JCalendar về trạng thái không chọn ngày nào
<<<<<<< HEAD
                    dateNgaySinh.setDate(null);
                }
            } else {
                // Nếu giá trị là null, đặt JCalendar về trạng thái không chọn ngày nào
                dateNgaySinh.setDate(null);
=======
                    jdcNgaySinh.setDate(null);
                }
            } else {
                // Nếu giá trị là null, đặt JCalendar về trạng thái không chọn ngày nào
                jdcNgaySinh.setDate(null);
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
            }
            txtDiaChi.setText((diaChiValue != null) ? diaChiValue.toString() : "");

            if (trangThaiValue != null) {
                String trangThai = trangThaiValue.toString();
<<<<<<< HEAD
                cbTrangThai.setSelected(trangThai.equalsIgnoreCase("Đã thanh toán"));
            }

//            int id = (int) tblKhachHang.getValueAt(index, 0);
//            for (QLBangTichDiem btd : bangTichDiemService.getList()) {
//                if (btd.getIdKH() == id) {
//                    lbMaTichDiem.setText(btd.getMa());
//                    lbDiemTich.setText(String.valueOf(btd.getDiemTich()));
//                    lbTiemDuocGiam.setText(String.valueOf(btd.getTienDuocGiam()));
//                }
//            }
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

     private String getCellValue(int rowIndex, int colIndex) {
=======
                chkTrangThai.setSelected(trangThai.equalsIgnoreCase("Đã thanh toán"));
            }

            int id = (int) tblKhachHang.getValueAt(index, 0);
            for (QLBangTichDiem btd : bangTichDiemService.getList()) {
                if (btd.getIdKH() == id) {
                    lbMaTichDiem.setText(btd.getMa());
                    lbDiemTich.setText(String.valueOf(btd.getDiemTich()));
                    lbTiemDuocGiam.setText(String.valueOf(btd.getTienDuocGiam()));
                }
            }
            }
    }//GEN-LAST:event_tblKhachHangMouseClicked
    private String getCellValue(int rowIndex, int colIndex) {
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
        Object value = tblKhachHang.getValueAt(rowIndex, colIndex);
        return (value != null) ? value.toString() : null;
    }
    private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem2ActionPerformed

    private void btnSua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSua2ActionPerformed

    private void btnMoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoi2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnMoi2;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua2;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem2;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbTrangThai1;
<<<<<<< HEAD
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private javax.swing.JComboBox<String> jComboBox1;
=======
    private javax.swing.JComboBox<String> cbbTimKhachHang;
    private javax.swing.JCheckBox chkTrangThai;
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JLabel lbDiemTich;
    private javax.swing.JLabel lbMaTichDiem;
    private javax.swing.JLabel lbTiemDuocGiam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNam2;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoNu2;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaChi2;
    private javax.swing.JTextField txtEmail;
<<<<<<< HEAD
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaySinh2;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
=======
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgaySinh2;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKhachHang;
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
    // End of variables declaration//GEN-END:variables
}
