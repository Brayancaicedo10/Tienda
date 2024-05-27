package com.co.tienda.repository; 


import org.springframework.data.jpa.repository.JpaRepository;

import com.co.tienda.models.Producto;




public interface ProductoRepository extends JpaRepository <Producto, Long>
{

}