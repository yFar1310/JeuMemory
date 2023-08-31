/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package jeumemory;

import java.awt.GridLayout;
import javax.swing.JButton;

/**
 *
 * @author Yahya
 */
public class VisuPersonnagesDlg extends javax.swing.JDialog {

    private Joueur j;
    
    
    public VisuPersonnagesDlg(java.awt.Frame parent, boolean modal,Joueur j) {
        super(parent, modal);
        initComponents();
        this.j=j;
        initPanneau();
    }
    
    public void initPanneau(){
        int nc=this.j.getPaquet().getTaille();
        //on fixe le layout du panneau avec nc
        Panneau.setLayout(new GridLayout(2,nc));
        for(int i=0;i<nc;i++)
        {
            JButton jb=new JButton();
            jb.setName(""+i);//on fixe comme name du bouton son numéro
            Panneau.add(jb);
        }
        this.pack();// pour ajuster correctement la taille des composants après les ajouts si besoin
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pseudo = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Score = new javax.swing.JLabel();
        Afficher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pseudo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pseudo))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        Score.setText(" ");
        jPanel4.add(Score);

        Afficher.setText("Afficher");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        jPanel4.add(Afficher);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
            pseudo.setText("Cartes du joueur :" +j.getPseudo());
            Score.setText("Score :"+j.getScore());
            for(int i=0;i<this.j.getPaquet().getTaille();i++ )
        {   //on récupère le ième bouton
            JButton jb = (JButton)Panneau.getComponent(i);
            Personnage p = this.j.getPaquet().getPerso(i);//récupère le personnage d'indice i
            
            p.setImgBouton(jb);
          
        }
            this.pack();
            
    }//GEN-LAST:event_AfficherActionPerformed

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
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisuPersonnagesDlg dialog = new VisuPersonnagesDlg(new javax.swing.JFrame(), true,new Joueur());
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
    private javax.swing.JButton Afficher;
    private javax.swing.JPanel Panneau;
    private javax.swing.JLabel Score;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel pseudo;
    // End of variables declaration//GEN-END:variables
}
