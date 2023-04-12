package com.example.retoapp.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name="gama")

public class Gama  implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idGama;
   private String name;
   private String description;
   @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "gama")
   @JsonIgnoreProperties("gama")
   private List<Car> Cars;

}
