package com.example.retoapp.modelo.repositorio;

import com.example.retoapp.modelo.entidad.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
}
