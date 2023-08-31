/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeumemory;

/**
 *
 * @author moham
 */
public class Bataille extends Action {
    //attribut
    private Joueur adversaire ;//bataille entre le joueur j (de la classe Action) et adversaire
    
    //constructeur avec paramètres
    public Bataille(Joueur jc,Joueur ja){
        super(jc,"Bataille");//appel du constructeur avec paramètres de la classe Action 
        this.adversaire=ja;//initialisation de l'attribut adversaire
    }
    
    //accesseurs en lecture pour récupérer l'adversaire
    public Joueur getAdversaire(){
        return this.adversaire;
    }
    
    //méthode qui effectue la bataille entre deux joueurs
    public int execute(){
        int res =-1;
        Personnage c1,c2;
        if(this.getJoueurCourant().getPaquet().getTaille()>0 && this.adversaire.getPaquet().getTaille()>0)
        {
            res=-1;
            c1=this.getJoueurCourant().getPaquet().getPerso(0);
            c2=this.adversaire.getPaquet().getPerso(0);
            this.getJoueurCourant().getPaquet().retirePerso(c1);
            this.adversaire.getPaquet().retirePerso(c2);
            //on teste les valeurs des cartes
            if(c1.getValeur()==c2.getValeur())
            {
                res=0;
                this.getJoueurCourant().getPaquet().ajoutePerso(c1);
                this.adversaire.getPaquet().ajoutePerso(c2);
            }
            else
                if(c1.getValeur()>c2.getValeur())
                {
                    res=1;
                    this.getJoueurCourant().getPaquet().ajoutePerso(c1);
                    this.getJoueurCourant().getPaquet().ajoutePerso(c2);
                }
            else //l'adversaire gagne la carte
                {
                    res=2;
                    this.adversaire.getPaquet().ajoutePerso(c1);
                    this.adversaire.getPaquet().ajoutePerso(c2);
                }
            //on teste si un des deux joueurs n'a plus de carte
            if(this.getJoueurCourant().getPaquet().getTaille()==0 || this.adversaire.getPaquet().getTaille()==0)
            {
                String s="";
                s+="Bataille :"+this.getJoueurCourant().getPseudo();
                s+=" contre :"+this.adversaire.getPseudo()+"\n";
                if(this.getJoueurCourant().getPaquet().getTaille()>0)
                { s+="gagnée! \n";
                     this.setDeroulement(s);}
                else
                    this.setDeroulement(s);
                
            }
            
        }
        return res;
    }
}
