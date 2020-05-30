package view;

import controller.DiemTuyenSinhDAO;
import controller.KhoiThiDAO;
import controller.NganhThiDAO;
import controller.ThiSinhDAO;
import entity.DiemTuyenSinh;
import entity.KhoiThi;
import entity.NganhThi;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import entity.ThiSinh;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

/**
 *
 * @author tungdd
 */
public class BaoCaoFrm extends javax.swing.JFrame {

    private final String[] header = {"STT", "Mã thí sinh", "Họ tên", "Ngày sinh", "Giới tính", "CMND", "Dân tộc", "Số điện thoại", "Quê quán"};
    private ArrayList<ThiSinh> items = new ArrayList<>();
    private int selectedIndex;
    private DefaultTableModel model;
    private ArrayList<NganhThi> listNganhThi = new ArrayList<>();
    private String[] listTenNganhThi;
    private ArrayList<KhoiThi> listKhoiThi = new ArrayList<>();
    private String[] listTenKhoiThi;
    private DiemTuyenSinh diemTuyenSinh;

    /**
     * Creates new form ThiSinhFrm
     */
    public BaoCaoFrm() {
        initComponents();
        setLocationRelativeTo(null);

        model = (DefaultTableModel) tblThiSinh.getModel();
        model.setColumnIdentifiers(header);

        listNganhThi = new NganhThiDAO().getListItem();
        setListTenNganhThi();
        listKhoiThi = new KhoiThiDAO().getListItem();
        setListTenKhoiThi();
    }

    /**
     * Lấy dữ liệu vào ô combobox ngành thi
     */
    public void setListTenNganhThi() {
        int size = listNganhThi.size();
        listTenNganhThi = new String[size];

        for (int i = 0; i < size; i++) {
            listTenNganhThi[i] = listNganhThi.get(i).getTenNganh();
        }
        cbTenNganh.setModel(new javax.swing.DefaultComboBoxModel(listTenNganhThi));
    }

    /**
     * Lấy dữ liệu vào ô combobox khối thi
     */
    public void setListTenKhoiThi() {
        int size = listKhoiThi.size();
        listTenKhoiThi = new String[size];

        for (int i = 0; i < size; i++) {
            listTenKhoiThi[i] = listKhoiThi.get(i).getTenKhoi();
        }
        cbKhoiThi.setModel(new javax.swing.DefaultComboBoxModel(listTenKhoiThi));
    }

    /**
     * Hiển thị danh sách dữ liệu
     */
    public void showTable() {
        model.setRowCount(0);
        for (ThiSinh item : items) {
            model.addRow(new Object[]{
                model.getRowCount() + 1, item.getMaThiSinh(), item.getHoTen(), new SimpleDateFormat("dd/MM/yyyy").format(item.getNgaySinh()), item.getGioiTinh() == 1 ? "Nam" : "Nữ", item.getCMND(), item.getDanToc(), item.getSoDienThoai(), item.getQueQuan()
            });
        }
    }

    /**
     * Thêm mới vào arraylist
     *
     * @param ts
     */
    public void addItem(ThiSinh item) {
        items.add(item);
        showTable();
    }

    /**
     * Cập nhật vào arraylist
     *
     * @param ts
     */
    public void updateItem(ThiSinh item) {
        items.remove(selectedIndex);
        items.add(item);
        showTable();
    }

    public void setDataLabel() {
        lbChiTieu.setText("Chỉ tiêu: " + diemTuyenSinh.getChiTieu());
        lbDiemChuan.setText("Điểm tuyển sinh: " + diemTuyenSinh.getDiemChuan());
        int numberChiTieu = Integer.parseInt(0 + diemTuyenSinh.getChiTieu());
        int numberTotal = tblThiSinh.getRowCount();
        lbChiTieuConThieu.setText("Chỉ tiêu còn thiếu: " + (numberChiTieu - numberTotal));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBackHome = new javax.swing.JButton();
        cbTenNganh = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThiSinh = new javax.swing.JTable();
        txtNamThi = new javax.swing.JTextField();
        cbKhoiThi = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        lbChiTieuConThieu = new javax.swing.JLabel();
        lbDiemChuan = new javax.swing.JLabel();
        lbChiTieu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thí sinh");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Báo cáo kết quả");
        jLabel1.setToolTipText("");

        btnBackHome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBackHome.setText("Trang chủ");
        btnBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHomeActionPerformed(evt);
            }
        });

        cbTenNganh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblThiSinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblThiSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblThiSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThiSinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThiSinh);

        txtNamThi.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtNamThi.setToolTipText("Năm thi");

        cbKhoiThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lbChiTieuConThieu.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbChiTieuConThieu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTieuConThieu.setText("Chỉ tiêu còn còn thiếu: 0");

        lbDiemChuan.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbDiemChuan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemChuan.setText("Điểm chuẩn: 0");

        lbChiTieu.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbChiTieu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTieu.setText("Chỉ tiêu: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cbTenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbChiTieuConThieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDiemChuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbKhoiThi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKhoiThi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbDiemChuan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbChiTieuConThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        btnBackHome.getAccessibleContext().setAccessibleName("Về trang chủ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sự kiện trở về trang chủ
     *
     * @param evt
     */
    private void btnBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHomeActionPerformed
        new TrangChuFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackHomeActionPerformed

    /**
     * Sự kiện hiển thị dữ liệu khi bấm vào hàng trong bảng
     *
     * @param evt
     */
    private void tblThiSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThiSinhMouseClicked
        selectedIndex = tblThiSinh.getSelectedRow();
    }//GEN-LAST:event_tblThiSinhMouseClicked

    /**
     * Sự kiện tìm kiếm
     *
     * @param evt
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        int indexMaNganh = cbTenNganh.getSelectedIndex();
        String maNganh = listNganhThi.get(indexMaNganh).getMaNganh();
        int indexMaKhoi = cbKhoiThi.getSelectedIndex();
        int maKhoi = listKhoiThi.get(indexMaKhoi).getMaKhoi();
        String namThi;

        if ("".equals(txtNamThi.getText())) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền năm thi");
        } else {
            namThi = txtNamThi.getText().trim();
            diemTuyenSinh = new DiemTuyenSinhDAO().getItemByCode(maNganh, maKhoi, namThi);
            if (diemTuyenSinh.getMaNganh() != null) {
                items = new ThiSinhDAO().getResultScore(diemTuyenSinh.getDiemChuan(), maKhoi);
                showTable();
                setDataLabel();
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả");
                model.setRowCount(0);
            }

        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(BaoCaoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoCaoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoCaoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoCaoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCaoFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbKhoiThi;
    private javax.swing.JComboBox<String> cbTenNganh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChiTieu;
    private javax.swing.JLabel lbChiTieuConThieu;
    private javax.swing.JLabel lbDiemChuan;
    private javax.swing.JTable tblThiSinh;
    private javax.swing.JTextField txtNamThi;
    // End of variables declaration//GEN-END:variables
}