/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.JPanel;

import javax.swing.JList;
import javax.swing.JScrollPane;


/**
 *
 * @author koray
 */
public class Test extends JFrame{
    
    String [] tabellen = {"vb nationaal student", "vb exchange student", "vb bedrijf", "vb opleiding"};
    JList list;
    JButton button;
    
    public Test() {
        
        setTitle("Test");
        setSize(300, 300);
        
        button();
        components();
        
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    }
    
    private void components(){
        
        JPanel panel = new JPanel();

        list = new JList(tabellen);
        
        list.setSize(200, 200);
        
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(150, 50));
        
        panel.add(new JLabel("Tabel:"));
        panel.add(scroll);
        panel.add(button);
        add(panel);
    }
    
    private void button(){
        button = new JButton("ok");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                List a = list.getSelectedValuesList();
                
                for (int i = 0; i < a.size(); i++) {
                    System.out.println(a.get(i));
                }
            }
            
        });
    }
    
    
    
    public static void main(String[] args) {
        // DIT IS VOOR MIJ OM TESTEN UIT TE VOEREN.
        Test tes = new Test();
        tes.setVisible(true);
        
    }

}