package com.Message.Message.dtos;

public class UserDTO {


    Long id;

    String name;

    String surname;

    LoginInfo loginInfo;


   public UserDTO(){


    }

    
    public UserDTO(Long id, String name, String surname, LoginInfo loginInfo){
        
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.loginInfo=loginInfo;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }




    
}