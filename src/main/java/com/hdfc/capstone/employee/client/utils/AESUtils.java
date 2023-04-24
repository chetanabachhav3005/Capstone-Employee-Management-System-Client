package com.hdfc.capstone.employee.client.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
	
	private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final byte[] SECRET_KEY = "12345678912345678912345678912345".getBytes(); // Replace with your own secret key

    public static byte[] decrypt(byte[] input) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(input);
    }


}
