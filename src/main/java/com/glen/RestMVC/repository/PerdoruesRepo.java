package com.glen.RestMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glen.RestMVC.model.Perdorues;



public interface PerdoruesRepo extends JpaRepository<Perdorues, Integer>{
	
	@Query("from Perdorues where email=?1 and enabled=?2")
	Perdorues findPerdoruesByEmailEnabled(String email, short enabled);

}
