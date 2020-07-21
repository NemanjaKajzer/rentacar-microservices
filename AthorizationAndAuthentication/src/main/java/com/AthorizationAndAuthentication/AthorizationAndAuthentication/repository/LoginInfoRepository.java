package com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long> {

    public LoginInfo findByEmail(String password);
    public LoginInfo findByUsername(String username);
    public LoginInfo findOneById(Long id);
}
