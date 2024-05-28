package com.co.tienda.services;

import com.co.tienda.models.Venta;

import net.sf.jasperreports.engine.JRException;

import java.util.List; 



public interface VentaService {



    public List<Venta> getAllVentas() throws Exception;

    Venta getVentaById(Long ventaId) throws Exception;

    Venta registrarVenta(Long ventaId, Long productoId, int cantidadVendida) throws Exception;

    void deleteVenta(Long ventaId) throws Exception;
     byte[] exportPdf() throws JRException;
}
