/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author murilo
 */
public class GeneralEntryException extends Exception {
    private String msg;
    protected enum TYPE {
        NULL,
        WRONG_VALUE,
    }
    /**
     * Creates a new instance of <code>GeneralEntryException</code> without
     * detail message.
     */
    public GeneralEntryException() {
    }
    
    public GeneralEntryException(JTextComponent comp, String field, TYPE type, String obs) {
        comp.grabFocus();
        switch(type){
            case NULL:
                this.msg = "O campo "+field+" é um campo obrigatório. Certifique-se de preencher os valores corretamente";
                break;
            case WRONG_VALUE:
                this.msg = "Foi encontrado um problema com o valor informado no campo "+field+". Certifique-se de informar corretamente os dados";
                break;
            default:
                break;
        }
        if(obs!=null){
            this.msg+="\n\n"+obs;
        }
        showAllert();
    }

    public void showAllert(){
        JOptionPane.showMessageDialog(null, msg);   
    }
    /**
     * Constructs an instance of <code>GeneralEntryException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GeneralEntryException(String msg) {
        super(msg);
    }
}
