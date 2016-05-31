/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


/**
 *
 * @author koray
 */
public class Test extends JFrame{

    public Test() {
        
        setTitle("Test");
        setSize(300, 300);

        components();
        
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    }
    
    private void components(){
        
        JPanel panel = new JPanel();
        
        String tabellen [] = {"vb nationaal student", "vb exchange student", "vb bedrijf", "vb opleiding"};

        JPopupMenu menu = new JPopupMenu();

        menu.add(new JCheckBox("asd"));
        menu.add(new JCheckBox("asss"));
        menu.add(new JCheckBox("dd"));
        
        JCheckBox aa = new JCheckBox("aa");

        panel.add(menu);
        add(panel);
    }
    
    
    
    public static void main(String[] args) {
        // DIT IS VOOR MIJ OM TESTEN UIT TE VOEREN.
        Test tes = new Test();
        tes.setVisible(true);
        
    }

}