import java.util.ArrayList;

public class CryptoMarche {

    private ArrayList<Portefeuille> portefeuilles;
    private static CryptoMarche marche;

    private CryptoMarche(){
        this.portefeuilles = new ArrayList<Portefeuille>();
    }

    public static CryptoMarche getInstance(){
        if(CryptoMarche.marche == null){ CryptoMarche.marche = new CryptoMarche();}
		return CryptoMarche.marche;
    }

    public void ajouter(Portefeuille p){
        this.portefeuilles.add(p);
    }

    /**
     * Cette fonction recherche sur le marché tous les portefeuilles 
     * du propriétaire et calcule son capital en euros. 
     * @param proprietare
     * @return capital en euros du propriétare.
     */
    public double capitalEnEuros(String proprietaire)
    {
        double rep;
        rep = 0;
        if ( this.portefeuilles.size() != 0 )
        {
            for ( int cpt=0; cpt < this.portefeuilles.size(); cpt++ )
            {
                rep = rep + this.portefeuilles.get(cpt).valeurEnEuros();
            }
            return rep;
        }
        return 0;
    }

    /**
     * Cette fonction recherche sur le marché tous les portefeuilles 
     * d'un type de devise et calcule le volume total de capital de 
     * cette devise sur le marché 
     * @param monnaie
     * @return capital total en circulation de la CryptoMonnaie (en euros).
     */
    public double capitalMonneaie(CryptoMonnaie monnaie)
    {
        double rep;
        rep = 0;
        if ( this.portefeuilles.size() != 0 )
        {
            for ( int cpt=0; cpt < this.portefeuilles.size(); cpt++ )
            {
                if ( this.portefeuilles.get(cpt).getMonnaie() == monnaie )
                {
                    rep = rep + this.portefeuilles.get(cpt).getMontant();
                }
            }
            return rep;
        }
        return 0;
    }

    @Override
    public String toString() {
        String ret = "";
        for(Portefeuille p : this.portefeuilles){
            ret += p.toString() + "\n";
        }
        return ret;
    }

}