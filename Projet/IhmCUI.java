import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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

		List<Ouvrage> listeTriee = this.ctrl.getListeTrieeParOrdreNaturel();

		listeTriee.forEach(oOuvrage -> System.out.println(oOuvrage));
	}

	public void afficherOuvrageDe()
    {
		System.out.print( "Saisissez le nom de l'auteur que vous souhaitez : " );
		String sNom = "";

		try
		{
			Scanner in = new Scanner(System.in);
			
			sNom = in.nextLine();
			System.out.println( sNom );

		}catch(Exception e){e.printStackTrace();}

		List<Ouvrage> tmp = this.ctrl.getOuvragesDe( sNom );

		System.out.println( this.ctrl.getEnTete() );

		for (Ouvrage o : tmp) System.out.println( o );
	}

	public void afficherListeGroupee()
	{
		
		List<Ouvrage> ouvragesTries = this.ctrl.
					                  getListeTrieeParEditeurEtSerie();

		System.out.println( this.ctrl.getEnTete() );
		
		ouvragesTries.forEach(oOuvrage -> System.out.println(oOuvrage));
	}
}
