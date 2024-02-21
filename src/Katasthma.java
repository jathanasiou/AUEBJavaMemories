
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Katasthma {

    static HashMap<String, Object> Tags = new HashMap(26);

    public static void main(String[] args) {

        File Item_file = new File("Item.txt");
        File Sale_file = new File("Sale.txt");
        File Order_file = new File("Order.txt");
        //kataskeyi twn instances twn arxeiwn pou 8a xrhsimopoioume

        ArrayList<Product> Stock = new ArrayList(0);
        ArrayList<Paraggelia> ParaggeliaC = new ArrayList(0);
        ArrayList<Pwlisi> PwlisiC = new ArrayList(0);
        
        Stock.clear();
        ParaggeliaC.clear();
        PwlisiC.clear();

        BlueRay_DVD br1 = new BlueRay_DVD("SONY 2000", 2000, "SONY", 300.50, 5, "1000x1000", "DVD-RW");
        BlueRay_DVD br2 = new BlueRay_DVD("TOSHIBA 2001", 2001, "TOSHIBA", 500.50, 0, "2000x1000", "BD-RD");
        Thleorash t1 = new Thleorash("XL-1", 2009, "SONY", 300.0, 2, "1600x900", "LCD", 20, "HDMI");
        Thleorash t2 = new Thleorash("S-1", 2008, "SAMSUNG", 500.8, 0, "2000x1000", "LED", 36, "HDMI,DVI");
        Plidiria_Rouxwn pl1 = new Plidiria_Rouxwn("PITSOS-5", 2005, "PITSOS", 150.23, 4, "A", 100, 10);
        Plidiria_Rouxwn pl2 = new Plidiria_Rouxwn("LG-6", 2006, "LG", 200.50, 0, "B", 500, 20);
        Psigeia p1 = new Psigeia("P3", 2010, "PITSOS", 200.50, 7, "Monoporto", "A", 500, 200);
        Psigeia p2 = new Psigeia("LG-5", 2009, "LG", 300.0, 0, "Ntoulapa", "B", 600, 300);
        //kataskeyi arxikwn antikeimenwn twn prointwn pou pwlountai sto katasthma (akomh kai me 0 temaxia)


        if (!Item_file.exists())
        {
            System.out.println("Item.txt file missing. Will load the default stock data.");
            Stock.add(br1);
            Stock.add(br2);
            Stock.add(t1);
            Stock.add(t2);
            Stock.add(pl1);
            Stock.add(pl2);
            Stock.add(p1);
            Stock.add(p2);
            try
            {
                Item_file.createNewFile();
            }
            catch (IOException e)
            {
                System.err.println("Error while creating file");
            }
        }
        else
        {
            //if file already exists --> loadFile()
            loadFile(Item_file,Stock);
        }

        if(Sale_file.exists())
        {
            loadFile(Sale_file,PwlisiC);
        }
        else
        {
            System.out.println("Sale.txt file missing. No Sales will be loaded.");
            try
            {
                Sale_file.createNewFile();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }

        }

        if(Order_file.exists())
        {
            loadFile(Order_file,ParaggeliaC);
        }
        else
        {
            System.out.println("Order.txt file missing. No Orders will be loaded.");
            try
            {
                Order_file.createNewFile();
            }
            catch(IOException e)
            {
                 System.out.println(e);
            }
        }


        int menu_input = 0;
        int item_code;
        int del_code;
        int location;
        boolean exit = false;
        boolean found = false;
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";

        while (!exit) {
            for (int i = 1; i <= Stock.size(); i++) {
                System.out.println();
                System.out.println("Kwdikos syskeyhs: " + (i - 1));
                System.out.println(Stock.get(i - 1).toString());
            }
            System.out.println("...:::~~ MENU ~~:::..." + "\r\n");
            System.out.println("1) Pwlhsh/Paraggelia proiontos");
            System.out.println("2) Emfanish katalogou Pwlhsewn kai Paraggeliwn"); // me xrhsh toString
            System.out.println("3) Oloklhrwsh paraggelias"); // ta stoixeia prosti8entai kai ston katalogo pwlhsewn me kwdiko pwlhshs etc
            System.out.println("4) Eksodos apo to programma");
            menu_input = my.readInt();

            switch (menu_input) {

                //AGORA H PARAGGELIA
                case 1:
                    System.out.println("Parakalw dwste ton kwdiko ths syskeyhs");
                    item_code = my.readInt();
                    if (Stock.get(item_code).getTemaxia() == 0)
                    {
                        System.out.println("To proion den einai amesa diathesimo, tha ginei paraggelia tis syskeyis");
                        System.out.println("Parakalw symplhrwste ta parakatw stoixeia gia ton pelath kai thn paraggelia");
                        System.out.println("Onomatepwnymo:");
                        s1 = my.readString();
                        System.out.println("Thlefwno:");
                        s2 = my.readString();
                        System.out.println("Hmeromhnia paraggelias:");
                        s3 = my.readString();
                        System.out.println("Hmeromhnia afiksis:");
                        s4 = my.readString();
                        if(Stock.get(item_code).getClass().getName().equals("Plidiria_Rouxwn"))
                        {
                            ParaggeliaC.add(new Paraggelia((Plidiria_Rouxwn)Stock.get(item_code), ParaggeliaC.size(), s1, s2, s3, s4, Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh(), false));
                        }
                        else if(Stock.get(item_code).getClass().getName().equals("Psigeia"))
                        {
                            ParaggeliaC.add(new Paraggelia((Psigeia)Stock.get(item_code), ParaggeliaC.size(), s1, s2, s3, s4, Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh(), false));
                        }
                        else if(Stock.get(item_code).getClass().getName().equals("Thleorash"))
                        {
                            ParaggeliaC.add(new Paraggelia((Thleorash)Stock.get(item_code), ParaggeliaC.size(), s1, s2, s3, s4, Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh(), false));
                        }
                        else if(Stock.get(item_code).getClass().getName().equals("BlueRay_DVD"))
                        {
                            ParaggeliaC.add(new Paraggelia((BlueRay_DVD)Stock.get(item_code), ParaggeliaC.size(), s1, s2, s3, s4, Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh(), false));
                        }
                        
                        System.out.println("H paraggelia pragmatopoih8hke.");
                        System.out.println("Teliko kostos me ekptwsh: " + Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh());
                        System.out.println("Kwdikos paraggelias: " + (ParaggeliaC.size() - 1));
                    }//paraggelia
                    else
                    {
                        System.out.println("Parakalw symplhrwste ta parakatw stoixeia gia ton pelath kai thn pwlhsh");
                        System.out.println("Onomatepwnymo: ");
                        s1 = my.readString();
                        System.out.println("Thlefwno: ");
                        s2 = my.readString();
                        System.out.println("Hmeromhnia pwlhshs: ");
                        s3 = my.readString();
                        if(Stock.get(item_code).getClass().getName().equals("Plidiria_Rouxwn"))
                        {
                            PwlisiC.add(new Pwlisi((Plidiria_Rouxwn)Stock.get(item_code), PwlisiC.size(), s1, s2, s3, Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh()));
                        }
                        else if(Stock.get(item_code).getClass().getName().equals("Psigeia"))
                        {
                            PwlisiC.add(new Pwlisi((Psigeia)Stock.get(item_code), PwlisiC.size(), s1, s2, s3, Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh()));
                        }
                        else if(Stock.get(item_code).getClass().getName().equals("Thleorash"))
                        {
                            PwlisiC.add(new Pwlisi((Thleorash)Stock.get(item_code), PwlisiC.size(), s1, s2, s3, Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh()));
                        }
                        else if(Stock.get(item_code).getClass().getName().equals("BlueRay_DVD"))
                        {
                            PwlisiC.add(new Pwlisi((BlueRay_DVD)Stock.get(item_code), PwlisiC.size(), s1, s2, s3, Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh()));
                        }
                        System.out.println("H pwlhsh pragmatopoih8hke.");
                        System.out.println("Teliko kostos me ekptwsh: " + Stock.get(item_code).getTimh() * Stock.get(item_code).getEkptwsh());
                        System.out.println("Kwdikos pwlhshs: " + (PwlisiC.size() - 1));
                        Stock.get(item_code).setTemaxia(Stock.get(item_code).getTemaxia() - 1); // afairesh enos temaxiou apo tin syllogi dia8esimwn proiontwn Stock
                    }//pwlhsh
                    break;



                //Ektypwsh katalogwn Paraggeliwn & Pwlisewn
                case 2:
                    if (ParaggeliaC.isEmpty())
                    {
                        System.out.println("O katalagos paraggeliwn einai adeios.");
                    }
                    else
                    {
                        System.out.println("***Katalogos Paraggeliwn***");
                        for (int i = 1; i <= ParaggeliaC.size(); i++)
                        {
                            System.out.println(ParaggeliaC.get(i - 1).toString());
                        }
                    }
                    if (PwlisiC.isEmpty()) {
                        System.out.println("O katalagos pwlhsewn einai adeios.");
                    }
                    else
                    {
                        System.out.println("***Katalogos Pwlisewn***");
                        for (int i = 1; i <= PwlisiC.size(); i++) {
                            System.out.println(PwlisiC.get(i - 1).toString());
                        }
                    }
                    break;


                //Oloklhrwsh Paraggelias
                case 3:
                    found = false;
                    location = 0;
                    if (!ParaggeliaC.isEmpty())
                    {
                        System.out.println("Parakalw eisagete kwdiko paraggelias pros oloklhrwsh" + "\r\n");
                        del_code = my.readInt();
                        for (int i = 1; i <= ParaggeliaC.size(); i++)
                        {
                            if (ParaggeliaC.get(i - 1).getKodikos_Paraggelias() == del_code)
                            {
                                found = true;
                                location = (i - 1);
                                i = (ParaggeliaC.size() + 1);
                            }
                        }

                        if (found && !(ParaggeliaC.get(location).getKatastasi_Paragelias()))
                        {
                            if(ParaggeliaC.get(location).getProion().getClass().getName().equals("Plidiria_Rouxwn"))
                            {
                                PwlisiC.add(new Pwlisi((Plidiria_Rouxwn)ParaggeliaC.get(location).getProion(), PwlisiC.size(), ParaggeliaC.get(location).getOnomatEponimo_Pelati(), ParaggeliaC.get(location).getTilefono_Pelati(), ParaggeliaC.get(location).getHmeromhnia_Paragelias(), ParaggeliaC.get(location).getTeliko_Kostos()));
                            }
                            else if(ParaggeliaC.get(location).getProion().getClass().getName().equals("Psigeia"))
                            {
                                PwlisiC.add(new Pwlisi((Psigeia)ParaggeliaC.get(location).getProion(), PwlisiC.size(), ParaggeliaC.get(location).getOnomatEponimo_Pelati(), ParaggeliaC.get(location).getTilefono_Pelati(), ParaggeliaC.get(location).getHmeromhnia_Paragelias(), ParaggeliaC.get(location).getTeliko_Kostos()));
                            }
                            else if(ParaggeliaC.get(location).getProion().getClass().getName().equals("Thleorash"))
                            {
                                PwlisiC.add(new Pwlisi((Thleorash)ParaggeliaC.get(location).getProion(), PwlisiC.size(), ParaggeliaC.get(location).getOnomatEponimo_Pelati(), ParaggeliaC.get(location).getTilefono_Pelati(), ParaggeliaC.get(location).getHmeromhnia_Paragelias(), ParaggeliaC.get(location).getTeliko_Kostos()));
                            }
                            else if(ParaggeliaC.get(location).getProion().getClass().getName().equals("BlueRay_DVD"))
                            {
                                PwlisiC.add(new Pwlisi((BlueRay_DVD)ParaggeliaC.get(location).getProion(), PwlisiC.size(), ParaggeliaC.get(location).getOnomatEponimo_Pelati(), ParaggeliaC.get(location).getTilefono_Pelati(), ParaggeliaC.get(location).getHmeromhnia_Paragelias(), ParaggeliaC.get(location).getTeliko_Kostos()));
                            }
                            ParaggeliaC.remove(location); // AFAIRESH THS OLOKLHRWMENHS PARAGGELIAS APO TON KATALOGO PARAGGELIWN
                            System.out.println("H paraggelia oloklhrw8hke kai metafer8hke ston katalogo pwlisewn");
                        }
                        else
                        {
                            System.out.println("O kwdikos paraggelias den yparxei h h paraggelia exei hdh paradothei.");
                        }
                    }
                    else
                    {
                        System.out.println("O katalogos paraggeliwn einai adeios.");
                    }
                    break;


                //Exit case    
                case 4:
                    saveFile(Item_file, Stock);
                    saveFile(Sale_file, PwlisiC);
                    saveFile(Order_file, ParaggeliaC);
                    exit = true;
                    break;

                default:
                    System.out.println("Lathos epilogi. Eisagete 1 h 2 h 3 h 4 ." + "\r\n");
                    break;
            }//switch

        }//while loop

    }//main

    public static void saveFile(File f, ArrayList c)
    {
        
        int dotindex = f.getName().indexOf(".");
        String FileType = f.getName().substring(0, dotindex);

        f.delete();
        try
        {
            f.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }


        BufferedWriter bw = null;

        try
        {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error creating file output buffer or file not found.");
        }

        try
        {
            bw.write(FileType.toUpperCase()+"_LIST"+"\r\n{"+"\r\n");

            for (int i = 0; i < c.size(); i++)
            {
                bw.write("\t"+FileType.toUpperCase()+"\r\n\t{\r\n");
                if(FileType.equalsIgnoreCase("ITEM"))
                {
                    if(c.get(i).getClass().getName().equals("Plidiria_Rouxwn"))
                    {
                        bw.write("\t\tITEM_TYPE Plidiria_Rouxwn\r\n");
                        bw.write("\t\tMODEL "+((Plidiria_Rouxwn)c.get(i)).getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Plidiria_Rouxwn)c.get(i)).getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Plidiria_Rouxwn)c.get(i)).getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Plidiria_Rouxwn)c.get(i)).getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Plidiria_Rouxwn)c.get(i)).getTemaxia())+"\r\n");
                        bw.write("\t\tENERGY_CLASS "+String.valueOf(((Plidiria_Rouxwn)c.get(i)).getEnergiaki_Klasi())+"\r\n");
                        bw.write("\t\tVOLUME "+String.valueOf(((Plidiria_Rouxwn)c.get(i)).getXoritikotita())+"\r\n");
                        bw.write("\t\tSPINS "+String.valueOf(((Plidiria_Rouxwn)c.get(i)).getStrofes())+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    if(c.get(i).getClass().getName().equals("Thleorash"))
                    {
                        bw.write("\t\tITEM_TYPE Thleorash\r\n");
                        bw.write("\t\tMODEL "+((Thleorash)c.get(i)).getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Thleorash)c.get(i)).getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Thleorash)c.get(i)).getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Thleorash)c.get(i)).getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Thleorash)c.get(i)).getTemaxia())+"\r\n");
                        bw.write("\t\tPANEL_TYPE "+(((Thleorash)c.get(i)).getTupos())+"\r\n");
                        bw.write("\t\tDIMENSIONS "+String.valueOf(((Thleorash)c.get(i)).getDiastash())+"\r\n");
                        bw.write("\t\tRESOLUTION "+(((Thleorash)c.get(i)).getAnalush())+"\r\n");
                        bw.write("\t\tPORTS "+(((Thleorash)c.get(i)).getThures())+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    if(c.get(i).getClass().getName().equals("BlueRay_DVD"))
                    {
                        bw.write("\t\tITEM_TYPE BlueRay_DVD\r\n");
                        bw.write("\t\tMODEL "+((BlueRay_DVD)c.get(i)).getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((BlueRay_DVD)c.get(i)).getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((BlueRay_DVD)c.get(i)).getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((BlueRay_DVD)c.get(i)).getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((BlueRay_DVD)c.get(i)).getTemaxia())+"\r\n");
                        bw.write("\t\tRESOLUTION "+(((BlueRay_DVD)c.get(i)).getAnalush())+"\r\n");
                        bw.write("\t\tFORMAT "+(((BlueRay_DVD)c.get(i)).getFormat())+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    if(c.get(i).getClass().getName().equals("Psigeia"))
                    {
                        bw.write("\t\tITEM_TYPE Psigeia\r\n");
                        bw.write("\t\tMODEL "+((Psigeia)c.get(i)).getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Psigeia)c.get(i)).getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Psigeia)c.get(i)).getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Psigeia)c.get(i)).getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Psigeia)c.get(i)).getTemaxia())+"\r\n");
                        bw.write("\t\tFRIDGE_TYPE "+(((Psigeia)c.get(i)).getTipos())+"\r\n");
                        bw.write("\t\tENERGY_CLASS "+(((Psigeia)c.get(i)).getEnergiaki_Klasi())+"\r\n");
                        bw.write("\t\tREFRIGERATOR_VOLUME "+String.valueOf(((Psigeia)c.get(i)).getXoritikotita_Sidirisis())+"\r\n");
                        bw.write("\t\tFREEZER_VOLUME "+String.valueOf(((Psigeia)c.get(i)).getXoritikotita_Katapsiksis())+"\r\n");
                        bw.write("\t}\r\n");
                    }
                }//ITEM CASE
                        
                else if(FileType.equalsIgnoreCase("ORDER"))
                {
                    if(((Paraggelia)c.get(i)).getProion().getClass().getName().equals("Plidiria_Rouxwn"))
                    {
                        bw.write("\t\tORDER_TYPE Plidiria_Rouxwn\r\n");
                        bw.write("\t\tMODEL "+((Paraggelia)c.get(i)).getProion().getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Paraggelia)c.get(i)).getProion().getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Paraggelia)c.get(i)).getProion().getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Paraggelia)c.get(i)).getProion().getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Paraggelia)c.get(i)).getProion().getTemaxia())+"\r\n");
                        bw.write("\t\tENERGY_CLASS "+String.valueOf(((Plidiria_Rouxwn)((Paraggelia)c.get(i)).getProion()).getEnergiaki_Klasi())+"\r\n");
                        bw.write("\t\tVOLUME "+String.valueOf(((Plidiria_Rouxwn)((Paraggelia)c.get(i)).getProion()).getXoritikotita())+"\r\n");
                        bw.write("\t\tSPINS "+String.valueOf(((Plidiria_Rouxwn)((Paraggelia)c.get(i)).getProion()).getStrofes())+"\r\n");
                        
                        bw.write("\t\tORDER_CODE "+String.valueOf(((Paraggelia)c.get(i)).getKodikos_Paraggelias())+"\r\n");
                        bw.write("\t\tNAME "+(((Paraggelia)c.get(i)).getOnomatEponimo_Pelati())+"\r\n");
                        bw.write("\t\tPHONE_NUMBER "+((Paraggelia)c.get(i)).getTilefono_Pelati()+"\r\n");
                        bw.write("\t\tORDER_DATE "+String.valueOf(((Paraggelia)c.get(i)).getHmeromhnia_Paragelias())+"\r\n");
                        bw.write("\t\tARRIVAL_DATE "+String.valueOf(((Paraggelia)c.get(i)).getHmeromhnia_Afiksis())+"\r\n");
                        bw.write("\t\tFINAL_PRICE "+String.valueOf(((Paraggelia)c.get(i)).getTeliko_Kostos())+"\r\n");
                        bw.write("\t\tORDER_STATUS "+String.valueOf(((Paraggelia)c.get(i)).getKatastasi_Paragelias())+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    else if(((Paraggelia)c.get(i)).getProion().getClass().getName().equals("Thleorash"))
                    {
                        bw.write("\t\tORDER_TYPE Thleorash\r\n");
                        bw.write("\t\tMODEL "+((Paraggelia)c.get(i)).getProion().getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Paraggelia)c.get(i)).getProion().getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Paraggelia)c.get(i)).getProion().getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Paraggelia)c.get(i)).getProion().getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Paraggelia)c.get(i)).getProion().getTemaxia())+"\r\n");
                        bw.write("\t\tPANEL_TYPE "+((Thleorash)((Paraggelia)c.get(i)).getProion()).getTupos()+"\r\n");
                        bw.write("\t\tDIMENSIONS "+String.valueOf(((Thleorash)((Paraggelia)c.get(i)).getProion()).getDiastash())+"\r\n");
                        bw.write("\t\tRESOLUTION "+((Thleorash)((Paraggelia)c.get(i)).getProion()).getAnalush()+"\r\n");
                        bw.write("\t\tPORTS "+((Thleorash)((Paraggelia)c.get(i)).getProion()).getThures()+"\r\n");
                        
                        bw.write("\t\tORDER_CODE "+String.valueOf(((Paraggelia)c.get(i)).getKodikos_Paraggelias())+"\r\n");
                        bw.write("\t\tNAME "+(((Paraggelia)c.get(i)).getOnomatEponimo_Pelati())+"\r\n");
                        bw.write("\t\tPHONE_NUMBER "+((Paraggelia)c.get(i)).getTilefono_Pelati()+"\r\n");
                        bw.write("\t\tORDER_DATE "+String.valueOf(((Paraggelia)c.get(i)).getHmeromhnia_Paragelias())+"\r\n");
                        bw.write("\t\tARRIVAL_DATE "+String.valueOf(((Paraggelia)c.get(i)).getHmeromhnia_Afiksis())+"\r\n");
                        bw.write("\t\tFINAL_PRICE "+String.valueOf(((Paraggelia)c.get(i)).getTeliko_Kostos())+"\r\n");
                        bw.write("\t\tORDER_STATUS "+String.valueOf(((Paraggelia)c.get(i)).getKatastasi_Paragelias())+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    else if(((Paraggelia)c.get(i)).getProion().getClass().getName().equals("BlueRay_DVD"))
                    {
                        bw.write("\t\tORDER_TYPE BlueRay_DVD\r\n");
                        bw.write("\t\tMODEL "+((Paraggelia)c.get(i)).getProion().getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Paraggelia)c.get(i)).getProion().getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Paraggelia)c.get(i)).getProion().getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((BlueRay_DVD)c.get(i)).getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((BlueRay_DVD)c.get(i)).getTemaxia())+"\r\n");
                        bw.write("\t\tRESOLUTION "+(((BlueRay_DVD)c.get(i)).getAnalush())+"\r\n");
                        bw.write("\t\tFORMAT "+(((BlueRay_DVD)c.get(i)).getFormat())+"\r\n");
                        
                        bw.write("\t\tORDER_CODE "+String.valueOf(((Paraggelia)c.get(i)).getKodikos_Paraggelias())+"\r\n");
                        bw.write("\t\tNAME "+(((Paraggelia)c.get(i)).getOnomatEponimo_Pelati())+"\r\n");
                        bw.write("\t\tPHONE_NUMBER "+((Paraggelia)c.get(i)).getTilefono_Pelati()+"\r\n");
                        bw.write("\t\tORDER_DATE "+String.valueOf(((Paraggelia)c.get(i)).getHmeromhnia_Paragelias())+"\r\n");
                        bw.write("\t\tARRIVAL_DATE "+String.valueOf(((Paraggelia)c.get(i)).getHmeromhnia_Afiksis())+"\r\n");
                        bw.write("\t\tFINAL_PRICE "+String.valueOf(((Paraggelia)c.get(i)).getTeliko_Kostos())+"\r\n");
                        bw.write("\t\tORDER_STATUS "+String.valueOf(((Paraggelia)c.get(i)).getKatastasi_Paragelias())+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    else if(((Paraggelia)c.get(i)).getProion().getClass().getName().equals("Psigeia"))
                    {
                        bw.write("\t\tORDER_TYPE Psigeia\r\n");
                        bw.write("\t\tMODEL "+((Paraggelia)c.get(i)).getProion().getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Paraggelia)c.get(i)).getProion().getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Paraggelia)c.get(i)).getProion().getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Paraggelia)c.get(i)).getProion().getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Paraggelia)c.get(i)).getProion().getTemaxia())+"\r\n");
                        bw.write("\t\tFRIDGE_TYPE "+((Psigeia)((Paraggelia)c.get(i)).getProion()).getTipos()+"\r\n");
                        bw.write("\t\tENERGY_CLASS "+((Psigeia)((Paraggelia)c.get(i)).getProion()).getEnergiaki_Klasi()+"\r\n");
                        bw.write("\t\tREFRIGERATOR_VOLUME "+String.valueOf(((Psigeia)((Paraggelia)c.get(i)).getProion()).getXoritikotita_Sidirisis())+"\r\n");
                        bw.write("\t\tFREEZER_VOLUME "+String.valueOf(((Psigeia)((Paraggelia)c.get(i)).getProion()).getXoritikotita_Katapsiksis())+"\r\n");
                        
                        bw.write("\t\tORDER_CODE "+String.valueOf(((Paraggelia)c.get(i)).getKodikos_Paraggelias())+"\r\n");
                        bw.write("\t\tNAME "+(((Paraggelia)c.get(i)).getOnomatEponimo_Pelati())+"\r\n");
                        bw.write("\t\tPHONE_NUMBER "+((Paraggelia)c.get(i)).getTilefono_Pelati()+"\r\n");
                        bw.write("\t\tORDER_DATE "+String.valueOf(((Paraggelia)c.get(i)).getHmeromhnia_Paragelias())+"\r\n");
                        bw.write("\t\tARRIVAL_DATE "+String.valueOf(((Paraggelia)c.get(i)).getHmeromhnia_Afiksis())+"\r\n");
                        bw.write("\t\tFINAL_PRICE "+String.valueOf(((Paraggelia)c.get(i)).getTeliko_Kostos())+"\r\n");
                        bw.write("\t\tORDER_STATUS "+String.valueOf(((Paraggelia)c.get(i)).getKatastasi_Paragelias())+"\r\n");
                        bw.write("\t}\r\n");
                    }
                }// ORDER CASE
                        
                else if(FileType.equalsIgnoreCase("SALE"))
                {
                    if(((Pwlisi)c.get(i)).getProion().getClass().getName().equals("Plidiria_Rouxwn"))
                    {
                        bw.write("\t\tSALE_TYPE Plidiria_Rouxwn\r\n");
                        bw.write("\t\tMODEL "+((Pwlisi)c.get(i)).getProion().getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Pwlisi)c.get(i)).getProion().getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Pwlisi)c.get(i)).getProion().getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Pwlisi)c.get(i)).getProion().getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Pwlisi)c.get(i)).getProion().getTemaxia())+"\r\n");
                        bw.write("\t\tENERGY_CLASS "+String.valueOf(((Plidiria_Rouxwn)((Pwlisi)c.get(i)).getProion()).getEnergiaki_Klasi())+"\r\n");
                        bw.write("\t\tVOLUME "+String.valueOf(((Plidiria_Rouxwn)((Pwlisi)c.get(i)).getProion()).getXoritikotita())+"\r\n");
                        bw.write("\t\tSPINS "+String.valueOf(((Plidiria_Rouxwn)((Pwlisi)c.get(i)).getProion()).getStrofes())+"\r\n");
                        
                        bw.write("\t\tSALE_DATE "+((Pwlisi)c.get(i)).getHmeromhnia_Pwlisis()+"\r\n");
                        bw.write("\t\tSALE_CODE "+String.valueOf(((Pwlisi)c.get(i)).getKodikos_Pwlisis())+"\r\n");
                        bw.write("\t\tNAME "+((Pwlisi)c.get(i)).getOnomatEponimo_Pelati()+"\r\n");
                        bw.write("\t\tFINAL_PRICE "+String.valueOf(((Pwlisi)c.get(i)).getTeliko_Kostos())+"\r\n");
                        bw.write("\t\tPHONE "+((Pwlisi)c.get(i)).getTilefono_Pelati()+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    else if(((Pwlisi)c.get(i)).getProion().getClass().getName().equals("Thleorash"))
                    {
                        bw.write("\t\tSALE_TYPE Thleorash\r\n");
                        bw.write("\t\tMODEL "+((Pwlisi)c.get(i)).getProion().getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Pwlisi)c.get(i)).getProion().getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Pwlisi)c.get(i)).getProion().getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Pwlisi)c.get(i)).getProion().getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Pwlisi)c.get(i)).getProion().getTemaxia())+"\r\n");
                        bw.write("\t\tPANEL_TYPE "+((Thleorash)((Pwlisi)c.get(i)).getProion()).getTupos()+"\r\n");
                        bw.write("\t\tDIMENSIONS "+String.valueOf(((Thleorash)((Pwlisi)c.get(i)).getProion()).getDiastash())+"\r\n");
                        bw.write("\t\tRESOLUTION "+((Thleorash)((Pwlisi)c.get(i)).getProion()).getAnalush()+"\r\n");
                        bw.write("\t\tPORTS "+((Thleorash)((Pwlisi)c.get(i)).getProion()).getThures()+"\r\n");
                        
                        bw.write("\t\tSALE_DATE "+((Pwlisi)c.get(i)).getHmeromhnia_Pwlisis()+"\r\n");
                        bw.write("\t\tSALE_CODE "+String.valueOf(((Pwlisi)c.get(i)).getKodikos_Pwlisis())+"\r\n");
                        bw.write("\t\tNAME "+((Pwlisi)c.get(i)).getOnomatEponimo_Pelati()+"\r\n");
                        bw.write("\t\tFINAL_PRICE "+String.valueOf(((Pwlisi)c.get(i)).getTeliko_Kostos())+"\r\n");
                        bw.write("\t\tPHONE "+((Pwlisi)c.get(i)).getTilefono_Pelati()+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    else if(((Pwlisi)c.get(i)).getProion().getClass().getName().equals("BlueRay_DVD"))
                    {
                        bw.write("\t\tSALE_TYPE BlueRay_DVD\r\n");
                        bw.write("\t\tMODEL "+((Pwlisi)c.get(i)).getProion().getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Pwlisi)c.get(i)).getProion().getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Pwlisi)c.get(i)).getProion().getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Pwlisi)c.get(i)).getProion().getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Pwlisi)c.get(i)).getProion().getTemaxia())+"\r\n");
                        bw.write("\t\tRESOLUTION "+((BlueRay_DVD)((Pwlisi)c.get(i)).getProion()).getAnalush()+"\r\n");
                        bw.write("\t\tFORMAT "+((BlueRay_DVD)((Pwlisi)c.get(i)).getProion()).getFormat()+"\r\n");
                        
                        bw.write("\t\tSALE_DATE "+((Pwlisi)c.get(i)).getHmeromhnia_Pwlisis()+"\r\n");
                        bw.write("\t\tSALE_CODE "+String.valueOf(((Pwlisi)c.get(i)).getKodikos_Pwlisis())+"\r\n");
                        bw.write("\t\tNAME "+((Pwlisi)c.get(i)).getOnomatEponimo_Pelati()+"\r\n");
                        bw.write("\t\tFINAL_PRICE "+String.valueOf(((Pwlisi)c.get(i)).getTeliko_Kostos())+"\r\n");
                        bw.write("\t\tPHONE "+((Pwlisi)c.get(i)).getTilefono_Pelati()+"\r\n");
                        bw.write("\t}\r\n");
                    }
                    else if(((Pwlisi)c.get(i)).getProion().getClass().getName().equals("Psigeia"))
                    {
                        bw.write("\t\tSALE_TYPE Psigeia\r\n");
                        bw.write("\t\tMODEL "+((Pwlisi)c.get(i)).getProion().getOnoma_Montelou()+"\r\n");
                        bw.write("\t\tMODEL_YEAR "+String.valueOf(((Pwlisi)c.get(i)).getProion().getEtos_Montelou())+"\r\n");
                        bw.write("\t\tMANUFACTURER "+((Pwlisi)c.get(i)).getProion().getKataskeyastis()+"\r\n");
                        bw.write("\t\tPRICE "+String.valueOf(((Pwlisi)c.get(i)).getProion().getTimh())+"\r\n");
                        bw.write("\t\tPIECES "+String.valueOf(((Pwlisi)c.get(i)).getProion().getTemaxia())+"\r\n");
                        bw.write("\t\tFRIDGE_TYPE "+((Psigeia)((Pwlisi)c.get(i)).getProion()).getTipos()+"\r\n");
                        bw.write("\t\tENERGY_CLASS "+((Psigeia)((Pwlisi)c.get(i)).getProion()).getEnergiaki_Klasi()+"\r\n");
                        bw.write("\t\tREFRIGERATOR_VOLUME "+String.valueOf(((Psigeia)((Pwlisi)c.get(i)).getProion()).getXoritikotita_Sidirisis())+"\r\n");
                        bw.write("\t\tFREEZER_VOLUME "+String.valueOf(((Psigeia)((Pwlisi)c.get(i)).getProion()).getXoritikotita_Katapsiksis())+"\r\n");
                        
                        bw.write("\t\tSALE_DATE "+((Pwlisi)c.get(i)).getHmeromhnia_Pwlisis()+"\r\n");
                        bw.write("\t\tSALE_CODE "+String.valueOf(((Pwlisi)c.get(i)).getKodikos_Pwlisis())+"\r\n");
                        bw.write("\t\tNAME "+((Pwlisi)c.get(i)).getOnomatEponimo_Pelati()+"\r\n");
                        bw.write("\t\tFINAL_PRICE "+String.valueOf(((Pwlisi)c.get(i)).getTeliko_Kostos())+"\r\n");
                        bw.write("\t\tPHONE "+((Pwlisi)c.get(i)).getTilefono_Pelati()+"\r\n");
                        bw.write("\t}\r\n");
                    }
                }//SALE CASE

            }//end_for
            bw.write("}");
            bw.close();
            System.out.println("File "+FileType+".txt saved/overwritten successfully.");
        } catch (IOException e)
        {
            System.err.println("Error writing in file");
        }
    }

    public static void loadFile(File f, ArrayList c) //method to load a files components into one of the ArrayList collections
    {

        makeDefault(Tags);

        int dotindex = f.getName().indexOf(".");
        String FileType = f.getName().substring(0, dotindex);
        boolean corrupted = false;
        String line = "";
        int spaceindex = 0;
        String line_firstWord = "";
        String line_residue = "";
        int line_counter = 0;
        BufferedReader br = null;


        int LIST_num = 0;//number of _LIST entities found
        int CORE_num = 0;//number of CORE entities found
        int LIST_status = 0; // 0=awaiting LIST entity declaration | 1=awaiting LIST { | 2=awaiting LIST }
        int CORE_status = 0; // 0=awaiting CORE entity declaration | 1=awaiting CORE { | 2=awaiting CORE }


        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        } 
        catch (FileNotFoundException e)
        {
            System.err.println("Error creating file input buffer or file not found");
        }
        try
        {
            line = br.readLine();
            line_counter++;


            while (line!=null)
            {
                
                if (!line.trim().equals(""))
                {
                    if(line.trim().contains(" "))
                    {
                        spaceindex = line.trim().indexOf(" ");
                        line_firstWord = line.trim().substring(0, spaceindex);
                        line_residue = line.trim().substring(spaceindex+1);
                    }
                    
                    if (line.trim().equalsIgnoreCase(FileType+"_LIST") && (LIST_status == 0) && (CORE_status == 0) && (LIST_num == 0))
                    {
                        LIST_status = 1;
                    }
                    else if (line.trim().equalsIgnoreCase(FileType) && (LIST_status == 2) && (CORE_status == 0))
                    {
                        CORE_status = 1;
                    }
                    else if (line.trim().equalsIgnoreCase("{"))
                    {
                        if ((LIST_status == 1) && (CORE_status == 0))
                        {
                            LIST_status = 2;
                        }
                        else if ((LIST_status == 2) && (CORE_status == 1))
                        {
                            CORE_status = 2;
                        }
                        else
                        {
                            corrupted = true;
                            break;
                        }
                    }
                    else if (line.trim().equalsIgnoreCase("}"))
                    {
                        if ((LIST_status == 2) && (CORE_status == 0))
                        {
                            LIST_num++;
                            LIST_status = 0;
                        }
                        else if ((LIST_status == 2) && (CORE_status == 2))
                        {
                            CORE_status = 0;

                            //ITEM FILE PARSING
                            if (FileType.equalsIgnoreCase("ITEM"))
                            {
                                if (((String)Tags.get("ITEM_TYPE")).equals("BlueRay_DVD"))
                                {
                                    c.add(new BlueRay_DVD(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble(Tags.get("PRICE").toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("RESOLUTION")), ((String) Tags.get("FORMAT"))));
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("ITEM_TYPE")).equals("Plidiria_Rouxwn"))
                                {
                                    c.add(new Plidiria_Rouxwn(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("ENERGY_CLASS")), Integer.parseInt(Tags.get("VOLUME").toString()), Integer.parseInt((Tags.get("SPINS")).toString()) ) );
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("ITEM_TYPE")).equals("Psigeia"))
                                {
                                    c.add(new Psigeia( ((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("FRIDGE_TYPE")), ((String) Tags.get("ENERGY_CLASS")), Integer.parseInt((Tags.get("REFRIGERATOR_VOLUME")).toString()), Integer.parseInt((Tags.get("FREEZER_VOLUME")).toString()) ) );
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("ITEM_TYPE")).equals("Thleorash"))
                                {
                                    c.add(new Thleorash(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("RESOLUTION")),((String)Tags.get("PANEL_TYPE")),Integer.parseInt((Tags.get("DIMENSIONS")).toString()),((String)Tags.get("PORTS")) ) );
                                    CORE_num++;
                                }

                            } //ORDER FILE PARSING
                                    
                            else if (FileType.equalsIgnoreCase("ORDER"))
                            {
                                if ( ((String)Tags.get("ORDER_TYPE")).equals("BlueRay_DVD"))
                                {
                                    c.add(new Paraggelia(new BlueRay_DVD(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("RESOLUTION")), ((String) Tags.get("FORMAT"))), Integer.parseInt((Tags.get("ORDER_CODE")).toString()), ((String) Tags.get("NAME")), ((String) Tags.get("PHONE_NUMBER")), ((String) Tags.get("ORDER_DATE")), ((String) Tags.get("ARRIVAL_DATE")), Double.parseDouble((Tags.get("FINAL_PRICE")).toString()), Boolean.parseBoolean((Tags.get("ORDER_STATUS")).toString()) ) );
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("ORDER_TYPE")).equals("Plidiria_Rouxwn"))
                                {
                                    c.add(new Paraggelia(new Plidiria_Rouxwn(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("ENERGY_CLASS")), Integer.parseInt((Tags.get("VOLUME")).toString()), Integer.parseInt((Tags.get("SPINS")).toString()) ), Integer.parseInt((Tags.get("ORDER_CODE")).toString()), ((String) Tags.get("NAME")), ((String) Tags.get("PHONE_NUMBER")), ((String) Tags.get("ORDER_DATE")), ((String) Tags.get("ARRIVAL_DATE")), Double.parseDouble((Tags.get("FINAL_PRICE")).toString()), Boolean.parseBoolean((Tags.get("ORDER_STATUS")).toString())));
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("ORDER_TYPE")).equals("Psigeia"))
                                {
                                    c.add(new Paraggelia(new Psigeia( ((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("FRIDGE_TYPE")), ((String) Tags.get("ENERGY_CLASS")), Integer.parseInt((Tags.get("REFRIGERATOR_VOLUME")).toString()), Integer.parseInt((Tags.get("FREEZER_VOLUME").toString())) ), Integer.parseInt((Tags.get("ORDER_CODE")).toString()), ((String) Tags.get("NAME")), ((String) Tags.get("PHONE_NUMBER")), ((String) Tags.get("ORDER_DATE")), ((String) Tags.get("ARRIVAL_DATE")), Double.parseDouble((Tags.get("FINAL_PRICE")).toString()), Boolean.parseBoolean((Tags.get("ORDER_STATUS")).toString()) ) );
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("ORDER_TYPE")).equals("Thleorash"))
                                {
                                    c.add(new Paraggelia(new Thleorash(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("RESOLUTION")), ((String) Tags.get("PANEL_TYPE")), Integer.parseInt((Tags.get("DIMENSIONS")).toString()), ((String) Tags.get("PORTS"))), Integer.parseInt((Tags.get("ORDER_CODE")).toString()), ((String) Tags.get("NAME")), ((String) Tags.get("PHONE_NUMBER")), ((String) Tags.get("ORDER_DATE")), ((String) Tags.get("ARRIVAL_DATE")), Double.parseDouble((Tags.get("FINAL_PRICE")).toString()), Boolean.parseBoolean((Tags.get("ORDER_STATUS")).toString())));
                                    CORE_num++;
                                }
                            } //SALE FILE PARSING
                            else if (FileType.equalsIgnoreCase("SALE"))
                            {
                                if ( ((String) Tags.get("SALE_TYPE")).equals("BlueRay_DVD"))
                                {
                                    c.add(new Pwlisi(new BlueRay_DVD(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("RESOLUTION")), ((String) Tags.get("FORMAT"))), Integer.parseInt((Tags.get("SALE_CODE")).toString()), ((String) Tags.get("NAME")), ((String) Tags.get("PHONE_NUMBER")), ((String) Tags.get("SALE_DATE")), Double.parseDouble((Tags.get("FINAL_PRICE")).toString())));
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("SALE_TYPE")).equals("Plidiria_Rouxwn"))
                                {
                                    c.add(new Pwlisi(new Plidiria_Rouxwn(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("ENERGY_CLASS")), Integer.parseInt((Tags.get("VOLUME")).toString()), Integer.parseInt((Tags.get("SPINS")).toString()) ), Integer.parseInt((Tags.get("SALE_CODE")).toString()), ((String) Tags.get("NAME")), ((String) Tags.get("PHONE_NUMBER")), ((String) Tags.get("SALE_DATE")), Double.parseDouble((Tags.get("FINAL_PRICE")).toString())));
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("SALE_TYPE")).equals("Psigeia"))
                                {
                                    c.add(new Pwlisi (new Psigeia(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("FRIDGE_TYPE")), ((String) Tags.get("ENERGY_CLASS")), Integer.parseInt((Tags.get("REFRIGERATOR_VOLUME")).toString()), Integer.parseInt(Tags.get("FREEZER_VOLUME").toString()) ), Integer.parseInt((Tags.get("SALE_CODE")).toString()), ((String) Tags.get("NAME")), ((String) Tags.get("PHONE_NUMBER")), ((String) Tags.get("SALE_DATE")), Double.parseDouble((Tags.get("FINAL_PRICE")).toString()) ) );
                                    CORE_num++;
                                }
                                else if (((String) Tags.get("SALE_TYPE")).equals("Thleorash"))
                                {
                                    c.add(new Pwlisi(new Thleorash(((String) Tags.get("MODEL")), Integer.parseInt((Tags.get("MODEL_YEAR")).toString()), ((String) Tags.get("MANUFACTURER")), Double.parseDouble((Tags.get("PRICE")).toString()), Integer.parseInt((Tags.get("PIECES")).toString()), ((String) Tags.get("RESOLUTION")), ((String) Tags.get("PANEL_TYPE")), Integer.parseInt((Tags.get("DIMENSIONS")).toString()), ((String) Tags.get("PORTS"))), Integer.parseInt((Tags.get("SALE_CODE")).toString()), ((String) Tags.get("NAME")), ((String) Tags.get("PHONE_NUMBER")), ((String) Tags.get("SALE_DATE")), Double.parseDouble((Tags.get("FINAL_PRICE")).toString())));
                                    CORE_num++;
                                }
                            }

                            makeDefault(Tags);

                        }
                        
                        else
                        {
                            corrupted = true;
                            break;
                        }
                    }
                    else
                    {
                        if(LIST_status==2&&CORE_status==2)
                        {
                            if(Tags.containsKey(line_firstWord.toUpperCase())&&(!line_residue.matches("\\s+")) )
                            {
                                if(line_residue!=null)
                                {
                                Tags.put(line_firstWord, line_residue);
                                }
                            }
                        }
                        else
                        {
                            corrupted=true;
                            break;
                        }
                    }
                    
                }// if(LINE NOT EMPTY)
                
                
                line = br.readLine();
                line_counter++;
                
            }//end_while

            br.close();
            if (corrupted)
            {
                c.clear();
                System.out.println("Error: corrupted/invalid file format.\r\nFile was not loaded and data collection is empty.\r\nProblem detected in line " + line_counter);
            }
            else
            {
                System.out.println("Loading of file "+f.getName()+" to data collection successful.\r\n"+CORE_num+" entities loaded.");
            }
        }
        catch (IOException e)
        {
            System.err.println("Error reading while in line" + line_counter);
        }

    }//end_loadFile

    public static void makeDefault(HashMap h) 
    {
        h.clear();
        h.put("ITEM_TYPE", new String("N/A"));
        h.put("ORDER_TYPE", new String("N/A"));
        h.put("SALE_TYPE", new String("N/A"));
        h.put("MODEL", new String("N/A"));
        h.put("MODEL_YEAR", new Integer(-1));
        h.put("MANUFACTURER", new String("N/A"));
        h.put("PRICE", new Double(0.00));
        h.put("PIECES", new Integer(-1));
        h.put("PANEL_TYPE", new String("N/A"));
        h.put("DIMENSIONS", new Integer(0));
        h.put("PORTS", new String("N/A"));
        h.put("FORMAT", new String("N/A"));
        h.put("RESOLUTION", new String("N/A"));
        h.put("FRIDGE_TYPE", new String("N/A"));
        h.put("REFRIGERATOR_VOLUME", new Integer(0));
        h.put("FREEZER_VOLUME", new Integer(0));
        h.put("ENERGY_CLASS", new String("N/A"));
        h.put("VOLUME", new Integer(0));
        h.put("SPINS", new Integer(0));
        h.put("SALE_DATE", new String("N/A"));
        h.put("SALE_CODE", new Integer(-1));
        h.put("NAME", new String("N/A"));
        h.put("PHONE_NUMBER", new String("N/A"));
        h.put("FINAL_PRICE", new Double(0.00));
        h.put("ORDER_DATE", new String("N/A"));
        h.put("ARRIVAL_DATE", new String("N/A"));
        h.put("ORDER_STATUS", new Boolean(false));
        h.put("ORDER_CODE", new Integer(-1));
    }
}//end_Katasthma
