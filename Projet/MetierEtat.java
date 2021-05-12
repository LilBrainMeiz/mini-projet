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

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Collections;

public class MetierEtat extends MetierBase
{
    public List<Ouvrage> getOuvragesDe( String sAuteur )
    {
        List<Ouvrage> ensTempo   = new ArrayList<Ouvrage>();

        List<Ouvrage> ensOuvrages = super.getOuvrages();

        for(Ouvrage oOuvrage : ensOuvrages)
        {
           if(oOuvrage.getDessinateur().equals(sAuteur) || oOuvrage.getScenariste().equals(sAuteur))
           {
               ensTempo.add(oOuvrage);
           }
        }

        return ensTempo;
    }

    public List<Ouvrage> getListeTrieeParEditeurEtSerie()
    {
        List<Ouvrage> ensOuvrages = super.getOuvrages();

        List<Ouvrage> listeTriee = ensOuvrages.stream().
                                   sorted(Comparator.comparing(Ouvrage::getEditeur).
                                   thenComparing(Ouvrage::getSerie)).
                                   collect(Collectors.toList());

        return listeTriee;
    }

    public List<Ouvrage> getListeTrieeParOrdreNaturel()
    {
        List<Ouvrage> ensOuvrages = super.getOuvrages();

        Collections.sort(ensOuvrages);

        return ensOuvrages;
    }
}
