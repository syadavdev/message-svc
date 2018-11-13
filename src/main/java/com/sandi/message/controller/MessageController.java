package com.sandi.message.controller;

import com.sandi.message.model.Message;
import com.sandi.message.repository.MessageRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class MessageController {

    private MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @PostMapping("/send")
    @ApiOperation(value = "To Send Message's")
    @ApiResponse(code = 400, message = "Bad Request")
    public ResponseEntity sendMessage(@NotNull @RequestBody Message message){
        return ResponseEntity.status(HttpStatus.OK).body(messageRepository.save(message));
    }

    @GetMapping("/get")
    @ApiOperation(value = "To Get All Message's")
    @ApiResponse(code = 400, message = "Bad Request")
    public ResponseEntity getMessages(){
        return ResponseEntity.status(HttpStatus.OK).body(messageRepository.findAll());
    }
}
