import java.util.List;
import java.util.ArrayList;

import java.io.FileWriter;

public class MetierSaisie extends MetierBase
{
    public MetierSaisie(){}

    public String[] getAuteur()
    {
        ArrayList<String> tab = super.lireFichier("auteur.txt");

        return tab.toArray(new String[tab.size()]);
    }

    public String[] getEditeur()
    {
        ArrayList<String> tab = super.lireFichier("editeur.txt");

        return tab.toArray(new String[tab.size()]);
    }

    public String[] getSerie()
    {
        List<String> tab = super.lireFichier("serie.txt");

        return tab.toArray(new String[tab.size()]);
    }
}
