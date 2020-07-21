package com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository;


import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EntityUser, Long> {

    public EntityUser findByLoginInfo_EmailAndLoginInfo_Password(String email, String password);

    public EntityUser findByJmbg(String jmbg);


    public  EntityUser findOneByid(Long id);

    public EntityUser findByLoginInfo_Email(String email);

    public EntityUser findByLoginInfo_Username(String username);



}
