package myboot.manager.services;

import myboot.manager.dao.ActivityRepository;
import myboot.manager.model.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myboot.manager.dao.CvRepository;
import myboot.manager.model.Cv;
import myboot.manager.model.Person;

import java.util.List;


@Service
@Transactional
public class CvManager {

	 @Autowired
	 CvRepository cr;
	@Autowired
	PersonManager pr;

	@Autowired
	ActivityRepository ar;

	@Transactional
	 public Cv createCv(Cv cv) {
		cr.save(cv);
		return cv;
	}

	@Transactional
	public List<Cv> showAllCvs() {
		List<Cv> cvs = cr.findAll();
		return cvs;
	}

	@Transactional
	public void deleteSingleCv(Long id) {
		cr.deleteById(id);
	}

	@Transactional
	public void updateSinglePost(Long id, Cv cv) {
		cv.setId(id);
		cr.save(cv);
	}

	@Transactional
	public Cv readSingleCv(Long id) {
		return cr.findById(id).orElseThrow(() -> new RuntimeException("For id " + id));
	}

	@Transactional
	public List<Cv> findByPersonId(Long personId) {

		return cr.findByPersonId(personId);
	}

	@Transactional
	public void createPersonCv(Long personId, Cv cvRequest) {
		Person person =  pr.readSinglePerson(personId);
		cvRequest.setPerson(person);
		cr.save(cvRequest);
	}
}

