/**
 * ControleurEtat.java
 * controleur de l'application pour les Etat d'une bedetheque.
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */
import java.util.Scanner;
import java.util.List;

public class ControleurEtat
{
	/**
	 * Ihm pour l'application Etat qui sera en CUI.
	 * @see ControleurEtat#ControleurEtat()
	 * @see ControleurEtat#lancerEtat()
	 */
	private IhmCUI     oIhm;

	/**
	 * Metier pour l'application Etat.
	 * @see ControleurEtat#ControleurEtat()
	 * @see ControleurEtat#getEnTete()
	 * @see ControleurEtat#getOuvrages()
	 */

	private MetierEtat oMetier;
	
	/**
	 * Creer une instance de ControleurEtat.
	 * Lance une IhmCUI et un MetierEtat.
	 * @see ControleurEtat#oIhm
	 * @see ControleurEtat#oMetier
	 */
	public ControleurEtat()
	{
		this.oIhm    = new IhmCUI(this);
		this.oMetier = new MetierEtat();

		this.lancerEtat();
	}

	// Accesseurs

	/**
	 * Retourne une String étant l'en-tête de tous les affichages.
	 * @see ControleurEtat#oMetier
	 * @return L'en-tête dans metier.
	 */
	public String        getEnTete  (){ return this.oMetier.enTete     (); }

	/**
	 * Appelle getOuvrages dans la classe metier.
	 * @see ControleurEtat#oMetier
	 * @return L'ensembles des ouvrages dans la classe metier.
	 */
	public List<Ouvrage> getOuvrages(){ return this.oMetier.getOuvrages(); }

	/**
	 * Permet de lancer l'état avec une boucle.
	 */
	private void lancerEtat()
	{
		int iAction;
		String sTmp;
		Scanner oEntree;

		try
		{
			oEntree = new Scanner(System.in);

			do
			{
				this.oIhm.afficherMenu();
				sTmp = oEntree.nextLine();

				if ( !sTmp.equals("0") && !sTmp.equals("1") && !sTmp.equals("2") &&
				     !sTmp.equals("3") && !sTmp.equals("4"))
				{
					System.out.println("Veuillez rentrer un numéro valide");
					iAction = 0;
				}
				else
				{
					iAction = sTmp.charAt(0) - '0';
				}

				this.oMetier.synchroniserOuvrages();

				switch( iAction )
				{
					case 1  -> this.oIhm.afficherTriNaturel  ();
					case 2  -> this.oIhm.afficherOuvrageDe   ();
					case 3  -> this.oIhm.afficherListeGroupee();
				}
			}while ( iAction != 4 );

			oEntree.close();
		}catch(Exception e){e.printStackTrace();}
	}

	/**
	 * Retourne la liste des ouvrages fait par auteur en paramètre
	 * @param sAuteur Nom de l'auteur dont on souhaite les ouvrages.
	 * @return Liste des ouvrages de l'auteur en paramètre.
	 */
	public List<Ouvrage> getOuvragesDe(String sAuteur)
	{
		return this.oMetier.getOuvragesDe( sAuteur );
	}

	/**
	 * Retourne la liste des ouvrages triées par éditeurs et par séries.
	 * @return Liste des ouvrages triée par éditeurs et séries.
	 * @see ControleurEtat#oMetier
	 */
	public List<Ouvrage> getListeTrieeParEditeurEtSerie()
	{
		return this.oMetier.getListeTrieeParEditeurEtSerie();
	}

	/**
	 * Retourne la liste des ouvrages triées par ordre naturel.
	 * @return Liste des ouvrages triée par ordre naturel.
	 * @see ControleurEtat#oMetier
	 */
	public List<Ouvrage> getListeTrieeParOrdreNaturel()
	{
		return this.oMetier.getListeTrieeParOrdreNaturel();
	}

	/**
	 * Lance l'application.
	 * @param args argument au lancement du ControleurEtat
	 */
	public static void main(String[] args)
	{
		new ControleurEtat();
	}
}
