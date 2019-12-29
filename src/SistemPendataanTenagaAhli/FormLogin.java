package SistemPendataanTenagaAhli;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormLogin extends javax.swing.JFrame {
    public static String User, HakAkses;
    
    public FormLogin() {
        initComponents();
        setLocationRelativeTo(null);
        Text_Username.requestFocus();
        Config.getConnection();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Text_Username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Text_Password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PT Virama Karya - Form Login");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(50, 109, 0), null));

        Text_Username.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Text_Username.setForeground(new java.awt.Color(84, 84, 84));
        Text_Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Text_UsernameKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PASSWORD");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("L O G I N");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Text_Password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Text_Password.setForeground(new java.awt.Color(84, 84, 84));
        Text_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Text_PasswordKeyPressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemPendataanTenagaAhli/ImagesFile/ViramaKarya.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Text_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(Text_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addComponent(Text_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Text_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            String Password = "";
            char [] Pass = Text_Password.getPassword();
            for(int i = 0; i < Pass.length; i++) {
                Password += Pass[i];
            }
            
            Config.getData("SELECT * FROM Table_User "
                     + "WHERE Username = '" + Text_Username.getText() + "'"
                     + "AND Password = '" + Password + "'");

            if(Config.RS.next()) {
                User = Config.RS.getString("Username");
                HakAkses = Config.RS.getString("HakAkses");
                
                FormMenuUtama FMU = new FormMenuUtama();
                FMU.setVisible(true);

            } else if(Text_Username.getText().equals("") || Password.equals("")) { 
                JOptionPane.showMessageDialog(null, "Maaf! Username dan Password Harus Diisi!");
                Text_Username.requestFocus();
      
            } else if(!Text_Username.getText().equals(Config.RS.next() || !Password.equals(Config.RS.next()))) {
                JOptionPane.showMessageDialog(null, "Maaf, Username/Password Anda Salah!");
                Text_Username.requestFocus();
                Text_Username.setText("");
                Text_Password.setText("");
            } 
                
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Text_UsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_UsernameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Text_Password.requestFocus();
        }
    }//GEN-LAST:event_Text_UsernameKeyPressed

    private void Text_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_PasswordKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String Password = "";
                char [] Pass = Text_Password.getPassword();
                for(int i = 0; i < Pass.length; i++) {
                    Password += Pass[i];
                }

                Config.getData("SELECT * FROM Table_User "
                         + "WHERE Username = '" + Text_Username.getText() + "'"
                         + "AND Password = '" + Password + "'");

                if(Config.RS.next()) {
                    User = Config.RS.getString("Username");
                    HakAkses = Config.RS.getString("HakAkses");

                    FormMenuUtama FMU = new FormMenuUtama();
                    FMU.setVisible(true);
                    setVisible(false);

                } else if(Text_Username.getText().equals("") || Password.equals("")) { 
                    JOptionPane.showMessageDialog(null, "Maaf! Username dan Password Harus Diisi!");
                    Text_Username.requestFocus();

                } else if(!Text_Username.getText().equals(Config.RS.next() || !Password.equals(Config.RS.next()))) {
                    JOptionPane.showMessageDialog(null, "Maaf, Username/Password Anda Salah!");
                    Text_Username.requestFocus();
                    Text_Username.setText("");
                    Text_Password.setText("");
                } 

            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Text_PasswordKeyPressed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Text_Password;
    private javax.swing.JTextField Text_Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
