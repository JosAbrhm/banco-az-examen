package com.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.entity.Cliente;
import com.cliente.request.ClienteRequest;
import com.cliente.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService srv;
	
	@GetMapping("mostrar-todos")
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> list
		
		= srv.mostrar();
		return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
	}
	
	@GetMapping("buscar-por-id/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable int id){
		Cliente c = srv.buscar(id);			
		return new ResponseEntity<Cliente>( c, HttpStatus.OK);
	}
	
	@PostMapping("guardar")
	public ResponseEntity<Cliente> guardar(@RequestBody ClienteRequest req) {
		Cliente c = srv.guardar(req);
		return new ResponseEntity<Cliente>( c,HttpStatus.OK);
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<Cliente> actualizar( @RequestBody ClienteRequest req) {
		Cliente c = srv.actualizar(req);
		return new ResponseEntity<Cliente>( c,HttpStatus.OK);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		String mensaje = srv.eliminar(id);
		return new ResponseEntity<String>(mensaje, HttpStatus.OK);
	}

}
