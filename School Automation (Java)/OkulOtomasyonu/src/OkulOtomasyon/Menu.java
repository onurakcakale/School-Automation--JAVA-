package OkulOtomasyon;

import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame 
{
    public Menu() 
    {
        initComponents();  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dersEkle = new javax.swing.JButton();
        ogrenciEkle = new javax.swing.JButton();
        cikis = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ogretmenEkle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(462, 432));

        dersEkle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        dersEkle.setText("Ders Paneli");
        dersEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dersEkle.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        dersEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dersEkleActionPerformed(evt);
            }
        });

        ogrenciEkle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ogrenciEkle.setText("Öğrenci Paneli");
        ogrenciEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ogrenciEkle.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        ogrenciEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ogrenciEkleActionPerformed(evt);
            }
        });

        cikis.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cikis.setText("Çıkış");
        cikis.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cikis.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Okul Otomasyonu");

        ogretmenEkle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ogretmenEkle.setText("Öğretmen Paneli");
        ogretmenEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ogretmenEkle.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        ogretmenEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ogretmenEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel2)
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ogrenciEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dersEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ogretmenEkle, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(140, 140, 140))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(ogretmenEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ogrenciEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dersEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cikis, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisActionPerformed
        JOptionPane.showMessageDialog(rootPane,"Çıkış Yapılıyor"); System.exit(1);
    }//GEN-LAST:event_cikisActionPerformed

    private void dersEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dersEkleActionPerformed
        DersPaneli ders=new DersPaneli();
        ders.setVisible(true);      
    }//GEN-LAST:event_dersEkleActionPerformed

    private void ogrenciEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ogrenciEkleActionPerformed
        OgrenciPaneli ogrenci=new OgrenciPaneli();
        ogrenci.setVisible(true);
    }//GEN-LAST:event_ogrenciEkleActionPerformed

    private void ogretmenEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ogretmenEkleActionPerformed
        OgretmenPaneli ogretmen=new OgretmenPaneli();
        ogretmen.setVisible(true);
    }//GEN-LAST:event_ogretmenEkleActionPerformed

    public static void main(String args[]) 
    {
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cikis;
    private javax.swing.JButton dersEkle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton ogrenciEkle;
    private javax.swing.JButton ogretmenEkle;
    // End of variables declaration//GEN-END:variables
}