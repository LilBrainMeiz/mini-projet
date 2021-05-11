/*
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
	private List<Ouvrage> ensOuvrages;
	
	// Constructeur
	public MetierBase()
	{
		this.ensOuvrages = new ArrayList<Ouvrage>();
		this.synchroniserOuvrages();
	}
	
	/*
	 * Ajoute un ouvrage
	 * @param titre, editeur, serie, scenariste, dessinateur, tome
	 *          Attributs du nouvel ouvrage
	 * @return true si tmp différent de null
	 */
	public boolean ajouterOuvrage(String titre, String editeur, String serie,
				      String scenariste, String dessinateur,
				      Integer tome)
	{
		Ouvrage tmp = Ouvrage.creerOuvrage(titre, editeur, serie,
						   scenariste, dessinateur, tome);

		if ( tmp == null )return false;

		this.ensOuvrages.add(tmp);
		return true;
	}
	
	/*
	 * lit le fichier jusqu'à la dernière ligne
	 * @param chemin
	 *          Chemin vers le fichier que l'on veut lire
	 * @return la dernière ligne du fichier sous forme de tableau de String
	 */
	public List<String> lireFichier(String chemin)
	{
		List<String> oFichier = new ArrayList<String>();

		try
        	{
            		Scanner oInput = new Scanner( new FileInputStream(chemin),
			                              "UTF8" );

			while(oInput.hasNextLine())
			{
				oFichier.add(oInput.nextLine());
			}
			
		}catch(Exception e){ e.printStackTrace(); }

		return oFichier;
	}
	
	/*
	 * synchronise les ouvrages
	 */
	public void synchroniserOuvrages()
	{
		File      f = new File("sortie.txt");
		String[] tabLigActuelle;

		Integer tome;

		this.ensOuvrages.clear();

		if ( f.exists() )
		{
			List<String> tmp = this.lireFichier("sortie.txt");

			for ( String s : tmp )
			{
				tabLigActuelle = s.split(":");
				
				tome =  tabLigActuelle[5].equals("null")?null: Integer.parseInt(tabLigActuelle[5]);
				this.ensOuvrages.add(Ouvrage.creerOuvrage(tabLigActuelle[0], tabLigActuelle[3],
														  tabLigActuelle[4], tabLigActuelle[1],
														  tabLigActuelle[2], tome));
			}
		}
	}
	
	/*
	 * retourne l'en-tete d'un tableau
	 * @return la première ligne d'un tableau*/
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

		String encadre = "|" +
							"             Titre            "      + "|" +
							"        Scenariste       "           + "|" +
							"        Dessinateur      "           + "|" +
							"    Editeur    "                     + "|" +
							"               Serie               " + "|" +
							" Tome "                              + "|" +"\n";

		sRet += encadre + "+";

		sRet += "------------------------------+";
		sRet += "-------------------------+";
		sRet += "-------------------------+";
		sRet += "---------------+";
		sRet += "-----------------------------------+";
		sRet += "------+";

		return sRet;
	}
	
	/*
	 * retourne ensOuvrage
	 * @return l'ensemble des ouvrages dans la classe MetierBase
	 */
	public List<Ouvrage> getOuvrages   (){ return this.ensOuvrages; }
	
	/*
	 * retourne le dernier élément de ensOuvrages
	 * @return le dernier ouvrage ajouté dans l'ensemble d'ouvrages
	 */
	public Ouvrage       getLastOuvrage(){ return this.ensOuvrages.get(this.ensOuvrages.size()-1);}
}
