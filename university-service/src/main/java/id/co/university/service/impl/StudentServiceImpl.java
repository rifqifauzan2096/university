package id.co.university.service.impl;


import id.co.university.backend.model.Student;
import id.co.university.backend.repository.StudentRepository;
import id.co.university.service.wrapper.StudentWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentWrapper toWrapper(Student model){
        StudentWrapper wrapper = new StudentWrapper();

        wrapper.setId(model.getId());
        wrapper.setDescription(model.getDescription());
        wrapper.setNim(model.getNim());
        wrapper.setFullname(model.getFullname());
        wrapper.setAge(model.getAge());
        wrapper.setGender(model.getGender());
        wrapper.setEmail(model.getEmail());
        wrapper.setPhoneNumber(model.getPhoneNumber());

        return wrapper;
    }

    private Student toEntity(StudentWrapper wrapper){
        Student model = new Student();

        if (wrapper.getId() != null){
            Optional<Student> optStudent = studentRepository.findById(wrapper.getId());
            if (optStudent.isPresent()){
                model = optStudent.get();
            }
        }

        model.setDescription(wrapper.getDescription());
        model.setDeleted(false);
        model.setNim(wrapper.getNim());
        model.setFullname(wrapper.getFullname());
        model.setAge(wrapper.getAge());
        model.setGender(wrapper.getGender());
        model.setEmail(wrapper.getEmail());
        model.setPhoneNumber(wrapper.getPhoneNumber());

        return model;

    }

    private List<StudentWrapper> toWrapperList(List<Student> listModel){
        List<StudentWrapper> rList = new ArrayList<>();
        if (listModel != null && !listModel.isEmpty()){
            for (Student model : listModel){
                rList.add(toWrapper(model));
            }
        }

        return rList;
    }

    public StudentWrapper save(StudentWrapper wrapper){
        return toWrapper(studentRepository.save(toEntity(wrapper)));
    }

    public List<StudentWrapper> getAll(){
        return toWrapperList((List<Student>) studentRepository.findAll());
    }

    public StudentWrapper getById(Long id){
        Optional<Student> optStudent = studentRepository.findById(id);
        return optStudent.map(this::toWrapper).orElse(null);
    }
}
