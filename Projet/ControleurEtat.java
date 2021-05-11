import java.util.Scanner;
import java.util.List;

public class ControleurEtat
{
	private IhmCUI     ihm;
	private MetierEtat metier;
    private Scanner    scInput;

	public ControleurEtat()
	{
		this.ihm    = new IhmCUI(this);
		this.metier = new MetierEtat();

        scInput = new Scanner(System.in);

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
			action = scInput.nextInt();

			this.metier.synchroniserOuvrages();

			switch( action )
			{
				case 1  -> this.ihm.afficherTriNaturel();
				case 2  -> this.ihm.afficherListeGroupee();
				case 3  -> this.ihm.afficherTriNaturel();
			}			
		}while ( action != 4 );
	}


	public static void main(String[] args)
	{
		new ControleurEtat();
	}
}
