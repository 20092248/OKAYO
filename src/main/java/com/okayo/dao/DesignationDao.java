package com.okayo.dao;

import java.util.List;

import com.okayo.model.Designation;

public interface DesignationDao {
	
	void save(Designation designation);
	void update(Designation designation);
	void delete(Designation designation);
	Designation findDescriptionById(int id);
	List<Designation> findFactureByRef(String refFacture);

}
