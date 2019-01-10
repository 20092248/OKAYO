package com.okayo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okayo.dao.DesignationDao;
import com.okayo.model.Designation;

@Transactional
@Service("prestationService")
public class PrestationServiceImpl implements PrestationService {

	@Autowired
	DesignationDao designationDao;
	
	/**
	 * @return designationDao
	 */
	public DesignationDao getDesignationDao() {
		return designationDao;
	}

	public void creerFacture(List<Designation> designation) {
		for(Designation d : designation) {
			getDesignationDao().save(d);
		}		
	}

	public void majPrestation(Designation designation) {
		getDesignationDao().update(designation);
	}

	public void supprimerPrestation(Designation designation) {
		getDesignationDao().delete(designation);
	}

	public Designation rechercherPrestation(int id) {
		return getDesignationDao().findDescriptionById(id);
	}

	public List<Designation> rechercherFacture(String ref) {
		// TODO Auto-generated method stub
		return getDesignationDao().findFactureByRef(ref);
	}

	public void supprimerFacture(String ref) {
		List<Designation> factures= rechercherFacture(ref);
		if(null != factures) {
			for(Designation d : factures) {
				getDesignationDao().delete(d);
			}	
			System.out.println("\n-------------> La facture a été supprimée!!!\n");
		}
		else {
			try {
				throw new Exception("Aucune facture n'a été trouvé");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public double TotalTTC(String ref, double tva) {
		// TODO Auto-generated method stub
		double result = 0;
		List<Designation> factures= rechercherFacture(ref);
		if(null != factures) {
			for(Designation d : factures) {
				result = result + (d.getPrestation().getTotalHorsTaxe()*((tva/100)+1));
			}	
		}
		return result;
	}

	public void changeTVA(String ref, double tva) {
		List<Designation> factures= rechercherFacture(ref);
		if(null != factures) {
			for(Designation d : factures) {
				d.getPrestation().setTva(tva);
				getDesignationDao().update(d);
			}	
			System.out.println("\n-------------> La tva a été modifiée!!!\n");
		}
		else {
			try {
				throw new Exception("Aucune facture n'a été trouvé");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
