public class Psigeia extends Leykh_syskevh
{
 private String Tipos;
 private int Xoritikotita_Sidirisis;
 private int Xoritikotita_Katapsiksis;

    public Psigeia(String Onoma_Modelou,int Etos_Modelou,String Kataskeyastis,double Timh, int tem, String t,String EK,int XS,int XK)
    {
    super(Onoma_Modelou,Etos_Modelou,Kataskeyastis,Timh,tem, EK);
    Tipos=t;
    Xoritikotita_Sidirisis=XS;
    Xoritikotita_Katapsiksis=XK;
    }

    public void setTipos(String t)
    {this.Tipos=t;
    }
    public void setXoritikotita_Sidirisis(int XS)
    {this.Xoritikotita_Sidirisis=XS;
    }
    public void setXoritikotita_Katapsiksis(int XK)
    {this.Xoritikotita_Katapsiksis=XK;
    }
    public String getTipos()
    { return Tipos;
    }
    public int getXoritikotita_Sidirisis()
    {return Xoritikotita_Sidirisis;
    }
    public int getXoritikotita_Katapsiksis()
    {return Xoritikotita_Katapsiksis;
    }
    public String getAll()
    {
        String s="\nTipos: "+Tipos;
        s+="\nXoritikotita Sidirisis: "+Xoritikotita_Sidirisis;
        s+="\nXoritikotita Katapsiksis: "+Xoritikotita_Katapsiksis;
        return super.getAll()+s;
    }
}