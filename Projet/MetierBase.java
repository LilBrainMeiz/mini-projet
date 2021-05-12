/**
 * MetierBase.java
 * classe mère de MetierSaisie et MetierEtat
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

public class MetierBase
{
	// Attributs
	/**
	 * La liste des ouvrages de metierBase.
	 *
	 * @see Ouvrages
	 *
	 * @see MetierBase#MetierBase()
	 * @see MetierBase#ajouterOuvrage( String, String, String, String, String, Integer )
	 * @see MetierBase#synchroniserOuvrages()
	 * @see MetierBase#getOuvrages()
	 * @see MetierBase#getLastOuvrage()
	 */
	private List<Ouvrage> ensOuvrages;
	
	/**
	 * Constructeur de la classe MetierBase.
	 *
	 * @see MetierBase#ensOuvrages
	 *
	 * @see MetierBase#synchroniserOuvrages
	 */
	public MetierBase()
	{
		this.ensOuvrages = new ArrayList<Ouvrage>();
		this.synchroniserOuvrages();
	}
	
	/**
	 * Ajoute un ouvrage à ensOuvrages.
	 * @param titre
	 *          Titre du nouvel Ouvrage.
	 * @param editeur
	 *          Nom de l'éditeur du nouvel Ouvrage.
	 * @param serie
	 *          Nom de la série du nouvel Ouvrage.
	 * @param scenariste
	 *          Nom du scénariste du nouvel Ouvrage.
	 * @param dessinateur
	 *          Nom du dessinateur du nouvel Ouvrage.
	 * @param tome
	 *          Nombre de tome du nouvel Ouvrage.
	 *
	 * @return true si tmp différent de null
	 */
	public boolean ajouterOuvrage(String titre, String editeur, String serie,
				      String scenariste, String dessinateur,
				      Integer tome)
	{
		Ouvrage oTempo = Ouvrage.creerOuvrage(titre, editeur, serie,
						   scenariste, dessinateur, tome);

		if ( oTempo == null )return false;

		this.ensOuvrages.add(oTempo);
		return true;
	}
	
	/**
	 * lit le fichier jusqu'à la dernière ligne
	 * @param chemin
	 *          Chemin vers le fichier que l'on veut lire.
	 * @return la dernière ligne du fichier sous forme de tableau de String
	 */
	public List<String> lireFichier(String chemin)
	{
		List<String> oFichier = new ArrayList<String>();

		try
        	{
            	Scanner oEntree = new Scanner( new FileInputStream(chemin),
			                                  "UTF8" );

			while(oEntree.hasNextLine())
			{
				oFichier.add(oEntree.nextLine());
			}
			
		}catch(Exception e){ e.printStackTrace(); }

		return oFichier;
	}
	
	/**
	 * Synchronise les ouvrages.
	 *
	 * @see MetierBase#ensOuvrages
	 */
	public void synchroniserOuvrages()
	{
		File     oFichier = new File("sortie.txt");
		String[] tableauLignesActuelles;

		Integer iTome;

		this.ensOuvrages.clear();

		if ( oFichier.exists() )
		{
			List<String> ensLignesFichier = this.lireFichier("sortie.txt");

			for ( String s : ensLignesFichier )
			{
				tableauLignesActuelles = s.split("\t");
				
				iTome =  tableauLignesActuelles[5].equals("null")?null: Integer.parseInt(tableauLignesActuelles[5]);

				this.ensOuvrages.add(Ouvrage.creerOuvrage(tableauLignesActuelles[0], tableauLignesActuelles[1],
				                                          tableauLignesActuelles[2], tableauLignesActuelles[3],
				                                          tableauLignesActuelles[4], iTome));
			}
		}
	}
	/**
	 * Retourne l'en-tete d'un tableau.
	 * 
	 * @return la première ligne d'un tableau
	 * 
	 */
	public String enTete()
	{
		String sRet = "+";

		sRet += "------------------------------+";
		sRet += "-------------------------+";
		sRet += "-------------------------+";
		sRet += "---------------+";
		sRet += "-----------------------------------+";
		sRet += "------+";

		sRet += "\n";

		String sEncadre = "|" +
							"             Titre            "      + "|" +
							"        Scenariste       "           + "|" +
							"        Dessinateur      "           + "|" +
							"    Editeur    "                     + "|" +
							"               Serie               " + "|" +
							" Tome "                              + "|" +"\n";

		sRet += sEncadre + "+";

		sRet += "------------------------------+";
		sRet += "-------------------------+";
		sRet += "-------------------------+";
		sRet += "---------------+";
		sRet += "-----------------------------------+";
		sRet += "------+";

		return sRet;
	}
	
	/**
	 * retourne ensOuvrage
	 *
	 * @return l'ensemble des ouvrages dans la classe MetierBase
	 *
	 * @see MetierBase#ensOuvrages
	 */
	public List<Ouvrage> getOuvrages   (){ return this.ensOuvrages; }
	
	/**
	 * Retourne le dernier élément de ensOuvrages.
	 *
	 * @return le dernier ouvrage ajouté dans l'ensemble d'ouvrages
	 *
	 * @see MetierBases#ensOuvrages
	 */
	public Ouvrage       getLastOuvrage(){ return this.ensOuvrages.get(this.ensOuvrages.size()-1);}
}
