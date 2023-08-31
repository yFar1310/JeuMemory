/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeumemory;

/**
 *
 * @author moham
 */
public class Jeu {
    //attributs
    private LesPersonnages lesPers;//personnages du jeu
    private LesJoueurs lesJ;//joueurs du jeu
    private PlateauJeu monP;//le plateau du jeu (état courant)
    private Action act;//action à réaliser
    private int indC;//indice du joueur courant

    //constructeur standard
    public Jeu(LesPersonnages lp,LesJoueurs lj,int nbc){
        this.lesPers=lp;
        this.lesJ=lj;
        this.indC=0;
        this.monP=new PlateauJeu(nbc);
        this.act=null;
    }
    
    //accesseur pour récupérer les personnages du jeu
    public LesPersonnages getPersonnages() {
        return lesPers;
    }
    
    //accesseur pour récupérer les joueurs du jeu
    public LesJoueurs getJoueurs() {
        return lesJ;
    }
    
    //accesseur pour récupérer le plateau du jeu
    public PlateauJeu getPlateau() {
        return monP;
    }
    
    //accesseur pour récupérer le plateau du jeu
    public Action getAct() {
        return act;
    }
    
    //acceseur pour récupérer l'indice du joueur courant
    public int getIndC() {
        return indC;
    }
    
    //accesseur pour récupérer le joueur courantt
    public Joueur getJoueurCourant(){
        return this.lesJ.getJoueur(indC);
    }
    
    //accesseur pour récupérer l'indice suivant de l'indice donnée en paramètre
    public int getIndSuivant(int ic){
        return (ic+1)%this.lesJ.getNbJoueurs();//quand on est au dernier joueur, on repart au 1er%=module
    }
    
    //accesseur en écriture pour positionner le joueur courant suivant son indice
    public void setJoueurCourant(int n){
        this.indC=n;
    }
    
    //méthode boolean pour savoir si le plateau est vide
    public boolean finJeu(){
        return this.monP.jeuVide();
    }
    
    //méthode pour gérer un tour de jeu lorsque le joueur courant a retourné deux cartes identiques
    public int traiterTour(Joueur jo,int s){
        int bns=-1;
        Personnage pers=this.lesPers.getPerso(s);
        jo.getPaquet().ajoutePerso(pers);
        String f =pers.getFamille();
        int nbf=this.lesPers.getCartesFamille(f).getTaille();
        int nbj=jo.getPaquet().getCartesFamille(f).getTaille();
        if(nbf==nbj){
            if(f.equals(jo.getNomFamille())){
                bns=0;
                this.monP.termineJeu();
            }
            else
                for(int i=0;i<this.lesJ.getNbJoueurs();i++)
                if(this.lesJ.getJoueur(i).getPaquet().getTaille()!=0){
                    if(f.equals("rares") || f.equals("communs"))
                        bns=1;
            else
                        if(f.equals("epiques") || f.equals("legendaires"))
                            bns=2;
                }
            
        }
        return bns;
    }











}