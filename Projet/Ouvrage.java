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

	/*
	 *retourne sEditeur de l'ouvrage
	 * @return le nom de l'éditeur de l'oeuvre
	 */
	public String  getEditeur    (){ return this.sEditeur;     }

	/* 
	 *retourne sDessinateur de l'ouvrage
	 * @return le nom du dessinateur de l'oeuvre
	 */
	public String  getDessinateur(){ return this.sDessinateur; }

	/*
	 *retourne sSerie de l'ouvrage
	 * @return le nom de la série de l'oeuvre
	 */
	public String  getSerie      (){ return this.sSerie;       }

	/* 
	 *retourne sScenariste de l'ouvrage
	 * @return le nom du scénariste de l'oeuvre
	 */
	public String  getScenariste (){ return this.sScenariste;  }

	/* 
	 *retourne sTitre de l'ouvrage
	 * @return le titre de l'oeuvre
	 */
	public String  getTitre      (){ return this.sTitre;       }

	/* 
	 * retourne iTome de l'ouvrage
	 * @return le nombre de tome de l'oeuvre
	 */
	public Integer getTome       (){ return this.iTome;        }

	/* retourne les informations de l'ouvrage */
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
	
	public String toString2()
	{
        	return this.sTitre       + ":" + this.sScenariste + ":" +
		       this.sDessinateur + ":" + this.sEditeur    + ":" +
		       this.sSerie       + ":" + this.iTome;
        
    }
    
	/*
	 * compare le titre de l'ouvrage actuel avec le titre de l'ouvrage mis en paramètre
	 * @param autre
	 *           ouvrage comparé
	 * @return 0 si les titres des 2 ouvrages sont identiques
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

	/*
	 * compare l'ouvrage actuel avec l'ouvrage mis en paramètre
	 * @param autre
	 *           ouvrage comparé
	 * @return true si les attributs des 2 ouvrages sont identiques
	 */
	public boolean equals(Ouvrage autre)
	{
		return this.sTitre      .equals(autre.sTitre      ) && 
			   this.sScenariste .equals(autre.sScenariste ) &&
			   this.sDessinateur.equals(autre.sDessinateur) &&
			   this.sEditeur    .equals(autre.sDessinateur) &&
			   this.sSerie      .equals(autre.sSerie      );
	}
}
