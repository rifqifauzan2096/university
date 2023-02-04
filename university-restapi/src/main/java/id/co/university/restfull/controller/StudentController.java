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
    public Map<String, Object> addData(@RequestBody StudentWrapper wrapper){

        Map<String, Object> rMap = new HashMap<>();

        StudentWrapper studentWrapper = studentService.save(wrapper);

        if (studentWrapper.getId() != null){
            rMap.put("message", "Data has been save successfully");
            rMap.put("status", "200");
            rMap.put("datas", studentWrapper);
        } else {
            rMap.put("message", "Failed to saved");
            rMap.put("status", "200");
        }

        return rMap;
    }

    @PostMapping(value = "edit/{id}")
    public Map<String, Object> updateData(@PathVariable("id") Long id ,@RequestBody StudentWrapper wrapper){
        Map<String, Object> rMap = new HashMap<>();
        StudentWrapper studentWrapper = studentService.getById(id);

        if (studentWrapper.getId() != null){
            wrapper = studentService.save(wrapper);
            rMap.put("message", "Data has been save successfully");
            rMap.put("status", "200");
            rMap.put("datas", wrapper);
        } else {
            rMap.put("message", "Failed to update");
            rMap.put("status", "200");
        }

        return rMap;

    }

    @GetMapping(value = "/list")
    public List<StudentWrapper> getList(){
        return studentService.getAll();
    }

    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        studentService.delete(id);
        StudentWrapper wrapper = studentService.getById(id);

        return "Delete Data " + wrapper.getFullname() + " Succesfully";
    }
}
