import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class IhmCUI
{
	private ControleurEtat oCtrl;

	private Scanner        oEntree;

	public IhmCUI(ControleurEtat ctrl)
	{
		this.oCtrl = ctrl;
		this.oEntree = new Scanner(System.in);
	}

	/**
	 * Affiche le menu de choix de l'application.
	 */
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

	/**
	 * Affiche tous les ouvrages triés dans l'ordre naturel.
	 */
	public void afficherTriNaturel()
	{
		System.out.println(this.oCtrl.getEnTete());

		List<Ouvrage> listeTriee = this.oCtrl.getListeTrieeParOrdreNaturel();

		listeTriee.forEach(oOuvrage -> System.out.println(oOuvrage));
	}

	/**
	 * Affiche tous les ouvrages d'un auteur en particulier.
	 */
	public void afficherOuvrageDe()
    {
		System.out.print( "Saisissez le nom de l'auteur que vous souhaitez : " );
		String sNom = "";

		try
		{
			Scanner oEntree = new Scanner(System.in);
			
			sNom = oEntree.nextLine();
			System.out.println( sNom );

		}catch(Exception e){e.printStackTrace();}

		List<Ouvrage> ensOuvragesAuteur = this.oCtrl.getOuvragesDe( sNom );

		System.out.println( this.oCtrl.getEnTete() );

		ensOuvragesAuteur.forEach(oOuvrage -> System.out.println(oOuvrage));
	}

	/**
	 * Affiche tous les ouvrages triés par éditeurs puis par séries.
	 */
	public void afficherListeGroupee()
	{
		
		List<Ouvrage> ensOuvragesTries = this.oCtrl.
					                  getListeTrieeParEditeurEtSerie();

		System.out.println( this.oCtrl.getEnTete() );
		
		ensOuvragesTries.forEach(oOuvrage -> System.out.println(oOuvrage));
	}
}
