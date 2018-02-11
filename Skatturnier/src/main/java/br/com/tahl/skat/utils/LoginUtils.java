package br.com.tahl.skat.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class LoginUtils {

	public static String getHash(String senha) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte hash[] = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));
			return String.format("%064x", new BigInteger(1, hash));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String gerarNovaSenha() {
		String caracteres = "ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz1234567890";
		String especiais = "@#$%&()!";
		
		StringBuilder senha = new StringBuilder();
		Random rndCaracteres = new Random();
		Random rndTipo = new Random();
		while (senha.length() < 10) {
			if (rndTipo.nextInt(10) > 0) {
				int indice = (int) (rndCaracteres.nextFloat() * caracteres.length());
				senha.append(caracteres.charAt(indice));
			} else {
				int index = (int) (rndCaracteres.nextFloat() * especiais.length());
				senha.append(especiais.charAt(index));
			}
		}
		return senha.toString();
	}
}
