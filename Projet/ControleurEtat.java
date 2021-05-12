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
	private IhmCUI     ihm;

	/**
	 * Metier pour l'application Etat.
	 * @see ControleurEtat#ControleurEtat()
	 * @see ControleurEtat#getEnTete()
	 * @see ControleurEtat#getOuvrages()
	 */

	private MetierEtat metier;

	/**
	 * Permet de lire l'entrée de l'utilisateur dans différents cas.
	 * @see ControleurEtat#ControleurEtat()
	 * @see ControleurEtat#lancerEtat()
	 */
    private Scanner    scInput;
	
	/**
	 * Creer une instance de ControleurEtat.
	 * Lance une IhmCUI et un MetierEtat.
	 * @see ControleurEtat#ihm
	 * @see ControleurEtat#metier
	 * @see ControleurEtat#scInput
	 */
	public ControleurEtat()
	{
		this.ihm    = new IhmCUI(this);
		this.metier = new MetierEtat();

        scInput = new Scanner(System.in);

		this.lancerEtat();
	}
	
	// Accesseurs
	
	/**
	 * Retourne une String étant l'en-tête de tous les affichages.
	 * @see ControleurEtat#metier
	 * @return L'en-tête dans metier.
	 */
	public String        getEnTete  (){ return this.metier.enTete     (); }
	
	/**
	 * Appelle getOuvrages dans la classe metier.
	 * @see ControleurEtat#metier
	 * @return L'ensembles des ouvrages dans la classe metier.
	 */
	public List<Ouvrage> getOuvrages(){ return this.metier.getOuvrages(); }
	
	/**
	 * Permet de lancer l'état avec une boucle.
	 * @see ControleurEtat#scInput
	 */
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
				case 1  -> this.ihm.afficherTriNaturel  ();
				case 2  -> this.ihm.afficherListeGroupee();
				case 3  -> this.ihm.afficherOuvrageDe   ();
			}			
		}while ( action != 4 );
	}

	/**
	 * Lit un nom d'auteur pour l'etat n°3.
	 * @return Entrée de l'utilisateur destinée à être l'auteur pour l'état n°3.
	 */
	public String getNomAuteur()
	{
		String sRet = this.scInput.next();

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
