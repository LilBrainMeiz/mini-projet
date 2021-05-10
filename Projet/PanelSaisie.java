import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout  ;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent   ;

public class PanelSaisie extends JPanel implements ActionListener
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
        JPanel panelTmp  ;
        JPanel panelTmp2 ;
        
        JLabel lblTemp     ;
        
        // Réglage du layoutManager
        this.setLayout( new BorderLayout(1, 4) );
        
        /*-----------------------------*/
        /*   Création des composants   */
        /*-----------------------------*/
        
        txtTitre       = new JTextField(20);
        txtEditeur     = new JTextField(20);
        txtDessinateur = new JTextField(20);
        txtScenariste  = new JTextField(20);
        txtTome        = new JTextField(20);
        txtSerie       = new JTextField(20);
        
        btnAjouter     = new JButton("Ajouter la BD");
        
        txtTitre      .setHorizontalAlignment(JTextField.RIGHT);
        txtEditeur    .setHorizontalAlignment(JTextField.RIGHT);
        txtDessinateur.setHorizontalAlignment(JTextField.RIGHT);
        txtScenariste .setHorizontalAlignment(JTextField.RIGHT);
        txtTome       .setHorizontalAlignment(JTextField.RIGHT);
        txtSerie      .setHorizontalAlignment(JTextField.RIGHT);

        panelNord = new JPanel( new BorderLayout() );
        lblTemp   = new JLabel("* Champs obligatoires", JLabel.LEFT); // lblTemp à revoir pour la taille
        
        panelCentre = new JPanel( new BorderLayout() );
        panelTmp    = new JPanel( new GridLayout(6, 1, 1, 2));
        
        /*-----------------------------*/
        /*     Ajout des composants    */
        /*-----------------------------*/
        
        panelNord.add( new JLabel ( new ImageIcon ( "./bedetheque.png" )), BorderLayout.CENTER);
        panelNord.add( lblTemp                                         , BorderLayout.SOUTH );
        
        panelTmp.add( new JLabel( "Titre* : "      , JLabel.RIGHT ));
        panelTmp.add( new JLabel( "Editeur* : "    , JLabel.RIGHT ));
        panelTmp.add( new JLabel( "Dessinateur* : ", JLabel.RIGHT ));
        panelTmp.add( new JLabel( "Scénariste* : " , JLabel.RIGHT ));
        panelTmp.add( new JLabel( "Tome : "        , JLabel.RIGHT ));
        panelTmp.add( new JLabel( "Série : "       , JLabel.RIGHT ));
    
        panelCentre.add( panelTmp, BorderLayout.WEST );

        panelTmp    = new JPanel( new GridLayout(6, 1, 1, 2));

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.txtTitre       );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.txtEditeur     );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.txtDessinateur );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.txtScenariste  );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.txtTome        );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.txtSerie       );
        panelTmp.add ( panelTmp2 );
        
        panelCentre.add ( panelTmp, BorderLayout.CENTER );
        
        this.add( panelNord      , BorderLayout.NORTH  );
        this.add( panelCentre    , BorderLayout.CENTER );
        this.add( this.btnAjouter, BorderLayout.SOUTH  );
        
        /*-----------------------------*/
        /*  Activation des composants  */
        /*-----------------------------*/
        this.btnAjouter.addActionListener(this);
    }
    
    public void maj()
    {
        this.txtTitre      .setText("");
        this.txtEditeur    .setText("");
        this.txtDessinateur.setText("");
        this.txtScenariste .setText("");
        this.txtTome       .setText("");
        this.txtSerie      .setText("");
    }
    
    public void actionPerformed(ActionEvent e){}
}
