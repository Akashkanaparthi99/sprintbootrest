package com.studentapp.controller;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDTO;
import com.studentapp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student-api")
public class StudentController {
    private IStudentService studentService;
    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/id/{id}")
    ResponseEntity<StudentDTO> getById(@RequestParam("id")int studentId){
        StudentDTO getById = studentService.getByStudentId(studentId);
        return ResponseEntity.ok(getById);
    }

//    @GetMapping("/students/name/{name}")
//    ResponseEntity<StudentDTO> getByName(@RequestParam("name")String name){
//        StudentDTO getName = studentService.getByTheName(name);
//        return ResponseEntity.ok(getName);
//    }

}
