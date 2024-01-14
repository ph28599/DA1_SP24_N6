/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPhamModel;
import service.ICTSPService;
import service.IChatLieuService;
import service.ILoaiAoService;
import service.IMauSacService;
import service.ISanPhamSevice;
import service.ISizeService;
import service.IThuongHieuService;
import service.impl.CTSPServiceImpl;
import service.impl.ChatLieuServiceImpl;
import service.impl.LoaiAoServiceImpl;
import service.impl.MauSacServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.SizeServiceImpl;
import service.impl.ThuongHieuServiceImpl;
import view.contains.thuoctinhsanpham.ViewChatLieu;
import view.contains.thuoctinhsanpham.ViewLoaiAo;
import view.contains.thuoctinhsanpham.ViewMauSac;
import view.contains.thuoctinhsanpham.ViewSize;
import view.contains.thuoctinhsanpham.ViewThuongHieu;
import viewmodel.CTSPViewModel;
import viewmodel.ChatLieuViewMoel;
import viewmodel.ChiTietSanPhamViewModel;
import viewmodel.LoaiAoViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.SanPhamViewModel;
import viewmodel.SizeViewModel;
import viewmodel.ThuongHieuViewModel;

/**
 *
 * @author LAPTOP24H
 */
public class SanPhamJpanel extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private ICTSPService iCTSPService = new CTSPServiceImpl();

    //list tb SPCT
    private List<ChiTietSanPhamViewModel> listCTSPTable = new ArrayList<>();

    //fix
    private List<ChatLieuViewMoel> listCL = new ArrayList<>();
    private IChatLieuService ichatLieuService = new ChatLieuServiceImpl();
    private List<String> listCbbCL = new ArrayList<>();
    private DefaultComboBoxModel dcbCL = new DefaultComboBoxModel();

    private List<SizeViewModel> listKC = new ArrayList<>();
    private ISizeService iSizeService = new SizeServiceImpl();
    private List<String> listCbbKC = new ArrayList<>();
    private DefaultComboBoxModel dcbKC = new DefaultComboBoxModel();

    private List<SanPhamViewModel> listSP = new ArrayList<>();
    private ISanPhamSevice iSanPhamSevice = new SanPhamServiceImpl();
    private List<String> listCbbSP = new ArrayList<>();
    private DefaultComboBoxModel dcbSP = new DefaultComboBoxModel();

    private List<LoaiAoViewModel> listLA = new ArrayList<>();
    private ILoaiAoService iLoaiAoService = new LoaiAoServiceImpl();
    private List<String> listCbbLA = new ArrayList<>();
    private DefaultComboBoxModel dcbLA = new DefaultComboBoxModel();

    private List<MauSacViewModel> listMS = new ArrayList<>();
    private IMauSacService iMauSacService = new MauSacServiceImpl();
    private List<String> listCbbMS = new ArrayList<>();
    private DefaultComboBoxModel dcbMS = new DefaultComboBoxModel();

    private List<ThuongHieuViewModel> listTH = new ArrayList<>();
    private IThuongHieuService iThuongHieuService = new ThuongHieuServiceImpl();
    private List<String> listCbbTH = new ArrayList<>();
    private DefaultComboBoxModel dcbTH = new DefaultComboBoxModel();

    /**
     * Creates new form SanPhamJpanel
     */
    public SanPhamJpanel() {
        initComponents();
        listCTSPTable = iCTSPService.getAllTale();
        load(listCTSPTable);
        //load table

        listSP = iSanPhamSevice.getAll();
        listTH = iThuongHieuService.getAll();
        listLA = iLoaiAoService.getAll();
        listKC = iSizeService.getAll();
        listMS = iMauSacService.getAll();
        listCL = ichatLieuService.getAll();

        //load cbb sp
        dcbSP = (DefaultComboBoxModel) this.cbbSanPham.getModel();
        listCbbSP.add("");
        for (SanPhamViewModel sp : listSP) {
            listCbbSP.add(sp.getTen());
        }
        showDataCBO(listCbbSP, dcbSP);
        //load cbb th
        dcbTH = (DefaultComboBoxModel) this.cbbThuongHieu.getModel();
        listCbbTH.add("");
        for (ThuongHieuViewModel sp : listTH) {
            listCbbTH.add(sp.getTen());
        }
        showDataCBO(listCbbTH, dcbTH);
        //load cbb loai ao
        dcbLA = (DefaultComboBoxModel) this.cbbLoaiAo.getModel();
        listCbbLA.add("");
        for (LoaiAoViewModel sp : listLA) {
            listCbbLA.add(sp.getTen());
        }
        showDataCBO(listCbbLA, dcbLA);
        //load cbb kc

        dcbKC = (DefaultComboBoxModel) this.cbbKichCo.getModel();
        listCbbKC.add("");
        for (SizeViewModel sp : listKC) {
            listCbbKC.add(sp.getTen());
        }
        showDataCBO(listCbbKC, dcbKC);
        //load cbb ms
        dcbMS = (DefaultComboBoxModel) this.cbbMauSac.getModel();
        listCbbMS.add("");
        for (MauSacViewModel sp : listMS) {
            listCbbMS.add(sp.getTen());
        }
        showDataCBO(listCbbMS, dcbMS);
        //load CL
        dcbCL = (DefaultComboBoxModel) this.cbbChatLieu.getModel();
        listCbbCL.add("");
        for (ChatLieuViewMoel sp : listCL) {
            listCbbCL.add(sp.getTen());
        }
        showDataCBO(listCbbCL, dcbCL);

    }

    public void load(List<ChiTietSanPhamViewModel> list) {
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tb.getModel();
        for (ChiTietSanPhamViewModel chiTietSanPhamViewModel : list) {
            dtm.addRow(chiTietSanPhamViewModel.toDataRow());
        }
    }

    private void showDataCBO(List<String> lisString, DefaultComboBoxModel cbo) {
        for (String string : lisString) {
            cbo.addElement(string);
        }
    }

    //show data form
    public void showDataForm(int idex) {
        ChiTietSanPhamViewModel ctspvm = listCTSPTable.get(idex);
        txtMa.setText(ctspvm.getMa());
        txtMaVach.setText(ctspvm.getMaVach());
        cbbSanPham.setSelectedItem(ctspvm.getIdSP());
        cbbThuongHieu.setSelectedItem(ctspvm.getIdTH());
        cbbLoaiAo.setSelectedItem(ctspvm.getIdLA());
        cbbKichCo.setSelectedItem(ctspvm.getIdKC());
        cbbMauSac.setSelectedItem(ctspvm.getIdMS());
        cbbChatLieu.setSelectedItem(ctspvm.getIdCL());
        txtSoLuong.setText(String.valueOf(ctspvm.getSoLuong()));
        txtGiaNhap.setText(String.valueOf(ctspvm.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(ctspvm.getGiaBan()));
        ckbTrangThai.setSelected(ctspvm.isTrangThai());
        txtMoTa.setText(ctspvm.getMoTa());
    }

    public void fillData() {
        dtm = (DefaultTableModel) tb.getModel();
        ChiTietSanPhamViewModel ctspvm = new ChiTietSanPhamViewModel();
        int row = tb.getSelectedRow();
        txtMa.setText(tb.getValueAt(row, 0).toString());
        txtMaVach.setText(tb.getValueAt(row, 1).toString());
        txtMoTa.setText(tb.getValueAt(row, 2).toString());
        txtSoLuong.setText(String.valueOf(tb.getValueAt(row, 3).toString()));

//        defaultTableModel = (DefaultTableModel) TBL.getModel();
//        String vaiTroValue = TBL.getValueAt(row, 10).toString();
//        cbVaitro.setSelectedItem(vaiTroValue);
        dcbSP = (DefaultComboBoxModel) tb.getModel();
        String sp = tb.getValueAt(row, 4).toString();
        cbbSanPham.setSelectedItem(sp);

        String th = tb.getValueAt(row, 5).toString();
        cbbThuongHieu.setSelectedItem(th);

        String la = tb.getValueAt(row, 6).toString();
        cbbLoaiAo.setSelectedItem(la);

        String kc = tb.getValueAt(row, 7).toString();
        cbbKichCo.setSelectedItem(kc);

        String ms = tb.getValueAt(row, 8).toString();
        cbbMauSac.setSelectedItem(ms);

        String cl = tb.getValueAt(row, 8).toString();
        cbbChatLieu.setSelectedItem(cl);

//        cbbLoaiAo.setSelectedItem(tb.getValueAt(row, 6).toString());
//        cbbKichCo.setSelectedItem(tb.getValueAt(row, 7).toString());
//        cbbMauSac.setSelectedItem(tb.getValueAt(row, 8).toString());
//        cbbChatLieu.setSelectedItem(tb.getValueAt(row, 9).toString());
        txtGiaNhap.setText(String.valueOf(tb.getValueAt(row, 10).toString()));
        txtGiaBan.setText(String.valueOf(tb.getValueAt(row, 11).toString()));
        ckbTrangThai.setSelected(ctspvm.isTrangThai());

    }

    private CTSPViewModel add() {

        CTSPViewModel ctsp = new CTSPViewModel();
//        int i = listCTSPTable.size() - 1;
//        ctsp.setMa("SPCT" + listCTSPTable.get(i).getId());
        ctsp.setMa(txtMa.getText());
        ctsp.setMaVach(txtMaVach.getText());
        ctsp.setMoTa(txtMoTa.getText());
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

        for (SanPhamViewModel sp : listSP) {
            if (cbbSanPham.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdSP(sp.getId());
            }
        }

        for (ThuongHieuViewModel sp : listTH) {
            if (cbbThuongHieu.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdTH(sp.getId());
            }
        }

        for (LoaiAoViewModel sp : listLA) {
            if (cbbLoaiAo.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdLA(sp.getId());
            }
        }

        for (SizeViewModel sp : listKC) {
            if (cbbKichCo.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdKC(sp.getId());
            }
        }

        for (MauSacViewModel sp : listMS) {
            if (cbbMauSac.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdMS(sp.getId());
            }
        }

        for (ChatLieuViewMoel sp : listCL) {
            if (cbbChatLieu.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdCL(sp.getId());
            }
        }
        ctsp.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
        ctsp.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
        ctsp.setTrangThai(ckbTrangThai.isSelected());

        return ctsp;
    }

    public CTSPViewModel update() {
        CTSPViewModel ctsp = new CTSPViewModel();
        int i = listCTSPTable.size() - 1;
        ctsp.setMa("SPCT" + listCTSPTable.get(i).getId());
        // ctsp.setMa(txtMa.getText());
        ctsp.setMaVach(txtMaVach.getText());
        ctsp.setMoTa(txtMoTa.getText());
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

        for (SanPhamViewModel sp : listSP) {
            if (cbbSanPham.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdSP(sp.getId());
            }
        }

        for (ThuongHieuViewModel sp : listTH) {
            if (cbbThuongHieu.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdTH(sp.getId());
            }
        }

        for (LoaiAoViewModel sp : listLA) {
            if (cbbLoaiAo.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdLA(sp.getId());
            }
        }

        for (SizeViewModel sp : listKC) {
            if (cbbKichCo.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdKC(sp.getId());
            }
        }

        for (MauSacViewModel sp : listMS) {
            if (cbbMauSac.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdMS(sp.getId());
            }
        }

        for (ChatLieuViewMoel sp : listCL) {
            if (cbbChatLieu.getSelectedItem().equals(sp.getTen())) {
                ctsp.setIdCL(sp.getId());
            }
        }
        ctsp.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
        ctsp.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
        ctsp.setTrangThai(ckbTrangThai.isSelected());

        return ctsp;
    }

//    public CTSPViewModel getSP (int kieu){
//      
//        
//       
//    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbbLocSize = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbLocLoaiAo = new javax.swing.JComboBox<>();
        cbbLocCLieu = new javax.swing.JComboBox<>();
        cbbLocSanPham = new javax.swing.JComboBox<>();
        cbbLocMauSac = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLoc = new javax.swing.JButton();
        txtSerch = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbbLocTHieu = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        cbbLoaiAo = new javax.swing.JComboBox<>();
        btnSetFormLA = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        cbbThuongHieu = new javax.swing.JComboBox<>();
        btnSetFormTH = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        cbbKichCo = new javax.swing.JComboBox<>();
        btnSetFormKC = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        cbbMauSac = new javax.swing.JComboBox<>();
        btnSetFormMS = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        cbbChatLieu = new javax.swing.JComboBox<>();
        btnSetFormCL = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnLuuDS = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtMaVach = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbbSanPham = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        ckbTrangThai = new javax.swing.JCheckBox();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 400));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh Sách Sản Phẩm Chi Tiết");

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Mã Vạch", "Mô Tả", "Số Lượng", "Tên Sản Phẩm", "Thương Hiệu", "Loại Áo", "Kích Cỡ", "Màu Sắc", "Chất Liệu", "Giá Nhập", "Giá Bán", "Trạng Thái"
            }
        ));
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Lọc và Tìm Kiếm Sản Phẩm");

        jLabel4.setText("Size");

        jLabel5.setText("Màu Sắc");

        jLabel6.setText("Chất liệu");

        jLabel8.setText("Tên Sản Phẩm");

        jLabel9.setText("Thương Hiệu");

        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Zoom out.png"))); // NOI18N
        btnLoc.setText("Lọc");

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tìm Kiếm Theo Tên");

        jLabel17.setText("Loại Áo");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSetFormLA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnSetFormLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetFormLAActionPerformed(evt);
            }
        });

        jLabel46.setText("Loại Áo");

        jLabel47.setText("Thương Hiệu");

        btnSetFormTH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnSetFormTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetFormTHActionPerformed(evt);
            }
        });

        jLabel48.setText("Kích Cỡ");

        btnSetFormKC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnSetFormKC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetFormKCActionPerformed(evt);
            }
        });

        jLabel49.setText("Màu Sắc");

        btnSetFormMS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnSetFormMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetFormMSActionPerformed(evt);
            }
        });

        jLabel50.setText("Chất Liệu");

        btnSetFormCL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnSetFormCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetFormCLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel49)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSetFormMS)))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel46)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(cbbLoaiAo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSetFormLA))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSetFormTH))
                        .addComponent(jLabel47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel50)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSetFormCL))))
                .addGap(52, 52, 52)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(cbbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSetFormKC)))
                .addGap(52, 52, 52))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbChatLieu, cbbKichCo, cbbLoaiAo, cbbMauSac, cbbThuongHieu});

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSetFormCL, btnSetFormKC, btnSetFormLA, btnSetFormMS, btnSetFormTH});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSetFormLA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbLoaiAo)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSetFormKC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel47)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSetFormTH))))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSetFormMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSetFormCL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbChatLieu, cbbKichCo, cbbLoaiAo, cbbMauSac, cbbThuongHieu});

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSetFormCL, btnSetFormKC, btnSetFormLA, btnSetFormMS, btnSetFormTH});

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Thuộc Tính Sản Phẩm");

        jButton3.setText("Phân Trang");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(cbbLocSize, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLocTHieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cbbLocCLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbLocMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(25, 25, 25)
                                .addComponent(btnLoc)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiem)
                            .addComponent(txtSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(91, 91, 91))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLocLoaiAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbLocCLieu, cbbLocLoaiAo, cbbLocMauSac, cbbLocSanPham, cbbLocSize, cbbLocTHieu});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2)
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLocSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbLocMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))))
                    .addComponent(btnLoc)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtSerch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLocCLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocLoaiAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocTHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbLocCLieu, cbbLocLoaiAo, cbbLocMauSac, cbbLocSanPham, cbbLocSize, cbbLocTHieu, txtSerch});

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Gear.png"))); // NOI18N
        btnupdate.setText("Sửa");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Bar chart.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");

        btnLuuDS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLuuDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Computer.png"))); // NOI18N
        btnLuuDS.setText("Lưu DS SP");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnLuuDS)
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnupdate)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnupdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi)
                    .addComponent(btnLuuDS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Mã");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Thông Tin Sản Phẩm");

        jLabel12.setText("Mã Vạch");

        jLabel14.setText("Tên Sản Phẩm");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N

        jLabel15.setText("Số Lượng");

        jLabel16.setText("Giá Nhập");

        jLabel18.setText("Giá Bán");

        jLabel19.setText("Trạng Thái");

        jLabel20.setText("Mô tả ");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        ckbTrangThai.setText("Còn Hàng");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaVach)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckbTrangThai))
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtGiaBan, txtGiaNhap, txtMa, txtMaVach, txtSoLuong});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaVach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(ckbTrangThai))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel20))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtGiaBan, txtGiaNhap, txtMa, txtMaVach, txtSoLuong});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetFormLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetFormLAActionPerformed
//      new view.contains.thuoctinhsanpham.ViewLoaiAo().setVisible(true);
        ViewLoaiAo ao = new ViewLoaiAo();
        ao.setVisible(true);

        //setVisible(false);

    }//GEN-LAST:event_btnSetFormLAActionPerformed

    private void btnSetFormTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetFormTHActionPerformed
        // TODO add your handling code here:
        new ViewThuongHieu().setVisible(true);

    }//GEN-LAST:event_btnSetFormTHActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        // TODO add your handling code here:
        //  fillData();
        int index = tb.getSelectedRow();
        if (index >= 0 && index <= listCTSPTable.size()) {
            showDataForm(index);
        } else {
            // Xử lý khi không có phần tử nào được chọn hoặc danh sách rỗng
            System.out.println("Không có dữ liệu hoặc lựa chọn không hợp lệ");
        }
    }//GEN-LAST:event_tbMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        CTSPViewModel ctsp = add();
        JOptionPane.showMessageDialog(this, iCTSPService.add(ctsp));
        listCTSPTable = iCTSPService.getAllTale();
        load(listCTSPTable);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:

//        int index = tb.getSelectedRow();
//        //kiem tra
//        if (index >= 0 && index < listCTSPTable.size()) {
//            CTSPViewModel ctsp = update();
//            ChiTietSanPhamViewModel model = listCTSPTable.get(index);
//            JOptionPane.showMessageDialog(this, iCTSPService.getupdate(ctsp, model.getId()));
//            List<CTSPViewModel> ctsp3 = new ArrayList<>();
//            ctsp3.clear();
//            listCTSPTable = iCTSPService.getAllTale();
//            load(listCTSPTable);
//        } else {
//            JOptionPane.showMessageDialog(this, "Chon 1 dong ");
//        }
        int index = tb.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Mời bạn chọn 1 dòng để sửa");
        } else {
            CTSPViewModel ctsp = new CTSPViewModel();
            ctsp.setMa(txtMa.getText());
            ctsp.setMaVach(txtMaVach.getText());
            ctsp.setMoTa(txtMoTa.getText());
            ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

            for (SanPhamViewModel sp : listSP) {
                if (cbbSanPham.getSelectedItem().equals(sp.getTen())) {
                    ctsp.setIdSP(sp.getId());
                }
            }

            for (ThuongHieuViewModel sp : listTH) {
                if (cbbThuongHieu.getSelectedItem().equals(sp.getTen())) {
                    ctsp.setIdTH(sp.getId());
                }
            }

            for (LoaiAoViewModel sp : listLA) {
                if (cbbLoaiAo.getSelectedItem().equals(sp.getTen())) {
                    ctsp.setIdLA(sp.getId());
                }
            }

            for (SizeViewModel sp : listKC) {
                if (cbbKichCo.getSelectedItem().equals(sp.getTen())) {
                    ctsp.setIdKC(sp.getId());
                }
            }

            for (MauSacViewModel sp : listMS) {
                if (cbbMauSac.getSelectedItem().equals(sp.getTen())) {
                    ctsp.setIdMS(sp.getId());
                }
            }

            for (ChatLieuViewMoel sp : listCL) {
                if (cbbChatLieu.getSelectedItem().equals(sp.getTen())) {
                    ctsp.setIdCL(sp.getId());
                }
            }
            ctsp.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
            ctsp.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
            ctsp.setTrangThai(ckbTrangThai.isSelected());

            String kq = iCTSPService.getupdate(ctsp, index + 1);
            JOptionPane.showMessageDialog(this, kq);
            listCTSPTable = iCTSPService.getAllTale();
            load(listCTSPTable);
        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnSetFormMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetFormMSActionPerformed
        // TODO add your handling code here:
        new ViewMauSac().setVisible(true);
    }//GEN-LAST:event_btnSetFormMSActionPerformed

    private void btnSetFormKCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetFormKCActionPerformed
        // TODO add your handling code here:
        new ViewSize().setVisible(true);
    }//GEN-LAST:event_btnSetFormKCActionPerformed

    private void btnSetFormCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetFormCLActionPerformed
        // TODO add your handling code here:
        new ViewChatLieu().setVisible(true);
    }//GEN-LAST:event_btnSetFormCLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnLuuDS;
    private javax.swing.JButton btnSetFormCL;
    private javax.swing.JButton btnSetFormKC;
    private javax.swing.JButton btnSetFormLA;
    private javax.swing.JButton btnSetFormMS;
    private javax.swing.JButton btnSetFormTH;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbKichCo;
    private javax.swing.JComboBox<String> cbbLoaiAo;
    private javax.swing.JComboBox<String> cbbLocCLieu;
    private javax.swing.JComboBox<String> cbbLocLoaiAo;
    private javax.swing.JComboBox<String> cbbLocMauSac;
    private javax.swing.JComboBox<String> cbbLocSanPham;
    private javax.swing.JComboBox<String> cbbLocSize;
    private javax.swing.JComboBox<String> cbbLocTHieu;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbSanPham;
    private javax.swing.JComboBox<String> cbbThuongHieu;
    private javax.swing.JCheckBox ckbTrangThai;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaVach;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSerch;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
