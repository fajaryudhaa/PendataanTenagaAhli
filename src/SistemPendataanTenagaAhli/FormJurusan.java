package SistemPendataanTenagaAhli;

import static SistemPendataanTenagaAhli.FormKeahlian.ButtonAddSave;
import static SistemPendataanTenagaAhli.FormKeahlian.ButtonDeleteCancel;
import static SistemPendataanTenagaAhli.FormKeahlian.ButtonEditSave;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
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

public class FormJurusan extends javax.swing.JFrame {
    
    String AddSave = "Add";
    String EditSave = "Edit";
    String DeleteCancel = "Delete"; 
    
    static Icon iAddSave = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Add.png");
    static Icon iAddSaveHover = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Add Hover.png");
    static Icon iEditSave = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Edit.png");
    static Icon iEditSaveHover = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Edit Hover.png");
    static Icon iSave = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Save.png");
    static Icon iSaveHover = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Save Hover.png");
    static Icon iDeleteCancel = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Delete.png");
    static Icon iDeleteCancelHover = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Delete Hover.png");
    static Icon iCancel = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Cancel.png");
    static Icon iCancelHover = new ImageIcon("src/SistemPendataanTenagaAhli/ImagesFile/Button Cancel Hover.png");
    
    public FormJurusan() {
        initComponents();
        setLocationRelativeTo(null);
        PanelBackground.requestFocus();
        
        Config.getConnection();
        setData();
        setTable();
        
        if(FormLogin.HakAkses.equals("User")) {
            ButtonAddSave.setEnabled(false);
            ButtonEditSave.setEnabled(false);
            ButtonDeleteCancel.setEnabled(false);
        }
    }
   
    private void setButton(String Set) {
        if(Set == "Refresh") {
            ButtonAddSave.setEnabled(true);
            ButtonEditSave.setEnabled(true);
            ButtonDeleteCancel.setEnabled(true);
            ButtonPrint.setEnabled(true);
            ButtonAddSave.setIcon(iAddSave);
            ButtonEditSave.setIcon(iEditSave);
            ButtonDeleteCancel.setIcon(iDeleteCancel);
            ButtonAddSave.setRolloverIcon(iAddSaveHover);
            ButtonEditSave.setRolloverIcon(iEditSaveHover);
            ButtonDeleteCancel.setRolloverIcon(iDeleteCancelHover);
            AddSave = "Add";
            EditSave = "Edit";
            DeleteCancel = "Delete";
        } else if(Set == "Add") {
            ButtonAddSave.setEnabled(true);
            ButtonEditSave.setEnabled(false);
            ButtonDeleteCancel.setEnabled(true);
            ButtonAddSave.setIcon(iSave);
            ButtonDeleteCancel.setIcon(iCancel);
            ButtonAddSave.setRolloverIcon(iSaveHover);
            ButtonDeleteCancel.setRolloverIcon(iCancelHover);
            AddSave = "Save";
            DeleteCancel = "Cancel";
            Text_Jurusan.requestFocus();
        } else if(Set == "Edit") {
            ButtonAddSave.setEnabled(false);
            ButtonEditSave.setEnabled(true);
            ButtonDeleteCancel.setEnabled(true);
            ButtonEditSave.setIcon(iSave);
            ButtonDeleteCancel.setIcon(iCancel);
            ButtonEditSave.setRolloverIcon(iSaveHover);
            ButtonDeleteCancel.setRolloverIcon(iCancelHover);
            EditSave = "Save";
            DeleteCancel = "Cancel";
            Text_Jurusan.requestFocus();
        }
    }
    
    private void setClear() {
        Text_IDJurusan.setText("");
        Text_Jurusan.setText("");
    }
    
    public void setDataTable(int row) {
        row += Table_Jurusan.getSelectedRow();
        int col = row;
        Text_IDJurusan.setText(Table_Jurusan.getModel().getValueAt(col, 0).toString());
        Text_Jurusan.setText(Table_Jurusan.getModel().getValueAt(col, 1).toString()); 
    }
    
    private void setDisable() {   
        Text_IDJurusan.setEnabled(false);
    }
    
    private void setDisplay() { 
        Table_Jurusan.changeSelection(0, 0, false, false);
        setDataTable(0);
    }
    
    private void setEnable(boolean TOF) {
        Text_Jurusan.setEnabled(TOF);
    }
    
    private void setTable() {
        Config.setTableDesign(Table_Jurusan, ScrollPane);
        Config.setTableColumn(Table_Jurusan, 2, new int[]{200, 290});
    }
    
    private void setData() {
        DefaultTableModel TB = new DefaultTableModel();
        Table_Jurusan.setModel(TB);
        TB.addColumn("ID JURUSAN");
        TB.addColumn("JURUSAN");
        
        try { 
            Config.getData("SELECT * FROM Master_Jurusan");
            if(!Config.RS.isBeforeFirst()) {
                Text_IDJurusan.setText("");
                setButton("Refresh");
                setClear();
                setDisable();
                setEnable(false);
                setTable();
                PanelBackground.requestFocus();
            } else if(Config.RS.isBeforeFirst()) {
                Config.getData("SELECT * FROM Master_Jurusan");
                while(Config.RS.next()) {
                    TB.addRow(new Object[] { 
                        Config.RS.getString(1),
                        Config.RS.getString(2), 
                    }); 
                }
                setButton("Refresh");
                setDisable();
                setDisplay();
                setEnable(false);
                setTable();
                PanelBackground.requestFocus();
            }
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada setData()"); 
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        PanelBackground = new javax.swing.JPanel();
        PanelContent = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        Table_Jurusan = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Text_IDJurusan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Text_Jurusan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ButtonAddSave = new javax.swing.JButton();
        ButtonEditSave = new javax.swing.JButton();
        ButtonDeleteCancel = new javax.swing.JButton();
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

        Table_Jurusan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_Jurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_JurusanMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(Table_Jurusan);
        if (Table_Jurusan.getColumnModel().getColumnCount() > 0) {
            Table_Jurusan.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            Table_Jurusan.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            Table_Jurusan.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            Table_Jurusan.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        PanelContent.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 510, 180));
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID JURUSAN :");
        PanelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 38, -1, -1));
        PanelContent.add(Text_IDJurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 30, 81, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("JURUSAN :");
        PanelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 78, -1, -1));
        PanelContent.add(Text_Jurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 70, 150, 25));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 566, 370));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 413, 570, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("DATA MASTER - JURUSAN");
        PanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 17));
        PanelBackground.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 570, 10));

        ButtonAddSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Add.png"))); // NOI18N
        ButtonAddSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Add Hover.png"))); // NOI18N
        ButtonAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddSaveActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonAddSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 100, 35));

        ButtonEditSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Edit.png"))); // NOI18N
        ButtonEditSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Edit Hover.png"))); // NOI18N
        ButtonEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditSaveActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 100, 35));

        ButtonDeleteCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Delete.png"))); // NOI18N
        ButtonDeleteCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Delete Hover.png"))); // NOI18N
        ButtonDeleteCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteCancelActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonDeleteCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 100, 35));

        ButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print.png"))); // NOI18N
        ButtonPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print Hover.png"))); // NOI18N
        ButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 100, 35));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close Hover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PanelBackground.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddSaveActionPerformed
        switch(AddSave) {
            case "Add" : 
                
                setButton("Add");
                setClear();
                setDisable();
                setEnable(true);
                
                try {
                    Config.getData("SELECT MAX(RIGHT(IDJurusan, 4)) AS NO FROM Master_Jurusan");
                    while(Config.RS.next()) {
                        if(Config.RS.first() == false) {
                            Text_IDJurusan.setText("JUR-0001");
                        } else {
                            Config.RS.last();
                            int Auto_ID = Config.RS.getInt(1) + 1;
                            String Number = String.valueOf(Auto_ID);
                            int noLong = Number.length();

                            for(int i = 0; i < 4 - noLong; i++) {
                                Number = "0" + Number;
                            }
                            Text_IDJurusan.setText("JUR-" + Number);
                        }
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            break;
            
            case "Save" :
                String Regex = "[0-9]+"; 
                
                if(Text_Jurusan.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Jurusan Tidak Boleh Kosong!");
                    Text_Jurusan.requestFocus(); 
                    Text_Jurusan.setText(""); 
                } else {
                    try {
                        String Query = "INSERT INTO Master_Jurusan(IDJurusan, Jurusan) VALUES (?, ?)";
                        Config.updateData(Query);
                        Config.PS.setString(1, Text_IDJurusan.getText());
                        Config.PS.setString(2, Text_Jurusan.getText());

                        int i = 0;
                        if(Config.PS.executeUpdate() != i) {
                            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Maaf, Simpan Data Gagal!");
                        }
                        setButton("Refresh");
                        setData();
                    } catch(SQLException e) {
                        e.printStackTrace();
                    }   
                }
            break;
        }
    }//GEN-LAST:event_ButtonAddSaveActionPerformed

    private void ButtonEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditSaveActionPerformed
        try {
            Config.getData("SELECT * FROM Master_Jurusan");
            if(!Config.RS.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                setButton("Refresh");
            } else if(Config.RS.isBeforeFirst()) {
                switch(EditSave) {
                    
                    case "Edit" :
                        setButton("Edit");
                        setDisable();
                        setEnable(true);
                        Text_Jurusan.requestFocus();
                    break;

                    case "Save" :
                        String Regex = "[0-9]+"; 

                        if(Text_Jurusan.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Jurusan Tidak Boleh Kosong!");
                            Text_Jurusan.requestFocus(); 
                            Text_Jurusan.setText(""); 
                        } else {
                            try {
                                String Query = "UPDATE Master_Jurusan SET Jurusan = ? WHERE IDJurusan = ?";
                                Config.updateData(Query);
                                Config.PS.setString(1, Text_Jurusan.getText());
                                Config.PS.setString(2, Text_IDJurusan.getText());

                                int i = 0;
                                if(Config.PS.executeUpdate() != i) {
                                    JOptionPane.showMessageDialog(null, "Update Data Berhasil!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Maaf, Update Data Gagal!");
                                }
                                setButton("Refresh");
                                setData();
                            } catch(SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    break;
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan!");
        }
    }//GEN-LAST:event_ButtonEditSaveActionPerformed

    private void ButtonDeleteCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteCancelActionPerformed
        switch(DeleteCancel) {
            case "Delete" :
                try {
                    Config.getData("SELECT * FROM Master_Jurusan");
                    if(!Config.RS.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                        setButton("Refresh");
                    } else if(Config.RS.isBeforeFirst()) {
                        int Choose = 0;
                        int dialogResult = JOptionPane.showConfirmDialog (null, "Apa Anda Yakin Ingin Menghapus Data?", "Warning", Choose);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            try {
                                Config.updateData("DELETE FROM Master_Jurusan WHERE IDJurusan = ?");
                                Config.PS.setString(1, Text_IDJurusan.getText());
                                int Count = 0;
                                Count = Config.PS.executeUpdate();

                                if(Count != 0) {
                                    JOptionPane.showMessageDialog(null, "Hapus Data Berhasil!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Hapus Data Gagal!");
                                }
                                setData();
                                setButton("Refresh");  
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Dalam Hapus Data!");
                            }
                        }
                    } 
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan!");
                }
            break;

            case "Cancel" :
                setData();
            break;
        }
    }//GEN-LAST:event_ButtonDeleteCancelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Table_JurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_JurusanMouseClicked
        setDataTable(0);
        if(AddSave == "Save" || EditSave == "Save") {
            setData();
        }
    }//GEN-LAST:event_Table_JurusanMouseClicked

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        try {
                String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                String Lokasi = "src/Report/DaftarJurusan.jasper";

                HashMap HM = new HashMap(1);
                HM.put("ViramaKarya", Logo);

                File F = new File(Lokasi);
                JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                viewReport.setTitle("Report - Daftar Jurusan");
                viewReport.setZoomRatio(new Float(0.80));
                viewReport.setVisible(true);

            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Maaf, Terdapat Kesalahan Dalam Mencetak Report!");
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
            java.util.logging.Logger.getLogger(FormJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJurusan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton ButtonAddSave;
    public static javax.swing.JButton ButtonDeleteCancel;
    public static javax.swing.JButton ButtonEditSave;
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table_Jurusan;
    private javax.swing.JTextField Text_IDJurusan;
    private javax.swing.JTextField Text_Jurusan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
