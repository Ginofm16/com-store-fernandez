package com.store.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Size(min = 3, message = "Nombre debe tener mas de 3 caracteres")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @Size(min = 3, message = "Apellidos debe tener mas de 3 caracteres")
    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

}
