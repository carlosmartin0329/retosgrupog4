package com.example.retoapp.api;

import com.example.retoapp.modelo.entidad.Message;
import com.example.retoapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Message")
@CrossOrigin("*")

public class ApiMessage {
    @Autowired
    private MessageService service;
    @GetMapping("/all")
    public List<Message> getAll(){
        return service.getAll();
    }
    public ResponseEntity save(@RequestBody Message message){
        service.save(message);
        return ResponseEntity.status(201).build();

    }
}
