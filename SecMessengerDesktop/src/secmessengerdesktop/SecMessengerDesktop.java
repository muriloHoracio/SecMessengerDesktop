/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secmessengerdesktop;

import core.rn.UserRN;
import exceptions.GeneralEntryException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author murilo
 */
public class SecMessengerDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[] estados = new Object[1];
        estados[0] = "SP";
        
        /*
        //TESTE DE INSERSÃO NO BANCO DE DADOS
        try {
            UserRN.insertUser(new JTextField("murilo.horacio@hotmail.com"), new JTextField("muriloHoracio"), new JPasswordField("murilo1nfo"), new JTextField("Murilo Horacio Pereira da Cruz"), new JTextField("111.111.111-11"), new JTextField("(043) 8836-4413"), new JComboBox(estados), new JTextField("Avaré"), new JTextField("Brabância"), new JTextField("Armando Assato"), new JTextField("228"), new JTextField("18.704-310"));
        } catch (GeneralEntryException ex) {
            ex.showAllert();
        }*/
        
        /*
        //TESTE DE VERIFICAÇÃO DE SENHA CORRETA
        if(UserRN.verifyPassword("muriloHoracio", "murilo1nfo")){
            System.out.println("Password matched!");
        }else{
            System.out.println("Password did not matched!");
        }*/
        
        /*
        //TESTE DE VERIFICAÇÃO DO USUÁRIO/EMAIL QUE JÁ EXISTE
        try {
            UserRN.insertUser(new JTextField("pedro.paulo@hotmail.com"), new JTextField("pedrao"), new JPasswordField("pedrinho"), new JTextField("Murilo Horacio Pereira da Cruz"), new JTextField("111.111.111-11"), new JTextField("(043) 8836-4413"), new JComboBox(estados), new JTextField("Avaré"), new JTextField("Brabância"), new JTextField("Armando Assato"), new JTextField("228"), new JTextField("18.704-310"));
        } catch (GeneralEntryException ex) {
            ex.showAllert();
        }*/
        
        /*
        //TESTE ADICIONAR CONTATO
        try {
            UserRN.addContact("pedrao", new JTextField("muriloHoracio"));
        } catch (GeneralEntryException ex) {
            
        }*/
        
        
    }
    
}
