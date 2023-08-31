/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumemory;

import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Yahya
 */
public class Personnage {
    private String famille ;//famille de personnage
    private String Nom ;//nom du personnage
    private int valeur ;//la valeur du personnage
    private Image photo ;//la photo du personnage
    
    //constructeur par défaut
    public Personnage(){
        this.famille = "anonyme";
        this.Nom= "anonyme";
        this.valeur = 0;
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png")).getImage();
        
    }
    
    //constructeur avec paramètres 
    public Personnage(String f,String n,int v){
        this.famille=f;
        this.Nom=n;
        this.valeur=v;
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png")).getImage();
    }    
    
    //accesseur pour récupérer la famille du personnage
    public String getFamille(){
        return this.famille ;
    }
    
    //accesseur pour récupérer le nom du personnage
    public String getNom(){
        return this.Nom ;
    }
    
    //accesseur pour récupérer la valeur du personnage
    public int getValeur(){
        return this.valeur ;
    }
    
    //accesseur pour récupérer la photo du personnage
    public Image getPhoto() {
        return photo;
    }
    
    //accesseur an écriture pour positionner la famille du personnage
    public void setFamille(String famille) {
        this.famille = famille;
    }
    
    //accesseur an écriture pour positionner le nom du personnage
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    
    //accesseur an écriture pour positionner la valeur du personnage
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    //accesseur an écriture pour positionner la photo du personnage
    public void setPhoto(Image photo) {
        this.photo = photo;
    }
    
    //méthode qui restitue le personnage en chaine de caractères
    public String toString() {
        String s="";
        s+=this.Nom+" de la famille "+this.famille+", "+" valeur : "+this.valeur+"\n";
        return s;
    }
    
    //méthode qui affiche la photo du personnage dans le JButton jb 
    public void setImgBouton(JButton jb) {
    Image img = photo.getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
    jb.setIcon(new ImageIcon(img));
    }
    
    
    
    
}
