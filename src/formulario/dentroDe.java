/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package formulario;


import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class dentroDe extends JFrame implements ActionListener {
    Scanner teclitas = new Scanner(System.in);
    
    
    private JLabel l1, l2, l3, l4;    
    private JButton guarda;
    private JTextField t1,t2,t3,t4;
    
    public dentroDe(){
        setTitle("Formulario del Demonio");
        setLocationRelativeTo(null);        
        setLayout(null);
        setBounds(100, 100, 700, 400);  
        
        l1 = new JLabel("Nombre:");
        l1.setBounds(60, 20, 200, 50);
        add(l1);
        
        l2 = new JLabel("Apellido Paterno:");
        l2.setBounds(60, 100, 200, 50);
        add(l2);
        
        l3 = new JLabel("Apellido Materno:");
        l3.setBounds(60, 180, 200, 50);
        add(l3);
        
        l4 = new JLabel("Escuela:");
        l4.setBounds(60, 260, 200, 50);
        add(l4);
        
        guarda = new JButton("Guardar");
        guarda.setBounds(265, 320, 170, 30);
        add(guarda);
        guarda.addActionListener(this);
        
        t1 = new JTextField();
        t1.setBounds(300, 20, 200, 30);
        add(t1);
        
        t2 = new JTextField();
        t2.setBounds(300, 100, 200, 30);
        add(t2);
        
        t3 = new JTextField();
        t3.setBounds(300, 180, 200, 30);
        add(t3);
        
        t4 = new JTextField();
        t4.setBounds(300, 260, 200, 30);
        add(t4);
        
        setVisible(true);
        
    }
    
    public void llama(){
        cDatos conex = new cDatos();
        String nombre = t1.getText();
        String apellidp = t2.getText();
        String apellidm = t3.getText();
        String escul = t4.getText();
        try{
            conex.conectar();
            
            ResultSet guardaForm = conex.consulta("call guardaAlumno('"+nombre+"', '"+apellidp+"','"+apellidm+"','"+escul+"');");
        }catch(Exception lel){
            JOptionPane.showMessageDialog(null, "Hubo un error: " + lel.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == guarda){
            llama();
        }
    }
    
}
