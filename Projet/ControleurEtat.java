public class ControleurEtat
{
    private FrameEtat  ihm;
    private MetierEtat metier;

    public ControleurEtat()
    {
        this.ihm    = new FrameEtat(this);
        this.metier = new metierEtat();
    }

    public static public static void main(String[] args) {
        new ControleurEtat();
    }
}
