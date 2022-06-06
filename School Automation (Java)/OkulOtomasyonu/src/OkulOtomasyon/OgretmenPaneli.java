package OkulOtomasyon;

import Interface.Interface4;
import Interface.Interface6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import OkulOtomasyon.OgretmenPaneli;
import OkulOtomasyon.YapıcıMethod;



public final class OgretmenPaneli extends javax.swing.JFrame implements Interface4,Interface6
{
    private int ogretmenid;
    private String ogretmenadi;
    private String ogretmensoyadi;
    private String vders;
    private String vsinif;
    private String Gun;
    private String baslamasaati;
    private String bitissaati;
    
    public int getOgretmen_id(){
        return ogretmenid;
    }

    public void setOgretmen_id(int ogretmenid){
        this.ogretmenid = ogretmenid;
    }
    
    public String getOgretmen_adi(){
        return ogretmenadi;
    }

    public void setOgretmen_adi(String ogretmenadi){
        this.ogretmenadi = ogretmenadi;
    }
    
    public String getOgretmen_soyadi(){
        return ogretmensoyadi;
    }

    public void setOgretmen_soyadi(String ogretmensoyadi){
        this.ogretmensoyadi = ogretmensoyadi;
    }
    
    public String getOgretmen_vders(){
        return vders;
    }

    public void setOgretmen_vders(String vders){
        this.vders = vders;
    }
    
    public String getOgretmen_vsinif(){
        return vsinif;
    }

    public void setOgretmen_vsinif(String vsinif){
        this.vsinif = vsinif;
    }
    
    public String getOgretmen_Gun(){
        return Gun;
    }

    public void setOgretmen_Gun(String Gun){
        this.Gun = Gun;
    }
    
    public String getOgretmen_baslamasaati(){
        return baslamasaati;
    }

    public void setOgretmen_baslamasaati(String baslamasaati){
        this.baslamasaati = baslamasaati;
    }
    
    public String getOgretmen_bitissaati(){
        return bitissaati;
    }

    public void setOgretmen_bitissaati(String bitissaati){
        this.bitissaati = bitissaati;
    }
    
    public OgretmenPaneli() 
    {   
        ogretmenadi = "";
        ogretmensoyadi = "";
        vders = "";
        vsinif = "";
        Gun = "";
        baslamasaati = "";
        bitissaati = "";
        
        YapıcıMethod ı = new YapıcıMethod(rootPane);
        initComponents();
        Connect();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs; 
    
    public void Connect()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SchoolDB?serverTimezone=UTC","root","Istanbul12345.");                   
        } 
        
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(OgretmenPaneli.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        catch (SQLException ex) 
        {
            Logger.getLogger(OgretmenPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    public void ogretmenlistele()
    {
        int c;
        try 
        {
            pst=con.prepareStatement("select * from Tbl_Ogretmen");
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            c=rsd.getColumnCount();
            
            
            int colcount = rs.getMetaData().getColumnCount();
            DefaultTableModel tm = new DefaultTableModel();
            for(int i = 1;i<=colcount;i++)
            tm.addColumn(rs.getMetaData().getColumnName(i)); 
            while(rs.next())
            {
                Object[] row = new Object[colcount];
                for(int i=1;i<=colcount;i++)
                    row[i-1] = rs.getObject(i);
                tm.addRow(row);
            }
            jTable1.setModel(tm);
        }
        
        catch (SQLException ex) 
        {
            Logger.getLogger(OgretmenPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        String forName = "com.mysql.cj.jdbc.Driver";
        try 
        {
            Class.forName(forName);

            String url = "jdbc:mysql://localhost:3306/SchoolDB?serverTimezone=UTC";
            String kullaniciad = "root";
            String sifre = "Istanbul12345.";
            String sorgu = "SELECT * FROM Tbl_Ogretmen";
            Connection con = null; Statement st = null; 
            con = DriverManager.getConnection(url, kullaniciad, sifre);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sorgu);

            int colcount = rs.getMetaData().getColumnCount();
            DefaultTableModel tm = new DefaultTableModel(); 
            for(int i = 1;i<=colcount;i++)
            tm.addColumn(rs.getMetaData().getColumnName(i)); 
            while(rs.next())
            {
                Object[] row = new Object[colcount];
                for(int i=1;i<=colcount;i++)
                row[i-1] = rs.getObject(i);
                tm.addRow(row);
            }
            jTable1.setModel(tm);
        } 
        
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void  ogretmenekle()
    {
        ogretmenadi = ogretmen_adi.getText();
        ogretmensoyadi = ogretmen_soyadi.getText();
        vders = v_ders.getText();
        vsinif = v_sinif.getText();
        Gun = gun.getText();
        baslamasaati = baslama_saati.getText();
        bitissaati = bitis_saati.getText();

        int c;
        try 
        {
            pst=con.prepareStatement("insert into Tbl_Ogretmen(Ogretmen_Adi,Ogretmen_Soyadi,Verdigi_Ders,Verdigi_Sinif,Gun,Baslama_Saati,Bitis_Saati)values(?,?,?,?,?,?,?)");
            pst.setString(1,ogretmenadi);
            pst.setString(2,ogretmensoyadi);
            pst.setString(3,vders);
            pst.setString(4,vsinif);
            pst.setString(5,Gun);
            pst.setString(6,baslamasaati);
            pst.setString(7,bitissaati);
            

            int k = pst.executeUpdate();

            pst=con.prepareStatement("select * from Tbl_Ogretmen");
            rs=pst.executeQuery();
            ResultSetMetaData rsd=rs.getMetaData();
            c=rsd.getColumnCount();          
            DefaultTableModel d=(DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);            
            while(rs.next())
            {
                Vector v2=new Vector();            
                for (int i = 1; i <= c; i++)
                {
                    v2.add(rs.getString("Ogretmen_id"));
                    v2.add(rs.getString("Ogretmen_Adi"));
                    v2.add(rs.getString("Ogretmen_Soyadi"));
                    v2.add(rs.getString("Verdigi_Ders"));
                    v2.add(rs.getString("Verdigi_Sinif"));
                    v2.add(rs.getString("Gun"));
                    v2.add(rs.getString("Baslama_Saati"));
                    v2.add(rs.getString("Bitis_Saati"));            
                }
                d.addRow(v2);
            }    
        }

        catch(SQLException ex)
        {
            Logger.getLogger(OgretmenPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
    }
    
     
    public void ogretmenara()
    {
        String x=jTextField1.getText();
        String forName = "com.mysql.cj.jdbc.Driver";
        try 
        {
            Class.forName(forName);
            System.out.println("Driver Loaded Successfully");
            String url = "jdbc:mysql://localhost:3306/SchoolDB?serverTimezone=UTC";
            String ad = "root";
            String sifre = "Istanbul12345.";
            String sorgu = "SELECT * FROM Tbl_Ogretmen WHERE Ogretmen_Adi LIKE '%"+x+"%'";
            Connection con = null; Statement st = null;
            con = DriverManager.getConnection(url, ad, sifre);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sorgu);

            int colcount = rs.getMetaData().getColumnCount();
            DefaultTableModel tm = new DefaultTableModel(); 
            for(int i = 1;i<=colcount;i++)
                tm.addColumn(rs.getMetaData().getColumnName(i)); 
            while(rs.next())
            {
                Object[] row = new Object[colcount];
                for(int i=1;i<=colcount;i++)
                    row[i-1] = rs.getObject(i);
                tm.addRow(row);
            }
            jTable1.setModel(tm);
        } 
        
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
      
    public void ogretmenguncelle()
    {
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        ogretmenid = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        ogretmenadi = ogretmen_adi.getText();
        ogretmensoyadi = ogretmen_soyadi.getText();
        vders = v_ders.getText();
        vsinif = v_sinif.getText();
        Gun = gun.getText();
        baslamasaati = baslama_saati.getText();
        bitissaati = bitis_saati.getText();
       
        try 
        {
            pst=con.prepareStatement("update Tbl_Ogretmen set Ogretmen_Adi = ?, Ogretmen_Soyadi = ?, Verdigi_Ders = ?, Verdigi_Sinif = ?, Gun = ?, Baslama_Saati = ?, Bitis_Saati = ? where Ogretmen_id = ?");
            
            pst.setString(1,ogretmenadi);
            pst.setString(2,ogretmensoyadi);
            pst.setString(3,vders);
            pst.setString(4,vsinif);
            pst.setString(5,Gun);
            pst.setString(6,baslamasaati);
            pst.setString(7,bitissaati);
            pst.setInt(8,ogretmenid);
            int k=pst.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            Logger.getLogger(OgretmenPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
    }
      
    public void ogretmensil()
    {        
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        int id=Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        try 
        {
            pst=con.prepareStatement("delete from Tbl_Ogretmen where Ogretmen_id = ?");
            pst.setInt(1, id);
            int k=pst.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            Logger.getLogger(OgretmenPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ogretmen_adi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        v_ders = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gun = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        baslama_saati = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bitis_saati = new javax.swing.JTextField();
        ogretmen_soyadi = new javax.swing.JTextField();
        v_sinif = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Öğretmen Paneli");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Öğretmen Adı");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Öğretmen Soyadı");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Ekle");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton2.setText("Güncelle");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton3.setText("Sil");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton4.setText("Ara");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Öğretmen Adı", "Öğretmen Soyadı", "Verdiği Ders", "Verdiği Sınıf", "Gün", "Başlama Saati", "Bitiş Saati"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton5.setText("Listele");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.setText("Öğretmen Adı");
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton6.setText("Menü");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Verdiği Ders");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Verdiği Sınıf");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gün");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Başlama Saati");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bitiş Saati");

        ogretmen_soyadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ogretmen_soyadiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(v_ders, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ogretmen_soyadi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ogretmen_adi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gun)
                            .addComponent(v_sinif, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(baslama_saati, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bitis_saati, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ogretmen_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ogretmen_soyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(v_ders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(v_sinif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(gun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(baslama_saati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(bitis_saati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(87, 87, 87))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    //EKLE 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    JOptionPane.showMessageDialog(this,"Öğretmen Eklendi." );
             ogretmenekle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
                                                      
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        ogretmen_adi.setText(d1.getValueAt(selectIndex, 1).toString());
        ogretmen_soyadi.setText(d1.getValueAt(selectIndex, 2).toString());
        v_ders.setText(d1.getValueAt(selectIndex, 3).toString());
        v_sinif.setText(d1.getValueAt(selectIndex, 4).toString());
        gun.setText(d1.getValueAt(selectIndex, 5).toString());
        baslama_saati.setText(d1.getValueAt(selectIndex, 6).toString());
        bitis_saati.setText(d1.getValueAt(selectIndex, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       ogretmenlistele();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ogretmenara();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ogretmenguncelle();
        JOptionPane.showMessageDialog(this,"Öğretmen Güncellendi." );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ogretmensil();
        JOptionPane.showMessageDialog(this,"Öğretmen Silindi." );
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ogretmen_soyadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ogretmen_soyadiActionPerformed
        
    }//GEN-LAST:event_ogretmen_soyadiActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OgretmenPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OgretmenPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OgretmenPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OgretmenPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OgretmenPaneli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField baslama_saati;
    private javax.swing.JTextField bitis_saati;
    private javax.swing.JTextField gun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField ogretmen_adi;
    private javax.swing.JTextField ogretmen_soyadi;
    private javax.swing.JTextField v_ders;
    private javax.swing.JTextField v_sinif;
    // End of variables declaration//GEN-END:variables
}