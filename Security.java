import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	public static void main(String[] args) {
	    System.out.println(digest("SHA-256", "Evren"));
	}
	private static String encodeHex(byte[] digested) {
	    StringBuilder string_builder = new StringBuilder();
	    for (int i = 0; i < digested.length; i++) {
	        string_builder.append(Integer.toString((digested[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return string_builder.toString();
	}

	public static String digest(String algorithm, String input) {
	    try {
	        MessageDigest message_digest = MessageDigest.getInstance(algorithm);
	        byte[] buffer = input.getBytes("UTF-8");
	        message_digest.update(buffer);
	        byte[] digested = message_digest.digest();
	        return encodeHex(digested);
	    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return e.getMessage();
	    }
	}
	
	
	
}
