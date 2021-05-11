/*
 * MetierBase.java
 * classe mère de MetierSaisie et MetierEtat
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */

import java.util.Scanner;
import java.io.FileInputStream;


public class MetierEtat extends MetierBase
{
	public void rechercheDansFichier( String recherche, String chemin )
	{
		System.out.println( super.enTete() );
		try
		{
			Scanner sc = new Scanner( new FileInputStream( chemin ) );

			while( sc.hasNextLine() )
			{
				String tmp;
				tmp = sc.nextLine();
				if( tmp.matches( recherche ) )
				{
					System.out.println( tmp );
				}
			}

			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}
}
