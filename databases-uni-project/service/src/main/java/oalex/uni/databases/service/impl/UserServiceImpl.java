package oalex.uni.databases.service.impl;

import oalex.uni.databases.dao.UserDAO;
import oalex.uni.databases.model.Privilege;
import oalex.uni.databases.model.User;
import oalex.uni.databases.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDAO userDAO;

    public void create(User user) {
        userDAO.create(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public User find(long id) {
        return userDAO.find(id);
    }

    public User findUserByLogin(String login) {
        return userDAO.findUserByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUserByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),enabled,accountNonExpired, credentialsNonExpired,accountNonLocked,getAuthorities(user.getPrivilege()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return userDetails;
    }

    public Collection getAuthorities(Privilege privilege) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getPrivileges(privilege));
        return authList;
    }

    public List<String> getPrivileges(Privilege privilege) {

        List<String> roles = new ArrayList<String>();

        if (privilege.getName().equals("ADMIN")) {
            roles.add("ROLE_ADMIN");
            roles.add("ROLE_USER");

        }
        else if(privilege.getName().equals("EMPLOYER")){
            roles.add("ROLE_EMPLOYER");
            roles.add("ROLE_USER");
        }
        else if(privilege.getName().equals("WORKER")){
            roles.add("ROLE_WORKER");
            roles.add("ROLE_USER");
        }
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
