package view;

import controller.DiemChuanDAO;
import controller.KhoiThiDAO;
import controller.NganhThiDAO;
import entity.DiemChuan;
import entity.KhoiThi;
import entity.NganhThi;
import helper.Validator;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tuanndm
 */
public class DiemChuanFormFrm extends javax.swing.JDialog {

    private final DiemChuanFrm home;
    private boolean isEdit = false;
    private ArrayList<NganhThi> listNganhThi = new ArrayList<>();
    private String[] listTenNganhThi;
    private ArrayList<KhoiThi> listKhoiThi = new ArrayList<>();
    private String[] listTenKhoiThi;
    private String maNganh;

    /**
     * Creates new form ThiSinhFormFrm
     */
    public DiemChuanFormFrm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        home = (DiemChuanFrm) parent;
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
     * Lấy dữ liệu từ phần tử được chọn
     *
     * @param edit
     * @param ts
     */
    public void getSelectedItem(boolean edit, DiemChuan item) {
        isEdit = edit;
        int index = 0;

        for (int i = 0; i < listNganhThi.size(); i++) {
            if (listNganhThi.get(i).getMaNganh().equals(item.getMaNganh())) {
                index = i;
            }
        }
        txtDiemChuan.setText("" + item.getDiemChuan());
        txtChiTieu.setText("" + item.getChiTieu());
        txtNamThi.setText(item.getNamThi());
        txtNamThi.setEnabled(false);
        cbTenNganh.setSelectedIndex(index);
        cbTenNganh.setEnabled(false);
        cbKhoiThi.setSelectedItem(item.getTenKhoi());
        cbKhoiThi.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHoTen = new javax.swing.JLabel();
        txtDiemChuan = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbHoTen1 = new javax.swing.JLabel();
        txtChiTieu = new javax.swing.JTextField();
        lbHoTen2 = new javax.swing.JLabel();
        txtNamThi = new javax.swing.JTextField();
        lbMaThiSinh1 = new javax.swing.JLabel();
        cbTenNganh = new javax.swing.JComboBox<>();
        lbMaThiSinh2 = new javax.swing.JLabel();
        cbKhoiThi = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin điểm chuẩn");

        lbHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoTen.setText("Điểm chuẩn");

        txtDiemChuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Lưu lại");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClose.setText("Huỷ bỏ");
        btnClose.setToolTipText("");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Thông tin điểm chuẩn");

        lbHoTen1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoTen1.setText("Chỉ tiêu");

        txtChiTieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbHoTen2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoTen2.setText("Năm thi");

        txtNamThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbMaThiSinh1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMaThiSinh1.setText("Tên ngành");

        cbTenNganh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbMaThiSinh2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMaThiSinh2.setText("Khối thi");

        cbKhoiThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDiemChuan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbHoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbMaThiSinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbTenNganh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbMaThiSinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbKhoiThi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbHoTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaThiSinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaThiSinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKhoiThi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiemChuan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sự kiện lưu dữ liệu
     *
     * @param evt
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        boolean isSuccess = true;
        ArrayList<Validator> data = new ArrayList<>();
        String maNganh, maKhoi;
        Validator diemChuan = new Validator(txtDiemChuan.getText(), new String[]{"required", "isDecimal"}, "Điểm chuẩn"),
                chiTieu = new Validator(txtChiTieu.getText(), new String[]{"required", "isInteger"}, "Chỉ tiêu"),
                namThi = new Validator(txtNamThi.getText(), new String[]{"required", "isInteger"}, "Năm thi");
        
        data.add(diemChuan);
        data.add(chiTieu);
        data.add(namThi);
        
        for (Validator item : data) {
            if (!item.setTextField(home)) {
                isSuccess = false;
            }
        }
        
        if (isSuccess) {
            int indexMaNganh = cbTenNganh.getSelectedIndex();
            int indexMaKhoi = cbKhoiThi.getSelectedIndex();
            maNganh = listNganhThi.get(indexMaNganh).getMaNganh();
            maKhoi = listKhoiThi.get(indexMaKhoi).getMaKhoi();
            DiemChuan item = new DiemChuan(maNganh, Float.parseFloat(diemChuan.getText()), Integer.parseInt(chiTieu.getText()), namThi.getText(), maKhoi, cbKhoiThi.getSelectedItem().toString());
            
            if (!isEdit) {
                if (new DiemChuanDAO().addItem(item)) {
                    home.showTable();
                    JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Điểm chuẩn năm này đã tồn tại!");
                }
            } else {
                if (new DiemChuanDAO().updateItem(item)) {
                    home.showTable();
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Có lỗi xảy ra!");
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Sự kiện đóng app
     *
     * @param evt
     */
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(DiemChuanFormFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiemChuanFormFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiemChuanFormFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiemChuanFormFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiemChuanFormFrm dialog = new DiemChuanFormFrm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbKhoiThi;
    private javax.swing.JComboBox<String> cbTenNganh;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbHoTen1;
    private javax.swing.JLabel lbHoTen2;
    private javax.swing.JLabel lbMaThiSinh1;
    private javax.swing.JLabel lbMaThiSinh2;
    private javax.swing.JTextField txtChiTieu;
    private javax.swing.JTextField txtDiemChuan;
    private javax.swing.JTextField txtNamThi;
    // End of variables declaration//GEN-END:variables
}