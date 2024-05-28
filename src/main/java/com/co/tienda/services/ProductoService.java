package com.co.tienda.services;

import com.co.tienda.models.Producto;
import java.util.List;
import net.sf.jasperreports.engine.JRException;



public interface ProductoService {

    public List<Producto> getAllProducto() throws Exception;

    static Producto addProducto(Producto producto) throws Exception {

        throw new Exception("Unimplemented method 'addProducto'");
    }
     Producto updateProducto (Producto prodcuto) throws Exception;
     


    void deleteProducto(Long id) throws Exception;

    Producto getProductoById(Long id) throws Exception;


    void updateCantidad(Long id, int cantidad) throws Exception;
     byte[] exportPdf() throws JRException;
}
