package com.co.tienda.services;

import com.co.tienda.models.Producto;
import com.co.tienda.models.Venta;
import com.co.tienda.services.ProductoService;
import com.co.tienda.services.ProductoServiceImpl;
import com.co.tienda.repository.ProductoRepository;
import com.co.tienda.repository.VentaRepository;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    // @Autowired

    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;

    }

    @Transactional(readOnly = true)
    public List<Venta> getAllVentas() throws Exception {
        List<Venta> venta = new ArrayList<Venta>();
        try {

            venta = (ventaRepository).findAll();
        } catch (Exception e) {
            throw new Exception("No ventas found");

        } finally {
        }
        return venta;

    }

    @Override
    @Transactional(readOnly = true)
    public Venta getVentaById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Id is null");
        }
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new Exception("Venta not found with id: " + id));
        return venta;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Venta registrarVenta(Long ventaId, Long productoId, int cantidadVendida) {
        Object productoService;
        Optional <Producto> optionalProducto = productoService.findById(ventaId.().orElseThrow()); 
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            if (producto.getCantidad() >= cantidadVendida) {
                producto.setCantidad(producto.getCantidad() - cantidadVendida);
                ((ProductoService) productoService).updateCantidad(producto.getProductoid(), producto.getCantidad());
               
                Venta venta = new Venta();
                venta.setProductoId(productoId);
                venta.setCantidadVendida(cantidadVendida);
                venta.setPrecioUnitario(producto.getPrecioUnitario());
                venta.setPrecioTotal(producto.getPrecioUnitario() * cantidadVendida);
                venta.setFecha(null); 

                return ventaRepository.save(venta);
            } else {
                throw new Exception("Cantidad de inventario insuficiente");
            }
        }
        throw new Exception("Producto no encontrado con ID: " + productoId);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteVenta (Long id) throws Exception{
        if (id == null) {
            throw new Exception("Id is null");
        }
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new Exception("Producto not found with id: " + id));
        ventaRepository.delete(venta);

    }
}
