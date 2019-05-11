package com.glen.RestMVC.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glen.RestMVC.model.ObjectModel;




//
public interface ObjectModelRepo  extends JpaRepository<ObjectModel, Integer>{

	
	@Query("select count(marksMath) from ObjectModel where marksMath>10 ")
	int	mungojneMat();
	
	@Query("select count(marksStatistics) from ObjectModel where marksStatistics>10 ")
	int	mungojneStat();
	
	@Query("select count(marksPrograming) from ObjectModel where marksPrograming>10 ")
	int	mungojneProg();
	
	@Query("select count(marksCalcus) from ObjectModel where marksCalcus>10 ")
	int	mungojneCalc();
	
	
	 
	@Query(" from ObjectModel where marksCalcus<?1 ")
	List<ObjectModelRepo>	findByMarksCalcusLessThen(int marksCalcus);
	
	@Query(" from ObjectModel where marksCalcus<?1 ")
	List<ObjectModelRepo>	findByMarksMathLessThen(int marksMath);
	
	@Query(" from ObjectModel where marksCalcus<?1 ")
	List<ObjectModelRepo>	findByMarksProgramingLessThen(int marksPrograming);
	
	@Query(" from ObjectModel where marksCalcus<?1 ")
	List<ObjectModelRepo>	findByMarksStatisticsLessThen(int marksStatistics);

	@Query("select grupi from ObjectModel where id=?1 ")
	String	grupiStudentit(int id);
	
	
	@Query("select doj from ObjectModel where id=?1")
	Date	dtfiStudentit(int id);
	
	
	@Query("select SUM(e.marksMath)  from ObjectModel e where e.marksMath<11 and e.marksMath>0")
	int	shumNotaStudenteveMat();
	
	@Query("select SUM(marksCalcus) from ObjectModel where marksCalcus<11 and marksCalcus>0")
	int	shumNotaStudenteveCalc();
	
	@Query("select SUM(e.marksPrograming) from ObjectModel e where e.marksPrograming<11 and e.marksPrograming>0")
	int	shumNotaStudenteveProg();
	
	
	@Query("select SUM(e.marksStatistics) from ObjectModel e where e.marksStatistics<11 and e.marksStatistics>0")
	int	shumNotaStudenteveStat();
	
	@Query("select count(e.marksCalcus) from ObjectModel e where e.marksCalcus<11 and e.marksCalcus>0")
	int nrstudenteveNeProvimCalc();
	
	@Query("select count(e.marksMath) from ObjectModel e where e.marksMath<11 and e.marksMath>0")
	int nrstudenteveNeProvimMat();
	
	@Query("select count(marksPrograming) from ObjectModel where marksPrograming<11 and marksPrograming>0  ")
	int nrstudenteveNeProvimProg();
	
	@Query("select count(marksStatistics) from ObjectModel where marksStatistics<11 and marksStatistics>0")
	int nrstudenteveNeProvimStat();
	
	@Query(" from ObjectModel ")
	List<ObjectModel> shfaqListenStudenteve();
	
	@Query(" from ObjectModel where id=?1")
	ObjectModel shfaqStudent(int id);
	
	ObjectModel findByLastName(String lastName);
;
}
