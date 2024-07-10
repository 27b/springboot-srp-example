package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dtos.MessageDTO;
import com.example.demo.services.MessageService;

import jakarta.transaction.Transactional;

@SpringBootTest
class MessageServiceTests {

	@Autowired
	private MessageService messageService;

	@Test
	@Transactional
	public void testMessageCreation() {
		MessageDTO message = messageService.createMessage("Jhon", "Hello World");

		assertEquals(message.getName(), "Jhon");
		assertEquals(message.getMessage(), "Hello World");
	}

	@Test
	@Transactional
	public void testMessageFind() {
		MessageDTO message = messageService.createMessage("Jhon", "Hello World");
		MessageDTO result = messageService.findMessage(message.getId());

		assertEquals(result.getId(), message.getId());
		assertEquals(result.getName(), message.getName());
		assertEquals(result.getMessage(), message.getMessage());
	}

}
