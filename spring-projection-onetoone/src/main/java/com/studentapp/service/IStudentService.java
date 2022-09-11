package com.studentapp.service;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDTO;

import java.util.List;

public interface IStudentService {
    Student addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);

    Student getById(int studentId);
    List<Student> getAll();


    List<Student> getByDepartment(String department);
    List<Student> getByCity(String city);
    List<Student> getByState(String state);
    List<Student> getByDeptAndCity(String dept,String city);
    List<Student> getByDepartmentAndAddressCity(String dept,String city);

    StudentDTO getByStudentId(int studentId);
//    StudentDTO getByTheName(String name);

}
