package com.glen.RestMVC.busines;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.glen.RestMVC.model.ObjectModel;
import com.glen.RestMVC.model.UniversityModel;
import com.glen.RestMVC.repository.ObjectModelRepo;




@Component
public class BusinesImp implements Busines {
	
	
	
	@Autowired
	ObjectModelRepo repo;
	
	
	
	/*
	 * 
	 * jep nr e studenteve ne nje lende perkatese ku lenda merret si input 
	 * 
	 * ishte "mat/{lenda}"
	 * */
	
	
	public String mugojne(String lenda) {
		
	
		if(lenda.equals("mat") )
		{
		return repo.mungojneMat() + "";
		}
		else if(lenda.equals("stat") )
		{
			return repo.mungojneStat() + "";
		}
		else if(lenda.equals("prog") ) 
		{
			return repo.mungojneProg() + "";
		}
		else if(lenda.equals("calc") ) 
		{
			return repo.mungojneCalc() + "";
		}
		else 
		{
			return "error";
		}
		
	}
	
	
	
	/*
	 * 
	 * jep nr e studenteve qe ngelen ne nje lende perkatese ku lenda merret si input 
	 * 
	 * */
	
	
	public String ngelen( String lenda) {
		
		
		
		if(lenda.equals("mat") )
		{
			return repo.findByMarksMathLessThen(5).size()  + "";
		}
		else if(lenda.equals("stat") )
		{
			return repo.findByMarksStatisticsLessThen(5).size()  + "";
		}
		else if(lenda.equals("prog") ) 
		{
			return repo.findByMarksProgramingLessThen(5).size()  + "";
		}
		else if(lenda.equals("calc") ) 
		{
			return repo.findByMarksCalcusLessThen(5).size()  + "";
		}
		else 
		{
			return "error";
		}
		
	}
	
	
	
	
	
	
	//   consumes = {"application/json","application/xml"}

	public void regjistro( ObjectModel obj) {
		
		System.out.println(obj);
		repo.save(obj);
		
		
	
	}
	
	// jep gr e nje studenti ku si input merret id e studentit
	

	public String tregoGrStd( int id) {
		System.out.println(" ok ");
		return repo.grupiStudentit( id);
	
	}
	
	
	/*
	 * Jep mesataren e pergjithshm ne nje lende
	 *  te caktuar qe merret si input
	 * 
	 * */
	
	
	public double mesatarja( String lenda) {
		
		double avg = 0;
		int S;
		int nrstd;
		
		if(lenda.equals("mat") )
		{
			
			S = repo.shumNotaStudenteveMat();
			nrstd =	repo.nrstudenteveNeProvimMat();
			
			avg = (double) S/ (double) nrstd;
		}
		else if(lenda.equals("stat") )
		{
			S = repo.shumNotaStudenteveStat();
			nrstd =	repo.nrstudenteveNeProvimStat();
			avg = (double) S/ (double) nrstd;
		}
		else if(lenda.equals("prog") ) 
		{
			S = repo.shumNotaStudenteveProg();
			nrstd = repo.nrstudenteveNeProvimProg();
			avg = (double) S/ (double) nrstd;
		}
		else if(lenda.equals("calc") ) 
		{
			S = repo.shumNotaStudenteveCalc();
			nrstd =	repo.nrstudenteveNeProvimCalc();
			avg = (double) S/ (double) nrstd;
		}
		else {
			
			avg=12;
		}
		
		return avg;
	}
	
	
	public List<ObjectModel> shfaq(){
		
		return repo.shfaqListenStudenteve();
	}

	

	public Date	 dtfUnv( int id) {
		
		System.out.println(id);
		return	repo.dtfiStudentit( id);
	}
	
	
	
	public ObjectModel shfaqStudent( int id) {
		
		 return repo.shfaqStudent(id);
		//return repo.findById(id).orElse(new ObjectModel());
	}
	
	
	
	
	public String cregjistroStudent(int id)
	{
		String str;
		//ObjectModel a = repo.findById(id).orElse(new ObjectModel());
		ObjectModel a =	shfaqStudent( id);
		
		//System.out.println(a);
		if(a != null) {
		repo.delete(a);
		str = " U cregjistrua me sukses ";
		}else {
			
			str = "Studenti me  ID e kerkuar nuk egziston. ";
		}
		return str;
	}
	
	
	
	
	public ResponseEntity<ObjectModel> modifikoteDhenatStd(int id,  ObjectModel objmod)
	{
		String str;
		
		
		System.out.println(objmod);
		
		ObjectModel a = repo.shfaqStudent( id);
		
		System.out.println(a);
		
		if(objmod.getDepID().getId() == 0) 
		{
			UniversityModel um = new UniversityModel();
			um.setId(a.getDepID().getId());
			objmod.setDepID(um);
		}
		
		HttpHeaders hd = new  HttpHeaders();
		
		if(id == a.getId() )
		{
			
			if(objmod.getName() != null && objmod.getLastName() != null && objmod.getDoj() != null 
					&& objmod.getGrupi() != null)
			{
				hd.add("Pergjigje", "Te dhenat u updatetuan me sukses" );
				objmod.setId(id);
				
				repo.save(objmod);
				
				return new ResponseEntity<ObjectModel>(objmod,hd,HttpStatus.OK);
		    }
				else 
				{
					str=" Error name lastname grupi or the starting date can not be null ";
					
					hd.add("Pergjigje", str);
					return new ResponseEntity<ObjectModel>(objmod,hd,HttpStatus.PARTIAL_CONTENT);
					
				}
			
		
		}
		else 
		{
			
			if(objmod.getName() != null && objmod.getLastName() != null && objmod.getDoj() != null && objmod.getGrupi() != null) {
							
							objmod.setId(id);
							
							str = " Studenti nuk egziston sapo  regjistruat "
									+ " nje student te ri me te dhenat qe futet ne sistem me id:  " + id + "";
							
							repo.save(objmod);
							
							hd.add("Pergjigje", str);
							return new ResponseEntity<ObjectModel>(objmod,hd,HttpStatus.NOT_MODIFIED);
							
					}
							else 
							{
								str=" Error nuk u gjet student me id e kerkuar, name lastname grupi or the starting date nuk mund te jene  null ";
								hd.add("Pergjigje", str);
								return new ResponseEntity<ObjectModel>(objmod,hd,HttpStatus.NOT_FOUND);
							}
			
		}
		
		//return new ResponseEntity<ObjectModel>(objmod,hd,HttpStatus.NOT_FOUND);
		
  }
	
	
	
	
	public double mesataretdent(int id) {
		
		double S=0;
		double n=0;
		
		ObjectModel a = repo.shfaqStudent( id);
		System.out.println(a);
		
		
		if(a.getMarksMath() != 0 && a.getMarksMath() < 11) {
			
			n=n+1;
			S=S+ (double) a.getMarksMath();
		}
		
	if(a.getMarksPrograming() != 0 && a.getMarksPrograming()< 11) {
				
				n=n+1;
				S=S+ (double) a.getMarksPrograming();
			}
		
	if(a.getMarksStatistics() != 0 && a.getMarksStatistics()< 11) {
		
		n=n+1;
		S=S+ (double) a.getMarksStatistics();
	}
	
	if(a.getMarksCalcus() != 0 && a.getMarksCalcus()< 11) {
		
		n=n+1;
		S=S+ (double) a.getMarksCalcus();
	}
	
	if(n == 0) {
		n=1;
	}
	
	double avg = S/n;
	return avg;
		
	}
	
	
public ObjectModel jepPerdoruesin(String str) {
	ObjectModel o =	 repo.findByLastName(str);
	
	if(o == null ) {
		o = new ObjectModel();
	}
	return o;
}
	
	
}
