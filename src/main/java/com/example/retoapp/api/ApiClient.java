package com.example.retoapp.api;

import com.example.retoapp.modelo.entidad.Client;
import com.example.retoapp.modelo.repositorio.ClientRepository;
import com.example.retoapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Client")
@CrossOrigin("*")
public class ApiClient {
    @Autowired
    private ClientService service;
    @GetMapping("/all")
    public List<Client> getAll(){
         return service.getAll();
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Client client){
       service.save(client);
        return ResponseEntity.status(201).build();
    }
}