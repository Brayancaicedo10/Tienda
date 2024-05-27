package com.co.tienda.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productoid")
    private Long productoid;
    private String nombre;
    private String descripcion;
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    public Long getProductoid() {
        return this.productoid;
    }

    public void setProductoid(Long productoid) {
        this.productoid = productoid;
    }

   public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}
