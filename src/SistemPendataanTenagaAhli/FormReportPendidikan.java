package SistemPendataanTenagaAhli;

import com.toedter.calendar.JTextFieldDateEditor;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class FormReportPendidikan extends javax.swing.JFrame {
    
    public FormReportPendidikan() {
        initComponents();
        setLocationRelativeTo(null);
        PanelBackground.requestFocus();
        
        Config.getConnection();
        
        
        
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        PanelBackground = new javax.swing.JPanel();
        PanelContent = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        ButtonPrint = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
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
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PENDIDIKAN :");
        PanelContent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 10));

        ButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print.png"))); // NOI18N
        ButtonPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print Hover.png"))); // NOI18N
        ButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintActionPerformed(evt);
            }
        });
        PanelContent.add(ButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 100, 35));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 130));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 553, 150));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 192, 570, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("REPORT - BERDASARKAN PENDIDIKAN");
        PanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 17));

        Button_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close.png"))); // NOI18N
        Button_Close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close Hover.png"))); // NOI18N
        Button_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CloseActionPerformed(evt);
            }
        });
        PanelBackground.add(Button_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 557, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CloseActionPerformed
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_Button_CloseActionPerformed

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        try{
            String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
            String Response1 = JOptionPane.showInputDialog(null, "Pendidikan","Laporan Pendidikan",JOptionPane.QUESTION_MESSAGE);
            String NamaFile = "./src/Report/DaftarPendidikan.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/pt_viramakarya","root","");
            HashMap param = new HashMap();
            //Mengambil parameter
            param.put("ViramaKarya",Logo);
            param.put("JURUSAN",Response1);

            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data tidak dapat di cetak","cetak data",JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null, ex);
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
            java.util.logging.Logger.getLogger(FormReportPendidikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormReportPendidikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormReportPendidikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormReportPendidikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormReportPendidikan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JButton Button_Close;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
