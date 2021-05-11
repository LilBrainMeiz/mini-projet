public class ControleurSaisie
{
    private FrameSaisie  ihm;
    private MetierSaisie metier;

    public ControleurSaisie()
    {
        this.metier = new MetierSaisie();
        this.ihm    = new FrameSaisie(this);
    }

    public void ajouterOuvrage(String titre, String editeur, String serie,
                               String scenariste, String dessinateur,
                               Integer tome)
    {
        this.metier.ajouterOuvrage(titre, editeur, serie, scenariste,
                                   dessinateur, tome);

        metier.ecrireFichier("sortie.txt", metier.toString());
    }

    public String[] getSerie  (){ return this.metier.getSerie  (); }
    public String[] getAuteur (){ return this.metier.getAuteur (); }
    public String[] getEditeur(){ return this.metier.getEditeur(); }
     
    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
