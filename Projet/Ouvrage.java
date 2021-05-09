public class Ouvrage 
{
    // ici, le préfixe is correspond à "int" "static" selon la notation hongroise.
    private static int isNombreOuvrage;
    private int        iNumeroOuvrage;

    private String  sTitre;
    private String  sEditeur;
    private String  sSerie;
    private String  sScenariste;
    private String  sDessinateur;
    private Integer iTome; // Ici le tome est en Integer car il est facultatif

    public Ouvrage(String titre, String editeur, String scenariste,
                   String serie, String dessinateur)
    {
        this(titre, editeur, serie, scenariste, dessinateur, null);
    }

    public Ouvrage(String titre, String editeur, String scenariste,
                   String dessinateur, Integer tome)
    {
        this(titre, editeur, null, scenariste, dessinateur, tome);
    }

    public Ouvrage(String titre, String editeur, String scenariste,
                   String dessinateur)
    {
        this(titre, editeur, null, scenariste, dessinateur, null);
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

    public String  getEditeur()    { return this.sEditeur; }
    public String  getDessinateur(){ return this.sDessinateur; }
    public String  getSerie()      { return this.sSerie; }
    public String  getScenariste() { return this.sScenariste; }
    public String  getTitre()      { return this.sTitre; }
    public Integer getTome()       { return this.iTome; }
}
