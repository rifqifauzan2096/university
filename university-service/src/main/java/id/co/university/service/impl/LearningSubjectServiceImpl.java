package id.co.university.service.impl;

import id.co.university.backend.model.LearningSubject;
import id.co.university.backend.repository.LearningSubjectRepository;
import id.co.university.service.wrapper.LearningSubjectWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LearningSubjectServiceImpl {

    @Autowired
    private LearningSubjectRepository learningSubjectRepository;

    private LearningSubjectWrapper toWrapper(LearningSubject model){
        LearningSubjectWrapper wrapper = new LearningSubjectWrapper();

        wrapper.setId(model.getId());
        wrapper.setDescription(model.getDescription());
        wrapper.setSubjectCode(model.getSubjectCode());
        wrapper.setSubjectName(model.getSubjectName());
        wrapper.setScs(model.getScs());

        return wrapper;
    }

    private LearningSubject toEntity(LearningSubjectWrapper wrapper){
        LearningSubject model = new LearningSubject();

        if (model.getId() != null){
            Optional<LearningSubject> optModel = learningSubjectRepository.findById(wrapper.getId());
            if (optModel.isPresent()){
                model = optModel.get();
            }
        }

        model.setDescription(wrapper.getDescription());
        model.setDeleted(false);
        model.setSubjectCode(wrapper.getSubjectCode());
        model.setSubjectName(wrapper.getSubjectName());
        model.setScs(wrapper.getScs());

        return model;
    }

    private List<LearningSubjectWrapper> toWrapperList(List<LearningSubject> modelList){
        List<LearningSubjectWrapper> rList = new ArrayList<>();
        if (modelList != null && !modelList.isEmpty()){
            for (LearningSubject model : modelList){
                rList.add(toWrapper(model));
            }
        }

        return rList;
    }

    public LearningSubjectWrapper save(LearningSubjectWrapper wrapper){
        return toWrapper(learningSubjectRepository.save(toEntity(wrapper)));
    }

    public LearningSubjectWrapper getById(Long id){
        Optional<LearningSubject> optModel = learningSubjectRepository.findById(id);
        return optModel.map(this::toWrapper).orElse(null);
    }

    public List<LearningSubjectWrapper> getList(){
        return toWrapperList((List<LearningSubject>) learningSubjectRepository.findAll());
    }
}
