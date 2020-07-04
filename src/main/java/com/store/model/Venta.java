package com.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false,
            foreignKey = @ForeignKey(name = "fk_venta_persona"))
    private Persona persona;

    @Column(name = "importe", nullable = false)
    private double importe;

    @OneToMany(mappedBy = "venta", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;

}
