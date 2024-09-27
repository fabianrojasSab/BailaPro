package com.byteCreaColombia.mtto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PAGOS")
public class Pago implements Serializable{

	private static final long serialVersionUID = 1L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Estudiante estudiante_id;
	
	@NotNull
	@Digits(integer = 6, fraction = 2)
	private BigDecimal monto;
	
	@NotNull
	private LocalDateTime fecha_pago;
	
	@NotNull	
	private String concepto;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estudiante getEstudiante_id() {
		return estudiante_id;
	}

	public void setEstudiante_id(Estudiante estudiante_id) {
		this.estudiante_id = estudiante_id;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public LocalDateTime getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(LocalDateTime fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
}
