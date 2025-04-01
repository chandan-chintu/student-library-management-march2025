package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converters.StudentConverter;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){

        // first convert the studentrequestdto into student model class
        Student student = StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

        // whenever the student is added automatically card also gets added for student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setBloodGroup(studentRequestDto.getBloodGroup());
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);
        return "Student and card saved successfully";

    }

    public Student findStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        } else{
            return null;
        }
    }

    public List<Student>  getAllStudents(){
       List<Student> studentList= studentRepository.findAll();
       return studentList;
    }

    public String updateStudent(int id, StudentRequestDto studentRequestDto){
        // find student with id

        Student student = findStudentById(id);
        // if id is present then perform update
        if (student != null) {
            student.setSection(studentRequestDto.getSection());
            student.setAddress(studentRequestDto.getAddress());
            student.setMobile(studentRequestDto.getMobile());
            student.setEmail(studentRequestDto.getEmail());
            student.setSem(studentRequestDto.getSem());
            student.setDob(studentRequestDto.getDob());
            student.setGender(studentRequestDto.getGender());
            student.setName(studentRequestDto.getName());
            student.setDept(studentRequestDto.getDept());

            studentRepository.save(student);
            return "Student updated successfully";
        }
        // else cannot update
        else{
            return "Student not found, cannot update";
        }
    }

    public String deleteStudent(int id){
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}
