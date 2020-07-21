package com.AthorizationAndAuthentication.AthorizationAndAuthentication.controller;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EndUser;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.LoginInfo;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EntityUser;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.VerificationToken;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.AgentRepository;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.AgentService;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.EndUserService;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.MailSenderService;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.UserService;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.VerificationTokenService;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;



import javax.print.attribute.standard.Media;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import java.util.UUID;
import java.util.Base64.Encoder;


@RestController
public class EndUserController {

    @Autowired
    private EndUserService endUserService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private VerificationTokenService verificationTokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private AgentService agentService;


    private final RabbitTemplate rabbitTemplate;

	public EndUserController(RabbitTemplate rabbitTemplate){
		this.rabbitTemplate=rabbitTemplate;
	}

 

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody EntityUser entityUser){
        System.out.println("OVO SU PODATCI:"+entityUser.getLoginInfo());

        LoginInfo loginInfo;

        loginInfo = endUserService.findByEmail(entityUser.getLoginInfo().getEmail());
        if(loginInfo != null){
            return new ResponseEntity<>("email", HttpStatus.BAD_REQUEST);
        }

        loginInfo = endUserService.findByUsername(entityUser.getLoginInfo().getUsername());
        if(loginInfo != null){
            return new ResponseEntity<>("username", HttpStatus.BAD_REQUEST);
        }

        EntityUser user = endUserService.findByJmbg(entityUser.getJmbg());
        if(user != null){
            return new ResponseEntity<>("jmbg", HttpStatus.BAD_REQUEST);
        }


        userService.saveNewUser(entityUser);
        
        HttpEntity<Long> request = new HttpEntity<>(entityUser.getId());
       

        // restTemplate.postForEntity("http://book/createShoopingCart", request,Long.class, entityUser.getId());
        
       // rabbitTemplate.convertAndSend("booking-exchange","foo.bar.booking", entityUser.getId().toString());

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

   

    @GetMapping(value = "/getUnregistered", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EndUser>> getUnregistered(){
        List<EndUser> users = endUserService.getUnregistered();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/getAdminUnregistered", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EndUser>> getAdminUnregistered(){
        List<EndUser> users = endUserService.getAdminUnregistered();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/accept", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> acceptRegistration(@RequestBody Long id){
        EndUser endUser = endUserService.changeAdminActivated(id);
        VerificationToken verificationToken = verificationTokenService.findByUser(endUser);

        try {
            mailSenderService.sendSimpleMessage(endUser.getUser().getLoginInfo().getEmail(), "Aktivacioni link",
                    "Vaša registracija je prihvaćena! Kliknite na link da bi aktivirali vaš nalog i koristili usluge našeg servisa!\n\n"
                            + "http://localhost:4200/registrationConfirm.html?token=" + verificationToken.getToken());
        }catch (Exception e){
            System.out.println("Slanje mail-a nije uspelo!");
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/reject", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> rejectRegistration(@RequestBody Long id){
        verificationTokenService.delete(id);
        endUserService.rejectRegistration(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/registrationConfirm")
    public ResponseEntity<Long> confirmRegistration(@RequestBody String token){
        System.out.println("usao je ovde");
        VerificationToken verificationToken = verificationTokenService.findByToken(token);

        if(verificationToken == null){
            return new ResponseEntity(1, HttpStatus.BAD_REQUEST);
        }

        //iz nekog razloga ne vraca nista na front, servis se nikad ne izvrsi na frontu i ne ode na homepage, vecno se zaglavi u ucitavanju

        EndUser endUser = verificationToken.getUser();
        endUserService.acceptRegistration(endUser.getId());
        verificationTokenService.delete(endUser.getId());
        return new ResponseEntity(0, HttpStatus.OK);
    }

    @GetMapping(value = "/getRegisteredUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EndUser>> getRegisteredUsers(){
        List<EndUser> data = endUserService.getRegisteredUsers();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping(value = "/deactivate/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deactivateAccount(@PathVariable("id") Long id){
        HttpEntity<Long> request = new HttpEntity<>(id);

        restTemplate.postForEntity("http://advert/deleteCommentsByEndUserID", request, Void.class, id);

        endUserService.deactivate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/block/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> blockAccount(@PathVariable("id") Long id){
        Boolean ret = endUserService.block(id);

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping(value = "/unblock/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> unblockAccount(@PathVariable("id") Long id){
        Boolean ret = endUserService.unblock(id);

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/getRentedCars/{id}", produces =
	MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Long>> getRentedCars(@PathVariable Long id) {
		List<Long> rentedCars = endUserService.getRentedCars(id);
		return new ResponseEntity<>(rentedCars, HttpStatus.OK);
    }
    
    @PostMapping(value = "/getEmail", produces = 
    MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getEmail(@RequestBody Long id){
        String email = endUserService.getEmail(id);

        return new ResponseEntity<>(email, HttpStatus.OK);
    }
}
