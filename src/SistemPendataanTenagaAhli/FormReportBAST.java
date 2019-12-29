package SistemPendataanTenagaAhli;

import com.toedter.calendar.JTextFieldDateEditor;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FormReportBAST extends javax.swing.JFrame {
    
    public FormReportBAST() {
        initComponents();
        setLocationRelativeTo(null);
        PanelBackground.requestFocus();
        
        Config.getConnection();
        
        JTextFieldDateEditor dateEditor_Begin = (JTextFieldDateEditor)Date_BASTAwal.getComponent(1);
        dateEditor_Begin.setHorizontalAlignment(JTextField.CENTER);
        JTextFieldDateEditor dateEditor_End = (JTextFieldDateEditor)Date_BASTAkhir.getComponent(1);
        dateEditor_End.setHorizontalAlignment(JTextField.CENTER);
        dateEditor_Begin.setFocusable(false);
        dateEditor_End.setFocusable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        PanelBackground = new javax.swing.JPanel();
        PanelContent = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Date_BASTAwal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        Date_BASTAkhir = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 10));

        Date_BASTAwal.setDateFormatString("dd MMMM yyyy");
        Date_BASTAwal.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Date_BASTAwal.setPreferredSize(new java.awt.Dimension(91, 24));
        PanelContent.add(Date_BASTAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("s/d");
        PanelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        Date_BASTAkhir.setDateFormatString("dd MMMM yyyy");
        Date_BASTAkhir.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Date_BASTAkhir.setPreferredSize(new java.awt.Dimension(91, 24));
        PanelContent.add(Date_BASTAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PERIODE");
        PanelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 9, -1, 130));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 610, 150));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 192, 610, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("REPORT - BERITA ACARA SERAH TERIMA");
        PanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 17));

        ButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print.png"))); // NOI18N
        ButtonPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print Hover.png"))); // NOI18N
        ButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 100, 35));

        Button_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close.png"))); // NOI18N
        Button_Close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close Hover.png"))); // NOI18N
        Button_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CloseActionPerformed(evt);
            }
        });
        PanelBackground.add(Button_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CloseActionPerformed
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_Button_CloseActionPerformed

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        if(Date_BASTAwal.getDate().equals(null) || Date_BASTAkhir.getDate().equals(null)) {
            JOptionPane.showMessageDialog(null, "Maaf, Periode Tanggal BAST Harus Dipilih!");
        } else {
            try {
                Date TanggalAwal, TanggalAkhir ;
                SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                TanggalAwal = new Date(Date_BASTAwal.getDate().getTime());
                TanggalAkhir = new Date(Date_BASTAkhir.getDate().getTime());
                String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                String Lokasi = "src/Report/DaftarBAST.jasper";

                HashMap HM = new HashMap(3);
                HM.put("ViramaKarya", Logo);
                HM.put("TanggalAwal", TanggalAwal);
                HM.put("TanggalAkhir", TanggalAkhir);

                File F = new File(Lokasi);
                JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                viewReport.setTitle("Report - Daftar Berita Acara Serah Terima");
                viewReport.setZoomRatio(new Float(0.80));
                viewReport.setVisible(true);

            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Maaf, Terdapat Kesalahan Dalam Mencetak Report!");
            }
        }
    }//GEN-LAST:event_ButtonPrintActionPerformed

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
            java.util.logging.Logger.getLogger(FormReportBAST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormReportBAST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormReportBAST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormReportBAST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormReportBAST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JButton Button_Close;
    private com.toedter.calendar.JDateChooser Date_BASTAkhir;
    private com.toedter.calendar.JDateChooser Date_BASTAwal;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
