import java.util.List;

import java.io.File       ;
import java.io.FileWriter ;
import java.io.PrintWriter;

public class MetierSaisie extends MetierBase
{
    public MetierSaisie(){}

    public String[] getEnsemble( String chemin )
    {
        List<String> tab = super.lireFichier(chemin);

        return tab.toArray(new String[tab.size()]);
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
        File      f = new File("sortie.txt");
        String sRet = "";

        boolean bIsExisting = f.exists();

        if(!bIsExisting)
        {
            sRet = super.enTete();
            
            for(Ouvrage o : super.getOuvrages() )sRet += "\n" + o.toString();
        }
        else
        {
            sRet = super.getLastOuvrage().toString();
        }

        return sRet;
    }
}
