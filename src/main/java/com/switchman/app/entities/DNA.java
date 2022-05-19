package com.switchman.app.entities;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "dna_bd")
public class DNA implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "dnainformation")
	@NotNull
	private String dnaInformation;

	@Column(name = "ismutant")
	private boolean isMutant;

	public void Dna() {
	}

	public void Dna(String dnaInformation) {

		this.dnaInformation = dnaInformation;

	}


}