package com.AthorizationAndAuthentication.AthorizationAndAuthentication.service;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EndUser;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.LoginInfo;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EntityUser;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.EndUserRepository;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.LoginInfoRepository;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EndUserService {

    @Autowired
    private EndUserRepository endUserRepository;

    @Autowired
    private LoginInfoRepository loginInfoRepository;

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private ShoppingCartService shoppingCartService;

    public void save(EndUser endUser) {

        endUserRepository.save(endUser);
        // shoppingCartService.save(endUser.getId());
    }

    public LoginInfo findByEmail(String email) {
        return loginInfoRepository.findByEmail(email);
    }

    public LoginInfo findByUsername(String username) {
        return loginInfoRepository.findByUsername(username);
    }

    public EntityUser findByJmbg(String jmbg) {
        return userRepository.findByJmbg(jmbg);
    }

    public List<EndUser> getUnregistered() {
        return endUserRepository.findByActivity(false);
    }

    public List<EndUser> getAdminUnregistered() {
        return endUserRepository.findByAdminApproved(false);
    }

    public EndUser findById(Long id) {
        return endUserRepository.findById(id).get();
    }

    @Transactional
    public EndUser acceptRegistration(Long id) {
        Optional opt = endUserRepository.findById(id);

        if (opt.isPresent()) {
            EndUser endUser = (EndUser) opt.get();

            endUser.setAccount_activated(true);
            endUser.setBlocked(false);
            endUserRepository.save(endUser);

            return endUser;
        }

        return null;
    }

    @Transactional
    public EndUser changeAdminActivated(Long id) {
        Optional opt = endUserRepository.findById(id);

        if (opt.isPresent()) {
            EndUser endUser = (EndUser) opt.get();

            endUser.setAdminApproved(true);
            endUserRepository.save(endUser);

            return endUser;
        }

        return null;
    }

    @Transactional
    public void rejectRegistration(Long id) {
        Optional opt = endUserRepository.findById(id);

        if (opt.isPresent()) {
            endUserRepository.delete((EndUser) opt.get());
        }
    }

    public List<EndUser> getRegisteredUsers() {
        return endUserRepository.findAllByActivity(true);
    }

    
    @Transactional public void deactivate(Long id){ 
        endUserRepository.deleteById(id);
    }
    
    @Transactional public Boolean block(Long id){
        EndUser endUser = endUserRepository.findOneById(id);
    
        if(endUser == null){ 
            return false; 
        }
    
        endUser.setBlocked(true);
     
        endUserRepository.save(endUser);
        
        return true;
    }
     
    @Transactional 
    public Boolean unblock(Long id){ 
        EndUser endUser = endUserRepository.findOneById(id);
     
        if(endUser == null){
            return false;
        }
     
        endUser.setBlocked(false); 
        endUserRepository.save(endUser);
     
        return true;
    }

    public List<Long> getRentedCars(Long userId){
        System.out.println(userId + "ID ENDUSERA");
		EntityUser user = userRepository.findOneByid(userId); //treba dobiti usera po id
		List<Long> list = new ArrayList<>();
		EndUser endUser = endUserRepository.findByUser(user);

		for(int i = 0;i < endUser.getRentedCars().size(); i++){
			list.add(endUser.getRentedCars().get(i));
		}

		return list;
    }
    
    public String getEmail(Long id){
        EndUser endUser = endUserRepository.findOneById(id);

        return endUser.getUser().getLoginInfo().getEmail();
    }
}
