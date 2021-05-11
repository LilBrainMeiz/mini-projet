public class ControleurEtat
{
	private EtatCUI  ihm;
	private MetierEtat metier;

	public ControleurEtat()
	{
		this.ihm    = new EtatCUI();
		this.metier = new MetierEtat();

		System.out.println( ihm.getMethodeAppeler() );
		System.out.println( ihm.getMethodeAppeler().charAt(0) );
		switch( ihm.getMethodeAppeler().charAt(0) + "" )
		{
			case "1" -> this.metier.afficheTous();
			case "2" -> System.out.println("truc dur");
			case "3" -> {
							String[] coupe;
							coupe = new String[2];
							coupe = ihm.getMethodeAppeler().split( " " );

							this.metier.rechercheDansFichier( "\\|.*\\|.*"+coupe[1]+".*", "./sortie.txt" );
						}
		}
	}

	public static void main(String[] args)
	{
		new ControleurEtat();
	}
}
