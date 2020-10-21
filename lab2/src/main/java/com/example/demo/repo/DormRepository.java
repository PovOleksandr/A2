package com.example.demo.repo;

import com.example.demo.entities.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.UUID;

public interface DormRepository extends JpaRepository<Dorm, UUID> {
    @Query("SELECT it FROM Dorm it WHERE it.dormNumber = :dormNumber")
    Dorm findDormByNumber(@Param("dormNumber") int dormNumber);
}
