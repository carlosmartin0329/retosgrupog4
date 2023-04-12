package com.example.retoapp.api;

import com.example.retoapp.modelo.entidad.Message;
import com.example.retoapp.modelo.entidad.Reservation;
import com.example.retoapp.service.MessageService;
import com.example.retoapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("api/Reservation")
    @CrossOrigin("*")

    public class ApiReservation {
        @Autowired
        private ReservationService service;
        @GetMapping("/all")
        public List<Reservation>gerAll(){
            return service.getAll();
        }   @PostMapping("/save")
        public ResponseEntity save(@RequestBody Reservation reservation){
            service.save(reservation);
            return ResponseEntity.status(201).build();

        }
    }

