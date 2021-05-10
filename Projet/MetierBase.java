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

        Scanner oInput = new Scanner(new File(path));

        // Bug ici si le fichier est vide;
        do
        {
            oFichier.add(oInput.nextLine());
        }while(oInput.hasNextLine());

        return oFichier;
    }
}