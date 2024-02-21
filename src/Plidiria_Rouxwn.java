public class Plidiria_Rouxwn extends Leykh_syskevh
{
    private int Xoritikotita;
    private int Strofes;

    public Plidiria_Rouxwn(String Onoma_Modelou,int Etos_Modelou,String Kataskeyastis,double Timh, int tem, String EK,int X,int S)
    {
        super(Onoma_Modelou,Etos_Modelou,Kataskeyastis,Timh, tem,EK);
        Xoritikotita=X;
        Strofes=S;
    }

    public void setXoritikotita(int X)
    {
        this.Xoritikotita=X;
    }
    public void setStrofes(int S)
    {
        this.Strofes=S;
    }
    public int getXoritikotita()
    {
        return Xoritikotita;
    }
    public int getStrofes()
    {
        return Strofes;
    }
    public String getAll()
    {
        String s="\nXoritikotita :"+Xoritikotita;
        s+="\nStrofes: "+Strofes;
        return super.getAll()+s;
    }
}