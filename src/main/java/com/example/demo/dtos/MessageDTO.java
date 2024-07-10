package com.example.demo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDTO {
    public int id;
    public String name;
    public String message;

    public MessageDTO(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
