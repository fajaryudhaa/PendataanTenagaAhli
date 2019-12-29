package SistemPendataanTenagaAhli;

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

public class FormKeahlian extends javax.swing.JFrame {
    
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
    
    public FormKeahlian() {
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
            Text_Keahlian.requestFocus();
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
            Text_Keahlian.requestFocus();
        }
    }
    
    private void setClear() {
        Text_IDKeahlian.setText("");
        Text_Keahlian.setText("");
    }
    
    public void setDataTable(int row) {
        row += Table_Keahlian.getSelectedRow();
        int col = row;
        Text_IDKeahlian.setText(Table_Keahlian.getModel().getValueAt(col, 0).toString());
        Text_Keahlian.setText(Table_Keahlian.getModel().getValueAt(col, 1).toString()); 
    }
    
    private void setDisable() {   
        Text_IDKeahlian.setEnabled(false);
    }
    
    private void setDisplay() { 
        Table_Keahlian.changeSelection(0, 0, false, false);
        setDataTable(0);
    }
    
    private void setEnable(boolean TOF) {
        Text_Keahlian.setEnabled(TOF);
    }
    
    private void setTable() {
        Config.setTableDesign(Table_Keahlian, ScrollPane);
        Config.setTableColumn(Table_Keahlian, 2, new int[]{200, 290});
    }
    
    private void setData() {
        DefaultTableModel TB = new DefaultTableModel();
        Table_Keahlian.setModel(TB);
        TB.addColumn("ID KEAHLIAN");
        TB.addColumn("KEAHLIAN");
        
        try { 
            Config.getData("SELECT * FROM Master_Keahlian");
            if(!Config.RS.isBeforeFirst()) {
                Text_IDKeahlian.setText("");
                setButton("Refresh");
                setClear();
                setDisable();
                setEnable(false);
                //setTable();
                PanelBackground.requestFocus();
            } else if(Config.RS.isBeforeFirst()) {
                Config.getData("SELECT * FROM Master_Keahlian");
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
                //setTable();
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
        Table_Keahlian = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Text_IDKeahlian = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Text_Keahlian = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
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

        Table_Keahlian.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Keahlian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_KeahlianMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(Table_Keahlian);

        PanelContent.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 510, 180));
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("ID KEAHLIAN :");
        PanelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 38, -1, -1));
        PanelContent.add(Text_IDKeahlian, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 30, 81, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 84, 84));
        jLabel3.setText("KEAHLIAN :");
        PanelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 78, -1, -1));
        PanelContent.add(Text_Keahlian, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 70, 270, 25));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 566, 370));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 413, 570, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("DATA MASTER - KEAHLIAN");
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
                    Config.getData("SELECT MAX(RIGHT(IDKeahlian, 4)) AS NO FROM Master_Keahlian");
                    while(Config.RS.next()) {
                        if(Config.RS.first() == false) {
                            Text_IDKeahlian.setText("AHLI-0001");
                        } else {
                            Config.RS.last();
                            int Auto_ID = Config.RS.getInt(1) + 1;
                            String Number = String.valueOf(Auto_ID);
                            int noLong = Number.length();

                            for(int i = 0; i < 4 - noLong; i++) {
                                Number = "0" + Number;
                            }
                            Text_IDKeahlian.setText("AHLI-" + Number);
                        }
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            break;
            
            case "Save" :
                String Regex = "[0-9]+"; 
                
                if(Text_Keahlian.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Keahlian Tidak Boleh Kosong!");
                    Text_Keahlian.requestFocus(); 
                    Text_Keahlian.setText(""); 
                } else {
                    try {
                        String Query = "INSERT INTO Master_Keahlian(IDKeahlian, Keahlian) VALUES (?, ?)";
                        Config.updateData(Query);
                        Config.PS.setString(1, Text_IDKeahlian.getText());
                        Config.PS.setString(2, Text_Keahlian.getText());

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
            Config.getData("SELECT * FROM Master_Keahlian");
            if(!Config.RS.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                setButton("Refresh");
            } else if(Config.RS.isBeforeFirst()) {
                switch(EditSave) {
                    
                    case "Edit" :
                        setButton("Edit");
                        setDisable();
                        setEnable(true);
                        Text_Keahlian.requestFocus();
                    break;

                    case "Save" :
                        String Regex = "[0-9]+"; 

                        if(Text_Keahlian.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Keahlian Tidak Boleh Kosong!");
                            Text_Keahlian.requestFocus(); 
                            Text_Keahlian.setText(""); 
                        } else {
                            try {
                                String Query = "UPDATE Master_Keahlian SET Keahlian = ? WHERE IDKeahlian = ?";
                                Config.updateData(Query);
                                Config.PS.setString(1, Text_Keahlian.getText());
                                Config.PS.setString(2, Text_IDKeahlian.getText());


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
                    Config.getData("SELECT * FROM Master_Keahlian");
                    if(!Config.RS.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                        setButton("Refresh");
                    } else if(Config.RS.isBeforeFirst()) {
                        int Choose = 0;
                        int dialogResult = JOptionPane.showConfirmDialog (null, "Apa Anda Yakin Ingin Menghapus Data?", "Warning", Choose);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            try {
                                Config.updateData("DELETE FROM Master_Keahlian WHERE IDKeahlian = ?");
                                Config.PS.setString(1, Text_IDKeahlian.getText());
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

    private void Table_KeahlianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_KeahlianMouseClicked
        setDataTable(0);
        if(AddSave == "Save" || EditSave == "Save") {
            setData();
        }
    }//GEN-LAST:event_Table_KeahlianMouseClicked

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        try {
                String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                String Lokasi = "src/Report/DaftarKeahlian.jasper";

                HashMap HM = new HashMap(1);
                HM.put("ViramaKarya", Logo);

                File F = new File(Lokasi);
                JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                viewReport.setTitle("Report - Daftar Keahlian");
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
            java.util.logging.Logger.getLogger(FormKeahlian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKeahlian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKeahlian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKeahlian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKeahlian().setVisible(true);
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
    private javax.swing.JTable Table_Keahlian;
    private javax.swing.JTextField Text_IDKeahlian;
    private javax.swing.JTextField Text_Keahlian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
