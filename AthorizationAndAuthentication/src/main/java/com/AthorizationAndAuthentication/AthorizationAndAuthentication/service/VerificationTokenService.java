package com.AthorizationAndAuthentication.AthorizationAndAuthentication.service;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EndUser;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EntityUser;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.VerificationToken;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.EndUserRepository;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class VerificationTokenService {

    @Autowired
    public VerificationTokenRepository verificationTokenRepository;

    @Autowired
    public EndUserRepository endUserRepository;

    public void save(EndUser user, String verificationToken){
        verificationTokenRepository.save(new VerificationToken(verificationToken, user));
    }

    public VerificationToken findByUser(EndUser endUser) {
        return verificationTokenRepository.findByUser(endUser);
    }

    public VerificationToken findByToken(String token){
        return verificationTokenRepository.findByToken(token);
    }

    @Transactional
    public void delete(Long id){
        Optional endUser = endUserRepository.findById(id);

        if(endUser.isPresent()){
            verificationTokenRepository.deleteByUser((EndUser) endUser.get());
        }
    }
}
