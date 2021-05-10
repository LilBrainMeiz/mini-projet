public class ControleurSaisie
{
    private MainFrame    ihm;
    private MetierSaisie metier;
    
    public ControleurSaisie()
    {
        this.ihm    = new MainFrame(this);
        this.metier = new MetierSaisie();
    }

    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
