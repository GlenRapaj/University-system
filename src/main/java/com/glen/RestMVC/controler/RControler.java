package com.glen.RestMVC.controler;


import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glen.RestMVC.busines.Busines;
import com.glen.RestMVC.model.ObjectModel;





@RestController
@RequestMapping("/Control")
public class RControler {

	
	
	@Autowired
	 Busines bus;
	
	
	
	/*
	 * 
	 * jep nr e studenteve ne nje lende perkatese ku lenda merret si input 
	 * 
	 * ishte "mat/{lenda}"
	 * */
	
	@GetMapping("/mungojne/{lenda}")
	public String mugojne(@PathVariable("lenda")String lenda) {
		
		
		
		return bus.mugojne( lenda);
		
		
	}
	
	
	
	/*
	 * 
	 * jep nr e studenteve qe ngelen ne nje lende perkatese ku lenda merret si input 
	 * 
	 * */
	
	@GetMapping("/ngelen/{lenda}")
	public String ngelen(@PathVariable("lenda") String lenda) {
		
	
		return bus.ngelen( lenda);
		
	}
	
	
	
	
	
	
	
	@PostMapping(path = "/regjistro",consumes = {"application/json","application/xml"})
	public void regjistro(@RequestBody ObjectModel obj) {
		
		
		
		bus.regjistro( obj);
	
	}
	
	
	
	
	// jep gr e nje studenti ku si input merret id e studentit
	
	@GetMapping("/grupi/{id}")
	public String tregoGrStd(@PathVariable("id") int id) {
		
		
		return bus.tregoGrStd(id) ;
		
	}
	
	
	/*
	 * Jep mesataren e pergjithshm ne nje lende
	 *  te caktuar qe merret si input
	 * 
	 * */
	
	@GetMapping("/mesatarja/{lenda}")
	public double mesatarja(@PathVariable("lenda") String lenda) {
		
		double pergjigje;
		
			pergjigje = bus.mesatarja( lenda);
			if(pergjigje == 12) {
				return 404;
			}else {
				return pergjigje;
			}
		
		
		
		
	}
	
	
	
	@GetMapping(path = "/",produces={"application/json","application/xml"})
	public List<ObjectModel> shfaq(){
		
		
		return bus.shfaq();
	}

	
	@GetMapping("/fillimistd/{id}")
	public Date	 dtfUnv(@PathVariable("id") int id) {
		
		return bus.dtfUnv(  id);
	}
	
	
	@GetMapping("/{id}")
	public ObjectModel shfaqStudent(@PathVariable("id") int id) {
		
		return bus.shfaqStudent( id);
	}
	
	
	
	@DeleteMapping("/stdent/{id}")
	public String cregjistroStudent(@PathVariable("id")int id)
	{
		return bus.cregjistroStudent( id);
	}
	
	
	
	
	
	// Shife dhe nje here se duhen bere ca ndryshime tek hderi cregjistroStudent(@PathVariable("id")int id)
	
	@PutMapping(path="/stdent/{id}",consumes = {"application/json","application/xml"})
	public ResponseEntity<ObjectModel> modifikoteDhenatStd(@PathVariable("id")int id, @RequestBody ObjectModel objmod)
	{
		return bus.modifikoteDhenatStd( id,   objmod);
		
	}
	
	
	
	
	@GetMapping("/mesatarestdent/{id}")
	public double mesataretdent(@PathVariable("id")int id) {
		
	double a =11;
	a = bus.mesataretdent( id);
	return a;
	
	
	/*
	try {
		return bus.mesataretdent( id);
		}catch{
			return 11;
		}
	*/
		
	}
	

	
}
