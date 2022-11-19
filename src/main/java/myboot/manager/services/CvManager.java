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

	public List<Cv> findByPersonId(Long personId) {
		return cr.findByPersonId(personId);
	}
}

