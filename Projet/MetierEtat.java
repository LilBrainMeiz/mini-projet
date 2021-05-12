/**
 * MetierEtat.java
 * classe fille de MetierBase
 * @author Bosquain  Maxence
 * @author Cléon     Benjamin
 * @author Loubeau   Enzo
 * @author Pesquerel Mathis
 * @author Vatres    Manon
 */

import java.util.List;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Collections;

public class MetierEtat extends MetierBase
{
	/**
	 * Retourne la liste d'ouvrages correspondant à l'auteur passé en paramètre.
	 * @param sAuteur Nom de l'auteur à rechercher.
	 * @return Liste des ouvrages de l'auteur.
	 */
	public List<Ouvrage> getOuvragesDe( String sAuteur )
	{
		List<Ouvrage> ensTempo   = new ArrayList<Ouvrage>();

		List<Ouvrage> ensOuvrages = super.getOuvrages();

        for(Ouvrage oOuvrage : ensOuvrages)
           if(oOuvrage.getDessinateur().equals(sAuteur) || oOuvrage.getScenariste().equals(sAuteur))
               ensTempo.add(oOuvrage);

		return ensTempo;
	}

	/**
	 * Retourne la liste des ouvrages triée par éditeur et par série.
	 * @return Liste d'ouvrages triée par éditeur et par série.
	 */
	public List<Ouvrage> getListeTrieeParEditeurEtSerie()
	{
		List<Ouvrage> ensOuvrages = super.getOuvrages();

		List<Ouvrage> ensOuvragesTries = ensOuvrages.stream().
		                           sorted(Comparator.comparing(Ouvrage::getEditeur).
		                           thenComparing(Ouvrage::getSerie)).
		                           collect(Collectors.toList());

		return ensOuvragesTries;
	}

	/**
	 * Retourne la liste triée par ordre naturel.
	 * @return Liste d'ouvrage triée par ordre naturel.
	 */
	public List<Ouvrage> getListeTrieeParOrdreNaturel()
	{
		List<Ouvrage> ensOuvrages = super.getOuvrages();

		Collections.sort(ensOuvrages);

		return ensOuvrages;
	}
}
