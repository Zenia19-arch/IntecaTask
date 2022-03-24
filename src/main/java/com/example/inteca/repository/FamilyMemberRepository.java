package com.example.inteca.repository;

import com.example.inteca.domain.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {

}
