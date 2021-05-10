import java.io.PrintWriter;
import java.io.FileOutputStream;

import java.io.FileWriter;

public class MetierSaisie extends MetierBase
{
    public void ecrireFichier(String chemin, String toPrint)
    {
        try
        {
            PrintWriter oOutput = new PrintWriter( new FileWriter(chemin, true));

            oOutput.println(toPrint);

            oOutput.close();
        }catch(Exception e){ e.printStackTrace(); }
    }
}
