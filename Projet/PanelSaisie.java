import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout  ;
import java.awt.FlowLayout  ;
import java.awt.Font        ;
import java.awt.Color       ;

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
        
        this.txtTitre       = new JTextField(20);
        this.txtEditeur     = new JTextField(20);
        this.txtDessinateur = new JTextField(20);
        this.txtScenariste  = new JTextField(20);
        this.txtTome        = new JTextField(20);
        this.txtSerie       = new JTextField(20);

        this.btnAjouter     = new JButton("Ajouter la BD");

        this.txtTitre      .setHorizontalAlignment(JTextField.RIGHT);
        this.txtEditeur    .setHorizontalAlignment(JTextField.RIGHT);
        this.txtDessinateur.setHorizontalAlignment(JTextField.RIGHT);
        this.txtScenariste .setHorizontalAlignment(JTextField.RIGHT);
        this.txtTome       .setHorizontalAlignment(JTextField.RIGHT);
        this.txtSerie      .setHorizontalAlignment(JTextField.RIGHT);

        panelNord = new JPanel( new BorderLayout() );
        lblTemp   = new JLabel("* Champs obligatoires", JLabel.LEFT);
        lblTemp.setFont(new Font ("Serif", Font.BOLD, 10));
        lblTemp.setForeground(Color.RED);
        
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
        txtTitre      .setText("");
        txtEditeur    .setText("");
        txtDessinateur.setText("");
        txtScenariste .setText("");
        txtTome       .setText("");
        txtSerie      .setText("");
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String titre       = this.txtTitre      .getText();
        String editeur     = this.txtEditeur    .getText();
        String serie       = this.txtSerie      .getText();
        String scenariste  = this.txtScenariste .getText();
        String dessinateur = this.txtDessinateur.getText();
        
        Integer tome = Integer.parseInt(this.txtTome.getText());
        
        this.ctrl.ajouterOuvrage( titre, editeur, serie, scenariste, dessinateur, tome );
    }
}
