package SistemPendataanTenagaAhli;

import static SistemPendataanTenagaAhli.FormKeahlian.ButtonAddSave;
import static SistemPendataanTenagaAhli.FormKeahlian.ButtonDeleteCancel;
import static SistemPendataanTenagaAhli.FormKeahlian.ButtonEditSave;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormBAST extends javax.swing.JFrame {
    
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
    
    public FormBAST() {
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
            
            try {
                String StatusProyek = "Proyek Sedang Berlangsung";
                Config.getData("SELECT NamaProyek FROM Table_Proyek");
                while(Config.RS.next()) {
                    Combo_NamaProyek.addItem(Config.RS.getString("NamaProyek"));
                }
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Nama Proyek!");
            }   
            
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
            Combo_NamaProyek.setEnabled(false);
        }
    }
    
    private void setClear() {
        Date_TanggalBAST.setDate(null);
        Text_NomorBAST.setText("");
        Combo_NamaProyek.setSelectedItem("Pilih Nama Proyek");
        Text_IDProyek.setText("");
        Text_LokasiProyek.setText("");
        Text_NomorKontrakProyek.setText("");
    }
    
    public void setDataTable(int row) {
        row += Table_BAST.getSelectedRow();
        int col = row;
        Text_IDBAST.setText(Table_BAST.getModel().getValueAt(col, 0).toString());
        try {
            String TanggalBAST = (String) Table_BAST.getModel().getValueAt(col, 1);
            java.util.Date Date = new SimpleDateFormat("yyyy-MM-dd").parse(TanggalBAST);
            Date_TanggalBAST.setDate(Date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada Tanggal Lahir Pegawai!");
        }
               
        Text_NomorBAST.setText(Table_BAST.getModel().getValueAt(col, 2).toString());
        Text_IDProyek.setText(Table_BAST.getModel().getValueAt(col, 3).toString());
        
        try {
            String IDProyek = (String) Table_BAST.getModel().getValueAt(col, 3);
            Config.getData("SELECT NamaProyek FROM Table_Proyek WHERE IDProyek = '" + IDProyek + "'");
            while(Config.RS.next()) {
                Combo_NamaProyek.setSelectedItem(Config.RS.getString("NamaProyek"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Nama Proyek!");
        } 
        
       //Combo_NamaProyek.setSelectedItem(Table_BAST.getModel().getValueAt(col, 4).toString());
        Text_LokasiProyek.setText(Table_BAST.getModel().getValueAt(col, 5).toString());
        Text_NomorKontrakProyek.setText(Table_BAST.getModel().getValueAt(col, 6).toString());
    }
    
    private void setDisable() {   
        Text_IDBAST.setEnabled(false);
        Text_IDProyek.setEnabled(false);
        Text_LokasiProyek.setEnabled(false);
        Text_NomorKontrakProyek.setEnabled(false);
    }
    
    private void setDisplay() { 
        Table_BAST.changeSelection(0, 0, false, false);
        setDataTable(0);
    }
    
    private void setEnable(boolean TOF) {
        Text_IDBAST.setEnabled(TOF);
        Date_TanggalBAST.setEnabled(TOF);
        Text_NomorBAST.setEnabled(TOF);
        Combo_NamaProyek.setEnabled(TOF);
    }
    
    private void setTable() {
        Config.setTableDesign(Table_BAST, ScrollPane);
        Config.setTableColumn(Table_BAST, 7, new int[]{100, 100, 175, 100, 175, 175, 175});
    }
    
    private void setData() {
        DefaultTableModel TB = new DefaultTableModel();
        Table_BAST.setModel(TB);
        TB.addColumn("ID BAST");
        TB.addColumn("TANGGAL BAST");
        TB.addColumn("NOMOR BAST");
        TB.addColumn("ID PROYEK");
        TB.addColumn("NAMA PROYEK");
        TB.addColumn("LOKASI PROYEK");
        TB.addColumn("NOMOR KONTRAK PROYEK");
 
        try { 
            Config.getData("SELECT * FROM Table_BAST");
            if(!Config.RS.isBeforeFirst()) {
                Text_IDBAST.setText("");
                setButton("Refresh");
                setClear();
                setDisable();
                setEnable(false);
                setTable();
                PanelBackground.requestFocus();
            } else if(Config.RS.isBeforeFirst()) {
                String Query = "SELECT " +
                               "table_bast.`IDBAST` AS table_bast_IDBAST, " +
                               "table_bast.`TanggalBAST` AS table_bast_TanggalBAST, " +
                               "table_bast.`NomorBAST` AS table_bast_NomorBAST, " +
                               "table_bast.`IDProyek` AS table_bast_IDProyek, " +
                               "table_proyek.`IDProyek` AS table_proyek_IDProyek, " +
                               "table_proyek.`NamaProyek` AS table_proyek_NamaProyek, " +
                               "table_proyek.`PemberiKerjaProyek` AS table_proyek_PemberiKerjaProyek, " +
                               "table_proyek.`LokasiProyek` AS table_proyek_LokasiProyek, " +
                               "table_proyek.`NomorKontrakProyek` AS table_proyek_NomorKontrakProyek, " +
                               "table_proyek.`PeriodeAwalProyek` AS table_proyek_PeriodeAwalProyek, " +
                               "table_proyek.`PeriodeAkhirProyek` AS table_proyek_PeriodeAkhirProyek, " +
                               "table_proyek.`IDTA` AS table_proyek_IDTA, " +
                               "table_proyek.`StatusProyek` AS table_proyek_StatusProyek " +
                               "FROM " +
                               "`table_proyek` table_proyek " +
                               "INNER JOIN " +
                               "`table_bast` table_bast " +
                               "ON " +
                               "table_proyek.`IDProyek` = table_bast.`IDProyek`";
                Config.getData(Query);
                while(Config.RS.next()) {
                    TB.addRow(new Object[] { 
                        Config.RS.getString("table_bast_IDBAST"),
                        Config.RS.getString("table_bast_TanggalBAST"),
                        Config.RS.getString("table_bast_NomorBAST"),
                        Config.RS.getString("table_proyek_IDProyek"),
                        Config.RS.getString("table_proyek_NamaProyek"),
                        Config.RS.getString("table_proyek_LokasiProyek"),
                        Config.RS.getString("table_proyek_NomorKontrakProyek"),
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
        Table_BAST = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Text_IDBAST = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Text_NomorKontrakProyek = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Combo_NamaProyek = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        Date_TanggalBAST = new com.toedter.calendar.JDateChooser();
        Text_NomorBAST = new javax.swing.JTextField();
        Text_IDProyek = new javax.swing.JTextField();
        Text_LokasiProyek = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ButtonAddSave = new javax.swing.JButton();
        ButtonEditSave = new javax.swing.JButton();
        ButtonDeleteCancel = new javax.swing.JButton();
        ButtonPrint = new javax.swing.JButton();
        ButtonClose = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBackground.setBackground(new java.awt.Color(255, 255, 255));
        PanelBackground.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        PanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelContent.setBackground(new java.awt.Color(0, 153, 153));
        PanelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table_BAST.setAutoCreateRowSorter(true);
        Table_BAST.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_BAST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_BASTMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(Table_BAST);

        PanelContent.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1020, 210));
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LOKASI PROYEK :");
        PanelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 100, -1));
        PanelContent.add(Text_IDBAST, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 70, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TANGGAL :");
        PanelContent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 68, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NOMOR BAST :");
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 98, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NAMA PROYEK :");
        PanelContent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 128, -1, -1));
        PanelContent.add(Text_NomorKontrakProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 220, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NOMOR KONTRAK PROYEK :");
        PanelContent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 150, -1));

        Combo_NamaProyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Nama Proyek" }));
        Combo_NamaProyek.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                Combo_NamaProyekPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        PanelContent.add(Combo_NamaProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 280, 25));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID BAST :");
        PanelContent.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 38, -1, -1));

        Date_TanggalBAST.setBackground(new java.awt.Color(233, 243, 245));
        Date_TanggalBAST.setOpaque(false);
        PanelContent.add(Date_TanggalBAST, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 150, 25));
        PanelContent.add(Text_NomorBAST, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 280, 25));
        PanelContent.add(Text_IDProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 70, 25));
        PanelContent.add(Text_LokasiProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 220, 25));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 100, 150));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 1060, 430));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 472, 1070, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("DATA - BERITA ACARA SERAH TERIMA");
        PanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 17));
        PanelBackground.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 570, 10));

        ButtonAddSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Add.png"))); // NOI18N
        ButtonAddSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Add Hover.png"))); // NOI18N
        ButtonAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddSaveActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonAddSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 100, 35));

        ButtonEditSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Edit.png"))); // NOI18N
        ButtonEditSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Edit Hover.png"))); // NOI18N
        ButtonEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditSaveActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 100, 35));

        ButtonDeleteCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Delete.png"))); // NOI18N
        ButtonDeleteCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Delete Hover.png"))); // NOI18N
        ButtonDeleteCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteCancelActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonDeleteCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 100, 35));

        ButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print.png"))); // NOI18N
        ButtonPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print Hover.png"))); // NOI18N
        ButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 100, 35));

        ButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close.png"))); // NOI18N
        ButtonClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close Hover.png"))); // NOI18N
        ButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCloseActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1065, 550));

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
                    Config.getData("SELECT MAX(RIGHT(IDBAST, 4)) AS NO FROM Table_BAST");
                    while(Config.RS.next()) {
                        if(Config.RS.first() == false) {
                            Text_IDBAST.setText("BAST-0001");
                        } else {
                            Config.RS.last();
                            int Auto_ID = Config.RS.getInt(1) + 1;
                            String Number = String.valueOf(Auto_ID);
                            int noLong = Number.length();

                            for(int i = 0; i < 4 - noLong; i++) {
                                Number = "0" + Number;
                            }
                            Text_IDBAST.setText("BAST-" + Number);
                        }
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
                
                Combo_NamaProyek.removeAllItems();
                Combo_NamaProyek.addItem("Pilih Nama Proyek");
                try {
                    String StatusProyek = "Proyek Sedang Berlangsung";
                    Config.getData("SELECT NamaProyek FROM Table_Proyek WHERE StatusProyek = '" + StatusProyek + "'");
                    while(Config.RS.next()) {
                        Combo_NamaProyek.addItem(Config.RS.getString("NamaProyek"));
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Nama Proyek!");
                } 
                
            break;
            
            case "Save" :
                String Regex = "[0-9]+"; 
                if(Date_TanggalBAST.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Maaf, Tanggal BAST Tidak Boleh Kosong!");
                } else if(Text_NomorBAST.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Nomor BAST Tidak Boleh Kosong!");
                    Text_NomorBAST.requestFocus(); 
                    Text_NomorBAST.setText(""); 
                } else if(Combo_NamaProyek.getSelectedItem().equals("Pilih Nama Proyek")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Nama Proyek Harus Dipilih!");
                } else {
                    try {
                        String Query = "INSERT INTO Table_BAST"
                                + "(IDBAST, TanggalBAST, NomorBAST, IDProyek) "
                                + "VALUES (?, ?, ?, ?)";
                        
                        java.util.Date TanggalBAST;
                        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                        TanggalBAST = new java.util.Date(Date_TanggalBAST.getDate().getTime());
                        String sTanggalBAST = Format.format(TanggalBAST);
                        
                        Config.updateData(Query);
                        Config.PS.setString(1, Text_IDBAST.getText());
                        Config.PS.setString(2, sTanggalBAST);
                        Config.PS.setString(3, Text_NomorBAST.getText());
                        Config.PS.setString(4, Text_IDProyek.getText());

                        int i = 0;
                        if(Config.PS.executeUpdate() != i) {
                            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil!");
                            
                            Config.updateData("UPDATE Table_Proyek SET StatusProyek = ? WHERE IDProyek = ?");
                            Config.PS.setString(1, "Proyek Selesai");
                            Config.PS.setString(2, Text_IDProyek.getText());
                            Config.PS.executeUpdate();
                            
                            String gQuery = "SELECT " +
                                           "table_proyek.`IDProyek` AS table_proyek_IDProyek, " +
                                           "table_proyek.`NamaProyek` AS table_proyek_NamaProyek, " +
                                           "table_proyek.`PemberiKerjaProyek` AS table_proyek_PemberiKerjaProyek, " +
                                           "table_proyek.`LokasiProyek` AS table_proyek_LokasiProyek, " +
                                           "table_proyek.`NomorKontrakProyek` AS table_proyek_NomorKontrakProyek, " +
                                           "table_proyek.`PeriodeAwalProyek` AS table_proyek_PeriodeAwalProyek, " +
                                           "table_proyek.`PeriodeAkhirProyek` AS table_proyek_PeriodeAkhirProyek, " +
                                           "table_proyek.`IDTA` AS table_proyek_IDTA, " +
                                           "table_datatenagaahli.`IDTA` AS table_datatenagaahli_IDTA, " +
                                           "table_datatenagaahli.`NamaTA` AS table_datatenagaahli_NamaTA, " +
                                           "table_datatenagaahli.`TempatLahirTA` AS table_datatenagaahli_TempatLahirTA, " +
                                           "table_datatenagaahli.`TanggalLahirTA` AS table_datatenagaahli_TanggalLahirTA, " +
                                           "table_datatenagaahli.`JenisKelaminTA` AS table_datatenagaahli_JenisKelaminTA, " +
                                           "table_datatenagaahli.`NomorTeleponTA` AS table_datatenagaahli_NomorTeleponTA, " +
                                           "table_datatenagaahli.`AlamatTA` AS table_datatenagaahli_AlamatTA, " +
                                           "table_datatenagaahli.`PendidikanTerakhirTA` AS table_datatenagaahli_PendidikanTerakhirTA, " +
                                           "table_datatenagaahli.`JurusanTA` AS table_datatenagaahli_JurusanTA, " +
                                           "table_datatenagaahli.`KeahlianTA` AS table_datatenagaahli_KeahlianTA, " +
                                           "table_datatenagaahli.`PengalamanTA` AS table_datatenagaahli_PengalamanTA, " +
                                           "table_datatenagaahli.`StatusTA` AS table_datatenagaahli_StatusTA " +
                                           "FROM " +
                                           "`table_datatenagaahli` table_datatenagaahli " +
                                           "INNER JOIN " +
                                           "`table_proyek` table_proyek " +
                                           "ON " +
                                           "table_datatenagaahli.`IDTA` = table_proyek.`IDTA` WHERE table_proyek.`IDProyek` = '" + Text_IDProyek.getText() + "'";
                            Config.getData(gQuery);
                            String IDTA = null;
                            while(Config.RS.next()) {
                                IDTA = Config.RS.getString("table_datatenagaahli_IDTA");
                            }

                            Config.updateData("UPDATE Table_DataTenagaAhli SET StatusTA = ? WHERE IDTA = ?");
                            Config.PS.setString(1, "Tidak Dalam Proyek");
                            Config.PS.setString(2, IDTA);
                            Config.PS.executeUpdate();
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
            Config.getData("SELECT * FROM Table_BAST");
            if(!Config.RS.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                setButton("Refresh");
            } else if(Config.RS.isBeforeFirst()) {
                switch(EditSave) {
                    
                    case "Edit" :
                        setDisable();
                        setEnable(true);
                        setButton("Edit");
                    break;

                    case "Save" :
                        String Regex = "[0-9]+"; 
                        if(Date_TanggalBAST.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Maaf, Tanggal BAST Tidak Boleh Kosong!");
                        } else if(Text_NomorBAST.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Nomor BAST Tidak Boleh Kosong!");
                            Text_NomorBAST.requestFocus(); 
                            Text_NomorBAST.setText(""); 
                        } else if(Combo_NamaProyek.getSelectedItem().equals("Pilih Nama Proyek")) {
                            JOptionPane.showMessageDialog(null, "Maaf, Nama Proyek Harus Dipilih!");
                        } else {
                            try {
                                String Query = "UPDATE Table_BAST SET TanggalBAST = ?, NomorBAST = ?, IDProyek = ? "
                                             + "WHERE IDBAST = ?";
                               
                                java.util.Date TanggalBAST;
                                SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                                TanggalBAST = new java.util.Date(Date_TanggalBAST.getDate().getTime());
                                String sTanggalBAST = Format.format(TanggalBAST);

                                Config.updateData(Query);
                                Config.PS.setString(1, sTanggalBAST);
                                Config.PS.setString(2, Text_NomorBAST.getText());
                                Config.PS.setString(3, Text_IDProyek.getText());
                                Config.PS.setString(4, Text_IDBAST.getText());

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
                    Config.getData("SELECT * FROM Table_BAST");
                    if(!Config.RS.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                        setButton("Refresh");
                    } else if(Config.RS.isBeforeFirst()) {
                        int Choose = 0;
                        int dialogResult = JOptionPane.showConfirmDialog (null, "Apa Anda Yakin Ingin Menghapus Data?", "Warning", Choose);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            try {
                                Config.updateData("DELETE FROM Table_BAST WHERE IDBAST = ?");
                                Config.PS.setString(1, Text_IDBAST.getText());
                                int Count = 0;
                                Count = Config.PS.executeUpdate();

                                if(Count != 0) {
                                    JOptionPane.showMessageDialog(null, "Hapus Data Berhasil!");
                                    
                                    Config.updateData("UPDATE Table_Proyek SET StatusProyek = ? WHERE IDProyek = ?");
                                    Config.PS.setString(1, "Proyek Sedang Berlangsung");
                                    Config.PS.setString(2, Text_IDProyek.getText());
                                    Config.PS.executeUpdate();

                                    String gQuery = "SELECT " +
                                                   "table_proyek.`IDProyek` AS table_proyek_IDProyek, " +
                                                   "table_proyek.`NamaProyek` AS table_proyek_NamaProyek, " +
                                                   "table_proyek.`PemberiKerjaProyek` AS table_proyek_PemberiKerjaProyek, " +
                                                   "table_proyek.`LokasiProyek` AS table_proyek_LokasiProyek, " +
                                                   "table_proyek.`NomorKontrakProyek` AS table_proyek_NomorKontrakProyek, " +
                                                   "table_proyek.`PeriodeAwalProyek` AS table_proyek_PeriodeAwalProyek, " +
                                                   "table_proyek.`PeriodeAkhirProyek` AS table_proyek_PeriodeAkhirProyek, " +
                                                   "table_proyek.`IDTA` AS table_proyek_IDTA, " +
                                                   "table_datatenagaahli.`IDTA` AS table_datatenagaahli_IDTA, " +
                                                   "table_datatenagaahli.`NamaTA` AS table_datatenagaahli_NamaTA, " +
                                                   "table_datatenagaahli.`TempatLahirTA` AS table_datatenagaahli_TempatLahirTA, " +
                                                   "table_datatenagaahli.`TanggalLahirTA` AS table_datatenagaahli_TanggalLahirTA, " +
                                                   "table_datatenagaahli.`JenisKelaminTA` AS table_datatenagaahli_JenisKelaminTA, " +
                                                   "table_datatenagaahli.`NomorTeleponTA` AS table_datatenagaahli_NomorTeleponTA, " +
                                                   "table_datatenagaahli.`AlamatTA` AS table_datatenagaahli_AlamatTA, " +
                                                   "table_datatenagaahli.`PendidikanTerakhirTA` AS table_datatenagaahli_PendidikanTerakhirTA, " +
                                                   "table_datatenagaahli.`JurusanTA` AS table_datatenagaahli_JurusanTA, " +
                                                   "table_datatenagaahli.`KeahlianTA` AS table_datatenagaahli_KeahlianTA, " +
                                                   "table_datatenagaahli.`PengalamanTA` AS table_datatenagaahli_PengalamanTA, " +
                                                   "table_datatenagaahli.`StatusTA` AS table_datatenagaahli_StatusTA " +
                                                   "FROM " +
                                                   "`table_datatenagaahli` table_datatenagaahli " +
                                                   "INNER JOIN " +
                                                   "`table_proyek` table_proyek " +
                                                   "ON " +
                                                   "table_datatenagaahli.`IDTA` = table_proyek.`IDTA` WHERE table_proyek.`IDProyek` = '" + Text_IDProyek.getText() + "'";
                                    Config.getData(gQuery);
                                    String IDTA = null;
                                    while(Config.RS.next()) {
                                        IDTA = Config.RS.getString("table_datatenagaahli_IDTA");
                                    }

                                    Config.updateData("UPDATE Table_DataTenagaAhli SET StatusTA = ? WHERE IDTA = ?");
                                    Config.PS.setString(1, "Sedang Dalam Proyek");
                                    Config.PS.setString(2, IDTA);
                                    Config.PS.executeUpdate();
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

    private void ButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_ButtonCloseActionPerformed

    private void Combo_NamaProyekPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Combo_NamaProyekPopupMenuWillBecomeInvisible
        try {
            String Query = "SELECT IDProyek, LokasiProyek, NomorKontrakProyek " +
                           "FROM Table_Proyek WHERE NamaProyek = '" + Combo_NamaProyek.getSelectedItem() + "'";
           
            Config.getData(Query);
            while(Config.RS.next()) {
                Text_IDProyek.setText(Config.RS.getString("IDProyek"));
                Text_LokasiProyek.setText(Config.RS.getString("LokasiProyek"));
                Text_NomorKontrakProyek.setText(Config.RS.getString("NomorKontrakProyek"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Nama Proyek!");
        }
    }//GEN-LAST:event_Combo_NamaProyekPopupMenuWillBecomeInvisible

    private void Table_BASTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_BASTMouseClicked
        setDataTable(0);
        if(AddSave == "Save" || EditSave == "Save") {
            setData();
        }
    }//GEN-LAST:event_Table_BASTMouseClicked

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        FormReportBAST FRBAST = new FormReportBAST();
        FRBAST.setVisible(true);
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
            java.util.logging.Logger.getLogger(FormBAST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBAST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBAST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBAST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBAST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton ButtonAddSave;
    private javax.swing.JButton ButtonClose;
    public static javax.swing.JButton ButtonDeleteCancel;
    public static javax.swing.JButton ButtonEditSave;
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JComboBox<String> Combo_NamaProyek;
    private com.toedter.calendar.JDateChooser Date_TanggalBAST;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table_BAST;
    private javax.swing.JTextField Text_IDBAST;
    private javax.swing.JTextField Text_IDProyek;
    private javax.swing.JTextField Text_LokasiProyek;
    private javax.swing.JTextField Text_NomorBAST;
    private javax.swing.JTextField Text_NomorKontrakProyek;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
