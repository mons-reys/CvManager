package myboot.manager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myboot.manager.model.Cv;
import myboot.manager.model.Nature;




@Repository
@Transactional
public interface CvRepository  extends JpaRepository<Cv, Long> {
}