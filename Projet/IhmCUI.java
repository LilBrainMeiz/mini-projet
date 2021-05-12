import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import java.util.stream.Collectors;

public class IhmCUI
{
	private ControleurEtat oCtrl;

	private Scanner        oEntree;

	public IhmCUI(ControleurEtat ctrl)
	{
		this.oCtrl = ctrl;
		this.oEntree = new Scanner(System.in);
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
		System.out.println(this.oCtrl.getEnTete());

		List<Ouvrage> listeTriee = this.oCtrl.getListeTrieeParOrdreNaturel();

		listeTriee.forEach(oOuvrage -> System.out.println(oOuvrage));
	}

	public void afficherOuvrageDe()
    {
		System.out.print( "Saisissez le nom de l'auteur que vous souhaitez : " );

		String sNom = this.oCtrl.getNomAuteur();

		List<Ouvrage> tmp = this.oCtrl.getOuvragesDe( sNom );

		System.out.println( this.oCtrl.getEnTete() );

		for (Ouvrage o : tmp) System.out.println( o );
	}

	public void afficherListeGroupee()
	{
		
		List<Ouvrage> ouvragesTries = this.oCtrl.
					                  getListeTrieeParEditeurEtSerie();

		System.out.println( this.oCtrl.getEnTete() );
		
		ouvragesTries.forEach(oOuvrage -> System.out.println(oOuvrage));
	}
}
