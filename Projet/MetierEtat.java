import javax.swing.*;

import java.awt.BorderLayout;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
