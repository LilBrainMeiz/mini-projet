import javax.swing.*;

public class PanelSaisie
{
    private ControleurSaisie ctrl;
    
    private JTextField txtTitre;
    private JTextField txtEditeur;
    private JTextField txtDessinateur;
    private JTextField txtScenariste;
    private JTextField txtTome;
    private JTextField txtTome;
    private JTextField txtSerie;
    
    private JButton btnAjouter;
    
    public PanelSaisie(ControleurSaisie ctrl)
    {
        this.ctrl = ctrl;
        
        /*-----------------------------*/
        /*   Création des composants   */
        /*-----------------------------*/
        
        txtTitre       = new JTextField(14);
        txtEditeur     = new JTextField(14);
        txtDessinateur = new JTextField(14);
        txtScenariste  = new JTextField(14);
        txtTome        = new JTextField(14);
        txtTome        = new JTextField(14);
        txtSerie       = new JTextField(14);
        
        btnAjouter     = new JButton("Ajouter la BD");
        
        
    }
}
