package SistemPendataanTenagaAhli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class FormMenuUtama extends javax.swing.JFrame {

    public FormMenuUtama() {
        initComponents();
        setLocationRelativeTo(null);
        
        if(FormLogin.HakAkses.equals("User")) {
            MenuItemCreateUser.setEnabled(false);
        }
        
        LabelUser.setText(FormLogin.User.toUpperCase());
        
        Date D = new Date();
        SimpleDateFormat S = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        LabelDate.setText(S.format(D));

        new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date D = new Date();
                SimpleDateFormat S = new SimpleDateFormat("hh:mm:ss a");
                LabelTime.setText(S.format(D).toUpperCase());
            }    
        }).start();
        
        
        Menubar.setUI(new BasicMenuBarUI(){
            public void paint(Graphics g, JComponent c){
                g.setColor (Color.decode("#009999"));
                g.fillRect (0, 0, c.getWidth(), c.getHeight());
            }
        });
        
        Menubar.add(Box.createRigidArea(new Dimension(10, 50)));
        
        MenuDataMaster.setPreferredSize(new Dimension(110, 40));
        MenuTenagaAhli.setPreferredSize(new Dimension(110, 40));
        MenuProyekDanBAST.setPreferredSize(new Dimension(120, 40));
        MenuReport.setPreferredSize(new Dimension(85, 40));
        MenuUtilitas.setPreferredSize(new Dimension(85, 40));
        
        MenuItemJurusan.setPreferredSize(new Dimension(120, 40));
        MenuItemKeahlian.setPreferredSize(new Dimension(120, 40));
        MenuItemTenagaAhli.setPreferredSize(new Dimension(150, 40));
        MenuItemDataProyek.setPreferredSize(new Dimension(150, 40));
        MenuItemDataBAST.setPreferredSize(new Dimension(150, 40));
        MenuItemReportTenagaAhli.setPreferredSize(new Dimension(150, 40));
        MenuItemReportProyek.setPreferredSize(new Dimension(150, 40));
        MenuItemReportBAST.setPreferredSize(new Dimension(150, 40));
        MenuItemCreateUser.setPreferredSize(new Dimension(150, 40));
        MenuItemLogout.setPreferredSize(new Dimension(150, 40));
        MenuItemExit.setPreferredSize(new Dimension(150, 40));
        MenuItemReportPENDIDIKAN.setPreferredSize(new Dimension(150, 40));
        
        MenuItemJurusan.setBackground(Color.decode("#009999"));
        MenuItemJurusan.setOpaque(true);
        Separator_DataMaster.setBackground(Color.decode("#009999"));
        Separator_DataMaster.setOpaque(true);
        MenuItemKeahlian.setBackground(Color.decode("#009999"));
        MenuItemKeahlian.setOpaque(true);
        
        MenuItemTenagaAhli.setBackground(Color.decode("#009999"));
        MenuItemTenagaAhli.setOpaque(true);
        
        MenuItemDataProyek.setBackground(Color.decode("#009999"));
        MenuItemDataProyek.setOpaque(true);
        Separator_ProyekDanBAST.setBackground(Color.decode("#009999"));
        Separator_ProyekDanBAST.setOpaque(true);
        MenuItemDataBAST.setBackground(Color.decode("#009999"));
        MenuItemDataBAST.setOpaque(true);
        MenuItemReportTenagaAhli.setBackground(Color.decode("#009999"));
        MenuItemReportTenagaAhli.setOpaque(true);
        
        MenuItemReportTenagaAhli.setBackground(Color.decode("#009999"));
        MenuItemReportTenagaAhli.setOpaque(true);
        Separator_Report1.setBackground(Color.decode("#009999"));
        Separator_Report1.setOpaque(true);
        MenuItemReportProyek.setBackground(Color.decode("#009999"));
        MenuItemReportProyek.setOpaque(true);
        Separator_Report2.setBackground(Color.decode("#009999"));
        Separator_Report2.setOpaque(true);
        MenuItemReportBAST.setBackground(Color.decode("#009999"));
        MenuItemReportBAST.setOpaque(true);
        Separator_Report3.setBackground(Color.decode("#009999"));
        Separator_Report3.setOpaque(true);
        MenuItemReportPENDIDIKAN.setBackground(Color.decode("#009999"));
        MenuItemReportPENDIDIKAN.setOpaque(true);
        
        MenuItemCreateUser.setBackground(Color.decode("#009999"));
        MenuItemCreateUser.setOpaque(true);
        Separator_Utilitas1.setBackground(Color.decode("#009999"));
        Separator_Utilitas1.setOpaque(true);
        MenuItemLogout.setBackground(Color.decode("#009999"));
        MenuItemLogout.setOpaque(true);
        Separator_Utilitas2.setBackground(Color.decode("#009999"));
        Separator_Utilitas2.setOpaque(true);
        MenuItemExit.setBackground(Color.decode("#009999"));
        MenuItemExit.setOpaque(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel = new javax.swing.JPanel();
        LabelTime = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LabelDate = new javax.swing.JLabel();
        JPanel2 = new javax.swing.JPanel();
        LabelNamaUser = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Menubar = new javax.swing.JMenuBar();
        MenuDataMaster = new javax.swing.JMenu();
        MenuItemJurusan = new javax.swing.JMenuItem();
        Separator_DataMaster = new javax.swing.JPopupMenu.Separator();
        MenuItemKeahlian = new javax.swing.JMenuItem();
        MenuTenagaAhli = new javax.swing.JMenu();
        MenuItemTenagaAhli = new javax.swing.JMenuItem();
        MenuProyekDanBAST = new javax.swing.JMenu();
        MenuItemDataProyek = new javax.swing.JMenuItem();
        Separator_ProyekDanBAST = new javax.swing.JPopupMenu.Separator();
        MenuItemDataBAST = new javax.swing.JMenuItem();
        MenuReport = new javax.swing.JMenu();
        MenuItemReportTenagaAhli = new javax.swing.JMenuItem();
        Separator_Report1 = new javax.swing.JPopupMenu.Separator();
        MenuItemReportProyek = new javax.swing.JMenuItem();
        Separator_Report2 = new javax.swing.JPopupMenu.Separator();
        MenuItemReportBAST = new javax.swing.JMenuItem();
        Separator_Report3 = new javax.swing.JPopupMenu.Separator();
        MenuItemReportPENDIDIKAN = new javax.swing.JMenuItem();
        MenuUtilitas = new javax.swing.JMenu();
        MenuItemCreateUser = new javax.swing.JMenuItem();
        Separator_Utilitas1 = new javax.swing.JPopupMenu.Separator();
        MenuItemLogout = new javax.swing.JMenuItem();
        Separator_Utilitas2 = new javax.swing.JPopupMenu.Separator();
        MenuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(787, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(787, 570));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPanel.setBackground(new java.awt.Color(255, 255, 255));
        JPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 102, 102)));
        JPanel.setPreferredSize(new java.awt.Dimension(787, 560));
        JPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTime.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        LabelTime.setForeground(new java.awt.Color(255, 255, 255));
        LabelTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelTime.setText("TIME");
        JPanel.add(LabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 512, 200, 20));
        JPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 484, 785, 10));

        LabelDate.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        LabelDate.setForeground(new java.awt.Color(255, 255, 255));
        LabelDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelDate.setText("DATE");
        JPanel.add(LabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 200, 20));

        JPanel2.setBackground(new java.awt.Color(0, 153, 153));
        JPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelNamaUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        LabelNamaUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelNamaUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelNamaUser.setText("User :");
        JPanel2.add(LabelNamaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 60, 20));

        LabelUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelUser.setText("User");
        JPanel2.add(LabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 60, 20));

        JPanel.add(JPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 485, 784, 52));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/ViramaKarya.png"))); // NOI18N
        JPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 260, 180));

        getContentPane().add(JPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 540));

        Menubar.setBackground(new java.awt.Color(0, 153, 153));
        Menubar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 102, 102)));
        Menubar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        MenuDataMaster.setForeground(new java.awt.Color(255, 255, 255));
        MenuDataMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Database Administrator_15px.png"))); // NOI18N
        MenuDataMaster.setText("DATA MASTER");
        MenuDataMaster.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        MenuItemJurusan.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemJurusan.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemJurusan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Bulleted List_15px.png"))); // NOI18N
        MenuItemJurusan.setText("JURUSAN");
        MenuItemJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemJurusanActionPerformed(evt);
            }
        });
        MenuDataMaster.add(MenuItemJurusan);
        MenuDataMaster.add(Separator_DataMaster);

        MenuItemKeahlian.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemKeahlian.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemKeahlian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/File_15px.png"))); // NOI18N
        MenuItemKeahlian.setText("KEAHLIAN");
        MenuItemKeahlian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemKeahlianActionPerformed(evt);
            }
        });
        MenuDataMaster.add(MenuItemKeahlian);

        Menubar.add(MenuDataMaster);

        MenuTenagaAhli.setForeground(new java.awt.Color(255, 255, 255));
        MenuTenagaAhli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Conference_15px.png"))); // NOI18N
        MenuTenagaAhli.setText("TENAGA AHLI");
        MenuTenagaAhli.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        MenuItemTenagaAhli.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemTenagaAhli.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemTenagaAhli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Conference_15px.png"))); // NOI18N
        MenuItemTenagaAhli.setText("DATA TENAGA AHLI");
        MenuItemTenagaAhli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemTenagaAhliActionPerformed(evt);
            }
        });
        MenuTenagaAhli.add(MenuItemTenagaAhli);

        Menubar.add(MenuTenagaAhli);

        MenuProyekDanBAST.setForeground(new java.awt.Color(255, 255, 255));
        MenuProyekDanBAST.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Increase_15px.png"))); // NOI18N
        MenuProyekDanBAST.setText("PROYEK & BAST");
        MenuProyekDanBAST.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        MenuItemDataProyek.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemDataProyek.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemDataProyek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Project_15px.png"))); // NOI18N
        MenuItemDataProyek.setText("DATA  PROYEK");
        MenuItemDataProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemDataProyekActionPerformed(evt);
            }
        });
        MenuProyekDanBAST.add(MenuItemDataProyek);
        MenuProyekDanBAST.add(Separator_ProyekDanBAST);

        MenuItemDataBAST.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemDataBAST.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemDataBAST.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Group of Projects_15px.png"))); // NOI18N
        MenuItemDataBAST.setText("DATA BAST");
        MenuItemDataBAST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemDataBASTActionPerformed(evt);
            }
        });
        MenuProyekDanBAST.add(MenuItemDataBAST);

        Menubar.add(MenuProyekDanBAST);

        MenuReport.setForeground(new java.awt.Color(255, 255, 255));
        MenuReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Report Card_15px.png"))); // NOI18N
        MenuReport.setText("REPORT");
        MenuReport.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        MenuItemReportTenagaAhli.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemReportTenagaAhli.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemReportTenagaAhli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Permanent Job_15px.png"))); // NOI18N
        MenuItemReportTenagaAhli.setText("TENAGA AHLI");
        MenuItemReportTenagaAhli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemReportTenagaAhliActionPerformed(evt);
            }
        });
        MenuReport.add(MenuItemReportTenagaAhli);
        MenuReport.add(Separator_Report1);

        MenuItemReportProyek.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemReportProyek.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemReportProyek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Stocks_15px.png"))); // NOI18N
        MenuItemReportProyek.setText("PROYEK");
        MenuItemReportProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemReportProyekActionPerformed(evt);
            }
        });
        MenuReport.add(MenuItemReportProyek);
        MenuReport.add(Separator_Report2);

        MenuItemReportBAST.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemReportBAST.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemReportBAST.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Project_15px.png"))); // NOI18N
        MenuItemReportBAST.setText("BAST");
        MenuItemReportBAST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemReportBASTActionPerformed(evt);
            }
        });
        MenuReport.add(MenuItemReportBAST);
        MenuReport.add(Separator_Report3);

        MenuItemReportPENDIDIKAN.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemReportPENDIDIKAN.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemReportPENDIDIKAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Literature_15px.png"))); // NOI18N
        MenuItemReportPENDIDIKAN.setText("PENDIDIKAN");
        MenuItemReportPENDIDIKAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemReportPENDIDIKANActionPerformed(evt);
            }
        });
        MenuReport.add(MenuItemReportPENDIDIKAN);

        Menubar.add(MenuReport);

        MenuUtilitas.setForeground(new java.awt.Color(255, 255, 255));
        MenuUtilitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Support_15px.png"))); // NOI18N
        MenuUtilitas.setText("UTILITAS");
        MenuUtilitas.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        MenuItemCreateUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemCreateUser.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemCreateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/User_15px.png"))); // NOI18N
        MenuItemCreateUser.setText("CREATE USER");
        MenuItemCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCreateUserActionPerformed(evt);
            }
        });
        MenuUtilitas.add(MenuItemCreateUser);
        MenuUtilitas.add(Separator_Utilitas1);

        MenuItemLogout.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemLogout.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Logout Rounded Left_15px.png"))); // NOI18N
        MenuItemLogout.setText("LOGOUT");
        MenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemLogoutActionPerformed(evt);
            }
        });
        MenuUtilitas.add(MenuItemLogout);
        MenuUtilitas.add(Separator_Utilitas2);

        MenuItemExit.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MenuItemExit.setForeground(new java.awt.Color(255, 255, 255));
        MenuItemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/Exit_15px.png"))); // NOI18N
        MenuItemExit.setText("EXIT");
        MenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemExitActionPerformed(evt);
            }
        });
        MenuUtilitas.add(MenuItemExit);

        Menubar.add(MenuUtilitas);

        setJMenuBar(Menubar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemJurusanActionPerformed
        FormJurusan FJ = new FormJurusan();
        FJ.setVisible(true);
    }//GEN-LAST:event_MenuItemJurusanActionPerformed

    private void MenuItemKeahlianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemKeahlianActionPerformed
        FormKeahlian FK = new FormKeahlian();
        FK.setVisible(true);
    }//GEN-LAST:event_MenuItemKeahlianActionPerformed

    private void MenuItemTenagaAhliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemTenagaAhliActionPerformed
        FormDataTenagaAhli FDTA = new FormDataTenagaAhli();
        FDTA.setVisible(true);
    }//GEN-LAST:event_MenuItemTenagaAhliActionPerformed

    private void MenuItemDataProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemDataProyekActionPerformed
        FormProyek FP = new FormProyek();
        FP.setVisible(true);
    }//GEN-LAST:event_MenuItemDataProyekActionPerformed

    private void MenuItemReportProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemReportProyekActionPerformed
        FormReportProyek FRP = new FormReportProyek();
        FRP.setVisible(true);
    }//GEN-LAST:event_MenuItemReportProyekActionPerformed

    private void MenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemLogoutActionPerformed
        setVisible(false);
        FormLogin FL = new FormLogin();
        FL.setVisible(true);
    }//GEN-LAST:event_MenuItemLogoutActionPerformed

    private void MenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuItemExitActionPerformed

    private void MenuItemDataBASTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemDataBASTActionPerformed
        FormBAST FB = new FormBAST();
        FB.setVisible(true);
    }//GEN-LAST:event_MenuItemDataBASTActionPerformed

    private void MenuItemReportTenagaAhliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemReportTenagaAhliActionPerformed
        FormReportTenagaAhli FRTA = new FormReportTenagaAhli();
        FRTA.setVisible(true);
    }//GEN-LAST:event_MenuItemReportTenagaAhliActionPerformed

    private void MenuItemReportBASTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemReportBASTActionPerformed
        FormReportBAST FRBAST = new FormReportBAST();
        FRBAST.setVisible(true);
    }//GEN-LAST:event_MenuItemReportBASTActionPerformed

    private void MenuItemCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCreateUserActionPerformed
        FormCreateUser FCU = new FormCreateUser();
        FCU.setVisible(true);
    }//GEN-LAST:event_MenuItemCreateUserActionPerformed

    private void MenuItemReportPENDIDIKANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemReportPENDIDIKANActionPerformed
        FormReportPendidikan FRPen = new FormReportPendidikan();
        FRPen.setVisible(true);
    }//GEN-LAST:event_MenuItemReportPENDIDIKANActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JPanel JPanel2;
    private javax.swing.JLabel LabelDate;
    private javax.swing.JLabel LabelNamaUser;
    private javax.swing.JLabel LabelTime;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JMenu MenuDataMaster;
    private javax.swing.JMenuItem MenuItemCreateUser;
    private javax.swing.JMenuItem MenuItemDataBAST;
    private javax.swing.JMenuItem MenuItemDataProyek;
    private javax.swing.JMenuItem MenuItemExit;
    private javax.swing.JMenuItem MenuItemJurusan;
    private javax.swing.JMenuItem MenuItemKeahlian;
    private javax.swing.JMenuItem MenuItemLogout;
    private javax.swing.JMenuItem MenuItemReportBAST;
    private javax.swing.JMenuItem MenuItemReportPENDIDIKAN;
    private javax.swing.JMenuItem MenuItemReportProyek;
    private javax.swing.JMenuItem MenuItemReportTenagaAhli;
    private javax.swing.JMenuItem MenuItemTenagaAhli;
    private javax.swing.JMenu MenuProyekDanBAST;
    private javax.swing.JMenu MenuReport;
    private javax.swing.JMenu MenuTenagaAhli;
    private javax.swing.JMenu MenuUtilitas;
    private javax.swing.JMenuBar Menubar;
    private javax.swing.JPopupMenu.Separator Separator_DataMaster;
    private javax.swing.JPopupMenu.Separator Separator_ProyekDanBAST;
    private javax.swing.JPopupMenu.Separator Separator_Report1;
    private javax.swing.JPopupMenu.Separator Separator_Report2;
    private javax.swing.JPopupMenu.Separator Separator_Report3;
    private javax.swing.JPopupMenu.Separator Separator_Utilitas1;
    private javax.swing.JPopupMenu.Separator Separator_Utilitas2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
