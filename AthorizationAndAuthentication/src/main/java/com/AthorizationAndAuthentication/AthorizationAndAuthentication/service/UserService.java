package com.AthorizationAndAuthentication.AthorizationAndAuthentication.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpSession;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.*;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.*;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.security.*;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private EndUserService endUserService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private VerificationTokenService verificationTokenService;

    @Autowired
    private LoginInfoService loginInfoService;

    @Autowired
    private EndUserRepository endUserRepository;

    // @Autowired
    // private LoggerService loggerService;

    @Autowired
    private SessionService sessionService;

    private HttpSession session;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public EntityUser findUserByEmailAndPassword(EntityUser user) {
        return userRepository.findByLoginInfo_EmailAndLoginInfo_Password(user.getLoginInfo().getEmail(),
                user.getLoginInfo().getPassword());
    }

    public void saveUser(LoginInfo log) {

        // Sacuvati korisnika u sesiji
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        session = attr.getRequest().getSession(true);

        for (EntityUser user : userRepository.findAll()) {

            if (user.getLoginInfo().getId().equals(log.getId())) {
                session.setAttribute("user", user.getId());
            }

        }

        System.out.println("//////////////////");
        System.out.println((Long) session.getAttribute("user"));
        System.out.println("//////////////////");

    }

    public Long getLoggedUser() {

        Long userId = (Long) session.getAttribute("user");
        return userId;

    }

    public EndUser getLoggedEndUser() {
        List<EndUser> all = endUserRepository.findAll();
        Long userId = (Long) session.getAttribute("user");

        for (EndUser endUser : all) {
            if (endUser.getUser().getId().equals(userId)) {
                return endUser;
            }
        }
        return null;
    }

    public int getEndusersNumberOfAds(Long endUserId) {
        EndUser endUser = endUserRepository.findOneById(endUserId);
        if (endUser == null) {
            return 0;
        }
        return endUser.getNumberOfAds();
    }

    public List<EntityUser> getAll() {

        return userRepository.findAll();
    }

    public Long increaseEndUsersNumberOfAds() {
        EndUser endUser = getLoggedEndUser();
        endUser.setNumberOfAds(endUser.getNumberOfAds() + 1);
        endUserRepository.save(endUser);
        return endUser.getId();
    }

    public void saveInDatabase(EntityUser entity) {

        userRepository.save(entity);

    }

    public EntityUser findByUsername(String username) {
        return userRepository.findByLoginInfo_Username(username);
    }
    /*
     * public void saveNewUser(EntityUser entityUser){
     * 
     * String salt=makeSalt();
     * 
     * System.out.println("Naso ga je lepo"+ findOneByid(entityUser.getId()));
     * 
     * System.out.println("HESOVAN PASSWORD == "+hashIt(entityUser.getPassword(),
     * salt));
     * 
     * LoginInfo loginInfo=new LoginInfo( entityUser.getUsername(),
     * hashIt(entityUser.getPassword(),salt ), entityUser.getLoginInfo().getEmail(),
     * salt, ApplicationUserRole.ENDUSER.getGrantedAuthorities(), true, true, true,
     * true);
     * 
     * loginInfoService.save(loginInfo);
     * 
     * entityUser.setLoginInfo(loginInfoService.findOneById(loginInfo.getId()));
     * 
     * //cuvanje u bazi saveInDatabase(entityUser);
     * 
     * EndUser endUser=new EndUser();
     * 
     * endUser.setNumber_of_requests(0); endUser.setAccount_activated(false);
     * endUser.setAdminApproved(false);
     * endUser.setUser(findOneByid(entityUser.getId()));
     * 
     * 
     * endUserService.save(endUser);
     * 
     * 
     * // String verificationToken = UUID.randomUUID().toString(); //
     * verificationTokenService.save(endUser, verificationToken); }
     */

    public void saveNewUser(EntityUser entityUser) {

        String salt = makeSalt();

        System.out.println("Naso ga je lepo" + findOneByid(entityUser.getId()));

        System.out.println("HESOVAN PASSWORD == " + hashIt(entityUser.getPassword(), salt));

        LoginInfo loginInfo = new LoginInfo(entityUser.getUsername(), entityUser.getPassword(),
                entityUser.getLoginInfo().getEmail(),
                // salt,
                // ApplicationUserRole.ENDUSER.getGrantedAuthorities(),
                true, true, true, true);

        loginInfoService.save(loginInfo);

        entityUser.setLoginInfo(loginInfoService.findOneById(loginInfo.getId()));

        // cuvanje u bazi
        saveInDatabase(entityUser);

        EndUser endUser = new EndUser();

        endUser.setNumberOfRequestsCanceled(0);
        endUser.setAccount_activated(false);
        endUser.setAdminApproved(false);
        endUser.setUser(findOneByid(entityUser.getId()));
        endUser.setNumberOfAds(0);

        endUserService.save(endUser);

        // String verificationToken = UUID.randomUUID().toString();
        // verificationTokenService.save(endUser, verificationToken);
    }

    private String hashIt(String password, String salt) {

        String passwordPlusSalt = password + salt;

        String hashedPassword = passwordEncoder.encode(passwordPlusSalt);

        return hashedPassword;

    }

    private String makeSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        return token;
    }

    public void logOut() {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        session.invalidate();
        System.out.println("Izlogovao se");
    }

    // public void changePassword(String jmbg, String password){
    // EntityUser user = userRepository.findByJmbg(jmbg);
    // System.out.println(user);
    // if(user.getUserType() == UserType.AGENT){
    // Agent agent = agentRepository.findByJmbg(jmbg);

    // agent.setFirst_login(false);
    // agent.setPassword(password);

    // agentRepository.save(agent);
    // }else{
    // user.setPassword(password);
    // userRepository.save(user);
    // }
    // }

    public List<EntityUser> findAll() {
        return userRepository.findAll();
    }

    public EntityUser findOneByid(Long id) {
        return userRepository.findOneByid(id);
    }
}
