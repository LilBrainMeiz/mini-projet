/*
 * MetierSaisie.java
 * Metier qui hérite de MetierBase
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */

import java.util.List;

import java.io.File       ;
import java.io.FileWriter ;
import java.io.PrintWriter;

public class MetierSaisie extends MetierBase
{
	// Constructeur
	public MetierSaisie(){}

	// Accesseur
	
	/**
	 * Retourne un tableau contenant toute les lignes du fichier passé en paramètre.
	 * @param chemin Chemin vers le fichier à lire.
	 * @return Tableau contenant les lignes du fichier.
	 */
	public String[] getTableauLignesFichier( String chemin )
	{
		List<String> lignesFichier = super.lireFichier(chemin);

		return lignesFichier.toArray(new String[lignesFichier.size()]);
	}
    
	/**
	 * Ecrit une chaine passée en paramètre dans le fichier dont le chemin est passé en paramètre.
	 * @param chemin Chemin vers le fichier à écrire.
	 * @param toPrint Texte à écrire dans le fichier.
	 */
	public void ecrireFichier(String chemin, String toPrint)
	{
		try
		{
			PrintWriter sSortie = new PrintWriter( new FileWriter(chemin,
															      true));
		
			sSortie.print(toPrint);
			sSortie.close();
		}
		catch(Exception e){ e.printStackTrace(); }
	}
	
	
	public String toString()
    	{
        	File   fichier = new File("sortie.txt");
        	String sRet    = "";

        	boolean bIsExisting = fichier.exists();

        	if(!bIsExisting)
        	{            
        	    for(Ouvrage o : super.getOuvrages() )
         	       sRet += o.toString2() + "\n";
        	}
        	else
        	{
       			sRet = super.getLastOuvrage().toString2() + "\n";
        	}
        	return sRet;
	}
}
