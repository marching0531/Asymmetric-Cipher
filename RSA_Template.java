package com.whykeykey.it.ciper;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
 
import javax.crypto.Cipher;
 
public class RSA_test {
	
    public static void main(String[] args) {
    
    	try {

            //Key Generation
	    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            
            KeyPair keyPair = keyPairGenerator.genKeyPair();
            Key publicKey = keyPair.getPublic();
            Key privateKey = keyPair.getPrivate();
            
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            
            /*RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
            RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
 
            System.out.println("public key modulus(" + publicKeySpec.getModulus() + ") exponent(" + publicKeySpec.getPublicExponent() + ")");
            System.out.println("private key modulus(" + privateKeySpec.getModulus() + ") exponent(" + privateKeySpec.getPrivateExponent() + ")");
             */
            
            //Plain Message
            String inputStr = "RSA Test";
 
            //Encryption Part
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] arrCipherData = cipher.doFinal(inputStr.getBytes());
            String strCipher = new String(arrCipherData);
            
            System.out.println(strCipher);
 
            //Decryption Part
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] arrData = cipher.doFinal(arrCipherData);
            String strResult = new String(arrData);
 
            System.out.println(strResult);
            
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
    }
}
