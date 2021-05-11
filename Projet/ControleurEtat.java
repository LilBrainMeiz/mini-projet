import iut.algo.Clavier;
import java.util.List;

public class ControleurEtat
{
	private IhmCUI     ihm;
	private MetierEtat metier;

	public ControleurEtat()
	{
		this.ihm    = new IhmCUI(this);
		this.metier = new MetierEtat();

		this.lancerEtat();
	}

	public String        getEnTete  (){ return this.metier.enTete     (); }
	public List<Ouvrage> getOuvrages(){ return this.metier.getOuvrages(); }

	private void lancerEtat()
	{
		int action;

		do
		{
			this.ihm.afficherMenu();
			action = Clavier.lire_int();

			switch( action )
			{
				case 1  -> this.ihm.afficherTriNaturel();
				case 2  -> this.ihm.afficherTriNaturel();
				case 3  -> this.ihm.afficherTriNaturel();
			}
			
		}while ( action != 4 );
	}


	public static void main(String[] args)
	{
		new ControleurEtat();
	}
}
