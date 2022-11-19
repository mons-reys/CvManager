package myboot.manager.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myboot.manager.dao.CvRepository;
import myboot.manager.model.Cv;
import myboot.manager.model.Person;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CvManager {

	 @Autowired
	 CvRepository cr;

	 
	 public void createCv(Cv cv) {
	        cr.save(cv);
	    }


	public List<Cv> showAllCvs() {
		List<Cv> cvs = cr.findAll();
		return cvs;
	}
}

