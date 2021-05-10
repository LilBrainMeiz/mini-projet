import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MetierBase
{
    List<Ouvrage> ensOuvrages;

    public MetierBase()
    {
        this.ensOuvrages = new ArrayList<Ouvrage>();
    }

    public List<String> lireFichier(String chemin)
    {
        List<String> oFichier = new ArrayList<String>();

        try
        {
            Scanner oInput = new Scanner( new FileInputStream(chemin));

            while(oInput.hasNextLine())
            {
                oFichier.add(oInput.nextLine());
            }
        }catch(Exception e){ e.printStackTrace(); }

        return oFichier;
    }

    public void ecrireFichier(List<String> oFichier)
    {

    }
}