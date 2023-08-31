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
 * @author Yahya
 */
public class LesJoueurs {
    
    private ArrayList<Joueur> lstJ ;//attribut de type ArrayList qui gère les joueurs
    
    //constructeur par défaut
    public LesJoueurs(){
        this.lstJ=new ArrayList<Joueur>();
    }
    
    //accesseur pour récupérer un joueur dans la liste
    public Joueur getJoueur(int i){
        if(i>=0 && i<this.lstJ.size())
            return this.lstJ.get(i) ;
        else
            return null;
    }
    
    //accesseur pour récupérer l'indice de joueur entrée dans le paramètre
    public int getIndiceJoueur(Joueur j){
        return this.lstJ.indexOf(j);
    }
    
    //accesseur pour récupérer le nombre des joueurs du liste
    public int getNbJoueurs(){
        return this.lstJ.size();
    }
    
    //méthode pour ajouter le joueur entrée dans le paramètre dans la liste
    public void ajouteJoueur(Joueur j){
        if(j!=null){
            if(j.getPseudo().equals("Jack") || j.getPseudo().equals("Anonyme") || j.getPseudo().equals("joueurDefaut" ) || j.getPseudo().equals("FanFBR" ))
            j.setPhoto(new ImageIcon(getClass().getResource("/img/"+j.getPseudo()+".png")));
            else
                if(j.getPseudo().equals("Lara") || j.getPseudo().equals("Jean") || j.getPseudo().equals("Amadeus"))
                    j.setPhoto(new ImageIcon(getClass().getResource("/img/"+j.getPseudo()+".jpg"))); 
            this.lstJ.add(j);
        }
    }
    
    //méthode qui cherche le joueur suivant son pseudo donnée en paramètre
    public Joueur rechJoueur(String j){
         Joueur je = new Joueur();
        for(int i=0;i<lstJ.size();i++)
        
            if(je.getPseudo().equals(j))
              lstJ.get(i);
            else
                return null;
        
        return je;
            
    }
    
    //méthode qui supprime le joueur donnée en paramètre de la liste 
    public void supprimeJoueur(Joueur j){
        for(int i=0;i<lstJ.size();i++)
            if(getJoueur(i).equals(j))
                this.lstJ.remove(i);
    }
    
    //méthode qui supprime tous les joueurs de la liste
    public void supprimeJoueurs(){
        this.lstJ.removeAll(this.lstJ);
    }
    
    //méthode qui restitue les joueurs de la liste en chaines de caractères
    public String toString(){
        String s="";
        for(int i=0;i<this.lstJ.size();i++)
            s+=i+"-"+getJoueur(i).toString();
        return s;
    }
    
    //méthode pour récupérer les joueurs gagnants
    public LesJoueurs getGagnants()
    { int max = 0;
        LesJoueurs gagnant = new LesJoueurs();
        for(int i=0;i<this.lstJ.size();i++){
            Joueur jc = lstJ.get(i);
            int jp =jc.getPaquet().getScore();
            
            if(jp==max){
                gagnant.ajouteJoueur(jc);
                
            }else if(jp>max){
                gagnant = new LesJoueurs();
                gagnant.ajouteJoueur(jc);
                max = jp;
                
            }
        }
        return gagnant;
        //En premier lieu on déclare une variable max de type int (entier)
        //puis on incrémente max par le score du premier joueur 
        //puis on ajoute une boucle qui va parcourir tous les joueurs 
        //et en ajoutant une condition if qui compare le score du joueur d'indice i et la variable max
        //si on trouve que le score du joueur est > au score affecté à la variable max
        //on affecte le score qui sera supérieur à max 
        //puis avec une instance et une deuxième boucle on classe les scores avec un ordre décroissant
    }
    
}



