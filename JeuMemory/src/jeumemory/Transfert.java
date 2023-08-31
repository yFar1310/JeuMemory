/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeumemory;

/**
 *
 * @author moham
 */
public class Transfert extends Action {
        private Joueur cible;//joueur séléctionée
        private String fp; //famille de la carte sélectionnée
        private LesPersonnages cartesTransferees; // cartes transférées
        
        //constructeur avec paramètres
        public Transfert(Joueur sc, Joueur c, String f) {
        super(sc, "Transfert de cartes");//appel du constructeur avec paramètres de la classe Action 
        //initialisation des attributs
        this.cible = c;
        this.fp=f;
        this.cartesTransferees= new LesPersonnages();
        }
        
        //accesseur pour récupérer les cartes transferées entre le joueur courant et le joueur cible
        public LesPersonnages getCartesTransferees() {
                return cartesTransferees;
        }
        
        //accesseur pour récupérer le joueur cible
        public Joueur getJoueurCible(){ return this.cible; }
        
        //méthode qui sert à effectuer le transfert entre le joueur courant et le joueur cible
        public int execute() { 
           int res;
           if(this.fp!=null)
           {  
               this.cartesTransferees=this.cible.getPaquet().getCartesFamille(fp);
               this.cible.getPaquet().retirePersosFamille(this.fp);
               this.getJoueurCourant().getPaquet().ajoutePersos(cartesTransferees);
               this.setDeroulement(this.getJoueurCourant().getPseudo()+" a pris les cartes de la famille "+fp+" à "+this.cible.getPseudo()+"\n");
               res=cartesTransferees.getTaille();
           }
           else
               res=0;
           return res;
       }
       

}
