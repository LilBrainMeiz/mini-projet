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
import java.nio.charset.StandardCharsets;

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
		List<String> ensLignesFichier = super.lireFichier(chemin);

		return ensLignesFichier.toArray(new String[ensLignesFichier.size()]);
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
			PrintWriter oSortie = new PrintWriter( new FileWriter(chemin, StandardCharsets.UTF_8, true));

			oSortie.print(toPrint);
			oSortie.close();
		}
		catch(Exception e){ e.printStackTrace(); }
	}
	
	
	public String toString()
    	{
        	File   oFichier = new File("sortie.txt");
        	String sRet    = "";

        	boolean bIsExisting = oFichier.exists();

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
