package id.co.university.backend.repository;

import id.co.university.backend.model.LearningSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningSubjectRepository extends CrudRepository<LearningSubject, Long> {
}
