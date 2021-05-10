import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.FileInputStream;
import java.util.FileOutputStream;

import java.io.PrintWriter;

public class MetierBase
{
    private List<Ouvrage> ensOuvrages;

    public MetierBase()
    {
        this.ensOuvrages = new ArrayList<Ouvrage>();
    }

    public List<String> lireFichier(String chemin)
    {
        List<String> oFichier = new ArrayList<String>();

        try
        {
            Scanner oInput = new Scanner( new FileInputStream(chemin),
                                          "UTF8" );

            while(oInput.hasNextLine())
            {
                oFichier.add(oInput.nextLine());
            }
        }catch(Exception e){ e.printStackTrace(); }

        return oFichier;
    }

    public void ecrireFichier(String chemin, List<String> oFichier)
    {
        try
        {
            PrintWriter oOutput = new PrintWriter( new FileOutputStream(
                                                       chemin));

            for(String sToPrint : oFichier)
            {
                oOutput.println(sToPrint);
            }

            oOutput.close();
        }catch(Exception e){ e.printStackTrace(); }
    }
}