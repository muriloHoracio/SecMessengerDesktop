/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.security;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author murilo
 */
public class Passwords {
    private static final Random RANDOM = new SecureRandom();
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 512;
    
    private Passwords(){}
    
    public static byte[] getNextSalt(){
        byte[] salt = new byte[32];
        RANDOM.nextBytes(salt);
        return salt;
    }
    
    public static byte[] hash(char[] password, byte[] salt){
        PBEKeySpec spec = new PBEKeySpec(password,salt,ITERATIONS,KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try{
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            spec.clearPassword();
        }
        return null;
    }
    
    public static boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash){
        byte[] pwdHash = hash(password,salt);
        Arrays.fill(password, Character.MIN_VALUE);
        if(pwdHash.length != expectedHash.length) return false;
        for(int i=0;i<pwdHash.length;i++){
            if(pwdHash[i]!=expectedHash[i]) return false;
        }
        return true;
    }
}