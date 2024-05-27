package com.co.tienda.models;

import jakarta.persistence.*; 
import java.sql.Date;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ventaId;
    private Long productoId;
    private Integer cantidadVendida;
    private Date fecha;


    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "precio_total")
    private Double precioTotal;
   

    public Long getventaId() {
        return this.ventaId;
    }

    public void setventaId(Long ventaId) {
        this.ventaId = ventaId;
    }

    public Long getProductoId() {
        return this.productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidadVendida() {
        return this.cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioTotal() {
        return this.precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
