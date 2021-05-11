import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MetierBase
{
    //Attribut
    private List<Ouvrage> ensOuvrages;
    
    //Constructeur
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

    public ArrayList<String> lireFichier(String chemin)
    {
        ArrayList<String> oFichier = new ArrayList<String>();

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

    public void ecrireFichier(String chemin, String toPrint)
    {
        try
        {
            PrintWriter oOutput = new PrintWriter( new FileWriter(chemin, true));
        
            oOutput.println(toPrint);
            oOutput.close();
        }
        catch(Exception e){ e.printStackTrace(); }
    }

    public String toString()
    {
        File f = new File("sortie.txt");
        boolean bIsExisting = f.exists();

        if(!bIsExisting)
        {
            String sEntete = "+";
            String suite = "------------------------------+";
    
            for(int i = 0; i < 5; i++)
            {
                sEntete += suite;
            }
    
            sEntete += "\n";

            String encadre = "|" + String.format("%-30s", "Titre") + "|" +
            String.format("%-30s", "Scenariste")  + "|" +
            String.format("%-30s", "Dessinateur") + "|" + 
            String.format("%-30s", "Editeur")     + "|" +
            String.format("%-30s", "Serie")       + "|" + "\n";

            sEntete += encadre + "+";

            for(int i = 0; i < 5; i++)
            {
                sEntete += suite;
            }

            sEntete += "\n";

            for(Ouvrage o : this.ensOuvrages)
            {
                sEntete += o.toString();
            }

            return sEntete;
        }
        else
        {
            String sRet = "";

            for(Ouvrage o : this.ensOuvrages)
            {
                sRet += o.toString();
            }

            return sRet;
        }
    }
}
