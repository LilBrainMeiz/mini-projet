import javax.swing.JFrame;

public class FrameSaisie extends JFrame
{
    private ControleurSaisie oCtrl;

    public MainFrame(ControleurSaisie ctrl)
    {
        // Modèle MVC
        this.oCtrl = ctrl;

        this.setTitle("Mini-projet");
        this.setSize(600, 600);
        this.setLocation(20, 20);

        this.setVisible(true);
    }
}