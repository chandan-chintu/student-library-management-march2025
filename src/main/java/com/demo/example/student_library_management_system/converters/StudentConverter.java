package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {

    // converter - used to convert the requestdto class inputs into model class, later API saves it in database

    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setDept(studentRequestDto.getDept());
        student.setDob(studentRequestDto.getDob());
        student.setSem(studentRequestDto.getSem());
        student.setEmail(studentRequestDto.getEmail());
        student.setGender(studentRequestDto.getGender());
        student.setMobile(studentRequestDto.getMobile());
        student.setAddress(studentRequestDto.getAddress());
        student.setSection(studentRequestDto.getSection());

        return student;
    }
}
