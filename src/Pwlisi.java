public class Pwlisi
{
   private Product Proion;
   private int Kodikos_Pwlisis;
   private String OnomatEponimo_Pelati;
   private String Tilefono_Pelati;
   private String Hmeromhnia_Pwlisis;
   private double Teliko_Kostos;
   
   public Pwlisi(Thleorash pr, int KP,String OP,String TP,String HP,double TK)
   {
       this.Proion=pr;
       Kodikos_Pwlisis=KP;
       OnomatEponimo_Pelati=OP;
       Tilefono_Pelati=TP;
       Hmeromhnia_Pwlisis=HP;
       Teliko_Kostos=TK;
   }
   public Pwlisi(Psigeia pr, int KP,String OP,String TP,String HP,double TK)
   {
       this.Proion=pr;
       Kodikos_Pwlisis=KP;
       OnomatEponimo_Pelati=OP;
       Tilefono_Pelati=TP;
       Hmeromhnia_Pwlisis=HP;
       Teliko_Kostos=TK;
   }
   public Pwlisi(Plidiria_Rouxwn pr, int KP,String OP,String TP,String HP,double TK)
   {
       this.Proion=pr;
       Kodikos_Pwlisis=KP;
       OnomatEponimo_Pelati=OP;
       Tilefono_Pelati=TP;
       Hmeromhnia_Pwlisis=HP;
       Teliko_Kostos=TK;
   }
   public Pwlisi(BlueRay_DVD pr, int KP,String OP,String TP,String HP,double TK)
   {
       this.Proion=pr;
       Kodikos_Pwlisis=KP;
       OnomatEponimo_Pelati=OP;
       Tilefono_Pelati=TP;
       Hmeromhnia_Pwlisis=HP;
       Teliko_Kostos=TK;
   }
   
   public void setProion(Product pr)
    {
    	this.Proion=pr;
    }
   
   public void setKodikos_Pwlisis(int KP)
   {
       Kodikos_Pwlisis=KP;
   }
 
   public void setOnomatEponimo_Pelati(String OP)
   {
       OnomatEponimo_Pelati=OP;
   }
   
   public void setTilefono_Pelati(String TP)
   {
       Tilefono_Pelati=TP;
   }
   
   public void setHmeromhnia_Pwlisis(String HP)
   {
       Hmeromhnia_Pwlisis=HP;
   }
   
   public void setTeliko_Kostos(double TK)
   {
       Teliko_Kostos=TK;
   }        
   
   public Product getProion()
    {
    	return this.Proion;
    }
   
   public int getKodikos_Pwlisis()
   {
       return Kodikos_Pwlisis;
   }

   public String getOnomatEponimo_Pelati()
   {
       return OnomatEponimo_Pelati;
   }
   
   public String getTilefono_Pelati()
   {
       return Tilefono_Pelati;
   }
   
   public String getHmeromhnia_Pwlisis()
   {
       return Hmeromhnia_Pwlisis;
   }
   
   public double getTeliko_Kostos()
   {
       return Teliko_Kostos;
   }
   
   public String getAll()
   {
        String s=Proion.toString();
	s+="\n"+"...::Stoixeia Paraggelias::..."+"\n";
        s+="\nKodikos Pwlisis: "+Kodikos_Pwlisis;
        s+="\nOnomatEponimo Pelati: "+OnomatEponimo_Pelati;
        s+="\nTilefono Pelati: "+Tilefono_Pelati;
        s+="\nHmeromhnia Polisis: "+Hmeromhnia_Pwlisis;
        s+="\nTeliko Kostos: " +Teliko_Kostos;
        s+="\n-----------------------------------------------------";
       return s;
   }
   
   public String toString()
    {
        return getAll();
    }
}
