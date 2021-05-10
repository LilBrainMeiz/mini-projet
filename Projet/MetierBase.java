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