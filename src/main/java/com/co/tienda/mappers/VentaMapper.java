package com.co.tienda.mappers;


import com.co.tienda.models.Venta; 
import com.co.tienda.dtos.VentaDTO; 



public interface VentaMapper {

VentaDTO toventaDTO (Venta venta); 
Venta toVenta (VentaDTO ventaDTO);

}
