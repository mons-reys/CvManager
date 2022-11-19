package myboot.manager.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import myboot.app1.model.Movie;
import myboot.app2.model.Counter;
import myboot.manager.dao.CvRepository;
import myboot.manager.dao.PersonRepository;
import myboot.manager.model.Cv;
import myboot.manager.model.Nature;
import myboot.manager.model.Person;
import myboot.manager.services.CvManager;
import myboot.manager.services.PersonManager;



@SpringBootTest
public class TestManagerRepository {

	@Autowired
	PersonRepository pr;
	
	@Autowired
	CvRepository cr;
	
	@Test
	public void testSavePerson() {
		Person p = new Person();
	    p.setFirstName("super");
	    p.setLastName("mario");
	    p.setEmail("mario@gmail.com");
	    
		var p2 = pr.save(p);
		var p3 = pr.findById(p.getId());
		assertEquals(p3.get().getFirstName(), "super");
	}
	
	@Test
	public void testDeletePerson() {
		Person p = new Person();
	    p.setFirstName("super");
	    p.setLastName("luigi");
	    p.setEmail("liugi@gmail.com");
	    
		var p2 = pr.save(p);
		pr.delete(p);
		var p3 = pr.findById(p.getId());
		assertEquals(p3, Optional.empty());
	}
	
	@Test
	public void testReplacePerson() {
		Person p = new Person();
	    p.setFirstName("super");
	    p.setLastName("luigi");
	    p.setEmail("liugi@gmail.com");
	    
		var p2 = pr.save(p);
		var p3 = pr.findById(p.getId());
		
		Person p4 = p3.get();
		p4.setFirstName("black");
		
		var p5 = pr.save(p4);
		var p6 = pr.findById(p.getId());
		assertEquals(p6.get().getFirstName(), "black");
	}

	
	@Test
	public void testSaveCv() {
		Cv c = new Cv();
	    c.setDescritpion("test");
	    c.setNature(Nature.professional);
	    c.setYear(2022);
	    
		var c2 = cr.save(c);
		var c3 = cr.findById(c.getId());
		assertEquals(c3.get().getDescritpion(), "test");
	}
	
	@Test
	public void testDeleteCv() {
		Cv c = new Cv();
	    c.setDescritpion("test");
	    c.setNature(Nature.professional);
	    c.setYear(2022);
	    
		var c2 = cr.save(c);
		cr.delete(c);
		var c3 = cr.findById(c.getId());
		assertEquals(c3, Optional.empty());
	}
	
	@Test
	public void testReplaceCv() {
		Cv c = new Cv();
	    c.setDescritpion("test");
	    c.setNature(Nature.professional);
	    c.setYear(2022);
	    
		var c2 = cr.save(c);
		var c3 = cr.findById(c.getId());
		
		Cv c4 = c3.get();
		c4.getYear();
		
		var c5 = cr.save(c4);
		var c6 = cr.findById(c.getId());
		assertEquals(c6.get().getYear(), 2022);
	}

	   
}
