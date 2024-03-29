/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumemory;


import javax.swing.DefaultListModel;


/**
 *
 * @author Yahya
 */
public class BatailleDlg extends javax.swing.JDialog {

    private LesJoueurs lj;//pour pouvoir choisir l'adversaire dans la liste des joueurs
    private int indj;//pour connaitre le joueur courant
    private Joueur adversaire;//qui est séléctionnée dans la liste 
    private boolean ok;//annuler ou non
    private Bataille b;//action à réaliser
    
    //constructeur
    public BatailleDlg(java.awt.Frame parent, boolean modal,LesJoueurs lesJ,int indC) {
        super(parent, modal);//appel du constructeur de la classe JDialog
        initComponents();//création de l'interface(générée par l'IDE)
        //initialisation des attributs
        this.lj=lesJ;
        this.indj=indC;
        this.ok=false;
        this.b=null;//crée dans la suite du code
        Annuler.setText("Annuler");
        Annuler.setVisible(false);
        MessageJ.setText(this.lj.getJoueur(indj).getPseudo()+" va effectuer une bataille contre : ");//initialiser le JLabel
        initListeJ();//méthode qui remplit la JList
    }
    
    //accesseur qui renvoie l'instance du Bataille
    public Bataille getBataille(){
        return this.b;
    }
    
    //méthode qui remplit la JList
    public void initListeJ(){
        //on suppose que la JList en mode mono-sélection
        //remplit la JList avec les pseudos du joueurs(this.lj)
        DefaultListModel mod = new DefaultListModel();
        ListeJ.setModel(mod);
        for(int i=0;i<this.lj.getNbJoueurs();i++)
            mod.addElement(this.lj.getJoueur(i).getPseudo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        MessageJ = new javax.swing.JLabel();
        Joueur = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeJ = new javax.swing.JList<>();
        Adversaire = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        InfosCarte1 = new javax.swing.JTextArea();
        Carte1 = new javax.swing.JButton();
        Carte2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        InfosCarte2 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        Vainqueur = new javax.swing.JLabel();
        Annuler = new javax.swing.JButton();
        Démarrer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.BorderLayout());

        MessageJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(MessageJ, java.awt.BorderLayout.CENTER);
        jPanel1.add(Joueur, java.awt.BorderLayout.PAGE_END);

        jPanel6.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        ListeJ.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ListeJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeJMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListeJ);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        Adversaire.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(Adversaire, java.awt.BorderLayout.PAGE_END);

        jPanel6.add(jPanel2);

        getContentPane().add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        InfosCarte1.setColumns(20);
        InfosCarte1.setRows(5);
        jScrollPane4.setViewportView(InfosCarte1);

        jPanel7.add(jScrollPane4);
        jPanel7.add(Carte1);
        jPanel7.add(Carte2);

        InfosCarte2.setColumns(20);
        InfosCarte2.setRows(5);
        jScrollPane5.setViewportView(InfosCarte2);

        jPanel7.add(jScrollPane5);

        getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel8.setLayout(new java.awt.GridLayout(1, 3));
        jPanel8.add(Vainqueur);

        Annuler.setText("Annuler/Fermer");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel8.add(Annuler);

        Démarrer.setText("Démarrer");
        Démarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DémarrerActionPerformed(evt);
            }
        });
        jPanel8.add(Démarrer);

        getContentPane().add(jPanel8, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //gestionnaire du clic sur un élément du JList
    private void ListeJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeJMouseClicked
        int i=ListeJ.getSelectedIndex();//on récupère l'indice de l'élément séléctionnée
        if(i!=-1)  //on teste si ce n'est pas le joueur courante
        {
            if(i==indj)
                //si le joueur séléctionnée est le courant 
            MessageJ.setText("Sélectionner un autre joueur !");
            else
            {   Joueur jc=this.lj.getJoueur(indj);
                this.adversaire=this.lj.getJoueur(i);
                this.b=new Bataille(jc,this.adversaire);
                //interface
                Annuler.setVisible(true);
                Joueur.setText(jc.getPseudo());
                Adversaire.setText(this.adversaire.getPseudo());
                InfosCarte1.append(" paquet de "+jc.getPseudo()+"\n"+jc.getPaquet().toString());
                InfosCarte2.append(" paquet de "+this.adversaire.getPseudo()+"\n"+this.adversaire.getPaquet().toString());
            }
        }
    }//GEN-LAST:event_ListeJMouseClicked
    //gestionnaire du clic sur le bouton Démarrer
    private void DémarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DémarrerActionPerformed
        int i=ListeJ.getSelectedIndex();
        Joueur jo = this.lj.getJoueur(this.indj);
        this.adversaire=this.lj.getJoueur(i);
        this.b=new Bataille(jo,this.adversaire);
    if(jo!=null && this.adversaire!=null)
    {//affichage d'informations dans les zones d'édition
        InfosCarte1.append(jo.getPseudo()+" joue "+jo.getPaquet().getPerso(0));
        InfosCarte2.append(this.adversaire.getPseudo()+" joue "+this.adversaire.getPaquet().getPerso(0));
    }
    //on execute la bataille
    int res =this.b.execute();//retourne 0,1 ou 2
    switch(res){
        case 1:{InfosCarte1.append(jo.getPseudo()+" gagne \n ");
               InfosCarte2.append(this.adversaire.getPseudo()+" perd \n ");
               Vainqueur.setText(jo.getPseudo());
               break;
        }
        case 2:{InfosCarte1.append(jo.getPseudo()+" perd \n ");
                InfosCarte2.append(this.adversaire.getPseudo()+" gagne \n ");
                Vainqueur.setText(this.adversaire.getPseudo());
                break;
        }
        case 0:{InfosCarte1.append(" aucun gagnant ");
                InfosCarte2.append(" aucun gagnant ");
                break;
        }
        
    }
    //on affiche les cartes joueurs
    InfosCarte1.append(jo.getPaquet().toString());
    InfosCarte2.append(this.adversaire.getPaquet().toString());
    LesPersonnages pjo=jo.getPaquet();
    LesPersonnages pad=this.adversaire.getPaquet();
      if(pjo.getTaille()==0 && pad.getTaille()>0)
      {
          Vainqueur.setText(this.adversaire.getPseudo()+" a gagné ");
          Démarrer.setEnabled(false);//non cliquable
          Annuler.setVisible(true);
          Annuler.setText(" Fermer ");
      }
      else 
          if(pjo.getTaille()>0 && pad.getTaille()==0)
          {
              Vainqueur.setText(jo.getPseudo()+" a gagné ");
              Démarrer.setEnabled(false);//non cliquable
              Annuler.setVisible(true);
              Annuler.setText(" Fermer ");
          }
          else  //il reste des cartes,on les affiche
          {   //l’affichage de la photo du personnage suivant du paquet dechaque joueur sur les boutons
              pjo.getPerso(0).setImgBouton(Carte1);
              pad.getPerso(0).setImgBouton(Carte2);
          
          }
      this.ok=true;
    
    }//GEN-LAST:event_DémarrerActionPerformed
    //gestionnaire du clic sur le bouton Annuler
    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.ok=false;
        if (Annuler.getText().equals("Annuler"))
        this.b.setDeroulement(" Bataille interrompue en cours de partie ");
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatailleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatailleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatailleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatailleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BatailleDlg dialog = new BatailleDlg(new javax.swing.JFrame(), true,new LesJoueurs(),0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Adversaire;
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Carte1;
    private javax.swing.JButton Carte2;
    private javax.swing.JButton Démarrer;
    private javax.swing.JTextArea InfosCarte1;
    private javax.swing.JTextArea InfosCarte2;
    private javax.swing.JLabel Joueur;
    private javax.swing.JList<String> ListeJ;
    private javax.swing.JLabel MessageJ;
    private javax.swing.JLabel Vainqueur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
