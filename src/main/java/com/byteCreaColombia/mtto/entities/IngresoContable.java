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
@Table(name = "INGRESOS_CONTABLES")
public class IngresoContable implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String concepto;
	
	@NotNull
	@Digits(integer = 6, fraction = 2)
	private BigDecimal monto;
	
	@NotNull
	private LocalDateTime  fecha_ingreso;
	
	@OneToOne
	private Usuario usuario_id;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public LocalDateTime getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(LocalDateTime fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

}
