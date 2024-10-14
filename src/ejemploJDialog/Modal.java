/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploJDialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class Modal extends JDialog {

    public Modal(JFrame padre){
        super(padre, "MI DIALOGO", JDialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        setSize(400,200);
        
    }
        private void initComponents(){
            JLabel label = new JLabel("MOSTRANDO INFO EN EL JDIALOG");
            label.setBounds(100,100,50,15);
            this.add(label);
            
    }
    
}
