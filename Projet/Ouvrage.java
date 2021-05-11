public class Ouvrage 
{
    // ici, le préfixe is correspond à "int" "static" selon la notation hongroise.
    private static int isNombreOuvrage;
    private int        iNumeroOuvrage;

    private String     sTitre;
    private String     sEditeur;
    private String     sSerie;
    private String     sScenariste;
    private String     sDessinateur;
    private Integer    iTome; // Ici le tome est en Integer car il est facultatif

    public static Ouvrage creerOuvrage(String titre, String editeur,
                                       String serie, String scenariste,
                                       String dessinateur, Integer tome)
    {
        // Permet de ne pas tolérer un autre argument que serie ou tome
        // en null;
        if(titre       == null || titre      .equals("") ||
           editeur     == null || editeur    .equals("") ||
           scenariste  == null || scenariste .equals("") ||
           dessinateur == null || dessinateur.equals("")  )
            return null;

        // Permet de ne pas ajouter d'ouvrage si il y en a déjà 10000
        if(Ouvrage.isNombreOuvrage == 10000)return null;

        return new Ouvrage(titre, editeur, serie, scenariste, dessinateur,
                           tome);
    }

    private Ouvrage(String titre, String editeur, String serie,
                   String scenariste, String dessinateur, Integer tome)
    {
        this.iNumeroOuvrage = ++Ouvrage.isNombreOuvrage;

        this.sTitre         = titre;
        this.sEditeur       = editeur;
        this.sSerie         = serie;
        this.sScenariste    = scenariste;
        this.sDessinateur   = dessinateur;
        this.iTome          = tome;
    }

        public String  getEditeur    (){ return this.sEditeur;     }
    public String  getDessinateur(){ return this.sDessinateur; }
    public String  getSerie      (){ return this.sSerie;       }
    public String  getScenariste (){ return this.sScenariste;  }
    public String  getTitre      (){ return this.sTitre;       }
    public Integer getTome       (){ return this.iTome;        }

    public String toString()
    {
        return "| " + String.format("%-30s", this.getTitre      ()) + "| " +
                      String.format("%-30s", this.getScenariste ()) + "| " +
                      String.format("%-30s", this.getDessinateur()) + "| " + 
                      String.format("%-30s", this.getEditeur    ()) + "| " +
                      String.format("%-30s", this.getSerie      ()) + "| " + 
                      String.format("%-30s", this.getTome       ()) + "|";
    }

    public int compareTo(Ouvrage autre)
    {
        int iSize = autre.sTitre.length();
        int iVal;

        if ( this.sTitre.length() < iSize )iSize = this.sTitre.length();

        for(int i=0;i<iSize;i++)
        {
            iVal = this.sTitre.charAt(i) - autre.sTitre.charAt(i);
            if ( iVal != 0 )return iVal; 
        }

        return 0;
    }

    public boolean equals(Ouvrage autre)
    {
        return this.toString().equals(autre.toString());
    }
}
