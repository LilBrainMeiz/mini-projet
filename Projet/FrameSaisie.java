/*
 * FrameSaisie.java
 * Frame
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */

import javax.swing.JFrame;

public class FrameSaisie extends JFrame
{
    // Attributs
    private ControleurSaisie oCtrl;
    private PanelSaisie oPanelSaisie;
    
    // Constructeur
    /*
     * Ceci est le constructeur de la classe FrameSaisie
     *
     * @param ctrl
     *           Initialise oCtrl de FrameSaisie à ctrl*/
    public FrameSaisie(ControleurSaisie ctrl)
    {
        // Modèle MVC
        this.oCtrl = ctrl;

        this.setTitle("Saisie des ouvrages");
        this.setLocation(20, 20);
        
        this.oPanelSaisie = new PanelSaisie(oCtrl);
        this.add(this.oPanelSaisie);
        
        this.pack();
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible(true);
    }
    
    // Mise à jour du PanelSaisie
    public void maj()
    {
        this.oPanelSaisie.maj();
    }
}
