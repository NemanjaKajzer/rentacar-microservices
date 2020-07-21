package com.Advertisement.Advertisement.controller;

import java.util.List;

import com.Advertisement.Advertisement.dtos.AdvertisementCreationDTO;
import com.Advertisement.Advertisement.dtos.CommentDTO;
import com.Advertisement.Advertisement.dtos.CommentPreviewDTO;
import com.Advertisement.Advertisement.dtos.ReplyDTO;
import com.Advertisement.Advertisement.model.Advertisement;
import com.Advertisement.Advertisement.service.AdvertisementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentGradeController {
    
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping(value = "/getAllByPostedBy/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdvertisementCreationDTO>> getAllByPostedBy(@PathVariable Long id) { 
       List<AdvertisementCreationDTO> advertisements = advertisementService.getAllByPostedBy(id); 
       return new ResponseEntity<>(advertisements, HttpStatus.OK); 
    }
    
    @PostMapping(value = "/saveReply", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveReply(@RequestBody ReplyDTO replyDTO){
        advertisementService.saveReply(replyDTO);
    
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/saveCommentAndGrade", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> saveCommentAndGrade(@RequestBody CommentDTO commentDTO) {
       advertisementService.saveCommentAndGrade(commentDTO);

       return new ResponseEntity<>((long) 1, HttpStatus.OK);

    }

    @GetMapping(value = "/getUnapprovedComments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentPreviewDTO>> getUnapprovedComments(){
        return new ResponseEntity<>(advertisementService.getUnapprovedComments(), HttpStatus.OK);
    }

    @PostMapping(value = "/approve/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> approve(@PathVariable("id") Long id){
        System.out.println(id + " Id komentara");
        advertisementService.approveComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        advertisementService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}