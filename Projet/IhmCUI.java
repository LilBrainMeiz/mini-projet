import java.util.Scanner;

import java.util.List;
import java.util.Collections;


public class IhmCUI
{
	private ControleurEtat ctrl;

	private Scanner        scInput;

	public IhmCUI(ControleurEtat ctrl)
	{
		this.ctrl = ctrl;
		this.scInput = new Scanner(System.in);
	}

	public void afficherMenu()
	{
		System.out.println( "Que souhaitez vous faire ?"                                    + "\n" +
							"   1.Afficher tous les ouvrages"                               + "\n" +
							"   2.Afficher tous les ouvrages triée par Editeurs et Séries." + "\n" +
							"   3.Afficher tous les ouvrages de [nom]"                      + "\n" +
							"   4.Quitter"                                                  + "\n"
						  );

		System.out.print( "Saisissez le numero puis son eventuel parametre : " );
	}

	public void afficherTriNaturel()
	{
		System.out.println(this.ctrl.getEnTete());

		List<Ouvrage> tmp = this.ctrl.getOuvrages();
		Collections.sort(tmp);

		for ( Ouvrage o : tmp )
			System.out.println(o);
	}
}
