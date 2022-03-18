package com.example.inteca.repository;

import com.example.inteca.domain.FamilyMember;
import org.springframework.data.repository.CrudRepository;


public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Long> {
}
