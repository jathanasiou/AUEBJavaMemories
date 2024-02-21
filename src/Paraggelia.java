public class Paraggelia
{
    private Product Proion;
    private int Kodikos_Paraggelias;
    private String OnomatEponimo_Pelati;
    private String Tilefono_Pelati;
    private String Hmeromhnia_Paragelias;
    private String Hmeromhnia_Afiksis;
    private double Teliko_Kostos;
    private boolean Katastasi_Paragelias; // FALSE= DEN EXEI GINEI | TRUE = EXEI GINEI
    
    public Paraggelia(Thleorash pr,int Kod,String OEP,String TP,String HP,String HA,double TK,boolean KP)
    {
    	this.Proion=pr;
        Kodikos_Paraggelias=Kod;
        OnomatEponimo_Pelati=OEP;
        Tilefono_Pelati=TP;
        Hmeromhnia_Paragelias=HP;
        Hmeromhnia_Afiksis=HA;
        Teliko_Kostos=TK;
        Katastasi_Paragelias=KP;
    }
    
    public Paraggelia(Plidiria_Rouxwn pr,int Kod,String OEP,String TP,String HP,String HA,double TK,boolean KP)
    {
    	this.Proion=pr;
        Kodikos_Paraggelias=Kod;
        OnomatEponimo_Pelati=OEP;
        Tilefono_Pelati=TP;
        Hmeromhnia_Paragelias=HP;
        Hmeromhnia_Afiksis=HA;
        Teliko_Kostos=TK;
        Katastasi_Paragelias=KP;
    }
    
    public Paraggelia(BlueRay_DVD pr,int Kod,String OEP,String TP,String HP,String HA,double TK,boolean KP)
    {
    	this.Proion=pr;
        Kodikos_Paraggelias=Kod;
        OnomatEponimo_Pelati=OEP;
        Tilefono_Pelati=TP;
        Hmeromhnia_Paragelias=HP;
        Hmeromhnia_Afiksis=HA;
        Teliko_Kostos=TK;
        Katastasi_Paragelias=KP;
    }
    
    public Paraggelia(Psigeia pr,int Kod,String OEP,String TP,String HP,String HA,double TK,boolean KP)
    {
    	this.Proion=pr;
        Kodikos_Paraggelias=Kod;
        OnomatEponimo_Pelati=OEP;
        Tilefono_Pelati=TP;
        Hmeromhnia_Paragelias=HP;
        Hmeromhnia_Afiksis=HA;
        Teliko_Kostos=TK;
        Katastasi_Paragelias=KP;
    }
    
    public void setProion(Product pr)
    {
    	this.Proion=pr;
    }

    public void setKodikos_Paraggelias(int Kod)
    {
        Kodikos_Paraggelias=Kod;
    }

    public void setOnomatEponimo_Pelati(String OEP)
    {
        OnomatEponimo_Pelati=OEP;
    }
    
    public void setTilefono_Pelati(String TP)
    {
        Tilefono_Pelati=TP;
    }
    
    public void setHmeromhnia_Paragelias(String HP)
    {
        Hmeromhnia_Paragelias=HP;
    }
    
    public void setHmeromhnia_Afiksis(String HA)
    {
        Hmeromhnia_Afiksis=HA;
    }
    
    public void setTeliko_Kostos(double TK)
    {
        Teliko_Kostos=TK;
    }
    
    public void setKatastasi_Paragelias(boolean KP)
    {
        Katastasi_Paragelias=KP;
    }
    
    public Product getProion()
    {
    	return this.Proion;
    }

    public int getKodikos_Paraggelias()
    {
        return Kodikos_Paraggelias;
    }

    public String getOnomatEponimo_Pelati()
    {
        return OnomatEponimo_Pelati;
    }
    
    public String getTilefono_Pelati()
    {
        return Tilefono_Pelati;
    }
    
    public String getHmeromhnia_Paragelias()
    {
        return Hmeromhnia_Paragelias;
    }
    
    public String getHmeromhnia_Afiksis()
    {
        return Hmeromhnia_Afiksis;
    }
    
    public double getTeliko_Kostos()
    {
        return Teliko_Kostos;
    }
    
    public boolean getKatastasi_Paragelias() 
    {
        return Katastasi_Paragelias;
    }   
    
    public String getAll()
    {
	String s=Proion.toString();
	s+="\n"+"...::Stoixeia Paraggelias::..."+"\n";
        s+="\nKodikos_Paraggelias: "+Kodikos_Paraggelias;
        s+="\nOnomateponimo Paragelias: "+OnomatEponimo_Pelati;
        s+="\nTilefono Pelati: "+Tilefono_Pelati;
        s+="\nHmeromhnia Paragelias: "+Hmeromhnia_Paragelias;
        s+="\nHmeromhnia Afiksis: "+Hmeromhnia_Afiksis;
        s+="\nTeliko Kostos: "+Teliko_Kostos;       
        s+="\nKatastasi Paragelias: "+Katastasi_Paragelias;
        s+="\n-----------------------------------------------------";
        return s;
    }
    
    public String toString()
    {
        return getAll();
    }
}

