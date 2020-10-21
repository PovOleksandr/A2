package com.example.demo.repo;

import com.example.demo.entities.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DormRepository extends JpaRepository<Dorm, UUID> {
}
