package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converters.StudentConverter;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
            throw new RuntimeException("Student with id : "+id +" not found");
        }
    }

    public List<Student>  getAllStudents(){
       List<Student> studentList= studentRepository.findAll();
       return studentList;
    }

    /*
    Pagination - fetching or getting the records or data in the form of pages
    pagenumber - the number of page we want to see(0,1,2,3,4,5,....)
    pagesize - total number of records in each page(fixed for all pages)

    total number of records - 28, page size - 5
    0th page - 1-5
    1st page - 6-10
    2nd page - 11-15
    3rd page - 16-20
    4th page - 21-25
    5th page - 26-28
    6th page - 0

    total number of records - 11, page size - 3
    0th page - 1-3
    1st page - 4-6
    2nd page - 7-9
    3rd page - 10-11

    sorting - arranging the record based on ascending or descending order

    only pagination
    public List<Student> getStudentByPage(int pageNo, int pageSize){
        List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize)).getContent();
        return studentList;
    }
     */

    public List<Student> getStudentByPage(int pageNo, int pageSize, String sortBy, String order){
        List<Student> studentList = null;
        if(order.equalsIgnoreCase("Ascending")){
            studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortBy).ascending())).getContent();
        } else{
            studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortBy).descending())).getContent();
        }
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
        Student student = findStudentById(id);
        if (student != null) {
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        }
        throw new RuntimeException("Student cannot be found with id : "+id+"  hence student not deleted");
    }

    public List<Student> getStudentByDept(String dept){
        List<Student> studentList = studentRepository.findByDept(dept, PageRequest.of(1,2));
        return studentList;
    }
}
