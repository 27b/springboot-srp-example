package com.example.demo.responses;

import com.example.demo.dtos.MessageDTO;

public class MessageResponse {
    MessageDTO message;

    public MessageResponse(MessageDTO message) {
        this.message = message;
    }

    public MessageDTO getMessage() {
        return message;
    }
}
