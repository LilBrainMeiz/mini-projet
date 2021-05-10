public class ControleurSaisie
{
    private FrameSaisie  ihm;
    private MetierSaisie metier;
    
    public ControleurSaisie()
    {
        this.ihm    = new FrameSaisie(this);
        this.metier = new MetierSaisie();
    }

    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
