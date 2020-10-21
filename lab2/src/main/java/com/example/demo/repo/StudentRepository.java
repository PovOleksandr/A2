package com.example.demo.repo;


import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    @Query("SELECT it FROM Student it WHERE it.dormNumber = :dormNumber")
    List<Student> findStudents(@Param("dormNumber") int dormNumber);
}
