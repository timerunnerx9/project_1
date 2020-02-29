package project_1.utils;
//
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.KeySpec;
//import java.util.Arrays;
//import java.util.Base64;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.PBEKeySpec;

//1. We need to make our passwords very long so that Mitch and Josh doesn't scold us for it. 
//At least 12 characters long.

//2. We have to generate salt for the password using a CSPRNG. In java we use, java.security.SecureRandom.


// Hash to look through to understand how a hashed implementation works.

//public class PassHash {
//	byte[] salt = new byte[16];
//	random.nextBytes(salt);
//	KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
//	SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//	byte[] hash = f.generateSecret(spec).getEncoded();
//	Base64.Encoder enc = Base64.getEncoder();
//	System.out.printf("salt: %s%n", enc.encodeToString(salt));
//	System.out.printf("hash: %s%n", enc.encodeToString(hash));
//	
//	public static void main(String[] args) {
//		
//	}
//}
