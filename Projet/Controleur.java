public class Controleur
{
    private MainFrame oIHM;

    public Controleur()
    {
        this.oIHM = new MainFrame(this);
    }

    public static void main(String[] args)
    {
        new Controleur();
    }
}
