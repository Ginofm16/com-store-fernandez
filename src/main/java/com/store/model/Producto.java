package com.store.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Size(min = 3, message = "Nombre debe tener mas de 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(min = 1, message = "Marca debe tener mas de 1 caracter")
    @Column(name = "marca", nullable = false, length = 150)
    private String marca;

}
