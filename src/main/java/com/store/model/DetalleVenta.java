package com.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false,
            foreignKey = @ForeignKey(name = "fk_detalle_venta"))
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false,
            foreignKey = @ForeignKey(name = "fk_detalle_producto"))
    private Producto producto;

}
