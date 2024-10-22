package com.kosal.modernPhoneshop.mobile_phone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="models")
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "mySeqGene")
	@SequenceGenerator(name="mySeqGene",sequenceName = "models_model_id_seq",initialValue = 100,allocationSize = 1)
	@Column(name = "model_id",updatable = false,nullable = false)
	private Long id;
	@Column(name="model_name")
	private String name;
	@ManyToOne
	@JoinColumn(name="brandId")
	private Brand brand;
	

}
