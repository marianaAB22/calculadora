/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejemploKeyType;



/**
 *
 * @author Administrator
 */
public class miniCalculadora extends javax.swing.JFrame {

    /**
     * Creates new form miniCalculadora
     */
    public miniCalculadora() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoResultado = new javax.swing.JTextField();
        botonNumero1 = new javax.swing.JButton();
        campoNumero2 = new javax.swing.JTextField();
        campoNumero1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonSumar = new javax.swing.JButton();
        botonNumero2 = new javax.swing.JButton();
        botonNumero3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        campoResultado.setFocusable(false);
        campoResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultadoActionPerformed(evt);
            }
        });

        botonNumero1.setText("1");
        botonNumero1.setFocusable(false);
        botonNumero1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNumero1MouseClicked(evt);
            }
        });
        botonNumero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNumero1ActionPerformed(evt);
            }
        });

        campoNumero2.setFocusable(false);
        campoNumero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumero2ActionPerformed(evt);
            }
        });

        campoNumero1.setFocusable(false);

        jLabel1.setText("MINI CALCULADORA");

        botonSumar.setText("SUMAR");
        botonSumar.setFocusable(false);
        botonSumar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSumarMouseClicked(evt);
            }
        });
        botonSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSumarActionPerformed(evt);
            }
        });

        botonNumero2.setText("2");
        botonNumero2.setFocusable(false);
        botonNumero2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNumero2MouseClicked(evt);
            }
        });
        botonNumero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNumero2ActionPerformed(evt);
            }
        });

        botonNumero3.setText("3");
        botonNumero3.setFocusable(false);
        botonNumero3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNumero3MouseClicked(evt);
            }
        });
        botonNumero3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNumero3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(campoResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(campoNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(botonNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(botonNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(botonNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(botonSumar)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNumero2)
                    .addComponent(botonNumero1)
                    .addComponent(botonNumero3))
                .addGap(60, 60, 60)
                .addComponent(botonSumar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNumero1ActionPerformed

    private void campoResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoResultadoActionPerformed

    private void botonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSumarActionPerformed

    private void campoNumero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumero2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumero2ActionPerformed

    private void botonNumero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNumero2ActionPerformed

    private void botonNumero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumero3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNumero3ActionPerformed

    private void botonNumero1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNumero1MouseClicked
        if(campoNumero1.getText().equals("")){
            campoNumero1.setText("1");
        }
        else if(campoNumero2.getText().equals("")){
            campoNumero2.setText("2");
        }        
    }//GEN-LAST:event_botonNumero1MouseClicked

    private void botonNumero2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNumero2MouseClicked
        if(campoNumero1.getText().equals("")){
            campoNumero1.setText("2");
        }
        else if(campoNumero2.getText().equals("")){
            campoNumero2.setText("2");
        }          
    }//GEN-LAST:event_botonNumero2MouseClicked

    private void botonNumero3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNumero3MouseClicked
        if(campoNumero1.getText().equals("")){
            campoNumero1.setText("3");
        }
        else if(campoNumero2.getText().equals("")){
            campoNumero2.setText("3");
        }           
    }//GEN-LAST:event_botonNumero3MouseClicked

    private void botonSumarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSumarMouseClicked
        int numero1 = Integer.parseInt(campoNumero1.getText());
        int numero2 = Integer.parseInt(campoNumero1.getText());
        int resultado = numero1+numero2;
        campoResultado.setText(String.valueOf(resultado));
    }//GEN-LAST:event_botonSumarMouseClicked

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        String numero = String.valueOf(evt.getKeyChar()); //caprurando alguna tecla que presiono el usuario
        if(numero.equals("1")){
            if(campoNumero1.getText().equals("")){
            campoNumero1.setText("1");
            }
            else if(campoNumero2.getText().equals("")){
                campoNumero2.setText("1");
            }  
            
        }
        if(numero.equals("2")){
            if(campoNumero1.getText().equals("")){
            campoNumero1.setText("2");
            }
            else if(campoNumero2.getText().equals("")){
                campoNumero2.setText("2");
            }
            
        if(numero.equals("3")){
            if(campoNumero1.getText().equals("")){
            campoNumero1.setText("3");
            }
            else if(campoNumero2.getText().equals("")){
                campoNumero2.setText("3");
            }  
            
        }
        }
        
    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK ENTER){
            int numero1 = Integer.parseInt(campoNumero1.getText());
            int numero2 = Integer.parseInt(campoNumero1.getText());
            int resultado = numero1+numero2;
            campoResultado.setText(String.valueOf(resultado));
            campoNumero1.setText("");
            campoNumero2.setText("");
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(miniCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(miniCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(miniCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(miniCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new miniCalculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonNumero1;
    private javax.swing.JButton botonNumero2;
    private javax.swing.JButton botonNumero3;
    private javax.swing.JButton botonSumar;
    private javax.swing.JTextField campoNumero1;
    private javax.swing.JTextField campoNumero2;
    private javax.swing.JTextField campoResultado;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}