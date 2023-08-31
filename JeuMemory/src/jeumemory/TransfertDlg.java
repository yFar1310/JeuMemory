/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package jeumemory;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Yahya
 */
public class TransfertDlg extends javax.swing.JDialog {

    private LesJoueurs lj; //collection des joueurs, pour initialiser la liste déroulante avec les pseudos des joueurs
    private int indj; //indice joueur courant
    private Transfert tc;//attribut pour gérer le transfert des cartes
    private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
    private int indjs; //indice du joueur sélectionné dans la liste déroulante
    private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné
  
    public TransfertDlg(java.awt.Frame parent, boolean modal,LesJoueurs lj,int indj) {
        super(parent, modal);//appel du constructeur de la classe JDialog
        initComponents();//création de l'interface(générée par l'IDE)
        //initialision des attributs
        this.lj = lj;
        this.indj = indj ;
        this.ok=false;
        this.fs=null;
        this.tc=null;
        this.indjs = 0;
        initCombo(); // méthode pour remplir la liste déroulante
        Message.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");
        Message2.setText("Il peut prendre toutes les cartes d'une meme famille d'un joueur");
        Infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet()+"\n");
    }
    
    //accesseur qui renvoie l'instance du Transfert 
    public Transfert getTransfert() {
        return tc;
    }
    
    //accesseur qui renvoie l'indicateur pour savoir le transfert a bien été effectué.
    public boolean isOk() {
        return ok;
    }
    
    //méthode qui remplit la liste déroulante
    public void initCombo(){
        for(int i=0;i<this.lj.getNbJoueurs();i++)
            ComboJoueurs.addItem(this.lj.getJoueur(i).getPseudo());
    }
    
    //méthode qui initialise le panneau gauche avec un nombre des boutons selon les personnages du joueur séléctionnée
    public void initPanneau(){
        PanneauG.removeAll();
        this.repaint();
        LesPersonnages lcs = lj.getJoueur(indjs).getPaquet();
        int t = lcs.getTaille();
        int n = 1+(t-1)/4;
        PanneauG.setLayout(new java.awt.GridLayout(4, n));
        for(int i = 0; i < t; i++) {
        JButton bt1 = new JButton();
        bt1.setName(lcs.getPerso(i).getFamille());
        bt1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
        boutonActionPerformed(evt);
        }
        });
        PanneauG.add(bt1);
        }
        this.pack();
 }

    //méthode qui affiche les images des personnages de joueur séléctionée dans les boutons 
    private void affichePanneau()
    { LesPersonnages lcs = lj.getJoueur(indjs).getPaquet();
    int t = lcs.getTaille();
    for (int i=0; i<t; i++)
    { JButton bt = (JButton) PanneauG.getComponent(i);
    Personnage p = lcs.getPerso(i);
    p.setImgBouton(bt);
    }
    }

    //Le gestionnaire d’évènement du clic sur un des boutons du panneau gauche
    private void boutonActionPerformed(ActionEvent evt)
    {   LesPersonnages lp = lj.getJoueur(indjs).getPaquet();//déclarer une instance de LesPersonnages et on affecte à sa valeur les personnages du joueur séléctionnée
        int t = lp.getTaille();//on récupère la taille du paquet du joueur séléctionnée
        JButton bt=(JButton) evt.getSource();//on récupère le bouton séléctionnée
        this.fs = bt.getName();//on affecte à l'attribut fs de la classe le name du bouton
        //boucle qui parcourit les boutons
        for(int i = 0; i < t; i++) {
        JButton b = (JButton)(PanneauG.getComponent(i));
        if (b.getName().equals(fs))//si le nom du bouton égale au famille de personnage séléctionnée 
        b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));//encadre en rouge les personnages de la même famille
        else 
            b.setBorder(null);
        }
        LesPersonnages lps = lp.getCartesFamille(fs);//déclarer une instance de LesPersonnages et on affecte à sa valeur les personnages de la famillle fs
        Infos.append("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps+"\n");//affiche dans la zone d’édition nommée « Infos » en bas au milieu les informations sur les personnages de cette famille.
        Infos.append("Action effectuée par "+this.lj.getJoueur(this.indj).getPseudo()+" : Transfert des cartes ");//affiche dans la zone d'édition le pseudo du joueur courant qui a effectué l'action de transfert
        }
    
    //méthode qui permet de créer dans le panneau jp donné en paramètres, autant de boutons qu’il y a de personnages dans l’instance lc
    public void creePanneau(JPanel jp, LesPersonnages lc){
        jp.removeAll();//supprimer le contenu du panneau jp
        this.repaint();//méthode pour forcer le dessin d'un composant
        int t = lc.getTaille();//récuperation de la taille des personnages lc
        int n = 1+(t-1)/4;
        jp.setLayout(new java.awt.GridLayout(4, n));
        int buttonSize=this.getWidth()/(3*n);//taille du bouton
        //boucle pour crée des boutons
        for(int i=0;i<t;i++){
            JButton jb=new JButton();
            jb.setPreferredSize(new Dimension(buttonSize,buttonSize));
            jp.add(jb);
        }
        this.pack();
    }
    
    //permet de dessiner sur les boutons déjà créés dans le panneau jp, les photos des personnages de lc
    public void dessinePanneau(JPanel jp, LesPersonnages lc){
        for(int i=0;i<lc.getTaille();i++){
            JButton jb=(JButton) jp.getComponent(i);
            lc.getPerso(i).setImgBouton(jb);
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauG = new javax.swing.JPanel();
        PanneauC = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        Message2 = new javax.swing.JLabel();
        L = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ComboJoueurs = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Infos = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        Transfert = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();
        PanneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));
        getContentPane().add(PanneauG);

        PanneauC.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setLayout(new java.awt.GridLayout(3, 1));
        jPanel1.add(Message);
        jPanel1.add(Message2);

        L.setText("Sélectionnez le joueur dont vous voulez voir les cartes :");
        jPanel1.add(L);

        PanneauC.add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(3, 1));

        ComboJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJoueursActionPerformed(evt);
            }
        });
        jPanel2.add(ComboJoueurs);

        Infos.setColumns(20);
        Infos.setRows(5);
        jScrollPane1.setViewportView(Infos);

        jPanel2.add(jScrollPane1);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        Transfert.setText("Transfert");
        Transfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransfertActionPerformed(evt);
            }
        });
        jPanel3.add(Transfert);

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        jPanel3.add(Fermer);

        jPanel2.add(jPanel3);

        PanneauC.add(jPanel2);

        getContentPane().add(PanneauC);
        getContentPane().add(PanneauD);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //gestionnaire du clic sur un élément du liste déroulante
    private void ComboJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJoueursActionPerformed
        this.indjs = ComboJoueurs.getSelectedIndex();//récupération de l'indice de l'élément séléctionnée et on l'affecte à l'attribut indjs
            if (indjs != -1){
            if (this.indjs==this.indj) {
            Infos.setText("Sélectionnez un joueur différent du joueur courant !");
            PanneauG.removeAll();
            PanneauG.repaint();
            }
            else {
            Infos.append("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString()+"\n");
            initPanneau();
            affichePanneau();
                 }
            }

    }//GEN-LAST:event_ComboJoueursActionPerformed
    //gestionnaire du clic sur le bouton Transfert
    private void TransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransfertActionPerformed
        if(this.indjs!=-1 && this.fs!=null)//on teste si l'indice de joueur séléctionnée different de -1 et la famille de personnage séléctionnée different de null
        {
            this.tc=new Transfert(this.lj.getJoueur(indj),this.lj.getJoueur(indjs),fs);//Création d’une instance pour l’attributtc de type Transfert
            int res=tc.execute();//Appel de la méthode execute()
            if(res>0)//on teste si le transfert est bien passé
            {
                LesPersonnages pt=this.tc.getCartesTransferees();//récupération des personnages transférés
                creePanneau(PanneauD,pt);//Appel de lae méthode creePanneau pour créer les boutons du panneau droit, pour les cartes transférées
                dessinePanneau(PanneauD,pt);//Appel de la méthode dessinePanneau pour afficher les personnages sur les boutons du panneau droit
                LesPersonnages pp=this.lj.getJoueur(indjs).getPaquet();//Récupération des personnages du paquet du joueur sélectionné (donc après l’action de transfert)
                creePanneau(PanneauG,pp);//Appel de la méthode creePanneau pour créer à nouveau les boutons du panneau pour les cartes du joueur cible
                dessinePanneau(PanneauG,pp);//Appel de la méthode dessinePanneau pour afficher à nouveau les personnages sur les boutons du panneau gauche
                this.ok=true;//Affectation de la valeur true au booléen ok
                Transfert.setEnabled(false);//Invalidation du bouton de transfert
                Infos.append(this.tc.getDeroulement()+"\n");//on affiche dans la zone d'édition le résultat du transfert
            }
        }
        else//Sinon un message indique dans la zone d’édition Infos qu’il est nécessaire de sélectionner un joueur qui a au moins une carte.
            Infos.append("\n merci de sélectionner un joueur qui a au moins une carte \n");
        
    }//GEN-LAST:event_TransfertActionPerformed
    //gestionnaire du clic sur le bouton Fermer
    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        setVisible(false);//invisibilité de la boite de dialogue
        this.dispose();//fermerture automatique de la boite de dialogue
    }//GEN-LAST:event_FermerActionPerformed

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
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TransfertDlg dialog = new TransfertDlg(new javax.swing.JFrame(), true,new LesJoueurs(),0);
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
    private javax.swing.JComboBox<String> ComboJoueurs;
    private javax.swing.JButton Fermer;
    private javax.swing.JTextArea Infos;
    private javax.swing.JLabel L;
    private javax.swing.JLabel Message;
    private javax.swing.JLabel Message2;
    private javax.swing.JPanel PanneauC;
    private javax.swing.JPanel PanneauD;
    private javax.swing.JPanel PanneauG;
    private javax.swing.JButton Transfert;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
