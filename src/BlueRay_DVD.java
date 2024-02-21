public class BlueRay_DVD extends Eikona_hxos
{
    private String format;

    public BlueRay_DVD(String a, int b, String c, double d, int e, String anal, String form){
       super(a, b, c, d, e, anal);
       this.format = form;
    }

    public void setFormat(String form){
       this.format = form;
    }

    public String getFormat(){
       return format;
    }
    public String getAll()
    {
        String s="\nFormat :"+format;
        return super.getAll()+s;
    }
}