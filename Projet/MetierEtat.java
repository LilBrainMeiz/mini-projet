import javax.swing.*;

import java.awt.BorderLayout;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.FileInputStream;


public class MetierEtat
{
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
}
