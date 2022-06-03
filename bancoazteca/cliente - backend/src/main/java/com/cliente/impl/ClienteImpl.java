package com.cliente.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.entity.Cliente;
import com.cliente.repository.ClienteRepository;
import com.cliente.request.ClienteRequest;
import com.cliente.service.ClienteService;

@Service
public class ClienteImpl implements ClienteService{
	
	@Autowired
	ClienteRepository repo;

	@Override
	public Cliente guardar(ClienteRequest cliente) {
		Cliente c = new Cliente();
		
		c.setNombre(cliente.getNombre());
		c.setFechaNac(cliente.getFechaNac());
		c.setCorreo(cliente.getCorreo());
		c.setCelular(cliente.getCelular());
		repo.save(c);
		return c;
	}

	@Override
	public Cliente actualizar(ClienteRequest cliente) {
		
		Cliente c = repo.findById(cliente.getClienteId()).get();
		c.setNombre(cliente.getNombre());
		c.setFechaNac(cliente.getFechaNac());
		c.setCorreo(cliente.getCorreo());
		c.setCelular(cliente.getCelular());
		repo.save(c);
		return c;
	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public String eliminar(int id) {
		Cliente c = repo.findById(id).get();
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List<Cliente> mostrar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
