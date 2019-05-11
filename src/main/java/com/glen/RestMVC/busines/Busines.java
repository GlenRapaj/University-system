package com.glen.RestMVC.busines;

import java.util.Date;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.glen.RestMVC.model.ObjectModel;



//@Component
public interface Busines {

	
	public String mugojne(String lenda) ;
	
	
	public ObjectModel jepPerdoruesin(String str) ;
	
	
	public String ngelen( String lenda) ;

	public void regjistro( ObjectModel obj);
	

	

	public String tregoGrStd( int id) ;
	
	
	
	
	public double mesatarja( String lenda);
	
	public List<ObjectModel> shfaq();
	

	public Date	 dtfUnv( int id);
	
	
	
	public ObjectModel shfaqStudent( int id) ;
	
	
	
	
	public String cregjistroStudent(int id);
	
	
	
	
	
	public ResponseEntity<ObjectModel> modifikoteDhenatStd(int id,  ObjectModel objmod);
	
	
	
	
	public double mesataretdent(@PathVariable("id")int id);
	
	
}
