import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import java.util.stream.Collectors;

public class IhmCUI
{
	private ControleurEtat ctrl;

	private Scanner        scInput;

	public IhmCUI(ControleurEtat ctrl)
	{
		this.ctrl = ctrl;
		this.scInput = new Scanner(System.in);
	}

	public void afficherMenu()
	{
		System.out.println( "Que souhaitez vous faire ?"                                    + "\n" +
							"   1.Afficher tous les ouvrages"                               + "\n" +
							"   2.Afficher tous les ouvrages triée par Editeurs et Séries." + "\n" +
							"   3.Afficher tous les ouvrages de [nom]"                      + "\n" +
							"   4.Quitter"                                                  + "\n"
						  );

		System.out.print( "Saisissez le numero puis son eventuel parametre : " );
	}

	public void afficherTriNaturel()
	{
		System.out.println(this.ctrl.getEnTete());

		List<Ouvrage> tmp = this.ctrl.getOuvrages();
		Collections.sort(tmp);

		for ( Ouvrage o : tmp )
			System.out.println(o);
	}

	public void afficherOuvrageDe()
    {
        List<Ouvrage> tmp = this.ctrl.getOuvrages();

        System.out.print( "Saisissez le nom de l'auteur que vous souhaitez : " );

        String nom = this.ctrl.getNomAuteur();

        System.out.println( this.ctrl.getEnTete() );

        for (Ouvrage o : tmp)
        {
            if( o.getDessinateur().equals( nom ) || o.getScenariste().equals( nom ) )
                System.out.println( o );
        }
    }

	public void afficherListeGroupee()
	{
		List<Ouvrage> list = this.ctrl.getOuvrages();

		List<Ouvrage> sort = list.stream().sorted(Comparator.comparing(Ouvrage::getSerie)).
							collect(Collectors.toList());

		sort = sort.stream().sorted(Comparator.comparing(Ouvrage::getEditeur)).
			   collect(Collectors.toList());
		
		System.out.println( this.ctrl.getEnTete() );
		
		for ( Ouvrage o : sort )System.out.println(o);
	}
}
