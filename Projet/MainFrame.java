import javax.swing.JFrame;

public class MainFrame extends JFrame
{
    private Controleur oCtrl;

    public MainFrame(Controleur ctrl)
    {
        // Modèle MVC
        this.oCtrl = ctrl;

        this.setTitle("Mini-projet");
        this.setSize(600, 600);
        this.setLocation(20, 20);

        this.setVisible(true);
    }
}