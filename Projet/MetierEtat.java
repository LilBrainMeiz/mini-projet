import javax.swing.*;
import java.awt.BorderLayout;


public class FrameEtat extends JFrame
{
	private Controleur  ctrl;

	private PanelEtat  panelEtat;

	public FrameEtat( Controleur  ctrl )
	{


		this.ctrl =  ctrl;

		this.setTitle( "Etats" );
		this.setLocation( 30, 30 );
		this.setSize( 400, 200 );

		this.panelEtat  = new PanelEtat( this.ctrl );

        this.add( this.panelEtat );


		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );

	}
}
