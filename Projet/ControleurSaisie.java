public class ControleurSaisie
{
    //Attributs de ControleurSaisie
    private FrameSaisie  ihm;    /* @see FrameSaisie */
    private MetierSaisie metier; /* @see MetierSaisie */

    //Constructeur de la classe ControleurSaisie
    public ControleurSaisie()
    {
        this.metier = new MetierSaisie();
        this.ihm    = new FrameSaisie(this);
    }
    
    //Méthode pour ajouter un ouvrage dans la bedetheque en appellant la méthode du même nom dans la classe métier
    public void ajouterOuvrage(String titre, String editeur, String serie,
                               String scenariste, String dessinateur,
                               Integer tome)
    {
        this.metier.ajouterOuvrage(titre, editeur, serie, scenariste,
                                   dessinateur, tome);

        metier.ecrireFichier("sortie.txt", metier.toString());
    }
    
    //Accesseur aux attributs de la classe métier
    public String[] getSerie  (){ return this.metier.getSerie  (); }
    public String[] getAuteur (){ return this.metier.getAuteur (); }
    public String[] getEditeur(){ return this.metier.getEditeur(); }
     
    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
