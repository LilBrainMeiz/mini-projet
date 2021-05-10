import javax.swing.JFrame;

public class FrameSaisie extends JFrame
{
    private ControleurSaisie oCtrl;
    private PanelSaisie oPanelSaisie;

    public FrameSaisie(ControleurSaisie ctrl)
    {
        // Modèle MVC
        this.oCtrl = ctrl;

        this.setTitle("Mini-projet");
        this.setSize(600, 600);
        this.setLocation(20, 20);
        
        this.oPanelSaisie = new PanelSaisie(oCtrl);
        
        this.add(this.oPanelSaisie);
        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible(true);
    }
    
    public void maj()
    {
        this.oPanelSaisie.maj();
    }
}
