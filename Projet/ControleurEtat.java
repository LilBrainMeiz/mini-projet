/*
 * ControleurEtat.java
 * controleur
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
	// Attributs
	private IhmCUI     ihm;
	private MetierEtat metier;
    	private Scanner    scInput;
	
	// Constructeur
	public ControleurEtat()
	{
		this.ihm    = new IhmCUI(this);
		this.metier = new MetierEtat();

        	scInput = new Scanner(System.in);

		this.lancerEtat();
	}
	
	// Accesseurs
	
	/*
	 * retourne une String étant l'en-tête de tous les affichages
	 * @return l'en-tête dans metier
	 */
	public String        getEnTete  (){ return this.metier.enTete     (); }
	
	/*
	 * appelle getOuvrages dans la classe metier
	 * @return l'ensembles des ouvrages dans la classe metier
	 */
	public List<Ouvrage> getOuvrages(){ return this.metier.getOuvrages(); }
	
	/*
	 * permet de lancer l'application
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

	/*
	 * retourne le nom de l'auteur saisie par l'utilisateur pour l'état n°3
	 */
	public String getNomAuteur()
	{
		String sRet = this.scInput.next();

		return sRet;
	}

	/*
	 * lance l'application
	 */
	public static void main(String[] args)
	{
		new ControleurEtat();
	}
}
