package com.co.tienda.repository; 


import org.springframework.data.jpa.repository.JpaRepository;

import com.co.tienda.models.Venta;




public interface VentaRepository extends JpaRepository <Venta, Long>
{

}