/**
 * Ouvrage.java
 * ouvrage.
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */
public class Ouvrage implements Comparable<Ouvrage>
{
	// Attributs
	/*
	 * C'est le nombre d'ouvrage qui a été créé.
	 * Ici, le préfixe is correspond à "int" "static" selon la notation hongroise.
	 *
	 * @see Ouvrage#creerOuvrage( String, String, String, String, String, Integer )
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 */
	private static int isNombreOuvrage;
	
	/*
	 * C'est le numero de l'ouvrage selon le l'ordre dans lequel il a été créé.
	 * 
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 */
	private int        iNumeroOuvrage;
	
	/*
	 * Titre de l'ouvrage.
	 *
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 * @see Ouvrage#getTitre()
	 * @see Ouvrage#toString()
	 * @see Ouvrage#toString2()
	 * @see Ouvrage#compareTo( Ouvrage )
	 */
	private String     sTitre;
	
	/*
	 * Nom de l'éditeur de l'ouvrage.
	 *
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 * @see Ouvrage#getEditeur()
	 * @see Ouvrage#toString()
	 * @see Ouvrage#toString2()
	 */
	private String     sEditeur;
	
	/*
	 * Nom de la série de l'ouvrage.
	 * Cet Attribut n'est pas facultatif, il se peut qu'il ne contienne rien(null).
	 *
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 * @see Ouvrage#getSerie()
	 * @see Ouvrage#toString()
	 * @see Ouvrage#toString2()
	 */
	private String     sSerie;
	
	/*
	 * Nom du scénariste de l'ouvrage.
	 *
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 * @see Ouvrage#getScenariste()
	 * @see Ouvrage#toString()
	 * @see Ouvrage#toString2()
	 */
	private String     sScenariste;
	
	/*
	 * Nom du dessinateur de l'ouvrage.
	 *
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 * @see Ouvrage#getDessinateur()
	 * @see Ouvrage#toString()
	 * @see Ouvrage#toString2()
	 */
	private String     sDessinateur;
	
	/*
	 * Nombre de tome de l'ouvrage.
	 * Ici le tome est en Integer car il est facultatif.
	 *
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 * @see Ouvrage#getTome()
	 * @see Ouvrage#toString()
	 * @see Ouvrage#toString2()
	 */
	private Integer    iTome;

	/**
	 * Méthode factory : Vérifie si les paramètres sont corrects.
	 * @param titre
	 *          Titre de l'ouvrage.
	 * @param editeur
	 *          Éditeur de l'ouvrage.
	 * @param serie
	 *          Série de l'ouvrage (Optionnel).
	 * @param scenariste
	 *          Scénariste de l'ouvrage.
	 * @param dessinateur
	 *          Dessinateur de l'ouvrage.
	 * @param tome
	 *          Tome de l'ouvrage (Optionnel).
	 *
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 */
	public static Ouvrage creerOuvrage(String titre, String editeur, String serie, String scenariste, String dessinateur, Integer tome)
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
	 * Si les paramétres de la méthode usine sont correct, elle appelle le constructeur.
	 * Celui-ci est "private" pour qu'on ne puisse pas l'appeller en dehors de la classe.
	 * Initialise les attributs du nouvel ouvrage.
	 *
	 * @param titre
	 *          Titre du nouvel ouvrage.
	 * @param editeur
	 *          Nom de l'éditeur du nouvel ouvrage.
	 * @param serie
	 *          Nom de la série du nouvel ouvrage (Optionnel).
	 * @param scenariste
	 *          Nom du scénariste du nouvel ouvrage.
	 * @param dessinateur
	 *          Nom du dessinateur du nouvel ouvrage.
	 * @param tome
	 *          Nombre de tome du nouvel ouvrage (Optionnel).
	 *
	 * @see Ouvrage#sTitre
	 * @see Ouvrage#sEditeur
	 * @see Ouvrage#sSerie
	 * @see Ouvrage#sScenariste
	 * @see Ouvrage#sDessinateur
	 * @see Ouvrage#iTome
	 */
	private Ouvrage(String titre, String editeur, String serie, String scenariste, String dessinateur, Integer tome)
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
	 *
	 * @see Ouvrage#sEditeur
	 */
	public String  getEditeur    (){ return this.sEditeur;     }

	/**
	 * Retourne le dessinateur de l'ouvrage.
	 * @return Le nom du dessinateur de l'ouvrage.
	 *
	 * @see Ouvrage#sDessinateur
	 */
	public String  getDessinateur(){ return this.sDessinateur; }

	/**
	 * Retourne la série de l'ouvrage.
	 * @return La série de l'ouvrage.
	 *
	 * @see Ouvrage#sSerie
	 */
	public String  getSerie      (){ return this.sSerie;       }

	/**
	 * Retourne le scénariste de l'ouvrage.
	 * @return Le nom du scénariste de l'ouvrage.
	 *
	 * @see Ouvrage#sScenriste
	 */
	public String  getScenariste (){ return this.sScenariste;  }

	/**
	 * Retourne le titre de l'ouvrage.
	 * @return Le titre de l'ouvrage.
	 *
	 * @see Ouvrage#sTitre
	 */
	public String  getTitre      (){ return this.sTitre;       }

	/**
	 * Retourne le tome de l'ouvrage.
	 * @return Le tome de l'ouvrage.
	 *
	 * @see Ouvrage#iTome
	 */
	public Integer getTome       (){ return this.iTome;        }
	
	/**
	 * Retourne les informations de l'ouvrage sous forme d'une ligne de tableau.
	 *
	 * @return Toute les infos de l'ouvrage dans une ligne de tableau
	 *
	 * @see Ouvrage#sTitre
	 * @see Ouvrage#sScenariste
	 * @see Ouvrage#sDessinateur
	 * @see Ouvrage#sEditeur
	 * @see Ouvrage#sSerie
	 * @see Ouvrage#iTome
	 *
	 * @see Ouvrage#getTome()
	 */
	public String toString()
	{
		String sRet = "| " +
					  String.format("%-29s", this.sTitre      ) + "| " +
					  String.format("%-24s", this.sScenariste ) + "| " +
					  String.format("%-24s", this.sDessinateur) + "| " + 
					  String.format("%-14s", this.sEditeur    ) + "| " +
					  String.format("%-34s", this.sSerie      ) + "| ";

		sRet += this.iTome == null ? "Aucun"+ "|": String.format("%-5s" , this.getTome()) + "|";

		return sRet;
	}
	
	/**
	 * Retourne les informations de l'ouvrage en les séparants par ":".
	 *
	 * @return Toute les infos de l'ouvrage séparé par ":" en une ligne 
	 *
	 * @see Ouvrage#sTitre
	 * @see Ouvrage#sScenariste
	 * @see Ouvrage#sDessinateur
	 * @see Ouvrage#sEditeur
	 * @see Ouvrage#sSerie
	 * @see Ouvrage#iTome
	 */
	public String toString2()
	{
        	return this.sTitre       + ":" + this.sEditeur      + ":" +
		       this.sSerie       + ":" +  this.sScenariste  + ":" +
		       this.sDessinateur + ":" + this.iTome;
	}
	
	/**
	 * Compare le titre de l'ouvrage actuel avec le titre de l'ouvrage en paramètre.
	 *
	 * @param Ouvrage
	 *          Ouvrage que l'on va comparé avec l'actuel
	 *
	 * @return 0 si le titre des deux ouvrages sont identiques
	 *
	 * @see Ouvrage#sTitre
	 */
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
