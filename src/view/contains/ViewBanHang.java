/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.HoaDonDomain;
import service.HDTableService;
import service.ICTSPService;
import service.IChatLieuService;
import service.IHoaDonCTService;
import service.IHoaDonService;
import service.ILoaiAoService;
import service.IMauSacService;
import service.ISanPhamSevice;
import service.ISizeService;
import service.IThuongHieuService;
import service.impl.CTSPServiceImpl;
import service.impl.ChatLieuServiceImpl;
import service.impl.HDTableServiceImpl;
import service.impl.HoaDonCTService;
import service.impl.HoaDonService;
import service.impl.LoaiAoServiceImpl;
import service.impl.MauSacServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.SizeServiceImpl;
import service.impl.ThuongHieuServiceImpl;
import viewmodel.ChatLieuViewMoel;
import viewmodel.ChiTietSanPhamViewModel;
import viewmodel.HDTableViewModel;
import viewmodel.HoaDonView;
import viewmodel.LoaiAoViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.SanPhamHDViewModel;
import viewmodel.SanPhamViewModel;
import viewmodel.SizeViewModel;
import viewmodel.ThuongHieuViewModel;

/**
 *
 * @author pc
 */
public class ViewBanHang extends javax.swing.JPanel {
    private IHoaDonService iHoaDonService = new HoaDonService();
    private IHoaDonCTService iHoaDonCTService = new HoaDonCTService();
    private List<HoaDonView> hoaDonViews = new ArrayList<>();
    private List<HoaDonDomain> hoaDonDomains = new ArrayList<>();
    private List<SanPhamHDViewModel> chiTiet = null;
    private HoaDonDomain hoaDonDomain = null;
    private List<HDTableViewModel> listHDTable=new ArrayList<>();
    private List<HDTableViewModel> listChiTietHD=new ArrayList<>();
    HDTableViewModel hdct=new HDTableViewModel();
    private HDTableService serviceHDTable= new HDTableServiceImpl();
    private HDTableViewModel hdTable=new HDTableViewModel();
    private DefaultTableModel dtmTable=new DefaultTableModel();
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
     * Creates new form ViewBanHang
     */
    public ViewBanHang() {
        initComponents();
        
        
        dtmTable=(DefaultTableModel) this.tblHoaDon.getModel();
        loadTable(serviceHDTable.getAll());
        listCTSPTable = iCTSPService.getAllTale();
        load(listCTSPTable);
        
        
       // ClickRow();
    }
    private void showDataTable(List<HDTableViewModel> listTable){
        dtmTable.setRowCount(0);
        for (HDTableViewModel hDTableVIewModel : listTable) {
            dtmTable.addRow(hDTableVIewModel.toRowData());
        }
    }
     private HDTableViewModel getHDTable(int index){
//        HDTableVIewModel hdTable=listHDTable.get(index);
//        return hdTable;
        if (index >= 0 && index < listHDTable.size()) {
        HDTableViewModel hdTable = listHDTable.get(index);
        return hdTable;
    } else {
        // Trả về giá trị mặc định hoặc thực hiện xử lý khác tùy thuộc vào yêu cầu của bạn.
        return null;
    }
    }
    public void loadTable(List<HDTableViewModel> list){
        
        int rowCount = tblHoaDon.getModel().getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) tblHoaDon.getModel()).removeRow(i);
        }
        for (HDTableViewModel p : list) {
            ((DefaultTableModel) tblHoaDon.getModel()).addRow(new Object[]{p.getMa(),
            p.getNgayTao(), p.getTenNhanVien(), p.getTenKhachHang()});
        }
    
    }
    public void load(List<ChiTietSanPhamViewModel> list) {
        int rowCount = tblSanPham.getModel().getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) tblSanPham.getModel()).removeRow(i);
        }
        dtm = (DefaultTableModel) tblSanPham.getModel();
        for (ChiTietSanPhamViewModel ct : list) {
            dtm.addRow( new Object[]{ct.getIdSP(),ct.getIdSP(),ct.getIdLA(),ct.getIdMS(),ct.getIdCL(),ct.getIdKC(),ct.getSoLuong(),ct.getGiaBan()});
        }
    }
//    public void loadTableCTHD(List<SanPhamHDViewModel> list){
//        int rowCount = tblGioHang.getModel().getRowCount();
//        for (int i = rowCount - 1; i >= 0; i--) {
//            ((DefaultTableModel) tblGioHang.getModel()).removeRow(i);
//        }
//        for (SanPhamHDViewModel p : list) {
//            ((DefaultTableModel) tblGioHang.getModel()).addRow(new Object[]{p.getTenSP(), p.getThuongHieu(),p.getLoaiAo(), p.getMauSac(),p.getChatLieu(),p.getSize(),p.getSoLuong(),p.getDonGia()});
//        }
//        tblGioHang.setRowHeight(25);
//    }
    
    
//    public void ClickRow() {
//        tblHoaDon.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent mouseEvent) {
//                JTable table = (JTable) mouseEvent.getSource();
//                Point point = mouseEvent.getPoint();
//                int row = table.rowAtPoint(point);
//                if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
//                    int id=0;
//                    String maHD=null;
//                    String ma = table.getValueAt(table.getSelectedRow(), 0).toString();
//                    for (HoaDonView hoaDonView : hoaDonViews) {
//                        if(hoaDonView.getMa().trim().equals(ma)){
//                            id=hoaDonView.getId();
//                            maHD=hoaDonView.getMa();
//                        }
//                    }
//                    HoaDonView x = iHoaDonService.findById(maHD);
//                    hoaDonDomain = new HoaDonDomain(x.getId(),x.getMa(),x.getIdNV(),x.getIdKH(),x.getPGG(),x.getNgayTao(),x.getNgayThanhToan(),x.getTienGiam(),x.getTongTien(),x.getTienKhachPhaiTra(),x.getTienKhachDua(),x.getTienThua(),x.getHinhThucThanhToan(),x.getMaChuyenKhoan(),x.getTrangThai());
//                    hoaDonDomain.setTrangThai(x.getTrangThai());
//                    System.out.println(id);
//                    loadTableCTHD(iHoaDonCTService.getByHdId(Integer.valueOf(id)));
//                    chiTiet = iHoaDonCTService.getByHdId(Integer.valueOf(id));
//                }
//            }
//        });
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jlbTenKhachHang1 = new javax.swing.JLabel();
        jlbSDT1 = new javax.swing.JLabel();
        jlbEmail1 = new javax.swing.JLabel();
        jlbTenNhanVien1 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        btnHuyHoaDon = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        btnUpdateSoLuong = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDonCT = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        chkSuaDung = new javax.swing.JCheckBox();
        rdoChuyenKhoan = new javax.swing.JRadioButton();
        rdoTienMat = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jlbMaHD = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        jlbMaGG = new javax.swing.JLabel();
        jlbDiemTichDuoc = new javax.swing.JLabel();
        jlbTienQuyDoi = new javax.swing.JLabel();
        jlbTienGiam = new javax.swing.JLabel();
        jlbKhachPhaiTra = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jlbTienThua = new javax.swing.JLabel();
        txtMaChuyenKhoan = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        cboLocSanPham = new javax.swing.JComboBox<>();
        cboLocKichCo = new javax.swing.JComboBox<>();
        cboLocLTT = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Tên: ");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("SDT: ");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thêm KH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Email :");

        jLabel36.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 0, 255));
        jLabel36.setText("Nhân viên");

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Danh sách");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 0, 255));
        jLabel37.setText("Khách hàng ");

        jlbTenKhachHang1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbTenKhachHang1.setText("Tên khách hàng");

        jlbSDT1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbSDT1.setText("Số điện thoại");

        jlbEmail1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbEmail1.setText("Email ");

        jlbTenNhanVien1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbTenNhanVien1.setText("Tên nhân viên");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Tên: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel24))
                                            .addComponent(jLabel33))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jlbTenKhachHang1))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlbEmail1))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlbSDT1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbTenNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jlbTenKhachHang1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jlbSDT1))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jlbEmail1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTenNhanVien1)
                    .addComponent(jLabel38))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Hóa đơn ");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HD", "Ngày Tạo", "Nhân Viên", "Khách Hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel40.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel40.setText("Hóa đơn chờ ");

        btnHuyHoaDon.setBackground(new java.awt.Color(0, 0, 0));
        btnHuyHoaDon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnHuyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyHoaDon.setText("Hủy hóa đơn");
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setBackground(new java.awt.Color(0, 0, 0));
        btnTaoHoaDon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40))
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 48, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel39.setText("Giỏ Hàng");

        btnUpdateSoLuong.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdateSoLuong.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUpdateSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSoLuong.setText("Sửa số lượng");
        btnUpdateSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSoLuongActionPerformed(evt);
            }
        });

        btnXoaSanPham.setBackground(new java.awt.Color(0, 0, 0));
        btnXoaSanPham.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnXoaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSanPham.setText("Xóa sản phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        tblHoaDonCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên Sản Phẩm", "Thương Hiệu", "Loại Áo", "Màu Sắc", "Chất Liệu", "Size", "Số Lượng", "Đơn Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblHoaDonCT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel39))
                .addGap(21, 21, 21))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 32, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(294, 294, 294))
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Thông tin");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText(" Mã               ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mã giảm giá ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tổng tiền      ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tích điểm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 0, 255));
        jLabel15.setText("Điểm tích được : ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 0, 255));
        jLabel16.setText("Tiền quy đổi :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tổng tiền giảm");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Khách phải trả");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Tiền khách đưa");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Tiền thừa");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Hình thức TT");

        chkSuaDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkSuaDung.setText("Sử dụng ");
        chkSuaDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSuaDungActionPerformed(evt);
            }
        });

        rdoChuyenKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChuyenKhoan.setText("Chuyển khoản");
        rdoChuyenKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChuyenKhoanMouseClicked(evt);
            }
        });

        rdoTienMat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoTienMat.setSelected(true);
        rdoTienMat.setText("Tiền mặt");
        rdoTienMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTienMatMouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Mã chuyển khoản");

        jlbMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMaHD.setText("Mã HD");

        jlbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTongTien.setText("0");
        jlbTongTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbTongTienMouseEntered(evt);
            }
        });

        jlbMaGG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMaGG.setText("Mã GG");

        jlbDiemTichDuoc.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbDiemTichDuoc.setForeground(new java.awt.Color(51, 0, 255));
        jlbDiemTichDuoc.setText("0");

        jlbTienQuyDoi.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbTienQuyDoi.setForeground(new java.awt.Color(51, 0, 255));
        jlbTienQuyDoi.setText("0");

        jlbTienGiam.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlbTienGiam.setForeground(new java.awt.Color(51, 0, 255));
        jlbTienGiam.setText("0");

        jlbKhachPhaiTra.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlbKhachPhaiTra.setForeground(new java.awt.Color(255, 0, 0));
        jlbKhachPhaiTra.setText("0");

        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienKhachDua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 51)));
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        txtTienKhachDua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTienKhachDuaMouseEntered(evt);
            }
        });
        txtTienKhachDua.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTienKhachDuaInputMethodTextChanged(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jlbTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTienThua.setText("0");
        jlbTienThua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jlbTienThuaKeyPressed(evt);
            }
        });

        txtMaChuyenKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaChuyenKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 153, 0)));
        txtMaChuyenKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaChuyenKhoanActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(255, 0, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("VNĐ");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 0, 255));
        jLabel25.setText("Điểm");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 0, 255));
        jLabel26.setText("VNĐ");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("VNĐ");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("VNĐ");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 0, 255));
        jLabel34.setText("VNĐ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMaGG)
                            .addComponent(jlbMaHD)
                            .addComponent(jlbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(chkSuaDung)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jlbTienQuyDoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel34))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbDiemTichDuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel25)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(60, 60, 60)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jlbTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32))
                                    .addComponent(txtTienKhachDua)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel19))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jlbKhachPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel29)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(rdoChuyenKhoan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoTienMat))
                                    .addComponent(txtMaChuyenKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(jlbTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btnThanhToan)
                        .addGap(120, 120, 120))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlbMaHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jlbTongTien)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlbMaGG))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jlbDiemTichDuoc)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jlbTienQuyDoi)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSuaDung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jlbTienGiam)
                    .addComponent(jLabel26))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jlbKhachPhaiTra)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoChuyenKhoan)
                        .addComponent(rdoTienMat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtMaChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jlbTienThua)
                    .addComponent(jLabel32))
                .addGap(26, 26, 26)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText(" Lọc và tìm kiếm sản phẩm");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Sản phẩm");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Kích cỡ");

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Chọn sản phẩm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Loại thể thao ");

        cboLocSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocSanPhamActionPerformed(evt);
            }
        });

        cboLocKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocKichCoActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        tblSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên Sản Phẩm", "Thương Hiệu", "Loại Áo", "Màu Sắc", "Chất Liệu", "Size", "Số Lượng", "Đơn Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLocKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLocLTT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)
                                .addComponent(cboLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboLocKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41)
                                .addComponent(cboLocLTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Danh sách sản phẩm");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Hóa đơn thanh toán");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(730, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        
         
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
     
        
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed

        
               
    
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void chkSuaDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSuaDungActionPerformed
        
    }//GEN-LAST:event_chkSuaDungActionPerformed

    private void rdoChuyenKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChuyenKhoanMouseClicked
        txtTienKhachDua.setText("");
        txtMaChuyenKhoan.enable();
        txtMaChuyenKhoan.repaint();
        txtTienKhachDua.disable();
        txtTienKhachDua.repaint();
        jlbTienThua.setText("");

    }//GEN-LAST:event_rdoChuyenKhoanMouseClicked

    private void rdoTienMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTienMatMouseClicked
        txtTienKhachDua.setText("");
        txtMaChuyenKhoan.disable();
        txtMaChuyenKhoan.repaint();
        txtTienKhachDua.enable();
        txtTienKhachDua.repaint();
        txtMaChuyenKhoan.setText("");
    }//GEN-LAST:event_rdoTienMatMouseClicked

    private void jlbTongTienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbTongTienMouseEntered

    }//GEN-LAST:event_jlbTongTienMouseEntered

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate

    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void txtTienKhachDuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachDuaMouseEntered

    }//GEN-LAST:event_txtTienKhachDuaMouseEntered

    private void txtTienKhachDuaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTienKhachDuaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaInputMethodTextChanged

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
    
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed

    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
   

    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void jlbTienThuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlbTienThuaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbTienThuaKeyPressed

    private void txtMaChuyenKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaChuyenKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaChuyenKhoanActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
    
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cboLocSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLocSanPhamActionPerformed

    private void cboLocKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocKichCoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLocKichCoActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed

    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnUpdateSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSoLuongActionPerformed

    }//GEN-LAST:event_btnUpdateSoLuongActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnUpdateSoLuong;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> cboLocKichCo;
    private javax.swing.JComboBox<String> cboLocLTT;
    private javax.swing.JComboBox<String> cboLocSanPham;
    private javax.swing.JCheckBox chkSuaDung;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel jlbDiemTichDuoc;
    private javax.swing.JLabel jlbEmail1;
    private javax.swing.JLabel jlbKhachPhaiTra;
    private javax.swing.JLabel jlbMaGG;
    private javax.swing.JLabel jlbMaHD;
    private javax.swing.JLabel jlbSDT1;
    private javax.swing.JLabel jlbTenKhachHang1;
    private javax.swing.JLabel jlbTenNhanVien1;
    private javax.swing.JLabel jlbTienGiam;
    private javax.swing.JLabel jlbTienQuyDoi;
    private javax.swing.JLabel jlbTienThua;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JRadioButton rdoChuyenKhoan;
    private javax.swing.JRadioButton rdoTienMat;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonCT;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtMaChuyenKhoan;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
