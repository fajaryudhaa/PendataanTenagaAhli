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

public class FormProyek extends javax.swing.JFrame {
    
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
    
    public FormProyek() {
        initComponents();
        setLocationRelativeTo(null);
        PanelBackground.requestFocus();
        
        Config.getConnection();
        
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
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox NamaTA!");
        }
        
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
            Text_NamaProyek.requestFocus();
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
            Text_NamaProyek.requestFocus();
            Combo_Keahlian.setEnabled(false);
            Combo_NamaTA.setEnabled(false);
        }
    }
    
    private void setClear() {
        Text_NamaProyek.setText("");
        Text_PemberiKerjaProyek.setText("");
        Text_LokasiProyek.setText("");
        Text_NomorKontrakProyek.setText("");
        Date_PeriodeAwalProyek.setDate(null);
        Date_PeriodeAkhirProyek.setDate(null);
        Combo_Keahlian.setSelectedItem("Pilih Keahlian");
        Combo_NamaTA.setSelectedItem("Pilih Tenaga Ahli");
        Text_IDTA.setText("");
        Text_PendidikanTerakhirTA.setText("");
        Text_JurusanTA.setText("");
        Text_PengalamanTA.setText("");
    }
    
    public void setDataTable(int row) {
        row += Table_Proyek.getSelectedRow();
        int col = row;
        Text_IDProyek.setText(Table_Proyek.getModel().getValueAt(col, 0).toString());
        Text_NamaProyek.setText(Table_Proyek.getModel().getValueAt(col, 1).toString()); 
        Text_PemberiKerjaProyek.setText(Table_Proyek.getModel().getValueAt(col, 2).toString()); 
        Text_LokasiProyek.setText(Table_Proyek.getModel().getValueAt(col, 3).toString()); 
        Text_NomorKontrakProyek.setText(Table_Proyek.getModel().getValueAt(col, 4).toString());
        try {
            String PeriodeAwalProyek = (String) Table_Proyek.getModel().getValueAt(col, 5);
            java.util.Date Date = new SimpleDateFormat("yyyy-MM-dd").parse(PeriodeAwalProyek);
            Date_PeriodeAwalProyek.setDate(Date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada Tanggal Lahir Pegawai!");
        }
        try {
            String PeriodeAkhirProyek = (String) Table_Proyek.getModel().getValueAt(col, 6);
            java.util.Date Date = new SimpleDateFormat("yyyy-MM-dd").parse(PeriodeAkhirProyek);
            Date_PeriodeAkhirProyek.setDate(Date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada Tanggal Lahir Pegawai!");
        }
        Text_IDTA.setText(Table_Proyek.getModel().getValueAt(col, 7).toString());
        try {
            Config.getData("SELECT * FROM Table_DataTenagaAhli WHERE IDTA = '" + Text_IDTA.getText() + "'");
            while(Config.RS.next()) {
                Combo_NamaTA.setSelectedItem(Config.RS.getString("NamaTA"));
                Text_PendidikanTerakhirTA.setText(Config.RS.getString("PendidikanTerakhirTA"));
                Text_JurusanTA.setText(Config.RS.getString("PendidikanTerakhirTA"));
                Text_PengalamanTA.setText(Config.RS.getString("PendidikanTerakhirTA"));
                Combo_Keahlian.setSelectedItem(Config.RS.getString("KeahlianTA"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Keahlian!");
        }
        
    }
    
    private void setDisable() {   
        Text_IDProyek.setEnabled(false);
        Text_IDTA.setEnabled(false);
        Text_PendidikanTerakhirTA.setEnabled(false);
        Text_JurusanTA.setEnabled(false);
        Text_PengalamanTA.setEnabled(false);
    }
    
    private void setDisplay() { 
        Table_Proyek.changeSelection(0, 0, false, false);
        setDataTable(0);
    }
    
    private void setEnable(boolean TOF) {
        Text_NamaProyek.setEnabled(TOF);
        Text_PemberiKerjaProyek.setEnabled(TOF);
        Text_LokasiProyek.setEnabled(TOF);
        Text_NomorKontrakProyek.setEnabled(TOF);
        Date_PeriodeAwalProyek.setEnabled(TOF);
        Date_PeriodeAkhirProyek.setEnabled(TOF);
        Combo_Keahlian.setEnabled(TOF);
        Combo_NamaTA.setEnabled(TOF);
    }
    
    private void setTable() {
        Config.setTableDesign(Table_Proyek, ScrollPane);
        Config.setTableColumn(Table_Proyek, 9, new int[]{75, 200, 150, 150, 150, 150, 100, 100, 100});
    }
    
    private void setData() {
        DefaultTableModel TB = new DefaultTableModel();
        Table_Proyek.setModel(TB);
        TB.addColumn("ID PROYEK");
        TB.addColumn("NAMA PROYEK");
        TB.addColumn("PEMBERI KERJA");
        TB.addColumn("LOKASI");
        TB.addColumn("NOMOR KONTRAK");
        TB.addColumn("PERIODE AWAL");
        TB.addColumn("PERIODE AKHIR");
        TB.addColumn("ID TA");
        TB.addColumn("STATUS PROYEK");
 
        try { 
            Config.getData("SELECT * FROM Table_Proyek");
            if(!Config.RS.isBeforeFirst()) {
                Text_IDProyek.setText("");
                setButton("Refresh");
                setClear();
                setDisable();
                setEnable(false);
                setTable();
                PanelBackground.requestFocus();
            } else if(Config.RS.isBeforeFirst()) {
                Config.getData("SELECT * FROM Table_Proyek");
                while(Config.RS.next()) {
                    TB.addRow(new Object[] { 
                        Config.RS.getString(1),
                        Config.RS.getString(2), 
                        Config.RS.getString(3), 
                        Config.RS.getString(4), 
                        Config.RS.getString(5), 
                        Config.RS.getString(6), 
                        Config.RS.getString(7), 
                        Config.RS.getString(8), 
                        Config.RS.getString(9), 
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
        Table_Proyek = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Text_IDProyek = new javax.swing.JTextField();
        Text_NamaProyek = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Text_NomorKontrakProyek = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Combo_NamaTA = new javax.swing.JComboBox<>();
        Combo_Keahlian = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        Text_IDTA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Date_PeriodeAwalProyek = new com.toedter.calendar.JDateChooser();
        Text_PemberiKerjaProyek = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Date_PeriodeAkhirProyek = new com.toedter.calendar.JDateChooser();
        Text_LokasiProyek = new javax.swing.JTextField();
        Text_PendidikanTerakhirTA = new javax.swing.JTextField();
        Text_JurusanTA = new javax.swing.JTextField();
        Text_PengalamanTA = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
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

        Table_Proyek.setAutoCreateRowSorter(true);
        Table_Proyek.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Proyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_ProyekMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(Table_Proyek);

        PanelContent.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 1050, 200));
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PERIODE AWAL PROYEK :");
        PanelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));
        PanelContent.add(Text_IDProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 70, 25));
        PanelContent.add(Text_NamaProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 280, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NAMA PROYEK :");
        PanelContent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 68, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PEMBERI KERJA PROYEK :");
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 98, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LOKASI PROYEK :");
        PanelContent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 128, -1, -1));
        PanelContent.add(Text_NomorKontrakProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 280, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NOMOR KONTRAK PROYEK :");
        PanelContent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 158, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("KEAHLIAN YANG DIBUTUHKAN :");
        PanelContent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, 10));

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
        PanelContent.add(Combo_NamaTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 180, 25));

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
        PanelContent.add(Combo_Keahlian, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 270, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TENAGA AHLI :");
        PanelContent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));
        PanelContent.add(Text_IDTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 80, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PENDIDIKAN, JURUSAN & PENGALAMAN :");
        PanelContent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID PROYEK :");
        PanelContent.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 38, -1, -1));

        Date_PeriodeAwalProyek.setBackground(new java.awt.Color(233, 243, 245));
        Date_PeriodeAwalProyek.setOpaque(false);
        PanelContent.add(Date_PeriodeAwalProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 150, 25));
        PanelContent.add(Text_PemberiKerjaProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 280, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PERIODE AKHIR PROYEK :");
        PanelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        Date_PeriodeAkhirProyek.setBackground(new java.awt.Color(233, 243, 245));
        Date_PeriodeAkhirProyek.setOpaque(false);
        PanelContent.add(Date_PeriodeAkhirProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 150, 25));
        PanelContent.add(Text_LokasiProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 280, 25));
        PanelContent.add(Text_PendidikanTerakhirTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 30, 25));
        PanelContent.add(Text_JurusanTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 140, 25));
        PanelContent.add(Text_PengalamanTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 150, 80, 25));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, -1));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 1110, 460));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 502, 1110, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("DATA - PROYEK");
        PanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 17));
        PanelBackground.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 570, 10));

        ButtonAddSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Add.png"))); // NOI18N
        ButtonAddSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Add Hover.png"))); // NOI18N
        ButtonAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddSaveActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonAddSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 100, 35));

        ButtonEditSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Edit.png"))); // NOI18N
        ButtonEditSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Edit Hover.png"))); // NOI18N
        ButtonEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditSaveActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 100, 35));

        ButtonDeleteCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Delete.png"))); // NOI18N
        ButtonDeleteCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Delete Hover.png"))); // NOI18N
        ButtonDeleteCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteCancelActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonDeleteCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 100, 35));

        ButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print.png"))); // NOI18N
        ButtonPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print Hover.png"))); // NOI18N
        ButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, 100, 35));

        ButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close.png"))); // NOI18N
        ButtonClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close Hover.png"))); // NOI18N
        ButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCloseActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 570));

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
                    Config.getData("SELECT MAX(RIGHT(IDProyek, 4)) AS NO FROM Table_Proyek");
                    while(Config.RS.next()) {
                        if(Config.RS.first() == false) {
                            Text_IDProyek.setText("PRYK-0001");
                        } else {
                            Config.RS.last();
                            int Auto_ID = Config.RS.getInt(1) + 1;
                            String Number = String.valueOf(Auto_ID);
                            int noLong = Number.length();

                            for(int i = 0; i < 4 - noLong; i++) {
                                Number = "0" + Number;
                            }
                            Text_IDProyek.setText("PRYK-" + Number);
                        }
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            break;
            
            case "Save" :
                String Regex = "[0-9]+"; 
                if(Text_NamaProyek.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Nama Proyek Tidak Boleh Kosong!");
                    Text_NamaProyek.requestFocus(); 
                    Text_NamaProyek.setText(""); 
                } else if(Text_PemberiKerjaProyek.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Pemberi Kerja Proyek Tidak Boleh Kosong!");
                    Text_PemberiKerjaProyek.requestFocus(); 
                    Text_PemberiKerjaProyek.setText(""); 
                } else if(Text_NomorKontrakProyek.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Nomor Kontrak Proyek Tidak Boleh Kosong!");
                    Text_NomorKontrakProyek.requestFocus(); 
                    Text_NomorKontrakProyek.setText(""); 
                } else if(Date_PeriodeAwalProyek.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Maaf, Periode Awal Proyek Tidak Boleh Kosong!");
                } else if(Date_PeriodeAkhirProyek.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Maaf, Periode Akhir Proyek Tidak Boleh Kosong!");
                } else if(Combo_Keahlian.getSelectedItem().equals("Pilih Keahlian")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Keahlian Harus Dipilih!");
                } else if(Combo_NamaTA.getSelectedItem().equals("Pilih Tenaga Ahli")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Tenaga Ahli Harus Dipilih!");
                } else {
                    try {
                        String Query = "INSERT INTO Table_Proyek"
                                + "(IDProyek, NamaProyek, PemberiKerjaProyek, LokasiProyek, NomorKontrakProyek, "
                                + "PeriodeAwalProyek, PeriodeAkhirProyek, IDTA, StatusProyek) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        
                        java.util.Date PeriodeAwalProyek, PeriodeAkhirProyek;
                        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                        PeriodeAwalProyek = new java.util.Date(Date_PeriodeAwalProyek.getDate().getTime());
                        PeriodeAkhirProyek = new java.util.Date(Date_PeriodeAkhirProyek.getDate().getTime());
                        String sPeriodeAwalProyek = Format.format(PeriodeAwalProyek);
                        String sPeriodeAkhirProyek = Format.format(PeriodeAkhirProyek);
                        
                        Config.updateData(Query);
                        Config.PS.setString(1, Text_IDProyek.getText());
                        Config.PS.setString(2, Text_NamaProyek.getText());
                        Config.PS.setString(3, Text_PemberiKerjaProyek.getText());
                        Config.PS.setString(4, Text_LokasiProyek.getText());
                        Config.PS.setString(5, Text_NomorKontrakProyek.getText());
                        Config.PS.setString(6, sPeriodeAwalProyek);
                        Config.PS.setString(7, sPeriodeAkhirProyek);
                        Config.PS.setString(8, Text_IDTA.getText());
                        Config.PS.setString(9, "Proyek Sedang Berlangsung");

                        int i = 0;
                        if(Config.PS.executeUpdate() != i) {
                            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil!"); 
                            Config.updateData("UPDATE Table_DataTenagaAhli SET StatusTA = ? WHERE IDTA = ?");
                            Config.PS.setString(1, "Sedang Dalam Proyek");
                            Config.PS.setString(2, Text_IDTA.getText());
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
            Config.getData("SELECT * FROM Table_Proyek");
            if(!Config.RS.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                setButton("Refresh");
            } else if(Config.RS.isBeforeFirst()) {
                switch(EditSave) {
                    
                    case "Edit" :
                        setDisable();
                        setEnable(true);
                        setButton("Edit");
                        Text_NamaProyek.requestFocus();
                    break;

                    case "Save" :
                        String Regex = "[0-9]+"; 
                        
                        if(Text_NamaProyek.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Nama Proyek Tidak Boleh Kosong!");
                            Text_NamaProyek.requestFocus(); 
                            Text_NamaProyek.setText(""); 
                        } else if(Text_PemberiKerjaProyek.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Pemberi Kerja Proyek Tidak Boleh Kosong!");
                            Text_PemberiKerjaProyek.requestFocus(); 
                            Text_PemberiKerjaProyek.setText(""); 
                        } else if(Text_NomorKontrakProyek.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Nomor Kontrak Proyek Tidak Boleh Kosong!");
                            Text_NomorKontrakProyek.requestFocus(); 
                            Text_NomorKontrakProyek.setText(""); 
                        } else if(Date_PeriodeAwalProyek.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Maaf, Periode Awal Proyek Tidak Boleh Kosong!");
                        } else if(Date_PeriodeAkhirProyek.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Maaf, Periode Akhir Proyek Tidak Boleh Kosong!");
                        } else if(Combo_Keahlian.getSelectedItem().equals("Pilih Keahlian")) {
                            JOptionPane.showMessageDialog(null, "Maaf, Keahlian Harus Dipilih!");
                        } else if(Combo_NamaTA.getSelectedItem().equals("Pilih Tenaga Ahli")) {
                            JOptionPane.showMessageDialog(null, "Maaf, Tenaga Ahli Harus Dipilih!");
                        } else {
                            try {
                                String Query = "UPDATE Table_Proyek SET NamaProyek = ?, PemberiKerjaProyek = ?, NomorKontrakProyek = ?, "
                                             + "PeriodeAwalProyek = ?, PeriodeAkhirProyek = ?, IDTA = ? StatusProyek = ? WHERE IDProyek = ?";
                               
                                java.util.Date PeriodeAwalProyek, PeriodeAkhirProyek;
                                SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                                PeriodeAwalProyek = new java.util.Date(Date_PeriodeAwalProyek.getDate().getTime());
                                PeriodeAkhirProyek = new java.util.Date(Date_PeriodeAkhirProyek.getDate().getTime());
                                String sPeriodeAwalProyek = Format.format(PeriodeAwalProyek);
                                String sPeriodeAkhirProyek = Format.format(PeriodeAkhirProyek);

                                Config.updateData(Query);
                                Config.PS.setString(1, Text_NamaProyek.getText());
                                Config.PS.setString(2, Text_PemberiKerjaProyek.getText());
                                Config.PS.setString(3, Text_LokasiProyek.getText());
                                Config.PS.setString(4, Text_NomorKontrakProyek.getText());
                                Config.PS.setString(5, sPeriodeAwalProyek);
                                Config.PS.setString(6, sPeriodeAkhirProyek);
                                Config.PS.setString(7, Text_IDTA.getText());
                                Config.PS.setString(8, Text_IDProyek.getText());
                                Config.PS.setString(9, "Proyek Sedang Berlangsung");

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
                    Config.getData("SELECT * FROM Table_Proyek");
                    if(!Config.RS.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                        setButton("Refresh");
                    } else if(Config.RS.isBeforeFirst()) {
                        int Choose = 0;
                        int dialogResult = JOptionPane.showConfirmDialog (null, "Apa Anda Yakin Ingin Menghapus Data?", "Warning", Choose);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            try {
                                Config.updateData("DELETE FROM Table_Proyek WHERE IDProyek = ?");
                                Config.PS.setString(1, Text_IDProyek.getText());
                                int Count = 0;
                                Count = Config.PS.executeUpdate();

                                if(Count != 0) {
                                    JOptionPane.showMessageDialog(null, "Hapus Data Berhasil!");
                                    Config.updateData("UPDATE Table_DataTenagaAhli SET StatusTA = ? WHERE IDTA = ?");
                                    Config.PS.setString(1, "Tidak Dalam Proyek");
                                    Config.PS.setString(2, Text_IDTA.getText());
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

    private void Combo_KeahlianPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Combo_KeahlianPopupMenuWillBecomeInvisible
        try {
            Combo_NamaTA.removeAllItems();
            Combo_NamaTA.addItem("Pilih Tenaga Ahli");
            
            Text_IDTA.setText("");
            Text_PendidikanTerakhirTA.setText("");
            Text_JurusanTA.setText("");
            Text_PengalamanTA.setText("");
            
            String StatusTA = "Tidak Dalam Proyek";
            Config.getData("SELECT NamaTA FROM Table_DataTenagaAhli WHERE KeahlianTA = '" + Combo_Keahlian.getSelectedItem() + "' AND StatusTA = '" + StatusTA + "'");
            while(Config.RS.next()) {
                Combo_NamaTA.addItem(Config.RS.getString("NamaTA"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Keahlian!");
        }
    }//GEN-LAST:event_Combo_KeahlianPopupMenuWillBecomeInvisible

    private void Combo_NamaTAPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_Combo_NamaTAPopupMenuWillBecomeInvisible
        try {
            Config.getData("SELECT * FROM Table_DataTenagaAhli WHERE NamaTA = '" + Combo_NamaTA.getSelectedItem() + "'");
            while(Config.RS.next()) {
                Text_IDTA.setText(Config.RS.getString("IDTA"));
                Text_PendidikanTerakhirTA.setText(Config.RS.getString("PendidikanTerakhirTA"));
                Text_JurusanTA.setText(Config.RS.getString("JurusanTA"));
                Text_PengalamanTA.setText(Config.RS.getString("PengalamanTA"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Keahlian!");
        }
    }//GEN-LAST:event_Combo_NamaTAPopupMenuWillBecomeInvisible

    private void Table_ProyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_ProyekMouseClicked
        setDataTable(0);
        if(AddSave == "Save" || EditSave == "Save") {
            setData();
        }
    }//GEN-LAST:event_Table_ProyekMouseClicked

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        FormReportProyek FRP = new FormReportProyek();
        FRP.setVisible(true);
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
            java.util.logging.Logger.getLogger(FormProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProyek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton ButtonAddSave;
    private javax.swing.JButton ButtonClose;
    public static javax.swing.JButton ButtonDeleteCancel;
    public static javax.swing.JButton ButtonEditSave;
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JComboBox<String> Combo_Keahlian;
    private javax.swing.JComboBox<String> Combo_NamaTA;
    private com.toedter.calendar.JDateChooser Date_PeriodeAkhirProyek;
    private com.toedter.calendar.JDateChooser Date_PeriodeAwalProyek;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table_Proyek;
    private javax.swing.JTextField Text_IDProyek;
    private javax.swing.JTextField Text_IDTA;
    private javax.swing.JTextField Text_JurusanTA;
    private javax.swing.JTextField Text_LokasiProyek;
    private javax.swing.JTextField Text_NamaProyek;
    private javax.swing.JTextField Text_NomorKontrakProyek;
    private javax.swing.JTextField Text_PemberiKerjaProyek;
    private javax.swing.JTextField Text_PendidikanTerakhirTA;
    private javax.swing.JTextField Text_PengalamanTA;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
