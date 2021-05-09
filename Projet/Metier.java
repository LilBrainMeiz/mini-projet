public class Metier 
{
    private final int MAX_OUVRAGE = 10000;
    private Ouvrage[] arOuvrages;

    public Metier()
    {
        // Remplissage du tableau pour 10 000 ouvrages
        this.arOuvrages = new Ouvrage[MAX_OUVRAGE];
    }
}
