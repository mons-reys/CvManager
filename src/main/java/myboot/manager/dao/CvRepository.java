package myboot.manager.dao;

import java.util.List;

import myboot.manager.model.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myboot.manager.model.Cv;


@Repository
@Transactional
public interface CvRepository  extends JpaRepository<Cv, Long> {
    List<Cv> findByPersonId(Long postId);
}