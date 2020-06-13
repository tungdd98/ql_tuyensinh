package view;

import controller.DiemChuanDAO;
import controller.KhoiThiDAO;
import controller.NganhThiDAO;
import controller.ThiSinhDAO;
import entity.DiemChuan;
import entity.KhoiThi;
import entity.NganhThi;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import entity.ThiSinh;
import java.text.SimpleDateFormat;

/**
 *
 * @author tungdd
 */
public class BaoCaoFrm extends javax.swing.JFrame {

    private final String[] header = {"STT", "Mã thí sinh", "Họ tên", "Ngày sinh", "Giới tính", "CMND", "Dân tộc", "Số điện thoại", "Quê quán"};
    private ArrayList<ThiSinh> items = new ArrayList<>();
    private DefaultTableModel model;
    private ArrayList<NganhThi> listNganhThi = new ArrayList<>();
    private String[] listTenNganhThi;
    private ArrayList<KhoiThi> listKhoiThi = new ArrayList<>();
    private String[] listTenKhoiThi;
    private ArrayList<String> listNamThi;
    private DiemChuan diemChuan;

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
        listNamThi = new DiemChuanDAO().getListYear();
        setListNamThi();
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
     * Lấy dữ liệu vào ô combobox năm thi
     */
    public void setListNamThi() {
        for (String item : listNamThi) {
            cbNamThi.addItem(item);
        }
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

    public void setDataLabel() {
        lbChiTieu.setText("Chỉ tiêu: " + diemChuan.getChiTieu());
        lbDiemChuan.setText("Điểm chuẩn: " + diemChuan.getDiemChuan());
        lbChiTieuConThieu.setText("Chỉ tiêu còn thiếu: " + (diemChuan.getChiTieu() - tblThiSinh.getRowCount()));
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
        cbKhoiThi = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        lbChiTieuConThieu = new javax.swing.JLabel();
        lbDiemChuan = new javax.swing.JLabel();
        lbChiTieu = new javax.swing.JLabel();
        cbNamThi = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Báo cáo kết quả");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Báo cáo kết quả");
        jLabel1.setToolTipText("");

        btnBackHome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBackHome.setText("Quay lại");
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
        jScrollPane1.setViewportView(tblThiSinh);

        cbKhoiThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lbChiTieuConThieu.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbChiTieuConThieu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbChiTieuConThieu.setText("Chỉ tiêu còn còn thiếu: 0");

        lbDiemChuan.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbDiemChuan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDiemChuan.setText("Điểm chuẩn: 0");

        lbChiTieu.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbChiTieu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbChiTieu.setText("Chỉ tiêu: 0");

        cbNamThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbTenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbKhoiThi, 0, 118, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(lbChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lbDiemChuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbChiTieuConThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
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
                    .addComponent(cbNamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiemChuan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbChiTieuConThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnBackHome.getAccessibleContext().setAccessibleName("Về trang chủ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sự kiện trở về trang chủ
     *
     * @param evt
     */
    private void btnBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHomeActionPerformed
        new BanTuyenSinhFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackHomeActionPerformed

    /**
     * Sự kiện tìm kiếm
     *
     * @param evt
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        int indexMaNganh = cbTenNganh.getSelectedIndex();
        String maNganh = listNganhThi.get(indexMaNganh).getMaNganh();
        int indexMaKhoi = cbKhoiThi.getSelectedIndex();
        String maKhoi = listKhoiThi.get(indexMaKhoi).getMaKhoi();
        String namThi = cbNamThi.getSelectedItem().toString();
        
        diemChuan = new DiemChuanDAO().getItemByCode(maNganh, maKhoi, namThi);
        if (diemChuan.getMaNganh() != null) {
            items = new ThiSinhDAO().getResultScore(diemChuan.getDiemChuan(), maKhoi);
            if(items.size() > 0) {
                showTable();
            } else {
                JOptionPane.showMessageDialog(this, "Danh sách thí sinh rỗng");
                model.setRowCount(0);
            }
            setDataLabel();
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả");
            model.setRowCount(0);
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
    private javax.swing.JComboBox<String> cbNamThi;
    private javax.swing.JComboBox<String> cbTenNganh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChiTieu;
    private javax.swing.JLabel lbChiTieuConThieu;
    private javax.swing.JLabel lbDiemChuan;
    private javax.swing.JTable tblThiSinh;
    // End of variables declaration//GEN-END:variables
}
