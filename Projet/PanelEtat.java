import javax.swing.*;

import java.awt.GridLayout;

public class PanelEtat extends JPanel
{
	private ControleurEtat ctrl;

	private JButton btnTous;
	private JButton btnList;

	private JTextField txtAuteur;

	public PanelEtat( ControleurEtat ctrl )
	{
		this.setLayout( new GridLayout( 4, 1 ) );

		this.btnTous = new JButton( "Afficher tous les ouvrages"  );
		this.btnList = new JButton( "Lister par Editeur et Série" );


		JPanel panelTmp = new JPanel();
		this.txtAuteur = new JTextField( 20 );



		this.add( new JLabel( "Que souhaitez vous faire ?" ) );
		this.add( this.btnTous );
		this.add( this.btnList );

		panelTmp.add( new JLabel( "Afficher les BD de" ) );
		panelTmp.add( this.txtAuteur );

		this.add( panelTmp );
	}
}
