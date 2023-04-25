package com.example.retoapp.service;


import com.example.retoapp.modelo.entidad.Reservation;
import com.example.retoapp.modelo.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll(){
        return repository.findAll();
    }
    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }
    public Optional<Reservation> getFindById(long id){
        return repository.findById(id);
    }
    public Reservation updateReservation(Reservation reservation){
        Optional<Reservation> reservationUpdate = getFindById(reservation.getIdReservation());
        if(reservationUpdate.isPresent()){
            reservationUpdate.get().setStartDate(reservation.getStartDate());
            reservationUpdate.get().setDevolutionDate(reservation.getDevolutionDate());
            reservationUpdate.get().setStatus(reservation.getStatus());
            reservationUpdate.get().setCar(reservation.getCar());
            reservationUpdate.get().setClient(reservation.getClient());
            return repository.save(reservationUpdate.get());
        }
        else{
            return reservation;
        }
    }
    public void deleteReservation(long id){
        repository.deleteById(id);
    }
    public List<Reservation>getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date ();
        Date b = new Date ();
        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);

        } catch (ParseException e){
            e.printStackTrace();
        }
        if (a.before(b)){
            return  repository.findAllByStartDateAfterAndStartDateBefore(a,b);
        }
        else{
            return new ArrayList<>();
        }
    }
}
