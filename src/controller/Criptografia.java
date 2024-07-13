package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	public static final String SHA256 = "SHA-256";
	public static final String MD5 = "MD5";
    
	protected String informação;
	protected String padrao;
	
	public Criptografia(String informação, String padrao) {
		super();
		this.informação = informação;
		this.padrao = padrao;
	}

	public String getInformação() {
		return informação;
	}

	public void setInformação(String informação) {
		this.informação = informação;
	}

	public String getPadrao() {
		return padrao;
	}

	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}
	
	public String criptografar() {
		String informacao = getInformação();
		
		MessageDigest messageDigest;
		StringBuilder hexString = null;
		
		try {
			messageDigest = MessageDigest.getInstance(getPadrao());
			byte[] hash = messageDigest.digest(
					informacao.getBytes(StandardCharsets.UTF_8));
			        hexString = new StringBuilder(2* hash.length);
			        for(int i = 0; i < hash.length; i++) {
			        	String hex = Integer.toHexString(0xff & hash[i]);
			        	if(hex.length() == 1) {
			        		hexString.append('0');	
			        	}
			        	hexString.append(hex);
			        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		        
		        return hexString.toString().toUpperCase();
	}
}
