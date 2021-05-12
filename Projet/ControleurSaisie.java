/**
 * ControleurSaisie.java
 * controleur
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */

public class ControleurSaisie
{
	//Attributs de ControleurSaisie
	/**
	 * IHM qui sera sous forme de Frame.
	 *
	 *
	 * @see ControleurSaisie#ControleurSaisie()
	 * @see ControleurSaisie#ajouterOuvrage(String, String, String, String, String, Integer)
	 */
	private FrameSaisie  ihm;
	
	/**
	 * Metier pour l'application Saisie.
	 *
	 *
	 * @see ControleurSaisie#ControleurSaisie()
	 * @see ControleurSaisie#ajouterOuvrage(String, String, String, String, String, Integer)
	 * @see ControleurSaisie#getSerie()
	 * @see ControleurSaisie#getAuteur()
	 * @see ControleurSaisie#getEditeur()
	 */
	private MetierSaisie metier;

	/**
	 * Constructeur Controleur.
	 * @see ControleurSaisie#metier
	 * @see ControleurSaisie#ihm
	 */
	public ControleurSaisie()
	{
		this.metier = new MetierSaisie();
		this.ihm    = new FrameSaisie(this);
	}
    
    	//Méthode pour ajouter un ouvrage dans la bedetheque en appellant la méthode du même nom dans la classe métier
	
    	/**
     	 * Ajoute un ouvrage dans la base metier.
     	 *
     	 * @param titre
	 *          Le titre de l'ouvrage.
	 * @param editeur
	 *          Le nom de l'editeur de l'ouvrage.
	 * @param serie
	 *          Le nom de la série de l'ouvrage.
	 * @param scenariste
	 *          Le nom du scénariste de l'ouvrage.
	 * @param dessinateur
	 *          Le nom du dessinateur de l'ouvrage.
     	 *             
     	 *
     	 * @see ControleurSaisie#metier
     	 * @see ControleurSaisie#ihm
     	 */
	public void ajouterOuvrage(String titre, String editeur, String serie,
                               String scenariste, String dessinateur,
                               Integer tome)
	{
		if ( this.metier.ajouterOuvrage(titre, editeur, serie, scenariste,
                                        dessinateur, tome) )
			this.metier.ecrireFichier("sortie.txt", metier.toString());
		else
			this.ihm.champObligatoire();
	}
    
	/*-----Accesseur aux attributs de la classe metier-----*/
	
	/**
	 * Retourne l'ensemble des series contenues dans le fichier "serie.txt".
	 * @return L'ensemble des series contenues dans le fichier "serie.txt".
	 *
	 * @see metier
	 */
	public String[] getSeries  (){ return this.metier.getTableauLignesFichier("serie.txt"  ); }
    
	/**
	 * Retourne l'ensemble des auteurs contenues dans le fichier "auteur.txt".
	 * @return L'ensemble des auteurs contenues dans le fichier "auteur.txt".
	 *
	 * @see metier
	 */
	public String[] getAuteurs (){ return this.metier.getTableauLignesFichier("auteur.txt" ); }
    
	/**
	 * Retourne l'ensemble des editeurs contenues dans le fichier "editeur.txt".
	 * @return L'ensemble des editeurs contenues dans le fichier "editeur.txt".
	 *
	 * @see metier
	 */
   	public String[] getEditeurs(){ return this.metier.getTableauLignesFichier("editeur.txt"); }

	public static void main(String[] args)
	{
		new ControleurSaisie();
	}
}
