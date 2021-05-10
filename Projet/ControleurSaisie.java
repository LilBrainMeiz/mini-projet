public class ControleurSaisie
{
    private FrameSaisie  ihm;
    private MetierSaisie metier;

    public ControleurSaisie()
    {
        this.ihm = new FrameSaisie(this);
        this.metier = new MetierSaisie(this);

        metier.ajouterOuvrage("test", "test", "test", "test", "test", 10);

        String toPrint = metier.toString();
        metier.ecrireFichier("sortie.txt", toPrint);
    }

    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
