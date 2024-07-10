package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.MessageDTO;
import com.example.demo.responses.MessageListResponse;
import com.example.demo.responses.MessageResponse;
import com.example.demo.services.MessageService;

@RestController
@RequestMapping({"/messages", "/messages/"})
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<MessageListResponse> getAllMessages() {
        ArrayList<MessageDTO> result = this.messageService.getAll();
        MessageListResponse response = new MessageListResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> findMessage(@PathVariable Integer id) {
        MessageDTO result = messageService.findMessage(id);
        MessageResponse response = new MessageResponse(result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> crateMessage(@RequestBody MessageDTO body) {
        MessageDTO result = messageService.createMessage(body.name, body.message);
        MessageResponse response = new MessageResponse(result);
        return ResponseEntity.ok(response);
    }
}
