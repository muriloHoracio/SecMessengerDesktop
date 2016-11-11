/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.rn;

import core.dao.UserDao;
import core.entity.User;
import core.security.Passwords;
import exceptions.GeneralEntryException;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

/**
 *
 * @author murilo
 */
public class UserRN extends GeneralEntryException{
    private static final long serialVersionUID = 4092825992954782211L;
    
    private static User user;

    private UserRN() {
        
    }
    
    public static void insertUser
        (
            JTextComponent email, JTextComponent username, JTextComponent password, JTextComponent name, JTextComponent cpf, 
            JTextComponent telefone, JComboBox estado, JTextComponent cidade, JTextComponent bairro, JTextComponent rua, 
            JTextComponent numero, JTextComponent cep
        ) throws GeneralEntryException
    {
        if(email.getText()==null || email.getText().equals("")){
            throw new GeneralEntryException(email, "email", GeneralEntryException.TYPE.NULL, null);
        }
        if(UserDao.doEmailExists(email.getText())){
            throw new GeneralEntryException(email, "email", TYPE.WRONG_VALUE, "Este email já está cadastrado na base de dados");
        }
        if(username.getText()==null || username.getText().equals("")){
            throw new GeneralEntryException(username, "username", GeneralEntryException.TYPE.NULL, null);
        }
        if(UserDao.doUserExists(username.getText())){
            throw new GeneralEntryException(username, "username", TYPE.WRONG_VALUE, "Este nome de usuário já existe");
        }
        if(password.getText()==null || password.getText().equals("")){
            throw new GeneralEntryException(password, "senha", GeneralEntryException.TYPE.NULL, null);
        }
        if(name.getText()==null || name.getText().equals("")){
            throw new GeneralEntryException(name, "nome", TYPE.NULL, null);
        }
        if(cpf.getText()==null || cpf.getText().equals("")){
            throw new GeneralEntryException(cpf, "cpf", TYPE.NULL, null);
        }
        if(telefone.getText()==null || telefone.getText().equals("")){
            throw new GeneralEntryException(telefone, "telefone", GeneralEntryException.TYPE.NULL, null);
        }
        if(cidade.getText()==null || cidade.getText().equals("")){
            throw new GeneralEntryException(cidade, "cidade", TYPE.NULL, null);
        }
        if(bairro.getText()==null || bairro.getText().equals("")){
            throw new GeneralEntryException(bairro, "bairro", TYPE.NULL, null);
        }
        if(rua.getText()==null || rua.getText().equals("")){
            throw new GeneralEntryException(rua, "rua", TYPE.NULL, null);
        }
        if(numero.getText()==null || numero.getText().equals("")){
            throw new GeneralEntryException(numero, "numero", TYPE.NULL, null);
        }
        if(cep.getText()==null || cep.getText().equals("")){
            throw new GeneralEntryException(cep, "cep", TYPE.NULL, null);
        }
        if(!email.getText().contains("@")){
            throw new GeneralEntryException(email, "email", TYPE.WRONG_VALUE, null);
        }
        if(password.getText().length()<8){
            throw new GeneralEntryException(password, "senha", TYPE.WRONG_VALUE, "O campo senha deve possuir no mínimo 8 caracteres");
        }
        User u = new User(email.getText(), username.getText(), null, new String(Passwords.getNextSalt()), name.getText(), cpf.getText(), telefone.getText(), estado.getSelectedItem().toString(), cidade.getText(), bairro.getText(), rua.getText(), numero.getText(), cep.getText());
        u.setPassword(new String(Passwords.hash(password.getText().toCharArray(),u.getPasswordSalt().getBytes())));
        UserDao.insertUser(u);
    }
    
    public static boolean verifyPassword(String username, String password){
        String salt = UserDao.getSalt(username);
        String hash = UserDao.getHash(username);
        User u = new User();
        u.setPassword(new String(Passwords.hash(password.toCharArray(), salt.getBytes())));
        return (u.getPassword().equals(hash));
    }
    
    public static void addContact(String username, JTextComponent contact) throws GeneralEntryException{
        if(contact.getText()==null || contact.getText().equals("")){
            throw new GeneralEntryException(contact, "contato", GeneralEntryException.TYPE.NULL, "O campo contato não pode ser nulo");
        }
        if(!UserDao.doUserExists(contact.getText())){
            throw new GeneralEntryException(contact, "contato", GeneralEntryException.TYPE.WRONG_VALUE, "O contato informado não existe na base de dados");
        }
        if(UserDao.doUserHasThisContact(username, contact.getText())){
            throw new GeneralEntryException(contact, "contato", TYPE.WRONG_VALUE, "Você já possui este contato");
        }
        UserDao.addContact(username,contact.getText());
    }
}
