package com.co.tienda.mappers;



import com.co.tienda.dtos.ProductoDTO;
import com.co.tienda.models.Producto;



public interface ProductoMapper {

    ProductoDTO toproductoDTO(Producto producto);
    Producto toProducto(ProductoDTO productoDTO);
}
