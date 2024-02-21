public class Eikona_hxos extends Product
{
    private final double Ekptwsh=25/100D;
    private String analush;
     
    public Eikona_hxos(String a, int b, String c, double d, int e, String anal)
    {
        super(a, b, c, d, e);
        analush=anal;
    }

    public void setAnalush(String anal){
       this.analush = anal;
    }

    public String getAnalush(){
       return analush;
    }
    public double getEkptwsh()
    {
        return Ekptwsh;
    }
    
    public String getAll()
    {
        return super.getAll()+"\nEkptwsh: "+Ekptwsh*100+"%"+"\nAnalysh : "+analush;
    }
}