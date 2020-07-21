package com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
