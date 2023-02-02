package id.co.university.backend.repository;

import id.co.university.backend.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query(value = "select a from Student a where a.deleted = false")
    List<Student> getDataList();
}
