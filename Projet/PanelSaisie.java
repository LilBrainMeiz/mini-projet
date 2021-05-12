/**
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
	/**
	 * Controleur de l'application Saisie
	 * @see PanelSaisie#actionPerformed(ActionEvent)
	 * @see PanelSaisie#PanelSaisie(ControleurSaisie)
	 */
	private ControleurSaisie   oCtrl;
	
	/**
	 * Liste des dessinateurs.
	 * @see PanelSaisie#initComposantComboBox(String[], String[], String[])
	 * @see PanelSaisie#PanelSaisie(ControleurSaisie)
	 * @see PanelSaisie#actionPerformed(ActionEvent)
	 */
	private JComboBox<String>  cmbListDessinateur;

	/**
	 * Liste des scénaristes.
	 * @see PanelSaisie#initComposantComboBox(String[], String[], String[])
	 * @see PanelSaisie#PanelSaisie(ControleurSaisie)
	 * @see PanelSaisie#actionPerformed(ActionEvent)
	 */
	private JComboBox<String>  cmbListScenariste;

	/**
	 * Liste des série.
	 * @see PanelSaisie#initComposantComboBox(String[], String[], String[])
	 * @see PanelSaisie#PanelSaisie(ControleurSaisie)
	 * @see PanelSaisie#actionPerformed(ActionEvent)
	 */
	private JComboBox<String>  cmbListSerie;

	/**
	 * Liste des éditeurs.
	 * @see PanelSaisie#initComposantComboBox(String[], String[], String[])
	 * @see PanelSaisie#PanelSaisie(ControleurSaisie)
	 * @see PanelSaisie#actionPerformed(ActionEvent)
	 */
	private JComboBox<String>  cmbListEditeur;

	/**
	 * Champs de saisie du titre
	 * @see PanelSaisie#PanelSaisie(ControleurSaisie)
	 * @see PanelSaisie#initComposantTextField()
	 * @see PanelSaisie#actionPerformed(ActionEvent)
	 * @see PanelSaisie#champObligatoire()
	 */
	private JTextField         txtTitre;

	/**
	 * Champs de saisie du n° de tom
	 * @see PanelSaisie#PanelSaisie(ControleurSaisie)
	 * @see PanelSaisie#initComposantTextField()
	 * @see PanelSaisie#actionPerformed(ActionEvent)
	 * @see PanelSaisie#champObligatoire()
	 */
	private JTextField         txtTome;

	/**
	 * Champs de saisie du titre
	 * @see PanelSaisie#PanelSaisie(ControleurSaisie)
	 */
	private JButton            btnAjouter;
	
	/**
	 * Initialise les composant ComboBox
	 * @param auteurs, editeurs, series
	 *          listes d'auteurs, d'editeurs et de series
	 * @see PanelSaisie#cmbListDessinateur
	 * @see PanelSaisie#cmbListScenariste
	 * @see PanelSaisie#cmbListSerie
	 * @see PanelSaisie#cmbListEditeur
	 */

	public void initComposantComboBox(String[] auteurs, String[] editeurs, String[] series)
	{
		this.cmbListDessinateur  = new JComboBox<String>(auteurs );
		this.cmbListScenariste   = new JComboBox<String>(auteurs );
		this.cmbListSerie        = new JComboBox<String>(series  );
		this.cmbListEditeur      = new JComboBox<String>(editeurs);

		this.cmbListDessinateur.setMaximumRowCount(10);
		this.cmbListScenariste .setMaximumRowCount(10);
		this.cmbListSerie      .setMaximumRowCount(10);
		this.cmbListEditeur    .setMaximumRowCount(10);
	}
	
	/**
	 * Initialise les composant TextField
	 * @param column Correspond à la taille en largeur des textField
	 * @see PanelSaisie#txtTitre
	 * @see PanelSaisie#txtTome
	 */
	public void initComposantTextField()
	{
		this.txtTitre       = new JTextField(20);
		this.txtTome        = new JTextField( 5);
	}
	
	/**
	 * Ajoute les labels à un panel
	 * @param JPanel qui recevra les JLabel
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
	/**
	 * Constructeur de PanelSaisie.
	 * @param ctrl
	 *          ControleurSaisie
	 *
	 * @see PanelSaisie#oCtrl
	 * @see PanelSaisie#cmbListDessinateur
	 * @see PanelSaisie#cmbListScenariste
	 * @see PanelSaisie#cmbListSerie
	 * @see PanelSaisie#cmbListEditeur
	 *
	 * @see PanelSaisie#txtTitre
	 * @see PanelSaisie#txtTome
	 *
	 * @see PanelSaisie#btnAjouter
	 *
	 * @see PanelSaisie#initComposantComboBox( String[], String[], String[] )
	 */
	public PanelSaisie(ControleurSaisie ctrl)
	{
		this.oCtrl = ctrl;

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

		this.initComposantComboBox (this.oCtrl.getAuteurs(), this.oCtrl.getEditeurs(),
							   this.oCtrl.getSeries());

		this.initComposantTextField();

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

		this.addFormulaireComposantLabel(panelTmp);

		panelCentre.add( panelTmp, BorderLayout.WEST );

		panelTmp    = new JPanel( new GridLayout(6, 1, 1, 2));

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.txtTitre      );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.cmbListEditeur     );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.cmbListDessinateur );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.cmbListScenariste  );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.txtTome       );
		panelTmp  .add( panelTmp2          );

		panelTmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTmp2 .add( this.cmbListSerie        );
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
	
	/**
	 * Affiche "Champs obligatoire" en rouge dans le TextField txtTitre
	 */
	public void champObligatoire()
	{
		this.txtTitre.setForeground(Color.RED);
		this.txtTitre.setText("Champs obligatoire");
	}
	
	/**
	 * définition d'actionPerformed
	 * @see PanelSaisie#txtTitre
	 * @see PanelSaisie#cmbListEditeur
	 * @see PanelSaisie#cmbListSerie
	 * @see PanelSaisie#cmbListScenariste
	 * @see PanelSaisie#cmbListDessinateur
	 * @see PanelSaisie#txtTome
	 * @see PanelSaisie#oCtrl
	 * @param e Objet sur lequel l'action est effectué action effectué
	 */
	public void actionPerformed(ActionEvent e)
	{
		if ( this.txtTitre.getForeground() == Color.RED )return;

		String  sTitre       =         this.txtTitre          .getText        ();
		String  sEditeur     = (String)this.cmbListEditeur    .getSelectedItem();
		String  sSerie       = (String)this.cmbListSerie      .getSelectedItem();
		String  sScenariste  = (String)this.cmbListScenariste .getSelectedItem();
		String  sDessinateur = (String)this.cmbListDessinateur.getSelectedItem();

		Integer iTome;

		if ( !this.txtTome.getText().equals("") && this.txtTome.getText().matches("^[0-9]*$") )
		{
			iTome = Integer.parseInt(this.txtTome.getText());
		}
		else
		{
			if ( !this.txtTome.getText().equals("") )
			{
				this.txtTome.setForeground(Color.RED);
				this.txtTome.setText("Erreur");
			}
			iTome = null;
		}

		this.oCtrl.ajouterOuvrage( sTitre, sEditeur, sSerie, sScenariste, sDessinateur, iTome );
	}

	/**
	 * @param e Objet sur lequel nous sommes Focus
	 * si la couleur de police du TextField est rouge et que l'on clique sur celui-ci,
	 * la couleur de police devient noir et txtTitre contient ""
	 */
	public void focusGained(FocusEvent e)
	{
		((JTextField)e.getSource()).setForeground(Color.BLACK);
		((JTextField)e.getSource()).setText("");
	}
	
	/**
	 * on défini cette méthode car on implémente focusListener mais on ne l'utilise pas
	 */
	public void focusLost(FocusEvent e){}
}
