package security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.stereotype.Service;

@Service
public class MyMatcher implements CredentialsMatcher{

    @SuppressWarnings("static-access")
	@Override
    public boolean doCredentialsMatch(AuthenticationToken at, AuthenticationInfo ai) {
        
    	MessageDigest md = null;
    	
    	String pw = null;
    	
    	byte[] dbArr = null;
		try {
			md = MessageDigest.getInstance("SHA-256");

        char[] cred = (char[])at.getCredentials();
        
        pw = String.valueOf(cred);
        
        String dbPw = (String) ai.getCredentials();
        
        byte[] bytes = dbPw.getBytes("iso-8859-1");
        
        md.update(bytes);
       
        dbArr = md.digest();
        

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return md.isEqual(pw.getBytes(),dbArr);
    }
}