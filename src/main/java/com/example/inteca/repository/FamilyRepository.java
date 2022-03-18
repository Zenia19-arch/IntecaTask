package com.example.inteca.repository;

import com.example.inteca.domain.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {
}
