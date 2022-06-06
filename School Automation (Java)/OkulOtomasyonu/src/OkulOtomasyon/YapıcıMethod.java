package OkulOtomasyon;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

class YapıcıMethod 
{
    String uyari;
        
    public YapıcıMethod(Component rootPane)
    {
        uyari="Yapıcı Method Uyarısı";
        JOptionPane.showMessageDialog(rootPane,uyari);
        System.out.println("Yapıcı Method");
    }
        
    public YapıcıMethod(String uyari)
    {
        this.uyari = uyari;    
    }   
}