package com.Advertisement.Advertisement.service;

import javax.transaction.Transactional;

import com.Advertisement.Advertisement.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Transactional
    public void deleteByEndUserID(Long id){
        commentRepository.deleteByEndUserID(id);
    }
    
}