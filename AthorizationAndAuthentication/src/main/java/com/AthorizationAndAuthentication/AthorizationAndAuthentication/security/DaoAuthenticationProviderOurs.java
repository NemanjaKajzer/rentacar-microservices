package com.AthorizationAndAuthentication.AthorizationAndAuthentication.security;
/*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.util.Assert;

extends AbstractUserDetailsAuthenticationProvider
*/

public class DaoAuthenticationProviderOurs  {

/*
    private PasswordEncoder passwordEncoder;

    private volatile String userNotFoundEncodedPassword;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginInfoService loginInfoService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
                if (authentication.getCredentials() == null) {
                    logger.debug("Authentication failed: no credentials provided");
        
                    throw new BadCredentialsException(messages.getMessage(
                            "AbstractUserDetailsAuthenticationProvider.badCredentials",
                            "Bad credentials"));
                }
        
                String presentedPassword = authentication.getCredentials().toString();
        
                String nasSalt=loginInfoService.findSaltByUsername(userDetails.getUsername());

                System.out.println("NAS SALT JE ===="+nasSalt);
                
                
                if (!passwordEncoder.matches(presentedPassword+nasSalt, userDetails.getPassword())) {
                    logger.debug("Authentication failed: password does not match stored value");
        
                    throw new BadCredentialsException(messages.getMessage(
                            "AbstractUserDetailsAuthenticationProvider.badCredentials",
                            "Bad credentials"));
                }

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
                prepareTimingAttackProtection();
                try {
                    UserDetails loadedUser = this.getUserDetailsService().loadUserByUsername(username);
                    if (loadedUser == null) {
                        throw new InternalAuthenticationServiceException(
                                "UserDetailsService returned null, which is an interface contract violation");
                    }
                    return loadedUser;
                }
                catch (UsernameNotFoundException ex) {
                    mitigateAgainstTimingAttack(authentication);
                    throw ex;
                }
                catch (InternalAuthenticationServiceException ex) {
                    throw ex;
                }
                catch (Exception ex) {
                    throw new InternalAuthenticationServiceException(ex.getMessage(), ex);
                }
    }

    private void prepareTimingAttackProtection() {
		if (this.userNotFoundEncodedPassword == null) {
			this.userNotFoundEncodedPassword = this.passwordEncoder.encode("userNotFoundPassword");
		}
    }
    
    protected UserDetailsService getUserDetailsService() {
		return userDetailsService;
    }
    
    private void mitigateAgainstTimingAttack(UsernamePasswordAuthenticationToken authentication) {
		if (authentication.getCredentials() != null) {
			String presentedPassword = authentication.getCredentials().toString();
			this.passwordEncoder.matches(presentedPassword, this.userNotFoundEncodedPassword);
		}
    }
    
    public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
    }
    
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");
		this.passwordEncoder = passwordEncoder;
		this.userNotFoundEncodedPassword = null;
	}

    */
}