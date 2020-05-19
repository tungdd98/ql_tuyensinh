package view;

import controller.DiemThiDAO;
import controller.MonThiDAO;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import entity.DiemThi;
import entity.MonThi;
import java.util.regex.Pattern;

/**
 *
 * @author tungdd
 */
public class DiemThiFormFrm extends javax.swing.JDialog {

    private String maThiSinh = null;
    private ArrayList<JLabel> arrLabel = new ArrayList<>();
    private ArrayList<JTextField> arrTextField = new ArrayList<>();
    private ArrayList<MonThi> listMonThi = new ArrayList<>();
    private ArrayList<DiemThi> listDiemThi = new ArrayList<>();

    /**
     * Creates new form DiemThiFormFrm
     */
    public DiemThiFormFrm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setMonThi();
    }

    public void setMonThi() {
        listMonThi = new MonThiDAO().getListItem();
        int y = 80;

        for (int i = 0; i < listMonThi.size(); i++) {
            MonThi item = listMonThi.get(i);

            JLabel label = new JLabel();
            label.setFont(new java.awt.Font("Consolas", 1, 14));
            label.setBounds(40, y, 120, 30);
            label.setText(item.getTenMon());
            label.setName("lb" + item.getMaMon());
            arrLabel.add(label);
            this.add(label);

            JTextField txt = new JTextField();
            txt.setBounds(130, y, 200, 30);
            txt.setName("txt" + item.getMaMon());
            this.add(txt);
            arrTextField.add(txt);

            y += 40;
        }
    }

    public void setData(ArrayList<DiemThi> listScore, String mts) {
        maThiSinh = mts;

        for (int i = 0; i < listScore.size(); i++) {
            DiemThi item = listScore.get(i);
            String field = "txt" + item.getMonThi_id();

            for (int j = 0; j < arrTextField.size(); j++) {
                if (field.equals(arrTextField.get(j).getName())) {
                    listDiemThi.add(item);
                    arrTextField.get(j).setText("" + item.getDiem());
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý điểm thi");

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Điểm thi");

        btnSave.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnSave.setText("Lưu lại");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnClose.setText("Đóng");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        btnClose.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        boolean isOk = true;
        int sizeListDiemThi = listDiemThi.size();

        if (sizeListDiemThi > 0) {
            for (int i = 0; i < sizeListDiemThi; i++) {
                DiemThi itemDiemThi = listDiemThi.get(i);
                String field = "txt" + itemDiemThi.getMonThi_id();

                for (int j = 0; j < arrTextField.size(); j++) {
                    JTextField itemTxt = arrTextField.get(j);
                    DiemThi dt = new DiemThi();
                    String regexScore = "^[0-9/.]*$";
                    String score = itemTxt.getText();

                    dt.setThiSinh_id(maThiSinh);
                    if (!"".equals(itemTxt.getText())) {
                        if (Pattern.matches(regexScore, score) && Float.parseFloat(score) <= 10 && Float.parseFloat(score) >= 0) {
                            dt.setDiem(score);
                        } else {
                            JOptionPane.showMessageDialog(this, "Điểm nhập không hợp lệ");
                        }
                        if (field.equals(itemTxt.getName())) {
                            dt.setMonThi_id(itemDiemThi.getMonThi_id());
                            if (!new DiemThiDAO().updateItem(dt)) {
                                isOk = false;
                            }
                        } else {
                            dt.setMonThi_id(listMonThi.get(j).getMaMon());
                            if (!new DiemThiDAO().addItem(dt)) {
                                isOk = false;
                            }
                        }
                    }

                }
            }
        } else {
            for (int j = 0; j < arrTextField.size(); j++) {
                JTextField itemTxt = arrTextField.get(j);
                DiemThi dt = new DiemThi();
                String regexScore = "^[0-9/.]*$";
                String score = itemTxt.getText();

                dt.setThiSinh_id(maThiSinh);
                if (!"".equals(itemTxt.getText())) {
                    if (Pattern.matches(regexScore, score) && Float.parseFloat(score) <= 10 && Float.parseFloat(score) >= 0) {
                        dt.setDiem(score);
                    } else {
                        JOptionPane.showMessageDialog(this, "Điểm nhập không hợp lệ");
                    }
                    dt.setMonThi_id(listMonThi.get(j).getMaMon());
                    if (!new DiemThiDAO().addItem(dt)) {
                        isOk = false;
                    }
                }

            }
        }

        if (isOk) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            this.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(DiemThiFormFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiemThiFormFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiemThiFormFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiemThiFormFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiemThiFormFrm dialog = new DiemThiFormFrm(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
