import javax.swing.*;
import java.awt.BorderLayout;


public class FrameEtat extends JFrame
{
	private PanelEtat  panelEtat;

	public FrameEtat( ControleurEtat  ctrl )
	{
		this.setTitle( "Etats" );
		this.setLocation( 30, 30 );
		this.setSize( 400, 200 );

		this.panelEtat  = new PanelEtat( ctrl );

        this.add( this.panelEtat );


		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
	}
}
