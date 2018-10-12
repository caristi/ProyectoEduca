package security;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.edu.dto.UsuarioDto;

public class MyRealm extends AuthorizingRealm{
	

	private Session sesion;
	
    private SessionFactory sessionFactory;

    public MyRealm() {
//        setName("myrealm");
            
    }

    @SuppressWarnings("unchecked")
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        
    	String userName = pc.getPrimaryPrincipal() + "";
        
    	sesion = sessionFactory.openSession();
        
    	Query q = sesion.createQuery("SELECT n FROM UsuarioDto n WHERE n.login = :name").setParameter("name", userName);
        
    	List<UsuarioDto> l = q.list();
        
    	if (!l.isEmpty()) {
        	UsuarioDto user = l.get(0);
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            for (PerfilDto role : user.getUserRoles()) {
//                info.addRole(role.getNombre());
//                            
//            }
            sesion.close();
            return info;
        }
        sesion.close();
        return null;
    }

    @SuppressWarnings("unchecked")
	@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
    	sesion = sessionFactory.openSession();
        at = (UsernamePasswordToken) at;
        Query q = sesion.createQuery("SELECT n FROM UsuarioDto n");
        List<UsuarioDto> l = q.list();
        if (!l.isEmpty()) {
        	UsuarioDto user = l.get(0);
        	sesion.close();
            return new SimpleAuthenticationInfo(user.getLogin(), user.getContrasena(), user.getNombre());
        }
        sesion.close();
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
