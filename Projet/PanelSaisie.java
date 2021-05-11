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
    
    private JComboBox<String>  cbDessinateur;
    private JComboBox<String>  cbScenariste;
    private JComboBox<String>  cbSerie;
    private JComboBox<String>  cbEditeur;

    private JTextField txtTitre;
    private JTextField txtEditeur;
    private JTextField txtTome;
    
    private JButton btnAjouter;
    
    public void initComposantComboBox(String[] auteurs, String[] editeurs,  
                                      String[] series)
    {
        this.cbDessinateur  = new JComboBox<String>(auteurs);
        this.cbScenariste   = new JComboBox<String>(auteurs);
        this.cbSerie        = new JComboBox<String>(series );
        this.cbEditeur      = new JComboBox<String>(editeurs);
    }

    public void initComposantTextField(int column)
    {
        this.txtTitre       = new JTextField(column);
        this.txtEditeur     = new JTextField(column);
        this.txtTome        = new JTextField(column);
    }

    public void setComposantTextFieldAlignement(int alignement)
    {
        this.txtTitre      .setHorizontalAlignment(alignement);
        this.txtEditeur    .setHorizontalAlignment(alignement);
        this.txtTome       .setHorizontalAlignment(alignement);
    }

    public void addFormulaireComposantLabel(JPanel toAdd)
    {
        toAdd.add( new JLabel( "Titre* : "      , JLabel.RIGHT ));
        toAdd.add( new JLabel( "Editeur* : "    , JLabel.RIGHT ));
        toAdd.add( new JLabel( "Dessinateur* : ", JLabel.RIGHT ));
        toAdd.add( new JLabel( "Scénariste* : " , JLabel.RIGHT ));
        toAdd.add( new JLabel( "Tome : "        , JLabel.RIGHT ));
        toAdd.add( new JLabel( "Série : "       , JLabel.RIGHT ));
    }

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

        initComposantComboBox (this.ctrl.getAuteur(), this.ctrl.getEditeur(),
                               this.ctrl.getSerie());

        initComposantTextField(20);

        this.btnAjouter     = new JButton("Ajouter la BD");

        setComposantTextFieldAlignement(JTextField.RIGHT);

        panelNord = new JPanel( new BorderLayout() );
        lblTemp   = new JLabel("* Champs obligatoires", JLabel.LEFT);
        lblTemp.setFont(new Font ("Serif", Font.BOLD, 10));
        lblTemp.setForeground(Color.RED);
        
        panelCentre = new JPanel( new BorderLayout()        );
        panelTmp    = new JPanel( new GridLayout(6, 1, 1, 2));
        
        /*-----------------------------*/
        /*     Ajout des composants    */
        /*-----------------------------*/
        
        panelNord.add( new JLabel ( new ImageIcon ( "./bedetheque.png" ))
                                  , BorderLayout.CENTER);
        panelNord.add( lblTemp    , BorderLayout.SOUTH );
        
        addFormulaireComposantLabel(panelTmp);
    
        panelCentre.add( panelTmp, BorderLayout.WEST );

        panelTmp    = new JPanel( new GridLayout(6, 1, 1, 2));

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.txtTitre      );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.cbEditeur     );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.cbDessinateur );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.cbScenariste );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.txtTome        );
        panelTmp.add ( panelTmp2 );

        panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTmp2.add( this.cbSerie       );
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
        this.txtTome       .setText("");
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String sTitre       = this.txtTitre     .getText();
        String sEditeur     = (String)this.cbEditeur    .getSelectedItem();
        String sSerie       = (String)this.cbSerie      .getSelectedItem();
        String sScenariste  = (String)this.cbScenariste .getSelectedItem();
        String sDessinateur = (String)this.cbDessinateur.getSelectedItem();
        
        Integer iTome;

        if ( this.txtTome.getText().matches("^[0-9]*$") )
            iTome = Integer.parseInt(this.txtTome.getText());
        else
            iTome = null;
            
        this.ctrl.ajouterOuvrage( sTitre, sEditeur, sSerie, sScenariste,
                                  sDessinateur, iTome );
    }
}
