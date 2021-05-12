/*
 * Ouvrage.java
 * ouvrage
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */
public class Ouvrage implements Comparable<Ouvrage>
{
	// Attributs
	// ici, le préfixe is correspond à "int" "static" selon la notation hongroise.
	private static int isNombreOuvrage;
	private int        iNumeroOuvrage;

	private String     sTitre;
	private String     sEditeur;
	private String     sSerie;
	private String     sScenariste;
	private String     sDessinateur;
	private Integer    iTome; // Ici le tome est en Integer car il est facultatif

	// Méthode usine
	/*
	 * vérifie si les paramétres sont correct
	 * @param titre, editeur, serie, scenariste, dessinateur, tome
	 *          attributs de l'ouvrage créé
	 */

	/**
	 * Méthode factory : Vérifie si les paramètres sont corrects.
	 * @param titre Titre de l'ouvrage.
	 * @param editeur Éditeur de l'ouvrage.
	 * @param serie   Série de l'ouvrage (Optionnel).
	 * @param scenariste Scénariste de l'ouvrage.
	 * @param dessinateur Dessinateur de l'ouvrage.
	 * @param tome Tome de l'ouvrage (Optionnel).
	 */
	public static Ouvrage creerOuvrage(String titre, String editeur,
									   String serie, String scenariste,
									   String dessinateur, Integer tome)
	{
		// Permet de ne pas tolérer un autre argument que serie ou tome
		// en null;
		if(titre       == null || titre      .equals("") ||
		   editeur     == null || editeur    .equals("") ||
		   scenariste  == null || scenariste .equals("") ||
		   dessinateur == null || dessinateur.equals("")  )
			return null;

		// Permet de ne pas ajouter d'ouvrage si il y en a déjà 10000
		if(Ouvrage.isNombreOuvrage == 10000)return null;

		return new Ouvrage(titre, editeur, serie, scenariste, dessinateur,
						   tome);
    }
    
	// Constructeur
	/*
	 * Si les paramétres de la méthode usine sont correct, elle appelle le constructeur
	 * "private" pour qu'on ne puisse pas l'appeller en dehors de la classe
	 * Initialise les attributs du nouvel ouvrage
	 */
	private Ouvrage(String titre, String editeur, String serie,
				   String scenariste, String dessinateur, Integer tome)
	{
		this.iNumeroOuvrage = ++Ouvrage.isNombreOuvrage;

		this.sTitre         = titre;
		this.sEditeur       = editeur;
		this.sSerie         = serie;
		this.sScenariste    = scenariste;
		this.sDessinateur   = dessinateur;
		this.iTome          = tome;
	}
    
	/*-----Accesseurs-----*/

	/**
	 * Retourne l'éditeur de l'ouvrage.
	 * @return Le nom de l'éditeur de l'ouvrage.
	 */
	public String  getEditeur    (){ return this.sEditeur;     }

	/**
	 * Retourne le dessinateur de l'ouvrage.
	 * @return Le nom du dessinateur de l'ouvrage.
	 */
	public String  getDessinateur(){ return this.sDessinateur; }

	/**
	 * Retourne la série de l'ouvrage.
	 * @return La série de l'ouvrage.
	 */
	public String  getSerie      (){ return this.sSerie;       }

	 /**
	  * Retourne le scénariste de l'ouvrage.
	  * @return Le nom du scénariste de l'ouvrage.
	  */
	public String  getScenariste (){ return this.sScenariste;  }

	 /**
	  * Retourne le titre de l'ouvrage.
	  * @return Le titre de l'ouvrage.
	  */
	public String  getTitre      (){ return this.sTitre;       }

	/**
	 * Retourne le tome de l'ouvrage.
	 * @return Le tome de l'ouvrage.
	 */
	public Integer getTome       (){ return this.iTome;        }

	public String toString()
	{
		String sRet = "| " +
					  String.format("%-29.29s", this.sTitre      ) + "| " +
					  String.format("%-24.24s", this.sScenariste ) + "| " +
					  String.format("%-24.24s", this.sDessinateur) + "| " + 
					  String.format("%-14.14s", this.sEditeur    ) + "| " +
					  String.format("%-34.34s", this.sSerie      ) + "| ";

		sRet += this.iTome == null ? "Aucun"+ "|": String.format("%-5s" , this.getTome()) + "|";

		return sRet;
	}
	
	public String toString2()
	{
        	return this.sTitre       + ":" + this.sEditeur      + ":" +
		       this.sSerie       + ":" +  this.sScenariste  + ":" +
		       this.sDessinateur + ":" + this.iTome;
	}

	public int compareTo(Ouvrage autre)
	{
		int iSize = autre.sTitre.length();
		int iVal;

		if ( this.sTitre.length() < iSize )iSize = this.sTitre.length();

		for(int i=0;i<iSize;i++)
		{
			iVal = this.sTitre.charAt(i) - autre.sTitre.charAt(i);
			if ( iVal != 0 )return iVal; 
		}

		return 0;
	}
}
