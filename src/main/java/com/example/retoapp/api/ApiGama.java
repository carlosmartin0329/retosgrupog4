package com.example.retoapp.api;

import com.example.retoapp.modelo.entidad.Gama;
import com.example.retoapp.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gama")
@CrossOrigin("*")

public class ApiGama {
    @Autowired
    private GamaService service;
    @GetMapping("/all")
    public List<Gama> getGamaAll(){
        return service.getAll();
    }
    @PostMapping("/save")
    public ResponseEntity saveGama(@RequestBody Gama gama){
        service.save(gama);
        return ResponseEntity.status(201).build();
    }
}
