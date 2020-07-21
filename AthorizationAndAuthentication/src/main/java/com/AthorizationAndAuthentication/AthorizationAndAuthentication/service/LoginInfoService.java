package com.AthorizationAndAuthentication.AthorizationAndAuthentication.service;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.LoginInfo;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.LoginInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//implements UserDetailsService

@Service
public class LoginInfoService  {

   @Autowired
   private LoginInfoRepository loginInfoRepository;

   // @Override
  //  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        
   //     return loginInfoRepository.findByUsername(username);

   // }

    public void save(LoginInfo loginInfo){

        loginInfoRepository.save(loginInfo);

    }

    public String findSaltByUsername(String username){

return loginInfoRepository.findByUsername(username).getSalt();

    }

    public LoginInfo findByEmail(String email){


        return loginInfoRepository.findByEmail(email);
    }

    public LoginInfo findOneById(Long id){

        return loginInfoRepository.findOneById(id);

    }

    public LoginInfo findOneByUsername(String username){

        return loginInfoRepository.findByUsername(username);
    }

}