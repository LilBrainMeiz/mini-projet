import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout  ;

public class PanelSaisie extends JPanel
{
    private ControleurSaisie ctrl;
    
    private JTextField txtTitre;
    private JTextField txtEditeur;
    private JTextField txtDessinateur;
    private JTextField txtScenariste;
    private JTextField txtTome;
    private JTextField txtSerie;
    
    private JButton btnAjouter;
    
    public PanelSaisie(ControleurSaisie ctrl)
    {
        this.ctrl = ctrl;
        
        // Variables locales
        JPanel panelNord  ;
        JPanel panelCentre;
        JPanel panelTmp   ;
        
        JLabel lblTmp     ;
        
        // Réglage du layoutManager
        this.setLayout( new BorderLayout() );
        
        /*-----------------------------*/
        /*   Création des composants   */
        /*-----------------------------*/
        
        txtTitre       = new JTextField(14);
        txtEditeur     = new JTextField(14);
        txtDessinateur = new JTextField(14);
        txtScenariste  = new JTextField(14);
        txtTome        = new JTextField(14);
        txtSerie       = new JTextField(14);
        
        btnAjouter     = new JButton("Ajouter la BD");
        
        txtTitre      .setHorizontalAlignment(JTextField.RIGHT);
        txtEditeur    .setHorizontalAlignment(JTextField.RIGHT);
        txtDessinateur.setHorizontalAlignment(JTextField.RIGHT);
        txtScenariste .setHorizontalAlignment(JTextField.RIGHT);
        txtTome       .setHorizontalAlignment(JTextField.RIGHT);
        txtSerie      .setHorizontalAlignment(JTextField.RIGHT);

        panelNord = new JPanel( new BorderLayout() );
        lblTemp   = new JLabel("* Champs obligatoires"); // lblTemp à revoir pour la taille
        lblTemp.setHorizontalTextPosition(JLabel.LEFT);
        
        panelCentre = new JPanel( new GridLayout( 6, 1 ));
        panelTmp    = new JPanel();
        
        /*-----------------------------*/
        /*     Ajout des composants    */
        /*-----------------------------*/
        
        panelNord.add( new JLabel ( new ImageIcon ( "bedetheque.png" )), BorderLayout.CENTER);
        panelNord.add( lblTemp                                         , BorderLayout.SOUTH );
        
        panelTmp.add( new JLabel( "Titre* : "      , JLabel.RIGHT ));
        panelTmp.add( this.txtTitre );
        panelCentre.add( panelTmp );
        
        panelTmp = new JPanel();
        panelTmp.add( new JLabel( "Editeur* : "    , JLabel.RIGHT ));
        panelTmp.add( this.txtEditeur );
        panelCentre.add( panelTmp );
        
        panelTmp = new JPanel();
        panelTmp.add( new JLabel( "Dessinateur* : ", JLabel.RIGHT ));
        panelTmp.add( this.txtDessinateur );
        panelCentre.add( panelTmp );
        
        panelTmp = new JPanel();
        panelTmp.add( new JLabel( "Scénariste* : " , JLabel.RIGHT ));
        panelTmp.add( this.txtScenariste );
        panelCentre.add( panelTmp );
        
        panelTmp = new JPanel();
        panelTmp.add( new JLabel( "Tome : "        , JLabel.RIGHT ));
        panelTmp.add( this.txtTome );
        panelCentre.add( panelTmp );
        
        panelTmp = new JPanel();
        panelTmp.add( new JLabel( "Série : "       , JLabel.RIGHT ));
        panelTmp.add( this.txtSerie );
        panelCentre.add( panelTmp );
        
        panelTmp = new JPanel();
        
        this.add( panelNord  , BorderLayout.NORTH );
        this.add( panelCentre, BorderLayout.CENTER );
    }
}
