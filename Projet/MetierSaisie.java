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
	/* retourne la derniere ligne du fichier mit en paramètre
 	 * @param chemin
	 *          chemin pour aller jusqu'au fichier voulu
 	 * @return une ArrayList de la dernière ligne du fichier
 	 */
	public String[] getTableauLignesFichier( String chemin )
	{
		List<String> lignesFichier = super.lireFichier(chemin);

		return lignesFichier.toArray(new String[lignesFichier.size()]);
	}
    
	/*
 	 * @param chemin
 	 *          chemin vers le fichier ou l'on veut écrire
	 * @param toPrint
	 *          écrit dans le fichier le contenu de toPrint
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
	
	/*
 	 * retourne ?
 	 */
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
