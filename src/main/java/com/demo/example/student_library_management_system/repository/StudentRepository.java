package com.demo.example.student_library_management_system.repository;

import com.demo.example.student_library_management_system.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // writing our own customized queries

    // 1. with JPA support - using fields or attributes
    public Student findByEmail(String email);

    public List<Student> findByDept(String dept, Pageable pageable);

    public List<Student> findByDeptAndSem(String dept, String sem);

    public List<Student> findByDeptOrSem(String dept, String sem);

    // 2. writing own sql queries
    @Query(nativeQuery = true, value = "select * from student where sem = :sem1")
    public List<Student> getStudentBySem(String sem1);

    @Query(nativeQuery = true, value = "select * from student where email = :email1")
    public Student getStudentByEmail(String email1);

}
