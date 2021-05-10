public class ControleurSaisie
{
    private FrameSaisie  ihm;
    private MetierSaisie metier;
    
    public ControleurSaisie()
    {
        this.ihm    = new FrameSaisie(this);
        this.metier = new MetierSaisie();

        metier.ajouterOuvrage("titre", "editeur", "serie", "scenariste",
                              "dessinateur", 5);
        metier.ajouterOuvrage("test", "test", "test", "test", "test", 10);

        System.out.println(metier.toString());
    }

    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
