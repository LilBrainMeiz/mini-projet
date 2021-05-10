import java.util.List;

public class MetierSaisie extends MetierBase
{
    public MetierSaisie(){}

    public String[] getAuteur()
    {
        List<String> tab = super.lireFichier("auteur.txt");

        return tab.toArray(new String[tab.size()]);
    }

    public String[] getEditeur()
    {
        List<String> tab = super.lireFichier("editeur.txt");

        return tab.toArray(new String[tab.size()]);
    }

    public String[] getSerie()
    {
        List<String> tab = super.lireFichier("serie.txt");

        return tab.toArray(new String[tab.size()]);
    }
}
