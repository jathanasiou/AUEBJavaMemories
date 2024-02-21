public class Thleorash extends Eikona_hxos{

    private String tupos;
    private int diastash;
    private String thures;

    public Thleorash(String a, int b, String c, double d, int e, String anal, String tup, int diast, String thur)
    {
       super(a, b, c, d, e, anal);
       this.tupos = tup;
       this.diastash = diast;
       this.thures = thur;
    }

    public void setTupos(String tup)
    {
       this.tupos = tup;
    }

    public String getTupos()
    {
       return tupos;
    }

    public void setDiastash(int diast)
    {
       this.diastash = diast;
    }

    public int getDiastash(){
       return diastash;
    }

    public void setThures(String thur)
    {
       this.thures = thur;
    }

    public String getThures()
    {
       return thures;
    }
    public String getAll()
    {
        return super.getAll()+"\nTypos: "+tupos+"\nDiastash: "+diastash+"\nThyres: "+thures;
    }
}