package com.okayo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.okayo.model.Designation;
import com.okayo.util.CustomHibernateDaoSupport;

@Repository("designationDao") 
public class DesignationDoaImpl extends CustomHibernateDaoSupport implements DesignationDao {

	public void save(Designation designation) {
		// TODO Module de remplacement de méthode auto-généré
		getHibernateTemplate().save(designation);
	}

	public void update(Designation designation) {
		// TODO Module de remplacement de méthode auto-généré
		getHibernateTemplate().update(designation);

	}

	public void delete(Designation designation) {
		// TODO Module de remplacement de méthode auto-généré
		getHibernateTemplate().delete(designation);

	}

	public Designation findDescriptionById(int id) {
		// TODO Module de remplacement de méthode auto-généré
		List<?> list = getHibernateTemplate().find("from Designation where id="+id+"");
		return (Designation)list.get(0);
	}

	public List<Designation> findFactureByRef(String refFacture) {
		// TODO Auto-generated method stub
		List<?> list = getHibernateTemplate().find("from Designation where refFacture= '"+refFacture+"'");
				return (List<Designation>) list;
	}

}
