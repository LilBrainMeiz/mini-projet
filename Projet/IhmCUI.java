/**
 * ControleurSaisie.java
 * controleur
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */
import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class IhmCUI
{
	/**
	 * Accès aux controleur de l'ihm qui accède au métier
	 * @see IhmCUI#IhmCUI(ControleurEtat)
	 * @see IhmCUI#afficherTriNaturel()
	 * @see IhmCUI#afficherListeGroupee()
	 * @see IhmCUI#afficherListeGroupee()
	 */
	private ControleurEtat oCtrl;
	
	/**
	 * Controleur de IhmCUI.
	 *
	 * @param oCtrl
	 *          Controleur de l'IhmCUI.
	 *
	 * @see IhmCUI#oCtrl
	 */
	public IhmCUI(ControleurEtat oCtrl)
	{
		this.oCtrl = oCtrl;
	}

	/**
	 * Affiche le menu de choix de l'application.
	 */
	public void afficherMenu()
	{
		System.out.println( "Que souhaitez vous faire ?"                                    + "\n" +
							"   1.Afficher tous les ouvrages"                               + "\n" +
							"   2.Afficher tous les ouvrages de [nom]"                      + "\n" +
							"   3.Afficher tous les ouvrages triée par Editeurs et Séries." + "\n" +
							"   4.Quitter"                                                  + "\n"
						  );

		System.out.print( "Saisissez le numero : " );
	}

	/**
	 * Affiche tous les ouvrages triés dans l'ordre naturel.
	 *
	 * @see IhmCUI#oCtrl
	 */
	public void afficherTriNaturel()
	{
		System.out.println(this.oCtrl.getEnTete());

		List<Ouvrage> ensListeTriee = this.oCtrl.getListeTrieeParOrdreNaturel();

		ensListeTriee.forEach(oOuvrage -> System.out.println(oOuvrage));
		
		System.out.println(  "\n" + "La Bedetheque contient " + ensListeTriee.size() + 
		                    (ensListeTriee.size()<=1?" ouvrage.":" ouvrages.") + "\n" );
	}

	/**
	 * Affiche tous les ouvrages d'un auteur en particulier.
	 *
	 * @see IhmCUI#oCtrl
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

		System.out.println("\nCette auteur à participer à " + ensOuvragesAuteur.size() +
		                  (ensOuvragesAuteur.size()<=1?" ouvrage":" ouvrages") + " de la bedetheque.\n");
	}

	/**
	 * Affiche tous les ouvrages triés par éditeurs puis par séries.
	 *
	 * @see IhmCUI#oCtrl
	 */
	public void afficherListeGroupee()
	{
		List<Ouvrage> ensOuvragesTries = this.oCtrl.getListeTrieeParEditeurEtSerie();

		System.out.println( this.oCtrl.getEnTete() );
		ensOuvragesTries.forEach(oOuvrage -> System.out.println(oOuvrage));

		System.out.println(  "\n" + "La Bedetheque contient " + ensOuvragesTries.size() + 
		                    (ensOuvragesTries.size()<=1?" ouvrage.":" ouvrages.") + "\n" );
	}
}
