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
	 * IHM qui sera sous forme de Frame
	 *
	 * @see FrameSaisie
	 *
	 * @see ControleurSaisie#ControleurSaisie()
	 * @see ControleurSaisie#ajouterOuvrage(String, String, String, String, String, Integer)
	 */
	private FrameSaisie  ihm;
	
	/**
	 * metier pour l'application Saisie
	 *
	 * @see MetierSaisie
	 *
	 * @see ControleurSaisie#ControleurSaisie()
	 * @see ControleurSaisie#ajouterOuvrage(String, String, String, String, String, Integer)
	 * @see ControleurSaisie#getSerie()
	 * @see ControleurSaisie#getAuteur()
	 * @see ControleurSaisie#getEditeur()
	 */
	private MetierSaisie metier;

	/**
	 * Constructeur Controleur
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
     * Ajoute un ouvrage dans la base metier
     *
     * @param titre, editeur, serie, scenariste, dessinateur, tome
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
    
	/*-----Accesseur aux attributs de la classe métier-----*/
	/**
	 * @return L'attribut Serie de la classe metier
	 */
	public String[] getSeries  (){ return this.metier.
								   getTableauLignesFichier("serie.txt"  ); }
    
	/**
	 * @return L'attribut Auteur de la classe metier
	 */
	public String[] getAuteurs (){ return this.metier.
								   getTableauLignesFichier("auteur.txt" ); }
    
	/**
	 * @return L'attribut Editeur de la classe metier
	 */
   	public String[] getEditeurs(){ return this.metier.
								   getTableauLignesFichier("editeur.txt"); }

	public static void main(String[] args)
	{
		new ControleurSaisie();
	}
}
