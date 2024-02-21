public class Product
{
    private String onoma_montelou;
    private int etos_montelou;
    private String kataskeyastis;
    private double timh;
    private int temaxia;
    public Product(String model, int year, String creator, double price, int quantity)
    {
        this.onoma_montelou=model;
        this.etos_montelou=year;
        this.kataskeyastis=creator;
        this.timh=price;
        this.temaxia=quantity;
    }
    
    public void setOnoma_Montelou(String model)
    {
        this.onoma_montelou=model;
    }
    public String getOnoma_Montelou()
    {
        return this.onoma_montelou;
    }
    public void setEtos_Montelou(int year)
    {
        this.etos_montelou=year;
    }
    public int getEtos_Montelou()
    {
        return this.etos_montelou;
    }
    public void setKataskeyastis(String creator)
    {
        this.kataskeyastis=creator;
    }
    public String getKataskeyastis()
    {
        return this.kataskeyastis;
    }
    public void setTimh(double price)
    {
        this.timh=price;
    }
    public double getTimh()
    {
        return this.timh;
    }
    public void setTemaxia(int quantity)
    {
        this.temaxia=quantity;
    }
    public int getTemaxia()
    {
        return this.temaxia;
    }
    
    public double getEkptwsh()//to be overwritted in lower classes
    {
        return 0D;
    }
    
    public String getAll()
    {
        String s="...::Stoixeia Proiontos::..."+"\n";
       	s+="Onoma Montelou: "+this.onoma_montelou;
        s+="\nEtos Montelou: "+this.etos_montelou;
        s+="\nKataskeyastis: "+this.kataskeyastis;
        s+="\nTimh: "+this.timh;
        s+="\nDiathesima Temaxia: "+this.temaxia;
        return s;
    }
    
    public String toString()
    {
        return getAll();
    }
}