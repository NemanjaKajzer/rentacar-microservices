package com.AthorizationAndAuthentication.AthorizationAndAuthentication.model;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.enums.*;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.*;
import javax.persistence.*;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int number_ads;

    @Column(name = "first_login")
    private boolean first_login;

    @Column
    private String adress;

    @Column(name ="business_registration_number")
    private String bsregnum;

    @OneToOne
    @JoinColumn
    private EntityUser user;

 

    public Agent(String name, String surname, LoginInfo loginInfo, String jmbg, String phoneNumber, UserType ut, int number_ads, boolean first_login, String adress, String bsregnum) {
        this.number_ads = number_ads;
        this.first_login = first_login;
        this.adress = adress;
        this.bsregnum = bsregnum;
    }

    public Agent(){

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber_ads() {
        return number_ads;
    }

    public void setNumber_ads(int number_ads) {
        this.number_ads = number_ads;
    }

    public boolean isFirst_login() {
        return first_login;
    }

    public void setFirst_login(boolean first_login) {
        this.first_login = first_login;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBsregnum() {
        return bsregnum;
    }

    public void setBsregnum(String bsregnum) {
        this.bsregnum = bsregnum;
    }

    public EntityUser getUser() {
        return this.user;
    }

    public void setUser(EntityUser user) {
        this.user = user;
    }
}
