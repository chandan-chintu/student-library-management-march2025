package com.demo.example.student_library_management_system.controller;


import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import com.demo.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        try {
            String response = studentService.addStudent(studentRequestDto);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Some execption occured while save! ->"+e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id){
        try {
            Student student = studentService.findStudentById(id);
            return ResponseEntity.ok(student);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Some execption occured while find by id : "+id);
        }
    }

    @GetMapping("/findAll")
    public List<Student>  findAllStudent(){
        List<Student>  studentList = studentService.getAllStudents();
        return studentList;
    }

    @GetMapping("/findAllByPage")
    public List<Student>  findAllStudent(@RequestParam int pageNo,@RequestParam int pageSize, @RequestParam String sortBy, @RequestParam String order){
        List<Student>  studentList = studentService.getStudentByPage(pageNo,pageSize, sortBy, order);
        return studentList;
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.updateStudent(id,studentRequestDto);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        try {
            String response = studentService.deleteStudent(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Some execption occured while delete with id : "+id);
        }
    }

    @GetMapping("/findByDept")
    public List<Student> findStudentByDept(@RequestParam String dept){
        List<Student> studentList = studentService.getStudentByDept(dept);
        return studentList;
    }

}
