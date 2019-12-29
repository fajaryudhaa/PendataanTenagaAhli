package SistemPendataanTenagaAhli;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FormReportTenagaAhli extends javax.swing.JFrame {
    
    public FormReportTenagaAhli() {
        initComponents();
        setLocationRelativeTo(null);
        PanelBackground.requestFocus();
        
        Config.getConnection();
        ButtonGroup TenagaAhli = new ButtonGroup();
        TenagaAhli.add(Radio_SeluruhTenagaAhli);
        TenagaAhli.add(Radio_Jurusan);
        TenagaAhli.add(Radio_NamaTenagaAhli);
        TenagaAhli.add(Radio_Keahlian);
        
        try {
            Config.getData("SELECT Keahlian FROM Master_Keahlian");
            while(Config.RS.next()) {
                Combo_Keahlian.addItem(Config.RS.getString("Keahlian"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Keahlian!");
        }
        
        try {
            Config.getData("SELECT NamaTA FROM Table_DataTenagaAhli");
            while(Config.RS.next()) {
                Combo_NamaTA.addItem(Config.RS.getString("NamaTA"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Nama Tenaga Ahli!");
        }
        
        
        
        Text_IDTA.setVisible(false);
        Combo_Keahlian.setEnabled(false);
        Combo_NamaTA.setEnabled(false);
        Combo_Keahlian.setSelectedItem("Pilih Keahlian");
        Combo_NamaTA.setSelectedItem("Pilih Tenaga Ahli");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        PanelBackground = new javax.swing.JPanel();
        PanelContent = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Radio_NamaTenagaAhli = new javax.swing.JRadioButton();
        Radio_SeluruhTenagaAhli = new javax.swing.JRadioButton();
        Combo_Keahlian = new javax.swing.JComboBox<>();
        Combo_NamaTA = new javax.swing.JComboBox<>();
        Text_IDTA = new javax.swing.JTextField();
        Radio_Jurusan = new javax.swing.JRadioButton();
        Radio_Keahlian = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        ButtonPrint = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBackground.setBackground(new java.awt.Color(255, 255, 255));
        PanelBackground.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        PanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelContent.setBackground(new java.awt.Color(0, 153, 153));
        PanelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 10));

        Radio_NamaTenagaAhli.setBackground(new java.awt.Color(0, 51, 153));
        Radio_NamaTenagaAhli.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Radio_NamaTenagaAhli.setForeground(new java.awt.Color(255, 255, 255));
        Radio_NamaTenagaAhli.setText("BERDASARKAN NAMA TENAGA AHLI");
        Radio_NamaTenagaAhli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radio_NamaTenagaAhliActionPerformed(evt);
            }
        });
        PanelContent.add(Radio_NamaTenagaAhli, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 220, -1));

        Radio_SeluruhTenagaAhli.setBackground(new java.awt.Color(0, 51, 153));
        Radio_SeluruhTenagaAhli.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Radio_SeluruhTenagaAhli.setForeground(new java.awt.Color(255, 255, 255));
        Radio_SeluruhTenagaAhli.setText("SELURUH DATA TENAGA AHLI");
        Radio_SeluruhTenagaAhli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radio_SeluruhTenagaAhliActionPerformed(evt);
            }
        });
        PanelContent.add(Radio_SeluruhTenagaAhli, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 220, -1));

        Combo_Keahlian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Keahlian" }));
        Combo_Keahlian.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                Combo_KeahlianPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        PanelContent.add(Combo_Keahlian, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 200, 25));

        Combo_NamaTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tenaga Ahli" }));
        Combo_NamaTA.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                Combo_NamaTAPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        PanelContent.add(Combo_NamaTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 190, 25));
        PanelContent.add(Text_IDTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 50, 25));

        Radio_Jurusan.setBackground(new java.awt.Color(0, 51, 153));
        Radio_Jurusan.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Radio_Jurusan.setForeground(new java.awt.Color(255, 255, 255));
        Radio_Jurusan.setText("JURUSAN");
        Radio_Jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radio_JurusanActionPerformed(evt);
            }
        });
        PanelContent.add(Radio_Jurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 220, -1));

        Radio_Keahlian.setBackground(new java.awt.Color(0, 51, 153));
        Radio_Keahlian.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Radio_Keahlian.setForeground(new java.awt.Color(255, 255, 255));
        Radio_Keahlian.setText("KEAHLIAN");
        Radio_Keahlian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radio_KeahlianActionPerformed(evt);
            }
        });
        PanelContent.add(Radio_Keahlian, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 220, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 720, 250));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 292, 720, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("REPORT - TENAGA AHLI");
        PanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 17));

        ButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print.png"))); // NOI18N
        ButtonPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print Hover.png"))); // NOI18N
        ButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 100, 35));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close Hover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PanelBackground.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Combo_KeahlianPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Combo_KeahlianPopupMenuWillBecomeInvisible
        try {
            Combo_NamaTA.removeAllItems();
            Combo_NamaTA.addItem("Pilih Tenaga Ahli");
            Config.getData("SELECT IDTA, NamaTA FROM Table_DataTenagaAhli WHERE KeahlianTA = '" + Combo_Keahlian.getSelectedItem() + "'");
            while(Config.RS.next()) {
                Text_IDTA.setText(Config.RS.getString("IDTA"));
                Combo_NamaTA.addItem(Config.RS.getString("NamaTA"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Nama Tenaga Ahli!");
        }
    }//GEN-LAST:event_Combo_KeahlianPopupMenuWillBecomeInvisible

    private void Combo_NamaTAPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Combo_NamaTAPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_Combo_NamaTAPopupMenuWillBecomeInvisible

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        if(Radio_SeluruhTenagaAhli.isSelected()) {
            try {
                String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                String Lokasi = "src/Report/DaftarTenagaAhli.jasper";

                HashMap HM = new HashMap(1);
                HM.put("ViramaKarya", Logo);

                File F = new File(Lokasi);
                JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                viewReport.setTitle("Report - Daftar Tenaga Ahli");
                viewReport.setZoomRatio(new Float(0.80));
                viewReport.setVisible(true);

            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Maaf, Terdapat Kesalahan Dalam Mencetak Report!");
            }    
        } else if(Radio_NamaTenagaAhli.isSelected()) {
            if(Combo_Keahlian.getSelectedItem().equals("Pilih Keahlian") || Combo_NamaTA.getSelectedItem().equals("Pilih Tenaga Ahli")) {
                JOptionPane.showMessageDialog(null, "Maaf, Keahlian dan Tenaga Ahli Harus Dipilih!");
            } else {
                try {
                    String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                    String Lokasi = "src/Report/DaftarTenagaAhliByProyek.jasper";

                    HashMap HM = new HashMap(2);
                    HM.put("ViramaKarya", Logo);
                    HM.put("IDTA", Text_IDTA.getText());

                    File F = new File(Lokasi);
                    JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                    JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                    viewReport.setTitle("Report - Tenaga Ahli");
                    viewReport.setZoomRatio(new Float(0.80));
                    viewReport.setVisible(true);

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Maaf, Terdapat Kesalahan Dalam Mencetak Report!");
                }
        }  
        }else if(Radio_Jurusan.isSelected()) {
            try {
                    String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                    String Lokasi = "src/Report/DaftarJurusan.jasper";

                    HashMap HM = new HashMap(3);
                    HM.put("ViramaKarya", Logo);
                    

                    File F = new File(Lokasi);
                    JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                    JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                    viewReport.setTitle("Report - JURUSAN");
                    viewReport.setZoomRatio(new Float(0.80));
                    viewReport.setVisible(true);

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Maaf, Terdapat Kesalahan Dalam Mencetak Report!");
            } 
        }else if(Radio_Keahlian.isSelected()) {
            try {
                    String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                    String Lokasi = "src/Report/DaftarKeahlian.jasper";

                    HashMap HM = new HashMap(4);
                    HM.put("ViramaKarya", Logo);
                    

                    File F = new File(Lokasi);
                    JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                    JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                    viewReport.setTitle("Report - KEAHLIAN");
                    viewReport.setZoomRatio(new Float(0.80));
                    viewReport.setVisible(true);

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Maaf, Terdapat Kesalahan Dalam Mencetak Report!");
            }
        }
        
    }//GEN-LAST:event_ButtonPrintActionPerformed

    private void Radio_SeluruhTenagaAhliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radio_SeluruhTenagaAhliActionPerformed
        Combo_Keahlian.setEnabled(false);
        Combo_NamaTA.setEnabled(false);
        Combo_Keahlian.setSelectedItem("Pilih Keahlian");
        Combo_NamaTA.setSelectedItem("Pilih Tenaga Ahli");
    }//GEN-LAST:event_Radio_SeluruhTenagaAhliActionPerformed

    private void Radio_NamaTenagaAhliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radio_NamaTenagaAhliActionPerformed
        Combo_Keahlian.setEnabled(true);
        Combo_NamaTA.setEnabled(true);
        Combo_Keahlian.setSelectedItem("Pilih Keahlian");
        Combo_NamaTA.setSelectedItem("Pilih Tenaga Ahli");
    }//GEN-LAST:event_Radio_NamaTenagaAhliActionPerformed

    private void Radio_JurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radio_JurusanActionPerformed
        Combo_Keahlian.setEnabled(false);
        Combo_NamaTA.setEnabled(false);
    }//GEN-LAST:event_Radio_JurusanActionPerformed

    private void Radio_KeahlianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radio_KeahlianActionPerformed
        Combo_Keahlian.setEnabled(false);
        Combo_NamaTA.setEnabled(false);
    }//GEN-LAST:event_Radio_KeahlianActionPerformed

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
            java.util.logging.Logger.getLogger(FormReportTenagaAhli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormReportTenagaAhli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormReportTenagaAhli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormReportTenagaAhli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormReportTenagaAhli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JComboBox<String> Combo_Keahlian;
    private javax.swing.JComboBox<String> Combo_NamaTA;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JRadioButton Radio_Jurusan;
    private javax.swing.JRadioButton Radio_Keahlian;
    private javax.swing.JRadioButton Radio_NamaTenagaAhli;
    private javax.swing.JRadioButton Radio_SeluruhTenagaAhli;
    private javax.swing.JTextField Text_IDTA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
