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
	 * Permet de lire l'entrée de l'utilisateur dans différents cas.
	 * @see ControleurEtat#ControleurEtat()
	 * @see ControleurEtat#lancerEtat()
	 */
    private Scanner    oEntree;
	
	/**
	 * Creer une instance de ControleurEtat.
	 * Lance une IhmCUI et un MetierEtat.
	 * @see ControleurEtat#oIhm
	 * @see ControleurEtat#oMetier
	 * @see ControleurEtat#oEntree
	 */
	public ControleurEtat()
	{
		this.oIhm    = new IhmCUI(this);
		this.oMetier = new MetierEtat();

        oEntree = new Scanner(System.in);

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
	 * @see ControleurEtat#oEntree
	 */
	private void lancerEtat()
	{
		int iAction;

		do
		{
			this.oIhm.afficherMenu();
			iAction = oEntree.nextInt();

			this.oMetier.synchroniserOuvrages();

			switch( iAction )
			{
				case 1  -> this.oIhm.afficherTriNaturel  ();
				case 2  -> this.oIhm.afficherListeGroupee();
				case 3  -> this.oIhm.afficherOuvrageDe   ();
			}			
		}while ( iAction != 4 );
	}
	
	/**
	 * Retourne la liste des ouvrages fait par auteur en paramètre
	 * @param auteur Nom de l'auteur dont on souhaite les ouvrages.
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
	 * Lit un nom d'auteur pour l'etat n°3.
	 * @return Entrée de l'utilisateur destinée à être l'auteur pour l'état n°3.
	 */
	public String getNomAuteur()
	{
		String sRet = this.oEntree.next();

		return sRet;
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
