package com.co.tienda.mappers;

import com.co.tienda.models.Cliente;
import com.co.tienda.dtos.ClienteDTO; 



public interface ClienteMapper {

     ClienteDTO toclienteDTO(Cliente cliente);
    Cliente toCliente(ClienteDTO clienteDTO);

}
