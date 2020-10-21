package com.example.demo.repo;

import com.example.demo.entities.Janitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JanitorRepository extends JpaRepository<Janitor, UUID> {
}
