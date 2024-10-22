package com.kosal.modernPhoneshop.mobile_phone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;

import lombok.Data;

@Data
@Entity
@Table(name="brands")
public class Brand {
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "mySeqGen")
	@SequenceGenerator(name="mySeqGen",sequenceName = "brands_brand_id_seq",initialValue = 1,allocationSize = 1)
	@Column(name="brand_id",updatable = false,nullable=false)
	private Long id;
	@Column(name="brand_name")
	private String name;

}
