/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeumemory;

/**
 *
 * @author moham
 */
public class PlateauJeu {
    private int tab[][];//tableau de deux dimensions
    private int nbp; // nombre de personnages sur le plateau qui diminue au cours du jeu
    private int nblig;//nombre de lignes
    private int nbcol;//nombre de colonnes
    
    //constructeur avec en paramètre le nombre de personnages
    public PlateauJeu(int n)
    {   this.nbp=n;
        this.nblig=(int)(Math.sqrt(nbp*2)) ;
        this.nbcol=nbp*2/nblig;
        this.tab=new int [this.nblig][this.nbcol];
        initPlateauJeu();
    }
    
    //constructeur par défaut
    public PlateauJeu()
    { this(4);
    }
    
    //accesseurs en lecture
    public int getNblig() { return this.nblig; }
    
    public int getNbcol() { return this.nbcol; }
    
    public int getNbp() { return this.nbp; }
    
    public int getCase(int l, int c) { return tab[l][c]; }
    
    public int getNbc() { return this.nblig*this.nbcol/2; }
    
    //méthode qui mélange le plateau du jeu
    public void initPlateauJeu()
    { int k=0;
      for(int i=0; i<this.nblig; i++)
         for(int j=0; j<this.nbcol; j++)
         {
             if(nbp!=0)
         tab[i][j]=(k++)%this.nbp;
         }
      melange();
    }
    
    //méthode qui met les cases du position donnée en paramètre en mode déja jouée
    public void invalide(int l1, int c1, int l2, int c2)
    {
        tab[l1][c1]=-1;
        tab[l2][c2]=-1;
        nbp--;
    }
    
    //méthode qui mélange le plateau du jeu
    public void melange()
    {   
       for(int i=1;i<=1000;i++)
       {      int l1=(int)(Math.random()*nblig);
              int l2=(int)(Math.random()*nblig);
              int c1=(int)(Math.random()*nbcol);
              int c2=(int)(Math.random()*nbcol);
              int temp = this.tab[l1][c1];
                         this.tab[l1][c1]=tab[l2][c2];// pour changer  les cartes
                         tab[l2][c2]=temp;
             }
       
    }
    
    //méthode pour savoir si le nombre de personnages du plateau est vide
    public boolean jeuVide()
    { 
        return this.nbp==0;
    }
    
    //méthode pour savoir si la case de position donnée en paramètre n'a pas encore jouée
    public boolean estValide(int l, int c)
    { 
        return tab[l][c]!=-1;
    }
    
    //méthode qui mit fin au jeu
    public void termineJeu()
    {
        for(int i=0;i<this.nblig;i++)
            for(int j=0;j<this.nbcol;j++)
                tab[i][j]=-1;
        this.nbp=0;
    }
}
