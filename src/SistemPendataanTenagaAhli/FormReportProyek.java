package SistemPendataanTenagaAhli;

import com.toedter.calendar.JTextFieldDateEditor;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FormReportProyek extends javax.swing.JFrame {
    
    public FormReportProyek() {
        initComponents();
        setLocationRelativeTo(null);
        PanelBackground.requestFocus();
        
        Config.getConnection();
        ButtonGroup Proyek = new ButtonGroup();
        Proyek.add(Radio_SeluruhProyek);
        Proyek.add(Radio_SeluruhProyekByStatus);
        
        Date_SeluruhProyekAwal.setEnabled(false);
        Date_SeluruhProyekAkhir.setEnabled(false);
        Combo_StatusProyek.setEnabled(false);
        Date_ProyekByStatusAwal.setEnabled(false);
        Date_ProyekByStatusAkhir.setEnabled(false);
        
        JTextFieldDateEditor dateEditor_SeluruhProyekAwal = (JTextFieldDateEditor)Date_SeluruhProyekAwal.getComponent(1);
        dateEditor_SeluruhProyekAwal.setHorizontalAlignment(JTextField.CENTER);
        JTextFieldDateEditor dateEditor_SeluruhProyekAkhir = (JTextFieldDateEditor)Date_SeluruhProyekAkhir.getComponent(1);
        dateEditor_SeluruhProyekAkhir.setHorizontalAlignment(JTextField.CENTER);
        dateEditor_SeluruhProyekAwal.setFocusable(false);
        dateEditor_SeluruhProyekAkhir.setFocusable(false);
        
        JTextFieldDateEditor dateEditor_ProyekAwalByStatus = (JTextFieldDateEditor)Date_ProyekByStatusAwal.getComponent(1);
        dateEditor_ProyekAwalByStatus.setHorizontalAlignment(JTextField.CENTER);
        JTextFieldDateEditor dateEditor_ProyekAkhirByStatus = (JTextFieldDateEditor)Date_ProyekByStatusAkhir.getComponent(1);
        dateEditor_ProyekAkhirByStatus.setHorizontalAlignment(JTextField.CENTER);
        dateEditor_ProyekAwalByStatus.setFocusable(false);
        dateEditor_ProyekAkhirByStatus.setFocusable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        PanelBackground = new javax.swing.JPanel();
        PanelContent = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Radio_SeluruhProyekByStatus = new javax.swing.JRadioButton();
        Radio_SeluruhProyek = new javax.swing.JRadioButton();
        Combo_StatusProyek = new javax.swing.JComboBox<>();
        Date_SeluruhProyekAkhir = new com.toedter.calendar.JDateChooser();
        Date_SeluruhProyekAwal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Date_ProyekByStatusAwal = new com.toedter.calendar.JDateChooser();
        Date_ProyekByStatusAkhir = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        ButtonPrint = new javax.swing.JButton();
        Button_Close = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBackground.setBackground(new java.awt.Color(255, 255, 255));
        PanelBackground.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        PanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelContent.setBackground(new java.awt.Color(0, 153, 153));
        PanelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 10));

        Radio_SeluruhProyekByStatus.setBackground(new java.awt.Color(0, 51, 153));
        Radio_SeluruhProyekByStatus.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Radio_SeluruhProyekByStatus.setForeground(new java.awt.Color(255, 255, 255));
        Radio_SeluruhProyekByStatus.setText("SELURUH PROYEK BERDASARKAN STATUS");
        Radio_SeluruhProyekByStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radio_SeluruhProyekByStatusActionPerformed(evt);
            }
        });
        PanelContent.add(Radio_SeluruhProyekByStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 250, -1));

        Radio_SeluruhProyek.setBackground(new java.awt.Color(0, 51, 153));
        Radio_SeluruhProyek.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Radio_SeluruhProyek.setForeground(new java.awt.Color(255, 255, 255));
        Radio_SeluruhProyek.setText("SELURUH PROYEK");
        Radio_SeluruhProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radio_SeluruhProyekActionPerformed(evt);
            }
        });
        PanelContent.add(Radio_SeluruhProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 250, -1));

        Combo_StatusProyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Status Proyek", "Proyek Sedang Berlangsung", "Proyek Selesai" }));
        PanelContent.add(Combo_StatusProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, 25));

        Date_SeluruhProyekAkhir.setDateFormatString("dd MMMM yyyy");
        Date_SeluruhProyekAkhir.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Date_SeluruhProyekAkhir.setPreferredSize(new java.awt.Dimension(91, 24));
        PanelContent.add(Date_SeluruhProyekAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 170, -1));

        Date_SeluruhProyekAwal.setDateFormatString("dd MMMM yyyy");
        Date_SeluruhProyekAwal.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Date_SeluruhProyekAwal.setPreferredSize(new java.awt.Dimension(91, 24));
        PanelContent.add(Date_SeluruhProyekAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("s/d");
        PanelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 115, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PERIODE");
        PanelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PERIODE");
        PanelContent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        Date_ProyekByStatusAwal.setDateFormatString("dd MMMM yyyy");
        Date_ProyekByStatusAwal.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Date_ProyekByStatusAwal.setPreferredSize(new java.awt.Dimension(91, 24));
        PanelContent.add(Date_ProyekByStatusAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 170, -1));

        Date_ProyekByStatusAkhir.setDateFormatString("dd MMMM yyyy");
        Date_ProyekByStatusAkhir.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Date_ProyekByStatusAkhir.setPreferredSize(new java.awt.Dimension(91, 24));
        PanelContent.add(Date_ProyekByStatusAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("s/d");
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 640, 330));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 292, 570, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("REPORT - PROYEK");
        PanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 17));

        ButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print.png"))); // NOI18N
        ButtonPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print Hover.png"))); // NOI18N
        ButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 100, 35));

        Button_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close.png"))); // NOI18N
        Button_Close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close Hover.png"))); // NOI18N
        Button_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CloseActionPerformed(evt);
            }
        });
        PanelBackground.add(Button_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CloseActionPerformed
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_Button_CloseActionPerformed

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        if(Radio_SeluruhProyek.isSelected()) {
            if(Date_SeluruhProyekAwal.getDate().equals(null) || Date_SeluruhProyekAkhir.getDate().equals(null)) {
                JOptionPane.showMessageDialog(null, "Maaf, Periode Tanggal Proyek Harus Dipilih!");
            } else {
                try {
                    Date TanggalAwal, TanggalAkhir ;
                    SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                    TanggalAwal = new Date(Date_SeluruhProyekAwal.getDate().getTime());
                    TanggalAkhir = new Date(Date_SeluruhProyekAkhir.getDate().getTime());
                    String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                    String Lokasi = "src/Report/DaftarProyek.jasper";

                    HashMap HM = new HashMap(3);
                    HM.put("ViramaKarya", Logo);
                    HM.put("TanggalAwal", TanggalAwal);
                    HM.put("TanggalAkhir", TanggalAkhir);

                    File F = new File(Lokasi);
                    JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                    JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                    viewReport.setTitle("Report - Daftar Proyek");
                    viewReport.setZoomRatio(new Float(0.80));
                    viewReport.setVisible(true);

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Maaf, Terdapat Kesalahan Dalam Mencetak Report!");
                }   
            }
        } else if(Radio_SeluruhProyekByStatus.isSelected()) {
            if(Combo_StatusProyek.getSelectedItem().equals("Pilih Status Proyek")) {
                JOptionPane.showMessageDialog(null, "Maaf, Status Proyek Harus Dipilih!");
            } else if(Date_ProyekByStatusAwal.getDate().equals(null) || Date_ProyekByStatusAkhir.getDate().equals(null)) {
                JOptionPane.showMessageDialog(null, "Maaf, Periode Tanggal Proyek Harus Dipilih!");
            } else {
                try {
                    Date TanggalAwal, TanggalAkhir ;
                    SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                    TanggalAwal = new Date(Date_ProyekByStatusAwal.getDate().getTime());
                    TanggalAkhir = new Date(Date_ProyekByStatusAkhir.getDate().getTime());
                    String Status = Combo_StatusProyek.getSelectedItem().toString();
                    String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                    String Lokasi = "src/Report/DaftarProyekByStatus.jasper";

                    HashMap HM = new HashMap(2);
                    HM.put("ViramaKarya", Logo);
                    HM.put("TanggalAwal", TanggalAwal);
                    HM.put("TanggalAkhir", TanggalAkhir);
                    HM.put("Status", Status);

                    File F = new File(Lokasi);
                    JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                    JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                    viewReport.setTitle("Report - Daftar Proyek Berdasarkan Status");
                    viewReport.setZoomRatio(new Float(0.80));
                    viewReport.setVisible(true);

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Maaf, Terdapat Kesalahan Dalam Mencetak Report!");
                }
            }
        }
    }//GEN-LAST:event_ButtonPrintActionPerformed

    private void Radio_SeluruhProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radio_SeluruhProyekActionPerformed
        Combo_StatusProyek.setEnabled(false);
        Combo_StatusProyek.setSelectedItem("Pilih Status Proyek");
        Date_SeluruhProyekAwal.setEnabled(true);
        Date_SeluruhProyekAkhir.setEnabled(true);
        Date_SeluruhProyekAwal.setDate(null);
        Date_SeluruhProyekAkhir.setDate(null);
        Date_ProyekByStatusAwal.setEnabled(false);
        Date_ProyekByStatusAkhir.setEnabled(false);
        Date_ProyekByStatusAkhir.setDate(null);
        Date_ProyekByStatusAkhir.setDate(null);
    }//GEN-LAST:event_Radio_SeluruhProyekActionPerformed

    private void Radio_SeluruhProyekByStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radio_SeluruhProyekByStatusActionPerformed
        Combo_StatusProyek.setEnabled(true);
        Combo_StatusProyek.setSelectedItem("Pilih Status Proyek");
        Date_SeluruhProyekAwal.setEnabled(false);
        Date_SeluruhProyekAkhir.setEnabled(false);
        Date_SeluruhProyekAwal.setDate(null);
        Date_SeluruhProyekAkhir.setDate(null);
        Date_ProyekByStatusAwal.setEnabled(true);
        Date_ProyekByStatusAkhir.setEnabled(true);
        Date_ProyekByStatusAkhir.setDate(null);
        Date_ProyekByStatusAkhir.setDate(null);
    }//GEN-LAST:event_Radio_SeluruhProyekByStatusActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormReportProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormReportProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormReportProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormReportProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormReportProyek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JButton Button_Close;
    private javax.swing.JComboBox<String> Combo_StatusProyek;
    private com.toedter.calendar.JDateChooser Date_ProyekByStatusAkhir;
    private com.toedter.calendar.JDateChooser Date_ProyekByStatusAwal;
    private com.toedter.calendar.JDateChooser Date_SeluruhProyekAkhir;
    private com.toedter.calendar.JDateChooser Date_SeluruhProyekAwal;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JRadioButton Radio_SeluruhProyek;
    private javax.swing.JRadioButton Radio_SeluruhProyekByStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
