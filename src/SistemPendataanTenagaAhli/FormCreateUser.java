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

public class FormCreateUser extends javax.swing.JFrame {
    
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
    
    public FormCreateUser() {
        initComponents();
        setLocationRelativeTo(null);
        PanelBackground.requestFocus();
        
        Config.getConnection();
        setData();
        setTable();
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
            Text_Username.requestFocus();
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
            Text_Username.requestFocus();
        }
    }
    
    private void setClear() {
        Text_Username.setText("");
        Text_Password.setText("");
        Combo_HakAkses.setSelectedItem("Pilih Hak Akses");
    }
    
    public void setDataTable(int row) {
        row += Table_CreateUser.getSelectedRow();
        int col = row;
        Text_IDUser.setText(Table_CreateUser.getModel().getValueAt(col, 0).toString());
        Text_Username.setText(Table_CreateUser.getModel().getValueAt(col, 1).toString()); 
        
        try {
            Config.getData("SELECT Password FROM Table_User WHERE IDUser = '" + Text_IDUser.getText() + "'");
            while(Config.RS.next()) {
                Text_Password.setText(Config.RS.getString("Password"));
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada Textfield Password");
        }
        
        Combo_HakAkses.setSelectedItem(Table_CreateUser.getModel().getValueAt(col, 3).toString()); 
    }
    
    private void setDisable() {   
        Text_IDUser.setEnabled(false);
    }
    
    private void setDisplay() { 
        Table_CreateUser.changeSelection(0, 0, false, false);
        setDataTable(0);
    }
    
    private void setEnable(boolean TOF) {
        Text_Username.setEnabled(TOF);
        Text_Password.setEnabled(TOF);
        Combo_HakAkses.setEnabled(TOF);
    }
    
    private void setTable() {
        Config.setTableDesign(Table_CreateUser, ScrollPane);
        Config.setTableColumn(Table_CreateUser, 4, new int[]{165, 170, 165, 170});
        Table_CreateUser.getColumnModel().getColumn(2).setWidth(0);
        Table_CreateUser.getColumnModel().getColumn(2).setMinWidth(0);
        Table_CreateUser.getColumnModel().getColumn(2).setMaxWidth(0);
    }
    
    private void setData() {
        DefaultTableModel TB = new DefaultTableModel();
        Table_CreateUser.setModel(TB);
        TB.addColumn("ID USER");
        TB.addColumn("USERNAME");
        TB.addColumn("PASSWORD");
        TB.addColumn("HAK AKSES");
        
        try { 
            Config.getData("SELECT * FROM Table_User");
            if(!Config.RS.isBeforeFirst()) {
                Text_IDUser.setText("");
                setButton("Refresh");
                setClear();
                setDisable();
                setEnable(false);
                setTable();
                PanelBackground.requestFocus();
            } else if(Config.RS.isBeforeFirst()) {
                Config.getData("SELECT * FROM Table_User");
                while(Config.RS.next()) {
                    TB.addRow(new Object[] { 
                        Config.RS.getString(1),
                        Config.RS.getString(2), 
                        Config.RS.getString(3), 
                        Config.RS.getString(4), 
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
        jToggleButton1 = new javax.swing.JToggleButton();
        PanelBackground = new javax.swing.JPanel();
        PanelContent = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        Table_CreateUser = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Text_IDUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Text_Username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Combo_HakAkses = new javax.swing.JComboBox<>();
        Text_Password = new javax.swing.JPasswordField();
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

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBackground.setBackground(new java.awt.Color(255, 255, 255));
        PanelBackground.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        PanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelContent.setBackground(new java.awt.Color(0, 153, 153));
        PanelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table_CreateUser.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_CreateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_CreateUserMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(Table_CreateUser);

        PanelContent.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 590, 190));
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID USER :");
        PanelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 38, -1, -1));
        PanelContent.add(Text_IDUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 81, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USERNAME :");
        PanelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 78, -1, -1));
        PanelContent.add(Text_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD :");
        PanelContent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 38, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("HAK AKSES :");
        PanelContent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 78, -1, -1));

        Combo_HakAkses.setBackground(new java.awt.Color(240, 240, 240));
        Combo_HakAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Hak Akses", "Admin", "User" }));
        PanelContent.add(Combo_HakAkses, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 120, 25));
        PanelContent.add(Text_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 120, 25));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 630, 370));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 413, 630, 10));

        jLabel1.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("UTILITAS - CREATE USER");
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
        PanelBackground.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 480));

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
                    Config.getData("SELECT MAX(RIGHT(IDUser, 4)) AS NO FROM Table_User");
                    while(Config.RS.next()) {
                        if(Config.RS.first() == false) {
                            Text_IDUser.setText("USER-0001");
                        } else {
                            Config.RS.last();
                            int Auto_ID = Config.RS.getInt(1) + 1;
                            String Number = String.valueOf(Auto_ID);
                            int noLong = Number.length();

                            for(int i = 0; i < 4 - noLong; i++) {
                                Number = "0" + Number;
                            }
                            Text_IDUser.setText("USER-" + Number);
                        }
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            break;
            
            case "Save" :
                String Regex = "[0-9]+"; 
                
                String Password = "";
                char [] Pass = Text_Password.getPassword();
                for(int i = 0; i < Pass.length; i++) {
                    Password += Pass[i];
                }
                
                if(Text_Username.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Username Tidak Boleh Kosong!");
                    Text_Username.requestFocus(); 
                    Text_Username.setText(""); 
                } else if(Password.length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Password Tidak Boleh Kosong!");
                    Text_Password.requestFocus(); 
                    Text_Password.setText(""); 
                } else if(Combo_HakAkses.getSelectedItem().equals("Pilih Hak Akses")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Jurusan Tidak Boleh Kosong!");
                } else {
                    try {
                        String Query = "INSERT INTO Table_User(IDUser, Username, Password, HakAkses) VALUES (?, ?, ?, ?)";
                        Config.updateData(Query);
                        Config.PS.setString(1, Text_IDUser.getText());
                        Config.PS.setString(2, Text_Username.getText());
                        Config.PS.setString(3, Password);
                        Config.PS.setString(4, Combo_HakAkses.getSelectedItem().toString());

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
                        Text_Username.requestFocus();
                    break;

                    case "Save" :
                        String Password = "";
                        char [] Pass = Text_Password.getPassword();
                        for(int i = 0; i < Pass.length; i++) {
                            Password += Pass[i];
                        }
                        
                        String Regex = "[0-9]+"; 

                        if(Text_Username.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Username Tidak Boleh Kosong!");
                            Text_Username.requestFocus(); 
                            Text_Username.setText(""); 
                        } else if(Password.length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Password Tidak Boleh Kosong!");
                            Text_Password.requestFocus(); 
                            Text_Password.setText(""); 
                        } else if(Combo_HakAkses.getSelectedItem().equals("Pilih Hak Akses")) {
                            JOptionPane.showMessageDialog(null, "Maaf, Jurusan Tidak Boleh Kosong!");
                        } else {
                            try {
                                String Query = "UPDATE Table_User SET Username = ?, Password = ?, HakAkses = ? WHERE IDUser = ?";
                                Config.updateData(Query);
                                Config.PS.setString(1, Text_IDUser.getText());
                                Config.PS.setString(2, Text_Username.getText());
                                Config.PS.setString(3, Password);
                                Config.PS.setString(4, Combo_HakAkses.getSelectedItem().toString());

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
                    Config.getData("SELECT * FROM Table_User");
                    if(!Config.RS.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                        setButton("Refresh");
                    } else if(Config.RS.isBeforeFirst()) {
                        int Choose = 0;
                        int dialogResult = JOptionPane.showConfirmDialog (null, "Apa Anda Yakin Ingin Menghapus Data?", "Warning", Choose);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            try {
                                Config.updateData("DELETE FROM Table_User WHERE IDUser = ?");
                                Config.PS.setString(1, Text_IDUser.getText());
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

    private void Table_CreateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_CreateUserMouseClicked
        setDataTable(0);
        if(AddSave == "Save" || EditSave == "Save") {
            setData();
        }
    }//GEN-LAST:event_Table_CreateUserMouseClicked

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        try {
                String Logo = new File("src\\Report\\LogoViramaKarya\\PTViramaKarya.png").getAbsolutePath();
                String Lokasi = "src/Report/DaftarUser.jasper";

                HashMap HM = new HashMap(1);
                HM.put("ViramaKarya", Logo);

                File F = new File(Lokasi);
                JasperReport jasperReport=(JasperReport)JRLoader.loadObject(F);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, Config.getConnection());
                JasperViewer viewReport = new JasperViewer(jasperPrint, false);

                viewReport.setTitle("Report - Daftar User");
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
            java.util.logging.Logger.getLogger(FormCreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAddSave;
    private javax.swing.JButton ButtonDeleteCancel;
    private javax.swing.JButton ButtonEditSave;
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JComboBox<String> Combo_HakAkses;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table_CreateUser;
    private javax.swing.JTextField Text_IDUser;
    private javax.swing.JPasswordField Text_Password;
    private javax.swing.JTextField Text_Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
