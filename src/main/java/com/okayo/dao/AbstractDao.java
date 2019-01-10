package com.okayo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {

	@Autowired
	private SessionFactory factory;

	public Session getSession() {
		return factory.getCurrentSession();
	}

}