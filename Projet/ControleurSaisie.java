public class ControleurSaisie
{
    private FrameSaisie  ihm;
    private MetierSaisie metier;

    public ControleurSaisie()
    {
        this.ihm = new FrameSaisie(this);
        this.metier = new MetierSaisie();

        metier.ajouterOuvrage("test", "test", "test", "test", "test", 10);

        String toPrint = metier.toString();
        metier.ecrireFichier("sortie.txt", toPrint);
    }

    public void ajouterOuvrage(String titre, String editeur, String serie,
                               String scenariste, String dessinateur,
                               Integer tome)
    {
        this.metier.ajouterOuvrage(titre, editeur, serie, scenariste,
                                   dessinateur, tome);
    }

    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
