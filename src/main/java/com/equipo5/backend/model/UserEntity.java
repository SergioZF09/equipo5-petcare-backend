package com.equipo5.backend.model;


import com.equipo5.backend.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name ="users")
public class UserEntity extends TimeStampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String avatarUser;

    @Enumerated(EnumType.STRING)
    private Role rol;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    @OneToMany(mappedBy = "sitters", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceEntity> services = new ArrayList<>();

    @OneToMany(mappedBy = "owners", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

}
