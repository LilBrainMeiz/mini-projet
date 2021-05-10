public class MetierSaisie extends MetierBase
{
    public void ecrireFichier(String chemin, String toPrint)
    {
        try
        {
            PrintWriter oOutput = new PrintWriter( new FileOutputStream(
                                                       chemin));

            oOutput.println(toPrint);

            oOutput.close();
        }catch(Exception e){ e.printStackTrace(); }
    }
}
