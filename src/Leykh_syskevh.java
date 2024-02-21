public class Leykh_syskevh extends Product
{
    private double Ekptwsh=10/100D;
    private String Energiaki_Klasi;
    public Leykh_syskevh(String model, int year, String creator, double price, int quantity, String EK)
    {
        super(model,year,creator,price,quantity);
        Energiaki_Klasi=EK;
    }
    public double getEkptwsh()
    {
        return this.Ekptwsh;
    }
    
    public void setEnergiaki_Klasi(String EK)
    {
        this.Energiaki_Klasi=EK;
    }
    
    public String getEnergiaki_Klasi()
    {
        return Energiaki_Klasi;
    }
    
    public String getAll()
    {
        return super.getAll()+"\nEkptwsh: "+Ekptwsh*100+"%"+"\nEnergiaki Klasi: "+Energiaki_Klasi;
    }
}
