package com.studentapp.service;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDTO;
import com.studentapp.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService{

    private IStudentRepository studentRepository;
    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getById(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC,"name");
        return studentRepository.findAll(sort);
    }

    @Override
    public List<Student> getByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    @Override
    public List<Student> getByCity(String city) {
        Sort sort = Sort.by("name");
        return studentRepository.findByAddressCity(city,sort);
    }

    @Override
    public List<Student> getByState(String state) {
        return studentRepository.findByState(state);
    }

    @Override
    public List<Student> getByDeptAndCity(String dept, String city) {
        return studentRepository.findByDeptAndCity(dept, city);
    }

    @Override
    public List<Student> getByDepartmentAndAddressCity(String dept, String city) {
        return studentRepository.findByDepartmentAndAddressCity(dept, city);
    }

    @Override
    public StudentDTO getByStudentId(int studentId) {
        return studentRepository.getByStudentId(studentId);
    }

//    @Override
//    public StudentDTO getByTheName(String name) {
//        return studentRepository.getByTheName(name);
//    }
}
