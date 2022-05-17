package ma.enset.patientmvc.sec.service;

import ma.enset.patientmvc.sec.entities.AppUser;
import org.apache.groovy.parser.antlr4.GroovyLexer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {
    private SecurityService securityService;
    public UserDetailsServiceImpl(SecurityService securityService) {
        this.securityService = securityService;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=securityService.loadByUsername(username);
        /*
        Collection<GrantedAuthority> authorities=new ArrayList();
        appUser.getAppRoles().forEach(role -> {
            SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(authority);
        });*/
        Collection<GrantedAuthority> authorities1=
                appUser.getAppRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toList());

        User user=new User(appUser.getUsername(),appUser.getPassword(),authorities1);
        return user;
    }
}
