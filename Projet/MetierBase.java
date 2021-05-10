import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MetierBase
{
    private List<Ouvrage> ensOuvrages;

    public MetierBase()
    {
        this.ensOuvrages = new ArrayList<Ouvrage>();
    }

    public void ajouterOuvrage(String titre, String editeur, String serie,
                               String scenariste, String dessinateur,
                               Integer tome)
    {
        this.ensOuvrages.add(Ouvrage.creerOuvrage(titre, editeur, serie,
                                                  scenariste, dessinateur,
                                                  tome));
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

    public String toString()
    {
        String sRet = "";

        for(Ouvrage o : this.ensOuvrages)
        {
            sRet += o.toString();
        }

        return sRet;
    }
}