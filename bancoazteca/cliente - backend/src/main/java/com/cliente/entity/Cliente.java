package com.cliente.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="auto_clienteId")
	@SequenceGenerator(name="auto_clienteId", sequenceName="CLIENTE_SEQ", allocationSize=1)
	@Column(name="CLIENTE_ID", columnDefinition="NUMBER")
	private int clienteId;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(20)")
	private String nombre;
	
	@Column(name="FECHA_NAC", columnDefinition="DATE")
	private Date fechaNac;
	
	@Column(name="CELULAR", columnDefinition="NVARCHAR2(10)")
	private String celular;
	
	@Column(name="CORREO", columnDefinition="NVARCHAR2(25)")
	private String correo;

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
