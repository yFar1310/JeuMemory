/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumemory;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author mc485207
 */
public class LesPersonnages {
    private ArrayList<Personnage> persos ;//attribut de type ArrayList qui gère les personnages
    
    //constructeur par défaut
    public LesPersonnages(){
        this.persos = new ArrayList<Personnage>();
    }
    
    //constructeur standard
    public LesPersonnages(int nc ) {
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
            }
            if (nc >= 10){
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            }
            if (nc >= 18){
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            }
            if (nc == 32){
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("épiques", "rex", 30));
            ajoutePerso(new Personnage("épiques", "shadow-ops", 40));
}
    }
    
    //accesseur pour récupérer la taille du liste
    public int getTaille() {
        return this.persos.size();
    }
    
    //accesseur pour récupérer un personnage dans la liste
    public Personnage getPerso(int i)
    {
        if(i>=0 && i<this.persos.size())
            return this.persos.get(i) ;
        else
            return null;
    }
    
    //accesseur pour récupérer le score des personnages
    public int getScore()
    { int s = 0;
    for(int i=0; i<getTaille(); i++)
    s+=getPerso(i).getValeur();
    return s;
    }
    
    //méthode qui supprime tous les personnages du liste
    public void retirePersos()
    { persos.clear();
    }
    
    //méthode pour ajouter le personnage( entrée dans le paramètre )dans la liste
    public void ajoutePerso(Personnage p){
        if(p!=null){
            p.setPhoto(new ImageIcon(getClass().getResource("/img/"+p.getNom()+".jpg")).getImage());
            this.persos.add(p);
        }
    }
    
    //méthode pour ajouter les personnages( entrée dans le paramètre )dans la liste
    public void ajoutePersos(LesPersonnages lp){
        for(int i=0;i<lp.getTaille();i++)
        {Personnage p = lp.getPerso(i);
         p.setPhoto(new ImageIcon(getClass().getResource("/img/"+p.getNom()+".jpg")).getImage());
         this.persos.add(p);
        }
    }
    
    //méthode pour supprimer le personnage entrée dans le paramètre de la liste
    public void retirePerso(Personnage p){
        for(int i=0;i<getTaille();i++)
            if(getPerso(i).equals(p))
                this.persos.remove(i);
    }
    
    //méthode pour supprimer le personnage de la famille nf de la liste
    public void retirePersosFamille(String nf){
        LesPersonnages lp=new LesPersonnages();
        for(int i=0;i<getTaille();i++){
            Personnage p = persos.get(i);
            if(!p.getFamille().equals(nf)){
                lp.ajoutePerso(p);
            }
        }
        this.persos = lp.persos;
    }
    
    //méthode pour récupérer le personnage de la famille nf 
    public LesPersonnages getCartesFamille(String nf){
        LesPersonnages lpf = new LesPersonnages();
        for(int i=0;i<getTaille();i++)
        {
            if(getPerso(i).getFamille().equals(nf))
              lpf.ajoutePerso(getPerso(i));  
              
        }
        return lpf;
    }
    
    //méthode qui restitue les personnages de la liste en chaines de caractères
    public String toString(){
        String s="";
        for(int i=0;i<this.persos.size();i++)
            s+=i+"-"+getPerso(i).toString();
        return s;
    }
    
    //méthode qui renvoie une liste de famille des personnages
    public ArrayList<String> getFamilles()
        { ArrayList<String> lst = new ArrayList<String>();
        for (int j=0; j<this.persos.size(); j++)
        { Personnage p = this.persos.get(j);
        boolean trouve = false;
        for (int i=0; i< lst.size(); i++)
        if (lst.get(i).equals(p.getFamille()))
        trouve = true;
        if (!trouve) lst.add(p.getFamille());
        }
        return lst; 
        }
    
    } 
    

