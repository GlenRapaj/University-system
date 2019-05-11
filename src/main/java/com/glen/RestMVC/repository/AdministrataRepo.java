package com.glen.RestMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glen.RestMVC.model.Administrata;



public interface AdministrataRepo extends JpaRepository<Administrata, Integer> {

	//public void save(Administrata adm);
	
	
}
