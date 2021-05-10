import javax.swing.*;

public class FrameEtat extends JFrame
{
	private PanelEtat  panelEtat;

	public FrameEtat( ControleurEtat  ctrl )
	{
		this.setTitle( "Etats" );
		this.setLocation( 30, 30 );

		this.panelEtat  = new PanelEtat( ctrl );

        	this.add( this.panelEtat );

		this.pack();
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       	 	this.setVisible( true );
	}

	public void maj()
    	{
        	this.panelEtat.maj();
    	}
}
