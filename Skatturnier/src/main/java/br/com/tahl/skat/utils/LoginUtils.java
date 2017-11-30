package br.com.tahl.skat.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class LoginUtils {

	public static String getHash(String password) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte hash[] = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));
			return String.format("%064x", new BigInteger(1, hash));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String generatePassword() {
		String characters = "ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz1234567890";
		String special = "@#$%&()!";
		
		StringBuilder pass = new StringBuilder();
		Random rndChar = new Random();
		Random rndType = new Random();
		while (pass.length() < 10) {
			if (rndType.nextInt(10) > 0) {
				int index = (int) (rndChar.nextFloat() * characters.length());
				pass.append(characters.charAt(index));
			} else {
				int index = (int) (rndChar.nextFloat() * special.length());
				pass.append(special.charAt(index));
			}
		}
			
		return pass.toString();
	}
}
