package com.AthorizationAndAuthentication.AthorizationAndAuthentication.controller;


import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EndUser;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EntityUser;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.LoginInfo;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.AgentService;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.LoginInfoService;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginInfoService loginInfoService;

    @Autowired
    private AgentService agentService;

    @GetMapping("/hello")
    public ResponseEntity<?> get() {

        return new ResponseEntity<>(String.format("NEMANJA "), HttpStatus.OK);
    }
    /*
     * @PostMapping(value = "/login") public String Login(){
     * 
     * 
     * 
     * System.out.println("PROSO PROSO");
     * 
     * return "proslo"; }
     */

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginInfo> Login(@RequestBody LoginInfo login) {

        LoginInfo loginInfo = loginInfoService.findOneByUsername(login.getUsername());
        if (loginInfo == null) {
            System.out.println("Wrong username or password");
            return new ResponseEntity<>(loginInfo, HttpStatus.BAD_REQUEST);
        }

        userService.saveUser(loginInfo);

        return new ResponseEntity<>(loginInfo, HttpStatus.OK);
    }

    @GetMapping(value = "/loginToken")
    public ResponseEntity getToken() {

        System.out.println("POGODIO JE LOGIN TOKEN");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * @PostMapping(value = "/login", produces=MediaType.APPLICATION_JSON_VALUE,
     * consumes=MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<EntityUser>
     * Login(@RequestBody EntityUser user){
     * 
     * System.out.println(user.getLoginInfo().getEmail() + " " +
     * user.getLoginInfo().getPassword());
     * 
     * //provera email-a i username-a: EntityUser userDB =
     * userService.findUserByEmailAndPassword(user); if(userDB == null){
     * System.out.println("Wrong username or password"); return new
     * ResponseEntity<>(user, HttpStatus.BAD_REQUEST); }
     * 
     * 
     * userService.saveUser(userDB);
     * 
     * return new ResponseEntity<>(userDB, HttpStatus.OK); }
     */

    @GetMapping(value = "/logout")
    public ResponseEntity getAllForCart() {

        System.out.println("izbrisao sve proslo izlogovan");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getUserId")
    public ResponseEntity<Long> getUserId() {

        return new ResponseEntity<>(userService.getLoggedUser(), HttpStatus.OK);
    }

    @GetMapping(value = "/getLoggedEndUser")
    public ResponseEntity<EndUser> getLoggedEndUser() {

        return new ResponseEntity<>(userService.getLoggedEndUser(), HttpStatus.OK);
    }

    @GetMapping(value = "/getUserByUsername/{username}")
    public ResponseEntity<EntityUser> getUserByUsername(@PathVariable("username") String username) {

        EntityUser user = userService.findByUsername(username);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/increaseEndUsersNumberOfAds")
    public ResponseEntity<Long> increaseEndUsersNumberOfAds() {

        return new ResponseEntity<>(userService.increaseEndUsersNumberOfAds(), HttpStatus.OK);
    }

    @GetMapping(value= "/getAll")
    public ResponseEntity<List<EntityUser>> getAllUsers(){


        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);

    }

    @PostMapping(value = "/getAgentIDByMail", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Long> getAgentIDByMail(@RequestBody String email){
        return new ResponseEntity<>(agentService.getAgentIDByEmail(email), HttpStatus.OK);
    }

    @PostMapping(value = "/getAgentEmail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getAgentMail(@RequestBody Long id){
        return new ResponseEntity<>(agentService.getAgentMail(id), HttpStatus.OK);
    }

    // @PostMapping(value = "/passwordChange", produces =
    // MediaType.APPLICATION_JSON_VALUE, consumes =
    // MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Long> changePassword(@RequestBody UserDTO userDTO){
    // userService.changePassword(userDTO.getJmbg(), userDTO.getPassword());

    // return new ResponseEntity<Long>((long) 1, HttpStatus.OK);
    // }

}
