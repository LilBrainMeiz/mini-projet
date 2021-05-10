public class ControleurSaisie
{
    private MainFrame oIHM;

    public ControleurSaisie()
    {
        this.oIHM = new MainFrame(this);
    }

    public static void main(String[] args)
    {
        new ControleurSaisie();
    }
}
