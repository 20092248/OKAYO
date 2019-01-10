package com.okayo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.okayo.model.Designation;

@Component
public interface PrestationService {

	void creerFacture(List<Designation> designation);
	void majPrestation(Designation designation);
	void supprimerPrestation(Designation designation);
	Designation rechercherPrestation(int id);
	List<Designation> rechercherFacture(String ref);
	double TotalTTC(String ref, double tva);
	void supprimerFacture(String ref);
	void changeTVA(String ref, double tva);
}
