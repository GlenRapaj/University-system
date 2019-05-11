package com.glen.RestMVC.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.glen.RestMVC.busines.Busines;
import com.glen.RestMVC.model.Administrata;
import com.glen.RestMVC.model.ObjectModel;
import com.glen.RestMVC.model.Perdorues;
import com.glen.RestMVC.repository.AdministrataRepo;
import com.glen.RestMVC.service.UserDetailsServiceImpl;

import org.springframework.ui.Model;




@Controller
@RequestMapping("/student")
public class Controler {

	//implements ErrorController
	@Autowired
	AdministrataRepo administrataRepo;
	
	@Autowired
	 Busines bus;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	
	@GetMapping("/")
	public ModelAndView home() 
	{
	
			ModelAndView mv = new ModelAndView();
			
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName();
			
		
			 ObjectModel om = new ObjectModel();
			
			 om = bus.jepPerdoruesin( str);
			 
			 if(om == null) {
				 
				 om.setId(1);
				 
				 
			 }
			 
			
			
			mv.setViewName("faqjaPerdoruesit");
			mv.addObject("perdorues", om);
			
			return mv;
	}
	
	
	@GetMapping("/log")
	public String login(Model model)
	{
		 model.addAttribute("student", new ObjectModel() );
		return "login";
	}
	
	
	
	@GetMapping("/mungojne/{lenda}")
	public ModelAndView mugojne(@PathVariable("lenda")String lenda)
	{
		
			ModelAndView mv = new ModelAndView();
			
			String l;
			String str = lenda;
			String mungojne = bus.mugojne( lenda);
		
			if(mungojne.equalsIgnoreCase("error")) {
				
				l = " Lenda e kerkuar nuk eshte pjese e programit tone. ";
			}else {
				
				l = " Ne lenden " + str + " munguan " + mungojne + " studente gjate provimit. ";
			}
			mv.addObject("mungojne", l);
			
			mv.setViewName("mungojneProvim");
				
				return mv;
	}
	
	
	
	@GetMapping("/ngelen/{lenda}")
	public ModelAndView ngelen(@PathVariable("lenda") String lenda) 
	{
			String l;
			String ng;
			
			ModelAndView mv = new ModelAndView();
			
			
		if(lenda.equals("mat")){
			l = "matematik";
		}
		else if(lenda.equals("stat")) {
			l = "statistik";
		}
		else if(lenda.equals("prog")) {
			l = "programim";
		}else {
			l = "calkus";
		}
		
		
		if(bus.ngelen( lenda).equals("error")) {
			
			ng = " Lend e kerkuar nuk egziston. ";
		}else {
			
			 ng = " Ne " + l + " ngelen: " + bus.ngelen( lenda);
		}
		
			mv.addObject("ngelen",ng);
			
			mv.setViewName("ngelen");
				
				return mv;
		
	}
	
	//  ,consumes = {"application/json","application/xml"}
	@PostMapping(path = "/regjistro")
	public ModelAndView regjistro(@RequestBody @ModelAttribute ObjectModel regjistroStudentin) {
		
		ModelAndView mv = new ModelAndView();
		
		/*
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName();
			*/
		
			System.out.println();
		System.out.println();
		System.out.println(regjistroStudentin);
		
		bus.regjistro( regjistroStudentin);
		 
		mv.addObject("pergjigje", " U regjistruat me sukses. ");
		
		mv.setViewName("rezultate");
			
			return mv;
	
	}
	
	@GetMapping("/grupi/{id}")
	public ModelAndView  tregoGrStd(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView();
		String str;
		
		// " Studenti eshte ne grupin " + bus.tregoGrStd(id)
		
		if(bus.tregoGrStd(id) != null) {
			 str = " Studenti eshte ne grupin " + bus.tregoGrStd(id) ;
		}
		else {
			str= " Studenti i kerkuar nuk egziston. ";
		}
		mv.addObject("GrStudenti", str );
		
		mv.setViewName("GrupiStudentit");
		return mv ;
		
	}
	
	
	@GetMapping("/mesatarja/{lenda}")
	public ModelAndView mesatarja(@PathVariable("lenda") String lenda) {
		
			double mesatarja=11;
			
			String l;
			
		if(lenda.equals("mat")){
			l = "matematik";
		}
		else if(lenda.equals("stat")) {
			l = "statistik";
		}
		else if(lenda.equals("prog")) {
			l = "programim";
		}else {
			l = "calkus";
		}
		
			
			ModelAndView mv = new ModelAndView();
			
			mesatarja =  bus.mesatarja( lenda);
		
			if(mesatarja == 12) {
				
				mv.addObject("Mesatare", " Lenda e kerkuar nuk eshte ne planin mesimor. " );
				
			}else {
				
				mv.addObject("Mesatare", " Mesatarja e studenteve ne lenden : " + l  + " " + mesatarja + "" );
				
			}
			
			
			mv.setViewName("MesatareLendes");
			return mv ;
		}
	
	
	
	
	
	@GetMapping(path = "/home",produces={"application/json","application/xml"})
	public ModelAndView shfaq(){
		
		ModelAndView mv = new ModelAndView();
		
		 List<ObjectModel> l = bus.shfaq();
		 mv.addObject("listaStudenteve", l);
		 
			mv.setViewName("fshi");
		
			return mv ;
	}
	
	
	@GetMapping("/fillimistd/{id}")
	public ModelAndView dtfUnv(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView();
		
		
		 mv.addObject("dtFillimitStudenteve",  bus.dtfUnv(  id));
	
					mv.setViewName("DataFillimitStudimeve");
					return mv ;
	}
	
	
	@GetMapping("/data/{id}")
	public ModelAndView shfaqStudent(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView();
		
		
		
		mv.addObject("student", bus.shfaqStudent( id) );
		
		mv.setViewName("kursi");
		return mv ;
	}
	
	
	@DeleteMapping("/stdent/{id}")
	public ModelAndView cregjistroStudent(@PathVariable("id")int id)
	{
		System.out.println(" U fshi! ");
		String str = bus.cregjistroStudent( id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("creghistrim", str);
		// bej pamjen
				mv.setViewName("cregjistrim");
				return mv ;
		
	}
	
	
	
	

	@GetMapping("/mesatarestdent/{id}")
	public ModelAndView mesataretdent(@PathVariable("id")int id) {
		
		double mesatre;
		
		ModelAndView mv = new ModelAndView();
		
		String str ;
		
	
		try {
			mesatre = bus.mesataretdent( id);
			
			 str = " Mesatarja e studentit me id " +id + "" + " eshte: " + mesatre + "";
			
			//System.out.println(mesatre);
		
		}	catch (Exception e) {
			
			 str = "  Studentit me id " +id + "" + " nuk egziston. " ;
			mesatre = 11;
		}
		//System.out.println(mesatre);
		
		
		mv.addObject("mesatareStudenti",str);
		
		
		mv.setViewName("mesatareStudentit");
		return mv ;
		
	}
	
	  @GetMapping("/regjistro")
	    public String greetingForm(Model model) {
	        model.addAttribute("regjistroStudentin", new ObjectModel() );
	        return "regjistroStudent";
	    }
	
	  
	  @GetMapping("/sitem/regjistrosistem")
	    public String regjistroForm(Model model) {
	        model.addAttribute("regjistroPerdoruesin", new Perdorues() );
	        return "regjistro_sistem";
	    }
	
	  
	  
		@PostMapping(path = "/sitem/regjistrosistem")
		public ModelAndView regjistroPerdorues(@RequestBody @ModelAttribute Perdorues regjistroPerdoruesin) {
			
			ModelAndView mv = new ModelAndView();
			
			String emailPerdoruesi = regjistroPerdoruesin.getEmail();
				ObjectModel om = bus.jepPerdoruesin( emailPerdoruesi) ;
				
			String str;
			
			
			if(om == null) {
				
				str=" Perdoruesi nuk studjon ne universitet prndaj nuk mund te  regjistrohet ";
				
			}else {
			
				userDetailsServiceImpl.regjistroPerdoruesin( regjistroPerdoruesin);
			str=" U regjistruat me sukses. ";
			}
			
			
			if(regjistroPerdoruesin.getRole().equals("ROLE_ADMIN")) {
				
				Administrata adm = new Administrata();
				
				adm.setName(regjistroPerdoruesin.getName());
				adm.setLastName(regjistroPerdoruesin.getEmail());
				adm.setGrupi("administrate");
				
				administrataRepo.save(adm);
				userDetailsServiceImpl.regjistroPerdoruesin( regjistroPerdoruesin);
				
				str=" Antar i ri ne administrat. u regjistruat me sukses ";
				
				System.out.println();
				System.out.println();
				System.out.println(adm);
				
			}
			else {
				str=" Ju nuk jeni pjese e administrates. Nuk u regjistruat. ";
			}
			
			
			mv.addObject("per", str);
			
			mv.setViewName("pergjigjeRegjistrimi");
				
				return mv;
		
		}
		
		@GetMapping("/data/abaut")
		public String abaut() {
			
			return "abaut";
		}

		/*
		@GetMapping("/error")
		public String error() {
			
			//ModelAndView mv = new ModelAndView();
			//mv.setViewName("403");
			
			return "403";
		}

		@Override
		public String getErrorPath() {
			
			return "/error";
		}
	  */
}
