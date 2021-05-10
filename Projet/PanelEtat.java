import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout  ;
import java.awt.Dimension   ;

public class PanelEtat extends JPanel
{
	private ControleurEtat ctrl;

	private JButton btnTous;
	private JButton btnList;

	private JTextField txtAuteur;

	public PanelEtat( ControleurEtat ctrl )
	{
		this.ctrl = ctrl;

		// Variables locales
		JPanel panelTmp;
		JPanel panelCentre;
		JPanel panelNord  ;

		// gestion du layoutManager
		this.setLayout( new BorderLayout() );

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.btnTous = new JButton( "Afficher tous les ouvrages"  );
		this.btnList = new JButton( "Lister par Editeur et Série" );

		this.btnTous.setPreferredSize(new Dimension (250, 30));
		this.btnList.setPreferredSize(new Dimension (250, 30));

		this.txtAuteur = new JTextField( 20 );

		panelTmp    = new JPanel();
		panelNord   = new JPanel();
		panelCentre = new JPanel( new GridLayout( 4, 1 )  );
		/*-------------------------*/
		/*   Ajout des composants  */
		/*-------------------------*/

		panelNord.add( new JLabel(new ImageIcon("./bedetheque.png")));

		panelCentre.add( new JLabel( "  Que souhaitez vous faire ?" ) );

		panelTmp.add( this.btnTous );
		panelCentre.add( panelTmp );

		panelTmp    = new JPanel();
		panelTmp.add( this.btnList );
		panelCentre.add( panelTmp );

		panelTmp = new JPanel();
		panelTmp.add( new JLabel( "Afficher les BD de" ) );
		panelTmp.add( this.txtAuteur );

		panelCentre.add( panelTmp );
		
		this.add ( panelNord  , BorderLayout.NORTH  );
		this.add ( panelCentre, BorderLayout.CENTER );
	}
}
