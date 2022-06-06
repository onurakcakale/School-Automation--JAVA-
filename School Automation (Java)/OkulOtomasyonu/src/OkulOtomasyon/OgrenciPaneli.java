package OkulOtomasyon;

import Interface.Interface7;
import Interface.Interface9;
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
import OkulOtomasyon.OgrenciPaneli;
import OkulOtomasyon.YapıcıMethod;
import javax.swing.JApplet;



public class OgrenciPaneli extends javax.swing.JFrame implements Interface7,Interface9
{
    private int ogrenciid;
    private String ogrenciadi;
    private String ogrencisoyadi;
    private String Sinif;
    private String aders;   
    private String Gun;
    private String baslamasaati;
    private String bitissaati;
    private String ogretmenadi;
    
    public int getOgrenci_id(){
        return ogrenciid;
    }

    public void setOgrenci_id(int ogrenciid){
        this.ogrenciid = ogrenciid;
    }
    
    public String getOgrenci_adi(){
        return ogrenciadi;
    }

    public void setOgrenci_adi(String ogrenciadi){
        this.ogrenciadi = ogrenciadi;
    }
    
    public String getOgrenci_soyadi(){
        return ogrencisoyadi;
    }

    public void setOgrenci_soyadi(String ogrencisoyadi){
        this.ogrencisoyadi = ogrencisoyadi;
    }
    
    public String getOgrenci_sinif(){
        return Sinif;
    }

    public void setOgrenci_sinif(String Sinif){
        this.Sinif = Sinif;
    }
    
    public String getOgrenci_aders(){
        return aders;
    }

    public void setOgrenci_aders(String aders){
        this.aders = aders;
    }
    
    public String getOgrenci_Gun(){
        return Gun;
    }

    public void setOgrenci_Gun(String Gun){
        this.Gun = Gun;
    }
    
    public String getOgrenci_baslamasaati(){
        return baslamasaati;
    }

    public void setOgrenci_baslamasaati(String baslamasaati){
        this.baslamasaati = baslamasaati;
    }
    
    public String getOgrenci_bitissaati(){
        return bitissaati;
    }

    public void setOgreci_bitissaati(String bitissaati){
        this.bitissaati = bitissaati;
    }
    
    public String getOgretmen_adi(){
        return ogretmenadi;
    }

    public void setOgretmen_adi(String ogretmenadi){
        this.ogretmenadi = ogretmenadi;
    }
        
    public OgrenciPaneli() 
    {
        ogrenciadi = "";
        ogrencisoyadi = "";
        Sinif = "";
        aders = "";   
        Gun = "";
        baslamasaati = "";
        bitissaati = "";
        ogretmenadi = "";
        
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
            Logger.getLogger(OgrenciPaneli.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        catch (SQLException ex) 
        {
            Logger.getLogger(OgrenciPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    @Override
    public void ogrencilistele()
    {
        int c;
        try 
        {
            pst=con.prepareStatement("select * from Tbl_Ogrenci");
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
            Logger.getLogger(OgrenciPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String forName = "com.mysql.cj.jdbc.Driver";
        try 
        {
            Class.forName(forName);

            String url = "jdbc:mysql://localhost:3306/SchoolDB?serverTimezone=UTC";
            String kullaniciad = "root";
            String sifre = "Istanbul12345.";
            String sorgu = "SELECT * FROM Tbl_Ogrenci";
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
    public void ogrenciekle()
    {
        ogrenciadi = ogrenci_adi.getText();
        ogrencisoyadi = ogrenci_soyadi.getText();
        Sinif = sinif.getText();
        aders = a_ders.getText();   
        Gun = gun.getText();
        baslamasaati = baslama_saati.getText();
        bitissaati = bitis_saati.getText();
        ogretmenadi = ogretmen_adi.getText();

        int c;
        try 
        {
            pst=con.prepareStatement("insert into Tbl_Ogrenci(Ogrenci_Adi,Ogrenci_Soyadi,Sinif,Aldigi_Ders,Gun,Baslama_Saati,Bitis_Saati,Ogretmen_Adi)values(?,?,?,?,?,?,?,?)");
//            pst.setString(1,ogrenciid);
            pst.setString(1,ogrenciadi);
            pst.setString(2,ogrencisoyadi); 
            pst.setString(3,Sinif);
            pst.setString(4,aders);
            pst.setString(5,Gun);
            pst.setString(6,baslamasaati);
            pst.setString(7,bitissaati);
            pst.setString(8,ogretmenadi);

            int k=pst.executeUpdate();

            pst=con.prepareStatement("select * from Tbl_Ogrenci");
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
                    v2.add(rs.getString("Ogrenci_id"));
                    v2.add(rs.getString("Ogrenci_Adi"));
                    v2.add(rs.getString("Ogrenci_Soyadi"));
                    v2.add(rs.getString("Sinif"));
                    v2.add(rs.getString("Aldigi_Ders"));
                    v2.add(rs.getString("Gun"));
                    v2.add(rs.getString("Baslama_Saati"));
                    v2.add(rs.getString("Bitis_Saati"));
                    v2.add(rs.getString("Ogretmen_Adi"));
                }
                d.addRow(v2);
            }    
        }

        catch(SQLException ex)
        {
            Logger.getLogger(OgrenciPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
    }
    
     
    @Override
    public void ogrenciara()
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
            String sorgu = "SELECT * FROM Tbl_Ogrenci WHERE Ogrenci_Adi LIKE '%"+x+"%'";
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
      
    @Override
    public void ogrenciguncelle()
    {
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        ogrenciid = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        ogrenciadi = ogrenci_adi.getText();
        ogrencisoyadi = ogrenci_soyadi.getText();
        Sinif = sinif.getText();
        aders = a_ders.getText();
        Gun = gun.getText();
        baslamasaati = baslama_saati.getText();
        bitissaati = bitis_saati.getText();
        ogretmenadi = ogretmen_adi.getText();
       
        try 
        {
            pst=con.prepareStatement("update Tbl_Ogrenci set Ogrenci_Adi = ?, Ogrenci_Soyadi = ?, Sinif = ?, Aldigi_Ders = ?, Gun = ?, Baslama_Saati = ?, Bitis_Saati = ?, Ogretmen_Adi = ? where Ogrenci_id = ?");
            pst.setString(1,ogrenciadi);
            pst.setString(2,ogrencisoyadi);
            pst.setString(3,Sinif);
            pst.setString(4,aders);
            pst.setString(5,Gun);
            pst.setString(6,baslamasaati);
            pst.setString(7,bitissaati);
            pst.setString(8,ogretmenadi);
            pst.setInt(9,ogrenciid);
            int k=pst.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            Logger.getLogger(OgrenciPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
    }
      
    @Override
    public void ogrencisil()
    {        
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        int id=Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        try 
        {
            pst=con.prepareStatement("delete from Tbl_Ogrenci where Ogrenci_id = ?");
            pst.setInt(1, id);
            int k=pst.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            Logger.getLogger(OgrenciPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ogrenci_adi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gun = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        baslama_saati = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bitis_saati = new javax.swing.JTextField();
        ogrenci_soyadi = new javax.swing.JTextField();
        sinif = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ogretmen_adi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        a_ders = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Öğrenci Paneli");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Öğrenci Adı");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Öğrenci Soyadı");

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
                "ID", "Öğrenci Adı", "Öğrenci Soyadı", "Sınıf", "Aldığı Ders", "Gün", "Başlama Saati", "Bitiş Saati", "Öğretmen Adı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        jTextField1.setText("Öğrenci Adı");
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

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sınıf");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gün");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Başlama Saati");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bitiş Saati");

        ogrenci_soyadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ogrenci_soyadiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Öğretmen Adı");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Aldığı Ders");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bitis_saati, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(baslama_saati, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sinif, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(ogrenci_adi)
                                    .addComponent(ogrenci_soyadi)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addGap(25, 25, 25)
                                .addComponent(ogretmen_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(a_ders, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gun, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ogrenci_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ogrenci_soyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(sinif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(a_ders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(baslama_saati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(bitis_saati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(ogretmen_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton2)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6))
                .addGap(213, 213, 213))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this,"Öğrenci Eklendi." );
        ogrenciekle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        ogrenci_adi.setText(d1.getValueAt(selectIndex, 1).toString());
        ogrenci_soyadi.setText(d1.getValueAt(selectIndex, 2).toString());
        sinif.setText(d1.getValueAt(selectIndex, 3).toString());
        a_ders.setText(d1.getValueAt(selectIndex, 4).toString());
        gun.setText(d1.getValueAt(selectIndex, 5).toString());
        baslama_saati.setText(d1.getValueAt(selectIndex, 6).toString());
        bitis_saati.setText(d1.getValueAt(selectIndex, 7).toString());
        ogretmen_adi.setText(d1.getValueAt(selectIndex, 8).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       ogrencilistele();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ogrenciara();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ogrenciguncelle();
        JOptionPane.showMessageDialog(this,"Öğrenci Güncellendi." );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ogrencisil();
        JOptionPane.showMessageDialog(this,"Öğrenci Silindi." );
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ogrenci_soyadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ogrenci_soyadiActionPerformed
        
    }//GEN-LAST:event_ogrenci_soyadiActionPerformed


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
            java.util.logging.Logger.getLogger(OgrenciPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OgrenciPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OgrenciPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OgrenciPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OgrenciPaneli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a_ders;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField ogrenci_adi;
    private javax.swing.JTextField ogrenci_soyadi;
    private javax.swing.JTextField ogretmen_adi;
    private javax.swing.JTextField sinif;
    // End of variables declaration//GEN-END:variables
}