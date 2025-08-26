package com.equipo5.backend.model;


/*Feature M-04: Crear la entidad Booking
Tareas:
Definir la clase Booking con atributos: id, startTime, endTime, status.
Establecer relaciones @ManyToOne hacia Pet, Service y User (owner).
*/

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startTime;

    private LocalDate endTime;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pets;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity services;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owners;
}
