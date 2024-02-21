import java.io.*;

public class my
{
    public static String readString()
    {
        BufferedReader br = new
        BufferedReader (new InputStreamReader(System.in), 1);

        String string = " ";

        try
        {
            string = br.readLine();
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
        return string;
    }
    public static int readInt()
    {
        return Integer.parseInt(readString() );
    }
}