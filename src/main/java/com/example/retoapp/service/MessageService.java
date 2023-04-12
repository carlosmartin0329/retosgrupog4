package com.example.retoapp.service;

import com.example.retoapp.modelo.entidad.Message;
import com.example.retoapp.modelo.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    public List<Message> getAll(){
        return repository.findAll();
    }
    public Message save(Message message){
        return repository.save(message);
    }
}
