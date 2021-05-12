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
	private FrameSaisie  ihm;    /* @see FrameSaisie */
	private MetierSaisie metier; /* @see MetierSaisie */

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
     *             Attributs du nouvel ouvrage
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
	public String[] getSerie  (){ return this.metier.getEnsemble("serie.txt"  ); }
    
	/**
	 * @return L'attribut Auteur de la classe metier
	 */
	public String[] getAuteur (){ return this.metier.getEnsemble("auteur.txt" ); }
    
	/**
	 * @return L'attribut Editeur de la classe metier
	 */
   	public String[] getEditeur(){ return this.metier.getEnsemble("editeur.txt"); }

	public static void main(String[] args)
	{
		new ControleurSaisie();
	}
}
