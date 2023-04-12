package com.example.retoapp.service;

import com.example.retoapp.modelo.entidad.Gama;
import com.example.retoapp.modelo.repositorio.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamaService {
    @Autowired
    private GamaRepository repository;
     public List<Gama> getAll(){
         return repository.findAll();
     }
      public Gama save(Gama gama){
         return repository.save(gama);
      }

}
