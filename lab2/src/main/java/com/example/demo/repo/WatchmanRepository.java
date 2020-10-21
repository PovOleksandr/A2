package com.example.demo.repo;

import com.example.demo.entities.Watchman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WatchmanRepository extends JpaRepository<Watchman, UUID> {
}

