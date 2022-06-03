package com.cliente.service;

import java.util.List;

import com.cliente.entity.Cliente;
import com.cliente.request.ClienteRequest;

public interface ClienteService {
	
	Cliente guardar(ClienteRequest cliente);
	Cliente actualizar(ClienteRequest cliente);
	Cliente buscar(int id);
	String eliminar(int id);
	List<Cliente> mostrar();

}
