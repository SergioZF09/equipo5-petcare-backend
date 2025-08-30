package com.equipo5.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*Definir la clase Service con atributos: id, name, description, price.
Establecer la relación @ManyToOne desde Service hacia User (el cuidador).
*/
@Entity
@Data
@NoArgsConstructor
@Table(name = "services")
public class ServiceEntity extends TimeStampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String description;

    private Double rate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity sitters;

    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

}
