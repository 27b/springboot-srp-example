package com.example.demo.responses;

import java.util.ArrayList;

import com.example.demo.dtos.MessageDTO;

public class MessageListResponse {
    ArrayList<MessageDTO> messages;

    public MessageListResponse(ArrayList<MessageDTO> messages) {
        this.messages = messages;
    }

    public ArrayList<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageDTO> messages) {
        this.messages = messages;
    }
}
