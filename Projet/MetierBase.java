import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.FileInputStream;

public class MetierBase
{
	private List<Ouvrage> ensOuvrages;

	public MetierBase()
	{
		this.ensOuvrages = new ArrayList<Ouvrage>();
	}

	public boolean ajouterOuvrage(String titre, String editeur, String serie,
				      String scenariste, String dessinateur,
				      Integer tome)
	{
		Ouvrage tmp = Ouvrage.creerOuvrage(titre, editeur, serie,
						   scenariste, dessinateur, tome);

        this.afficherListeGroupee();

		if ( tmp == null )return false;

		this.ensOuvrages.add(tmp);
		return true;
	}

	public ArrayList<String> lireFichier(String chemin)
	{
		ArrayList<String> oFichier = new ArrayList<String>();

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
				this.ensOuvrages.add(Ouvrage.creerOuvrage(tabLigActuelle[0], tabLigActuelle[1],
														  tabLigActuelle[2], tabLigActuelle[3],
														  tabLigActuelle[4], tome));
			}
		}
	}

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

	public List<Ouvrage> getOuvrages   (){ return this.ensOuvrages; }

	public Ouvrage       getLastOuvrage(){ return this.ensOuvrages.get(this.ensOuvrages.size()-1);}

    public void afficherListeGroupee()
	{
		List<Ouvrage> list = this.getOuvrages();

		Map<String, List<Ouvrage>> listGrouped = list.stream().collect(Collectors.groupingBy(l -> l.getEditeur()));
		System.out.println(listGrouped);
	}
}
