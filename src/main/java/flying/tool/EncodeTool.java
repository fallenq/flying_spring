package flying.tool;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EncodeTool {   
	
	private static final PasswordEncoder encoder = new StandardPasswordEncoder("18033D685478CA77F2776792F57CFEDA");//秘钥值  

	public static String encrypt(String rawPassword) {  
	   return encoder.encode(rawPassword);  
	}  
	
	public static boolean match(String rawPassword, String password) {  
	   return encoder.matches(rawPassword, password);  
	}  
}
