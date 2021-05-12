/*
 * PanelSaisie.java
 * panneau
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout  ;
import java.awt.FlowLayout  ;
import java.awt.Font        ;
import java.awt.Color       ;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent   ;
import java.awt.event.FocusListener ;
import java.awt.event.FocusEvent    ;

public class PanelSaisie extends JPanel implements ActionListener,
												   FocusListener
{
	
	// Attributs
	private ControleurSaisie   ctrl;

	private JComboBox<String>  cbDessinateur;
	private JComboBox<String>  cbScenariste;
	private JComboBox<String>  cbSerie;
	private JComboBox<String>  cbEditeur;

	private JTextField         txtTitre;
	private JTextField         txtTome;

	private JButton            btnAjouter;
	
	/*
	 * Initialise les composant ComboBox
	 * @param auteurs, editeurs, series
	 *          listes d'auteurs, d'editeurs et de series
	 */
	public void initComposantComboBox(String[] auteurs, String[] editeurs,  
									  String[] series)
	{
		this.cbDessinateur  = new JComboBox<String>(auteurs );
		this.cbScenariste   = new JComboBox<String>(auteurs );
		this.cbSerie        = new JComboBox<String>(series  );
		this.cbEditeur      = new JComboBox<String>(editeurs);
	}
	
	/*
	 * Initialise les composant TextField
	 * @param column
	 *          Correspond à la taille en largeur des textField
	 */
	public void initComposantTextField(int textFieldColumn)
	{
		this.txtTitre       = new JTextField(textFieldColumn);
		this.txtTome        = new JTextField(textFieldColumn);
	}
	
	/*
	 * Ajoute les labels à un panel
	 * @param toAdd
	 *          JPanel qui recevra les JLabel
	 */
	public void addFormulaireComposantLabel(JPanel panelToAdd)
	{
		panelToAdd.add( new JLabel(       "Titre* : " , JLabel.RIGHT ));
		panelToAdd.add( new JLabel(     "Editeur* : " , JLabel.RIGHT ));
		panelToAdd.add( new JLabel( "Dessinateur* : " , JLabel.RIGHT ));
		panelToAdd.add( new JLabel(  "Scénariste* : " , JLabel.RIGHT ));
		panelToAdd.add( new JLabel(         "Tome : " , JLabel.RIGHT ));
		panelToAdd.add( new JLabel(        "Série : " , JLabel.RIGHT ));
	}
	
	// Constructeur
	/*
	 * @param ctrl
	 *          ControleurSaisie
	 */
	public PanelSaisie(ControleurSaisie ctrl)
	{
		this.ctrl = ctrl;

		// Variables locales
		JPanel panelNord  ;
		JPanel panelCentre;
		JPanel panelTmp   ;
		JPanel panelTmp2  ;

		JLabel lblTemp    ;

		// Réglage du layoutManager
		this.setLayout( new BorderLayout(1, 4) );

		/*-----------------------------*/
		/*   Création des composants   */
		/*-----------------------------*/

		initComposantComboBox (this.ctrl.getAuteur(), this.ctrl.getEditeur(),
							   this.ctrl.getSerie());

		initComposantTextField(20);

		this.btnAjouter = new JButton("Ajouter la BD");

		panelNord       = new JPanel( new BorderLayout() );
		lblTemp         = new JLabel("* Champs obligatoires", JLabel.LEFT);

		lblTemp.setFont      (new Font ("Serif", Font.BOLD, 10));
		lblTemp.setForeground(Color.RED);

		panelCentre     = new JPanel( new BorderLayout()        );
		panelTmp        = new JPanel( new GridLayout(6, 1, 1, 2));

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
		panelTmp2 .add( this.txtTitre      );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.cbEditeur     );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.cbDessinateur );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.cbScenariste  );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.txtTome       );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.cbSerie        );
		panelTmp  .add( panelTmp2           );

		panelCentre.add ( panelTmp, BorderLayout.CENTER );

		this.add( panelNord       , BorderLayout.NORTH  );
		this.add( panelCentre     , BorderLayout.CENTER );
		this.add( this.btnAjouter , BorderLayout.SOUTH  );

		/*-----------------------------*/
		/*  Activation des composants  */
		/*-----------------------------*/
		this.btnAjouter.addActionListener(this);
		this.txtTitre  .addFocusListener (this);
		this.txtTome   .addFocusListener (this);
	}
    
	/*
	 * Mise à jour du Panel
	 * Met à jour l'affichage du panel
	 */
	public void maj()
	{
		this.txtTitre.setText("");
		this.txtTome .setText("");
	}
	
	/*
	 * Affiche "Champs obligatoire" en rouge dans le TextField txtTitre
	 */
	public void champObligatoire()
	{
		this.txtTitre.setForeground(Color.RED);
		this.txtTitre.setText("Champs obligatoire");
	}
	
	/*
	 * définition d'actionPerformed
	 * @param e
	 *          action effectué
	 */
	public void actionPerformed(ActionEvent e)
	{
		if ( this.txtTitre.getForeground() == Color.RED )return;

		String  sTitre       =         this.txtTitre     .getText();
		String  sEditeur     = (String)this.cbEditeur    .getSelectedItem();
		String  sSerie       = (String)this.cbSerie      .getSelectedItem();
		String  sScenariste  = (String)this.cbScenariste .getSelectedItem();
		String  sDessinateur = (String)this.cbDessinateur.getSelectedItem();

		Integer iTome;

		if ( !this.txtTome.getText().equals("") && this.txtTome.getText()
												   .matches("^[0-9]*$") )
		{
			iTome = Integer.parseInt(this.txtTome.getText());
		}
		else
		{
			this.txtTome.setForeground(Color.RED);
			this.txtTome.setText("Valeur impossible");
			iTome = null;
		}

		this.ctrl.ajouterOuvrage( sTitre, sEditeur, sSerie, sScenariste,
								  sDessinateur, iTome );
	}

	/*
	 * si la couleur de police de txtTitre est rouge et que l'on clique sur txtTitre,
	 * la couleur de police devient noir et txtTitre contient ""
	 */
	public void focusGained(FocusEvent e)
	{
		((JTextField)e.getSource()).setForeground(Color.BLACK);
		((JTextField)e.getSource()).setText("");
	}
	
	/*
	 * on défini cette méthode car on implémente focusListener mais elle est inutile
	 */
	public void focusLost(FocusEvent e){}
}
