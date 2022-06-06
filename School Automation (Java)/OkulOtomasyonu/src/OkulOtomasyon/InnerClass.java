package OkulOtomasyon;

class Outside
{
    String universite_ismi;
    public class Inside
    {
        String fakulte_ismi;
        String ders_ismi;
        public Inside()
        {
            fakulte_ismi="Teknoloji Fakültesi";
            ders_ismi = "Java Programlama";
        }

        public Inside( String fakulte_ismi, String ders_ismi )
        {
            this.fakulte_ismi = fakulte_ismi;
            this.ders_ismi = ders_ismi;
        }
    }

    class MYO
    {
        String myo_ismi;
    }

    public class InnerClass 
    {  
        public void main(String[] args) 
        { 
            Outside u1 = new Outside();
            Outside.Inside f1 = u1.new Inside();
        } 
    }
}