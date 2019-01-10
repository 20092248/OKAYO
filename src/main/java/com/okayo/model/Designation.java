package com.okayo.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Designation implements java.io.Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Embedded
	private Prestation prestation;
	
	@Column(name = "REF_FACTURE")
	private String refFacture;
	
	public Designation() {
		
	}

	public Designation(Prestation prestation, String refFacture) {
		this.prestation = prestation;
		this.refFacture = refFacture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public String getRefFacture() {
		return refFacture;
	}

	public void setRefFacture(String refPrestation) {
		this.refFacture = refPrestation;
	}

	@Override
	public String toString() {
		return "Designation [id=" + id + ", prestation=" + prestation + ", refFacture=" + refFacture + "]\n";
	}
	
}
