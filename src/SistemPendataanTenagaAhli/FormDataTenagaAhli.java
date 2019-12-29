package SistemPendataanTenagaAhli;

import static SistemPendataanTenagaAhli.FormKeahlian.ButtonAddSave;
import static SistemPendataanTenagaAhli.FormKeahlian.ButtonDeleteCancel;
import static SistemPendataanTenagaAhli.FormKeahlian.ButtonEditSave;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;

public class FormDataTenagaAhli extends javax.swing.JFrame {
    
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
    
    
    
    public FormDataTenagaAhli() {
        initComponents();
        setLocationRelativeTo(null);
        PanelBackground.requestFocus();
        
        Config.getConnection();
        
        try {
            Config.getData("SELECT Keahlian FROM Master_Keahlian");
            while(Config.RS.next()) {
                Combo_KeahlianTA.addItem(Config.RS.getString("Keahlian"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Keahlian!");
        }
        
        try {
            Config.getData("SELECT Jurusan FROM Master_Jurusan");
            while(Config.RS.next()) {
                Combo_JurusanTA.addItem(Config.RS.getString("Jurusan"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada ComboBox Jurusan!");
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
            Text_NamaTA.requestFocus();
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
            Text_NamaTA.requestFocus();
        }
    }
    
    private void setClear() {
        Text_NamaTA.setText("");
        Text_TempatLahirTA.setText("");
        Date_TanggalLahirTA.setDate(null);
        Combo_JenisKelaminTA.setSelectedItem("Pilih Kelamin");
        Text_NomorTeleponTA.setText("");
        Text_AlamatTA.setText("");
        Combo_PendidikanTerakhirTA.setSelectedItem("Pilih Pendidikan");
        Combo_JurusanTA.setSelectedItem("Pilih Jurusan");
        Combo_KeahlianTA.setSelectedItem("Pilih Keahlian");
        Text_PengalamanTA.setText("");
    }
    
    public void setDataTable(int row) {
        row += Table_TenagaAhli.getSelectedRow();
        int col = row;
        Text_IDTA.setText(Table_TenagaAhli.getModel().getValueAt(col, 0).toString());
        Text_NamaTA.setText(Table_TenagaAhli.getModel().getValueAt(col, 1).toString()); 
        Text_TempatLahirTA.setText(Table_TenagaAhli.getModel().getValueAt(col, 2).toString()); 
        try {
            String TanggalLahirTA = (String) Table_TenagaAhli.getModel().getValueAt(col, 3);
            java.util.Date Date = new SimpleDateFormat("yyyy-MM-dd").parse(TanggalLahirTA);
            Date_TanggalLahirTA.setDate(Date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf, Terjadi Kesalahan Pada Tanggal Lahir Pegawai!");
        }
        Combo_JenisKelaminTA.setSelectedItem(Table_TenagaAhli.getModel().getValueAt(col, 4).toString()); 
        Text_NomorTeleponTA.setText(Table_TenagaAhli.getModel().getValueAt(col, 5).toString()); 
        Text_AlamatTA.setText(Table_TenagaAhli.getModel().getValueAt(col, 6).toString()); 
        Combo_PendidikanTerakhirTA.setSelectedItem(Table_TenagaAhli.getModel().getValueAt(col, 7).toString()); 
        Combo_JurusanTA.setSelectedItem(Table_TenagaAhli.getModel().getValueAt(col, 8).toString()); 
        Combo_KeahlianTA.setSelectedItem(Table_TenagaAhli.getModel().getValueAt(col, 9).toString()); 
        Text_PengalamanTA.setText(Table_TenagaAhli.getModel().getValueAt(col, 10).toString()); 
    }
    
    private void setDisable() {   
        Text_IDTA.setEnabled(false);
    }
    
    private void setDisplay() { 
        Table_TenagaAhli.changeSelection(0, 0, false, false);
        setDataTable(0);
    }
    
    private void setEnable(boolean TOF) {
        Text_NamaTA.setEnabled(TOF);
        Text_TempatLahirTA.setEnabled(TOF);
        Date_TanggalLahirTA.setEnabled(TOF);
        Combo_JenisKelaminTA.setEnabled(TOF);
        Text_NomorTeleponTA.setEnabled(TOF);
        Text_AlamatTA.setEnabled(TOF);
        Combo_PendidikanTerakhirTA.setEnabled(TOF);
        Combo_JurusanTA.setEnabled(TOF);
        Combo_KeahlianTA.setEnabled(TOF);
        Text_PengalamanTA.setEnabled(TOF);
    }
    
    private void setTable() {
        Config.setTableDesign(Table_TenagaAhli, ScrollPane);
        Config.setTableColumn(Table_TenagaAhli, 12, new int[]{75, 100, 100, 75, 75, 85, 150, 85, 150, 150, 85, 125});
    }
    
    private void setData() {
        DefaultTableModel TB = new DefaultTableModel();
        Table_TenagaAhli.setModel(TB);
        TB.addColumn("ID TA");
        TB.addColumn("NAMA");
        TB.addColumn("LAHIR");
        TB.addColumn("TGL LAHIR");
        TB.addColumn("KELAMIN");
        TB.addColumn("TELEPON");
        TB.addColumn("ALAMAT");
        TB.addColumn("PENDIDIKAN");
        TB.addColumn("JURUSAN");
        TB.addColumn("KEAHLIAN");
        TB.addColumn("PENGALAMAN");
        TB.addColumn("STATUS");
        
        try { 
            Config.getData("SELECT * FROM Table_DataTenagaAhli");
            if(!Config.RS.isBeforeFirst()) {
                Text_IDTA.setText("");
                setButton("Refresh");
                setClear();
                setDisable();
                setEnable(false);
                setTable();
                PanelBackground.requestFocus();
            } else if(Config.RS.isBeforeFirst()) {
                Config.getData("SELECT * FROM Table_DataTenagaAhli");
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
                        Config.RS.getString(10), 
                        Config.RS.getString(11), 
                        Config.RS.getString(12), 
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
        Table_TenagaAhli = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Text_IDTA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Text_NamaTA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Text_NomorTeleponTA = new javax.swing.JTextField();
        Text_TempatLahirTA = new javax.swing.JTextField();
        Date_TanggalLahirTA = new com.toedter.calendar.JDateChooser();
        Combo_JenisKelaminTA = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Text_AlamatTA = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        Combo_KeahlianTA = new javax.swing.JComboBox<>();
        Combo_PendidikanTerakhirTA = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        Combo_JurusanTA = new javax.swing.JComboBox<>();
        Text_PengalamanTA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        PanelContent.setToolTipText("");
        PanelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table_TenagaAhli.setAutoCreateRowSorter(true);
        Table_TenagaAhli.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_TenagaAhli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_TenagaAhliMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(Table_TenagaAhli);

        PanelContent.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 890, 200));
        PanelContent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ALAMAT :");
        PanelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));
        PanelContent.add(Text_IDTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 70, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMOR TELEPON :");
        PanelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 188, -1, -1));
        PanelContent.add(Text_NamaTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 150, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NAMA TENAGA AHLI :");
        PanelContent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 68, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TEMPAT LAHIR :");
        PanelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 98, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TANGGAL LAHIR :");
        PanelContent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 128, -1, -1));
        PanelContent.add(Text_NomorTeleponTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 100, 25));
        PanelContent.add(Text_TempatLahirTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 130, 25));

        Date_TanggalLahirTA.setBackground(new java.awt.Color(233, 243, 245));
        Date_TanggalLahirTA.setOpaque(false);
        PanelContent.add(Date_TanggalLahirTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 150, 25));

        Combo_JenisKelaminTA.setBackground(new java.awt.Color(240, 240, 240));
        Combo_JenisKelaminTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelamin", "Pria", "Wanita" }));
        PanelContent.add(Combo_JenisKelaminTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 100, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("JENIS KELAMIN :");
        PanelContent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 158, -1, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Text_AlamatTA.setColumns(20);
        Text_AlamatTA.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Text_AlamatTA.setLineWrap(true);
        Text_AlamatTA.setRows(5);
        Text_AlamatTA.setWrapStyleWord(true);
        jScrollPane1.setViewportView(Text_AlamatTA);

        PanelContent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 270, 84));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PENDIDIKAN & JURUSAN :");
        PanelContent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, 10));

        Combo_KeahlianTA.setBackground(new java.awt.Color(240, 240, 240));
        Combo_KeahlianTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Keahlian" }));
        PanelContent.add(Combo_KeahlianTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 270, 25));

        Combo_PendidikanTerakhirTA.setBackground(new java.awt.Color(240, 240, 240));
        Combo_PendidikanTerakhirTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Pendidikan", "S1", "S2", "S3" }));
        PanelContent.add(Combo_PendidikanTerakhirTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 100, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("KEAHLIAN :");
        PanelContent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        Combo_JurusanTA.setBackground(new java.awt.Color(240, 240, 240));
        Combo_JurusanTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jurusan" }));
        PanelContent.add(Combo_JurusanTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 160, 25));
        PanelContent.add(Text_PengalamanTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 100, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PENGALAMAN :");
        PanelContent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID TENAGA AHLI :");
        PanelContent.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 38, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/PTViramaKarya.png"))); // NOI18N
        PanelContent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        PanelBackground.add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 932, 450));
        PanelBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 502, 940, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("DATA - TENAGA AHLI");
        PanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 17));
        PanelBackground.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 570, 10));

        ButtonAddSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Add.png"))); // NOI18N
        ButtonAddSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Add Hover.png"))); // NOI18N
        ButtonAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddSaveActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonAddSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 100, 35));

        ButtonEditSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Edit.png"))); // NOI18N
        ButtonEditSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Edit Hover.png"))); // NOI18N
        ButtonEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditSaveActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 100, 35));

        ButtonDeleteCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Delete.png"))); // NOI18N
        ButtonDeleteCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Delete Hover.png"))); // NOI18N
        ButtonDeleteCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteCancelActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonDeleteCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 100, 35));

        ButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print.png"))); // NOI18N
        ButtonPrint.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Print Hover.png"))); // NOI18N
        ButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 100, 35));

        ButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close.png"))); // NOI18N
        ButtonClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Button Close Hover.png"))); // NOI18N
        ButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCloseActionPerformed(evt);
            }
        });
        PanelBackground.add(ButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 20, 20));

        getContentPane().add(PanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 936, 570));

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
                    Config.getData("SELECT MAX(RIGHT(IDTA, 4)) AS NO FROM Table_DataTenagaAhli");
                    while(Config.RS.next()) {
                        if(Config.RS.first() == false) {
                            Text_IDTA.setText("TA-0001");
                        } else {
                            Config.RS.last();
                            int Auto_ID = Config.RS.getInt(1) + 1;
                            String Number = String.valueOf(Auto_ID);
                            int noLong = Number.length();

                            for(int i = 0; i < 4 - noLong; i++) {
                                Number = "0" + Number;
                            }
                            Text_IDTA.setText("TA-" + Number);
                        }
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            break;
            
            case "Save" :
                String Regex = "[0-9]+"; 
                if(Text_NamaTA.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Nama Tenaga Ahli Tidak Boleh Kosong!");
                    Text_NamaTA.requestFocus(); 
                    Text_NamaTA.setText(""); 
                } else if(Text_TempatLahirTA.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Tempat Lahir Tenaga Ahli Tidak Boleh Kosong!");
                    Text_TempatLahirTA.requestFocus(); 
                    Text_TempatLahirTA.setText(""); 
                } else if(Date_TanggalLahirTA.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Maaf, Tanggal Lahir Tenaga Ahli Tidak Boleh Kosong!");
                } else if(Combo_JenisKelaminTA.getSelectedItem().equals("Pilih Jenis Kelamin")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Jenis Kelamin Tenaga Ahli Harus Dipilih!");
                } else if(Text_NomorTeleponTA.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Nomor Telepon Tenaga Ahli Tidak Boleh Kosong!");
                    Text_NomorTeleponTA.requestFocus(); 
                    Text_NomorTeleponTA.setText(""); 
                } else if(!Text_NomorTeleponTA.getText().matches(Regex)) {
                    JOptionPane.showMessageDialog(null, "Maaf, Nomor Telepon Tenaga Ahli Hanya Boleh Diinput Dengan Angka!");
                    Text_NomorTeleponTA.requestFocus(); 
                    Text_NomorTeleponTA.setText(""); 
                } else if(Text_NomorTeleponTA.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "Maaf, Nomor Telepon Tenaga Ahli Tidak Boleh Diinput Lebih Dari 30 Digit!");
                    Text_NomorTeleponTA.requestFocus(); 
                    Text_NomorTeleponTA.setText(""); 
                } else if(Text_AlamatTA.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Alamat Ahli Tidak Boleh Kosong!");
                    Text_AlamatTA.requestFocus(); 
                    Text_AlamatTA.setText(""); 
                } else if(Combo_PendidikanTerakhirTA.getSelectedItem().equals("Pilih Pendidikan")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Pendidikan Tenaga Ahli Harus Dipilih!");
                } else if(Combo_JurusanTA.getSelectedItem().equals("Pilih Jurusan")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Jurusan Tenaga Ahli Harus Dipilih!");
                } else if(Combo_KeahlianTA.getSelectedItem().equals("Pilih Keahlian")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Keahlian Tenaga Ahli Harus Dipilih!");
                } else if(Text_PengalamanTA.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Maaf, Pengalaman Tenaga Ahli Tidak Boleh Kosong!");
                    Text_PengalamanTA.requestFocus(); 
                    Text_PengalamanTA.setText(""); 
                } else {
                    try {
                        String Query = "INSERT INTO Table_DataTenagaAhli"
                                + "(IDTA, NamaTA, TempatLahirTA, TanggalLahirTA, JenisKelaminTA, NomorTeleponTA, "
                                + "AlamatTA, PendidikanTerakhirTA, JurusanTA, KeahlianTA, PengalamanTA, StatusTA) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        
                        java.util.Date TanggalLahirTA;
                        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                        TanggalLahirTA = new java.util.Date(Date_TanggalLahirTA.getDate().getTime());
                        String sTanggalLahirTA = Format.format(TanggalLahirTA);
                        
                        Config.updateData(Query);
                        Config.PS.setString(1, Text_IDTA.getText());
                        Config.PS.setString(2, Text_NamaTA.getText());
                        Config.PS.setString(3, Text_TempatLahirTA.getText());
                        Config.PS.setString(4, sTanggalLahirTA);
                        Config.PS.setString(5, Combo_JenisKelaminTA.getSelectedItem().toString());
                        Config.PS.setString(6, Text_NomorTeleponTA.getText());
                        Config.PS.setString(7, Text_AlamatTA.getText());
                        Config.PS.setString(8, Combo_PendidikanTerakhirTA.getSelectedItem().toString());
                        Config.PS.setString(9, Combo_JurusanTA.getSelectedItem().toString());
                        Config.PS.setString(10, Combo_KeahlianTA.getSelectedItem().toString());
                        Config.PS.setString(11, Text_PengalamanTA.getText());
                        Config.PS.setString(12, "Tidak Dalam Proyek");

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
            Config.getData("SELECT * FROM Table_DataTenagaAhli");
            if(!Config.RS.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                setButton("Refresh");
            } else if(Config.RS.isBeforeFirst()) {
                switch(EditSave) {
                    
                    case "Edit" :
                        setButton("Edit");
                        setDisable();
                        setEnable(true);
                        Text_NamaTA.requestFocus();
                    break;

                    case "Save" :
                        String Regex = "[0-9]+"; 

                        if(Text_NamaTA.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Nama Tenaga Ahli Tidak Boleh Kosong!");
                            Text_NamaTA.requestFocus(); 
                            Text_NamaTA.setText(""); 
                        } else if(Text_TempatLahirTA.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Tempat Lahir Tenaga Ahli Tidak Boleh Kosong!");
                            Text_TempatLahirTA.requestFocus(); 
                            Text_TempatLahirTA.setText(""); 
                        } else if(Date_TanggalLahirTA.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Maaf, Tanggal Lahir Tenaga Ahli Tidak Boleh Kosong!");
                        } else if(Combo_JenisKelaminTA.getSelectedItem().equals("Pilih Jenis Kelamin")) {
                            JOptionPane.showMessageDialog(null, "Maaf, Jenis Kelamin Tenaga Ahli Harus Dipilih!");
                        } else if(Text_NomorTeleponTA.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Nomor Telepon Tenaga Ahli Tidak Boleh Kosong!");
                            Text_NomorTeleponTA.requestFocus(); 
                            Text_NomorTeleponTA.setText(""); 
                        } else if(!Text_NomorTeleponTA.getText().matches(Regex)) {
                            JOptionPane.showMessageDialog(null, "Maaf, Nomor Telepon Tenaga Ahli Hanya Boleh Diinput Dengan Angka!");
                            Text_NomorTeleponTA.requestFocus(); 
                            Text_NomorTeleponTA.setText(""); 
                        } else if(Text_NomorTeleponTA.getText().length() > 20) {
                            JOptionPane.showMessageDialog(null, "Maaf, Nomor Telepon Tenaga Ahli Tidak Boleh Diinput Lebih Dari 30 Digit!");
                            Text_NomorTeleponTA.requestFocus(); 
                            Text_NomorTeleponTA.setText(""); 
                        } else if(Text_AlamatTA.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Alamat Ahli Tidak Boleh Kosong!");
                            Text_AlamatTA.requestFocus(); 
                            Text_AlamatTA.setText(""); 
                        } else if(Combo_PendidikanTerakhirTA.getSelectedItem().equals("Pilih Pendidikan")) {
                            JOptionPane.showMessageDialog(null, "Maaf, Pendidikan Tenaga Ahli Harus Dipilih!");
                        } else if(Combo_JurusanTA.getSelectedItem().equals("Pilih Jurusan")) {
                            JOptionPane.showMessageDialog(null, "Maaf, Jurusan Tenaga Ahli Harus Dipilih!");
                        } else if(Combo_KeahlianTA.getSelectedItem().equals("Pilih Keahlian")) {
                            JOptionPane.showMessageDialog(null, "Maaf, Keahlian Tenaga Ahli Harus Dipilih!");
                        } else if(Text_PengalamanTA.getText().length() < 1) {
                            JOptionPane.showMessageDialog(null, "Maaf, Pengalaman Tenaga Ahli Tidak Boleh Kosong!");
                            Text_PengalamanTA.requestFocus(); 
                            Text_PengalamanTA.setText(""); 
                        } else {
                            try {
                                String Query = "UPDATE Table_DataTenagaAhli SET NamaTA = ?, TempatLahirTA = ?, TanggalLahirTA = ?, "
                                             + "JenisKelaminTA = ?, NomorTeleponTA = ?, AlamatTA = ?, PendidikanTerakhirTA = ?, "
                                             + "JurusanTA = ?, KeahlianTA = ?, PengalamanTA = ?, StatusTA = ? WHERE IDTA = ?";
                               
                                java.util.Date TanggalLahirTA;
                                SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
                                TanggalLahirTA = new java.util.Date(Date_TanggalLahirTA.getDate().getTime());
                                String sTanggalLahirTA = Format.format(TanggalLahirTA);

                                Config.updateData(Query);
                                Config.PS.setString(1, Text_NamaTA.getText());
                                Config.PS.setString(2, Text_TempatLahirTA.getText());
                                Config.PS.setString(3, sTanggalLahirTA);
                                Config.PS.setString(4, Combo_JenisKelaminTA.getSelectedItem().toString());
                                Config.PS.setString(5, Text_NomorTeleponTA.getText());
                                Config.PS.setString(6, Text_AlamatTA.getText());
                                Config.PS.setString(7, Combo_PendidikanTerakhirTA.getSelectedItem().toString());
                                Config.PS.setString(8, Combo_JurusanTA.getSelectedItem().toString());
                                Config.PS.setString(9, Combo_KeahlianTA.getSelectedItem().toString());
                                Config.PS.setString(10, Text_PengalamanTA.getText());
                                Config.PS.setString(11, "Tidak Dalam Proyek");
                                Config.PS.setString(12, Text_IDTA.getText());

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
                    Config.getData("SELECT * FROM Table_DataTenagaAhli");
                    if(!Config.RS.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null, "Maaf, Data Masih Kosong! Tolong Diisi Terlebih Dahulu!");
                        setButton("Refresh");
                    } else if(Config.RS.isBeforeFirst()) {
                        int Choose = 0;
                        int dialogResult = JOptionPane.showConfirmDialog (null, "Apa Anda Yakin Ingin Menghapus Data?", "Warning", Choose);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            try {
                                Config.updateData("DELETE FROM Table_DataTenagaAhli WHERE IDTA = ?");
                                Config.PS.setString(1, Text_IDTA.getText());
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

    private void ButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_ButtonCloseActionPerformed

    private void Table_TenagaAhliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_TenagaAhliMouseClicked
        setDataTable(0);
        if(AddSave == "Save" || EditSave == "Save") {
            setData();
        }
    }//GEN-LAST:event_Table_TenagaAhliMouseClicked

    private void ButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintActionPerformed
        FormReportTenagaAhli FRTA = new FormReportTenagaAhli();
        FRTA.setVisible(true);
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
            java.util.logging.Logger.getLogger(FormDataTenagaAhli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataTenagaAhli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataTenagaAhli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataTenagaAhli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataTenagaAhli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton ButtonAddSave;
    private javax.swing.JButton ButtonClose;
    public static javax.swing.JButton ButtonDeleteCancel;
    public static javax.swing.JButton ButtonEditSave;
    private javax.swing.JButton ButtonPrint;
    private javax.swing.JComboBox<String> Combo_JenisKelaminTA;
    private javax.swing.JComboBox<String> Combo_JurusanTA;
    private javax.swing.JComboBox<String> Combo_KeahlianTA;
    private javax.swing.JComboBox<String> Combo_PendidikanTerakhirTA;
    private com.toedter.calendar.JDateChooser Date_TanggalLahirTA;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table_TenagaAhli;
    private javax.swing.JTextArea Text_AlamatTA;
    private javax.swing.JTextField Text_IDTA;
    private javax.swing.JTextField Text_NamaTA;
    private javax.swing.JTextField Text_NomorTeleponTA;
    private javax.swing.JTextField Text_PengalamanTA;
    private javax.swing.JTextField Text_TempatLahirTA;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
