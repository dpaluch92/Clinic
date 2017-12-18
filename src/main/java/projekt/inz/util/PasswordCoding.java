/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.util;

import java.util.Base64;

/**
 *
 * @author depek
 */
public class PasswordCoding {

    private byte[] encodedBytes;
    private byte[] decodedBytes;

    public String encode(String password) {
        this.encodedBytes = Base64.getEncoder().encode(password.getBytes());
        return new String(encodedBytes);
    }

    public String decode(String codedPassword) {
        this.encodedBytes = codedPassword.getBytes();
        String n = new String(encodedBytes);
        this.decodedBytes = Base64.getDecoder().decode(encodedBytes);
        return new String(decodedBytes);
    }
}
