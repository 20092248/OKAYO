package com.okayo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Prestation {

	@Column(name = "TITRE", nullable = false)
	private String titre;	
	@Column(name = "NOUVEAU_TITRE", nullable = true)
	private String nouveauTitre;
	@Column(name = "TVA", nullable = false)
	private double tva;	//en %
	@Column(name = "PRIX_UNITAIRE", nullable = false)
	private double prixUnitaire;	
	@Column(name = "QUANTITE", nullable = false)
	private int quantite;	
	@Column(name = "REDUCTION", nullable = false)
	private double reduction; //en %
	@Column(name = "TOTAL_HORS_TAXE", nullable = false)
	private double totalHorsTaxe;
	
	public Prestation() {
		
	}

	public Prestation(String title, String nouveauTitre, double prixUnitaire, double tva, int quantite, double reduction) {
		super();
		this.titre = title;
		this.nouveauTitre = "";
		this.prixUnitaire = prixUnitaire;
		this.tva = tva;
		this.quantite = quantite;
		this.reduction = reduction;
		this.totalHorsTaxe = getTotalHorsTaxe();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String title) {
		this.titre = title;
	}

	public String getNouveauTitre() {
		return nouveauTitre;
	}

	public void setNouveauTitre(String nouveauTitre) {
		this.nouveauTitre = nouveauTitre;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getReduction() {
		return reduction;
	}

	public void setReduction(double reduction) {
		this.reduction = reduction;
	}

	public double getTotalHorsTaxe() {
		return prixUnitaire * quantite * (1 - reduction/100);
	}

	@Override
	public String toString() {
		return "Prestation [titre=" + titre + ", nouveauTitre=" + nouveauTitre + ", tva=" + tva + ", prixUnitaire="
				+ prixUnitaire + ", quantite=" + quantite + ", reduction=" + reduction + ", totalHorsTaxe="
				+ totalHorsTaxe + "]";
	}
	
}
