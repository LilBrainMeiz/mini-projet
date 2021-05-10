public class ControleurSaisie
{
    private FrameSaisie  ihm;
    private MetierSaisie metier;

    public ControleurSaisie()
    {
        this.ihm = new FrameSaisie(this);
        this.metier = new MetierSaisie();
    }

    public void ajouterOuvrage(String titre, String editeur, String serie,
                               String scenariste, String dessinateur,
                               Integer tome)
    {
        this.metier.ajouterOuvrage(titre, editeur, serie, scenariste,
                                   dessinateur, tome);

        metier.ecrireFichier("sortie.txt", metier.toString());
    }

    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
