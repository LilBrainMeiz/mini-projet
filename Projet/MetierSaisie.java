/*
 * MetierSaisie.java
 * Metier qui hérite de MetierBase
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */

import java.util.List;

import java.io.File       ;
import java.io.FileWriter ;
import java.io.PrintWriter;

public class MetierSaisie extends MetierBase
{
    // Constructeur
    public MetierSaisie(){}
    
    // Accesseur
    /* @param chemin
     *          
     * @return ArrayList*/
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
