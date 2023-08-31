/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeumemory;

/**
 *
 * @author moham
 */
public abstract class Action {
    //attributs
    private Joueur j;//déclaration de la variable j de type Joueur qui sert à identifier le joueur courant
    private String descrptif;//chaine de caractère qui va nous servir à connaitre les informations concernant le type d'action(bataille,transfert)
    private String deroulement;//sera rempli avec le resultat de l'action
    
    //constructeur par défaut
    public Action(){
        this.j=null;
        this.descrptif="";
        this.deroulement="";
    }
    
    //constructeur avec paramètres
    public Action(Joueur jc,String d){
        this.j=jc;
        this.descrptif=d;
        this.deroulement="";
    }
    
    //accesseur pour récupérer le joueur courant qui est l'attribut j
    public Joueur getJoueurCourant() {
        return j;
    }
    
    //accesseur en écriture pour positionner le joueur courant en j
    public void setJoueurCourant(Joueur j) {
        this.j = j;
    }
    
    //accesseur pour récupérer le descriptif d'action
    public String getDescrptif() {
        return descrptif;
    }
    
    //accesseur en écriture pour positionner le descriptif 
    public void setDescrptif(String descrptif) {
        this.descrptif = descrptif;
    }

    //accesseur pour récupérer le déroulement du jeu
    public String getDeroulement() {
        return deroulement;
    }

    //accesseur en écriture pour positionner le deroulement du jeu
    public void setDeroulement(String deroulement) {
        this.deroulement = deroulement;
    }
    
    //méthode qui restitue les inforamtion de l'action en chaine de caractères
    public String toString(){
        String s="";
        s+="Action effectuée par" +this.j.getPseudo()+"\n" ;
        s+="Descriptif :"+this.descrptif+"\n";
        s+="Deroulement :"+this.deroulement+"\n";
        return s;
    }
    
    //méthode abstraite qui sera surcharger dans les sous-classes
    public abstract int execute();
    
}
