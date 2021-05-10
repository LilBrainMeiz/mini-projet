import javax.swing.*;


public class MetierEtat extends JFrame
{
	private ControleurEtat  ctrl;

	private PanelEtat  panelEtat;

	public MetierEtat()
	{
		this.setTitle( "Etats" );
		this.setLocation( 30, 30 );
		this.setSize( 400, 200 );

		this.panelEtat  = new PanelEtat( this.ctrl );

        this.add( this.panelEtat );


		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );

	}
}
