/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ThreadGUIProblemDemo.java
 *
 * Created on Apr 29, 2010, 1:20:03 PM
 */

package threads.basic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlombardo
 */
public class ThreadGUIProblemDemo extends javax.swing.JFrame {
    private long count = 0;

    /** Creates new form ThreadGUIProblemDemo */
    public ThreadGUIProblemDemo() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        txtCount = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStart.setText("Start Counter");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        txtCount.setText("0");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(34, 34, 34)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCount)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnStart))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if(evt.getActionCommand().startsWith("Start")) {
            btnStart.setText("Stop");
            btnStart.setActionCommand("Stop");
            // This code will run on gui event dispatch thread.
            // This is bad because that thread is needed to respond to
            // user events. The gui will seem frozen in time
//            for(long i=0; i<1000000000; i++) {
//                txtCount.setText(""+i);
//            }

            // Now try the same thing using a customer thread to do the counter.
            // Always put long running code in a separate thread
            new Thread(new Runnable() {
                public void run() {

                    // put long running code here....
                    for(count = 0; count < 1000000000; count++) {
                        txtCount.setText(""+count);
                        try {
                            Thread.sleep(250); // give some processor time to gui event dispatch thread
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ThreadGUIProblemDemo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    // end long running code

                }
            }).start();
        } else {
            btnStart.setText("Start");
            btnStart.setActionCommand("Start");
            count = 1000000000;
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThreadGUIProblemDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel txtCount;
    // End of variables declaration//GEN-END:variables

}
