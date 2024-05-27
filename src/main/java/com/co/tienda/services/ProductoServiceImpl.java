package com.co.tienda.services;

import com.co.tienda.models.Producto;
import com.co.tienda.repository.ProductoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    // @Autowired

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;

    }

    /// @Override
    @Transactional(readOnly = true)
    public List<Producto> getAllProducto() throws Exception {
        List<Producto> producto = new ArrayList <Producto>();
        try {

            producto = (productoRepository).findAll();
        } catch (Exception e) { 
            throw new Exception("No productos found");

        } finally {

        }
        return producto;
    
    }
    
    // @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Producto addProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Producto is null");
            }
        } catch (Exception e) {
            throw new Exception("No productos found");
        } finally {

        }
        return productoRepository.save(producto);
    }


    @Override
    @Transactional(readOnly = true)
    public Producto getProductoById(Long id) throws Exception{
        if (id == null) {
            throw new Exception("Id is null");
        }
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new Exception("Producto not found with id: " + id));
        return producto;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Producto updateProducto(Producto producto) throws Exception{
        if (producto == null) {
            throw new Exception("Producto is null");
        }
        return productoRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteProducto(Long id) throws Exception{
        if (id == null) {
            throw new Exception("Id is null");
        }
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new Exception("Producto not found with id: " + id));
        productoRepository.delete(producto);

    }

    public void updateCantidad(Long id, int cantidad) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setCantidad(cantidad);
            productoRepository.save(producto);
        }
    }


    public void getInventarioRestante() {
        List<Producto> productos = productoRepository.findAll();
        for (Producto producto : productos) {
            int cantidadVendida = getCantidadVendida(producto);
            producto.setCantidad(producto.getCantidad() - cantidadVendida);
            productoRepository.save(producto);
        }
    }

    private int getCantidadVendida(Producto producto) {

        throw new UnsupportedOperationException("Unimplemented method 'getCantidadVendida'");
    }


    
    

   
}