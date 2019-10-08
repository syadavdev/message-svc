package com.sandi.message.controller;

import com.sandi.message.model.Message;
import com.sandi.message.repository.MessageRepository;
import com.sandi.message.service.MessageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private MessageRepository messageRepository;
    private MessageService messageService;

    public MessageController(MessageRepository messageRepository, MessageService messageService){
        this.messageRepository = messageRepository;
        this.messageService = messageService;
    }

    @PostMapping("/send")
    @ApiOperation(value = "To Send Message's")
    @ApiResponse(code = 400, message = "Bad Request")
    @PreAuthorize("hasAuthority('ROLE')")
    public ResponseEntity sendMessage(@NotNull @RequestBody Message message){
        return ResponseEntity.status(HttpStatus.OK).body(messageRepository.save(message));
    }

    @GetMapping("/get")
    @ApiOperation(value = "To Get All Message's")
    @ApiResponse(code = 400, message = "Bad Request")
    @PreAuthorize("hasAuthority('ROLE1')")
    public ResponseEntity getMessages(){
        return ResponseEntity.status(HttpStatus.OK).body(messageRepository.findAll());
    }

    @PostMapping("/sendMessage")
    @ApiOperation(value = "To Send Message's")
    @ApiResponse(code = 400, message = "Bad Request")
    public ResponseEntity send(@NotNull @RequestBody String message){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.send(message));
    }
}
