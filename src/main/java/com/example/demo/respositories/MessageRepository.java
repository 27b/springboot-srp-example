package com.example.demo.respositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}