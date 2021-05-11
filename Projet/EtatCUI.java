import iut.algo.Clavier;

public class EtatCUI
{
	private String methodeAppeler;

	public EtatCUI()
	{
		System.out.println( "Que souhaitez vous faire ?"                                    + "\n" +
		                    "   1.Afficher tous les ouvrages"                               + "\n" +
		                    "   2.Afficher tous les ouvrages triée par Editeurs et Séries." + "\n" +
		                    "   3.Afficher tous les ouvrages de [nom]"                      + "\n"
		                  );

		System.out.print( "Saisissez le numero puis son eventuel parametre : " );
		this.methodeAppeler = Clavier.lireString();
	}

	public String getMethodeAppeler(){ return this.methodeAppeler; }
	}
