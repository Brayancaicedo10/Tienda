package com.co.tienda.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.co.tienda.models.Cliente;



public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}
