package com.Message.Message.repository;

import com.Message.Message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository <Message, Long>{

}