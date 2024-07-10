package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.MessageDTO;
import com.example.demo.models.Message;
import com.example.demo.respositories.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageDTO createMessage(String name, String message) {
        Message messageToStore = new Message();
        messageToStore.setName(name);
        messageToStore.setMessage(message);
        
        Message result = this.messageRepository.save(messageToStore);
        
        MessageDTO resultCleaned = new MessageDTO(name, message);
        resultCleaned.setId(result.getId());

        return resultCleaned;
    }

    public MessageDTO findMessage(Integer id) {
        Optional<Message> message = this.messageRepository.findById(id);
        
        if (!message.isPresent()) {
            return new MessageDTO(null, null);
        }

        Message messageData = message.get();

        return modelMapper.map(messageData, MessageDTO.class);
    }

    public ArrayList<MessageDTO> getAll() {
        List<Message> messages = this.messageRepository.findAll();
        ArrayList<MessageDTO> messageDTOs = new ArrayList<MessageDTO>();

        for (Message message : messages) {
            messageDTOs.add(modelMapper.map(message, MessageDTO.class));
        }

        return messageDTOs;
    }
}
