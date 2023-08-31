/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumemory;


import javax.swing.ImageIcon;

/**
 *
 * @author mc485207
 */
public class Joueur {
    private String pseudo ;//pseudo de joueur 
    private String nomFamille;//familgle du joueur
    private LesPersonnages paquet ;//paquet de personnages de joueur
    private ImageIcon photo ;//photo de joueur
    
    //constructeur par défaut
    public Joueur(){
        this.pseudo="anonyme";
        this.nomFamille="anonyme";
        this.paquet = new LesPersonnages();
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));
    }
    
    //constructeur avec paramètres
    public Joueur(String pseudo, String nomFamille) {
        this.pseudo = pseudo;
        this.nomFamille = nomFamille;
        this.paquet = new LesPersonnages();
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));
    }
    
    //accesseur pour récupérer le pseudo du joueur
    public String getPseudo() {
        return this.pseudo;
    }

    //accesseur pour récupérer la famille du joueur
    public String getNomFamille() {
        return this.nomFamille;
    }
 
    //accesseur pour récupérer le paquet de personnages du joueur
    public LesPersonnages getPaquet() {
        return this.paquet;
    }

    //accesseur pour récupérer la photo du joueur
    public ImageIcon getPhoto() {
        return this.photo;
    }
    
    //accesseur en écriture pour positionner la photo du joueur
    public void setPhoto(ImageIcon p) {
        this.photo = p;
    }
    
    //accesseur pour récupérer le score du paquet de personnages du joueur
    public int getScore(){
       return this.paquet.getScore();
    }
    
    
    //méthode qui restitue le joueur en chaines de caractères
    public String toString(){
        return " Joueur "+this.pseudo+"\n"+" Famille préférée "+this.nomFamille+"\n"+" en possession des personnages : \n "+this.paquet.toString()+" \n "+" score : "+getScore()+" \n ";
    }
    
    //méthode qui ajoute le personnage p au paquet du joueur
    public void ajoutePersoPaquet(Personnage p)
    { 
        p.setPhoto(new ImageIcon(getClass().getResource("/img/"+p.getNom()+".jpg")).getImage());
        this.paquet.ajoutePerso(p);
        
    }
    
}
