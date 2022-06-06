package OkulOtomasyon;

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
import OkulOtomasyon.DersPaneli;
import OkulOtomasyon.YapıcıMethod;
import Interface.Interface1;
import Interface.Interface3;




public class DersPaneli extends javax.swing.JFrame implements Interface1,Interface3
{
    private int dersid;
    private String dersadi;
    private String Gun;
    private String baslamasaati;
    private String bitissaati;
    private String ogretmenadi;
    private String Sinif;
    private String fkogrenci;
    private String fkogretmen;
    
    public int getDers_id(){
        return dersid;
    }

    public void setDers_id(int dersid){
        this.dersid = dersid;
    }
    
    public String getDers_adi(){
        return dersadi;
    }

    public void setDers_adi(String dersadi){
        this.dersadi = dersadi;
    }
    
    public String getDers_Gun(){
        return Gun;
    }

    public void setDers_Gun(String Gun){
        this.Gun = Gun;
    }
    
    public String getDers_baslamasaati(){
        return baslamasaati;
    }

    public void setDers_baslamasaati(String baslamasaati){
        this.baslamasaati = baslamasaati;
    }
    
    public String getDers_bitissaati(){
        return bitissaati;
    }

    public void setDers_bitissaati(String bitissaati){
        this.bitissaati = bitissaati;
    }
    
    public String getFKOgrenci_id(){
        return fkogrenci;
    }

    public void setFKOgrenci_id(String fkogrenci){
        this.fkogrenci = fkogrenci;
    }
    
    public String getFKOgretmen_id(){
        return fkogretmen;
    }

    public void setFKOgretmen_id(String fkogretmen){
        this.fkogretmen = fkogretmen;
    }
        
    public DersPaneli() 
    {
        dersadi = "";
        Gun = "";
        baslamasaati = "";
        bitissaati = "";
        ogretmenadi = "";
        Sinif = "";
        fkogrenci = "";
        fkogretmen = ""; 
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
            Logger.getLogger(DersPaneli.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        catch (SQLException ex) 
        {
            Logger.getLogger(DersPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }  
    
    public void derslistele()
    {
        int c;
        try 
        {
            pst=con.prepareStatement("select * from Tbl_Ders");
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
            Logger.getLogger(DersPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String forName = "com.mysql.cj.jdbc.Driver";
        try 
        {
            Class.forName(forName);

            String url = "jdbc:mysql://localhost:3306/SchoolDB?serverTimezone=UTC";
            String kullaniciad = "root";
            String sifre = "Istanbul12345.";
            String sorgu = "SELECT * FROM Tbl_Ders";
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
    
    public void dersekle()
    {
        dersadi = ders_adi.getText();
        Gun = gun.getText();
        baslamasaati = baslama_saati.getText();
        bitissaati = bitis_saati.getText();
        ogretmenadi = ogretmen_adi.getText();
        Sinif = sinif.getText();
        fkogrenci = fk_ogrenci.getText();
        fkogretmen = fk_ogretmen.getText();

        int c;
        try 
        {
            pst=con.prepareStatement("insert into Tbl_Ders(Ders_Ad,Gun,Baslama_Saati,Bitis_Saati,Ogretmen_Adi,Sinif,FK_Ogrenci_id,FK_Ogretmen_id)values(?,?,?,?,?,?,?,?)");
            pst.setString(1,dersadi);
            pst.setString(2,Gun);
            pst.setString(3,baslamasaati);
            pst.setString(4,bitissaati);
            pst.setString(5,ogretmenadi);
            pst.setString(6,Sinif);
            pst.setString(7,fkogrenci);
            pst.setString(8,fkogretmen);
            
            int k=pst.executeUpdate();

            pst=con.prepareStatement("select * from Tbl_Ders");
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
                    v2.add(rs.getString("Ders_id"));
                    v2.add(rs.getString("Ders_Ad"));
                    v2.add(rs.getString("Gun"));
                    v2.add(rs.getString("Baslama_Saati"));
                    v2.add(rs.getString("Bitis_Saati"));
                    v2.add(rs.getString("Ogretmen_Adi"));
                    v2.add(rs.getString("Sinif"));
                    v2.add(rs.getString("FK_Ogrenci_id"));
                    v2.add(rs.getString("FK_Ogretmen_id"));
                }
                d.addRow(v2);
            }
        }
        
        catch(SQLException ex)
        {
                Logger.getLogger(DersPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
    }
    
     
    public void dersara()
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
            String sorgu = "SELECT * FROM Tbl_Ders WHERE Ders_Ad LIKE '%"+x+"%'";
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
      
    
    public void dersguncelle()
    {
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        dersid = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());  
        dersadi = ders_adi.getText();
        Gun = gun.getText();
        baslamasaati = baslama_saati.getText();
        bitissaati = bitis_saati.getText();
        ogretmenadi = ogretmen_adi.getText();
        Sinif = sinif.getText();
        fkogrenci = fk_ogrenci.getText();
        fkogretmen = fk_ogretmen.getText();
        
        try 
        {
            pst=con.prepareStatement("update Tbl_Ders set Ders_Ad = ?, Gun = ?, Baslama_Saati = ?, Bitis_Saati = ?, Ogretmen_Adi = ?, Sinif = ?, FK_Ogrenci_id = ?, FK_Ogretmen_id = ? where Ders_id = ?");
            pst.setString(1,dersadi);
            pst.setString(2,Gun);
            pst.setString(3,baslamasaati);
            pst.setString(4,bitissaati);
            pst.setString(5,ogretmenadi);
            pst.setString(6,Sinif);
            pst.setString(7,fkogrenci);
            pst.setString(8,fkogretmen);
            pst.setInt(9,dersid);
            int k=pst.executeUpdate();
        }
        
        catch(SQLException ex)
        {
            Logger.getLogger(DersPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
    }
      
    public void derssil()
    {      
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        try 
        {
            pst=con.prepareStatement("delete from Tbl_Ders where Ders_id = ?");
            pst.setInt(1,id);
            int k=pst.executeUpdate();  
        }
        
        catch(SQLException ex)
        {
            Logger.getLogger(DersPaneli.class.getName()).log(Level.SEVERE, null,ex);;
        } 
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ders_adi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        baslama_saati = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bitis_saati = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ogretmen_adi = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        sinif = new javax.swing.JTextField();
        gun = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fk_ogrenci = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fk_ogretmen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ders Paneli");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ders Adı");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gün");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Ekle");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                "ID", "Ders Adı", "Gün", "Başlama Saati", "Bitiş Saati", "Öğretmen Adı", "Sınıf", "Öğrenci No", "Öğretmen No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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

        jTextField1.setText("Ders Adı");
        jTextField1.setToolTipText("");
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
        jLabel4.setText("Başlama Saati");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bitiş Saati");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Öğretmen Adı");

        jButton7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton7.setText("Güncelle");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sınıf");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Öğrenci No");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Öğretmen No");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ders_adi)
                            .addComponent(bitis_saati)
                            .addComponent(ogretmen_adi)
                            .addComponent(baslama_saati, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(gun, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fk_ogretmen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sinif)
                                .addComponent(fk_ogrenci)))))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton3)
                                    .addComponent(jButton5)
                                    .addComponent(jButton7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ders_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(gun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(baslama_saati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(bitis_saati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ogretmen_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sinif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fk_ogrenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fk_ogretmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        derslistele();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        ders_adi.setText(d1.getValueAt(selectIndex, 1).toString());
        gun.setText(d1.getValueAt(selectIndex, 2).toString());
        baslama_saati.setText(d1.getValueAt(selectIndex, 3).toString());
        bitis_saati.setText(d1.getValueAt(selectIndex, 4).toString());
        ogretmen_adi.setText(d1.getValueAt(selectIndex, 5).toString());
        sinif.setText(d1.getValueAt(selectIndex, 6).toString());
        fk_ogrenci.setText(d1.getValueAt(selectIndex, 7).toString());
        fk_ogretmen.setText(d1.getValueAt(selectIndex, 8).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dersara();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        derssil();
        JOptionPane.showMessageDialog(this,"Ders Silindi." );
    }//GEN-LAST:event_jButton3ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this,"Ders Eklendi." );
        dersekle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dersguncelle();
        JOptionPane.showMessageDialog(this,"Ders Güncellendi." );
    }//GEN-LAST:event_jButton7ActionPerformed

    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(DersPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DersPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DersPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DersPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new DersPaneli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField baslama_saati;
    private javax.swing.JTextField bitis_saati;
    private javax.swing.JTextField ders_adi;
    private javax.swing.JTextField fk_ogrenci;
    private javax.swing.JTextField fk_ogretmen;
    private javax.swing.JTextField gun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField ogretmen_adi;
    private javax.swing.JTextField sinif;
    // End of variables declaration//GEN-END:variables
}