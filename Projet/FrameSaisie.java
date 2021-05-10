import javax.swing.JFrame;

public class FrameSaisie extends JFrame
{
    private ControleurSaisie oCtrl;
    private PanelSaisie oPanelSaisie;

    public FrameSaisie(ControleurSaisie ctrl)
    {
        // Modèle MVC
        this.oCtrl = ctrl;
        
        //Caractèristiques de la frame
        this.setTitle("Mini-projet");
        this.setSize(600, 600);
        this.setLocation(20, 20);
        
        //Création des composants
        this.oPanelSaisie = new PanelSaisie(oCtrl);
        
        //Ajout des composants
        this.add(this.oPanelSaisie);
        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible(true);
    }
    
    //Mise à jour du panel
    public void maj()
    {
        this.oPanelSaisie.maj();
    }
}
