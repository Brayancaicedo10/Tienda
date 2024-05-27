package com.co.tienda.dtos; 



public class ProductoDTO {

private Long productoid;
private String nombre;
private String descripcion;
private Integer cantidad;
private double precioUnitario;
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

    public String getTipoProducto() {
        return this.tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }


}
