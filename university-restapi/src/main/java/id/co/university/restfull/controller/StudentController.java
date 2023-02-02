package id.co.university.restfull.controller;


import id.co.university.service.impl.StudentServiceImpl;
import id.co.university.service.wrapper.StudentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;



    @PostMapping(value = "/add")
    public Map<Object, String> addData(@RequestBody StudentWrapper wrapper){

        Map<Object, String> rMap = new HashMap<>();

        StudentWrapper studentWrapper = studentService.save(wrapper);

        if (studentWrapper.getId() != null){
            rMap.put("message", "Success");
            rMap.put("status", "200");
            rMap.put("datas", "");
        } else {
            rMap.put("message", "Failed");
            rMap.put("status", "200");
        }

        return rMap;
    }

    @GetMapping(value = "/list")
    public List<StudentWrapper> getList(){
        return studentService.getAll();
    }
}
