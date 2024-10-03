/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploJtable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ejemploJTableLibreria {


    public static void main(String[] args){
        
        String columnas[] = {"NOMBRE", "APELLIDO", "EDAD", "CORREO"};
        String datos[][] = {{"JUAN", "PEREZ", "30", "PEREZ@GMAIL.COM"}, {"MARIA", "LOPEZ", "25", "LOPEZ@GMAIL.COM"},
                {"LUIS", "AGUILAR", "20", "LUIS@GMAIL.COM"},
                {"GABRIEL", "JESUS", "21", "GABRIEL@GMAIL.COM"},
                {"ERLING", "HALLAND", "22", "HALLAND@GMAIL.COM"},
                {"ALLISON", "BECKER", "27", "BECKER@GMAIL.COM"}};
    
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(100, 100 , 600, 100);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.add(scroll);
        frame.setVisible(true);
        
        
    }
                
}
    
  
